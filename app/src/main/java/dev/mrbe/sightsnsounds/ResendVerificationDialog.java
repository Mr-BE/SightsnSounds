package dev.mrbe.sightsnsounds;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResendVerificationDialog extends DialogFragment {

    private final String TAG = "MailResendVerification";
    private EditText mConfirmEmail, mConfirmPassword;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resend_verification_mail_dialog, container, false);
        mContext = getActivity();
        mConfirmEmail = view.findViewById(R.id.confirm_email);
        mConfirmPassword = view.findViewById(R.id.confirm_password);


        //Confirm action
        final TextView mConfirm = view.findViewById(R.id.dialogConfirm);
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(mConfirmEmail.getText().toString()) || !isEmpty(mConfirmPassword.getText().toString())) {
                    authenticateAndReverify(mConfirmEmail.getText().toString(), mConfirmPassword.getText().toString());
                } else {
                    Toast.makeText(mContext, "Please complete all fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Cancel dialog
        TextView mCancel = view.findViewById(R.id.dialogCancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
                getDialog().dismiss();
            }
        });

        return view;
    }

    private void authenticateAndReverify(String email, String password) {
        AuthCredential credential = EmailAuthProvider.getCredential(email, password);
        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "onClick: authentication successful");
                            sendVerification();
                            FirebaseAuth.getInstance().signOut();
                            getDialog().cancel();
                            getDialog().dismiss();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onClick; Authentication failed " + e);
                Toast.makeText(mContext, "Sorry, Could not authenticate.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendVerification() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "onClick: Verification mail resent");
                        Toast.makeText(mContext, "Please check your mail for verification", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d(TAG, "onClick: Could not send Verification mail");
                        Toast.makeText(mContext, "Could not send verification mail", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Log.d(TAG, "onClick: no user");

        }
    }

    private boolean isEmpty(String string) {
        return string.equals("");
    }
}
