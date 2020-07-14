package com.serdar.duydunmu;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {
    private static final int VERITABANI_SURUM=1;
    private static final String VERITABANI_ADI="SQLLite_Veritabani";

    private static final String TABLO_ADI="veriler";
    private static String Kelime_ID="id";
    private static String Kelime="kelime";
    private static String Heceleme="heceleme";
    private static String Video_Link="vlink";
    private static String Resim_Link="rlink";

    public Database (Context context){ super(context,VERITABANI_ADI,null,VERITABANI_SURUM);}

    public void onCreate(SQLiteDatabase db){
        String TABLO_OLUSTUR ="CREATE TABLE " + TABLO_ADI + " ("
                + Kelime_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Kelime +" TEXT,"
                + Heceleme +" TEXT,"
                + Video_Link + " TEXT,"
                + Resim_Link + " TEXT)";
        db.execSQL(TABLO_OLUSTUR);
        db.execSQL("insert into "+ TABLO_ADI +"("+Kelime+","+Heceleme+","+Video_Link+","+Resim_Link+") values('Anne','An-ne','anne','anne')" );
        db.execSQL("insert into "+ TABLO_ADI +"("+Kelime+","+Heceleme+","+Video_Link+","+Resim_Link+") values('Baba','Ba-ba','baba','baba')" );
        db.execSQL("insert into "+ TABLO_ADI +"("+Kelime+","+Heceleme+","+Video_Link+","+Resim_Link+") values('Okul','O-kul','okul','okul')" );
        db.execSQL("insert into "+ TABLO_ADI +"("+Kelime+","+Heceleme+","+Video_Link+","+Resim_Link+") values('Yemek','Ye-mek','yemek','yemek')" );
        db.execSQL("insert into "+ TABLO_ADI +"("+Kelime+","+Heceleme+","+Video_Link+","+Resim_Link+") values('Merhaba','Mer-ha-ba','merhaba','merhaba')" );

    }

   public void onUpgrade(SQLiteDatabase arg0,int arg1,int arg2){

    }

    public HashMap<String,String> Kelime_Getir(String gelenkelime){
        HashMap<String,String> hece=new HashMap<String, String>();
        String SQL="SELECT * FROM "+TABLO_ADI+" WHERE "+Kelime+"='" + gelenkelime +"' COLLATE NOCASE";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery(SQL,null);
        cur.moveToFirst();
        if (cur.getCount()>0){
            hece.put(Heceleme,cur.getString(2));
            hece.put(Video_Link,cur.getString(3));
            hece.put(Resim_Link,cur.getString(4));
        }
        cur.close();
        db.close();
        return  hece;
    }


    public void VeriEkle(String kelime,String heceleme,String vlink,
                         String rlink)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(Kelime,kelime.trim());
        cv.put(Heceleme,heceleme.trim());
        cv.put(Video_Link,vlink.trim());
        cv.put(Resim_Link,rlink.trim());
        db.insert(TABLO_ADI,null,cv);
        db.close();
    }


}