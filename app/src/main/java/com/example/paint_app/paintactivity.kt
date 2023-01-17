package com.example.paint_app

import android.app.Dialog
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.paint_app.draw.Companion.canva
import com.example.paint_app.draw.Companion.colorPalette
import com.example.paint_app.draw.Companion.defaultColor

class paintactivity : AppCompatActivity() {

    companion object{ //using companion object so that we can access these two variables in our class file 'draw.kt'
        var path = Path()
        var cursor = Paint()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paintactivity)
        val button = findViewById<Button>(R.id.about)

        button.setOnClickListener{
            val dialogBinding = layoutInflater.inflate(R.layout.popup,null)
            val myInfo = Dialog(this)
            myInfo.setContentView(dialogBinding)

            myInfo.setCancelable(true)
            myInfo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myInfo.show()
        }
        supportActionBar?.hide()
        val btn1 = findViewById<ImageButton>(R.id.color1)
        val btn2 = findViewById<ImageButton>(R.id.color2)
        val btn3 = findViewById<ImageButton>(R.id.color3)
        val clearbtn = findViewById<ImageButton>(R.id.clear)

        btn1.setOnClickListener{
            Toast.makeText(this,"Yellow",Toast.LENGTH_SHORT).show()
            cursor.setColor((Color.YELLOW))
            currentcursorcolor(cursor.color)
        }
        btn2.setOnClickListener{
            Toast.makeText(this,"Blue",Toast.LENGTH_SHORT).show()
            cursor.setColor((Color.BLUE))
            currentcursorcolor(cursor.color)
        }
        btn3.setOnClickListener{
            Toast.makeText(this,"Green",Toast.LENGTH_SHORT).show()
            cursor.setColor((Color.GREEN))
            currentcursorcolor(cursor.color)
        }
        clearbtn.setOnClickListener{
            Toast.makeText(this,"Cleared",Toast.LENGTH_SHORT).show()
            canva.clear()
            colorPalette.clear()
            path.reset()
        }
    }
    private fun currentcursorcolor(color: Int){
        defaultColor = color
        path = Path()
    }
}