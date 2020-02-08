package com.fraiman.zeev.plusrussianteam02;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    Button bL01, bL02, bL03;
    String st="1";
    Intent go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        bL01=findViewById(R.id.bL01);
        bL01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go=new Intent(Welcome.this, Level01.class);
                what(go);
            }
        });

        bL02=findViewById(R.id.bL02);
        bL02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go=new Intent(Welcome.this, Level02.class);
                what(go);
            }
        });

        bL03=findViewById(R.id.bL03);
        bL03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go=new Intent(Welcome.this, Level03.class);
                what(go);
            }
        });
    }

    private void what(final Intent go) {
        Context context;
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Harflerin siralanmasini sec");
        adb.setCancelable(false);
        adb.setPositiveButton("Harflerin alfabetik siralanmasi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                st="1";
                go.putExtra("what",st);
                startActivity(go);
            }
        });
        adb.setNegativeButton("Harflerin karisik siralanmasi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                st="2";
                go.putExtra("what",st);
                startActivity(go);
            }
        });
        adb.create().show();
    }
}
