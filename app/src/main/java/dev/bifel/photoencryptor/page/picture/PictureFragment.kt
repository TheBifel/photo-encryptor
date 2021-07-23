package dev.bifel.photoencryptor.page.picture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dev.bifel.photoencryptor.databinding.FragmentPictureBinding
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.global.extentions.addOnChangeListener
import kotlinx.android.synthetic.main.fragment_picture.*

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
        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(PictureViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentPictureBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.init()
        viewModel.bitmap.addOnChangeListener {
            progress.visibility = GONE
            img.setImageBitmap(it)
        }
    }
}

