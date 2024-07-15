package com.example.kotlindemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codilitytest.model.DataModel
import com.example.codilitytest.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val _detailData = MutableLiveData<List<DataModel>>()
    val detailData: LiveData<List<DataModel>>
        get() = _detailData

    fun fetchDetailData() {
        viewModelScope.launch {
            try {
                _detailData.value = repository.fetchDetailData()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}