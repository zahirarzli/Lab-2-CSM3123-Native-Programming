package com.example.layoutexploration;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout); // Ensure this matches the XML filename
    }

    // Method called when the "Go Back" button is clicked
    public void finish(View view) {
        finish(); // Ends the activity
    }
}
