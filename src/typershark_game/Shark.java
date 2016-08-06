
package typershark_game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Shark {
    private int movex, movey;
    private String palabra;
    private Image tiburonjpg;
    boolean visible;
    private int velocidad;
    private ImageView imageView;
    
    public Shark (int x1, int y1, String x, int speed){
        Image tiburonjpg = new Image(getClass().getResourceAsStream("imagenes/tiburon.jpg"));
        imageView = new ImageView(tiburonjpg);
        visible=true;
        this.movex=0;
        this.movey=0;
        this.velocidad=velocidad;
        this.palabra=palabra;       
    }
    
    public ImageView getImagen(){
        return imageView;
    }
    
    public boolean esVisible(){
        return visible;
    }
    
    public void mover(){
        
    }
}
