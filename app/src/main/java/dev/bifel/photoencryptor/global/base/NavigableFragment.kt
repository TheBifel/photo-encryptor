package dev.bifel.photoencryptor.global.base

import android.content.Context
import androidx.fragment.app.Fragment
import dev.bifel.photoencryptor.MainActivity
import dev.bifel.photoencryptor.global.pagenavigation.Navigator

/**
 * Date: 12.02.2020
 * Time: 23:30
 *
 * @author Bohdan Ishchenko
 */
open class NavigableFragment : Fragment() {

    protected val navigator: Navigator
        get() = MainActivity.navigator
            ?: throw NullPointerException("Page navigator is not initialized")

    fun onBackPressed() {
        navigator.pop()
    }

    fun onShow() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        provideDI()
    }

    fun provideDI() {}
}