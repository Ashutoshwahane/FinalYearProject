package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.EditProfile
import com.cybernerd.finalproject.model.Profile
import com.cybernerd.finalproject.repository.EditProfileRepository
import com.cybernerd.finalproject.repository.ProfileRepository
import com.cybernerd.finalproject.utils.SessionManager

class EditProfileViewModel(application: Application): AndroidViewModel(application) {

    lateinit var repository : EditProfileRepository
    val editProfileLiveData : LiveData<EditProfile>

    init {
        repository = SessionManager(application).fetchAuthToken()?.let {
            EditProfileRepository(it)
        }!!
        this.editProfileLiveData = repository.editprofileData
    }

    fun editProfile(id : Int, first_name: String, last_name:String, bio:String, mobile:String, email:String, date: String){
        repository.editProfile(id, first_name, last_name, bio, mobile, email, date)
    }
}