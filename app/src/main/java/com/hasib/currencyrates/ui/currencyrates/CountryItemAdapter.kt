package com.hasib.currencyrates.ui.currencyrates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hasib.currencyrates.databinding.ItemCountryItemBinding
import com.hasib.currencyrates.helper.extensions.roundOffDecimal
import com.hasib.currencyrates.model.CountryItem

class CountryItemAdapter :
    ListAdapter<CountryItem, CountryItemAdapter.CountryItemViewHolder>(CountryItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemViewHolder {
        val binding =
            ItemCountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CountryItemViewHolder(
        private val binding: ItemCountryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CountryItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(item.flagUrl)
                    .circleCrop()
                    .into(countryFlag)

                currencyName.text = item.fullName
                countryName.text = item.commonName
                currencyRate.text = item.rate.roundOffDecimal().toString()
            }
        }
    }

    class CountryItemDiffUtil : DiffUtil.ItemCallback<CountryItem>() {

        override fun areItemsTheSame(oldItem: CountryItem, newItem: CountryItem): Boolean {
            return oldItem.commonName == newItem.commonName
        }

        override fun areContentsTheSame(oldItem: CountryItem, newItem: CountryItem): Boolean {
            return oldItem == newItem
        }
    }
}