package com.example.pam_pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodMenu : AppCompatActivity() {

    val CUSTOMER_NAME_EXTRA = "com.example.pam_pizza.extra.CUSTOMER_NAME"
    val SELECTED_OPTION_EXTRA = "com.example.pam_pizza.extra.SELECTED_OPTION"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus_foods)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val customerName = intent.getStringExtra(CUSTOMER_NAME_EXTRA)
        val textView = findViewById<TextView>(R.id.tv_name_navbar_act_menus)
        textView.text = customerName

        val store = intent.getStringExtra(SELECTED_OPTION_EXTRA)

        val pizzaItems = listOf(
            FoodProduct("Paperoni Pizza", "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat", R.drawable.pepperoni),
            FoodProduct("Spaghetti", "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental", R.drawable.spaghetti),
            FoodProduct("Burger", "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal", R.drawable.burger),
            FoodProduct("Steak", "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat", R.drawable.steak)
        )

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager

        val adapter = CustomAdapter(pizzaItems)
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener { position ->
            val intent = Intent(this, FoodInformation::class.java)
            intent.putExtra(CUSTOMER_NAME_EXTRA, customerName)
            intent.putExtra(SELECTED_OPTION_EXTRA, store)
            startActivity(intent)
        }
    }
}
