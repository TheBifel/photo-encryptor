package dev.bifel.photoencryptor.model.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.experimental.xor
import kotlin.random.Random

class RepositoryImpl : Repository {

    override suspend fun xorWithNoise(bytes: ByteArray, password: String, progress: (Int) -> Unit) {
        val random = Random(password.hashCode())

        repeat(bytes.size) {
            bytes[it] = bytes[it] xor random.nextBits(8).toByte()
            withContext(Dispatchers.Main) { progress(it) }
        }
    }
}