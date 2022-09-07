package uz.exemple.less51_task1_introvp_kotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import uz.exemple.less51_task1_introvp_kotlin.R
import uz.exemple.less51_task1_introvp_kotlin.adapters.VPagerAdapter
import uz.exemple.less51_task1_introvp_kotlin.fragments.PageOne
import uz.exemple.less51_task1_introvp_kotlin.fragments.PageThree
import uz.exemple.less51_task1_introvp_kotlin.fragments.PageTwo

class IntroActivity : AppCompatActivity() {
    private lateinit var vPagerAdapter: VPagerAdapter
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        initViews()
    }

    fun initViews(){
        viewPager = findViewById(R.id.view_pager)
        val adapter = VPagerAdapter(this)
        adapter.add(PageOne(), "Page One")
        adapter.add(PageTwo(), "Page Two")
        adapter.add(PageThree(), "Page Three")

        viewPager.adapter = adapter
        viewPager.currentItem = 0
    }

}