package com.serdar.duydunmu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sorular extends AppCompatActivity {
    Button btn,btn2,btn3,btn4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorular);
        btn2=(Button)findViewById(R.id.soru);
        btn3=(Button)findViewById(R.id.ana);
        btn4=(Button)findViewById(R.id.ekle);
        btn =(Button)findViewById(R.id.ara2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arama=new Intent(Sorular.this,mesaj.class);
                startActivity(arama);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sorular=new Intent(Sorular.this,Sorular.class);
                startActivity(sorular);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent index=new Intent(Sorular.this,MainActivity.class);
                startActivity(index);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle=new Intent(Sorular.this,kelimeEkle.class);
                startActivity(ekle);
            }
        });
    }
}
