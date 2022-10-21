package com.hackaton.newbooks.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hackaton.newbooks.MainActivity

abstract class BaseFragment : Fragment() {

    protected fun hideOrShowBottomNavigation(shouldHide: Boolean) {
        if (shouldHide) {
            (activity as? MainActivity)?.hideBottomNavigation()
        } else {
            (activity as? MainActivity)?.showBottomNavigation()
        }
    }

    abstract fun obtainViewModel(): BaseViewModel?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obtainViewModel()?.let {
            lifecycle.addObserver(it)
        }
        setupLiveData()
    }

    private fun setupLiveData() {
        obtainViewModel()?.navigateToFragment?.observe(viewLifecycleOwner) {
            findNavController().navigate(it.navigationId, it.bundle, it.navOptions)
        }
    }
}