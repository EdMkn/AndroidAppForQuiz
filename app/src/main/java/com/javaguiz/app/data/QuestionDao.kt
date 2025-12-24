package com.javaguiz.app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for question database operations
 */
@Dao
interface QuestionDao {
    /**
     * Get all questions as a Flow (reactive)
     */
    @Query("SELECT * FROM questions ORDER BY id")
    fun getAllQuestions(): Flow<List<QuestionEntity>>
    
    /**
     * Get all questions synchronously (for initialization)
     */
    @Query("SELECT * FROM questions ORDER BY id")
    suspend fun getAllQuestionsSync(): List<QuestionEntity>
    
    /**
     * Get questions filtered by Java version as a Flow
     */
    @Query("SELECT * FROM questions WHERE javaVersion = :version ORDER BY id")
    fun getQuestionsByVersion(version: String): Flow<List<QuestionEntity>>
    
    /**
     * Get questions filtered by Java version synchronously
     */
    @Query("SELECT * FROM questions WHERE javaVersion = :version ORDER BY id")
    suspend fun getQuestionsByVersionSync(version: String): List<QuestionEntity>
    
    /**
     * Get a single question by ID
     */
    @Query("SELECT * FROM questions WHERE id = :id")
    suspend fun getQuestionById(id: Int): QuestionEntity?
    
    /**
     * Get distinct Java versions available in the database
     */
    @Query("SELECT DISTINCT javaVersion FROM questions ORDER BY CASE WHEN javaVersion = 'Core' THEN 0 WHEN javaVersion = '8' THEN 1 ELSE CAST(javaVersion AS INTEGER) END DESC")
    suspend fun getAvailableVersions(): List<String>
    
    /**
     * Insert a single question
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionEntity)
    
    /**
     * Insert multiple questions (bulk insert)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuestionEntity>)
    
    /**
     * Delete all questions
     */
    @Query("DELETE FROM questions")
    suspend fun deleteAllQuestions()
    
    /**
     * Get total count of questions
     */
    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getQuestionCount(): Int
}


