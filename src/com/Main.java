package com;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

    public class Main {
    	
	 private  static Scanner scan = new Scanner(System.in);
	 static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	 static int day = Integer.parseInt(LocalDate.now().format(formatter));
	 static int dailytarif;
	 public static double num(double num)
	 {
		 double res=0;
		 if(num ==1 ) res = 0.3; 
		 else if(num ==2 ) res = 1; 
		 else if(num == 3) res =2;
		 else if(num == 4) res =4;
	return res;
	 }
	 public static double convertHour(double time){
			BigDecimal bigDecimal = new BigDecimal(String.valueOf(time));
			int hours = bigDecimal.intValue();
			float min =(float) ((Double.parseDouble(bigDecimal.subtract( new BigDecimal(hours)).toPlainString())*100)+ (hours * 60)) / 60;
			return min; 	
	 }
	 
	 public static boolean checkDebut(double debut){ 
		 if((debut>= 8.00 && debut<12.00)||(debut>= 14.00 && debut<20.00)){	 
			return true ;
		 }
		 else{
			return false ;
		 }
	 }
	 public static void menu() {
		 do {			 
			 System.out.println("1- Ajouter une reservation !");
			 System.out.println("2- Les tarifs du jour");
			 System.out.println("2- Les tarifs du mois");
			 int a  = scan.nextInt();
			 switch(a)
			 {
				case 1: infoJoueur() ;
				case 2: revenue(0);
				case 3:  revenue(0);
			 }
		 }
		 while(true);
			 
	 }
	 public static int tarif(int a)
	 {
		 int tarif=0;
		 if(a==1) tarif=5;
		 else if (a==2) tarif = 10;
		 else if (a==3) tarif = 18;
		 else if (a==4) tarif = 40;
		 return tarif;
	 }
	 
	 public  static boolean checkFin(double debut,double periode){
		     double fin = convertHour(debut+periode) ;
			 if((fin>= 8.00 && fin<=12.00)||(fin>= 14.00 && fin <= 20.00)) {
				 return true;
			 }
			 else {
				return false;
			 }	 
		 }
	
	 public static String newJoueur() {
		 String nom , prenom ;
		 System.out.println("Votre nom \n");
		 nom = scan.nextLine();
		 System.out.println("Votre prenom \n");
		 prenom = scan.nextLine();
		 Joueur j = new Joueur(nom,prenom);
		 return j.getCode();
	 }
	
	 public static void revenue(int tarif) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
			int dnow = Integer.parseInt(LocalDate.now().format(formatter));
			if(day == dnow) {
				dailytarif=dailytarif+tarif;
			}
			else
			{
				dailytarif=0;
				day = Integer.parseInt(LocalDate.now().format(formatter));
			}
			System.out.printf("les revenu du jour : %s \n",dailytarif);
		}
	 
	 public static void infoJoueur() {
		 String game;
		 int duree;
		 double heureDebut;
		 String[] jeux= { "FIFA , PES , PUBG ","PES , CALLOF , BLACKOPS , WARZONE","PUBG , WARZONE , BLACKOPS","GTA , FIFA , PES , PUBG"," ","WARZONE, FIFA , PES DEATH NOTE","RED DED , FIFA , PES","FIFA PES GTA  " };
		 Poste p1 = new Poste(1,"Samsung","Ps5",jeux[0]);
		 Poste p2 = new Poste(2,"Sony","Ps3",jeux[1]);
		 Poste p3 = new Poste(3,"LG","ps2",jeux[2]);
		 Poste p4 = new Poste(4,"FITCO","Ps5",jeux[3]);
		 Poste p5 = new Poste(5,"Samsung","Ps3",jeux[4]);
		 Poste p6 = new Poste(6,"Samsung","Ps4",jeux[5]);
		 Poste p7 = new Poste(7,"LG","Ps4",jeux[7]);
	
	
	     String code = newJoueur();
	     System.out.println("Votre code est : " + code );
		 System.out.println("----------------Bienvenue chez ali---------------------");
		 System.out.println("Quel jeu veux-tu jouer?");
		 game = scan.nextLine();
		 System.out.printf("---------------- Game[%s]-------------------\n",game); 
		 System.out.println("Heure début ?");
		 heureDebut =Double.parseDouble(scan.nextLine());
		 if(!checkDebut(heureDebut))
		 {
			System.out.println("Désole on travaille pas cette heure \n Les horraires de travaille \n 08=>12 et 14=>20");
		 }
		 else
		 {	 
			 System.out.println("Pour combien de temps? \n 1)30min ==> 5dh \n 2)1h ==> 10dh \n 3)2h ==> 18dh \n 4)5h ==> 40dh \n 5)Luxe ==> 65dh ");
			 duree = scan.nextInt();
		 if(checkFin(heureDebut, num(duree))) {
			 System.out.println("1) Poste : "+p1.getNum()+" Televesion :" +p1.getTv() +" Console :" +p1.getConsole() +" Games disponible :" +p1.getGames() );
			 System.out.println("2) Poste : "+p2.getNum()+" Televesion :" +p2.getTv() +" Console :" +p2.getConsole() +" Games disponible :" +p2.getGames() );
			 System.out.println("3) Poste : "+p3.getNum()+" Televesion :" +p3.getTv() +" Console :" +p3.getConsole() +" Games disponible :" +p2.getGames() );
			 System.out.println("4) Poste : "+p4.getNum()+" Televesion :" +p4.getTv() +" Console :" +p4.getConsole() +" Games disponible :" +p2.getGames() );
			 System.out.println("5) Poste : "+p5.getNum()+" Televesion :" +p5.getTv() +" Console :" +p5.getConsole() +" Games disponible :" +p2.getGames() );
			 System.out.println("6) Poste : "+p6.getNum()+" Televesion :" +p6.getTv() +" Console :" +p6.getConsole() +" Games disponible :" +p2.getGames() );
			 System.out.println("7) Poste : "+p7.getNum()+" Televesion :" +p7.getTv() +" Console :" +p7.getConsole() +" Games disponible :" +p2.getGames() );
			 int p = scan.nextInt();
		 switch (p) {
			case 1:
				p1.reserver(convertHour(heureDebut),convertHour(heureDebut+duree),code);
				revenue(tarif(duree));
				break;				
			case 2:
				p2.reserver(convertHour(heureDebut),convertHour(heureDebut+duree),code);
				revenue(tarif(duree));
				break;
			case 3:
				p3.reserver(convertHour(heureDebut),convertHour(heureDebut+duree),code);
				revenue(tarif(duree));
				break;
			case 4:
				p4.reserver(convertHour(heureDebut),convertHour(heureDebut+duree),code);
				revenue(tarif(duree));
				break;
			case 5:
				p5.reserver(convertHour(heureDebut),convertHour(heureDebut+duree),code);
				revenue(tarif(duree));
				break;
			case 6:
				p6.reserver(convertHour(heureDebut),convertHour(heureDebut+duree),code);
				revenue(tarif(duree));
				break;
			case 7:
				p7.reserver(convertHour(heureDebut),convertHour(heureDebut+duree),code);
				revenue(tarif(duree));
				break;
			default:	
				System.out.printf("Operation invalide");
				break;
				
			}
		 }
		 else {
				System.out.println("Désole on travaille pas cette heure \n Les horraires de travaille \n 08=>12 et 14=>20");
		 }
		 
		 } 
	     }
	    
	public static void main(String[] args) {
	menu();
	    
		 }
	}


