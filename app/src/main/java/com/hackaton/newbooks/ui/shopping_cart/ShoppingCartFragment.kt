package com.hackaton.newbooks.ui.shopping_cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hackaton.newbooks.databinding.FragmentShoppingCartBinding
import dagger.hilt.android.AndroidEntryPoint
import com.hackaton.newbooks.ui.base.BaseFragment

@AndroidEntryPoint
class ShoppingCartFragment : BaseFragment() {

    private val binding: FragmentShoppingCartBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val viewModel: ShoppingCartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun obtainViewModel() = viewModel

}