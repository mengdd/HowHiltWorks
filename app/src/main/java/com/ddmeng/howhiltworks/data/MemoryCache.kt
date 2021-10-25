package com.ddmeng.howhiltworks.data

import android.util.Log
import javax.inject.Inject

class MemoryCache @Inject constructor() : CacheManager {
    override fun clear() {
        Log.i("memory cache", "clear")
    }
}
