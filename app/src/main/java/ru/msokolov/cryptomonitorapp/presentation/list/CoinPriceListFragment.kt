package ru.msokolov.cryptomonitorapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.msokolov.cryptomonitorapp.databinding.FragmentCoinPriceListBinding
import ru.msokolov.cryptomonitorapp.domain.CoinInfoEntity
import ru.msokolov.cryptomonitorapp.presentation.CoinViewModel
import ru.msokolov.cryptomonitorapp.presentation.CoinViewModelFactory
import ru.msokolov.cryptomonitorapp.presentation.list.adapter.CoinInfoAdapter

class CoinPriceListFragment : Fragment() {

    private val viewModelFactory by lazy {
        CoinViewModelFactory(requireActivity().application)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
    }
    private var _binding: FragmentCoinPriceListBinding? = null
    private val binding: FragmentCoinPriceListBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinPriceListBinding is NULL")

    private lateinit var coinAdapter: CoinInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinPriceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        observeViewModel()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun setupAdapter() {
        coinAdapter = CoinInfoAdapter(requireContext())
        coinAdapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinInfoEntity: CoinInfoEntity) {
                navigateToCoinDetailFragment(coinInfoEntity.fromSymbol)
            }
        }
        applyRecyclerViewParams()
    }

    private fun applyRecyclerViewParams() {
        binding.apply {
            rvCoinPriceList.adapter = coinAdapter
            rvCoinPriceList.itemAnimator = null
        }
    }

    private fun observeViewModel() {
        viewModel.coinInfoList.observe(viewLifecycleOwner) {
            coinAdapter.submitList(it)
        }
    }

    private fun navigateToCoinDetailFragment(fromSymbol: String) {
        findNavController().navigate(
            CoinPriceListFragmentDirections
                .actionCoinPriceListFragmentToCoinDetailFragment(
                    fromSymbol
                )
        )
    }
}
