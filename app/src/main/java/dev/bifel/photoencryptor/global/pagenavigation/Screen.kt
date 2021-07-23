package dev.bifel.photoencryptor.global.pagenavigation

import androidx.fragment.app.Fragment
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.page.enterpassword.PasswordFragment
import dev.bifel.photoencryptor.page.pickfile.PickFileFragment
import dev.bifel.photoencryptor.page.picture.PictureFragment

/**
 * Date: 12.02.2020
 * Time: 23:32
 *
 * @author Bohdan Ishchenko
 */
enum class Screen(val fragment: NavigableFragment) {
    PICK_FILE(PickFileFragment()),
    PASSWORD(PasswordFragment()),
    PICTURE(PictureFragment()),
    ;

    companion object {
        fun getScreen(fragment: Fragment): Screen? =
            when (fragment) {
                is PictureFragment -> PICTURE
                is PickFileFragment -> PICK_FILE
                is PasswordFragment -> PASSWORD
                else -> null
            }

        val initialScreen = PICK_FILE
    }
}
