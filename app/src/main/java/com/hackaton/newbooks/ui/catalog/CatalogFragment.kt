package com.hackaton.newbooks.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hackaton.newbooks.R
import com.hackaton.newbooks.databinding.FragmentCatalogBinding
import com.hackaton.newbooks.ui.base.BaseFragment
import com.hackaton.newbooks.ui.catalog.adapter.BooksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : BaseFragment() {

    private val binding: FragmentCatalogBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val viewModel: CatalogViewModel by viewModels()


    private val adapter by lazy { BooksAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun obtainViewModel() = viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setOnClickListeners()
        setOnLiveDataListeners()
    }

    private fun setOnLiveDataListeners() {
        viewModel.items.observe(viewLifecycleOwner){
            adapter.addItems(it)
        }
    }


    private fun setOnClickListeners() {

    }

    private fun setRecyclerView() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}