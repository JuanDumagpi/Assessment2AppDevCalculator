package com.example.metric2murica_temp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.metric2murica_temp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var editTextC: EditText
    private lateinit var textF: TextView
    private lateinit var editTextF: EditText
    private lateinit var textC: TextView
    private lateinit var binding: ActivityMainBinding
    private lateinit var tutorialPopUpView: tutorialPopUp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //This will pop up a modal when you click the help button on the lower right
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonTut.setOnClickListener{
            tutorialPopUp().show(supportFragmentManager, "newTaskTag")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonTutorial)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //this will call the computeF function everytime the edittextview for celsius is changed
        editTextC = findViewById(R.id.editTextC)
        textF = findViewById(R.id.textF)
        editTextC.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                computeF()
            }

        })
        //same as above but call the computeC function instead when the edit text view for fahrenheit is changed
        editTextF = findViewById(R.id.editTextF)
        textC = findViewById(R.id.textC)
        editTextF.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                computeC()
            }

        })

    }



    private fun computeF() {
        //computes for the Fahrenheit value when we type a number into the celsius edit text
        val baseCelsius = editTextC.text.toString().toDouble()
        val newFahrenheit = (baseCelsius * 1.8) + 32

        //changes the textF textview to the result and concatenates the F symbol with it
        val fSymbol = "F"
        val fahrenheitValue = newFahrenheit.toInt()
        textF.text = "$fahrenheitValue $fSymbol"

    }

    private fun computeC() {
        //computes for the Celsius value when we type a number into the fahrenheit edit text
        val baseFahrenheit = editTextF.text.toString().toDouble()
        val newCelsius = (baseFahrenheit - 32) / 1.8

        //changes the textC textview to the result and concatenates the C symbol with it
        val cSymbol = "C"
        val celsiusValue = newCelsius.toInt()
        textC.text = "$celsiusValue $cSymbol"
    }
}