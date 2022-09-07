package uz.exemple.less51_task1_introvp_kotlin.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import uz.exemple.less51_task1_introvp_kotlin.MainActivity
import uz.exemple.less51_task1_introvp_kotlin.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PageThree.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageThree : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_page_three, container, false)
        initViews(view)
        return view
    }
    fun initViews(view:View){
        val tv_title = view.findViewById<TextView>(R.id.tv_title_f3)
        val tv_desc = view.findViewById<TextView>(R.id.tv_desc_f3)
        val tv_start = view.findViewById<Button>(R.id.btn_start)
        tv_title.text = "Safe, Trusted & Fully Secure"
        tv_desc.text = "Encrypted transactions mean your payments & Privacy and protected."

        tv_start.setOnClickListener { openMainActivity() }
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
         * @return A new instance of fragment PageThree.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PageThree().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}