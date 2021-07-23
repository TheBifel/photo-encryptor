package dev.bifel.photoencryptor.global.pagenavigation

import androidx.fragment.app.Fragment
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.page.pickfile.PickFileFragment
import dev.bifel.photoencryptor.page.picture.PictureFragment

/**
 * Date: 12.02.2020
 * Time: 23:32
 *
 * @author Bohdan Ishchenko
 */
enum class Screen(val fragment: NavigableFragment) {
    PICTURE(PictureFragment()),
    PICK_FILE(PickFileFragment()),
    ;

    companion object {
        fun getScreen(fragment: Fragment): Screen? =
            when (fragment) {
                is PictureFragment -> PICTURE
                is PickFileFragment -> PICK_FILE
                else -> null
            }

        val initialScreen = PICK_FILE
    }
}
