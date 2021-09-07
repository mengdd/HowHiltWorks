package com.ddmeng.howhiltworks

import com.ddmeng.mylibrary.BuildInformation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBuildInformation(): BuildInformation {
        return BuildInformation(versionName = BuildConfig.VERSION_NAME)
    }
}
