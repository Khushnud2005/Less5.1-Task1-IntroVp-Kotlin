package uz.exemple.less51_task1_introvp_kotlin.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.exemple.less51_task1_introvp_kotlin.MainActivity
import uz.exemple.less51_task1_introvp_kotlin.R
import uz.exemple.less51_task1_introvp_kotlin.adapters.VPagerAdapter
import uz.exemple.less51_task1_introvp_kotlin.fragments.PageOne
import uz.exemple.less51_task1_introvp_kotlin.fragments.PageThree
import uz.exemple.less51_task1_introvp_kotlin.fragments.PageTwo

class IntroActivity : AppCompatActivity() {
    private lateinit var vPagerAdapter: VPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var tv_skip: TextView
    private lateinit var btn_start:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        initViews()
    }

    fun initViews(){
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)
        tv_skip = findViewById(R.id.tv_skip)
        btn_start = findViewById(R.id.btn_start)
        val adapter = VPagerAdapter(this)
        adapter.add(PageOne(), "Page One")
        adapter.add(PageTwo(), "Page Two")
        adapter.add(PageThree(), "Page Three")

        viewPager.adapter = adapter
        viewPager.currentItem = 0

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, offset: Float, offsetPx: Int) {

                if (viewPager.currentItem == 2){
                    btn_start.visibility = View.VISIBLE
                    tv_skip.visibility = View.GONE
                }else{
                    btn_start.visibility = View.GONE
                    tv_skip.visibility = View.VISIBLE
                }
            }
        })

        val tabs = tabLayout.getChildAt(0) as ViewGroup

        TabLayoutMediator(tabLayout,viewPager){tab,index ->
            for (i in 0 until tabs.getChildCount()) {
                val v: View = tabs.getChildAt(i)
                val params = v.layoutParams as MarginLayoutParams
                params.rightMargin = 25
            }
        }.attach()

        tv_skip.setOnClickListener {

            Handler().postDelayed({
                viewPager.setCurrentItem(2,true)
            }, 200)
        }
        btn_start.setOnClickListener{openMainActivity()}

    }
    fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}