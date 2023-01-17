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

class musicactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musicactivity)
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
        var firstsong = findViewById<ImageView>(R.id.song1)
        var secondsong = findViewById<ImageView>(R.id.song2)
        var thirdsong = findViewById<ImageView>(R.id.song3)
        var fourthsong = findViewById<ImageView>(R.id.song4)

        firstsong.setOnClickListener{
            TeenageActivity()
        }
        secondsong.setOnClickListener{
            SomeActivity()
        }
        thirdsong.setOnClickListener{
            dandelionsActivity()
        }
        fourthsong.setOnClickListener{
            christmasActivity()
        }
    }
    public fun TeenageActivity(){
        startActivity(Intent(this@musicactivity, songOneActivity::class.java))
        overridePendingTransition(
            androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
    public fun SomeActivity(){
        startActivity(Intent(this@musicactivity, songTwoActivity::class.java))
        overridePendingTransition(
            androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
    public fun dandelionsActivity(){
        startActivity(Intent(this@musicactivity, songThreeActivity::class.java))
        overridePendingTransition(
            androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
    public fun christmasActivity(){
        startActivity(Intent(this@musicactivity, songFourActivity::class.java))
        overridePendingTransition(
            androidx.appcompat.R.anim.abc_fade_in,
            androidx.appcompat.R.anim.abc_fade_out)
    }
}
