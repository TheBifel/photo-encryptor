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

    suspend fun getEncrypted(password: String, progress: (Int) -> Unit): ByteArray {
        val stream = context.getInputStream("cat.jpg")
        val bytes = stream.readBytes()
        repository.xorWithNoise(bytes, password, progress)
        return bytes
    }

    suspend fun getDecrypted(
        password: String,
        bytes: ByteArray,
        progress: (Int) -> Unit
    ): Bitmap {
        repository.xorWithNoise(bytes, password, progress)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}