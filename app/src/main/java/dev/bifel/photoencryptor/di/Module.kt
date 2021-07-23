package dev.bifel.photoencryptor.di

import dev.bifel.photoencryptor.model.repository.Repository
import dev.bifel.photoencryptor.model.repository.RepositoryImpl
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
    single { RepositoryImpl() as Repository }
}

val useCaseModule = module {
    single { PictureUseCase() }
    single { PickFileUseCase() }
}