package com.sportsme.saiganesh.pickme;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emal,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        emal=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

        findViewById(R.id.btnsignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(emal.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        SharedPreferences sharedPreferences=getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("COUNT","YES");
                        Toast.makeText(signup.this, "user Created", Toast.LENGTH_SHORT).show();
                        editor.apply();
                        Intent login = new Intent(signup.this,LoginActivity.class);
                    }
                });
            }
        });
       
    }
}
