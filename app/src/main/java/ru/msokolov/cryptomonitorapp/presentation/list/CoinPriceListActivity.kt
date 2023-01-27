package ru.msokolov.cryptomonitorapp.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.msokolov.cryptomonitorapp.databinding.ActivityCoinPriceListBinding
import ru.msokolov.cryptomonitorapp.domain.CoinInfoEntity
import ru.msokolov.cryptomonitorapp.presentation.detail.CoinDetailActivity
import ru.msokolov.cryptomonitorapp.presentation.CoinViewModel
import ru.msokolov.cryptomonitorapp.presentation.CoinViewModelFactory
import ru.msokolov.cryptomonitorapp.presentation.list.adapter.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {

    private val viewModelFactory by lazy {
        CoinViewModelFactory(application)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
    }
    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinInfoEntity: CoinInfoEntity) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinInfoEntity.fromSymbol
                )
                startActivity(intent)
            }
        }
        binding.apply {
            rvCoinPriceList.adapter = adapter
            rvCoinPriceList.itemAnimator = null
        }
        viewModel.coinInfoList.observe(this){
            adapter.submitList(it)
        }
    }
}
