package com.example.moviesapp.di.component

import android.app.Application

class MyApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}
