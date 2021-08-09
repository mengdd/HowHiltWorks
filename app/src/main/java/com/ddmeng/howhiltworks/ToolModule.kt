package com.ddmeng.howhiltworks

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

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

    @ActivityScoped
    @Provides
    fun provideTool(): Tool {
        return ToolImpl()
    }
}
