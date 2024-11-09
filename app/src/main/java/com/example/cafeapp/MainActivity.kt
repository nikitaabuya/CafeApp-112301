package com.example.cafeapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var mOrderMessage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        private fun displayToast(message: String) {
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
        fun showDonutOrder(view: View) {
            mOrderMessage = "You ordered a donut."
            displayToast(mOrderMessage)
        }
        fun showIceCreamOrder(view: View) {
            mOrderMessage = "You ordered a Ice cream sandwich."
            displayToast(mOrderMessage)
        }
        fun showFroyoOrder(view: View) {
            mOrderMessage = "You ordered a Froyo."
            displayToast(mOrderMessage)
        }

        fun startOrder(view: View) {
            Snackbar.make(view, "Not yet implemented Order functionality", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }
}