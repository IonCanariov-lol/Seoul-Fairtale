package com.example.seoulfairtale

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.seoulfairtale.dao.FeedbackDao
import com.example.seoulfairtale.data.ReservationDatabase
import com.example.seoulfairtale.entity.Feedback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedbackActivity : AppCompatActivity() {

    private lateinit var feedbackDao: FeedbackDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_give_feedback)

        val database = ReservationDatabase.getDatabase(this)
        feedbackDao = database.feedbackDao()

        val feedbackEditText = findViewById<EditText>(R.id.feedback_edittext)
        val submitButton = findViewById<Button>(R.id.submit_feedback_button)

        submitButton.setOnClickListener {
            val feedbackText = feedbackEditText.text.toString()

            if (feedbackText.isEmpty()) {
                Toast.makeText(this, "Please enter your feedback", Toast.LENGTH_SHORT).show()
            } else {
                val feedback = Feedback(feedbackText = feedbackText)
                saveFeedback(feedback)
            }
        }
    }

    private fun saveFeedback(feedback: Feedback) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                feedbackDao.insert(feedback)
            }
            Toast.makeText(this@FeedbackActivity, "Feedback submitted", Toast.LENGTH_SHORT).show()
            finish() // Close the activity after submitting feedback
        }
    }
}
