package com.javaguiz.app

import android.app.Application
import com.javaguiz.app.data.QuestionBank
import com.javaguiz.app.data.QuestionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Application class for initializing database and repository
 */
class QuizApplication : Application() {
    lateinit var questionRepository: QuestionRepository
    
    override fun onCreate() {
        super.onCreate()
        questionRepository = QuestionRepository(this)
        
        // Initialize database with default questions on first launch
        CoroutineScope(Dispatchers.IO).launch {
            val defaultQuestions = QuestionBank.getAllQuestions()
            questionRepository.initializeDatabase(defaultQuestions)
        }
    }
}


