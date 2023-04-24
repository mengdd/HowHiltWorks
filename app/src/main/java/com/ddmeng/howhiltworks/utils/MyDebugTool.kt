package com.ddmeng.howhiltworks.utils

import android.util.Log
import com.ddmeng.howhiltworks.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

interface LogTool {
    fun print(string: String)
}

class MyDebugLogTool : LogTool {
    override fun print(string: String) {
        Log.i("debug", "log $string")
    }
}

class NoOpLogTool : LogTool {
    override fun print(string: String) {
    }
}

@Module
@InstallIn(SingletonComponent::class)
object MyLogToolModule {

    @Provides
    fun provideLogTool(): LogTool {
        return if (BuildConfig.DEBUG) {
            MyDebugLogTool()
        } else {
            NoOpLogTool()
        }
    }
    // in release build, viewed by jadx-gui, NoOpLogTool is returned directly
    // this is done even when `minifyEnabled false` for release
}
