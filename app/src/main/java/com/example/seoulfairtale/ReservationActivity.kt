package com.example.seoulfairtale

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservationActivity : AppCompatActivity() {

    private lateinit var reservationDao: ReservationDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val database = ReservationDatabase.getDatabase(this)
        reservationDao = database.reservationDao()

        val nameEditText = findViewById<EditText>(R.id.edittext_name)
        val phoneEditText = findViewById<EditText>(R.id.edittext_phone)
        val dateEditText = findViewById<EditText>(R.id.edittext_date)
        val timeEditText = findViewById<EditText>(R.id.edittext_time)
        val tableNumberEditText = findViewById<EditText>(R.id.edittext_table_number)
        val submitButton = findViewById<Button>(R.id.button_submit_reservation)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val date = dateEditText.text.toString()
            val time = timeEditText.text.toString()
            val tableNumber = tableNumberEditText.text.toString()

            if (phone.isEmpty() || date.isEmpty() || time.isEmpty() || tableNumber.isEmpty()) {
                Toast.makeText(this, "Please fill in all mandatory fields", Toast.LENGTH_SHORT).show()
            } else {
                val reservation = Reservation(name, phone, date, time, tableNumber.toInt())
                saveReservation(reservation)
            }
        }
    }

    private fun saveReservation(reservation: Reservation) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                reservationDao.insert(reservation)
            }
            Toast.makeText(this@ReservationActivity, "Reservation submitted", Toast.LENGTH_SHORT).show()
        }
    }
}
