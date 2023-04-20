package com.ddmeng.howhiltworks.qualifier

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

interface Preferences {
    fun save(key: String, value: String)
}

//@Qualifier
//@Retention(AnnotationRetention.BINARY)
//annotation class DefaultPreferences

// we could omit the default annotation, so the one without annotation will be used.

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SpecialPreferences

class DefaultPreferencesForMe @Inject constructor() : Preferences {
    override fun save(key: String, value: String) {
        Log.i("preferences", "saved in default: $key=$value")
    }
}

class SpecialPreferencesForMe @Inject constructor() : Preferences {
    override fun save(key: String, value: String) {
        Log.i("preferences", "saved in special: $key=$value")
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {

    //    @DefaultPreferences
    @Binds
    abstract fun bindLocalDataSource(defaultPreferences: DefaultPreferencesForMe): Preferences

    @SpecialPreferences
    @Binds
    abstract fun bindRemoteDataSource(specialPreferencesForMe: SpecialPreferencesForMe): Preferences
}
