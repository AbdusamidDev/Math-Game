package com.example.mathgame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler
    var number1 = 0
    var number2 = 0
    var operation = 0
    var answer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_answer.addTextChangedListener {
            if (it.toString().length == answer.toString().length) {
                if (it.toString().toInt() == answer) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "InCorrect \n $answer", Toast.LENGTH_SHORT).show()
                }
                tv_answer.text.clear()
                loadQuestion()
            }
        }
    }

    private fun loadQuestion() {
        number1 = Random.nextInt(20)
        number2 = Random.nextInt(20)
        operation = Random.nextInt(4)
        when (operation) {
            0 -> {
                answer = number1 + number2
                question.text = "$number1 + $number2"
            }
            1 -> {
                if (number1 > number2) {
                    answer = number1 - number2
                    question.text = "$number1 - $number2"
                } else {
                    loadQuestion()
                }
            }
            2 -> {
                answer = number1 * number2
                question.text = "$number1 * $number2"
            }
            3 -> {
                if (number1 % number2 == 0 && number2 % number1 != 0) {
                    answer = number1 / number2
                    question.text = "$number1 / $number2"
                } else {
                    loadQuestion()
                }
            }
        }
    }
}