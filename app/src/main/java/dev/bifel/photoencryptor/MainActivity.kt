package dev.bifel.photoencryptor

import android.os.Bundle
import dev.bifel.photoencryptor.global.base.BaseActivity
import dev.bifel.photoencryptor.global.pagenavigation.Navigator
import dev.bifel.photoencryptor.global.pagenavigation.Screen

/**
 * Date: 12.02.2020
 * Time: 23:16
 *
 * @author Bohdan Ishchenko
 */
class MainActivity : BaseActivity() {

    companion object {
        var navigator: Navigator? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator = Navigator(
            savedInstanceState,
            supportFragmentManager,
            R.id.container,
            Screen.initialScreen
        )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (navigator?.isRoot != true) {
            navigator?.current?.onBackPressed()
        }
    }
}