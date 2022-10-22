package com.hackaton.newbooks.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hackaton.newbooks.R
import com.hackaton.newbooks.databinding.FragmentBookEditorBinding
import com.hackaton.newbooks.databinding.FragmentFavoritesBinding
import com.hackaton.newbooks.ui.base.BaseFragment
import com.hackaton.newbooks.ui.favorites.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BookEditorFragment  : BaseFragment() {

    private val binding: FragmentBookEditorBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    private val viewModel: FavoritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun obtainViewModel() = viewModel
}