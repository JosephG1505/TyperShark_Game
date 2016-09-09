
package typershark_game;

import javafx.util.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class Shark extends Thread {
    
    private StackPane _stackpane;
    
    //Concatena los label - cada letra es un label
    private HBox _concatLabel;

    Timeline _time;
    private boolean vida;
    
    //palabra a tipear
    private String _palabra;
    private Label _text;
    
    //imagen a mostrar
    private ImageView imageView;
    private Image tiburon;

    //velocidad dependiendo del nivel
    private int velocidad;
    
    private int aciertos;

    
    
    
    
    public Shark(int velocidad) {

        super("SharkThread");
        
        this.aciertos = 0;
        this.vida = true;
        
        this.velocidad = velocidad;
        
        //load and displays image
        this.tiburon = new Image("/images/tiburon.gif");
        this.imageView = new ImageView();
        this.imageView.setImage(tiburon);
        
        this._stackpane = new StackPane();
        //_text.setOnKeyPressed(new SharkHandler() );
        //init();
        
    }

    
    
    
    /*1*/
    public void setTiburon(String palabra) {
        setLabel(palabra);
        _stackpane.getChildren().addAll(imageView, _concatLabel);
        
    }
    

    public class SharkHandler implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent event) {
            //validarPalabra(event.getText())
            if(event.getCode() == KeyCode.ENTER){
                //pintar(event.getText());
                System.out.println(event.getText());
                event.consume();
                
            }
        }
//        _text.setOnKeyPressed((KeyEvent event) -> {
//               if(validarPalabra(event.getCharacter())){
//                   pintar(event.getCharacter());
//                   event.consume();
//                   System.out.println(event.getCharacter());
//               }  
//
//        }); 
    
    }
    
    public void init(){
        _text.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                
                if (Character.isLetter(car)) {
                    pintar(Character.toString(car));
                    event.consume();
                }
            }
        
        });
    
    }
    
    //antes debemos crear un metodo para cargar palabras de un archivo
    public void setLabel(String palabra){
        _concatLabel = new HBox();
        _concatLabel.setAlignment(Pos.CENTER);
        for (int i = 0; i < palabra.length(); i++) {
            Label l = new Label(Character.toString(palabra.charAt(i)));
            l.setStyle("-fx-text-fill: white;-fx-font: bold 17 serif");
            _concatLabel.getChildren().addAll(l);
        }
        
    }
    //*******
    //considerar setLabelintoPaane y validar palabra para eliminar un pez
    //considerar utilizarlo en Oceano Class
    public void setPalabra(String palabra){
        _stackpane.getChildren().remove(_concatLabel);
        setLabel(palabra);
        _stackpane.getChildren().addAll(_concatLabel);
    
    }
    
    public Boolean validarPalabra(String letra){
        //int longt = palabra.length();
        if(((Label) this._concatLabel.getChildren().get(0)).getText().equals(letra) ) {
            return true;
        }
        velocidad = velocidad +1;
        return false;
    }
    //*********
    
    //pintar cada letra que voy acertando
    public void pintar(String a){
        for(Node letra: _concatLabel.getChildren()){
            Label _l = (Label) letra;
            if (a.equals(_l.getText())){
                letra.setStyle("-fx-text-fill: red;-fx-font: bold 17 serif");
                /*
                if (!(_l.getStyle().equals("-fx-text-fill: red;-fx-font: bold 17 serif"))){
                    letra.setStyle("-fx-text-fill: red;-fx-font: bold 17 serif");
                }
                */
            }
        }
    }
    
    //protected abstract double getLimite();
    
    public boolean kill(){
        if(aciertos==this._concatLabel.getChildren().size()){            
            this.vida = false;
            System.out.println("Shark died");
            aciertos = 0;
            //selected.set(false);
            
            _time = new Timeline();
            
            _time.setCycleCount(1);
            _time.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e->{
                    //Oceano.actualizarOceano();
                },
                new KeyValue(_stackpane.translateYProperty(), _stackpane.getTranslateY()-30.05,Interpolator.SPLINE(0.295,0.800,0.305,1.000)),
                new KeyValue(_stackpane.opacityProperty(), 0f)
            ));            
            _time.play();
            
            return true;
        }
        return false;
    }
    //protected abstract double getLimite();
    
    @Override
    public void run(){
        
        while(vida){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    
                    _stackpane.setTranslateX(_stackpane.getTranslateX()-3);
//                    if(_stackpane.translateXProperty().lessThan(getLimite()).getValue()){
//                        vida = false;
//                        //cruzo = true;
//                        _stackpane.setOpacity(0.0);
//                        //Oceano.actualizarOceano();
//                    }
                    
                }
            });
            
            try {
                Shark.sleep((int) velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Shark.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    }
    
    //default methods
    
    public StackPane getPane() {
        return _stackpane;
    }

    public void setStackPane(StackPane _stackpane) {
        this._stackpane = _stackpane;
    }

    
    public HBox getConcatLabel() {
        return _concatLabel;
    }

    public void setConcatLabel(HBox _concatLabel) {
        this._concatLabel = _concatLabel;
    }

    
    public boolean isVida() {
        return vida;
    }

    public void setVida(boolean vida) {
        this.vida = vida;
    }
    
    
    public String getPalabra() {
        return _palabra;
    }

    
    public Label getText() {
        return _text;
    }

    public void setText(Label _text) {
        this._text = _text;
    }

    
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Image getTiburon() {
        return tiburon;
    }
    
    
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
}







//scratch





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