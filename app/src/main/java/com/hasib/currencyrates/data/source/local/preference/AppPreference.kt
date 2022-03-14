package com.hasib.currencyrates.data.source.local.preference

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.hasib.currencyrates.data.AppConstant
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


private val Context.datastore by preferencesDataStore(PreferenceConstant.PREFERENCE_NAME)

@ViewModelScoped
class AppPreference @Inject constructor(@ApplicationContext context: Context) {

    private val appDatastore = context.datastore

    private object PreferenceKeys {
        val CURRENCY_RATES_FETCHING_TIME =
            stringPreferencesKey(PreferenceConstant.KEY_FETCHING_CURRENCY_RATES_TIME)
    }

    val currencyRatesFetchingTimeFlow: Flow<Long> = appDatastore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[PreferenceKeys.CURRENCY_RATES_FETCHING_TIME]?.toLong()
                ?: System.currentTimeMillis() + AppConstant.CURRENCY_RATES_FETCHING_TIME_PERIOD
        }

    suspend fun storeCurrencyRatesFetchingTime(time: Long) {
        appDatastore.edit { preference ->
            preference[PreferenceKeys.CURRENCY_RATES_FETCHING_TIME] = time.toString()
        }
    }
}