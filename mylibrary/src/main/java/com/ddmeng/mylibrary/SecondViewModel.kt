package com.ddmeng.mylibrary

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SecondViewModel @AssistedInject constructor(
    private val buildInformation: BuildInformation,
    @Assisted private val noteId: String
) : ViewModel() {
    init {
        Log.i("SecondViewModel", "build information: $buildInformation")
        Log.i("SecondViewModel", "note id: $noteId")
    }

    fun print() {
        Log.i("SecondViewModel", "print")
    }

    @AssistedFactory
    interface Factory {
        fun create(noteId: String): SecondViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            noteId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(noteId) as T
            }
        }
    }
}
