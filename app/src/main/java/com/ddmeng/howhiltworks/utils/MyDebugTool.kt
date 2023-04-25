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

const val constBooleanFlag = true
@Module
@InstallIn(SingletonComponent::class)
object MyLogToolModule {

    @Provides
    fun provideLogTool(): LogTool {
        return if (constBooleanFlag) {
            MyDebugLogTool()
        } else {
            NoOpLogTool()
        }
    }
    // in release build, viewed by jadx-gui, NoOpLogTool is returned directly when using BuildConfig.DEBUG
    // this is done even when `minifyEnabled false` for release, debug build did the same way

    // but if we change to use another customised flag, the build still checks the flag
    // tried const val flag, same behavior as BuildConfig.DEBUG

}
