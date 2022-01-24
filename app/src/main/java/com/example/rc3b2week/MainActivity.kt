package com.example.rc3b2week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rc3b2week.databinding.ActivityMainBinding
import android.app.Activity
import android.content.SharedPreferences
import android.util.Log
import androidx.fragment.app.Fragment


private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var first : Boolean = false
    private lateinit var keyboardVisibilityUtils: KeyboardVisibilityUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        firstState()
        binding.btNext.setOnClickListener{
            if((binding.etIdInput.length() != 0) || (binding.etPasswordInput.length() != 0)) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"아이디와 비밀번호를 입력해주세요",Toast.LENGTH_LONG).show()
            }
        }
        keyboardVisibilityUtils = KeyboardVisibilityUtils(window,
            onShowKeyboard = { keyboardHeight ->
                binding.svRoot.run {
                    smoothScrollTo(scrollX, scrollY + keyboardHeight)
                }
            })
    }

    override fun onStart() {
        super.onStart()
        nextState()
    }

    override fun onResume() {
        super.onResume()
        restoreState()
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {
        super.onStop()
        saveState()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart호출", Toast.LENGTH_LONG).show()
        setDataAtFragment(HomeFbFragment(), "기사 교체")
    }

    fun setDataAtFragment(fragment: Fragment, title:String){
        val bundle = Bundle()
        bundle.putString("title",title)

        fragment.arguments = bundle
    }

    fun setFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_tab_fm,fragment)
        transaction.commit()
    }

    override fun onDestroy() {
        keyboardVisibilityUtils.detachKeyboardListeners()
        clearState()
        super.onDestroy()
    }
    private fun restoreState(){
        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        if (pref != null && pref.contains("id")) {
            val id = pref.getString("id", "")
            binding.etIdInput.setText(id)
            val pw = pref.getString("pw", "")
            binding.etPasswordInput.setText(pw)
        }
    }
    private fun saveState(){
        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("id",binding.etIdInput.getText().toString())
        editor.putString("pw",binding.etPasswordInput.getText().toString())
        editor.commit()

    }
    private fun clearState() {
        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("isFirst",false)
        editor.putString("id",null)
        editor.putString("pw",null)
        editor.commit()
    }

    private fun firstState(){
        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        first = pref.getBoolean("isFirst",false)
        if(!first){
            Toast.makeText(this,"첫접속 이다",Toast.LENGTH_LONG).show()
            var editor = pref.edit()
            editor.putBoolean("isFirst",true)
            first = pref.getBoolean("isFirst",true)
            editor.commit()

        }
        else{
            Toast.makeText(this,"첫 접속이 아니다",Toast.LENGTH_LONG).show()
        }
    }
    private fun nextState() {
        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        if (pref.contains("id") && pref.contains("pw") && first) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
