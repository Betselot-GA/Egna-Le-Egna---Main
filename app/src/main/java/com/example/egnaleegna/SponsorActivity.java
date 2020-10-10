package com.example.egnaleegna;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SponsorActivity extends AppCompatActivity {

    private ViewPager2 bloodActivityViewPager;
    private SponsorViewPagerAdapter bloodViewPagerAdapter;
    private TabLayout tabLayout;

    private ImageView sponsorImageView;
    private TextView nameTextView;
    private TextView ageTextView;
    private TextView phoneTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        sponsorImageView = findViewById(R.id.blood_image_view);
        nameTextView = findViewById(R.id.name_text_view);
        ageTextView = findViewById(R.id.age_text_view);
        phoneTextView = findViewById(R.id.phone_text_view);

        bloodActivityViewPager = findViewById(R.id.blood_activity_view_pager);
        tabLayout = findViewById(R.id.news_activity_tab_layout);
        bloodViewPagerAdapter = new SponsorViewPagerAdapter(this);

        bloodViewPagerAdapter.addFragment(new NewsAndEventFragment(), "newsAndEvent");
        bloodViewPagerAdapter.addFragment(new UploadFragment(), "bloodDonation");
        bloodViewPagerAdapter.addFragment(new NotficationFragment(), "notification");
        bloodViewPagerAdapter.addFragment(new UserFragment(), "userInfo");

        bloodActivityViewPager.setAdapter(bloodViewPagerAdapter);



        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, bloodActivityViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                ViewGroup vg = (ViewGroup) SponsorActivity.this.sponsorImageView.getParent();
                switch (position){
                    case 0:{
                        tab.setIcon(R.drawable.ic_news);

                        break;
                    }
                    case 1:{
                        tab.setIcon(R.drawable.ic_upload);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setNumber(2);
                        break;
                    }
                    case 2:{
                        tab.setIcon(R.drawable.ic_notification);
                        break;
                    }
                    case 3:{
                        tab.setIcon(R.drawable.ic_account);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setNumber(2);
                        break;
                    }

                }
            }
        }
        );
        tabLayoutMediator.attach();



    }
}

