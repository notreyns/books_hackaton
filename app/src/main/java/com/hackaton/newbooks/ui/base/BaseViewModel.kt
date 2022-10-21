package com.hackaton.newbooks.ui.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.hackaton.newbooks.helper.SingleLiveEvent
import com.hackaton.newbooks.model.navigation.FragmentTransaction

abstract class BaseViewModel : ViewModel(), LifecycleEventObserver {

    val navigateToFragment = SingleLiveEvent<FragmentTransaction>()

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> onCreate()
            Lifecycle.Event.ON_RESUME -> onResume()
            Lifecycle.Event.ON_START -> onStart()
            Lifecycle.Event.ON_PAUSE -> onPause()
            Lifecycle.Event.ON_STOP -> onStop()
            else -> {}
        }
    }

    open fun onCreate() {}
    open fun onResume() {}
    open fun onStart() {}
    open fun onPause() {}
    open fun onStop() {}

}