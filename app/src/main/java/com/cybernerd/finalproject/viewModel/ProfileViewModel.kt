package com.cybernerd.finalproject.viewModel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.Profile
import com.cybernerd.finalproject.repository.ProfileRepository
import com.cybernerd.finalproject.utils.SessionManager

class ProfileViewModel(application: Application): AndroidViewModel(application) {

    lateinit var repository : ProfileRepository
    val profileLiveData : LiveData<Profile>

    init {
        repository = SessionManager(application).fetchAuthToken()?.let {
            ProfileRepository(it)
        }!!
        this.profileLiveData = repository.profileLiveData
    }

    fun getProfile(){
        repository.getProfile()
    }

}