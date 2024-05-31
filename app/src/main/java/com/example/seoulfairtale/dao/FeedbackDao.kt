package com.example.seoulfairtale.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.seoulfairtale.entity.Feedback

@Dao
interface FeedbackDao {

    @Insert
    suspend fun insert(feedback: Feedback)

    @Query("SELECT * FROM feedbacks")
    suspend fun getAllFeedbacks(): List<Feedback>
}
