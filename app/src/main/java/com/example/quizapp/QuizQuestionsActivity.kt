package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {


    private var mCurrentPosition:Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mCorrectAnswers:Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener{
            selectedOptionView(tv_option_one,1)
        }
        tv_option_two.setOnClickListener{
            selectedOptionView(tv_option_two,2)
        }
        tv_option_three.setOnClickListener{
            selectedOptionView(tv_option_three,3)
        }
        tv_option_four.setOnClickListener{
            selectedOptionView(tv_option_four,4)
        }
        btn_submit.setOnClickListener{
            if(mSelectedOptionPosition!=0){
                val question = mQuestionList!![mCurrentPosition-1]
                if(mSelectedOptionPosition!= question.correctAnswer){
                    answerView(mSelectedOptionPosition, R.drawable.wopb)
                } else {
                    mCorrectAnswers++
                }
                answerView(question.correctAnswer, R.drawable.copb)
                if(mCurrentPosition == mQuestionList!!.size)
                    btn_submit.text = "FINISH"
                else
                    btn_submit.text = "GO TO NEXT QUESTION"
            } else {
                mCurrentPosition++
                when{
                    mCurrentPosition <= mQuestionList!!.size->{
                        setQuestion()
                    } else->{
                        var intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, mUserName)
                    intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                    intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)

                    startActivity(intent)
                    finish()
                    }
                }
            }
            mSelectedOptionPosition = 0
        }
    }



     fun setQuestion(){

        val question= mQuestionList!![mCurrentPosition-1]

        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        } else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

     fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.dopb)

        }

    }



     fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

     fun selectedOptionView(tv:TextView,seledtedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = seledtedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.sopb)
    }
}