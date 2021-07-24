package dev.bifel.photoencryptor.page.picture

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import dev.bifel.photoencryptor.global.base.BaseUseCase
import dev.bifel.photoencryptor.global.extentions.getInputStream
import org.koin.core.KoinComponent

/**
 * Date: 20.02.2020
 * Time: 21:55
 *
 * @author Bohdan Ishchenko
 */
class PictureUseCase : BaseUseCase(), KoinComponent {

    suspend fun getEncrypted(
        noiseSeed: String,
        progressListener: suspend (Int) -> Unit = {}
    ): Bitmap {
        val stream = context.getInputStream("cat.png")

        return security.getNoisedBitmap(
            BitmapFactory.decodeStream(stream),
            noiseSeed,
            progressListener
        )
    }
}