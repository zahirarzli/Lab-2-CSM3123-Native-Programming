package com.example.controlexperiment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner spinner = findViewById(R.id.spinner);
        SeekBar seekBar = findViewById(R.id.seekBar);
        Switch switchControl = findViewById(R.id.switchControl);

        // Set up spinner data
        String[] options = {"Option A", "Option B", "Option C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Button click listener
        button.setOnClickListener(v -> {
            String input = editText.getText().toString();

            // Check if EditText is empty
            if (input.isEmpty()) {
                editText.setError("Input cannot be empty!");
            } else {
                boolean isChecked = checkBox.isChecked();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedRadioText = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "None";
                String selectedSpinner = spinner.getSelectedItem().toString();
                int progress = seekBar.getProgress();
                boolean isSwitched = switchControl.isChecked();

                // Show a Toast message with the collected input
                Toast.makeText(this, "Input: " + input + "\nChecked: " + isChecked +
                                "\nSelected Radio: " + selectedRadioText + "\nSelected Spinner: " + selectedSpinner +
                                "\nSeekBar Progress: " + progress + "\nSwitch: " + isSwitched,
                        Toast.LENGTH_LONG).show();

                // Show the CheckBox
                checkBox.setVisibility(View.VISIBLE);
            }
        });
    }
}
