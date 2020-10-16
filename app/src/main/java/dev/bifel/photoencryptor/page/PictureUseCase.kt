package dev.bifel.photoencryptor.page

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import dev.bifel.photoencryptor.global.base.BaseUseCase
import dev.bifel.photoencryptor.global.extentions.getInputStream

/**
 * Date: 20.02.2020
 * Time: 21:55
 *
 * @author Bohdan Ishchenko
 */
class PictureUseCase : BaseUseCase() {

    suspend fun getEncrypted(
        noiseSeed: String,
        progressListener: suspend (Int) -> Unit = {}
    ): Bitmap? {
        val stream = context.getInputStream("cat.png")

        return repository.getNoisedBitmap(
            BitmapFactory.decodeStream(stream),
            noiseSeed,
            progressListener
        )
    }
}