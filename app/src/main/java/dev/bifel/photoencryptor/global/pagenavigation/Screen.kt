package dev.bifel.photoencryptor.global.pagenavigation

import androidx.fragment.app.Fragment
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.page.PictureFragment

/**
 * Date: 12.02.2020
 * Time: 23:32
 *
 * @author Bohdan Ishchenko
 */
enum class Screen(val fragment: NavigableFragment) {
    MAIN(PictureFragment())
    ;

    companion object {
        fun getScreen(fragment: Fragment): Screen? =
            when (fragment) {
                is PictureFragment -> MAIN
                else -> null
            }
    }
}
