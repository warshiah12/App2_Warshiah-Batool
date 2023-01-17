package com.example.paint_app

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_yourname.*

class yourname : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yourname)
        val button = findViewById<Button>(R.id.about)

        button.setOnClickListener{
            val dialogBinding = layoutInflater.inflate(R.layout.popup,null)
            val myInfo = Dialog(this)
            myInfo.setContentView(dialogBinding)

            myInfo.setCancelable(true)
            myInfo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myInfo.show()
        }
    }

    fun submitbtn(view: View){
      val name = user_name.text.toString()
        if(userinput(name)) {
            val intent = Intent(this@yourname, MainActivity::class.java)
            intent.putExtra("Name", name)
            startActivity(intent)
            overridePendingTransition(
                androidx.appcompat.R.anim.abc_fade_in,
                androidx.appcompat.R.anim.abc_fade_out
            )
        }
    }

    private fun userinput(name:String?):Boolean{
        return when{
            name.isNullOrEmpty() -> {
                Toast.makeText(this,"Name field is required", Toast.LENGTH_LONG).show()
                return false
            }
            else -> {
                return true
            }
        }
    }
}