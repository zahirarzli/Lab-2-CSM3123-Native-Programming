package com.example.imageexperiment;

import android.animation.ObjectAnimator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout; // Import ConstraintLayout

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;  // Use ConstraintLayout here
    private int[] backgrounds = {R.drawable.background_image1, R.drawable.background_image2};
    private int currentBackground = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main);  // Reference the ConstraintLayout by its ID

        // Image Button (Pressable)
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> switchBackground());
    }

    // Method to switch the background with fade animation
    private void switchBackground() {
        // Fade out the current background
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(layout, "alpha", 1f, 0f);
        fadeOut.setDuration(500); // Fade out duration
        fadeOut.start();

        // Once fade-out is complete, switch background and fade in
        fadeOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                // Switch to the next background
                currentBackground = (currentBackground + 1) % backgrounds.length;
                layout.setBackgroundResource(backgrounds[currentBackground]);

                // Fade in the new background
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(layout, "alpha", 0f, 1f);
                fadeIn.setDuration(500); // Fade in duration
                fadeIn.start();
            }
        });
    }
}
