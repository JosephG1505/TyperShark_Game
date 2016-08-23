/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author RXLM
 */
public class Buzo extends Thread{
    
    private String nombre;
    private int level;
    private int profundidad;
    private int puntaje;
    //private int vidas;
    
    private ImageView image;
    
    private static ArrayList<Shark> tiburones;
    private ArrayList<String> palabras;
    
    private static boolean alive = true;
    
    

    public Buzo(){
        
        this.level = 1;
        this.profundidad = 0;
        this.puntaje = 0;
        //this.vidas = 3;
        
        this.image = new ImageView(new Image("buzo.gif"));
        this.image.setFitWidth(60);
        this.image.setFitHeight(60);
        
        this.tiburones = new ArrayList<Shark>();
        this.palabras = new ArrayList<String>(); 
        
    }

    public Buzo(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    

    public static ArrayList<Shark> getTiburones() {
        return tiburones;
    }

    public static void setTiburones(ArrayList<Shark> aTiburones) {
        tiburones = aTiburones;
    }

    public static boolean isVivir() {
        return alive;
    }

    public static void setAlive(boolean aAlive) {
        alive = aAlive;
    }
    
//    public void fire(){
//    	Random rand = new Random();
//    	int index;
//    	
//    	index = rand.nextInt(palabras.size());
//    	String word = palabras.get(index);
//    	
//    	System.out.println(index);
//    
//    	
//    	if(tiburones.size()<=level){
//            
//            switch(rand.nextInt(4)){
//    	
//            case 0: tiburones.add(new Shark(2000,70,word,rand.nextInt(4)+1));
//    			palabras.remove(index);
//    		break;
//            case 1:	tiburones.add(new Shark(2000,210,word,rand.nextInt(4)+1));
//    			palabras.remove(index);
//    		break;
//            case 2:	tiburones.add(new Shark(2000,350,word,rand.nextInt(4)+1));
//    			palabras.remove(index);
//    		break;
//            case 3:	tiburones.add(new Shark(2000,490,word,rand.nextInt(4)+1));
//    			palabras.remove(index);
//    		break;
//    		
//    	
//            }
//    	}
//       
//    	
//    }
    
    public void run(){
    	
    	while(true){
    	
        try{
    		sleep(1000);
    	}catch(Exception e){}
    	if(profundidad%1000 == 0)
    		level++;
        //fire();
    	
    	if(profundidad % 500 == 0)
    		level++;
    	
    	profundidad+= 100;
    	}
    	
    }

    public int getProfundidad() {
        return profundidad;
    }
    
    public static void die(boolean d){
    	alive = d;
    }
    
    public ArrayList<String> getPalabras(){
    	
    	ArrayList<String> words = new ArrayList<String>();
    	
    	File archivo = new File("palabras.txt");
        palabras = new ArrayList<String>();

        try {
            Scanner sc = new Scanner(archivo);
            while (sc.hasNext()) {
                String word = sc.nextLine();
                palabras.add(word);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    	
    	return words;
    	
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
    
}
