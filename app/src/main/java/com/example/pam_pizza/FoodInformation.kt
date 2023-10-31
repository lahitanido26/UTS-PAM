package com.example.pam_pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class FoodInformation : AppCompatActivity() {


    val CUSTOMER_NAME_EXTRA = "com.example.pam_pizza.extra.CUSTOMER_NAME"
    val SELECTED_OPTION_EXTRA = "com.example.pam_pizza.extra.SELECTED_OPTION"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_information)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val customerName = intent.getStringExtra(CUSTOMER_NAME_EXTRA)
        val selectedOption = intent.getStringExtra(SELECTED_OPTION_EXTRA)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnOrder.setOnClickListener {
            val orderIntent = Intent(this, OrderInformation::class.java)
            orderIntent.putExtra(CUSTOMER_NAME_EXTRA, customerName)
            orderIntent.putExtra(SELECTED_OPTION_EXTRA, selectedOption)
            startActivity(orderIntent)
        }
    }
}
