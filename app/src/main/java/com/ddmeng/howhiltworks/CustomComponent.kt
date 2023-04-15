package com.ddmeng.howhiltworks

import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton

@EntryPoint
@InstallIn(CustomComponent::class)
interface CustomEntryPoint {
    @Flow1
    fun factory1(): Factory1
    @Flow1
    fun factory2(): Factory2
}

@VIPScope
@DefineComponent(parent = SingletonComponent::class)
interface CustomComponent {
    @DefineComponent.Builder
    interface Builder {
        fun sharedDependency(@BindsInstance share: Shared): Builder
        fun build(): CustomComponent
    }
}

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class VIPScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ForFeature1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ForFeature2

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Flow1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Flow2

sealed class Shared
data class Config1(val test: String): Shared()
data class Config2(val test: Int): Shared()


@Module
@InstallIn(SingletonComponent::class)
class SingleModule {
    @[Provides ForFeature1]
    fun provideVIPFlow(): Flow<String> = flowOf("Test")

    @[Provides ForFeature2]
    fun provideLowFlow(): Flow<String> = flowOf("Hehe")

    @[Provides Flow1]
    fun provideConfig1(): Shared = Config1("test")

    @[Provides Flow2]
    fun provideConfig2(): Shared = Config2(123)

    @[Provides Singleton Flow2]
    fun provideNormalFactory1(@Flow2 shared: Shared) = Factory1(shared as Config2)

    @[Provides Singleton Flow2]
    fun provideNormalFactory2(@ForFeature2 flow: Flow<String>) = Factory2(flow)
}

@InstallIn(CustomComponent::class)
@Module
class CustomModule {
    @[VIPScope Provides Flow1]
    fun provideFactory1(@Flow1 shared: Shared) = Factory1(shared)

    @[VIPScope Provides Flow1]
    fun provideFactory2(@ForFeature1 flow: Flow<String>) = Factory2(flow)
}


data class Factory1(val shared: Shared)

data class Factory2(val flow: Flow<String>)