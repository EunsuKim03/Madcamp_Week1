package com.example.madcamp_week1.ui.reservation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is likes Fragment"
    }
    val text: LiveData<String> = _text
}