package com.example.rc3b2week

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rc3b2week.databinding.ActivityCommentBinding

private lateinit var binding : ActivityCommentBinding

class CommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)

        binding.llComment.clipToOutline = true

        setContentView(binding.root)
    }
}