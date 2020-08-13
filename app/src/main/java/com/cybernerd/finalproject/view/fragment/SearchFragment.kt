package com.cybernerd.cypherxandroid.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.adapter.StudentAdapter
import com.cybernerd.finalproject.adapter.TeacherAdapter
import com.cybernerd.finalproject.repository.AutoCompleteRepository
import com.cybernerd.finalproject.viewModel.AutoCompleteViewModel
import com.cybernerd.finalproject.viewModel.StudentViewModel
import com.cybernerd.finalproject.viewModel.TeacherViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var viewModel: StudentViewModel
    private lateinit var teacherViewModel: TeacherViewModel

    private lateinit var autoCompleteViewModel: AutoCompleteViewModel
    private lateinit var autoCompleteRepository: AutoCompleteRepository

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var teacherAdapter: TeacherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        autoCompleteViewModel = ViewModelProvider(this).get(AutoCompleteViewModel::class.java)
        teacherViewModel = ViewModelProvider(this).get(TeacherViewModel::class.java)
        studentAdapter = StudentAdapter(context!!)
        teacherAdapter = TeacherAdapter(context!!)

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getAllStudent()
        viewModel.studentLiveData.observe(viewLifecycleOwner, Observer {
                studentAdapter.setStudent(it.results)
//            debug("debugging","it : $it")
        })
        rv_members.adapter = studentAdapter

        teacherViewModel.getAllTeacher()
        teacherViewModel.teachertLiveData.observe(viewLifecycleOwner, Observer {
            teacherAdapter.setStudent(it.results)
        })
        rv_staffroom.adapter = teacherAdapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tv_search.setOnClickListener {
            autoCompleteViewModel.autoCompleteData(tv_search.text.toString())
            autoCompleteViewModel.autoCompleteData.observe(viewLifecycleOwner, Observer {
                for (i in it){
                    tv_search.setText(i.name)

                }
            })
        }
    }

}
