package com.cybernerd.finalproject.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.utils.SessionManager
import com.cybernerd.finalproject.utils.debug
import com.cybernerd.finalproject.viewModel.LoginActivityViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginActivityViewModel
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginActivityViewModel::class.java)  // ************** ye line pr


        sessionManager = SessionManager(this)


        // login to api
        login_button.setOnClickListener {
            if (et_email.text!!.isNotEmpty()){

                viewModel.login(et_email.text.toString(), et_password.text.toString())

            }
        }

        // showing progress bar while calling only
        viewModel.showprogress.observe(this, Observer {
            if (it){
                login_progressbar.visibility = VISIBLE
            }else{
                login_progressbar.visibility = GONE
            }
        })

        // save token
        viewModel.loginData.observe(this, Observer {
            sessionManager.saveAuthToken(it.token)
            debug("token",sessionManager.fetchAuthToken().toString())
            if (it != null){
                startActivity(Intent(this,
                    MainActivity::class.java))
                finish()
            }
        })





    }
}
