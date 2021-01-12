package com.rtsoftworld.recyclerviewpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView nameId,descriptionId;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameId = findViewById(R.id.nameId);
        descriptionId = findViewById(R.id.descriptionId);

        extras = getIntent().getExtras();

        if (extras != null)
        {
            nameId.setText(extras.getString("name"));
            descriptionId.setText(extras.getString("description"));
        }
    }
}
