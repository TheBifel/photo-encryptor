package dev.bifel.photoencryptor.page

import android.graphics.Bitmap
import androidx.databinding.ObservableField
import dev.bifel.photoencryptor.global.base.BaseViewModel
import org.koin.standalone.inject

/**
 * Date: 13.02.2020
 * Time: 0:42
 *
 * @author Bohdan Ishchenko
 */
class PictureViewModel : BaseViewModel() {
    private val useCase = inject<PictureUseCase>()

    val bitmap = ObservableField<Bitmap>()

    fun init() {
        execute({
            val encrypted = useCase.value.getEncrypted("test") {}
            useCase.value.getDecrypted("test", encrypted) {}
        }, {
            bitmap.set(it)
        })
    }
}