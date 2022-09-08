package uz.exemple.less51_task1_introvp_kotlin.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import uz.exemple.less51_task1_introvp_kotlin.MainActivity
import uz.exemple.less51_task1_introvp_kotlin.R
import uz.exemple.less51_task1_introvp_kotlin.activities.IntroActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PageOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageOne : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_page_one, container, false)
        initViews(view)
        return view
    }
    fun initViews(view:View){

        val tv_title = view.findViewById<TextView>(R.id.tv_title_f1)
        val tv_desc = view.findViewById<TextView>(R.id.tv_desc_f1)
        //val tv_skip = view.findViewById<TextView>(R.id.tv_skip_f1)
        tv_title.text = "Say Hello to Global Top - Up"
        tv_desc.text = "Send mobile top-up to more then 500 networks in over 140 countries."

        /*tv_skip.setOnClickListener { openMainActivity() }*/
    }

    fun openMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PageOne.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PageOne().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}