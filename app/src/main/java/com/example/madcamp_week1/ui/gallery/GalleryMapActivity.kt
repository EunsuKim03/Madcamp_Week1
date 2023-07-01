package com.example.madcamp_week1.ui.gallery

import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityGalleryMapBinding
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPOIItem.MarkerType
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.util.Locale

class GalleryMapActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGalleryMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_map)

        binding = ActivityGalleryMapBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val addr = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.getStringExtra("galleryMapAddr")
        } else {
            null
        }

        val name = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.getStringExtra("galleryMapName")
        } else {
            null
        }

        val mapView = MapView(this)
        binding.galleryMap.addView(mapView)

        val location = Geocoder(applicationContext, Locale.KOREA).getFromLocationName(addr!!, 1)?.let {
            Location("").apply {
                latitude = it[0].latitude
                longitude = it[0].longitude
            } ?: Location("").apply {
                latitude = 37.53737528
                longitude = 127.00557633
            }
        }

        println("\n\n\n lat: ${location?.latitude}\nlong: ${location?.longitude}\n\n\n")

        // MapCenter를 주소의 위도 경도로 설정
        val mapPoint = MapPoint.mapPointWithGeoCoord(location?.latitude!!, location?.longitude!!)
        mapView.setMapCenterPoint(mapPoint, true)
        mapView.setZoomLevel(1, true)

        // MapCenter에 marker 추가
        val marker = MapPOIItem()
        marker.itemName = name
        marker.tag = 0
        marker.mapPoint = mapPoint
        marker.markerType = MarkerType.BluePin
        marker.selectedMarkerType = MarkerType.RedPin
        mapView.addPOIItem(marker)
    }
}