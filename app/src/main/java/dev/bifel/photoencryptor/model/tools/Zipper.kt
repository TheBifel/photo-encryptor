package dev.bifel.photoencryptor.model.tools

import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.model.ZipParameters
import net.lingala.zip4j.model.enums.AesKeyStrength
import net.lingala.zip4j.model.enums.CompressionLevel
import net.lingala.zip4j.model.enums.CompressionMethod
import net.lingala.zip4j.model.enums.EncryptionMethod
import java.io.File


object Zipper {

    suspend fun isAccessible(file: File, password: String? = null): Boolean {
        val zip = ZipFile(file, password?.toCharArray())
        for (fileHeader in zip.fileHeaders) {
            return try {
                val inputStream = zip.getInputStream(fileHeader)
                val b = ByteArray(4 * 4096)
                inputStream.read(b)
                inputStream.close()
                true
            } catch (e: Exception) {
                false
            }
        }
        return true
    }

    fun pack(image: File, destination: File, password: CharArray? = null) {
        val zipParameters = ZipParameters()
        zipParameters.compressionMethod = CompressionMethod.STORE
        zipParameters.compressionLevel = CompressionLevel.FASTEST
        zipParameters.isEncryptFiles = true
        zipParameters.encryptionMethod = EncryptionMethod.ZIP_STANDARD
        zipParameters.aesKeyStrength = AesKeyStrength.KEY_STRENGTH_256
        val zipFile = ZipFile(destination, password)
        zipFile.addFile(image, zipParameters)
    }

//    @Throws(ZipException::class)
//    fun unpack(sourceZipFilePath: String, extractedZipFilePath: String?) {
//        val zipFile = ZipFile(sourceZipFilePath + "." + EXTENSION)
//        if (zipFile.isEncrypted) {
//            zipFile.setPassword(password)
//        }
//        zipFile.extractAll(extractedZipFilePath)
//    }

}