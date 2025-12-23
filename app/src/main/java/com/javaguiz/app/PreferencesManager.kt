package com.javaguiz.app

import android.content.Context
import android.content.SharedPreferences

/**
 * Manages user preferences for the app
 * Similar to localStorage in web development
 */
class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "JavaQuizzPreferences"

        // Preference keys
        const val KEY_QUESTION_COUNT = "question_count"
        const val KEY_DARK_MODE = "dark_mode"
        const val KEY_SOUND_ENABLED = "sound_enabled"
        const val KEY_VIBRATION_ENABLED = "vibration_enabled"
        
        // Default values
        const val DEFAULT_QUESTION_COUNT = 10
        const val DEFAULT_DARK_MODE = false
        const val DEFAULT_SOUND_ENABLED = true
        const val DEFAULT_VIBRATION_ENABLED = true
    }



    /**
     * Get number of questions per quiz
     */
    fun getQuestionCount(): Int {
        return prefs.getInt(KEY_QUESTION_COUNT, DEFAULT_QUESTION_COUNT)
    }
    
    /**
     * Set number of questions per quiz
     */
    fun setQuestionCount(count: Int) {
        prefs.edit().putInt(KEY_QUESTION_COUNT, count).apply()
    }
    
    /**
     * Check if dark mode is enabled
     */
    fun isDarkModeEnabled(): Boolean {
        return prefs.getBoolean(KEY_DARK_MODE, DEFAULT_DARK_MODE)
    }
    
    /**
     * Set dark mode preference
     */
    fun setDarkModeEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_DARK_MODE, enabled).apply()
    }
    
    /**
     * Check if sound is enabled
     */
    fun isSoundEnabled(): Boolean {
        return prefs.getBoolean(KEY_SOUND_ENABLED, DEFAULT_SOUND_ENABLED)
    }
    
    /**
     * Set sound preference
     */
    fun setSoundEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_SOUND_ENABLED, enabled).apply()
    }
    
    /**
     * Check if vibration is enabled
     */
    fun isVibrationEnabled(): Boolean {
        return prefs.getBoolean(KEY_VIBRATION_ENABLED, DEFAULT_VIBRATION_ENABLED)
    }
    
    /**
     * Set vibration preference
     */
    fun setVibrationEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_VIBRATION_ENABLED, enabled).apply()
    }
}