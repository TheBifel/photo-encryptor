package dev.bifel.photoencryptor.model.repository

import android.graphics.Bitmap
import org.koin.core.KoinComponent
import java.nio.ByteBuffer
import kotlin.experimental.xor
import kotlin.random.Random

class RepositoryImpl : Repository, KoinComponent {

    private suspend fun xorWithNoise(
        bytes: ByteArray,
        password: String,
        progressListener: suspend (Int) -> Unit
    ) {
        val random = Random(password.hashCode())
        var progress = 0
        repeat(bytes.size) {
            bytes[it] = bytes[it] xor random.nextBits(8).toByte()
            val newProgress = ((it.toDouble() / bytes.size) * 100).toInt()
            if (progress != newProgress) {
                progress = newProgress
                progressListener(progress)
            }
        }
    }

    override suspend fun getNoisedBitmap(
        source: Bitmap,
        noiseSeed: String,
        progressListener: suspend (Int) -> Unit
    ): Bitmap {
        val bitmapSize = source.rowBytes * source.height
        val byteBuffer = ByteBuffer.allocate(bitmapSize)
        source.copyPixelsToBuffer(byteBuffer)
        val bytes = byteBuffer.array()
        xorWithNoise(bytes, noiseSeed, progressListener)
        val buffer = ByteBuffer.wrap(bytes)

        val result = Bitmap.createBitmap(source.width, source.height, source.config)
        result.copyPixelsFromBuffer(buffer)
        return result;
    }
}