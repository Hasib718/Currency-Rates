package com.hasib.currencyrates.ui.currencyrates

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hasib.currencyrates.BuildConfig
import com.hasib.currencyrates.data.repo.country.CountryRepository
import com.hasib.currencyrates.data.repo.currency.CurrencyRepository
import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.model.CountryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyRatesViewModel @Inject constructor(
    private val countryRepository: CountryRepository,
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    val countriesLatestCurrencyRate: LiveData<Resource<List<CountryItem>>> =
        currencyRepository.loadLatestCurrencyRates(BuildConfig.CURRENCY_APP_ID).asLiveData()


    init {
        viewModelScope.launch {
            countryRepository.loadAllCountries("${BuildConfig.BASE_URL_COUNTRY}all")
        }
    }
}