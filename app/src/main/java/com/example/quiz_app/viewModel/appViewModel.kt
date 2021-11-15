package com.example.quiz_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    var user_name = MutableLiveData<String>()
    var score = MutableLiveData<String>()
}