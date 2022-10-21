package com.hackaton.newbooks

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hackaton.newbooks.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private lateinit var navigation: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()
    }

    fun hideBottomNavigation() {
        val bottomNavigationBar =
            findViewById<BottomNavigationView>(R.id.bottomNavigationView) ?: return
        bottomNavigationBar.visibility = View.GONE
    }

    fun showBottomNavigation() {
        val bottomNavigationBar =
            findViewById<BottomNavigationView>(R.id.bottomNavigationView) ?: return
        bottomNavigationBar.visibility = View.VISIBLE
    }

    private fun setupNavigation() {
        initNavController()
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navigation)
    }

    private fun initNavController() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navigation = fragment.navController
    }
}