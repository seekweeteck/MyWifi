package my.edu.tarc.mywifi;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button enableButton,disableButton;
    TextView textViewWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enableButton=(Button)findViewById(R.id.button1);
        disableButton=(Button)findViewById(R.id.button2);
        textViewWifi = (TextView)findViewById(R.id.textViewWifi);

        enableButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
            }
        });

        disableButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
            }
        });

    }

    public  void getAddress(View view){
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifi.getConnectionInfo();

        if(wifiInfo.getSupplicantState() == SupplicantState.COMPLETED){
            String ssid = wifiInfo.getSSID();
            textViewWifi.setText(ssid);
        }
    }
}
