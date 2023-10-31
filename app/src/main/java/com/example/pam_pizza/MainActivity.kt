package com.example.pam_pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    val CUSTOMER_NAME_EXTRA = "com.example.pam_pizza.extra.CUSTOMER_NAME"
    val SELECTED_OPTION_EXTRA = "com.example.pam_pizza.extra.SELECTED_OPTION"
    val REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val nameInput = findViewById<EditText>(R.id.name)
        val submitButton = findViewById<Button>(R.id.submit)

        var selectedOption = "Option 1" // Default selected option

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                selectedOption = spinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Do nothing
            }
        }

        submitButton.setOnClickListener {
            val intent = Intent(this, Location::class.java)
            val customerName = nameInput.text.toString()
            intent.putExtra(CUSTOMER_NAME_EXTRA, customerName)
            intent.putExtra(SELECTED_OPTION_EXTRA, selectedOption)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}
