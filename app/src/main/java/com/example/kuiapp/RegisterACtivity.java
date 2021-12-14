package com.example.kuiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kuiapp.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterACtivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //initialize firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editRegisterEmail.getText().toString();
                String password = binding.edtRegisterPassword.getText().toString();
                String userName = binding.editRegisterUserName.getText().toString();
                String phoneNo = binding.edtRegisterPhoneNum.getText().toString();
                String regNo = binding.editRegisterRegNo.getText().toString();

                if(email.isEmpty()){
                    binding.editRegisterEmail.setError("Empty Email");
                }else if (password.isEmpty()){
                    binding.edtRegisterPassword.setError("Password Is Empty");
                }else if (userName.isEmpty()){
                    binding.editRegisterUserName.setError("Empty UserName");
                }else if (phoneNo.isEmpty()){
                    binding.edtRegisterPhoneNum.setError("Phone Number should not be Empty");
                }else if (regNo.isEmpty()){
                    binding.editRegisterRegNo.setError("RegNo is Empty");
                }else{
                    binding.RegisterProgressBar.setVisibility(View.VISIBLE);

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                User user = new User(userName, regNo, phoneNo, email);
                                String userId = firebaseAuth.getCurrentUser().getUid();

                                databaseReference.child(userId).setValue(user);
                            }else{
                                Toast.makeText(getApplicationContext(),"Account Creation was not successful",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    binding.textViewHaveAccount.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegisterACtivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });

    }
}