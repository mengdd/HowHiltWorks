package com.ddmeng.howhiltworks

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

interface Tool {
    fun someMethod()
}

class ToolImpl @Inject constructor(
) : Tool {
    override fun someMethod() {
    }
}

@Module
@InstallIn(ActivityComponent::class)
object ToolModule {

    @Provides
    fun provideTool(): Tool {
        return ToolImpl()
    }
}
