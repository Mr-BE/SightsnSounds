package dev.mrbe.sightsnsounds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = "LoginActivity";

    //widgets
    private EditText mEmail, mPassword;
    private ProgressBar mProgressBar;
    private Button mSigninButton;
    private TextView mRegister, mForgotPassword, mResendVerification;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email_ET_login);
        mPassword = findViewById(R.id.password_ET_login);
        mProgressBar = findViewById(R.id.login_ProgressBar);
        mSigninButton = findViewById(R.id.signin_button);
        mRegister = findViewById(R.id.register_text_button);
        mForgotPassword = findViewById(R.id.forgot_password);

        hideDialog();
        //verify user's authentication status
        setupFirebaseAuth();

        //Register user
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                Log.d(TAG, "onClick: redirecting to register activity");
                startActivity(intent);
            }
        });
        //Resend verification
        TextView mResendVerification = findViewById(R.id.resend_verification);
        mResendVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResendVerificationDialog dialog = new ResendVerificationDialog();
                dialog.show(getSupportFragmentManager(), "resend_verification_dialog");
            }
        });

        //Sign in user
        mSigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                showDialog();
                FirebaseAuth.getInstance().signInWithEmailAndPassword(mEmail.getText().toString(), mPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(LoginActivity.this, AttractionActivity.class);
                                    Log.d(TAG, "onClick: Signing in user -> " + mEmail.getText().toString());
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Log.d(TAG, "onClick: Could not sign in user -> " + mEmail.getText().toString());
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        hideDialog();
                        Log.d(TAG, "onClick: Could not sign in user -> " + e);
                        Toast.makeText(LoginActivity.this, "Error signing in", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        //Forgot password
        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgotPasswordDialog dialog = new ForgotPasswordDialog();
                dialog.show(getSupportFragmentManager(), "forgot_password_dialog");
            }
        });
    }

    /**
     * FireBAse Setup
     */
    private void setupFirebaseAuth() {
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();// if null, no auth user
                if (user != null) {
                    if (user.isEmailVerified()) {
                        Log.d(TAG, "onAuthStateChanged: signed_in " + user.getUid());
                        Toast.makeText(LoginActivity.this, "Authenticated with: " + user.getEmail(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Check your email for verification link", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                    }
                } else {
                    Log.d(TAG, "onAuthStateChanged: signed_out");
                }
            }
        };
    }

    private void hideSoftKeyboard() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void showDialog() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideDialog() {
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {//Perform check to prevent app crash
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener);
    }

}
