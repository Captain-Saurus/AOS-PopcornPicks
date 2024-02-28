package com.captainsaurus.popcornpicks

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.captainsaurus.popcornpicks.databinding.ActivityMainBinding
import com.captainsaurus.popcornpicks.fragment.HomeFragment
import com.captainsaurus.popcornpicks.fragment.MovieFragment
import com.captainsaurus.popcornpicks.fragment.NormalTicketingFragment
import com.captainsaurus.popcornpicks.fragment.PersonalTicketingFragment
import com.captainsaurus.popcornpicks.fragment.TheaterFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {

    private val TAG = "[MainActivity]"

    private val homeFragment: Fragment = HomeFragment()
    private val movieFragment: Fragment = MovieFragment()
    private val theaterFragment: Fragment = TheaterFragment()
    private val normalTicketingFragment: Fragment = NormalTicketingFragment()
    private val personalTicketingFragment: Fragment = PersonalTicketingFragment()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.d(TAG, "$TAG onCreate()")

        initialize()
        setTabLayout()
    }

    private fun initialize() {
        Log.d(TAG, "$TAG initialize()")

        // 기본 보여지는 상태는 홈화면으로
        supportFragmentManager.beginTransaction().replace(binding.mainTabView.id, homeFragment).commit()

        binding.mainLogoIv.setOnClickListener {
            Log.d(TAG, "$TAG initialize() Logo Click set Home")
            supportFragmentManager.beginTransaction().replace(binding.mainTabView.id, homeFragment).commit()
        }
    }

    private fun setTabLayout() {
        Log.d(TAG, "$TAG setTabLayout()")

        binding.mainNavTl.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d(TAG, "$TAG onTableSelected()")

                when (tab?.position) {
                    0 -> {
                        Log.d(TAG, "$TAG onTableSelected() movieFragment")
                        supportFragmentManager.beginTransaction().replace(binding.mainTabView.id, movieFragment).commit()
                    }
                    1 -> {
                        Log.d(TAG, "$TAG onTableSelected() theaterFragment")
                        supportFragmentManager.beginTransaction().replace(binding.mainTabView.id, theaterFragment).commit()
                    }
                    2 -> {
                        Log.d(TAG, "$TAG onTableSelected() normalTicketingFragment")
                        supportFragmentManager.beginTransaction().replace(binding.mainTabView.id, normalTicketingFragment).commit()
                    }
                    3 -> {
                        Log.d(TAG, "$TAG onTableSelected() personalTicketingFragment")
                        supportFragmentManager.beginTransaction().replace(binding.mainTabView.id, personalTicketingFragment).commit()
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d(TAG, "$TAG onTabReselected()")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d(TAG, "$TAG onTabUnselected()")
            }
        })
    }
}