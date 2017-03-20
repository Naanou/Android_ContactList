package com.nael.mycontactlist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Madanael on 03/03/2017.
 */

public class Contact implements Serializable {

    char sexe;
    String prenom;
    String nom;
    String naissance;
    String tel;
    String mail;

    public Contact(String prenom, String nom, String naissance, char s, String tel, String mail){
        if (s=='M' || s=='F') sexe = s;
        else s = 'X';
        this.prenom = prenom;
        this.nom = nom;
        this.naissance = naissance;
        this.tel = tel;
        this.mail = mail;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == null || obj==null) return false;
        else if(this.getClass() != obj.getClass()) return false;
        Contact c = (Contact) obj;

        return (this.prenom==c.prenom && this.nom==c.nom);
    }

    @Override
    public String toString() {
        return prenom+" "+nom;
    }

    public static ArrayList<Contact> getListOfContact(){
        ArrayList<Contact> liste = new ArrayList<Contact>();

        liste.add(new Contact("Alice","Bekima","01/01/01",'F',"0000000000",""));
        liste.add(new Contact("Maureen","Louisy-Joseph","01/01/02",'F',"0000000001",""));
        liste.add(new Contact("Jean-Pierre","Vang","01/01/03",'M',"0000000002",""));
        liste.add(new Contact("Djesone","Moufouad","01/01/04",'M',"0000000003",""));
        liste.add(new Contact("Randy","Makaia","01/01/05",'M',"0000000004",""));
        liste.add(new Contact("Elodie","Sorce","01/01/06",'F',"0000000005",""));
        liste.add(new Contact("Aurélien","Sorce","10/01/01",'M',"0000000006",""));
        liste.add(new Contact("Mélanie","Mota","01/15/01",'F',"0000000007",""));
        liste.add(new Contact("Anthony","Mota","01/01/10",'M',"0000000008",""));
        liste.add(new Contact("David","Caillat","24/11/01",'M',"0000000009",""));
        liste.add(new Contact("Adrien","Grève","30/01/87",'M',"0000000010",""));
        liste.add(new Contact("Barbara","Fils","01/02/02",'F',"0000000011",""));
        liste.add(new Contact("Johanna","Coco","03/03/91",'F',"0000000012",""));
        liste.add(new Contact("Joella","Coco","12/07/90",'F',"0000000013",""));
        liste.add(new Contact("Anthony","Farho","12/08/93",'M',"0000000014",""));
        liste.add(new Contact("Meyléna","Ratsimbazafy","23/07/70",'F',"0000000015",""));
        liste.add(new Contact("Ethane","Ratsimbazafy","4/12/00",'M',"0000000016",""));
        liste.add(new Contact("Mathys","Payet","12/07/04",'M',"0000000017",""));
        liste.add(new Contact("Wilson","Ramanich","21/07/16",'M',"0000000018",""));
        liste.add(new Contact("Céline","Vincent-Sully","19/04/90",'F',"0000000019",""));

        return liste;
    }
}
