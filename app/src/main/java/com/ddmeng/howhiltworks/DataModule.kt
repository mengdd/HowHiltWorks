package com.ddmeng.howhiltworks

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

interface DataSource {
    fun someMethod()
}

class DataSourceImpl @Inject constructor(
) : DataSource {
    override fun someMethod() {
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindDataSource(
        dataSourceImpl: DataSourceImpl
    ): DataSource
}
