package com.hackaton.newbooks.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hackaton.newbooks.databinding.FragmentMoreBinding
import dagger.hilt.android.AndroidEntryPoint
import com.hackaton.newbooks.ui.base.BaseFragment

@AndroidEntryPoint
class MoreFragment : BaseFragment() {

    private val binding: FragmentMoreBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val viewModel : MoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun obtainViewModel() = viewModel
}