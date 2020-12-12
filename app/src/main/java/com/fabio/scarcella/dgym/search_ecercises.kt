package com.fabio.scarcella.dgym

import android.app.ActionBar
import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.util.Log.ASSERT
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonArray
import kotlinx.android.synthetic.main.content_scrolling.*
import java.io.BufferedReader
import java.io.File
import java.lang.StringBuilder

class search_ecercises : AppCompatActivity() {
    var section: String? = null
    var sectionExercises = listOf<JsonArray>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_ecercises)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        val b : Bundle? = intent.extras
        val exercise = b?.getString("class")

        if (exercise != null) {
            getExercises(exercise)
        }
    }

    fun getExercises(path: String){
        val assetsManager: AssetManager = getAssets()
        var files = listOf<String>()

        when(path) {
            "Biceps" -> {
                val listFolders = ListFolders()
                files = listFolders.biceps
            }

            "Triceps" -> {

            }

            "Forearm" -> {

            }

            "Trapezium" -> {

            }
        }

        var i = 0
        for(element in files){
            val file = element
            if(file.isEmpty()){
                continue
            }
            val gson = Gson()
            val inputString = applicationContext.assets.open("ExercisesInfo/$path/$file").bufferedReader().use {
                it.readText()
            }
            val jsonString = gson.fromJson(inputString, ExercisesInfo::class.java)

            createNecessaryElements(jsonString.name.toString(), file, jsonString)
        }
    }

    fun createNecessaryElements(name: String, fileName: String, jsonString : ExercisesInfo){
        val linearLayout: LinearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.HORIZONTAL

        val imgView : ImageView = ImageView(this)
        imgView.setImageResource(R.drawable.ic_launcher_foreground)
        imgView.setLayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))

        val btnGo: Button = Button(this)
        btnGo.textSize = 12f
        btnGo.text = name
        btnGo.setLayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        btnGo.setOnClickListener {
            val intent = Intent(this, SingleExercise::class.java)
            intent.putExtra("name", jsonString.name)
            intent.putExtra("observations", jsonString.Observations)
            intent.putExtra("textInformation", jsonString.textInformation)
            intent.putExtra("videoURL", jsonString.videoURL)
            startActivity(intent)
        }

        layoutVertical.addView(linearLayout)
        linearLayout.addView(imgView)
        linearLayout.addView(btnGo)
    }
}