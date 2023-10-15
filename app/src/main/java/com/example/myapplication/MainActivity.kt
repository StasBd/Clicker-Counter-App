package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R.id.ResetButton
import com.example.myapplication.R.id.button
import com.example.myapplication.R.id.countertxt
import com.example.myapplication.R.id.textView2
import org.w3c.dom.Text



class MainActivity : AppCompatActivity() {

    //uploading our variable here:
    var counter = 0
    val seeText = findViewById<TextView>(R.id.countertxt)

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("seeInt", "s")
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
           var seeText = savedInstanceState?.getString("seeInt", "s")


        seeText.text = countertxt
        if(savedInstanceState != null){
            seeText = savedInstanceState.getString("seeInt")
            seeText.text = seeText.toString()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


           // CONNECTING HERE ALL THINGS OF OUR DESIGN

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

