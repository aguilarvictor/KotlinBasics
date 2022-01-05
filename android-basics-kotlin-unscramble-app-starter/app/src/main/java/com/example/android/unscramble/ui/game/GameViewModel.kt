package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
/*
* ViewModel is an abstract class, so you need to extend it to use it in your app.
*/
class GameViewModel : ViewModel() {
    private var _score = 0
    private var _currentWordCount = 0
    private lateinit var _currentScrambledWord: String
    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    val currentScrambledWord: String
        get() = _currentScrambledWord

    val currentWordCount: Int
        get() = _currentWordCount

    val score: Int
        get() = _score
    /*
    * Updates currentWord and currentScrambledWord with the next word.
    */
    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        while (String(tempWord).equals(currentWord, false)){
            tempWord.shuffle()
        }

        if(wordList.contains(currentWord)){
            getNextWord()
        } else{
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }

    private fun increaseScore(){
        _score += SCORE_INCREASE
    }

    /*
    * Returns true if the current word count is less than MAX_NO_OF_WORDS.
    * Updates the next word.
    */
    fun nextWord(): Boolean{
        return if (currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            true
        }else{
            false
        }
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if(playerWord.equals(currentWord,true)){
            increaseScore()
            return true
        }
        return false
    }

    /*
    * Re-initializes the game data to restart the game.
    */
    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordList.clear()
        getNextWord()
    }

    /*
    * Initializer block provided by Kotlin
    */
    init {
        Log.d("GameFragment", "GameViewModel Created!")
        getNextWord()
    }

    /*
    * Right before the ViewModel is destroyed, the onCleared() callback is called.
    */
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel Destroyed!")
    }
}