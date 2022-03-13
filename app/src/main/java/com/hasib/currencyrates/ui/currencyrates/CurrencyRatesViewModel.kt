package com.hasib.currencyrates.ui.currencyrates

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hasib.currencyrates.data.repo.CountryRepository
import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.model.CountryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyRatesViewModel @Inject constructor(
    private val repository: CountryRepository
) : ViewModel() {

    val countries: LiveData<Resource<List<CountryItem>>> =
        repository.loadAllCountries().asLiveData()
}