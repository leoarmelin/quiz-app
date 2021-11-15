package com.example.quiz_app.helper

import com.example.quiz_app.model.Question
import com.example.quiz_app.R

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val qOne = Question(
            1,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionsList.add(qOne)

        val qTwo = Question(
            2, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )

        questionsList.add(qTwo)


        val qThree = Question(
            3, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )

        questionsList.add(qThree)


        val qFour = Question(
            4, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )

        questionsList.add(qFour)


        val qFive = Question(
            5, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )

        questionsList.add(qFive)


        val qSix = Question(
            6, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1
        )

        questionsList.add(qSix)


        val qSeven = Question(
            7, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3
        )

        questionsList.add(qSeven)


        val qEight = Question(
            8, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )

        questionsList.add(qEight)


        val qNine = Question(
            9, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            2
        )

        questionsList.add(qNine)


        val qTen = Question(
            10, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
            1
        )

        questionsList.add(qTen)

        return questionsList
    }

}