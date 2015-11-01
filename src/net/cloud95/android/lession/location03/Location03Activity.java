package net.cloud95.android.lession.location03;

import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class Location03Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView info = (TextView) findViewById(R.id.info);
        LocationManager locationManager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
        // 從GPS讀取最後儲存的位置
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        
        StringBuffer sb =new StringBuffer("Location Information:\n");
        
        if(location != null){
        	sb.append("Latitude:  "+location.getLatitude()).append("\n");
        	sb.append("Longitude: "+location.getLongitude()).append("\n");
        	sb.append("Accuracy:  "+location.getAccuracy()).append("\n");
        	sb.append("Altitude:  "+location.getAltitude()).append("\n");
        	sb.append("Bearing:   "+location.getBearing()).append("\n");
        	sb.append("Speed:     "+location.getSpeed()).append("\n");
        	sb.append("Time:      "+new Date(location.getTime())).append("\n");
        }else{
        	sb.append("N/A");
        }
        info.setText(sb.toString());
    }
}
