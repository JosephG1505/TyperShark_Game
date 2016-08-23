
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
    
    /********Nuevo*********/
    /*
    private ImageView imagen;
    private Label label;
    private Label text;
    private Pane _pane;
    
    private int x, y;
    private String word;
    private boolean visible;
    String s;
    private int speed;


    public Tiburon(int x, int y, String word, int speed) throws IOException {
        
        this._pane = new Pane();
        InputStream img = Files.newInputStream(Paths.get("src/typershark/proyect/imagenes/Tiburon.png"));
        Image imgTiburon = new Image(img);
        img.close();

        this.imagen = new ImageView(imgTiburon);
        this.imagen.setFitHeight(600);
        this.imagen.setFitHeight(600);

        _pane.getChildren().addAll(imagen);

        this.visible=true;
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.word=word;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getWord() {
        return word;
    }
    
    public boolean isVisible(){
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void move() {
        x -= speed;
        if (x == 0){
            visible = false;
          Buzo.getTiburon().remove(this);
          Buzo.die(false);
        }
    }
    
    
    */
}
