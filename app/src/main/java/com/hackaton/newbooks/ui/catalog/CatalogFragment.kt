package com.hackaton.newbooks.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hackaton.newbooks.databinding.FragmentCatalogBinding
import com.hackaton.newbooks.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : BaseFragment() {

    private val binding: FragmentCatalogBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val viewModel: CatalogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun obtainViewModel() = viewModel
}