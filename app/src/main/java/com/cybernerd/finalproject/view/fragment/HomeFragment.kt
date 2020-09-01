package com.cybernerd.cypherxandroid.ui.home.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.adapter.ClassroomAdapter
import com.cybernerd.finalproject.utils.SessionManager
import com.cybernerd.finalproject.viewModel.ClassroomViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var classroomAdapter: ClassroomAdapter
    private lateinit var viewmodel : ClassroomViewModel
//    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        viewmodel = ViewModelProvider(this).get(ClassroomViewModel::class.java)
        classroomAdapter = ClassroomAdapter(context!!)
//        sessionManager = SessionManager(context!!)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            viewmodel.getAllClassroom()
            viewmodel.classroomsLiveData.observe(viewLifecycleOwner, Observer {
                classroomAdapter.setClassroom(it.details)
            })
            rv_classroom.adapter = classroomAdapter


//        }else{
//            viewmodel.getStudentClassroom()
//            viewmodel.studentClassroomsLiveData.observe(viewLifecycleOwner, Observer {
//                classroomAdapter.setClassroom(ArrayList(it.details))
//            })
//            rv_classroom.adapter = classroomAdapter
//        }



        super.onViewCreated(view, savedInstanceState)
    }

}
