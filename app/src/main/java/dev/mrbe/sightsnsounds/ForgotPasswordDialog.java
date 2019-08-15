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
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ForgotPasswordDialog extends DialogFragment {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private final String TAG = "ForgotPasswordDialog";
    private EditText mEmail;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forgot_password_dialog, container, false);

        mContext = getActivity();
        mEmail = view.findViewById(R.id.password_dialog_email);

        //Cancel Dialog
        TextView dialogCancel = view.findViewById(R.id.passwordDialogCancel);
        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
                getDialog().dismiss();
            }
        });

        //Confirm dialog
        TextView dialogConfirm = view.findViewById(R.id.passwordDialogConfirm);
        dialogConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEmail(mEmail.getText().toString()) || !isEmpty(mEmail.getText().toString())) {
                    sendPasswordResetLink(mEmail.getText().toString());
                    getDialog().cancel();
                    getDialog().dismiss();
                } else {
                    Log.d(TAG, "Invalid email address");
                    Toast.makeText(mContext, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void sendPasswordResetLink(String email) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "onClick: Password reset link sent");
                    Toast.makeText(mContext, "Please check your mail for a reset link", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Could not reset password", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Could not sent password reset email -> " + e);
            }
        });
    }

    private boolean isValidEmail(String email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
    }

    private boolean isEmpty(String s) {
        return s.equals("");
    }
}

