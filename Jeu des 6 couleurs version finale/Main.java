package jeuDesSixCouleurs;
import java.awt.Font;
import edu.princeton.cs.introcs.StdDraw;


public class Main {
	public static void main(String[] args) {
		menu(0);
	}
	
	public static void choixJoueurs(){
		StdDraw.show(0);
		Font j = new Font("Bookman Old Style", 3, 70);
		Font k = new Font("Bookman Old Style", 2, 40);
		Font m = new Font("Bookman Old Style", 3, 28);
		StdDraw.picture(13, 5, "357653blanc.jpg");
		StdDraw.setPenColor(StdDraw.WHITE);
		double[] x = { 5.3, 20.5, 20, 5.8 };
		double[] y = { 12, 12, 10.5, 10.5 };
		StdDraw.filledPolygon(x, y);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.polygon(x, y);
		StdDraw.setFont(j);
		StdDraw.text(13, 11, "Jeu des 6 couleurs");
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.picture(13, 7, "unecaseblanche.png", 10, 2);
		StdDraw.setFont(k);
		StdDraw.filledRectangle(9, 4, 0.65, 0.6);
		StdDraw.filledRectangle(9, 2, 0.65, 0.6);
		StdDraw.text(13, 7, "Nombre de joueurs?");
		StdDraw.picture(9, 4, "unecaseblanche.png");
		StdDraw.picture(9, 2, "unecaseblanche.png");
		StdDraw.text(9, 4, "1");
		StdDraw.text(9, 2, "2");
		StdDraw.filledRectangle(13.9, 4, 4.25, 0.6);
		StdDraw.filledRectangle(13.9, 2, 4.25, 0.6);
		StdDraw.picture(13.9, 4, "unecaseblanche.png", 8.5, 1);
		StdDraw.picture(13.9, 2, "unecaseblanche.png", 8.5, 1);
		StdDraw.text(13.9, 4, "contre l'ordinateur");
		StdDraw.text(13.9, 2, "pour un duel");
		boolean s = true;
		int g =0;
		int h =0;
		int nbr=0;
		String retour="joueurs";
		StdDraw.filledRectangle(23, -0.5, 2.5, 0.8);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(23, -0.5, 2.4, 0.7);
		StdDraw.picture( 24.5, -0.5, "retour.png");
		StdDraw.setFont(m);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(22.5, -0.3, "Retour");
		StdDraw.text(22.5, -0.7, "au menu");
		StdDraw.setFont(k);
		StdDraw.show(0);
		StdDraw.show();
		while (s==true && nbr!=1 && nbr!=2 && retour!="menu"){
			if (StdDraw.mouseX()>=8.5 && StdDraw.mouseX()<=18.15 && StdDraw.mouseY()>=3.5 && StdDraw.mouseY()<=4.5){
				if (g==0){
					StdDraw.picture(9, 4, "unecasepickedblanche.png");
					StdDraw.text(9, 4, "1");
					StdDraw.picture(13.9, 4, "unecasepickedblanche.png", 8.5, 1);
					StdDraw.text(13.9, 4, "contre l'ordinateur");
					g=1;
				}
				if (StdDraw.mousePressed()){
					s= false;
					nbr = 1;
				}
			}
			else{
				if (g==1){
					StdDraw.picture(9, 4, "unecaseblanche.png");
					StdDraw.text(9, 4, "1");
					StdDraw.picture(13.9, 4, "unecaseblanche.png", 8.5, 1);
					StdDraw.text(13.9, 4, "contre l'ordinateur");
					g=0;
				}
			}
			if (StdDraw.mouseX()>=8.5 && StdDraw.mouseX()<=18.15 && StdDraw.mouseY()>=1.5 && StdDraw.mouseY()<=2.5){
				if (h==0){
					StdDraw.picture(9, 2, "unecasepickedblanche.png");
					StdDraw.text(9, 2, "2");
					StdDraw.picture(13.9, 2, "unecasepickedblanche.png", 8.5, 1);
					StdDraw.text(13.9, 2, "pour un duel");
					h=1;
				}
				if (StdDraw.mousePressed()){
					s= false;
					nbr = 2;
				}
			}
			else{
				if (h==1){
					StdDraw.picture(9, 2, "unecaseblanche.png");
					StdDraw.text(9, 2, "2");
					StdDraw.picture(13.9, 2, "unecaseblanche.png", 8.5, 1);
					StdDraw.text(13.9, 2, "pour un duel");
					h=0;
				}
			}
			if (StdDraw.mouseX()>=20.5 && StdDraw.mouseX()<=25.5 && StdDraw.mouseY()>=-1.3 && StdDraw.mouseY()<=0.3 ){
				if (StdDraw.mousePressed()){
					retour="menu";
				}
			}
		}
		if (nbr==1){
			UnJoueur();
		}
		else if (retour=="menu"){
			menu(1);
		}
		else{
			DeuxJoueurs();
		}
	}
	
