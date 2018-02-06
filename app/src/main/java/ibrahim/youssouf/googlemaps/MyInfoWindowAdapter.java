package ibrahim.youssouf.googlemaps;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.BitSet;

/**
 * Created by ibrahim on 08/01/18.
 */

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {


    private View infoWindowView;
    private boolean infoWindowAdapterAllowed;
    private View layoutInflater;


    MyInfoWindowAdapter() {
        infoWindowView = getLayoutInflater().inflate(R.layout.layout, root:null);
    }
    public  void fillTheView(Marker marker, View iwv){
        ImageView iv = iwv.findViewById(R.id.picture);
        iv.setImageResource(myPOIS.get(marker));
        TextView title=(TextView)iwv.findViewById(R.id.tv);
        TextView snippet=(TextView)iwv.findViewById(R.id.tv2);
        title.setText(marker.getTitle());
        title.setBackgroundColor(Color.argb( 100, 200, 100, 150));
        snippet.setText(marker.getSnippet());
        snippet.setBackgroundColor(Color.argb( 100, 200, 100, 150));
    }


    @Override
    public View getInfoWindow(Marker marker) {
        fillTheView(marker,infoWindowView);
        if ((infoWindowAdapterAllowed))
            return infoWindowView;
        else  return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        fillTheView(marker,infoWindowView);
        return infoWindowView;
    }

    public View getLayoutInflater() {
        return layoutInflater;
    }
}