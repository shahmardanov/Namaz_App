package com.alijan.demo.ui.pray

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alijan.demo.data.model.Namaz
import com.example.namaz_app.data.repository.NamazRepository
import com.example.namaz_app.util.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrayViewModel @Inject constructor(private val repository: NamazRepository) : ViewModel() {

    private var _pray = MutableLiveData<List<Namaz>>()
    val pray: LiveData<List<Namaz>> get() = _pray

    private var _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun getPrayDate(city: String) {
        viewModelScope.launch {
            _loading.value = true
            when (val resp = repository.getPrayDate(city)) {
                is NetworkResponse.Error -> {
                    _loading.value = false
                    _error.value = resp.message.toString()
                }

                is NetworkResponse.Success -> {
                    _loading.value = false
                    _pray.value = resp.data!!
                }

                null -> {}
            }
        }
    }


}