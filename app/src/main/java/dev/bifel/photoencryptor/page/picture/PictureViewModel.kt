package dev.bifel.photoencryptor.page.picture

import android.graphics.Bitmap
import androidx.databinding.ObservableField
import dev.bifel.photoencryptor.global.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Date: 13.02.2020
 * Time: 0:42
 *
 * @author Bohdan Ishchenko
 */
class PictureViewModel : BaseViewModel(), KoinComponent {
    private val useCase by inject<PictureUseCase>()

    val bitmap = ObservableField<Bitmap>()
    val process = ObservableField<String>()

    fun init() {
        execute({
            useCase.getEncrypted("test") {
                withContext(Dispatchers.Main) {
                    process.set("$it%")
                }
            }
        }, {
            bitmap.set(it)
        })
    }
}