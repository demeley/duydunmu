package com.serdar.duydunmu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Arama extends AppCompatActivity {
    EditText kelimeText;
    Button btn,btn2,btn3,btn4;
    TextView heceleme,hatam;
    VideoView video;
    ImageView resim;
    String hecele,vlink,rlink;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arama);
        btn=(Button)findViewById(R.id.ara);
        btn2=(Button)findViewById(R.id.soru);
        btn3=(Button)findViewById(R.id.ana);
        btn4=(Button)findViewById(R.id.ekle);
        heceleme=(TextView)findViewById(R.id.kelime_hece);
        hatam=(TextView)findViewById(R.id.hata);
        resim=(ImageView)findViewById(R.id.resim);
        kelimeText=(EditText)findViewById(R.id.kelime);
        video = (VideoView) findViewById(R.id.kelime_Video);

        Bundle veriler=getIntent().getExtras();
        if(veriler!=null){
            hecele=veriler.getString("hece");
            Database db=new Database(getApplicationContext());
            HashMap<String,String> kelimedetay=db.Kelime_Getir(hecele);
            kelimeText.setText(hecele);
            if(kelimedetay.isEmpty()){
                hatam.setVisibility(View.VISIBLE);
                hatam.setText("Aradığınız Kelime Veritabanında Bulunamamıştır.");
                resim.setVisibility(View.INVISIBLE);
                video.setVisibility(View.INVISIBLE);
                heceleme.setVisibility(View.INVISIBLE);
            }else {
                heceleme.setText(kelimedetay.get("heceleme"));
                int video_id = getResources().getIdentifier(kelimedetay.get("vlink"), "raw", getPackageName());
                vlink = "android.resource://" + getPackageName() + "/" + video_id;
                resim.setImageResource(getResources().getIdentifier(kelimedetay.get("rlink"), "drawable", getPackageName()));
                video.setVideoURI(Uri.parse(vlink));
                MediaController vidControl = new MediaController(this);
                video.setMediaController(vidControl);
                video.start();

            }

        }else {
            //Boş ekran ayarları burada yapılacak
            hatam.setVisibility(View.VISIBLE);
            hatam.setText("Lütfen kelime girerek arama yapınız");
            resim.setVisibility(View.INVISIBLE);
            video.setVisibility(View.INVISIBLE);
            heceleme.setVisibility(View.INVISIBLE);
        }


         btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ara=new Intent(Arama.this,Arama.class);
                ara.putExtra("hece",kelimeText.getText().toString());
                startActivity(ara);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sorular=new Intent(Arama.this,Sorular.class);
                startActivity(sorular);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent index=new Intent(Arama.this,MainActivity.class);
                startActivity(index);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle=new Intent(Arama.this,kelimeEkle.class);
                startActivity(ekle);
            }
        });
    }
}
