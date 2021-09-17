package android.homework.collection.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.homework.collection.R;
import android.homework.collection.databinding.ActivityRegisterBinding;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // bind event
        onButtonCreateNameClicked();
    }

    private void onButtonCreateNameClicked() {
        binding.buttonCreateName.setOnClickListener(v -> {
            String name = binding.editTextName.getText().toString();
            User user = new User(name);
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        });
    }

}