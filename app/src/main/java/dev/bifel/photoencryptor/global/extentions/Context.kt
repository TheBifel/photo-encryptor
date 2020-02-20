package dev.bifel.photoencryptor.global.extentions

import android.content.Context

/**
 * Date: 13.02.2020
 * Time: 0:34
 *
 * @author Bohdan Ishchenko
 */

fun Context.getInputStream(filename: String) = assets.open(filename)