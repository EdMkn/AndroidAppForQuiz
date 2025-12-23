package com.javaguiz.app.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.javaguiz.app.util.PreferencesManager
import com.javaguiz.app.data.Question
import com.javaguiz.app.data.QuestionBank
import com.javaguiz.app.ui.ResultsActivity
import com.javaguiz.app.R
/**
 * Quiz Activity - Handles the quiz questions
 * Similar to a component/page that manages quiz state in web development
 */
class QuizActivity : AppCompatActivity() {
    
    // UI Components (similar to DOM elements in web)
    private lateinit var questionCounter: TextView
    private lateinit var javaVersionBadge: TextView
    private lateinit var questionText: TextView
    private lateinit var optionButton1: MaterialButton
    private lateinit var optionButton2: MaterialButton
    private lateinit var optionButton3: MaterialButton
    private lateinit var optionButton4: MaterialButton
    private lateinit var feedbackText: TextView
    private lateinit var explanationText: TextView
    private lateinit var nextButton: MaterialButton
    
    // Quiz state (similar to component state in React/Vue)
    private lateinit var questions: List<Question>
    private var currentQuestionIndex = 0
    private var score = 0
    private var selectedAnswerIndex: Int? = null
    private var answerSubmitted = false

    private lateinit var preferencesManager: PreferencesManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        
        // Initialize preferences manager
        preferencesManager = PreferencesManager(this)

        // Initialize UI components
        initializeViews()
        
        // Load questions based on user preference
        val questionCount = preferencesManager.getQuestionCount()
        questions = if (questionCount >= 999) {
            // Show all questions
            QuestionBank.getAllQuestions().shuffled()
        } else {
            QuestionBank.getRandomQuestions(questionCount)
        }
        
        // Display the first question
        displayQuestion()
        
        // Set up option button click listeners
        setupOptionButtons()
        
