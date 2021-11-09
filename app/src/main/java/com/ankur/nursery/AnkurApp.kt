package com.ankur.nursery

import android.app.Application
import com.facebook.soloader.SoLoader

class AnkurApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
    }
}