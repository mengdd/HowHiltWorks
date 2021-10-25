package com.ddmeng.howhiltworks.data

import android.util.Log
import javax.inject.Inject

class LocalCache @Inject constructor(): CacheManager {
    override fun clear() {
        Log.i("local cache", "clear")
    }
}
