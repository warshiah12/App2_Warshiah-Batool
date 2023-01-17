package com.example.paint_app

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = getIntent()
        val name=intent.getStringExtra("Name")
        getname.text="Welcome " +name
        val button = findViewById<Button>(R.id.about)

        button.setOnClickListener{
            val dialogBinding = layoutInflater.inflate(R.layout.popup,null)
            val myInfo = Dialog(this)
            myInfo.setContentView(dialogBinding)

            myInfo.setCancelable(true)
            myInfo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myInfo.show()
        }
        clickListener()
    }

    public fun clickListener(){
        var imagemusic = findViewById<ImageView>(R.id.music)
        var imagepaint = findViewById<ImageView>(R.id.paint)

        imagemusic.setOnClickListener{
            openMusicActivity()
        }
        imagepaint.setOnClickListener{
            openPaintActivity()
        }
    }
    public fun openPaintActivity(){
        startActivity(Intent(this@MainActivity, paintactivity::class.java))
        overridePendingTransition(
            androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
    public fun openMusicActivity(){
        startActivity(Intent(this@MainActivity, musicactivity::class.java))
        overridePendingTransition(
            androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
}