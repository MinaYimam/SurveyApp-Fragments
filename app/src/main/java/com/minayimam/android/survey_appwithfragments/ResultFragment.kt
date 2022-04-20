package com.minayimam.android.survey_appwithfragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class ResultFragment : Fragment() {


    private lateinit var resetCountersButton: Button
    private lateinit var noCounterText: TextView
    private lateinit var yesCounterText: TextView


    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(this).get(SurveyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_result, container, false)


        resetCountersButton = view.findViewById(R.id.reset_button)
        noCounterText = view.findViewById(R.id.no_counter)
        yesCounterText = view.findViewById(R.id.yes_counter)


        surveyViewModel.yesCount.observe(requireActivity()){
                yes -> updateYesCounters(yes)
        }

        surveyViewModel.noCount.observe(requireActivity()){
                no -> updateNoCounters(no)
        }

        resetCountersButton.setOnClickListener{
            resetCounters()
        }

        return view
    }


    private fun resetCounters(){
        surveyViewModel.yesCount.value = 0
        surveyViewModel.noCount.value = 0

    }


    private fun updateYesCounters(yesCounter: Int){
        yesCounterText.text = yesCounter.toString()
    }
    private fun updateNoCounters(noCounter: Int){
        noCounterText.text = noCounter.toString()
    }

    companion object {
       // @JvmStatic
        fun newInstance() = ResultFragment()
    }
}