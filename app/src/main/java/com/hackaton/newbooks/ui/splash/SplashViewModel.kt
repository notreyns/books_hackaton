package com.hackaton.newbooks.ui.splash

import androidx.lifecycle.viewModelScope
import com.hackaton.newbooks.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.hackaton.newbooks.model.navigation.FragmentTransaction
import com.hackaton.newbooks.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): BaseViewModel() {

    override fun onCreate() {
        super.onCreate()

        //TODO перекидывать на нужный экран
        viewModelScope.launch {
            delay(3000)
            navigateToFragment.startEvent(FragmentTransaction(R.id.action_splashFragment_to_loginFragment))
        }
    }
}