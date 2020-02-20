package dev.bifel.photoencryptor.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dev.bifel.photoencryptor.databinding.FragmentPictureBinding
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.global.extentions.addOnChangeListenerIgnoreNull

/**
 * Date: 12.02.2020
 * Time: 23:56
 *
 * @author Bohdan Ishchenko
 */
class PictureFragment : NavigableFragment() {

    private lateinit var binding: FragmentPictureBinding
    private lateinit var viewModel: PictureViewModel

    override fun provideDI() {
        super.provideDI()
        viewModel = ViewModelProvider.AndroidViewModelFactory(activity!!.application)
            .create(PictureViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPictureBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init()
        viewModel.bitmap.addOnChangeListenerIgnoreNull { binding.img.setImageBitmap(it) }
    }
}

