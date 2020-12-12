package com.fabio.scarcella.dgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_single_exercise.*

class SingleExercise : AppCompatActivity() {
    var name: String = ""
    var observations: String = ""
    var textInformations: String = ""
    var videoURL: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_exercise)

        val b : Bundle? = intent.extras
        videoURL = b?.getString("videoURL").toString()
        name = b?.getString("name").toString()
        observations = b?.getString("observations").toString()
        textInformations = b?.getString("textInformation").toString()

        //val listEntries = listOf<String>("Entry1", "Second", "Third")
        val a = arrayOf("Entry1", "Second", "Third")

        putInformation()

       val adapter = ArrayAdapter(
           this,
           android.R.layout.simple_spinner_dropdown_item,
           a
       )

        dropList.adapter = adapter
    }


    fun putInformation(){
        val imgID: Int = resources.getIdentifier(videoURL, "drawable", packageName)
        gif.setImageResource(imgID)

        txtHowTo.text = textInformations
        txtObservations.text = observations
        txtName.text = name

    }
}