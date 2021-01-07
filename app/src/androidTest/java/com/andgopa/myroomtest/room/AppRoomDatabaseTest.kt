package com.andgopa.myroomtest.room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test

const val WORD_1 = "word_1"
const val WORD_2 = "word_2"

class AppRoomDatabaseTest {

    private lateinit var db: AppRoomDatabase
    private lateinit var wordDao: WordDao

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppRoomDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        wordDao = db.wordDao()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetWord() = runBlocking {
        val word = Word(WORD_1)
        wordDao.insertWord(word)
        val allWords = wordDao.selectAllWords()
        assertThat(allWords[0].word, `is`(WORD_1))
    }

    @Test
    @Throws(Exception::class)
    fun getAllWords() = runBlocking {
        val word = Word(WORD_1)
        wordDao.insertWord(word)
        val word2 = Word(WORD_2)
        wordDao.insertWord(word2)
        val allWords = wordDao.selectAllWords()
        assertThat(allWords[0].word, `is`(WORD_1))
        assertThat(allWords[1].word, `is`(WORD_2))
    }
}