package com.example.testrecyclerview;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.example.testrecyclerview.adapter.ExampleAdapter;
import com.example.testrecyclerview.adapter.ExampleViewPagerAdapter;
import com.example.testrecyclerview.api.ServerApi;
import com.example.testrecyclerview.model.ExampleItem;
import com.google.android.material.tabs.TabLayout;

import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    public static ServerApi serverApi;
    public static final String CHANNEL_ID = "EXAMPLE_CHANNEL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        Notificator.scheduleNotification(getApplicationContext());

        serverApi = new ServerApi();

        TabLayout tl = findViewById(R.id.tl_example);
        ViewPager vp = findViewById(R.id.vp_example);

        ExampleViewPagerAdapter adapter = new ExampleViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        adapter.addFragment(new FirstFragment(), "Первая");
        adapter.addFragment(new SecondFragment(), "Вторая");

        vp.setAdapter(adapter);

        tl.setupWithViewPager(vp);

        vp.setCurrentItem(1);
    }
}