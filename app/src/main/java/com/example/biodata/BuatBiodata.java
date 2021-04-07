package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BuatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    FloatingActionButton ton1, ton2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        text1 = (EditText)findViewById(R.id.editText1);
        text2 = (EditText)findViewById(R.id.editText2);
        text3 = (EditText)findViewById(R.id.editText3);
        text4 = (EditText)findViewById(R.id.editText4);
        text5 = (EditText)findViewById(R.id.editText5);
        ton1 = (FloatingActionButton)findViewById(R.id.button1);
        ton2 = (FloatingActionButton)findViewById(R.id.button2);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db =dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata (no, nama, tgl, jk, alamat) values ('"+text1.getText().toString()+"','"+text2.getText().toString()+"', '"+text3.getText().toString()+"', '"+text4.getText().toString()+"', '"+text5.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();

            }
        });

        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}