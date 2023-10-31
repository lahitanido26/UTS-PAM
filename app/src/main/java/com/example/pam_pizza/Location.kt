package com.example.pam_pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class Location : AppCompatActivity() {

    val CUSTOMER_NAME_EXTRA = "com.example.pam_pizza.extra.CUSTOMER_NAME"
    val SELECTED_OPTION_EXTRA = "com.example.pam_pizza.extra.SELECTED_OPTION"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val seeMenus = findViewById<Button>(R.id.see_menus)

        val intentStore = intent
        val store = intentStore.getStringExtra(SELECTED_OPTION_EXTRA)
        val textView2 = findViewById<TextView>(R.id.store)
        textView2.text = store

        val intent = intent
        val customerName = intent.getStringExtra(CUSTOMER_NAME_EXTRA)
        val textView = findViewById<TextView>(R.id.tv_name_navbar)
        textView.text = customerName

        seeMenus.setOnClickListener {
            val intent = Intent(this, FoodMenu::class.java)
            intent.putExtra(CUSTOMER_NAME_EXTRA, customerName)
            intent.putExtra(SELECTED_OPTION_EXTRA, store)
            startActivity(intent)
        }
    }
}
