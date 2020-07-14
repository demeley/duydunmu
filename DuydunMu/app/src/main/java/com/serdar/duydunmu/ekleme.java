package com.serdar.duydunmu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ekleme extends AppCompatActivity {

    Button btn,btn2,btn3,btn4;
    EditText k1,k2,k3,k4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ekleme);
        btn=(Button)findViewById(R.id.ara);
        btn2=(Button)findViewById(R.id.soru);
        btn3=(Button)findViewById(R.id.ana);
        btn4=(Button)findViewById(R.id.ekle);
        k1=(EditText)findViewById(R.id.kelime);
        k2=(EditText)findViewById(R.id.kelime2);
        k3=(EditText)findViewById(R.id.kelime3);
        k4=(EditText)findViewById(R.id.kelime4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String metin,hece,vlink,rlink;
                metin=k1.getText().toString();
                hece=k2.getText().toString();
                vlink=k3.getText().toString();
                rlink=k4.getText().toString();
                Database baglanti=new Database(getApplicationContext());
                baglanti.VeriEkle(metin,hece,vlink,rlink);
                baglanti.close();
                Toast.makeText(getApplicationContext(),"Veri kaydı başarıyla gerçekleştirilmiştir", Toast.LENGTH_LONG).show();
                k1.setText("");
                k2.setText("");
                k3.setText("");
                k4.setText("");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sorular=new Intent(ekleme.this,Sorular.class);
                startActivity(sorular);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent index=new Intent(ekleme.this,MainActivity.class);
                startActivity(index);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle=new Intent(ekleme.this,kelimeEkle.class);
                startActivity(ekle);
            }
        });
    }
}
