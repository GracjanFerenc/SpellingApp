package com.example.spellingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText



class MainActivity : AppCompatActivity() {

    private var mText1: String? = null
    private var mText2: String? = null
    private var mText3: String? = null
    private var mText4: String? = null
    private var mText5: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mText1 = intent.getStringExtra("First")
        mText2 = intent.getStringExtra("Second")
        mText3 = intent.getStringExtra("Third")
        mText4 = intent.getStringExtra("Fourth")
        mText5 = intent.getStringExtra("Fifth")

        fun setTextToRadio(){
            val word1 = findViewById<RadioButton>(R.id.word1)
            val word2 = findViewById<RadioButton>(R.id.word2)
            val word3 = findViewById<RadioButton>(R.id.word3)
            val word4 = findViewById<RadioButton>(R.id.word4)
            val word5 = findViewById<RadioButton>(R.id.word5)
            word1.text = mText1.toString()
            word2.text = mText2.toString()
            word3.text = mText3.toString()
            word4.text = mText4.toString()
            word5.text = mText5.toString()
        }


        setTextToRadio()




        //Initialize
        val submit_btn = findViewById<Button>(R.id.submit_btn)
        val hide_btn = findViewById<Button>(R.id.hide_btn)
        val spelling_txt = findViewById<TextView>(R.id.spelling)
        val input_txt = findViewById<TextInputEditText>(R.id.input_txt)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val setText = findViewById<Button>(R.id.setText)



        input_txt.setVisibility(View.INVISIBLE)

        //Hide views
        fun hidingTxt() {
            if (hide_btn.isPressed) {
                spelling_txt.setVisibility(View.INVISIBLE)
                radioGroup.setVisibility(View.INVISIBLE)
                input_txt.setVisibility(View.VISIBLE)
                setText.setVisibility(View.INVISIBLE)
            } else {
                spelling_txt.setVisibility(View.VISIBLE)
                radioGroup.setVisibility(View.VISIBLE)
            }
        }
        //Button for hiding views
        hide_btn.setOnClickListener { hidingTxt() }

        //onClicking and setting string to textview
        fun onClick() {
            val radioId = radioGroup.checkedRadioButtonId

            val radioButton = findViewById<RadioButton>(radioId)

            spelling_txt.setText(radioButton.getText())
        }
        //Button to set the text from radio button to Textview
        setText.setOnClickListener{onClick()}

        //Submit button
        submit_btn.setOnClickListener(){
            if(spelling_txt.text.toString() == input_txt.text.toString()) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                spelling_txt.setVisibility(View.VISIBLE)
                radioGroup.setVisibility(View.VISIBLE)
                setText.setVisibility(View.VISIBLE)
                input_txt.setVisibility(View.INVISIBLE)
                input_txt.text = null
            }else{
                Toast.makeText(this, "Incorrect, Try Again?", Toast.LENGTH_SHORT).show()
            }
        }

    }

    }
