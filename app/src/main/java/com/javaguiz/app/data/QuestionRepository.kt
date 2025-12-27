package com.javaguiz.app.data

import android.content.Context
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlin.collections.emptyList

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

    private suspend fun getQuestionsByVersions(versions: List<String>): List<Question> {
        return if (versions.isEmpty()) {
            emptyList()
        } else {
            questionDao.getQuestionsByVersions(versions).map { it.toQuestion() }
        }
    }
    
    /**
     * Get a random subset of questions filtered by Java version
     */
    suspend fun getRandomQuestionsByVersion(count: Int, javaVersion: String?): List<Question> {
        val allQuestions = getQuestionsByVersion(javaVersion).first()
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
     * Get questions filtered by both versions and category
     */
    suspend fun getQuestionsByVersionsAndCategory(versions: List<String>?, category: String?): List<Question> {
        return try {
            when {
                versions.isNullOrEmpty() && category.isNullOrEmpty() ->
                    getAllQuestions().first()
                versions.isNullOrEmpty() ->
                    getQuestionsByCategory(category!!).first()
                category.isNullOrEmpty() ->
                    getQuestionsByVersions(versions)
                else ->
                    questionDao.getQuestionsByVersionsAndCategory(versions, category)
                        .map { it.toQuestion() } // Convert entities to domain models
            }.let { questions ->
                questions.ifEmpty {
                    Log.w(
                        "QuestionRepository",
                        "No questions found for versions: $versions, category: $category"
                    )
                    emptyList()
                }
            }
        } catch (e: Exception) {
            Log.e("QuestionRepository", "Error getting questions", e)
            emptyList()
        }
    }
    
    /**
     * Get a random subset of questions filtered by version and category
     */
    suspend fun getRandomQuestionsByVersionAndCategory(count: Int, javaVersion: String?, category: String?): List<Question> {
        val allQuestions = getQuestionsByVersionAndCategory(javaVersion, category).first()
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



