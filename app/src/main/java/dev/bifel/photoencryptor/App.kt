package dev.bifel.photoencryptor

import android.app.Application
import dev.bifel.photoencryptor.di.repositoryModule
import dev.bifel.photoencryptor.di.useCaseModule
import org.koin.android.ext.android.startKoin

/**
 * Date: 12.02.2020
 * Time: 23:03
 *
 * @author Bohdan Ishchenko
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(repositoryModule, useCaseModule))
    }
}