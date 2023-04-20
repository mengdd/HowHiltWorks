package com.ddmeng.howhiltworks.qualifier

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject
import javax.inject.Qualifier

interface DataSource {
    fun someMethod()
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteSource

class LocalDataSource @Inject constructor() : DataSource {
    override fun someMethod() {}
}

class RemoteDataSource @Inject constructor() : DataSource {
    override fun someMethod() {}
}

@Module
@InstallIn(ActivityComponent::class)
abstract class DataModule {

    @LocalSource
    @Binds
    abstract fun bindLocalDataSource(localDataSource: LocalDataSource): DataSource

    @RemoteSource
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: RemoteDataSource): DataSource
}
