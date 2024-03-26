package com.example.testrecyclerview;


import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {
    private NotificationCompat.Builder builder;
    public SecondFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NotificationPermission")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_second, container, false);

        if (builder == null)
            builder = new NotificationCompat.Builder(requireContext(), MainActivity.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Уведомление")
                    .setContentText("Пример уведомления в Android Studio")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Button buttonForNotify = root.findViewById(R.id.button_for_notify);
        buttonForNotify.setOnClickListener(v -> {
            // Отправка уведомления
            NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());
        });

        return root;
    }
}