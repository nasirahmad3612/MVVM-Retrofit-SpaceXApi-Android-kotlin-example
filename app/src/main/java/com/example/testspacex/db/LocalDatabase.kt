package com.example.testspacex.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testspacex.model.SpaceXModelItem

@Database(
    version = 1, entities = [SpaceXModelItem::class],
    exportSchema = false
)
abstract class LocalDatabase():RoomDatabase() {

}