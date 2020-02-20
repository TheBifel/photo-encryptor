package dev.bifel.photoencryptor.global.extentions

import androidx.databinding.Observable
import androidx.databinding.ObservableField

/**
 * Date: 20.11.2019
 * Time: 16:46
 *
 * @author Bohdan Ishchenko
 */

fun <T> ObservableField<T>.addOnChangeListener(callback: (T?) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) = callback(get())
    })
}

fun <T> ObservableField<T>.addOnChangeListenerIgnoreNull(callback: (T) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) =
            get()?.let { callback(it) } ?: Unit
    })
}