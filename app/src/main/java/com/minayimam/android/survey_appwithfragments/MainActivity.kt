
package com.minayimam.android.survey_appwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        containerView = findViewById(R.id.survey_fragment_container)


        supportFragmentManager.setFragmentResultListener(SURVEY_COUNT_FRAGMENT,this){
                requestKey, bundle ->

            supportFragmentManager.beginTransaction()
                .add(R.id.survey_fragment_container, ResultFragment.newInstance())
                .addToBackStack("RESULTS")
                .commit()
        }




    }


}
