package dev.bifel.photoencryptor.page.enterpassword

import dev.bifel.photoencryptor.R
import dev.bifel.photoencryptor.global.base.BaseUseCase
import dev.bifel.photoencryptor.model.tools.Zipper
import org.koin.core.KoinComponent

/**
 * Date: 24.07.2021
 * Time: 0:05
 *
 * @author Bohdan Ishchenko
 */
class PasswordUseCase : BaseUseCase(), KoinComponent {
    suspend fun isZipAccessible(password: String?) =
        Zipper.isAccessible(cache.zip, password)

    fun getErrorText(): String = context.getString(R.string.error_password)

}