package com.andgopa.myroomtest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *  Created by Andres Gonzalez on 1/5/21.
 *  Copyright (c) 2020 City Electric Supply. All rights reserved.
 */
@Database(entities = [Word::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(
            context: Context
        ): AppRoomDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "my_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}