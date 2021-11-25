package com;

import java.util.concurrent.atomic.AtomicInteger;

public class Joueur { 
 private String code;
 private String nom;
 private String prenom;
 private static final AtomicInteger ID = new AtomicInteger();
 
 public Joueur(String nom,String prenom)
 {
	 this.code = "joueur"+ID.getAndIncrement();
	 this.nom = nom;
	 this.prenom = prenom; 
 }
 
 public void setNom(String nom) {
		this.nom = nom;
	}
public String getNom() {
		return this.nom;
   }
 public void setPrenom(String prenom) {
			this.prenom = prenom;
  }
public String getPreom() {
			return this.prenom;
  }
public String getCode() {
	return this.code;
}
public void setCode(String code) {
	this.code = code;
}

}
