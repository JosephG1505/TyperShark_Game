/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark_game;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author RXLM
 */
public abstract class Pez {
    
    protected Pane _pane;
    protected ImageView im;
    protected ImageView im2;
    private Label _palabra;
    protected Label _palabra2;
    
    private int _id;
    private int _inicio;
    private int _final;
    private int speed;
    
    protected boolean vida;
    protected boolean cruzo;
    
    abstract public void kill();
    abstract public void mover(ImageView im);
    abstract public int fila();
    abstract public ImageView getIm2();
    abstract public Label getWord();
    
    
    public int getID(){
        return this._id;
    }
    
    public void setID(int id) {
        this._id = id;
    }
    
    public int getPostIn() {
        return _inicio;
    }

    public void setPostIn(int _inicio) {
        this._inicio = _inicio;
    }
    
    public int getPosFin() {
        return _final;
    }

    public void setPosFin(int _final) {
        this._final = _final;
    }
    
    public int getVelocidad() {
        return speed;
    }
    
    public void setVelocidad(int speed) {
        this.speed = speed;
    }
    
    public Pane getPane() {
        return _pane;
    }
    
    public void setPane(Pane _pane) {
        this._pane = _pane;
    }
    
    public ImageView getImageView() {
        return im;
    }

    public void setImageView(ImageView im) {
        this.im = im;
    }
    
    public void switchPalabras(){
        _palabra.setVisible(false);
        _palabra2.setVisible(true);
    }
    
    public boolean isAlive() {
        return vida;
    }
    
    public boolean isCruzo() {
        return cruzo;
    }
    
    
    
    


    
    
    



    












    public Label getPalabra2() {
        return _palabra2;
    }

    public Label getPalabra() {
        return _palabra;
    }

    public void setPalabra(Label _palabra) {
        this._palabra = _palabra;
    }


    
}
