package ru.msokolov.cryptomonitorapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import ru.msokolov.cryptomonitorapp.databinding.FragmentCoinDetailBinding
import ru.msokolov.cryptomonitorapp.domain.CoinInfoEntity
import ru.msokolov.cryptomonitorapp.presentation.CoinViewModel
import ru.msokolov.cryptomonitorapp.presentation.CoinViewModelFactory

class CoinDetailFragment : Fragment() {

    private val viewModelFactory by lazy {
        CoinViewModelFactory(requireActivity().application)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
    }

    private val args by navArgs<CoinDetailFragmentArgs>()

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is NULL")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun observeViewModel(){
        viewModel.getDetailInfo(getArgFromOtherFragment()).observe(viewLifecycleOwner) {
            updateUi(it)
        }
    }

    private fun updateUi(coinInfo: CoinInfoEntity){
        with(binding) {
            tvPrice.text = coinInfo.price
            tvMinPrice.text = coinInfo.lowDay
            tvMaxPrice.text = coinInfo.highDay
            tvLastMarket.text = coinInfo.lastMarket
            tvLastUpdate.text = coinInfo.lastUpdate
            tvFromSymbol.text = coinInfo.fromSymbol
            tvToSymbol.text = coinInfo.toSymbol
            loadImage(coinInfo.imageUrl)
        }
    }

    private fun loadImage(imageUrl: String?){
        Picasso.get().load(imageUrl).into(binding.ivLogoCoin)
    }

    private fun getArgFromOtherFragment() = args.fromSymbol
}
