package dev.bifel.photoencryptor.page.pickfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import dev.bifel.photoencryptor.databinding.FragmentPickFileBinding
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.global.pagenavigation.Screen
import kotlinx.android.synthetic.main.fragment_pick_file.*

/**
 * Date: 23.07.2021
 * Time: 23:40
 *
 * @author Bohdan Ishchenko
 */
class PickFileFragment : NavigableFragment() {

    private lateinit var binding: FragmentPickFileBinding
    private lateinit var viewModel: PickFileViewModel
    private lateinit var getFileLauncher: ActivityResultLauncher<String>

    override fun provideDI() {
        super.provideDI()
        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(PickFileViewModel::class.java)
        getFileLauncher =
            registerForActivityResult(ActivityResultContracts.GetContent()) {
                viewModel.setUri(it)
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentPickFileBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        btnAction.setOnClickListener { getFileLauncher.launch("*/*") }
        btnNext.setOnClickListener { navigator.add(Screen.PASSWORD) }
    }
}