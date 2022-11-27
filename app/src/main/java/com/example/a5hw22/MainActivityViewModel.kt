package com.example.a5hw22

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: Repository): ViewModel() {



    fun getRequest(firstName: String, secondName: String):LiveData<CalculateModel>{
        return repository.getRequest(firstName, secondName)
    }
}