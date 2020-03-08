package com.example.cameratask.ui.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cameratask.R
import com.example.cameratask.ui.camera.ui.camera.CameraActivity
import com.example.cameratask.ui.utility.Codes

class MainActivity : AppCompatActivity() {
    private val allPermissionsRequired = arrayOf(
        Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DisplayImageFragment.newInstance())
                .commitNow()
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (!allPermissionGranted()) {
            askPermission()
        }

        setObserver()
    }


    /**
     * ************ Function used for observe button clicked or not in fragments *******************
     * */
    private fun setObserver() {
        mainViewModel.isGalleryClicked?.observe(this, Observer {
            if (it) {
                if (allPermissionGranted()) {
                    startCameraActivity()
                } else {
                    askPermission()

                }
            }
        })
    }

    /**
     * **************** Function used for starting camera Activity *********************************
     * */

    private fun startCameraActivity() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    /**
     * **************** Function used for asking permission ****************************************
     * */

    private fun askPermission() {
        ActivityCompat.requestPermissions(this, allPermissionsRequired, Codes.PermissionCode.CAMERA)

    }
    /**
     * **************** Function used for checking if all permission granted ***********************
     * */

    private fun allPermissionGranted(): Boolean {
        for (permission in allPermissionsRequired) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }

        return true
    }


}
