package com.example.quiz_app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quiz_app.R
import com.example.quiz_app.databinding.FragmentTrophyBinding
import com.example.quiz_app.viewModel.AppViewModel

class TrophyFragment : Fragment() {

    private lateinit var binding: FragmentTrophyBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrophyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTrophyFinish.setOnClickListener {
            findNavController().navigate(R.id.action_trophyFragment_to_loginFragment)
        }

        viewModel.user_name.observe(viewLifecycleOwner, { item ->
            binding.tvTrophyName.text = item
        })

        viewModel.score.observe( viewLifecycleOwner, { item ->
            Log.i("Aoba", item)

            val scoreText = "Your score is $item."
            binding.tvTrophyScore.text = scoreText
        })
    }

}