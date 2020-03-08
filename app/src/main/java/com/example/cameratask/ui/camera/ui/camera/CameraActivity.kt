package com.example.cameratask.ui.camera.ui.camera

import android.os.Bundle
import android.util.Rational
import android.util.Size
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.impl.PreviewConfig
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cameratask.R
import kotlinx.android.synthetic.main.camera_activity.*
import kotlinx.android.synthetic.main.main_activity.*

class CameraActivity : AppCompatActivity() {

    private var displayId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camera_activity)
        supportActionBar?.hide()
        startCamera()
    }



    /*
    * *********************** Function used to start camera ****************************************
    * */
    private fun startCamera() {
        view_finder.post {
            displayId = view_finder.display.displayId
            updateTheCameraUi()

        }
    }

    private fun updateTheCameraUi() {
        camera_container?.let {
            container.removeView(it)
        }

        val controls = View.inflate(this, R.layout.camera_ui_container, camera_container)


    }

}
