package com.example.wristsample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.bluetooth.BluetoothSocket;
import java.util.Set;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton saveBtn, bluetoothBtn;
    private TextView statusText;
    private Set<BluetoothDevice> mPairedDevices;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = findViewById(R.id.save);
        bluetoothBtn = findViewById(R.id.bluetooth);
        statusText = findViewById(R.id.status);
        bluetoothBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    Toast.makeText(getApplicationContext(), "블루투스를 지원하지 않는 기기입니다.", Toast.LENGTH_LONG).show();
                } else {
                    if (mBluetoothAdapter.isEnabled()) {
                        Toast.makeText(getApplicationContext(), "블루투스가 이미 활성화 되어 있습니다.", Toast.LENGTH_LONG).show();
                        statusText.setText("활성화");
                    } else {
                        Toast.makeText(getApplicationContext(), "블루투스가 활성화 되어 있지 않습니다.", Toast.LENGTH_LONG).show();
                    }
                }
//                if (mBluetoothAdapter.isEnabled()) {
//                    mPairedDevices = mBluetoothAdapter.getBondedDevices();
//                    if (mPairedDevices.size() > 0)
//                    {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                        builder.setTitle("장치 선택");
//                    }
//                }
            }
        });
    }
}