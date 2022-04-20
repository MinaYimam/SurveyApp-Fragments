package com.minayimam.android.survey_appwithfragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.minayimam.android.survey_appwithfragments.ResultFragment


const val SURVEY_COUNT_FRAGMENT = "com.minayimam.android.Survey-App_With_Fragments.survey"

class SurveyFragment : Fragment() {

    private lateinit var yesCountButton: Button
    private lateinit var noCountButton: Button
    private lateinit var noCounterText: TextView
    private lateinit var yesCounterText: TextView
    private lateinit var surveyResultsButton: Button


    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
    }


    var yesCount = 0
    var noCount = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_survey, container, false)


        yesCountButton = view.findViewById(R.id.yes_button)
        noCountButton = view.findViewById(R.id.no_button)
        noCounterText = view.findViewById(R.id.no_counter)
        yesCounterText = view.findViewById(R.id.yes_counter)
        surveyResultsButton = view.findViewById(R.id.result_button)



        yesCountButton.setOnClickListener{
            increaseYesCount()
        }

        noCountButton.setOnClickListener{
            increaseNoCount()
        }


        surveyViewModel.yesCount.observe(requireActivity()){
                yes -> updateYesCounters(yes)
        }

        surveyViewModel.noCount.observe(requireActivity()){
                no -> updateNoCounters(no)
        }


        surveyResultsButton.setOnClickListener{
            sendResults()
        }

        return view
    }


    private fun increaseYesCount(){
        yesCount += 1
        surveyViewModel.yesCount.value = yesCount
    }

    private fun increaseNoCount(){
        noCount += 1
        surveyViewModel.noCount.value = noCount
    }

    private fun updateYesCounters(yesCounter: Int){
        yesCounterText.text = yesCounter.toString()
    }
    private fun updateNoCounters(noCounter: Int){
        noCounterText.text = noCounter.toString()
    }

    private fun sendResults(){

        surveyViewModel.yesCount.value = yesCount
        surveyViewModel.noCount.value  = noCount
        parentFragmentManager.setFragmentResult(SURVEY_COUNT_FRAGMENT, Bundle.EMPTY)

    }

    companion object {


        @JvmStatic
        fun newInstance() = SurveyFragment()
    }
}