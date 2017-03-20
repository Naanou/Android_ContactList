package com.nael.mycontactlist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static com.nael.mycontactlist.Contact.getListOfContact;

public class MainActivity extends AppCompatActivity {

    ListView lv_contact;
    ArrayList<Contact> contacts = getListOfContact();
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent formCall = new Intent(MainActivity.this,form.class);
                startActivityForResult(formCall,42);
            }
        });

        lv_contact = (ListView)findViewById(R.id.lv_contact);

        adapter = new ContactAdapter(this,R.layout.affichage_contact,contacts);
        lv_contact.setAdapter(adapter);

        lv_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact personne = (Contact) lv_contact.getItemAtPosition(position);

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle(personne.prenom+" "+personne.nom);
                alert.setMessage("Né(e) le:"+personne.naissance+"\n Tél: "+personne.tel+"\n Mail: "+personne.mail);
                alert.setPositiveButton("Vu", null);
                alert.show();
            }
        });

        lv_contact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                Contact personne = (Contact) lv_contact.getItemAtPosition(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Supprimer le contact");
                alert.setMessage("Voulez vous supprimez le contact "+personne.prenom+" "+personne.nom);
                alert.setPositiveButton("Supprimer",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        contacts.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("Annuler",null);
                alert.show();
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==42){
            if(resultCode==RESULT_OK){
                Contact c = (Contact) data.getSerializableExtra("contact");
                contacts.add(c);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        try {
            FileInputStream fis = new FileInputStream("contact.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Contact c = (Contact) ois.readObject();
            contacts.add(c);
            ois.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
