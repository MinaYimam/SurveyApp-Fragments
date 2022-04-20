package com.minayimam.android.survey_appwithfragments
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SurveyViewModel: ViewModel() {

    var yesCount = MutableLiveData(0)
    var noCount = MutableLiveData(1)


}