	public static void UnJoueur(){
		Lettre[][] couleurs = new Lettre[13][13];
		int compteurControle1 = 0;
		int compteurControle2 = 0;
		int m=1;
		Font j = new Font("Bookman Old Style", 3, 28);
		Grille.creationValeursGrille(couleurs, compteurControle1, compteurControle2);
		StdDraw.picture(13, 5, "357653blanc.jpg");
		StdDraw.picture(20, 5, "unecaseblanche.png", 7, 1);
		StdDraw.picture(20, 4, "unecaseblanche.png", 7, 1);
		StdDraw.picture(20, 0.5, "unecaseblanche.png", 10, 2);
		Grille.checkControle(couleurs, compteurControle1, 1);
		Grille.checkControle(couleurs, compteurControle2, 3);
		Grille.dessineGrille(couleurs, compteurControle1, compteurControle2);
		char[][] grille2 = new char[13][13];
		while (m<=169){
			for (int k=0; k<13; k++)
				for (int l=0; l<13; l++)
					grille2[k][l]=couleurs[k][l].getLettre();
			StdDraw.setFont(j);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.picture(20, 7, "unecaseblanche.png", 9, 1);
			if (m%2!=0 && m!=2){
				StdDraw.text(20, 7, "C'est au Joueur 1");
				Grille.stepJoueur1(couleurs, compteurControle1, compteurControle2);
			}
			else {
				StdDraw.text(20, 7, "C'est � l'ordinateur");
				Grille.stepIABest(couleurs);
			}
			Grille.majGrille(couleurs, grille2, compteurControle1, compteurControle2);
			StdDraw.picture(20, 5, "unecaseblanche.png", 7, 1);
			StdDraw.picture(20, 4, "unecaseblanche.png", 7, 1);
			StdDraw.setPenColor(StdDraw.BLACK);
			Grille.checkControle(couleurs, compteurControle1, 1);
			Grille.checkControle(couleurs, compteurControle2, 2);
			m+=1;
			if (Grille.verifGagnant(couleurs, compteurControle1, compteurControle2, 1)==true){
				m=170;
			}
		}
	}
	
	
	
