package dev.bifel.photoencryptor.global.base

import android.content.Context
import dev.bifel.photoencryptor.model.repository.cashe.Cache
import dev.bifel.photoencryptor.model.repository.sequrity.Security
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseUseCase : KoinComponent {

    protected val context by inject<Context>()
    protected val security by inject<Security>()
    protected val cache by inject<Cache>()
}
