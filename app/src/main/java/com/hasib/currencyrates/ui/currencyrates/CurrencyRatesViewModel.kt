package com.hasib.currencyrates.ui.currencyrates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasib.currencyrates.data.repo.CountryRepository
import com.hasib.currencyrates.model.CountryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyRatesViewModel @Inject constructor(
    private val repository: CountryRepository
) : ViewModel() {

    private val _countries = MutableLiveData<List<CountryResponse>>()
    val countries: LiveData<List<CountryResponse>> = _countries

    fun loadCharacter() {
        viewModelScope.launch {
            val result = repository.loadAllCountries()
            _countries.postValue(result.data!!)
        }
    }
}