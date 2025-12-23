package com.javaguiz.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButton

/**
 * Main Activity - Welcome Screen
 * Similar to a landing page in web development
 */
class MainActivity : AppCompatActivity() {

    private lateinit var preferencesManager: PreferencesManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize preferences manager
        preferencesManager = PreferencesManager(this)
        //Apply theme based on preferences
        applyTheme()

        setContentView(R.layout.activity_main)
        
        // Find the start button from the layout (similar to document.getElementById in web)
        val startButton = findViewById<MaterialButton>(R.id.startButton)
        
        // Set click listener (similar to addEventListener in web)
        startButton.setOnClickListener {
            // Navigate to QuizActivity (similar to routing in web)
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        // Find and set up settings button
        val settingsButton = findViewById<MaterialButton>(R.id.settingsButton)
        settingsButton.setOnClickListener {
            openSettings()
        }
    }

    override fun onResume() {
        super.onResume()
        // Reapply theme in case it changed in settings
        applyTheme()
    }
    
    /**
     * Apply theme based on user preference
     */
    private fun applyTheme() {
        if (preferencesManager.isDarkModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

     /**
     * Navigate to settings (call this from a button click)
     */
    fun openSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}

