package dev.bifel.photoencryptor

import android.app.Application
import dev.bifel.photoencryptor.di.repositoryModule
import dev.bifel.photoencryptor.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Date: 12.02.2020
 * Time: 23:03
 *
 * @author Bohdan Ishchenko
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repositoryModule, useCaseModule))
        }
    }
}