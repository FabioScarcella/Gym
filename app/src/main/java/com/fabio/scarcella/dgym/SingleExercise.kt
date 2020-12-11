package com.fabio.scarcella.dgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_single_exercise.*

class SingleExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_exercise)

        val listEntries = listOf<String>("Entry1", "Second", "Third")
        val a = arrayOf("Entry1", "Second", "Third")

       /* val adapter = ArrayAdapter.createFromResource(
            this,
            a.size - 1,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        dropList.adapter = adapter*/
    }
}