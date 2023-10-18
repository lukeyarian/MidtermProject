package com.example.midtermproject
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Score::class], version = 1, exportSchema = false)
abstract class ScoreRoomDatabase : RoomDatabase() {
    abstract fun scoreDao(): ScoreDao
    companion object {
        @Volatile
        private var INSTANCE: ScoreRoomDatabase? = null
        fun getDatabase(context: Context): ScoreRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScoreRoomDatabase::class.java,
                    "score_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}