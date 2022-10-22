package com.hackaton.newbooks.ui.login

import com.hackaton.newbooks.R
import com.hackaton.newbooks.model.navigation.FragmentTransaction
import com.hackaton.newbooks.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    fun onSubmit(name: String, password: String) {
        navigateToFragment.startEvent(FragmentTransaction(R.id.action_loginFragment_to_studentHomeFragment))
    }
}