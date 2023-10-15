package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R.id.button
import com.example.myapplication.R.id.countertxt


class MainActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var seeText: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counterValue", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val data = savedInstanceState.getInt("counterValue")
        seeText.text = "Counter: $data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        seeText = findViewById<TextView>(R.id.countertxt)
        val button = findViewById<Button>(button)
        val resetButton = findViewById<Button>(R.id.ResetButton)

        //Click button logic
        button.setOnClickListener() {
            // when we click this button counter will add 1 number
            counter++
            seeText.text = "Counter: $counter"
        }

        //Reset button logic
        resetButton.setOnClickListener() {
            //when user click the button, counter will just reset
            counter = 0
            seeText.text = "Counter: $counter"
        }
    }
}