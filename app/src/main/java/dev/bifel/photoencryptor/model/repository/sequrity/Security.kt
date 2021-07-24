package dev.bifel.photoencryptor.model.repository.sequrity

import android.graphics.Bitmap
import org.koin.core.KoinComponent

/**
 * Date: 20.02.2020
 * Time: 21:48
 *
 * @author Bohdan Ishchenko
 */
interface Security : KoinComponent {

    suspend fun getNoisedBitmap(
        source: Bitmap,
        noiseSeed: String,
        progressListener: suspend (Int) -> Unit
    ): Bitmap
}