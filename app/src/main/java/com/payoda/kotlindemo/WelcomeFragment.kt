package com.payoda.kotlindemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.payoda.kotlindemo.database.ApplicationDatabase
import com.payoda.kotlindemo.database.User
import com.payoda.kotlindemo.databinding.FragmentWelcomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "param1"

class WelcomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    var binding: FragmentWelcomeBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_welcome, container, false)
        return binding!!.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setData()
    }

    override fun onDetach() {
        super.onDetach()
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    fun setData() {
        val db = context?.let { ApplicationDatabase(it) }

        GlobalScope.launch {
            db!!.UserDao().insertAllUsers(
                User(
                    "0002", "Upendra",
                    "Singh", "9611849076", "upendraaa@gmail.com"
                )
            )
            var data = db.UserDao().getAllUsers()

            data?.forEach {
                //                binding!!.tvData.append(it.firstName +",")
//                binding!!.tvData.append(it.lastName +",")
//                binding!!.tvData.append(it.mobileNumber +",")
//                binding!!.tvData.append(it.emailId +",")

                println(it)
            }
        }
    }
}
