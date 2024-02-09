package com.ztvgzh.computerservice;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ztvgzh.computerservice.Models.User;

public class MainActivity extends AppCompatActivity {
    Button signIn, register;
    FirebaseDatabase db;
    DatabaseReference users;
    ConstraintLayout root;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signIn = findViewById(R.id.voyti);
        register = findViewById(R.id.zareg);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        if(user != null)
        {  startActivity(new Intent(this, Dashboard.class));
           finish();
        }

        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        root =findViewById(R.id.root);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showRegWindow();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignInWindow();
            }
        });

    }

    private void showSignInWindow(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Вход в систему");
        dialog.setMessage("Введите все данные для входа");

        LayoutInflater inflater = LayoutInflater.from(this);
        View signIn = inflater.inflate(R.layout.sign_in_window, null);
        dialog.setView(signIn);
        final EditText email = signIn.findViewById(R.id.email);
        final EditText password = signIn.findViewById(R.id.password);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root, "Введите e-mail полностью", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(password.getText().toString().length() < 6){
                    Snackbar.make(root, "Введите пароль корректно", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(MainActivity.this, Dashboard.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка авторизации. " + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
        dialog.show();
    }
    private void showRegWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Регистрация");
        dialog.setMessage("Введите все данные для регистрации");

        LayoutInflater inflater = LayoutInflater.from(this);
        View regWin = inflater.inflate(R.layout.reg_window, null);
        dialog.setView(regWin);
        final EditText name = regWin.findViewById(R.id.name);
        final EditText number = regWin.findViewById(R.id.number);
        final EditText email = regWin.findViewById(R.id.email);
        final EditText password = regWin.findViewById(R.id.password);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(root, "Введите ФИО", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root, "Введите e-mail полностью", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(number.getText().toString())){
                    Snackbar.make(root, "Введите номер вашего телефона", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(password.getText().toString().length() < 6){
                    Snackbar.make(root, "Введите пароль, который более 5 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                //register
                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User user = new User();
                                user.setEmail(email.getText().toString());
                                user.setNumber(number.getText().toString());
                                user.setName(name.getText().toString());
                                user.setPassword(password.getText().toString());
                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Snackbar.make(root, "Пользователь добавлен!", Snackbar.LENGTH_SHORT).show();
                                                startActivity(new Intent(MainActivity.this, Dashboard.class));
                                                finish();
                                            }
                                        });
                            }
                        });
            }
        });
        dialog.show();
    }
}