package dev.bifel.photoencryptor

import android.os.Bundle
import dev.bifel.photoencryptor.global.base.BaseActivity

/**
 * Date: 12.02.2020
 * Time: 23:16
 *
 * @author Bohdan Ishchenko
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}