package com.ddmeng.howhiltworks

import android.util.Log
import javax.inject.Inject

class AnalyticsService @Inject constructor() {

    init {
        Log.i("Dependency", "AnalyticsService ${this.hashCode()}")
    }
}
