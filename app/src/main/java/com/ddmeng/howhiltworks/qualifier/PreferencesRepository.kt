package com.ddmeng.howhiltworks.qualifier

import javax.inject.Inject

class PreferencesRepository @Inject constructor(
    private val preferences: Preferences,
    @SpecialPreferences private val specialPreferences: Preferences,
) {
    init {
        preferences.save("key", "value")
        specialPreferences.save("key", "value")
    }
}