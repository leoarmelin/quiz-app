package com.example.quiz_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quiz_app.R
import com.example.quiz_app.databinding.FragmentLoginBinding
import com.example.quiz_app.viewModel.AppViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            if (binding.tvInput.text?.isNotEmpty() == false) {
                Toast.makeText(activity, "Name field must be filled", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            viewModel.user_name.postValue(binding.tvInput.text.toString())

            findNavController().navigate(R.id.action_loginFragment_to_quizFragment)
        }
    }

}