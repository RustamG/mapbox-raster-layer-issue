package com.example.mapbox.ui.main

import android.os.Bundle
import android.view.View
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.RasterLayer
import com.mapbox.mapboxsdk.style.sources.RasterSource


class RasterSourceFragment : BaseMapFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView?.getMapAsync { map ->
            map.setStyle(Style.LIGHT) { style ->
                style.addSource(RasterSource("albuquerque-source", "mapbox://rustamg.bb1c0myz"))
                style.addLayer(RasterLayer("albuquerque", "albuquerque-source"))
            }
        }
    }

    companion object {
        fun newInstance() = RasterSourceFragment()
    }
}
