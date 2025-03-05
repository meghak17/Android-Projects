package com.megha.mathgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var textScore : TextView
    lateinit var textLife : TextView
    private lateinit var textTime : TextView

    lateinit var textQuestion : TextView
    private lateinit var editTextAnswer: EditText

    private lateinit var buttonOk : Button
    private lateinit var buttonNext: Button

    private var correctAnswer = 0
    private var userScore = 0
    var userLife = 3

    private lateinit var timer : CountDownTimer
    private val startTimerInMillis : Long = 20000
    var timeLeftInMillis : Long = startTimerInMillis

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar!!.title = "Addition"
        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)
        textQuestion = findViewById(R.id.textViewQuestion)
        editTextAnswer = findViewById(R.id.editTextAnswer)
        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)

        gameContinue()

        buttonOk.setOnClickListener {

            val input  = editTextAnswer.text.toString()

            if (input == "")
            {
                Toast.makeText(applicationContext,"Please write an answer or click the next button",
                    Toast.LENGTH_LONG).show()
            }
            else
            {
                pauseTimer()

                val userAnswer = input.toInt()

                if (userAnswer == correctAnswer)
                {
                    userScore += 10
                    textQuestion.text = "Congratulations, your answer is correct"
                    textScore.text = userScore.toString()
                }
                else
                {
                    userLife--
                    textQuestion.text = "Sorry, your answer is wrong"
                    textLife.text = userLife.toString()
                }
            }

        }

        buttonNext.setOnClickListener {
            pauseTimer()
            resetTimer()

            editTextAnswer.setText("")

            if (userLife == 0)
            {
                Toast.makeText(applicationContext,"Game over",Toast.LENGTH_LONG).show()
                val intent = Intent(this@GameActivity,ResultActivity::class.java)
                intent.putExtra("score",userScore)
                startActivity(intent)
                finish()
            }
            else
            {
                gameContinue()
            }
        }

    }
    @SuppressLint("SetTextI18n")
    fun gameContinue()
    {
        val number1 = Random.nextInt(0,100)
        val number2 = Random.nextInt(0,100)

        textQuestion.text = "$number1 + $number2"

        correctAnswer = number1 + number2

        startTimer()
    }

    private fun startTimer()
    {
        timer = object  : CountDownTimer(timeLeftInMillis,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateText()
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
               pauseTimer()
                resetTimer()
                updateText()

                userLife--
                textLife.text = userLife.toString()
                textQuestion.text = "Sorry,Time is up!"
            }

        }.start()
    }

    fun updateText()
    {
        val remainingTime :Int =(timeLeftInMillis / 1000).toInt()
        textTime.text = String.format(Locale.getDefault(),"%02d",remainingTime)
    }

    fun pauseTimer()
    {
        timer.cancel()
    }

    fun resetTimer()
    {
        timeLeftInMillis = startTimerInMillis
        updateText()
    }
}