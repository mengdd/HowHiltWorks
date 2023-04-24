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
        return if (BuildConfig.testFlag) {
            MyDebugLogTool()
        } else {
            NoOpLogTool()
        }
    }
    // in release build, viewed by jadx-gui, NoOpLogTool is returned directly when using BuildConfig.DEBUG
    // this is done even when `minifyEnabled false` for release
    // See ./images/release-build-LogTool.png

    // but if we change to use another customised flag, the release build still checks the flag
    // See ./images/release-build-LogTool-using-test-flag.png
}
