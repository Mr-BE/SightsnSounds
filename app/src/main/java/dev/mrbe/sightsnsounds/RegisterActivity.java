package dev.mrbe.sightsnsounds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    //constants
    private final String TAG = "Register Activity";
    //widgets
    private EditText mEmail, mPassword, mConfirmPassword;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = findViewById(R.id.email_ET);
        mPassword = findViewById(R.id.password_ET);
        mConfirmPassword = findViewById(R.id.confirm_password_ET);
        mProgressBar = findViewById(R.id.register_PB);

        hideDialog();

        Button mRegisterButton = findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                //null entry check
                if (!isEmpty(mEmail.getText().toString())
                        || (!isEmpty(mPassword.getText().toString())
                        || (!isEmpty(mConfirmPassword.getText().toString())))) {
                    //valid email check
                    if (isValidEmail(mEmail.getText().toString())) {
                        //password match check
                        if (stringsMatch(mPassword.getText().toString(), mConfirmPassword.getText().toString())) {
                            registerNewAccount(mEmail.getText().toString(), mPassword.getText().toString());
                        } else {
                            Log.d(TAG, "onClick: Password fields do not match");
                            Toast.makeText(RegisterActivity.this, " Please ensure that passwords match", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Log.d(TAG, "onClick: Invalid email address");
                        Toast.makeText(RegisterActivity.this, " Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d(TAG, "onClick: Incomplete registration fields");
                    Toast.makeText(RegisterActivity.this, "Please Complete all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void registerNewAccount(final String email, String password) {
        showDialog();
        hideSoftKeyboard();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "onClick: registering new user -> " + email);
                    sendVerificationEmail();
                    FirebaseAuth.getInstance().signOut();
                    redirectToLoginScreen();
                } else {
                    Log.d(TAG, "onClick: Couldn't register user");
                }
                hideDialog();
            }
        });
    }

    private void redirectToLoginScreen() {
        Log.d(TAG, "redirectingLoginScreen: redirecting to login screen.");
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void sendVerificationEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Verification email sent");
                        Toast.makeText(RegisterActivity.this, "Please check your email for verification mail", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Couldn't send verification mail", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Log.d(TAG, "No user found");
        }
    }

    private void showDialog() {
        if (mProgressBar.getVisibility() != View.VISIBLE) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    private void hideDialog() {
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    private void hideSoftKeyboard() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private boolean isValidEmail(String email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
    }

    private boolean stringsMatch(String s1, String s2) {
        return s1.equals(s2);
    }

    private boolean isEmpty(String s) {
        return s.equals("");
    }
}
