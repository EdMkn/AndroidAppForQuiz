package com.javaguiz.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.javaguiz.app.R
import com.javaguiz.app.ui.QuizActivity
import com.javaguiz.app.ui.MainActivity
/**
 * Results Activity - Shows quiz results
 * Similar to a results/summary page in web development
 */
class ResultsActivity : AppCompatActivity() {
    
    private lateinit var scoreText: TextView
    private lateinit var percentageText: TextView
    private lateinit var restartButton: MaterialButton
    private lateinit var homeButton: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        
        // Get score from previous activity (similar to route params or state in web)
        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        
        // Initialize views
        scoreText = findViewById(R.id.scoreText)
        percentageText = findViewById(R.id.percentageText)
        restartButton = findViewById(R.id.restartButton)
        homeButton = findViewById(R.id.homeButton)
        
        // Display results
        scoreText.text = getString(R.string.score, score, total)
        
        val percentage = if (total > 0) {
            (score * 100 / total)
        } else {
            0
        }
        percentageText.text = getString(R.string.percentage, percentage)
        
        // Set up button listeners
        restartButton.setOnClickListener {
            // Start a new quiz
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish() // Close this activity
        }
        
        homeButton.setOnClickListener {
            // Go back to home
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}

