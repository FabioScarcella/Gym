package com.fabio.scarcella.dgym

import android.app.ActionBar
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_scrolling.*

class search_ecercises : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_ecercises)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        createNecessaryElements()
        createNecessaryElements()
        //createNecessaryElements()
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