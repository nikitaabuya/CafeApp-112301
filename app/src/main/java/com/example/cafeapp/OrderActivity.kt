package com.example.cafeapp

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {

    private lateinit var orderMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Retrieve the order message from the Intent
        orderMessage = intent.getStringExtra("ORDER_MESSAGE") ?: "No order specified"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the RadioGroup listener
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            val selectedDeliveryMethod = selectedRadioButton.text

            // Show a message with the selected delivery method and the order message
            Toast.makeText(this, "Selected Delivery Method: $selectedDeliveryMethod\nOrder: $orderMessage", Toast.LENGTH_LONG).show()
        }
    }
}