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
     * Get questions filtered by category as a Flow
     */
    fun getQuestionsByCategory(category: String?): Flow<List<Question>> {
        return if (category == null || category == "All") {
            getAllQuestions()
        } else {
            questionDao.getQuestionsByCategory(category).map { entities ->
                entities.map { it.toQuestion() }
            }
        }
    }
    
    /**
     * Get questions filtered by category synchronously
     */
    suspend fun getQuestionsByCategorySync(category: String?): List<Question> {
        return if (category == null || category == "All") {
            getAllQuestionsSync()
        } else {
            questionDao.getQuestionsByCategorySync(category).map { it.toQuestion() }
        }
    }
    
    /**
     * Get questions filtered by both version and category as a Flow
     */
    fun getQuestionsByVersionAndCategory(version: String?, category: String?): Flow<List<Question>> {
        return when {
            (version == null || version == "All") && (category == null || category == "All") -> getAllQuestions()
            version == null || version == "All" -> getQuestionsByCategory(category)
            category == null || category == "All" -> getQuestionsByVersion(version)
            else -> questionDao.getQuestionsByVersionAndCategory(version, category).map { entities ->
                entities.map { it.toQuestion() }
            }
        }
    }
    
    /**
     * Get questions filtered by both version and category synchronously
     */
    suspend fun getQuestionsByVersionAndCategorySync(version: String?, category: String?): List<Question> {
        return when {
            (version == null || version == "All") && (category == null || category == "All") -> getAllQuestionsSync()
            version == null || version == "All" -> getQuestionsByCategorySync(category)
            category == null || category == "All" -> getQuestionsByVersionSync(version)
            else -> questionDao.getQuestionsByVersionAndCategorySync(version, category).map { it.toQuestion() }
        }
    }
    
    /**
     * Get a random subset of questions filtered by version and category
     */
    suspend fun getRandomQuestionsByVersionAndCategory(count: Int, javaVersion: String?, category: String?): List<Question> {
        val allQuestions = getQuestionsByVersionAndCategorySync(javaVersion, category)
        return allQuestions.shuffled().take(count)
    }
    
    /**
     * Get available Java version categories
     */
    suspend fun getAvailableVersions(): List<String> {
        return questionDao.getAvailableVersions()
    }
    
    /**
     * Get available categories
     */
    suspend fun getAvailableCategories(): List<String> {
        return questionDao.getAvailableCategories()
    }
    
    /**
     * Get available categories for a specific Java version
     */
    suspend fun getCategoriesByVersion(version: String): List<String> {
        return questionDao.getCategoriesByVersion(version)
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



