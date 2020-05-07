package com.example.mapbox.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View


class CustomStyleFragment : BaseMapFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView?.getMapAsync { map ->
            map.setStyle("mapbox://styles/rustamg/ck8se724l23bh1io2b1hnbqls") { style ->

            }
            map.addOnCameraMoveListener {
                Log.d("CameraPosition", "${map.cameraPosition}")
            }
        }
    }

    companion object {
        fun newInstance() = CustomStyleFragment()
    }
}
