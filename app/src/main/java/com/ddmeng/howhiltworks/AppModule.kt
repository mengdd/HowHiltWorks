package com.ddmeng.howhiltworks

import com.ddmeng.howhiltworks.data.CacheManager
import com.ddmeng.howhiltworks.data.LocalCache
import com.ddmeng.howhiltworks.data.MemoryCache
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

    @Provides
    fun provideCacheManagers(localCache: LocalCache, memoryCache: MemoryCache): List<CacheManager> {
        return listOf(localCache, memoryCache)
    }
}
