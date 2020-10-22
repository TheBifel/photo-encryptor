package dev.bifel.photoencryptor.di

import dev.bifel.photoencryptor.model.repository.RepositoryImpl
import dev.bifel.photoencryptor.page.PictureUseCase
import org.koin.dsl.module.applicationContext

/**
 * Date: 20.02.2020
 * Time: 21:51
 *
 * @author Bohdan Ishchenko
 */

val repositoryModule = applicationContext {
    bean { RepositoryImpl() }
}

val useCaseModule = applicationContext {
    bean { PictureUseCase() }
}