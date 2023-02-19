package ru.msokolov.cryptomonitorapp.presentation.list.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.msokolov.cryptomonitorapp.domain.entity.database.CoinInfoEntity

object CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinInfoEntity>() {

    override fun areItemsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem == newItem
    }
}