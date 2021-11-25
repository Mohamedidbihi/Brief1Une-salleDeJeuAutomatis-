package com;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Jeu {
private double debut;
private double fin;
private String code ;
	
public Jeu(double d,double f , String code) {
	this.debut = d;
	this.fin = f;	
	this.code = code;
}
public void setDebut(double debut) {
	this.debut = debut;
}
public double getDebut() {
	return this.debut;
}
public void setFin(double debut) {
	this.debut = debut;
}
public Double getFin() {
	return this.fin;
}
public void setCode(String code) {
	this.code = code;
}

public String getCode() {
	return this.code;
}

public void urTime() {
	GregorianCalendar now1 = new GregorianCalendar();
    double hr = now1.get(Calendar.HOUR_OF_DAY);
    double min = now1.get(Calendar.MINUTE)*(0.01);
    double dd = hr+min;
    if(dd == this.debut)
    System.out.println ("It's your turn "+ this.code);
    
}


}
