package com.megha.flagquiz.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.megha.flagquiz.databinding.FragmentHomeBinding
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper


class FragmentHome : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater,container,false)


        createAndOpenDatabase()
        fragmentHomeBinding.buttonStart.setOnClickListener{

            val direction = FragmentHomeDirections.actionFragmentHomeToFragmentQuiz()
            this.findNavController().navigate(direction)

        }

        return fragmentHomeBinding.root

    }
        private fun createAndOpenDatabase(){
            try {
                val helper = DatabaseCopyHelper(requireActivity())
                helper.createDataBase()
                helper.openDataBase()
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }

}