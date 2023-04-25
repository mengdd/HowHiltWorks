package com.ddmeng.howhiltworks.dynamic

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

interface MyDynamicTool {
    fun foo()
}

class MyHeavyTool : MyDynamicTool {
    init {
        Log.i("dynamic tool", "heavy tool initialized, we should only do it when necessary")
    }

    override fun foo() {
        Log.i("dynamic tool", "use heavy tool")
    }
}

class MyLightTool : MyDynamicTool {
    init {
        Log.i("dynamic tool", "light tool initialized")
    }

    override fun foo() {
        Log.i("dynamic tool", "use light tool")
    }
}


@Module
@InstallIn(SingletonComponent::class)
object MyDynamicSampleModule {

    @Provides
    fun provideMyDynamicTool(myHeavyTool: MyHeavyTool, myLightTool: MyLightTool): MyDynamicTool {
        return if (someCondition()) {
            myHeavyTool
        } else {
            myLightTool
        }
    }

    @Provides
    fun provideMyHeavyTool(): MyHeavyTool {
        return MyHeavyTool()
    }

    @Provides
    fun provideMyLightTool(): MyLightTool {
        return MyLightTool()
    }

    private fun someCondition(): Boolean {
        return false
    }
}
