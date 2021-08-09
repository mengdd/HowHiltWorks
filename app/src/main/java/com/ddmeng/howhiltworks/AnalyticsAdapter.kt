package com.ddmeng.howhiltworks

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsAdapter @Inject constructor(
    private val service: AnalyticsService
)
