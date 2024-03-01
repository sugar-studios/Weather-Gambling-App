package com.example.cupcake.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property to create a DataStore for the application context
val Context.dataStore by preferencesDataStore(name = "bet_preferences")

class PreferencesManager(private val context: Context) {
    companion object {
        private val SELECTED_BET = stringPreferencesKey("selected_bet")
    }

    val selectedBet: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SELECTED_BET] ?: ""
        }

    suspend fun setSelectedBet(bet: String) {
        context.dataStore.edit { preferences ->
            preferences[SELECTED_BET] = bet
        }
    }
}
