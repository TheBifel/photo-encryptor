package dev.bifel.photoencryptor.page.enterpassword

import androidx.databinding.ObservableField
import dev.bifel.photoencryptor.global.base.BaseViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class PasswordViewModel : BaseViewModel(), KoinComponent {
    private val useCase by inject<PasswordUseCase>()

    val path = ObservableField<String>()
    val isNextAvailable = ObservableField(false)

}
