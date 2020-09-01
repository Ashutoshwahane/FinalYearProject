package com.cybernerd.finalproject.viewModel

import android.app.Application
import android.se.omapi.Session
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.ClassroomResponse
import com.cybernerd.finalproject.repository.ClassroomHomeRepository
import com.cybernerd.finalproject.utils.SessionManager


class ClassroomViewModel(application: Application): AndroidViewModel(application){

    lateinit var repository : ClassroomHomeRepository
    val classroomsLiveData : LiveData<ClassroomResponse>
    val studentClassroomsLiveData : LiveData<ClassroomResponse>

    init {

        repository = SessionManager(application).fetchAuthToken()?.let {
            ClassroomHomeRepository(it)
        }!!

        this.classroomsLiveData = repository.classroomLiveData
        this.studentClassroomsLiveData = repository.studentClassroomLiveData

    }

    fun getAllClassroom(){
        repository.getAllClassroom()
    }
    fun getStudentClassroom(){
        repository.getStudentClassroom()
    }
}

