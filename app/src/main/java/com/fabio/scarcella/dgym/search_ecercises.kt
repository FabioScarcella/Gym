package com.fabio.scarcella.dgym

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.util.Log.ASSERT
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
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

        getExercises()

        var i = 0
        for(i in 0..19){
            createNecessaryElements()
        }
    }

    fun onCreate(savedInstanceState: Bundle?, section: String?) {
        this.section = section

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_ecercises)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = section

        getExercises()

        var i = 0
        for(i in 0..19){
            createNecessaryElements()
        }
    }

    fun getExercises(){
        var gson = Gson()
        //val p ="\\app\\src\\main\\assets\\ExercisesInfo\\Biceps\\biceps1.json"
        //val bufferedReader: BufferedReader = File(p).bufferedReader()
        //val inputString = bufferedReader.use { it.readText() }
        val inputString = applicationContext.assets.open("ExercisesInfo/Biceps/biceps1.json").bufferedReader().use {
            it.readText()
        }
        var jsonString = gson.fromJson(inputString, ExercisesInfo::class.java)

        var stringBuilder = StringBuilder("JSONString Details\n----------")
        Log.d("Kotlin", jsonString.name.toString())
        Log.d("Kotlin", jsonString.Observations.toString())
    }

    fun createNecessaryElements(){
        val linearLayout: LinearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.HORIZONTAL

        val imgView : ImageView = ImageView(this)
        imgView.setImageResource(R.drawable.ic_launcher_foreground)
        imgView.setLayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))

        val btnGo: Button = Button(this)
        btnGo.textSize = 12f
        btnGo.text = "Hello world"
        btnGo.setLayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        layoutVertical.addView(linearLayout)
        linearLayout.addView(imgView)
        linearLayout.addView(btnGo)
    }
}