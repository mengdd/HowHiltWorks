package com.ddmeng.howhiltworks.entrypoint

import com.ddmeng.howhiltworks.AnalyticsService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface MyEntryPoint {
    fun analyticsService(): AnalyticsService
}
