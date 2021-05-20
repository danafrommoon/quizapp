package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

    private var mCurrentPosition:Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        Log.i("Question Size", "${questionsList.size}")

        val currentPosition = 1
        val question:Question? = questionsList[currentPosition -1]
        val progressBar:ProgressBar =findViewById(R.id.progressBar)
        val tv_progress:TextView = findViewById(R.id.tv_progress)
        val tv_question:TextView = findViewById(R.id.tv_question)
        val iv_image:ImageView = findViewById(R.id.iv_image)
        val tv_option_one:TextView = findViewById(R.id.tv_option_one)
        val tv_option_two:TextView = findViewById(R.id.tv_option_two)
        val tv_option_three:TextView = findViewById(R.id.tv_option_three)
        val tv_option_four:TextView = findViewById(R.id.tv_option_four)


        progressBar.progress = currentPosition
        tv_progress.text = "$currentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }
}