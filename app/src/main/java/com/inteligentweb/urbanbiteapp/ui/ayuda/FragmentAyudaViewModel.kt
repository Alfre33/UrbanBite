package com.inteligentweb.urbanbiteapp.ui.ayuda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentAyudaViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Ayuda Fragment"
    }
    val text: LiveData<String> = _text
}