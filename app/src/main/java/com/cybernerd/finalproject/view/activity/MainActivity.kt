package com.cybernerd.finalproject.view.activity

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.adapter.PagerViewAdapter
import com.cybernerd.finalproject.viewModel.MemberViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var homeBtn: ImageButton
    private lateinit var addBtn: ImageButton
    private lateinit var notiBtn: ImageButton
    private lateinit var searchBtn: ImageButton
    private lateinit var profileBtn: ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerViewAdapter: PagerViewAdapter

    private lateinit var memberViewModel: MemberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.isHideOnContentScrollEnabled





        // init views
        mViewPager = findViewById(R.id.mViewPager)
        homeBtn = findViewById(R.id.homeBtnStaff)
        addBtn = findViewById(R.id.addBtnStaff)
        profileBtn = findViewById(R.id.profileBtnStaff)
        searchBtn = findViewById(R.id.searchBtnStaff)
        notiBtn = findViewById(R.id.notificationBtnStaff)



        //onclick listner

        homeBtn.setOnClickListener {
            mViewPager.currentItem = 0

        }

        searchBtn.setOnClickListener {
            mViewPager.currentItem = 1
        }

        addBtn.setOnClickListener {
            mViewPager.currentItem = 2
        }

        notiBtn.setOnClickListener {
            mViewPager.currentItem = 3
        }

        profileBtn.setOnClickListener {
            mViewPager.currentItem = 4
        }

        mPagerViewAdapter = PagerViewAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerViewAdapter
        mViewPager.offscreenPageLimit = 5


        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                changeTabs(position)
            }

        })

        mViewPager.currentItem = 0
        homeBtn.setImageResource(R.drawable.ic_home_pink)



    }

    private fun changeTabs(position: Int) {
        if (position == 0) {
            homeBtn.setImageResource(R.drawable.ic_home_pink)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)




        }
        if (position == 1) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_pink)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)




        }
        if (position == 2) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_pink)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)

        }
        if (position == 3) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_fill)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)

        }
        if (position == 4) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_pink_fill)

        }

    }
}
