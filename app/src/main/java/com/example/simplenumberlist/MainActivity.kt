package com.example.simplenumberlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNumber = findViewById<EditText>(R.id.editNumber)
        val itemList = arrayListOf<Int>()
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonShow = findViewById<Button>(R.id.showButton)

        // Show button click listener
        buttonShow.setOnClickListener {
            // Clear the list before each use
            itemList.clear()

            // Get the number from the EditText
            val number = editNumber.text.toString().toIntOrNull()
            if (number == null || number < 0) {
                editNumber.error = "Please enter a valid number"
                return@setOnClickListener
            }

            // Get the selected RadioButton
            when (radioGroup.checkedRadioButtonId) {
                R.id.radioButton -> {
                    for (i in 1..number) {
                        if (i % 2 != 0) itemList.add(i)
                    }
                }

                R.id.radioButton2 -> {
                    for (i in 0..number) {
                        if (i % 2 == 0) itemList.add(i)
                    }
                }

                R.id.radioButton3 -> {
                    for (i in 0..number) {
                        val sqrt = Math.sqrt(i.toDouble())
                        if (sqrt == sqrt.toInt().toDouble()) itemList.add(i)
                    }
                }
            }

            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = NumberAdapter(itemList)
        }
    }
}