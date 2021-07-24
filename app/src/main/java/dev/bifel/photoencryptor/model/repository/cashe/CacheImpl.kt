package dev.bifel.photoencryptor.model.repository.cashe

import java.io.File

/**
 * Date: 24.07.2021
 * Time: 3:10
 *
 * @author Bohdan Ishchenko
 */
class CacheImpl : Cache {
    override lateinit var zip: File
}