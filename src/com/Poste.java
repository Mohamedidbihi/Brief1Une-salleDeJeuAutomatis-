package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public  class Poste {
private int num;
private String tv;
private String console;
private String games;
private ArrayList<Jeu> times;

int SalleAttente = 0;
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
int day = Integer.parseInt(LocalDate.now().format(formatter));

public  boolean get() {
	 for(Jeu fruit:times) {		 
		 System.out.println(fruit);    
	 }
	return true;	  
}

public void setGames(String games) {
	this.games = games;
}
public String getGames() {
	return this.games;
}

public void setNum(int num) {
	this.num = num;
}
public int getNum() {
	return this.num;
}

public void setTv(int tv) {
	this.num = tv;
}
public String getTv() {
	return this.tv;
}
public void setConsole(int console) {
	this.num = console;
}
public String getConsole() {
	return this.console;
}
public Poste(int num, String tv, String console,String games) {
	this.num = num;
	this.tv = tv;
	this.console = console;
	this.games=games;	
    times = new ArrayList<Jeu>();
}
public ArrayList<Jeu> getTimes(){
    return times;
}
public void reserver(double debut,double fin ,String code) {
	GregorianCalendar now1 = new GregorianCalendar();
    double hr = now1.get(Calendar.HOUR_OF_DAY);
    double min = now1.get(Calendar.MINUTE)*(0.01);
    double dd = hr+min;
	boolean res=true;
	 for(Jeu j : times) {			 
		 if( (debut >= j.getDebut() && debut < j.getFin()) || (fin > j.getDebut() && fin < j.getFin())) {
			 res=false;
			 break;
		 }
		 else
		 {
			 if(debut != dd && SalleAttente<10)
			 {
				 SalleAttente ++;
				 res=true;
			 }
			 else if(SalleAttente == 10) {
				 System.out.println("Salle d'attente plein a la prochaine fois");
				 break;
			 }
			 else {
				 res=true;
				 SalleAttente--;
			 }
		 }
	 }
	 if(res) {	 
		 times.add(new Jeu(debut,fin,code) );
		 System.out.println("Bien Reserver pour  le poste :" + num + "Heure debut : " +debut + "Code du joueur : "+code);
	 }
	 else {
		 System.out.println("Poste Occupé !! Poste : "+ num);
	 } 
}

public void revenue(int tarif) {
	int dailytarif=0;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	int dnow = Integer.parseInt(LocalDate.now().format(formatter));
	if(day == dnow) {
		dailytarif=dailytarif+tarif;
	}
	else
	{
		dailytarif=tarif;
		this.day = Integer.parseInt(LocalDate.now().format(formatter));
	}
	System.out.printf("les revenu du jour : %t ",dailytarif);
}

}
