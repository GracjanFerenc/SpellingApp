package com.example.spellingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SettingSpellings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_spellings)

        val edittext1 = findViewById<EditText>(R.id.editText1)
        val edittext2 = findViewById<EditText>(R.id.editText2)
        val edittext3 = findViewById<EditText>(R.id.editText3)
        val edittext4 = findViewById<EditText>(R.id.editText4)
        val edittext5 = findViewById<EditText>(R.id.editText5)
        val submit_txt = findViewById<Button>(R.id.submit_txt)

        submit_txt.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("First", edittext1.text.toString() )
            intent.putExtra("Second", edittext2.text.toString() )
            intent.putExtra("Third", edittext3.text.toString() )
            intent.putExtra("Fourth", edittext4.text.toString() )
            intent.putExtra("Fifth", edittext5.text.toString() )
            startActivity(intent)
        }


    }
}