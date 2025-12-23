package com.javaguiz.app.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.javaguiz.app.data.QuestionBank
import com.javaguiz.app.R

/**
 * Category selection screen - allows users to choose a Java version category
 */
class CategorySelectionActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_selection)
        
        // Get available versions from QuestionBank
        val availableVersions = QuestionBank.getAvailableVersions()
        
        // Set up category buttons
        setupCategoryButtons(availableVersions)
    }
    
    private fun setupCategoryButtons(versions: List<String>) {
        // All Questions button
        val allButton = findViewById<MaterialButton>(R.id.categoryAllButton)
        allButton.setOnClickListener {
            startQuiz(null)
        }
        
        // Java version buttons
        val versionButtons = mapOf(
            R.id.categoryJava17Button to "17",
            R.id.categoryJava18Button to "18",
            R.id.categoryJava19Button to "19",
            R.id.categoryJava20Button to "20",
            R.id.categoryJava21Button to "21",
            R.id.categoryJava8Button to "8",
            R.id.categoryCoreButton to "Core"
        )
        
        versionButtons.forEach { (buttonId, version) ->
            val button = findViewById<MaterialButton>(buttonId)
            // Only show buttons for versions that have questions
            if (versions.contains(version)) {
                button.visibility = View.VISIBLE
                button.setOnClickListener {
                    startQuiz(version)
                }
            } else {
                button.visibility = View.GONE
            }
        }
    }
    
    private fun startQuiz(javaVersion: String?) {
        val intent = Intent(this, QuizActivity::class.java)
        if (javaVersion != null) {
            intent.putExtra("javaVersion", javaVersion)
        }
        startActivity(intent)
    }
}

