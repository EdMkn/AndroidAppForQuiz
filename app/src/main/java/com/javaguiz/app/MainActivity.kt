package com.javaguiz.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Main Activity - Welcome Screen
 * Similar to a landing page in web development
 */
class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Find the start button from the layout (similar to document.getElementById in web)
        val startButton = findViewById<com.google.android.material.button.MaterialButton>(R.id.startButton)
        
        // Set click listener (similar to addEventListener in web)
        startButton.setOnClickListener {
            // Navigate to QuizActivity (similar to routing in web)
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}

