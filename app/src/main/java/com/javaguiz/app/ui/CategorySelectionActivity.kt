package com.javaguiz.app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.javaguiz.app.data.QuestionRepository
import com.javaguiz.app.QuizApplication
import com.javaguiz.app.R
import kotlinx.coroutines.launch

/**
 * Category selection screen - allows users to choose a Java version and/or category
 */
class CategorySelectionActivity : AppCompatActivity() {
    
    private lateinit var questionRepository: QuestionRepository
    private lateinit var step1CategorySelection: View
    private lateinit var step2VersionSelection: View
    private lateinit var selectedCategoryText: TextView
    private lateinit var versionButtonsRecycler: RecyclerView
    private lateinit var backButton: Button
    private var selectedCategory: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_selection)

        step1CategorySelection = findViewById(R.id.step1CategorySelection)
        step2VersionSelection = findViewById(R.id.step2VersionSelection)
        selectedCategoryText = findViewById(R.id.selectedCategoryText)
        versionButtonsRecycler = findViewById(R.id.versionButtonsRecycler)
        backButton = findViewById(R.id.backButton)

        // Set up RecyclerView for version buttons
        versionButtonsRecycler.layoutManager = LinearLayoutManager(this)
        versionButtonsRecycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        // Set up back button
        backButton.setOnClickListener {
            step1CategorySelection.visibility = View.VISIBLE
            step2VersionSelection.visibility = View.GONE
        }
        
        // Get repository from Application
        questionRepository = (application as QuizApplication).questionRepository
        
        // Load available versions and categories asynchronously from database
        lifecycleScope.launch {
            try {
                val availableVersions = questionRepository.getAvailableVersions()
                val availableCategories = questionRepository.getAvailableCategories()
                // Update UI on main thread
                setupVersionButtons(availableVersions)
                setupCategoryButtons(availableCategories)
            } catch (e: Exception) {
                // Handle error - show all buttons as fallback
                android.util.Log.e("CategorySelectionActivity", "Error loading data", e)
                setupVersionButtons(emptyList())
                setupCategoryButtons(emptyList())
            }
        }
        
        // All Questions button
        val allButton = findViewById<MaterialButton>(R.id.categoryAllButton)
        allButton.setOnClickListener {
            startQuiz(null, null)
        }
    }
    
    private fun setupVersionButtons(versions: List<String>) {
        val adapter = VersionAdapter(versions) { selectedVersion ->
            startQuiz(selectedVersion, selectedCategory)
        }
        versionButtonsRecycler.adapter = adapter
    }

    private fun showVersionSelection(categoryName: String) {
        selectedCategoryText.text = getString(R.string.selected_category, categoryName)
        step1CategorySelection.visibility = View.GONE
        step2VersionSelection.visibility = View.VISIBLE
        
        // Load available versions
        lifecycleScope.launch {
            try {
                val versions = questionRepository.getAvailableVersions()
                setupVersionButtons(versions)
            } catch (e: Exception) {
                Log.e("CategorySelection", "Error loading versions", e)
                // Fallback to default versions if there's an error
                setupVersionButtons(listOf("21", "20", "19", "18", "17", "8", "Core"))
            }
        }
    }
    
    private fun setupCategoryButtons(categories: List<String>) {
        val categoryButtonMap: Map<Int, String> = mapOf(
            R.id.categoryAllButton to getString(R.string.all_categories),
            R.id.categoryLanguageFeaturesButton to "Language Features",
            R.id.categoryConcurrencyButton to "Concurrency",
            R.id.categoryCollectionsButton to "Collections",
            R.id.categoryAPIsButton to "APIs",
            R.id.categoryCoreConceptsButton to "Core Concepts",
            R.id.categoryAdvancedButton to "Advanced",
            R.id.categoryGeneralButton to "General"
        )
        categoryButtonMap.forEach { (buttonId, category) ->
            val button = findViewById<MaterialButton>(buttonId)
            if (categories.contains(category) || category == getString(R.string.all_categories)) {
                button.visibility = View.VISIBLE
                button.setOnClickListener {
                    selectedCategory = if (category == getString(R.string.all_categories)) null else category
                    showVersionSelection(category)
                }
            } else {
                button.visibility = View.GONE
            }
        }
    }
    
    private fun startQuiz(javaVersion: String?, category: String?) {
        Log.d("QuizStart", "Starting quiz with version: $javaVersion, category: $category")
        
        lifecycleScope.launch {
            try {
                val questions = questionRepository.getQuestionsByVersionAndCategorySync(
                    if (javaVersion.isNullOrEmpty()) null else javaVersion,
                    if (category.isNullOrEmpty()) null else category
                )
                
                if (questions.isEmpty()) {
                    // Show a toast or dialog to inform the user
                    android.widget.Toast.makeText(
                        this@CategorySelectionActivity,
                        "No questions available for the selected criteria",
                        android.widget.Toast.LENGTH_LONG
                    ).show()
                    return@launch
                }
                
                val intent = Intent(this@CategorySelectionActivity, QuizActivity::class.java).apply {
                    putExtra("version", javaVersion ?: "")
                    putExtra("category", category ?: "")
                }
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                Log.e("CategorySelection", "Error checking questions", e)
                android.widget.Toast.makeText(
                    this@CategorySelectionActivity,
                    "Error checking questions: ${e.message}",
                    android.widget.Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    // Add this adapter class
private class VersionAdapter(
        private val versions: List<String>,
        private val onVersionSelected: (String) -> Unit
    ) : RecyclerView.Adapter<VersionAdapter.VersionViewHolder>() {
        class VersionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val button: Button = view as Button
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionViewHolder {
            val button = MaterialButton(parent.context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setPadding(32, 16, 32, 16)
                textSize = 16f
            }
            return VersionViewHolder(button)
        }
        override fun onBindViewHolder(holder: VersionViewHolder, position: Int) {
            val version = versions[position]
            holder.button.text = when (version) {
                "Core" -> holder.button.context.getString(R.string.core_java)
                else -> "Java $version"
            }
            holder.button.setOnClickListener { onVersionSelected(version) }
        }
        override fun getItemCount() = versions.size
    }
}