        // Set up next button click listener
        nextButton.setOnClickListener {
            if (currentQuestionIndex < questions.size - 1) {
                // Move to next question
                currentQuestionIndex++
                answerSubmitted = false
                selectedAnswerIndex = null
                displayQuestion()
                resetOptionButtons()
            } else {
                // Quiz finished, go to results
                goToResults()
            }
        }
    }
    
    /**
     * Initialize all view references
     * Similar to querySelector in web development
     */
    private fun initializeViews() {
        questionCounter = findViewById(R.id.questionCounter)
        javaVersionBadge = findViewById(R.id.javaVersionBadge)
        questionText = findViewById(R.id.questionText)
        optionButton1 = findViewById(R.id.optionButton1)
        optionButton2 = findViewById(R.id.optionButton2)
        optionButton3 = findViewById(R.id.optionButton3)
        optionButton4 = findViewById(R.id.optionButton4)
        feedbackText = findViewById(R.id.feedbackText)
        explanationText = findViewById(R.id.explanationText)
        nextButton = findViewById(R.id.nextButton)
    }
    
    /**
     * Display the current question
     * Similar to rendering data in a template
     */
    private fun displayQuestion() {
        val question = questions[currentQuestionIndex]
        
        // Update question counter
        questionCounter.text = getString(R.string.question_counter, currentQuestionIndex + 1, questions.size)
        
        // Update Java version badge
        javaVersionBadge.text = getString(R.string.java_version, question.javaVersion)
        
        // Update question text
        questionText.text = question.questionText
        
        // Update option buttons
        optionButton1.text = question.options[0]
        optionButton2.text = question.options[1]
        optionButton3.text = question.options[2]
        optionButton4.text = question.options[3]
        
        // Hide feedback and explanation initially
        feedbackText.visibility = View.GONE
        explanationText.visibility = View.GONE
        nextButton.visibility = View.GONE
        
        // Enable all option buttons
        enableOptionButtons()
    }
    
    /**
     * Set up click listeners for option buttons
     */
    private fun setupOptionButtons() {
        optionButton1.setOnClickListener { onOptionSelected(0) }
        optionButton2.setOnClickListener { onOptionSelected(1) }
        optionButton3.setOnClickListener { onOptionSelected(2) }
        optionButton4.setOnClickListener { onOptionSelected(3) }
    }
    
    /**
     * Handle when user selects an option
     */
    private fun onOptionSelected(selectedIndex: Int) {
        if (answerSubmitted) return // Don't allow changing answer after submission
        
        selectedAnswerIndex = selectedIndex
        val question = questions[currentQuestionIndex]
        
        // Disable all buttons to prevent multiple selections
        disableOptionButtons()
        
        // Highlight selected button
        highlightSelectedButton(selectedIndex)
        
        // Check if answer is correct
        val isCorrect = selectedIndex == question.correctAnswerIndex
        
        // Update score
        if (isCorrect) {
            score++
        }

        // Provide feedback (sound/vibration if enabled)
        provideFeedback(isCorrect)
        
        // Show feedback
        showFeedback(isCorrect, question)
        
        // Mark as submitted
        answerSubmitted = true
    }

    /**
     * Provide haptic/audio feedback based on preferences
     */
    private fun provideFeedback(isCorrect: Boolean) {
        // Vibration feedback
        if (preferencesManager.isVibrationEnabled()) {
            val vibratorManager = getSystemService(VIBRATOR_MANAGER_SERVICE) as? android.os.VibratorManager
            val vibrator = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                vibratorManager?.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                getSystemService(VIBRATOR_SERVICE) as? android.os.Vibrator
            }
            // Check if vibrator is available
            if (vibrator?.hasVibrator() == true) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    vibrator.vibrate(
                        android.os.VibrationEffect.createOneShot(
                            if (isCorrect) 50 else 100,
                            android.os.VibrationEffect.DEFAULT_AMPLITUDE
                        )
                    )
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(if (isCorrect) 50 else 100)
                }
            }
        }
        
        // Sound feedback could be added here using MediaPlayer or SoundPool
        // if (preferencesManager.isSoundEnabled()) { ... }
    }

    /**
     * Show feedback and explanation
     */
    private fun showFeedback(isCorrect: Boolean, question: Question) {
        feedbackText.visibility = View.VISIBLE
        explanationText.visibility = View.VISIBLE
        nextButton.visibility = View.VISIBLE
        
        if (isCorrect) {
            feedbackText.text = getString(R.string.correct_answer)
            feedbackText.setTextColor(Color.parseColor("#4CAF50"))
        } else {
            feedbackText.text = getString(R.string.incorrect_answer)
            feedbackText.setTextColor(Color.parseColor("#F44336"))
            
            // Highlight the correct answer
            highlightCorrectAnswer(question.correctAnswerIndex)
        }
        
        // Show explanation
        explanationText.text = "${getString(R.string.explanation)}\n${question.explanation}"
    }
    
    /**
     * Highlight the selected button
     */
    private fun highlightSelectedButton(index: Int) {
        val button = getOptionButton(index)
        button.setBackgroundColor(Color.parseColor("#E3F2FD"))
        button.setTextColor(Color.parseColor("#1976D2"))
    }
    
    /**
     * Highlight the correct answer
     */
    private fun highlightCorrectAnswer(index: Int) {
        val button = getOptionButton(index)
        button.setBackgroundColor(Color.parseColor("#C8E6C9"))
        button.setTextColor(Color.parseColor("#2E7D32"))
    }
    
    /**
     * Get option button by index
     */
    private fun getOptionButton(index: Int): MaterialButton {
        return when (index) {
            0 -> optionButton1
            1 -> optionButton2
            2 -> optionButton3
            3 -> optionButton4
            else -> optionButton1
        }
    }
    
    /**
     * Enable all option buttons
     */
    private fun enableOptionButtons() {
        optionButton1.isEnabled = true
        optionButton2.isEnabled = true
        optionButton3.isEnabled = true
        optionButton4.isEnabled = true
    }
    
    /**
     * Disable all option buttons
     */
    private fun disableOptionButtons() {
        optionButton1.isEnabled = false
        optionButton2.isEnabled = false
        optionButton3.isEnabled = false
        optionButton4.isEnabled = false
    }
    
    /**
     * Reset option buttons to default state
     */
    private fun resetOptionButtons() {
        val buttons = listOf(optionButton1, optionButton2, optionButton3, optionButton4)
        buttons.forEach { button ->
            button.setBackgroundColor(Color.TRANSPARENT)
            button.setTextColor(Color.parseColor("#6200EE"))
        }
    }
    
    /**
     * Navigate to results screen
     */
    private fun goToResults() {
        val intent = Intent(this, ResultsActivity::class.java)
        intent.putExtra("score", score)
        intent.putExtra("total", questions.size)
        startActivity(intent)
        finish() // Close this activity (similar to navigation.replace in web)
    }
}

