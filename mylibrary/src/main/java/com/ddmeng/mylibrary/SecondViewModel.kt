package com.ddmeng.mylibrary

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val buildInformation:  BuildInformation
) : ViewModel() {
    init {
        Log.i("SecondViewModel", "build information: $buildInformation")
    }

    fun print() {
        Log.i("SecondViewModel", "print")
    }
}
