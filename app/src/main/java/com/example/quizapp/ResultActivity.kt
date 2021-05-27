package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    lateinit var btn_finish:Button
    lateinit var tv_score:TextView
    lateinit var tv_name:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


         btn_finish = findViewById(R.id.btn_finish)
         tv_score = findViewById(R.id.tv_score)
        tv_name = findViewById(R.id.tv_name)

        val username = intent.getStringExtra(Constants.USER_NAME)

        tv_name.text = username

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0 )
        tv_score.text = "Your score is $correctAnswer out of $totalQuestions"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}