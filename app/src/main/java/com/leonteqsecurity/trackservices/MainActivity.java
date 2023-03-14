package com.leonteqsecurity.trackservices;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    private CameraManager mCameraManager;
    private CameraManager.AvailabilityCallback mCameraCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the CameraManager instance
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        // Register a CameraManager.AvailabilityCallback to listen for camera access events
        mCameraCallback = new CameraManager.AvailabilityCallback() {
            @Override
            public void onCameraAvailable(@NonNull String cameraId) {
                // The camera is available for use
                Log.d(TAG, "Camera " + cameraId + " is now available");
            }

            @Override
            public void onCameraUnavailable(@NonNull String cameraId) {
                // The camera is no longer available for use
                Log.d(TAG, "Camera " + cameraId + " is now unavailable");
            }
        };

        // Register the callback with the CameraManager
        mCameraManager.registerAvailabilityCallback(mCameraCallback, null);
    }

    public  void myNotification()
    {
        NotificationCompat.Builder builder =new NotificationCompat.Builder(MainActivity.this,"leontech");
        builder.setContentTitle("LEONTEQSECURITY");
        builder.setContentText("Hlello tis is my otification");
        builder.setSmallIcon(R.drawable.baseline_3p_24);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompact=NotificationCompat.fr()
    }









    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Unregister the callback when the activity is destroyed
        mCameraManager.unregisterAvailabilityCallback(mCameraCallback);
    }
}
