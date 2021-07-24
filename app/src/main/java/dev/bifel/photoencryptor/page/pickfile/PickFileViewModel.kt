package dev.bifel.photoencryptor.page.pickfile

import android.net.Uri
import androidx.databinding.ObservableField
import dev.bifel.photoencryptor.global.base.BaseViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class PickFileViewModel : BaseViewModel(), KoinComponent {
    private val useCase by inject<PickFileUseCase>()

    val path = ObservableField<String>()
    val actionText = ObservableField(useCase.getActionText(false))
    val isNextAvailable = ObservableField(false)

    fun setUri(uri: Uri?) {
        path.set(uri?.path ?: useCase.getErrorText())
        actionText.set(useCase.getActionText(uri != null))
        isNextAvailable.set(uri != null)
        if (uri != null) {
            useCase.setZipFile(uri)
        }
    }
}
