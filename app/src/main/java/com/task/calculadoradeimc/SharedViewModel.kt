package com.task.calculadoradeimc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _dataInformation = MutableLiveData<Data_Informations>()
    val dataInformations : LiveData<Data_Informations>  get() = _dataInformation

    fun setDataInformations(data: Data_Informations) {
        _dataInformation.value = data
    }

}