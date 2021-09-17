package android.homework.collection.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.homework.collection.databinding.ActivityUserBinding;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = UserActivity.class.getName();
    private ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // invoke when new intent is created
        onNewIntent(getIntent());

        // init event onClick
        onButtonGoBackClicked();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent");
        if (intent != null) {
            Log.e(TAG, "onNewIntent: Intent is not null");
            String fullName = intent.getStringExtra("fullName");
            String email = intent.getStringExtra("email");
            String password = intent.getStringExtra("password");
            String confirmedPassword = intent.getStringExtra("confirmedPassword");
            Log.e(TAG, "onNewIntent: " + fullName);
            Log.e(TAG, "onNewIntent: " + email);
            Log.e(TAG, "onNewIntent: " + password);
            Log.e(TAG, "onNewIntent: " + confirmedPassword);
            binding.textViewDataFullName.setText(fullName);
            binding.textViewDataEmail.setText(email);
            binding.textViewDataPassword.setText(password);
        } else {
            Log.e(TAG, "onNewIntent: Intent is null");
        }
    }

    private void onButtonGoBackClicked() {
        binding.buttonGoBack.setOnClickListener(v -> {

            Intent intent = new Intent();
            intent.putExtra("message", "Please create a new profile again");
            setResult(RESULT_OK, intent);
            finish();

        });
    }
}