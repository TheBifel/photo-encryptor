package dev.bifel.photoencryptor.page.pickfile

import android.net.Uri
import dev.bifel.photoencryptor.R
import dev.bifel.photoencryptor.global.base.BaseUseCase
import org.koin.core.KoinComponent
import java.io.File

/**
 * Date: 24.07.2021
 * Time: 0:05
 *
 * @author Bohdan Ishchenko
 */
class PickFileUseCase : BaseUseCase(), KoinComponent {

    fun getActionText(isPicked: Boolean): String =
        context.getString(if (isPicked) R.string.change_zip else R.string.pick_zip)

    fun getErrorText(): String = context.getString(R.string.error)

    fun setZipFile(file: Uri) {
        val tempFile: File = File.createTempFile("zip", ".zip", context.cacheDir)
        val inputStream = context.contentResolver.openInputStream(file)!!
        tempFile.outputStream().use(inputStream::copyTo)
        cache.zip = tempFile
    }
}