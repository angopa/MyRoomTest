package com.andgopa.myroomtest.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  Created by Andres Gonzalez on 1/5/21.
 *  Copyright (c) 2020 City Electric Supply. All rights reserved.
 */
@Entity
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String) {

}