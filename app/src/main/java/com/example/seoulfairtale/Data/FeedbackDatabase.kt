package com.example.seoulfairtale.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.seoulfairtale.Reservation
import com.example.seoulfairtale.ReservationDao
import com.example.seoulfairtale.dao.FeedbackDao
import com.example.seoulfairtale.entity.Feedback

@Database(entities = [Reservation::class, Feedback::class], version = 1, exportSchema = false)
abstract class ReservationDatabase : RoomDatabase() {

    abstract fun reservationDao(): ReservationDao
    abstract fun feedbackDao(): FeedbackDao

    companion object {
        @Volatile
        private var INSTANCE: ReservationDatabase? = null

        fun getDatabase(context: Context): ReservationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReservationDatabase::class.java,
                    "reservation_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
