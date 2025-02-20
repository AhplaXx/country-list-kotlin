package com.example.ulkeliste.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.ulkeliste.model.CountryModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.ulkeliste.CountryApplication
import com.example.ulkeliste.data.CountryRepository
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface CountryUiState {
    data class Success(val countries : List<CountryModel>) : CountryUiState
    object Error : CountryUiState
    object Loading : CountryUiState
}

class CountryViewModel(private val countryRepository: CountryRepository) : ViewModel() {
    var countryUiState : CountryUiState by mutableStateOf(CountryUiState.Loading)
        private set


    init {
        getCountries()

    }



    fun getCountries(){
        viewModelScope.launch {
            countryUiState = CountryUiState.Loading
            countryUiState = try {
                CountryUiState.Success(
                    countryRepository.getCountries()
                )
            }catch (e:IOException){
                CountryUiState.Error
            }catch (e:HttpException){
                print(e)
                CountryUiState.Error

            }catch(e:IllegalArgumentException){
                e.printStackTrace()
                Log.e("CountryViewModel", "IllegalArgumentException $e")
                CountryUiState.Error
            }
        }
    }


    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CountryApplication)
                val countryRepository = application.container.countryRepository
                CountryViewModel(countryRepository = countryRepository)

            }
        }
    }


}