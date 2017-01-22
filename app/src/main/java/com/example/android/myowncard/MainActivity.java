package com.example.android.myowncard;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbar.setTitle("Bugs - Computer Service");
        collapsingToolbar.setExpandedTitleColor(ResourcesCompat.getColor(getResources(), android.R.color.transparent, null)); //ContextCompat.getColor(getContext(), android.R.color.transparent)

        TextView colorTextView = (TextView)findViewById(R.id.header_card_company_description);
        String companyString = getResources().getString(R.string.company_description);

        if (Build.VERSION.SDK_INT >= 24) {
            colorTextView.setText(Html.fromHtml(companyString, Html.FROM_HTML_MODE_LEGACY)); // for 24 api and more
        } else {
            colorTextView.setText(Html.fromHtml(companyString)); // or for older api
        }

    }
}
