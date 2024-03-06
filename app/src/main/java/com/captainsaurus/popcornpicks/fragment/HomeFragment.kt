package com.captainsaurus.popcornpicks.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.captainsaurus.popcornpicks.R
import com.captainsaurus.popcornpicks.databinding.FragmentHomeBinding
import com.captainsaurus.popcornpicks.databinding.HomeViewPagerItemBinding

class HomeFragment : Fragment() {

    val TAG = "[HomeFragment]"

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, " onCreateView()")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, " onViewCreated()")

        initViewPager()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, " onResume()")

        binding.homeImageViewpager.clearAnimation()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, " onResume()")

        binding.homeImageViewpager.clearAnimation()
    }

    private fun initViewPager() {
        Log.d(TAG, " initViewPager()")

        homeViewPagerAdapter = HomeViewPagerAdapter(temporaryColor())
        binding.homeImageViewpager.adapter = homeViewPagerAdapter
        binding.homeImageViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun temporaryColor() : ArrayList<Int> {
        return arrayListOf(R.drawable.dune, R.drawable.interstellar, R.drawable.lalaland)
    }
}

class HomeViewPagerAdapter(private val homeImageItems: ArrayList<Int>) : RecyclerView.Adapter<HomeViewPagerAdapter.HomeViewPagerHolder>() {

    val TAG = "[HomeViewPagerAdapter]"

    inner class HomeViewPagerHolder(private val binding: HomeViewPagerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            Log.d(TAG, " bind()")
            binding.homeViewPagerItemIv.setImageResource(homeImageItems[position])
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewPagerAdapter.HomeViewPagerHolder {
        Log.d(TAG, " onCreateViewHolder()")
        val binding = HomeViewPagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewPagerAdapter.HomeViewPagerHolder, position: Int) {
        Log.d(TAG, " onBindViewHolder()")
        holder.bind()
    }

    override fun getItemCount() : Int {
        Log.d(TAG, " getItemCount()")

        return homeImageItems.size
    }

}