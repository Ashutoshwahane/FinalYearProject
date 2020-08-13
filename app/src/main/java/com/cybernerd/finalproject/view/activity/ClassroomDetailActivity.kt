package com.cybernerd.finalproject.view.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.utils.debug

class ClassroomDetailActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classroom_detail)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        debug("intent","name : $name and description : $description")

        val actionbar = supportActionBar
        actionbar?.title = name
        val bool = true

        supportActionBar?.apply {
            setDefaultDisplayHomeAsUpEnabled(bool)
        }

    }
}
