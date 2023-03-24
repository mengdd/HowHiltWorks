package com.ddmeng.howhiltworks.utils

import android.util.Log
import javax.inject.Inject

// Q: if both @Inject constructor and @Provides method are written, who will be use?
// A: @Provides method. as the info will be printed contains: from provides method
class MyTool @Inject constructor(
    private val secondTool: MySecondTool
) {
    var info: String = "field"

    fun printInformation() {
        Log.i("MyTool", "my tool with info $info and hash: ${hashCode()}")
    }
}