package com.hackaton.newbooks.ui.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hackaton.newbooks.R
import com.hackaton.newbooks.databinding.FragmentMyBooksBinding
import com.hackaton.newbooks.ui.base.BaseFragment
import com.hackaton.newbooks.ui.student.adapter.ReservedItemsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MyBooksFragment: BaseFragment() {

    private val binding: FragmentMyBooksBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    private val viewModel: MyBooksViewModel by viewModels()

    private val adapter by lazy { ReservedItemsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setOnLiveDataListeners()
    }

    private fun setOnLiveDataListeners() {
        viewModel.items.observe(viewLifecycleOwner){
            adapter.addItems(it)
            binding.subtitle.text = getString(R.string.available_books_count, 5 - it.size)
        }
    }

    private fun setRecyclerView() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun obtainViewModel() = viewModel
}