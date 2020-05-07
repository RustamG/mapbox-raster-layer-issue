package com.example.mapbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mapbox.ui.main.BaseMapFragment
import com.example.mapbox.ui.main.CustomStyleFragment
import com.example.mapbox.ui.main.RasterSourceFragment
import com.google.android.material.tabs.TabLayout
import com.mapbox.mapboxsdk.Mapbox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Mapbox.getInstance(applicationContext, getString(R.string.mapbox_access_token))

        if (savedInstanceState == null) {
            placeFragment(CustomStyleFragment.newInstance())
        }

        tabs.addTab(tabs.newTab().apply {
            text = "Custom Style"
        })
        tabs.addTab(tabs.newTab().apply {
            text = "Raster Source"
        })

        val tabListener = object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> placeFragment(CustomStyleFragment.newInstance())
                    1 -> placeFragment(RasterSourceFragment.newInstance())
                }
            }
        }
        tabs.addOnTabSelectedListener(tabListener)
    }

    private fun placeFragment(fragment: BaseMapFragment) {

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }
}
