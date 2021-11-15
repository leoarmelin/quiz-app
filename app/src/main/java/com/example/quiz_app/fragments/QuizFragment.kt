package com.example.quiz_app.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quiz_app.R
import com.example.quiz_app.databinding.FragmentQuizBinding
import com.example.quiz_app.helper.Constants
import com.example.quiz_app.model.Question
import com.example.quiz_app.viewModel.AppViewModel

class QuizFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentQuizBinding
    private val viewModel: AppViewModel by activityViewModels()
    private var currentPosition = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOption = 0
    private var correctAnswers = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnQuizSubmit.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
        questionsList = Constants.getQuestions()
        val questionData: Question = questionsList!![currentPosition - 1]
        val progressText = "$currentPosition / ${binding.pbProgressQuiz.max}"
        val btnSubmitText = "SUBMIT"

        binding.tvQuestion.text = questionData.question

        binding.ivCountryFlag.setImageResource(questionData.image)

        binding.pbProgressQuiz.progress = currentPosition
        binding.tvProgressQuiz.text = progressText

        binding.tvOptionOne.text = questionData.optionOne
        binding.tvOptionTwo.text = questionData.optionTwo
        binding.tvOptionThree.text = questionData.optionThree
        binding.tvOptionFour.text = questionData.optionFour

        binding.btnQuizSubmit.text = btnSubmitText
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = activity?.let {
                ContextCompat.getDrawable(
                    it,
                    R.drawable.default_option_border_bg
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        selectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = activity?.let {
            ContextCompat.getDrawable(
                it,
                R.drawable.selected_option_border_bg
            )
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.tvOptionOne.background =
                    activity?.let { ContextCompat.getDrawable(it, drawableView) }
                binding.tvOptionOne.setTextColor(Color.parseColor("#FFFFFF"))
            }
            2 -> {
                binding.tvOptionTwo.background =
                    activity?.let { ContextCompat.getDrawable(it, drawableView) }
                binding.tvOptionTwo.setTextColor(Color.parseColor("#FFFFFF"))
            }
            3 -> {
                binding.tvOptionThree.background =
                    activity?.let { ContextCompat.getDrawable(it, drawableView) }
                binding.tvOptionThree.setTextColor(Color.parseColor("#FFFFFF"))
            }
            4 -> {
                binding.tvOptionFour.background =
                    activity?.let { ContextCompat.getDrawable(it, drawableView) }
                binding.tvOptionFour.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOptionOne -> selectedOptionView(binding.tvOptionOne, 1)
            R.id.tvOptionTwo -> selectedOptionView(binding.tvOptionTwo, 2)
            R.id.tvOptionThree -> selectedOptionView(binding.tvOptionThree, 3)
            R.id.tvOptionFour -> selectedOptionView(binding.tvOptionFour, 4)
            R.id.btnQuizSubmit -> {
                if (binding.btnQuizSubmit.text == "FINISH") {
                    val scoreValue = "$correctAnswers out of ${questionsList?.size}"
                    viewModel.score.postValue(scoreValue)

                    findNavController().navigate(R.id.action_quizFragment_to_trophyFragment)

                    return
                }

                if (selectedOption == 0) {
                    currentPosition++

                    when {
                        currentPosition <= questionsList!!.size -> setQuestion()
                    }
                } else {
                    val question = questionsList?.get(currentPosition - 1)

                    if (question!!.correctAnswer != selectedOption) {
                        answerView(selectedOption, R.drawable.wrong_option_border_bg)
                    } else {
                        correctAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (currentPosition == questionsList!!.size) {
                        val btnSubmitText = "FINISH"
                        binding.btnQuizSubmit.text = btnSubmitText
                    } else {
                        val btnSubmitText = "NEXT QUESTION"
                        binding.btnQuizSubmit.text = btnSubmitText
                    }

                    selectedOption = 0
                }
            }
        }
    }

}