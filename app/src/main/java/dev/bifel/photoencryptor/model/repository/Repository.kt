package dev.bifel.photoencryptor.model.repository

/**
 * Date: 20.02.2020
 * Time: 21:48
 *
 * @author Bohdan Ishchenko
 */
interface Repository {

    suspend fun xorWithNoise(bytes: ByteArray, password: String, progress: (Int) -> Unit)
}