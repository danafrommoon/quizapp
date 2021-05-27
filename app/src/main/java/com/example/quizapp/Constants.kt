package com.example.quizapp

import com.example.quizapp.Question
object Constants{

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_question"
    const val  CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        //1
        val que1:Question = Question(1,
            "Who is maknae of group?",
            R.drawable.chonguk,
            "Chon Chonguk",
            "Park Jimin",
        "Kim Taehyun",
        "Kim Seok Jin",
        1)

        questionList.add(que1)

        //2
        val que2:Question = Question(2,
            "Name of drama, which V debuted as actor?",
            R.drawable.hwarang,
            "Scarlet Heart of Karyo",
            "Hwarang",
            "Empress Ki",
            "Moon clouding",
            2)

        questionList.add(que2)

        //3
        val que3:Question = Question(3,
            "Who is main dancer of group?",
            R.drawable.jh,
            "Chonguk",
            "Jimin",
            "J-Hope",
            "Jin",
            3)

        questionList.add(que3)

        //4
        val que4:Question = Question(4,
            "He danced with ballet elements for song Wings",
            R.drawable.jimin,
            "Chon Chonguk",
            "Park Jimin",
            "Kim Taehyun",
            "Kim Seok Jin",
            2)

        questionList.add(que4)

        //5
        val que5:Question = Question(5,
            "King of real korean charisma",
            R.drawable.jin,
            "Chon Chonguk",
            "Park Jimin",
            "Kim Taehyun",
            "Kim Seok Jin",
            4)

        questionList.add(que5)

        //6
        val que6:Question = Question(6,
            "Who is the team leader?",
            R.drawable.rm,
            "Kim Nam Joon",
            "Park Jimin",
            "Kim Taehyun",
            "Kim Seok Jin",
            1)

        questionList.add(que6)

        //7
        val que7:Question = Question(7,
            "Second name of Suga",
            R.drawable.suga,
            "August D",
            "August S",
            "Agust D",
            "Min Yun Gi",
            3)

        questionList.add(que7)

        return questionList
    }
}