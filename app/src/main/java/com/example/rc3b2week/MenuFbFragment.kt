package com.example.rc3b2week

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rc3b2week.databinding.FragmentMenuFbBinding
import kotlinx.android.synthetic.main.fragment_menu_fb.*

private lateinit var binding:MenuFbFragment

class MenuFbFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentMenuFbBinding.inflate(inflater,container,false)

        binding.llCg1.clipToOutline = true

        binding.btLogout.setOnClickListener{
            val mActivity = activity as HomeActivity
            mActivity.receiveData("로그아웃")
        }
        return binding.root

    }
}