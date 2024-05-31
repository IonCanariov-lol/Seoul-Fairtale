package com.example.seoulfairtale

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    private val dishes = listOf(
        "Spaghetti Carbonara",
        "Margherita Pizza",
        "Caesar Salad"
    )

    private val drinks = listOf(
        "Coca Cola",
        "Orange Juice",
        "Red Wine"
    )

    private val desserts = listOf(
        "Tiramisu",
        "Cheesecake",
        "Ice Cream"
    )

    private val descriptions = mapOf(
        "Spaghetti Carbonara" to "Pasta with eggs, cheese, pancetta, and pepper.",
        "Margherita Pizza" to "Pizza with tomatoes, mozzarella cheese, and basil.",
        "Caesar Salad" to "Salad with romaine lettuce, croutons, and Caesar dressing.",
        "Coca Cola" to "A sweetened, carbonated soft drink.",
        "Orange Juice" to "Freshly squeezed juice from oranges.",
        "Red Wine" to "A type of wine made from dark-colored grape varieties.",
        "Tiramisu" to "A coffee-flavored Italian dessert.",
        "Cheesecake" to "A dessert consisting of a mixture of soft, fresh cheese and a bottom layer of graham cracker crust.",
        "Ice Cream" to "A sweetened frozen food typically eaten as a snack or dessert."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val dishesContainer = findViewById<LinearLayout>(R.id.dishes_container)
        val drinksContainer = findViewById<LinearLayout>(R.id.drinks_container)
        val dessertsContainer = findViewById<LinearLayout>(R.id.desserts_container)

        populateMenu(dishesContainer, dishes)
        populateMenu(drinksContainer, drinks)
        populateMenu(dessertsContainer, desserts)
    }

    private fun populateMenu(container: LinearLayout, items: List<String>) {
        val inflater = LayoutInflater.from(this)
        for (item in items) {
            val view = inflater.inflate(android.R.layout.simple_list_item_1, container, false) as TextView
            view.text = item
            view.setOnClickListener {
                val intent = Intent(this, ItemDetailActivity::class.java)
                intent.putExtra("item_name", item)
                intent.putExtra("item_description", descriptions[item])
                startActivity(intent)
            }
            container.addView(view)
        }
    }
}
