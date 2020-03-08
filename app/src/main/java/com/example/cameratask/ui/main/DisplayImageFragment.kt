package com.example.cameratask.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cameratask.R
import kotlinx.android.synthetic.main.main_fragment.*

class DisplayImageFragment : Fragment() {

    companion object {
        fun newInstance() = DisplayImageFragment()
    }

    private  var mainViewModel: MainViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel = activity?.let { ViewModelProvider(it).get(MainViewModel::class.java) }
        setOnClickListeners()
    }

    /*
   * ***************** setting on click listeners on view  *****************************************
   * */

    private fun setOnClickListeners() {
        btnCamera.setOnClickListener {
            startCameraActivity()
        }

        btnGallery.setOnClickListener {
            openGallery()
        }
    }

    /*
    * ***************** Function used to start camera using view model *****************************
    * */

    private fun startCameraActivity() {
        mainViewModel?.isGalleryClicked?.value = true
    }

    /*
   * ***************** Function used to open  gallery using view model *****************************
   * */

    private fun openGallery() {

    }

}
