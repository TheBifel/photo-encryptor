package dev.bifel.photoencryptor.global.base

import android.content.Context
import androidx.fragment.app.Fragment

/**
 * Date: 12.02.2020
 * Time: 23:30
 *
 * @author Bohdan Ishchenko
 */
abstract class NavigableFragment : Fragment() {


    open fun onBackPressed() {
    }

    fun onShow() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        provideDI()
    }

    open fun provideDI() {}
}