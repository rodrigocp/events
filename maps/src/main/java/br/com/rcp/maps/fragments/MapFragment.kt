package br.com.rcp.maps.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.rcp.maps.R
import br.com.rcp.maps.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private lateinit var binding: FragmentMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("latlong").let {
            it?.split(":").let { splitted ->
               latitude = splitted?.get(0)?.toDouble()  ?: 0.0
               longitude = splitted?.get(1)?.toDouble() ?: 0.0
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMapBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)
        }
    }

    override fun onMapReady(map: GoogleMap) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 16f))
        map.addMarker(MarkerOptions().position(LatLng(latitude, longitude)))
    }
}
