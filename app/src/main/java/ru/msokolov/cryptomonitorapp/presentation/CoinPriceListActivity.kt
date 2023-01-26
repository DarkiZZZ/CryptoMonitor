package ru.msokolov.cryptomonitorapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_coin_price_list.*
import ru.msokolov.cryptomonitorapp.R
import ru.msokolov.cryptomonitorapp.presentation.adapters.CoinInfoAdapter
import ru.msokolov.cryptomonitorapp.data.models.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {

    private val viewModelFactory by lazy {
        CoinViewModelFactory(application)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }
        rvCoinPriceList.adapter = adapter
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })
    }
}
