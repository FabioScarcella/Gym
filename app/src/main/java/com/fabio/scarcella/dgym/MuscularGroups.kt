package com.fabio.scarcella.dgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_muscular_groups2.*

class MuscularGroups : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muscular_groups2)

        biceps.setOnClickListener {
            searchExercises("Biceps")
        }

        forearm.setOnClickListener {
            searchExercises("Forearm")
        }

        triceps.setOnClickListener {
            searchExercises("Triceps")
        }

        trapezium.setOnClickListener {
            searchExercises("Trapezium")
        }

    }


    fun searchExercises(exercise:String){
        val intent = Intent(this, search_ecercises::class.java)
        intent.putExtra("class", exercise)
        startActivity(intent)
    }
}