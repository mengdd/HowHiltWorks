package com.ddmeng.howhiltworks

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ddmeng.mylibrary.BuildInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ExampleRepository,
    private val buildInformation: BuildInformation
) : ViewModel() {
    init {
        Log.i("ExampleViewModel", "build information: $buildInformation")
    }

    fun print() {
        Log.i("ExampleViewModel", "print")
    }
}
