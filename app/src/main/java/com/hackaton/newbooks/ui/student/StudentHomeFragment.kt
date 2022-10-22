package com.hackaton.newbooks.ui.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hackaton.newbooks.R
import com.hackaton.newbooks.databinding.FragmentStudentHomeBinding
import com.hackaton.newbooks.ui.base.BaseFragment
import com.hackaton.newbooks.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentHomeFragment : BaseFragment() {

    private lateinit var navigation: NavController

    private val binding: FragmentStudentHomeBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    override fun obtainViewModel(): BaseViewModel? {
        return null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        initNavController()
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navigation)
    }

    private fun initNavController() {
        val fragment = childFragmentManager.findFragmentById(R.id.student_fragment_container) as NavHostFragment
        navigation = fragment.navController
    }
}