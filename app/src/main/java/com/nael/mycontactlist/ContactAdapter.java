package com.nael.mycontactlist;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Madanael on 09/03/2017.
 */

public class ContactAdapter extends ArrayAdapter<Contact>{

    Context myContext;
    int myLayoutResourceId;
    ArrayList<Contact> data = null;

    public ContactAdapter(Context context, int layoutResourceId, ArrayList<Contact> contactData){
        super(context,layoutResourceId,contactData);
        myContext = context;
        myLayoutResourceId = layoutResourceId;
        data = contactData;
    }

    public int getCount(){
        return data.size();
    }

    public long getItemId(int position){
        return position;
    }

    public Contact getItem(int position){
        return data.get(position);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();
            convertView = inflater.inflate(myLayoutResourceId,parent,false);
        }

        ImageView contactIcon = (ImageView) convertView.findViewById(R.id.img);
        TextView  tv_prenom = (TextView) convertView.findViewById(R.id.prenom);
        TextView tv_nom = (TextView) convertView.findViewById(R.id.nom);

        Contact c = data.get(position);

        if(c.sexe=='M') contactIcon.setImageResource(R.mipmap.ic_lcontact);
        else if (c.sexe=='F') contactIcon.setImageResource(R.mipmap.ic_contact_f);
        else contactIcon.setImageResource(R.mipmap.ic_contact);
        tv_prenom.setText(c.prenom);
        tv_nom.setText(c.nom);

        return convertView;
    }
}
