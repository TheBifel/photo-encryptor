package dev.bifel.photoencryptor.global.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import org.koin.standalone.KoinComponent

/**
 * Date: 20.02.2020
 * Time: 23:02
 *
 * @author Bohdan Ishchenko
 */
abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onCleared() {
        try {
            coroutineScope.cancel()
        } catch (e: Exception) {
            // ignore cause exception causing when scope is empty
        }
        super.onCleared()
    }

    protected fun <T> execute(
        task: suspend () -> T,
        callback: (T) -> Unit,
        errorCallback: (Exception) -> Unit = {},
        onComplete: () -> Unit = {}
    ) {
        coroutineScope.launch {
            try {
                val result = task() ?: return@launch
                withContext(Dispatchers.Main) {
                    callback(result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                errorCallback(e)
            } finally {
                onComplete()
            }
        }
    }
}