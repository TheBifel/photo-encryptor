package dev.bifel.photoencryptor.model.repository

import android.graphics.Bitmap

/**
 * Date: 20.02.2020
 * Time: 21:48
 *
 * @author Bohdan Ishchenko
 */
interface Repository {

    suspend fun getNoisedBitmap(
        source: Bitmap,
        noiseSeed: String,
        progressListener: suspend (Int) -> Unit
    ): Bitmap
}