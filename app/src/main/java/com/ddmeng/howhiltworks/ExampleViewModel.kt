package com.ddmeng.howhiltworks

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ddmeng.howhiltworks.qualifier.PreferencesRepository
import com.ddmeng.howhiltworks.utils.LogTool
import com.ddmeng.howhiltworks.utils.MyTool
import com.ddmeng.mylibrary.BuildInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ExampleRepository,
    private val buildInformation: BuildInformation,
    private val myTool: MyTool,
    private val preferencesRepository: PreferencesRepository,
    private val logTool: LogTool,
) : ViewModel() {
    init {
        Log.i("ExampleViewModel", "build information: $buildInformation")
        Log.i("ExampleViewModel", "repository $repository")
        myTool.printInformation()
        logTool.print("printing using log tool")
    }

    fun print() {
        Log.i("ExampleViewModel", "print")
    }
}
