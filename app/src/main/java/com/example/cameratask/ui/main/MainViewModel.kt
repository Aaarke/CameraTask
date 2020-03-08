package com.example.cameratask.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
   val isCameraButtonClicked:MutableLiveData<Boolean>?=MutableLiveData()
    val isGalleryClicked:MutableLiveData<Boolean>?=MutableLiveData()


}
