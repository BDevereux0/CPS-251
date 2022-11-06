package com.ebookfrenzy.navigationproject

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.navigationproject.ui.main.MainFragment
import java.net.URI

class MainActivity : AppCompatActivity(),
                DisplayImgFragment.OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    override fun onFragmentInteraction(uri: URI) {
        TODO("Not yet implemented")
    }

}