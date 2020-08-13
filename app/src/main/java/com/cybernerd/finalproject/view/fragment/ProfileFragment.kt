package com.cybernerd.cypherxandroid.ui.home.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.utils.debug
import com.cybernerd.finalproject.view.activity.LoginActivity
import com.cybernerd.finalproject.viewModel.EditProfileViewModel
import com.cybernerd.finalproject.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var viewModel: ProfileViewModel
    lateinit var EditviewModel: EditProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        EditviewModel = ViewModelProvider(this).get(EditProfileViewModel::class.java)


        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getProfile()
        viewModel.profileLiveData.observe(viewLifecycleOwner, Observer {
//            debug("Profile","Fragment Profile : ${it.user}")
            profileName.setText(it.user.first_name)
            profileEmail.setText(it.user.email)
            profileRole.setText(it.user.role.role)
            profilePhone.setText(it.user.mobile)
            profileDepartment.setText(it.user.department.name)
//            profileId.setText(it.user.id)

            val name = it.user.first_name
            val email = it.user.email
            val role = it.user.role.role
            val mobile = it.user.mobile
            val department = it.user.department.name
            val id = it.user.id
            val date = it.user.birth_date
            val bio : String = it.user.bio
            val last = it.user.last_login


//            profileSave.setOnClickListener {
//                EditviewModel.editProfile(id, name, last, bio, mobile, email, date as String)
//            }

        })


        btnProfileLogout.setOnClickListener {
            val intent = Intent(context!!, LoginActivity::class.java)
            context!!.startActivity(intent)
        }



        super.onViewCreated(view, savedInstanceState)
    }

}
