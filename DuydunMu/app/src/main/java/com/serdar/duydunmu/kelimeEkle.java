package com.serdar.duydunmu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class kelimeEkle extends AppCompatActivity {
    Button btn,btn2,btn3,btn4,btn5;
    EditText arama;
    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kelimeekle);
        arama=(EditText)findViewById(R.id.kelime);
        btn=(Button)findViewById(R.id.ara);
        btn2=(Button)findViewById(R.id.soru);
        btn3=(Button)findViewById(R.id.ana);
        btn4=(Button)findViewById(R.id.ekle);
        btn5=(Button)findViewById(R.id.yenikelime);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ekleme Talebi");//Email konusu
                emailIntent.putExtra(Intent.EXTRA_TEXT, arama.getText());//Email içeriği
                startActivity(Intent.createChooser(emailIntent, "E-mail Göndermek için Seçiniz:")); //birden fazla email uygulaması varsa seçmek için
                String aEmailList[] = { "duydunn.mmu@gmail.com" };
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                startActivity(emailIntent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sorular=new Intent(kelimeEkle.this,Sorular.class);
                startActivity(sorular);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent index=new Intent(kelimeEkle.this,MainActivity.class);
                startActivity(index);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle=new Intent(kelimeEkle.this,kelimeEkle.class);
                startActivity(ekle);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekleme=new Intent(kelimeEkle.this,ekleme.class);
                startActivity(ekleme);
            }
        });
    }
}
