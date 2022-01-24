package com.example.rc3b2week

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rc3b2week.databinding.FragmentHomeFbBinding
import com.example.rc3b2week.databinding.FragmentWatchFbBinding
import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.widget.MediaController
import android.widget.Toast


private lateinit var binding : FragmentWatchFbBinding

class WatchFbFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentWatchFbBinding.inflate(inflater,container,false)

        binding.vvVideo.setVideoPath("android.resource://com.example.rc3b2week/" + com.example.rc3b2week.R.raw.fb_video_webm)

         //val videoUri = Uri.parse("https://ykarr.github.io/web/test.mp4")

        //binding.vvVideo.setVideoURI(videoUri)

        binding.vvVideo.setMediaController(MediaController(activity))

        binding.vvVideo.setOnPreparedListener(OnPreparedListener {
            binding.vvVideo.start()
        })
        binding.btComment.setOnClickListener {
            val intent = Intent(activity, CommentActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
    override fun onPause() {
        super.onPause()
        //비디오 일시 정지
        if (binding.vvVideo != null && binding.vvVideo.isPlaying) {
            binding.vvVideo.pause()
        }
    }

}

