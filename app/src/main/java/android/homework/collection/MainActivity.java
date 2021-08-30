package android.homework.collection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.homework.collection.databinding.ActivityMainBinding;
import android.homework.collection.intent.ParseDataActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // initialize event
        onButtonHomeworkIntentClicked();
    }

    private void onButtonHomeworkIntentClicked() {

        binding.buttonHomeworkIntent.setOnClickListener(evt -> {
            Intent intent = new Intent(this, ParseDataActivity.class);
            startActivity(intent);
        });

    }

}