	public static void DeuxJoueurs(){
		Lettre[][] couleurs = new Lettre[13][13];
		int compteurControle1 = 0;
		int compteurControle2 = 0;
		int m=1;
		Font j = new Font("Bookman Old Style", 3, 28);
		Grille.creationValeursGrille(couleurs, compteurControle1, compteurControle2);
		StdDraw.picture(13, 5, "357653blanc.jpg");
		StdDraw.picture(20, 5, "unecaseblanche.png", 7, 1);
		StdDraw.picture(20, 4, "unecaseblanche.png", 7, 1);
		StdDraw.picture(20, 0.5, "unecaseblanche.png", 10, 2);
		Grille.checkControle(couleurs, compteurControle1, 1);
		Grille.checkControle(couleurs, compteurControle2, 2);
		Grille.dessineGrille(couleurs, compteurControle1, compteurControle2);
		char[][] grille2 = new char[13][13];
		while (m<=169){
			for (int k=0; k<13; k++)
				for (int l=0; l<13; l++)
					grille2[k][l]=couleurs[k][l].getLettre();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.setFont(j);
			StdDraw.picture(20, 7, "unecaseblanche.png", 9, 1);
			if (m%2!=0 && m!=2){
				StdDraw.text(20, 7, "C'est au Joueur 1");
				Grille.stepJoueur1(couleurs, compteurControle1, compteurControle2);
			}
			else {
				StdDraw.text(20, 7, "C'est au Joueur 2");
				Grille.stepJoueur2(couleurs, compteurControle1, compteurControle2);
			}
			Grille.majGrille(couleurs, grille2, compteurControle1, compteurControle2);
			StdDraw.picture(20, 5, "unecaseblanche.png", 7, 1);
			StdDraw.picture(20, 4, "unecaseblanche.png", 7, 1);
			StdDraw.setPenColor(StdDraw.BLACK);
			Grille.checkControle(couleurs, compteurControle1, 1);
			Grille.checkControle(couleurs, compteurControle2, 2);
			m+=1;
			if (Grille.verifGagnant(couleurs, compteurControle1, compteurControle2, 0)==true){
				m=170;
			}
		}
	}
	
