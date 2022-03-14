package com.hasib.currencyrates.ui.currencyrates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasib.currencyrates.databinding.FragmentCurrencyRatesBinding
import com.hasib.currencyrates.helper.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyRatesFragment : Fragment() {

    private lateinit var binding: FragmentCurrencyRatesBinding
    private val viewModel: CurrencyRatesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyRatesBinding.inflate(layoutInflater, container, false).apply {
            val countryItemAdapter = CountryItemAdapter()
            currencyInfo.apply {
                adapter = countryItemAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.countriesLatestCurrencyRate.observe(viewLifecycleOwner) {
                if (it is Resource.Success && !it.data.isNullOrEmpty()) countryItemAdapter.submitList(
                    it.data
                )

                progressBar.isVisible = it is Resource.Loading && it.data.isNullOrEmpty()
                errorText.isVisible = it is Resource.Error && it.data.isNullOrEmpty()
                errorText.text = it.error?.localizedMessage
            }
        }

        return binding.root
    }
}