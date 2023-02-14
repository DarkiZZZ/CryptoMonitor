package ru.msokolov.cryptomonitorapp.presentation.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import ru.msokolov.cryptomonitorapp.R
import ru.msokolov.cryptomonitorapp.databinding.ItemCoinInfoBinding
import ru.msokolov.cryptomonitorapp.domain2.entity.CoinInfoEntity

class CoinInfoAdapter(private val context: Context) :
    ListAdapter<CoinInfoEntity, CoinInfoViewHolder>(CoinInfoDiffCallback) {

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder) {
            val formattedValues = getFormattedInfoFromCoin(coin)
            updateUi(binding, coin, formattedValues)
            loadImage(coin.imageUrl, binding)

            itemView.setOnClickListener {
                onCoinClickListener?.onCoinClick(coin)
            }

        }
    }

    private fun loadImage(imageUrl: String?, binding: ItemCoinInfoBinding) {
        Picasso.get().load(imageUrl).into(binding.ivLogoCoin)
    }

    private fun getStringFromRes(context: Context, resId: Int): String {
        return context.resources.getString(resId)
    }

    private fun updateUi(
        binding: ItemCoinInfoBinding,
        coin: CoinInfoEntity,
        formattedValues: HashMap<String, String>
    ) {
        binding.tvPrice.text = coin.price
        binding.tvSymbols.text = formattedValues[SYMBOLS_KEY]
        binding.tvLastUpdate.text = formattedValues[LAST_UPDATE_KEY]
    }

    private fun getFormattedInfoFromCoin(coin: CoinInfoEntity): HashMap<String, String> {
        val symbolsTemplate = getStringFromRes(context, R.string.symbols_template)
        val lastUpdateTemplate = getStringFromRes(context, R.string.last_update_template)

        val formattedSymbols = String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
        val formattedLastUpdate = String.format(lastUpdateTemplate, coin.lastUpdate)
        val formattedValues = hashMapOf<String, String>()
        formattedValues[SYMBOLS_KEY] = formattedSymbols
        formattedValues[LAST_UPDATE_KEY] = formattedLastUpdate

        return formattedValues
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinInfoEntity: CoinInfoEntity)
    }

    companion object {
        private const val SYMBOLS_KEY = "SYMBOLS"
        private const val LAST_UPDATE_KEY = "LAST_UPDATE"
    }
}