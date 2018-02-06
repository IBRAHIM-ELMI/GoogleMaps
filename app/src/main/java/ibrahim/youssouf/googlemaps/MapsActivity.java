package ibrahim.youssouf.googlemaps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.CollationElementIterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private CollationElementIterator tv;
    private GoogleMap.InfoWindowAdapter myInfoWindowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(myInfoWindowAdapter);
        mMap.setOnMapLongClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        tagTheMap();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        // Add a marker in Sydney and move the camera
        LatLng Djibouti = new LatLng(11.58901, 43.14503);
        mMap.addMarker(new MarkerOptions().position(Djibouti).title("Marker in Djibouti"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Djibouti));

        LatLng Senegal = new LatLng(14.6937, -17.44406);
        mMap.addMarker(new MarkerOptions().position(Senegal).title("Marker in Senegal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Senegal));
    }

    private void tagTheMap() {
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        tv.setText(marker.getTitle()+"is the "+marker.getSnippet());
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        tv.setText(marker.getTitle()+"was chosen");
        return false;
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }
}

