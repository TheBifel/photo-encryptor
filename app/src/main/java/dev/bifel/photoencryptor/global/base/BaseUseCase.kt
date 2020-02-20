package dev.bifel.photoencryptor.global.base

import android.content.Context
import dev.bifel.photoencryptor.model.repository.Repository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

abstract class BaseUseCase : KoinComponent {

    protected val context by inject<Context>()
    protected val repository by inject<Repository>()
}
