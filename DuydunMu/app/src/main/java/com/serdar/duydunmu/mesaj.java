package com.serdar.duydunmu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class mesaj extends AppCompatActivity {
    Button btn2,btn3,btn4,btngonder;
    EditText mesaj,mail;
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mesaj);
        btngonder=(Button)findViewById(R.id.gonder);
        btn2=(Button)findViewById(R.id.soru);
        btn3=(Button)findViewById(R.id.ana);
        btn4=(Button)findViewById(R.id.ekle);
        mesaj=(EditText)findViewById(R.id.message);
        mail=(EditText)findViewById(R.id.eposta);
        btngonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Soru sorma");//Email konusu
                emailIntent.putExtra(Intent.EXTRA_TEXT, mesaj.getText());//Email içeriği
                startActivity(Intent.createChooser(emailIntent, "E-mail Göndermek için Seçiniz:")); //birden fazla email uygulaması varsa seçmek için
                String aEmailList[] = { "duydunn.mmu@gmail.com" };  //Mail gönderilecek kişi.Birden fazla ise virgülle ayırarak yazılır
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                startActivity(emailIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sorular=new Intent(mesaj.this,Sorular.class);
                startActivity(sorular);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent index=new Intent(mesaj.this,MainActivity.class);
                startActivity(index);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle=new Intent(mesaj.this,kelimeEkle.class);
                startActivity(ekle);
            }
        });
    }
}
