package android.homework.collection.intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.homework.collection.databinding.ActivityParseDataBinding;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ParseDataActivity extends AppCompatActivity {

    private static final String TAG = ParseDataActivity.class.getName();

    // 1 -> declare view binding
    private ActivityParseDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2 -> init bind by using layout inflater from binding self-object
        binding = ActivityParseDataBinding.inflate(getLayoutInflater());
        // 3 -> define view equals to binding.getRoot()
        View view = binding.getRoot();
        // 4 -> setContentView withing the view object
        setContentView(view);

        // initialize event
        onButtonSaveClicked();
    }

    private void onButtonSaveClicked() {
        binding.buttonSave.setOnClickListener(v -> {
            String fullName = binding.editTextFullName.getText().toString();
            String email = binding.editTextEmail.getText().toString();
            String password = binding.editTextPassword.getText().toString();
            String confirmedPassword = binding.editTextConfirmPassword.getText().toString();
            Log.i(TAG, "fullName: " + fullName);
            Log.i(TAG, "email: " + email);
            Log.i(TAG, "password: " + password);
            Log.i(TAG, "confirmedPassword: " + confirmedPassword);

            // compare password and confirmed password
            if (password.equals(confirmedPassword)) {
                Intent profileIntent = new Intent(this, ProfileActivity.class);
                profileIntent.putExtra("fullName", fullName);
                profileIntent.putExtra("email", email);
                profileIntent.putExtra("password", password);
                profileIntent.putExtra("confirmedPassword", confirmedPassword);

                onActivityResultLauncher.launch(profileIntent);

            } else {
                Toast.makeText(this, "The password is not match", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ActivityResultLauncher<Intent> onActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String message = data.getStringExtra("message");
                            Log.i(TAG, message);
                            binding.editTextFullName.setText("");
                            binding.editTextEmail.setText("");
                            binding.editTextPassword.setText("");
                            binding.editTextConfirmPassword.setText("");
                            Toast.makeText(ParseDataActivity.this, message, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
    );

}