package com.example.simplebluetooth;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declares the speaker for the a2dp bluetooth
    BluetoothA2dp speaker;
    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private BluetoothProfile.ServiceListener profileListener = new BluetoothProfile.ServiceListener(){
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if(profile == BluetoothProfile.A2DP) {
                speaker = (BluetoothA2dp) proxy;
                Toast.makeText(getApplicationContext(),"Bluetooth device connected",
                        Toast.LENGTH_SHORT).show();
            }

        }
        public void onServiceDisconnected(int profile) {
            if(profile == BluetoothProfile.A2DP) {
                speaker = null;
            }
            Toast.makeText(getApplicationContext(),"Bluetooth device disconnected",
                    Toast.LENGTH_SHORT).show();
        }
    };
}
