package com.andgopa.myroomtest.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 *  Created by Andres Gonzalez on 1/5/21.
 *  Copyright (c) 2020 City Electric Supply. All rights reserved.
 */
@Dao
interface WordDao {
    @Query("SELECT * FROM word ORDER BY word ASC")
    fun selectAllWords(): List<Word>

    @Insert
    suspend fun insertWord(word: Word)

    @Delete
    fun deleteWord(word: Word)
}