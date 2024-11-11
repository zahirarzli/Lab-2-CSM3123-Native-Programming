package com.example.menuexperiment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        // Register for context menu
        registerForContextMenu(textView);

        // Customize Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Custom Action Bar");
            actionBar.setSubtitle("Explore Menus");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle option menu items using if-else
        if (item.getItemId() == R.id.action_settings) {
            textView.setText("Settings selected");
        } else if (item.getItemId() == R.id.action_about) {
            textView.setText("About selected");
        } else if (item.getItemId() == R.id.action_help) {
            textView.setText("Help selected");
        } else if (item.getItemId() == R.id.action_general_settings) {
            textView.setText("General Settings selected");
        } else if (item.getItemId() == R.id.action_privacy_settings) {
            textView.setText("Privacy Settings selected");
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    // Context menu handling
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.setHeaderTitle("Choose an option");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle context menu items using if-else
        if (item.getItemId() == R.id.action_settings) {
            textView.setText("Settings selected from context menu");
        } else if (item.getItemId() == R.id.action_about) {
            textView.setText("About selected from context menu");
        } else if (item.getItemId() == R.id.action_help) {
            textView.setText("Help selected from context menu");
        } else if (item.getItemId() == R.id.action_general_settings) {
            textView.setText("General Settings selected from context menu");
        } else if (item.getItemId() == R.id.action_privacy_settings) {
            textView.setText("Privacy Settings selected from context menu");
        } else {
            return super.onContextItemSelected(item);
        }
        return true;
    }
}
