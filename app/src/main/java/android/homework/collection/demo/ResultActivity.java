package android.homework.collection.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.homework.collection.R;
import android.homework.collection.databinding.ActivityResultBinding;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            User user = (User) intent.getSerializableExtra("user");
            if (user != null)
                binding.textViewName.setText(user.getName());
        }
    }
}