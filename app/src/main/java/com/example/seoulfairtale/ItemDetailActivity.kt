package com.example.seoulfairtale

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val itemName = intent.getStringExtra("item_name")
        val itemDescription = intent.getStringExtra("item_description")

        findViewById<TextView>(R.id.item_name).text = itemName
        findViewById<TextView>(R.id.item_description).text = itemDescription
    }
}
