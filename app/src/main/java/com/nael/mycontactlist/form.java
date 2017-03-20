package com.nael.mycontactlist;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class form extends AppCompatActivity {

    EditText edtxt_pre;
    EditText edtxt_nom;
    EditText edtxt_tel;
    EditText edtxt_ddn;
    EditText edtxt_mail;
    RadioButton rdb_h;
    RadioButton rdb_f;
    Button valider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtxt_pre = (EditText) findViewById(R.id.edtxt_prenom);
        edtxt_nom = (EditText) findViewById(R.id.edtxt_nom);
        edtxt_tel = (EditText) findViewById(R.id.edtxt_mail);
        edtxt_ddn = (EditText) findViewById(R.id.edtxt_ddn);
        edtxt_mail = (EditText) findViewById(R.id.edtxt_mail);
        rdb_h = (RadioButton) findViewById(R.id.radio_homme);
        rdb_f = (RadioButton) findViewById(R.id.radio_femme);
        valider = (Button) findViewById(R.id.button);
    }


    public void submit(View v) throws Exception{
        String prenom = edtxt_pre.getText().toString();
        String nom = edtxt_nom.getText().toString();
        String tel = edtxt_tel.getText().toString();
        String ddn = edtxt_ddn.getText().toString();
        String mail = edtxt_mail.getText().toString();
        char sexe;

        if (rdb_h.isChecked()) sexe = 'M';
        else if (rdb_f.isChecked()) sexe = 'F';
        else sexe = 'I';

        Contact c = new Contact(prenom,nom,ddn,sexe,tel,mail);

        Intent myIntent = new Intent(form.this,MainActivity.class);
        myIntent.putExtra("contact",c);
        setResult(RESULT_OK,myIntent);
        finish();

        /*
        try {
            FileOutputStream fos = new FileOutputStream("contact.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(c);
            oos.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finish(c);
        */
    }

}
