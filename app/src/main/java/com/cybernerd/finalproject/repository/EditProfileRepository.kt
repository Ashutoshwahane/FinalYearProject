package com.cybernerd.finalproject.repository

import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.EditProfile
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileRepository(val token: String) {

    var editprofileData = MutableLiveData<EditProfile>()


    fun editProfile(id : Int, first_name: String, last_name:String, bio:String, mobile:String, email:String, date: String){

        CypherXAPI().editProfile(token, id, first_name, last_name, email, mobile, bio, date).enqueue(object :
            Callback<EditProfile>{
            override fun onFailure(call: Call<EditProfile>, t: Throwable) {
                debug("edit","error : ${t.message}")
            }

            override fun onResponse(call: Call<EditProfile>, response: Response<EditProfile>) {
                editprofileData.value = response.body()
                debug("edit","edit Response : ${response.body()}")
            }

        })


    }

}