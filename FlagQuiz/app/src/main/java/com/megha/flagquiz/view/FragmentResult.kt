package com.megha.flagquiz.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.megha.flagquiz.R
import com.megha.flagquiz.databinding.FragmentResultBinding



@Suppress("UNREACHABLE_CODE")
class FragmentResult : Fragment() {

    private lateinit var fragmentResultBinding: FragmentResultBinding
    private var correctNumber = 0
    private var emptytNumber = 0
    private var wrongNumber = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater,container,false)

        val args = arguments?.let {
            FragmentResultArgs.fromBundle(it)
        }
        args?.let{
            correctNumber = it.correct.toFloat().toInt()
            emptytNumber = it.empty.toFloat().toInt()
            wrongNumber = it.wrong.toFloat().toInt()
        }
        val barEntriesArrayListCorrect = ArrayList<BarEntry>()
        val barEntriesArrayListEmpty = ArrayList<BarEntry>()
        val barEntriesArrayListWrong = ArrayList<BarEntry>()

        barEntriesArrayListCorrect.add(BarEntry())
        barEntriesArrayListEmpty.add(BarEntry())
        barEntriesArrayListWrong.add(BarEntry())

        val barDataSetCorrect = BarDataSet(barEntriesArrayListCorrect,"Correct Number").apply {
            color = Color.GREEN
            valueTextSize = 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }
        val barDataSetEmpty = BarDataSet(barEntriesArrayListEmpty,"Empty Number").apply {
            color = Color.BLUE
            valueTextSize = 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }
        val barDataSetWrong = BarDataSet(barEntriesArrayListWrong,"Wrong Number").apply {
            color = Color.RED
            valueTextSize = 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }

        val barData  = BarData(barDataSetCorrect,barDataSetEmpty,barDataSetWrong)
        fragmentResultBinding.chart.data = barData
        fragmentResultBinding.buttonNewQuiz.setOnClickListener {
            this.findNavController().popBackStack(R.id.fragmentHome,inclusive = false)
        }

        fragmentResultBinding.buttonExit.setOnClickListener {
            requireActivity().finish()
        }
        return fragmentResultBinding.root
    }

    private fun BarEntry(): BarEntry {

        return TODO("Provide the return value")
    }


}