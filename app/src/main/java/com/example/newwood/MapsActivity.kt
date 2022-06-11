package com.example.newwood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.newwood.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // location of the places
        val sydney = LatLng(-34.0, 151.0)
        val hongkong = LatLng(22.316,114.183)
        val hongkongCity = LatLng(22.309,114.183)
        val hongkong3 = LatLng(22.310,114.171)
        val hongkong4 = LatLng(22.315,114.169)
        val hongkong5 = LatLng(22.319,114.167)


        //information of the places
        mMap.addMarker(MarkerOptions().position(hongkong).title("Artistry Canine").snippet("Wood Carving Shop , Opening hours are 9 a.m. to 6 p.m"))
        mMap.addMarker(MarkerOptions().position(hongkongCity).title("Wood Frame").snippet("Wood Carving Shop , Opening hours are 11 a.m. to 8 p.m"))
        mMap.addMarker(MarkerOptions().position(hongkong3).title("Wood Tap").snippet("Wood Carving Shop , Opening hours are 10 a.m. to 8 p.m" ))
        mMap.addMarker(MarkerOptions().position(hongkong4).title("Timber Love").snippet("Wood Carving Shop , Opening hours are 7 a.m. to 5 p.m"))
        mMap.addMarker(MarkerOptions().position(hongkong5).title("Art Guild").snippet("Wood Carving Shop , Opening hours are 12 a.m. to 7 p.m"))

        //zoom in the location , camera view
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hongkong, 15f))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hongkongCity, 15f))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hongkong3))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hongkong4))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hongkong5))

    }
}