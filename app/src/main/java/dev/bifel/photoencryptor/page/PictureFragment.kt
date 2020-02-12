package dev.bifel.photoencryptor.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.bifel.photoencryptor.databinding.FragmentPictureBinding
import dev.bifel.photoencryptor.global.base.NavigableFragment

/**
 * Date: 12.02.2020
 * Time: 23:56
 *
 * @author Bohdan Ishchenko
 */
class PictureFragment : NavigableFragment() {

    private lateinit var binding: FragmentPictureBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPictureBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}