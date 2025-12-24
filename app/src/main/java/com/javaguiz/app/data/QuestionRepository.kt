package com.javaguiz.app.data

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Repository for question data access
 * Provides a clean API for accessing questions from the database
 */
class QuestionRepository(context: Context) {
    private val database = QuizDatabase.getDatabase(context)
    private val questionDao = database.questionDao()
    
    /**
     * Get all questions as a Flow
     */
    fun getAllQuestions(): Flow<List<Question>> {
        return questionDao.getAllQuestions().map { entities ->
            entities.map { it.toQuestion() }
        }
    }
    
    /**
     * Get all questions synchronously
     */
    suspend fun getAllQuestionsSync(): List<Question> {
        return questionDao.getAllQuestionsSync().map { it.toQuestion() }
    }
    
    /**
     * Get questions filtered by Java version as a Flow
     */
    fun getQuestionsByVersion(version: String?): Flow<List<Question>> {
        return if (version == null || version == "All") {
            getAllQuestions()
        } else {
            questionDao.getQuestionsByVersion(version).map { entities ->
                entities.map { it.toQuestion() }
            }
        }
    }
    
    /**
     * Get questions filtered by Java version synchronously
     */
    suspend fun getQuestionsByVersionSync(version: String?): List<Question> {
        return if (version == null || version == "All") {
            getAllQuestionsSync()
        } else {
            questionDao.getQuestionsByVersionSync(version).map { it.toQuestion() }
        }
    }
    
    /**
     * Get a random subset of questions filtered by Java version
     */
    suspend fun getRandomQuestionsByVersion(count: Int, javaVersion: String?): List<Question> {
        val allQuestions = getQuestionsByVersionSync(javaVersion)
        return allQuestions.shuffled().take(count)
    }
    
    /**
     * Get available Java version categories
     */
    suspend fun getAvailableVersions(): List<String> {
        return questionDao.getAvailableVersions()
    }
    
    /**
     * Initialize database with questions from QuestionBank if empty
     */
    suspend fun initializeDatabase(questions: List<Question>) {
        if (questionDao.getQuestionCount() == 0) {
            val entities = questions.map { QuestionEntity.fromQuestion(it) }
            questionDao.insertQuestions(entities)
        }
    }
    
    /**
     * Get question count
     */
    suspend fun getQuestionCount(): Int {
        return questionDao.getQuestionCount()
    }
}


