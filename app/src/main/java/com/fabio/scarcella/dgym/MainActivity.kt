package com.fabio.scarcella.dgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnExercises.setOnClickListener {
            exercisesActivity()
        }

        btnPredifined.setOnClickListener {
            predifinedActivity()
        }

        btnMRoutines.setOnClickListener {
            mRoutinesActivity()
        }
    }

    fun exercisesActivity(){
        val intent = Intent(this, MuscularGroups::class.java)
        startActivity(intent)
    }

    fun predifinedActivity(){

    }

    fun mRoutinesActivity(){

    }
}