package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding


private const val TAG = "OYA"
class MainActivity : AppCompatActivity(), View.OnClickListener {

    var text = ""
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btn10.setOnClickListener(this)
        binding.btn11.setOnClickListener(this)
        binding.btn12.setOnClickListener(this)
        binding.btn13.setOnClickListener(this)
        binding.btn14.setOnClickListener(this)
        binding.ans.setOnClickListener(this)
        binding.btn16.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if(v != binding.ans){
            val btn: Button = v as Button
             text += btn.text
            Log.d(TAG, "onClick: $text")
            binding.text.editText!!.append(text)
        }else{
            //iterate over the typed word to get the signs used
            val signsUsed = ArrayList<Char>()
            for (i in text.indices){
                if(!text[i].isDigit() && text[i] != '.'){
                    signsUsed.add(text[i])
                }
            }
            Log.d(TAG, "sign: $signsUsed")
            //splitting the text based on the sign
            val splittedText = text.split("${signsUsed[signsUsed.size - 1]}")
            Log.d(TAG, "answer: $splittedText")

            if(signsUsed[signsUsed.size - 1] == 'x'){
                val answer = splittedText[0].toDouble() * splittedText[1].toDouble()
                Log.d(TAG, "answer: $answer")
                binding.text.editText!!.setText(answer.toString())
            }

        }
    }

    private fun performCalculation(text: String,signsUsed: ArrayList<Any>){
        //splitting the text based on the sign
        val splittedText = text.split("${signsUsed[signsUsed.size - 1]}")
        Log.d(TAG, "answer: $splittedText")

        if(signsUsed[signsUsed.size - 1] == "x"){
            val answer = splittedText[0].toDouble() * splittedText[1].toDouble()
            Log.d(TAG, "answer: $answer")
        }


    }

}