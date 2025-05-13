package com.example.stereometriya1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.stereometriya1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            
            if (navHostFragment == null) {
                Log.e(TAG, "NavHostFragment topilmadi!")
                Toast.makeText(this, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
                return
            }

            val navController = navHostFragment.navController
            
            // BottomNavigationView bilan bog'lash
            binding.bottomNavigation.setupWithNavController(navController)
            
            // Navigation xatolarini kuzatish
            navController.addOnDestinationChangedListener { _, destination, _ ->
                Log.d(TAG, "Navigation to: ${destination.label}")
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Xatolik yuz berdi: ${e.message}", e)
            Toast.makeText(this, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
        }
    }
}
