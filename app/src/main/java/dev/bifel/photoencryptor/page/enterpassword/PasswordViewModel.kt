package dev.bifel.photoencryptor.page.enterpassword

import androidx.databinding.ObservableField
import dev.bifel.photoencryptor.global.base.BaseViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class PasswordViewModel : BaseViewModel(), KoinComponent {
    private val useCase by inject<PasswordUseCase>()

    val password = ObservableField<String?>()
    val passwordError = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()

    fun checkPassword(onSuccess: () -> Unit) {
        isLoading.set(true)
        execute({
            useCase.isZipAccessible(password.get()?.takeIf { it.isNotEmpty() })
        }, callback = {
            if (it) {
                passwordError.set("")
                onSuccess()
            } else {
                passwordError.set(useCase.getErrorText())
            }
        }, onComplete = {
            isLoading.set(false)
        })


    }

}
