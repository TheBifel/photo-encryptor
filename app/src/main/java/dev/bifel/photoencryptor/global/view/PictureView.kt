package dev.bifel.photoencryptor.global.view

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import dev.bifel.photoencryptor.R
import dev.bifel.photoencryptor.global.extentions.getFile
import dev.bifel.photoencryptor.model.entity.Picture

class PictureView : PhotoView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attr: AttributeSet?) : super(context, attr)

    companion object {

        @BindingAdapter("app:picture")
        @JvmStatic
        fun setPicture(view: PictureView, picture: Picture?) = picture?.let { view.setPicture(it) }
    }


    init {
        isZoomable = true
    }

    fun setPicture(picture: Picture) {
        val drawable = CircularProgressDrawable(context)
            .apply {
                strokeWidth = 5f
                centerRadius = 30f
                setColorSchemeColors(context.getColor(R.color.colorPrimary))
                start()
            }

        Glide.with(context)
            .load(context.getFile(picture))
            .placeholder(drawable)
            .error(R.drawable.ic_error)
            .placeholder(drawable)
            .into(this)
    }
}