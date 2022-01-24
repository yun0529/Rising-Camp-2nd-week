package com.example.rc3b2week

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rc3b2week.databinding.FragmentHomeFbBinding

private lateinit var binding : FragmentHomeFbBinding


class HomeFbFragment : Fragment() {
   // private var title:String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeFbBinding.inflate(inflater,container,false)

        binding.ivHomeStroyMc.clipToOutline = true
        binding.ivHomeStroyMs.clipToOutline = true
        return binding.root

    }
    fun changeText(text:String){
        binding.tvThumbnail.text = text
        binding.tvTime.text = "3시간  "
        binding.tvThumbnail.text = "도촬 트라우마에 예민했다며.."
        binding.ivThumbnailImg.setImageResource(R.drawable.fb_site_thumbnail2)
        binding.tvSiteTitle.text = "\"형ㆍ동생 사이로 지내기로\"...\'징맨\' 황철순, 시민 폭행 논란에 입장 발표"
        binding.tvClickGood.text = "336"
        binding.tvLook.text = "댓글 89개ㆍ공유 6회"
    }
}

