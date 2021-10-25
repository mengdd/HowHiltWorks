package com.ddmeng.howhiltworks

import android.util.Log
import com.ddmeng.howhiltworks.data.CacheManager
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val cacheManagers: List<@JvmSuppressWildcards CacheManager>
) {
    init {
        cacheManagers.forEach {
            Log.i("cache", "${it.javaClass}")
        }
    }
}
