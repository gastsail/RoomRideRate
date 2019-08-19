package com.gaston.roomriderate.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Gastón Saillén on 19 August 2019
 */

@Database(entities = [CarRide::class], version = 1, exportSchema = false)
abstract class RideDatabase : RoomDatabase() {

    abstract val rideDatabaseDao: CarRideDao

    companion object {

        @Volatile
        private var INSTANCE: RideDatabase? = null

        fun getInstance(context: Context): RideDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RideDatabase::class.java,
                        "ride_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}