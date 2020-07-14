package com.serdar.duydunmu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText arama;
    Button btn,btn2,btn3,btn4;
    String hece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arama=(EditText)findViewById(R.id.kelime);
        btn=(Button)findViewById(R.id.ara);
        btn2=(Button)findViewById(R.id.soru);
        btn3=(Button)findViewById(R.id.ana);
        btn4=(Button)findViewById(R.id.ekle);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ara=new Intent(MainActivity.this,Arama.class);
                ara.putExtra("hece",arama.getText().toString());
                startActivity(ara);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sorular=new Intent(MainActivity.this,Sorular.class);
                startActivity(sorular);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent index=new Intent(MainActivity.this,MainActivity.class);
                startActivity(index);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle=new Intent(MainActivity.this,kelimeEkle.class);
                startActivity(ekle);
            }
        });
    }
}