	public static void menu(int retour){
		StdDraw.setCanvasSize(1366, 768);
		StdDraw.setXscale(-1, 26);
		StdDraw.setYscale(-2, 12);
		StdDraw.show(0);
		StdDraw.setPenRadius(0.01);
		Font j = new Font("Bookman Old Style", 3, 70);
		Font k = new Font("Bookman Old Style", 2, 40);
		StdDraw.setFont(j);
		StdDraw.picture(13, 5, "357653blanc.jpg");
		StdDraw.setPenColor(StdDraw.WHITE);
		double[] x = { 5.3, 20.5, 20, 5.8 };
		double[] y = { 12, 12, 10.5, 10.5 };
		StdDraw.filledPolygon(x, y);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.polygon(x, y);
		StdDraw.text(13, 11, "Jeu des 6 couleurs");
		StdDraw.picture(13, 7, "unecaseblanche.png", 8, 2);
		StdDraw.picture(13, 4, "unecaseblanche.png", 8, 2);
		StdDraw.picture(13, 1, "unecaseblanche.png", 8, 2);
		StdDraw.setFont(k);
		StdDraw.rectangle(13, 7, 4, 1);
		StdDraw.rectangle(13, 4, 4, 1);
		StdDraw.rectangle(13, 1, 4, 1);
		StdDraw.text(13, 7, "Jouer");
		StdDraw.text(13, 4, "Connaitre les r�gles");
		StdDraw.text(13, 1, "Quitter l'application");
		boolean r = true;
		int e =0;
		int f =0;
		int g =0;
		int choix=4;
		StdDraw.show(0);
		StdDraw.show();
		while (r == true && choix!=0 && choix!=1 && choix!=2){
			
			
			if (StdDraw.mouseX()>=9 && StdDraw.mouseX()<=17 && StdDraw.mouseY()>=0 && StdDraw.mouseY()<=2){
				if (e==0){
					StdDraw.picture(13, 1, "unecasepickedblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(13, 1, 4, 1);
					StdDraw.text(13, 1, "Quitter l'application");
					e=1;
				}
				else {
					
				}
				if (retour==0){
					if (StdDraw.mousePressed()){
						r= false;
						choix = 1;
					}
				}
				else if (retour==1){
					if (!StdDraw.mousePressed()){
						r= false;
						choix = 1;
					}
				}
				
				else {
					
				}
			}
			else {
				if (e==1){
					StdDraw.picture(13, 1, "unecaseblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(13, 1, 4, 1);
					StdDraw.text(13, 1, "Quitter l'application");
					e=0;
				}
				else{
					
				}
				
			}
			if (StdDraw.mouseX()>=9 && StdDraw.mouseX()<=17 && StdDraw.mouseY()>=3 && StdDraw.mouseY()<=5){
				if (f==0){
					StdDraw.picture(13, 4, "unecasepickedblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(13, 4, 4, 1);
					StdDraw.text(13, 4, "Connaitre les r�gles");
					f=1;
				}
				else {
					
				}
				if (retour==0){
					if (StdDraw.mousePressed()){
						r= false;
						choix = 2;
					}
				}
				if (retour==1){
					if (!StdDraw.mousePressed()){
						r= false;
						choix = 2;
					}
				}
				else {
					
				}
			}
			else {
				if (f==1){
					StdDraw.picture(13, 4, "unecaseblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(13, 4, 4, 1);
					StdDraw.text(13, 4, "Connaitre les r�gles");
					f=0;
				}
				else{
					
				}
				
			}
			if (StdDraw.mouseX()>=9 && StdDraw.mouseX()<=17 && StdDraw.mouseY()>=6 && StdDraw.mouseY()<=8){
				if (g==0){
					StdDraw.picture(13, 7, "unecasepickedblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(13, 7, 4, 1);
					StdDraw.text(13, 7, "Jouer");
					g=1;
				}
				else {
					
				}
				
				if (retour==0){
					if (StdDraw.mousePressed()){
						r= false;
						choix = 0;
					}
				}
				else if (retour==1){
					if (!StdDraw.mousePressed()){
						r= false;
						choix = 0;
					}
				}
				
				
				else {
					
				}
			}
			else {
				if (g==1){
					StdDraw.picture(13, 7, "unecaseblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(13, 7, 4, 1);
					StdDraw.text(13, 7, "Jouer");
					g=0;
				}
				else{
					
				}
				
			}
		}
		if (choix==1){
			System.exit(0);
		}
		else if (choix==2){
			regles();
		}
		else if ( choix==0){
			choixJoueurs();
		}
	}
	
	public static void regles(){
		StdDraw.show(0);
		Font j = new Font("Bookman Old Style", 3, 70);
		Font k = new Font("Bookman Old Style", 2, 28);
		Font l = new Font("Bookman Old Style", 2, 46);
		Font m = new Font("Bookman Old Style", 3, 28);
		Font n = new Font("Bookman Old Style", 3, 22);
		StdDraw.setFont(j);
		StdDraw.picture(13, 5, "357653blanc.jpg");
		StdDraw.setPenColor(StdDraw.WHITE);
		double[] x = { 5.3, 20.5, 20, 5.8 };
		double[] y = { 12, 12, 10.5, 10.5 };
		StdDraw.filledPolygon(x, y);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.polygon(x, y);
		StdDraw.text(13, 11, "Jeu des 6 couleurs");
		StdDraw.setPenColor(130,130,130);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.picture(13, 9, "unecaseblanche.png", 10, 2);
		StdDraw.setFont(l);
		StdDraw.text(13, 9, "R�gles du jeu");
		StdDraw.setFont(k);
		StdDraw.picture(13, 3.15, "unecaseblanche.png", 15, 9.5);
		StdDraw.text(13, 7, "Le jeu des 6 couleurs est un jeu de strat�gie se d�rou-");
		StdDraw.text(13, 6.5, "lant sur un plateau d�coup� en cases de 6 couleurs     ");
		StdDraw.text(13, 6, "diff�rentes (rouge, orange, jaune, vert, bleu ou violet).");
		StdDraw.text(13, 5.5, "Le but du jeu est de contr�ler plus de cases que son   ");
		StdDraw.text(7.8, 5, "adversaire.");
		StdDraw.text(13, 4.5, "Les joueurs commencent en contr�lant chacun une case");
		StdDraw.text(13, 4, "de la grille. Les joueurs jouent chacun � leur tour. A son ");
		StdDraw.text(13, 3.5, "tour, un joueur choisit une couleur diff�rente de celle   ");
		StdDraw.text(13, 3, "qu'il a actuellement, et de celle utilis�e par son adver-");
		StdDraw.text(7, 2.5, "saire.");
		StdDraw.text(13, 2, "		� Toutes les cases controll�es par le joueur deviennent");
		StdDraw.text(10, 1.5, "alors de la couleur choisie.");
		StdDraw.text(13, 1, "		� Toutes les cases de la couleur choisie et qui touchent");
		StdDraw.text(13, 0.5, "une case control�e par le joueur passent sous son  ");
		StdDraw.text(7.7, 0, "controle.");
		StdDraw.setFont(n);
		StdDraw.text(13, -0.5, "La partie se termine quand il n'y a plus de case non-controll�e");
		StdDraw.text(13, -1, "ou qu'un joueur controle plus de la moit� du plateau.");
		StdDraw.filledRectangle(23, -0.5, 2.5, 0.8);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(23, -0.5, 2.4, 0.7);
		StdDraw.picture( 24.5, -0.5, "retour.png");
		StdDraw.setFont(m);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(22.5, -0.3, "Retour");
		StdDraw.text(22.5, -0.7, "au menu");
		String retour="regles";
		StdDraw.show(0);
		StdDraw.show();
		while (retour!="menu"){
			if (StdDraw.mouseX()>=20.5 && StdDraw.mouseX()<=25.5 && StdDraw.mouseY()>=-1.3 && StdDraw.mouseY()<=0.3 ){
				if (StdDraw.mousePressed()){
					retour="menu";
				}
			}
		}
		menu(1);
		return;
	}
	
	public static void restartMenu(int retour, int x, Lettre[][] grille, int compteur1, int compteur2, int joueur){
		Font k = new Font("Bookman Old Style", 2, 40);
		Font l = new Font("Bookman Old Style", 3, 50);
		StdDraw.picture(x, 6.7, "unecaseblanche.png", 8.5, 8);
		StdDraw.picture(x, 8, "unecaseblanche.png", 8, 2);
		StdDraw.picture(x, 6, "unecaseblanche.png", 8, 2);
		StdDraw.picture(x, 4, "unecaseblanche.png", 8, 2);
		StdDraw.setFont(l);
		if (x==4)
			StdDraw.text(x, 9.5, "Menu");
		else
			StdDraw.text(x, 9.5, "Pause");
		StdDraw.setFont(k);
		if (x==4)
			StdDraw.text(x, 8, "Nouvelle partie");
		else
			StdDraw.text(x, 8, "Reprendre la partie");
		StdDraw.text(x, 6, "Menu principal");
		StdDraw.text(x, 4, "Quitter l'application");
		
		boolean r = true;
		int e =0;
		int f =0;
		int g =0;
		int choix=4;
		while (r == true && choix!=0 && choix!=1 && choix!=2){
			if (StdDraw.mouseX()>=x-4 && StdDraw.mouseX()<=x+4 && StdDraw.mouseY()>=7 && StdDraw.mouseY()<=9){
				if (e==0){
					StdDraw.picture(x, 8, "unecasepickedblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(x, 8, 4, 1);
					if (x==4)
						StdDraw.text(x, 8, "Nouvelle partie");
					else
						StdDraw.text(x, 8, "Reprendre la partie");
					e=1;
				}
				else {
					
				}
				if (retour==0){
					if (StdDraw.mousePressed()){
						r= false;
						choix = 1;
					}
				}
				else if (retour==1){
					if (!StdDraw.mousePressed()){
						r= false;
						choix = 1;
					}
				}
				
				else {
					
				}
			}
			else {
				if (e==1){
					StdDraw.picture(x, 8, "unecaseblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(x, 8, 4, 1);
					if (x==4)
						StdDraw.text(x, 8, "Nouvelle partie");
					else
						StdDraw.text(x, 8, "Reprendre la partie");
					e=0;
				}
				else{
					
				}
				
			}
			if (StdDraw.mouseX()>=x-4 && StdDraw.mouseX()<=x+4 && StdDraw.mouseY()>=5 && StdDraw.mouseY()<=7){
				if (f==0){
					StdDraw.picture(x, 6, "unecasepickedblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(x, 6, 4, 1);
					StdDraw.text(x, 6, "Menu principal");
					f=1;
				}
				else {
					
				}
				if (retour==0){
					if (StdDraw.mousePressed()){
						r= false;
						choix = 2;
					}
				}
				if (retour==1){
					if (!StdDraw.mousePressed()){
						r= false;
						choix = 2;
					}
				}
				else {
					
				}
			}
			else {
				if (f==1){
					StdDraw.picture(x, 6, "unecaseblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(x, 6, 4, 1);
					StdDraw.text(x, 6, "Menu principal");
					f=0;
				}
				else{
					
				}
				
			}
			if (StdDraw.mouseX()>=x-4 && StdDraw.mouseX()<=x+4 && StdDraw.mouseY()>=3 && StdDraw.mouseY()<=5){
				if (g==0){
					StdDraw.picture(x, 4, "unecasepickedblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(x, 4, 4, 1);
					StdDraw.text(x, 4, "Quitter l'application");
					g=1;
				}
				else {
					
				}
				
				if (retour==0){
					if (StdDraw.mousePressed()){
						r= false;
						choix = 0;
					}
				}
				else if (retour==1){
					if (!StdDraw.mousePressed()){
						r= false;
						choix = 0;
					}
				}
				
				
				else {
					
				}
			}
			else {
				if (g==1){
					StdDraw.picture(x, 4, "unecaseblanche.png", 8, 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.rectangle(x, 4, 4, 1);
					StdDraw.text(x, 4, "Quitter l'application");
					g=0;
				}
				else{
					
				}
				
			}
		}
		if (choix==1){
			if (x==13) {
				StdDraw.show(0);
				Font j = new Font("Bookman Old Style", 3, 28);
				StdDraw.picture(13, 5, "357653blanc.jpg");
				StdDraw.picture(20, 5, "unecaseblanche.png", 7, 1);
				StdDraw.picture(20, 4, "unecaseblanche.png", 7, 1);
				StdDraw.picture(20, 0.5, "unecaseblanche.png", 10, 2);
				Grille.checkControle(grille, compteur1, 1);
				Grille.checkControle(grille, compteur2, 2);
				Grille.dessineGrille(grille, compteur1, compteur2);
				Grille.dessinCouleurs();
				StdDraw.setFont(j);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.picture(20, 7, "unecaseblanche.png", 9, 1);
				StdDraw.text(20, 7, "C'est au Joueur "+ joueur);
				StdDraw.show(0);
				StdDraw.show();
			}
			else {
				choixJoueurs();
			}
		}
		else if (choix==2){
			menu(1);
		}
		else if ( choix==0){
			System.exit(0);
		}
	}
	
	public static void finDuJeu(String joueur, Lettre[][] grille, int compteur1, int compteur2){
		for (double i=12; i>3; i-=0.16){
			double[] xx = { 9, 9, 13, 17, 17 };
			double[] yy = { 13, i, i-1, i, 13 };
			double[] xxx = { 9.5, 9.5, 13, 16.5, 16.5 };
			double[] yyy = { 13, i+0.4, i-0.5, i+0.4, 13 };
			double[] xxxx = { 9.8, 9.8, 13, 16.2, 16.2 };
			double[] yyyy = { 13, i+0.7, i-0.2, i+0.7, 13 };
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledPolygon(xx, yy);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledPolygon(xxx, yyy);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledPolygon(xxxx, yyyy);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(13, i+3, "Partie termin�e");
			StdDraw.text(13, i+2, joueur + " a gagn�");
			StdDraw.show(5);
		}
		StdDraw.show();
		restartMenu(0, 4, grille, compteur1, compteur2, 0);
	}
}