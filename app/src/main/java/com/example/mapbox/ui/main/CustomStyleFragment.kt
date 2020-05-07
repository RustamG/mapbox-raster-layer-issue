package com.example.mapbox.ui.main

import android.os.Bundle
import android.view.View


class CustomStyleFragment : BaseMapFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView?.getMapAsync { map ->
            map.setStyle("mapbox://styles/rustamg/ck8se724l23bh1io2b1hnbqls") { style ->
                // this style has 2 raster layers with tilesets:
                // Albuquereque (mapbox://rustamg.bb1c0myz): https://drive.google.com/file/d/16D8v-K9GK_3zk_zgj4uuNTzNZ2-hJYTU/view?usp=sharing
                // Phoenix (mapbox://rustamg.aflpqt57): https://drive.google.com/file/d/1rJICzI_8fZA-G1L95hlkFuNxk7L2Z-Lb/view?usp=sharing
            }
        }
    }

    companion object {
        fun newInstance() = CustomStyleFragment()
    }
}
