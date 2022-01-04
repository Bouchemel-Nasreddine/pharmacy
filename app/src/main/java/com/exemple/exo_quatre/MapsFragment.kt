package com.exemple.exo_quatre

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private lateinit var map: GoogleMap
    private lateinit var fusesLocationClient: FusedLocationProviderClient
    private lateinit var coordinatesList: ArrayList<Pair<Double, Double>>
    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        map = googleMap
        map.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                this.requireContext(),
                R.raw.map_style
            )
        )
        addMarkersList(map, coordinatesList)

    }

    private fun addMarker(
        map: GoogleMap,
        latitude: Double,
        longitude: Double,
        title: String,
        res: Int? = null
    ) {
        if (res == null) {
            map.addMarker(MarkerOptions().position(LatLng(latitude, longitude)).title(title))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 14.0f))
        } else {
            map.addMarker(
                MarkerOptions().position(LatLng(latitude, longitude)).title(title)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            )
        }
    }

    private fun addMarkersList(
        map: GoogleMap,
        coordinatesList: ArrayList<Pair<Double, Double>>
    ) {
        for (coordinate in coordinatesList) {
            addMarker(
                map,
                coordinate.first,
                coordinate.second,
                "pharmacy",
                R.drawable.pharmacy_marker
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        coordinatesList = ArrayList()
        coordinatesList.add(Pair(36.71414582806839, 3.152710001393291))
        coordinatesList.add(Pair(36.27214450981929, 6.700339455946398))

        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        fusesLocationClient = LocationServices.getFusedLocationProviderClient(this.requireContext())
        if (checkPermission(this.requireContext())) {
            fusesLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        addMarker(map, location.latitude, location.longitude, "you")
                    }
                }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun checkPermission(context: Context): Boolean {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions()
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun requestPermissions() {
        val request = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {

                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    // Only approximate location access granted.
                }
                else -> {
                    // No location access granted.
                }
            }
        }

        request.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        // If request is cancelled, the result arrays are empty.
        if ((grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED)
        ) {
            // Permission is granted. Continue the action or workflow
            // in your app.
        } else {
            requestPermissions()
        }
    }
}