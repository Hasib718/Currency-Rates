package com.hasib.currencyrates.ui.currencyrates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hasib.currencyrates.databinding.FragmentCurrencyRatesBinding
import com.hasib.currencyrates.helper.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CurrencyRatesFragment : Fragment() {

    private lateinit var binding: FragmentCurrencyRatesBinding
    private val viewModel: CurrencyRatesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyRatesBinding.inflate(layoutInflater, container, false)

        viewModel.countries.observe(viewLifecycleOwner) {
            if (it is Resource.Success) Timber.d(it.data.toString())
        }

        return binding.root
    }
}