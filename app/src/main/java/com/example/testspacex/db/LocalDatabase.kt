package com.example.testspacex.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testspacex.model.SpaceXModelItem
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    version = 1, entities = [SpaceXModelItem::class],
    exportSchema = false
)
abstract class LocalDatabase():RoomDatabase() {

    abstract fun spaceXDao():SpaceXDao

    companion object{
        var localDatabaseInstance:LocalDatabase? = null

        @InternalCoroutinesApi
        @Synchronized
        fun getInstance(context: Context):LocalDatabase{
            if (localDatabaseInstance == null){
                synchronized(LocalDatabase::class.java){
                    localDatabaseInstance = Room.databaseBuilder(
                        context,LocalDatabase::class.java,"spacedb"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return localDatabaseInstance as LocalDatabase
        }
    }
}