package com.hasib.currencyrates.ui.currencyrates

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hasib.currencyrates.R
import com.hasib.currencyrates.databinding.FragmentCurrencyRatesBinding
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

        viewModel.loadCharacter()
        viewModel.countries.observe(viewLifecycleOwner) {
            Timber.d(it.toString())
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = CurrencyRatesFragment()
    }
}