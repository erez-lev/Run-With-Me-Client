package com.runwithme.runwithme.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.runwithme.runwithme.R
import com.runwithme.runwithme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /** Properties: */
    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy { findNavController(R.id.main_fragment) }

    /** Class Methods: */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apply toolbar.
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(false)
        }

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.profileFragment,
                R.id.runFragment,
                R.id.groupsFragment
            )
        )
        binding.mainNavigationMenu.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}