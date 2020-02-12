package dev.bifel.photoencryptor.global.extentions

import android.content.Context
import dev.bifel.photoencryptor.model.entity.Picture
import java.io.File

/**
 * Date: 13.02.2020
 * Time: 0:34
 *
 * @author Bohdan Ishchenko
 */

fun Context.getFile(picture: Picture): File = picture.file