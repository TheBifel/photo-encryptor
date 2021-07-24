@file:Suppress("USELESS_CAST")

package dev.bifel.photoencryptor.di

import dev.bifel.photoencryptor.model.repository.cashe.Cache
import dev.bifel.photoencryptor.model.repository.cashe.CacheImpl
import dev.bifel.photoencryptor.model.repository.sequrity.Security
import dev.bifel.photoencryptor.model.repository.sequrity.SecurityImpl
import dev.bifel.photoencryptor.page.enterpassword.PasswordUseCase
import dev.bifel.photoencryptor.page.pickfile.PickFileUseCase
import dev.bifel.photoencryptor.page.picture.PictureUseCase
import org.koin.dsl.module

/**
 * Date: 20.02.2020
 * Time: 21:51
 *
 * @author Bohdan Ishchenko
 */

val repositoryModule = module {
    single { SecurityImpl() as Security }
    single { CacheImpl() as Cache }
}

val useCaseModule = module {
    single { PictureUseCase() }
    single { PickFileUseCase() }
    single { PasswordUseCase() }
}