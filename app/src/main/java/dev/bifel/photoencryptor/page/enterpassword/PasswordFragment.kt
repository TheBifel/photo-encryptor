package dev.bifel.photoencryptor.page.enterpassword

import android.graphics.Rect
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.text.method.TransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dev.bifel.photoencryptor.R
import dev.bifel.photoencryptor.databinding.FragmentPasswordBinding
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.global.pagenavigation.Screen
import kotlinx.android.synthetic.main.fragment_password.*


/**
 * Date: 24.07.2021
 * Time: 1:01
 *
 * @author Bohdan Ishchenko
 */
class PasswordFragment : NavigableFragment() {

    private lateinit var binding: FragmentPasswordBinding
    private lateinit var viewModel: PasswordViewModel

    override fun provideDI() {
        super.provideDI()
        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(PasswordViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentPasswordBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        btnShowPassword.setOnClickListener {
            inputPassword.transformationMethod =
                if (btnShowPassword.isSelected) PasswordTransformationMethod() else DoNothingTransformation()
            btnShowPassword.setImageResource(if (btnShowPassword.isSelected) R.drawable.ic_invisible else R.drawable.ic_visible)
            btnShowPassword.isSelected = !btnShowPassword.isSelected
        }
        btnNext.setOnClickListener {
            viewModel.checkPassword { navigator.add(Screen.PICTURE) }
        }
    }

    class DoNothingTransformation : TransformationMethod {
        override fun getTransformation(p0: CharSequence, p1: View?): CharSequence = p0

        override fun onFocusChanged(p0: View?, p1: CharSequence, p2: Boolean, p3: Int, p4: Rect?) =
            Unit

    }
}