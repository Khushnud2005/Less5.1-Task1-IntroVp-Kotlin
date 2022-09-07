package uz.exemple.less51_task1_introvp_kotlin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPagerAdapter(activity: FragmentActivity?): FragmentStateAdapter(activity!!) {

    private val fragments: ArrayList<Fragment> = ArrayList()
    private val fragmentTitle: ArrayList<String> = ArrayList()

    fun add(fragment: Fragment,title:String) {
        fragments.add(fragment)
        fragmentTitle.add(title)
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
    /*override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{PageOne()}
            1->{PageTwo()
            }
            2->{PageThree()
            }
            else->{PageOne()}
        }
    }*/

}