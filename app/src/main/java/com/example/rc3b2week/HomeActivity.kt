package com.example.rc3b2week

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.rc3b2week.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout


private lateinit var binding : ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var tab1:HomeFbFragment
    lateinit var tab2:GroupFbFragment
    lateinit var tab3:WatchFbFragment
    lateinit var tab4:ProfileFbFragment
    lateinit var tab5:AlarmFbFragment
    lateinit var tab6:MenuFbFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        tab1 = HomeFbFragment()
        tab2 = GroupFbFragment()
        tab3 = WatchFbFragment()
        tab4 = ProfileFbFragment()
        tab5 = AlarmFbFragment()
        tab6 = MenuFbFragment()

        val view = binding.root
        binding.tbTitle.setBackgroundColor(Color.rgb(255,255,255))
        setContentView(view)
        replaceView(tab1)
        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.position){
                    0 -> {
                        replaceView(tab1)
                    }
                    1 -> {
                        replaceView(tab2)
                    }
                    2 -> {
                        replaceView(tab3)
                    }
                    3 -> {
                        replaceView(tab4)
                    }
                    4 -> {
                        replaceView(tab5)
                    }
                    5 -> {
                        replaceView(tab6)
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        //(supportFragmentManager.findFragmentByTag("fragmentTag") as HomeFbFragment?)?.changeText("onRestart가 호출됨")
    }

    fun receiveData(what: String){
        if(what == "로그아웃"){
            ActivityCompat.finishAffinity(this);
        }
    }



    private fun replaceView(tab:Fragment){
        var selectedFragment: Fragment? = null
        selectedFragment = tab
        selectedFragment?.let{
            supportFragmentManager.beginTransaction().replace(
                R.id.fl_tab_fm,it
            ).commit()
        }
    }

    override fun onRestart() {
        super.onRestart()
        //(supportFragmentManager.findFragmentByTag("fragmentTag") as HomeFbFragment?)?.changeText("onRestart가 호출됨")
        var tf:HomeFbFragment =supportFragmentManager.findFragmentById(R.id.fl_tab_fm) as HomeFbFragment
        tf.changeText("onRestart호출됨");
        Toast.makeText(this,"onRestart2호출", Toast.LENGTH_LONG).show()
    }


/*private fun setDataAtFragment(fragment:Fragment, title:String){
    val bundle = Bundle()
    bundle.putString("title",title)

    fragment.arguments = bundle
    setFragment(fragment)
}*/

/*fun newInstance(data: MyData?): Fragment? {
    val f: Fragment = HomeFbFragment()
    val b = Bundle()
    b.putParcelable(MyData::class.java.name, data)
    f.arguments = b
    return f
}*/

/*fun setFragment(fragment: Fragment){
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fl_tab_fm,fragment)
    transaction.commit()
}*/
}