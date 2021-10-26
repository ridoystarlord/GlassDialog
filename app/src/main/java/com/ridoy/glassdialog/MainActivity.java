package com.ridoy.glassdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Glassdialog glassdialog;
    Button successBtn,errorBtn,infoBtn,warningBtn,customBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        successBtn=findViewById(R.id.successBtn);
        errorBtn=findViewById(R.id.errorBtn);
        infoBtn=findViewById(R.id.infoBtn);
        warningBtn=findViewById(R.id.warningBtn);
        customBtn=findViewById(R.id.customBtn);

        successBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glassdialog=new Glassdialog(MainActivity.this,Glassdialog.SUCCESS_TYPE);
                glassdialog.setTitle("Succss Glass Dialog");
                glassdialog.setConfirmButtonText("Ok");
                glassdialog.setMessage("Hi Bro, I am new born glass dialog.\nDid you like me?");
                glassdialog.setConfirmClickListener(new Glassdialog.Glasslisner() {
                    @Override
                    public void onClick(Glassdialog dialog) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Successfully Created", Toast.LENGTH_SHORT).show();
                    }
                });
                glassdialog.show();
            }
        });
        errorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glassdialog=new Glassdialog(MainActivity.this,Glassdialog.ERROR_TYPE);
                glassdialog.setTitle("Error Glass Dialog");
                glassdialog.setConfirmButtonText("Ok");
                glassdialog.setCancelButtonText("Cancel");
                glassdialog.setMessage("Hi Bro, I am new born glass dialog.\nDid you like me?");
                glassdialog.setConfirmClickListener(new Glassdialog.Glasslisner() {
                    @Override
                    public void onClick(Glassdialog dialog) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Successfully Created", Toast.LENGTH_SHORT).show();
                    }
                });
                glassdialog.show();
            }
        });
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glassdialog=new Glassdialog(MainActivity.this,Glassdialog.INFO_TYPE);
                glassdialog.setTitle("Info Glass Dialog");
                glassdialog.setConfirmButtonText("Ok");
                glassdialog.setMessage("Hi Bro, I am new born glass dialog.\nDid you like me?");
                glassdialog.setConfirmClickListener(new Glassdialog.Glasslisner() {
                    @Override
                    public void onClick(Glassdialog dialog) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Successfully Created", Toast.LENGTH_SHORT).show();
                    }
                });
                glassdialog.show();
            }
        });
        warningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glassdialog=new Glassdialog(MainActivity.this,Glassdialog.WARNING_TYPE);
                glassdialog.setTitle("Warning Glass Dialog");
                glassdialog.setConfirmButtonText("Ok");
                glassdialog.setCancelButtonText("Cancel");
                glassdialog.setMessage("Hi Bro, I am new born glass dialog.\nDid you like me?");
                glassdialog.setConfirmClickListener(new Glassdialog.Glasslisner() {
                    @Override
                    public void onClick(Glassdialog dialog) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Successfully Created", Toast.LENGTH_SHORT).show();
                    }
                });
                glassdialog.show();
            }
        });
        customBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glassdialog=new Glassdialog(MainActivity.this,Glassdialog.CUSTOM_TYPE,"team.json");
                glassdialog.setTitle("Custom Glass Dialog");
                glassdialog.setConfirmButtonText("Ok");
                glassdialog.setMessage("Hi Bro, I am new born glass dialog.\nDid you like me?");
                glassdialog.setConfirmClickListener(new Glassdialog.Glasslisner() {
                    @Override
                    public void onClick(Glassdialog dialog) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Successfully Created", Toast.LENGTH_SHORT).show();
                    }
                });
                glassdialog.show();
            }
        });


    }
}