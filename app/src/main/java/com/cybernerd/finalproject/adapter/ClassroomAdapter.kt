package com.cybernerd.finalproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.model.Detail
import com.cybernerd.finalproject.utils.debug
import com.cybernerd.finalproject.view.activity.ChatRoomActivity
import kotlinx.android.synthetic.main.rv_classroom_child.view.*

class ClassroomAdapter(private val context: Context) :
    RecyclerView.Adapter<ClassroomAdapter.ViewHolder>(){

    private var list: List<Detail> = ArrayList()

    fun setClassroom(list: List<Detail>){
        this.list = list
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassroomAdapter.ViewHolder {
        return ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.rv_classroom_child, parent, false)
        )
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name = view.tv_classroom_name!!
        val description = view.tv_classroom_description!!
        val rootView = view.childRoot!!

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ClassroomAdapter.ViewHolder, position: Int) {

        holder.name.text = list[position].name
        holder.description.text = list[position].description
        holder.rootView.setOnClickListener {
            val intent = Intent(context, ChatRoomActivity::class.java)
            intent.putExtra("name",list[position].name)
            intent.putExtra("description",list[position].description)
            context.startActivity(intent)
            debug("click","bhai click ho raha hai ispe : ${holder.rootView}")
        }
    }

}