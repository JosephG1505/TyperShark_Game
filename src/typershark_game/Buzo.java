/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark_game;

/**
 *
 * @author RXLM
 */
public class Buzo extends Thread{
    /*
    private int level = 1;
    private int profundidad = 0;
    private ImageView image;
    private static ArrayList<Tiburon> tiburones;
    private ArrayList<String> palabras;
    private static boolean alive = true;

    public Buzo() throws IOException {
        InputStream img = Files.newInputStream(Paths.get("src/typershark/proyect/imagenes/Buceador.jpg"));
        Image imgBuzo = new Image(img);
        img.close();

        this.image = new ImageView(imgBuzo);
        this.image.setFitHeight(600);
        this.image.setFitHeight(600);
        
        this.tiburones = new ArrayList<Tiburon>();
        this.palabras = new ArrayList<String>();
        
        try{
            palabras = getPalabras();
        }catch(Exception e){}
    }

    public ImageView getImage() {
        return image;
    }
    
    public static ArrayList<Tiburon> getTiburon(){
        return tiburones;
    }
    
    public void fire() throws IOException {
    	Random rand = new Random();
    	int index;
    	
    	index = rand.nextInt(palabras.size());
    	String word = palabras.get(index);
    	
    	System.out.println(index);
    
    	
    	if(tiburones.size()<=level){
            switch(rand.nextInt(4)){
    	
            case 0: tiburones.add(new Tiburon(2000,70,word,rand.nextInt(4)+1));
    			palabras.remove(index);
    		break;
            case 1:	tiburones.add(new Tiburon(2000,210,word,rand.nextInt(4)+1));
    			palabras.remove(index);
    		break;
            case 2:	tiburones.add(new Tiburon(2000,350,word,rand.nextInt(4)+1));
    			palabras.remove(index);
    		break;
            case 3:	tiburones.add(new Tiburon(2000,490,word,rand.nextInt(4)+1));
    			palabras.remove(index);
    		break;
    		
    	
            }
    	}
       
    	
    }
    
    public void run(){
    	
    	while(true){
    	
        try{
    		sleep(1000);
    	}catch(Exception e){}
    	if(profundidad%1000 == 0)
    		level++;
                try {
                    fire();
                } catch (IOException ex) {
                    Logger.getLogger(Buzo.class.getName()).log(Level.SEVERE, null, ex);
                }
    	
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
    
    public ArrayList<String> getPalabras() throws Exception{
    	
    	ArrayList<String> words = new ArrayList<String>();
    	
    	BufferedReader Read = new BufferedReader(new FileReader("word.txt"));
    	String line = Read.readLine();
    	while (line != null){
    		words.add(line);
    		line = Read.readLine();
    		
    	}
    		Read.close();
    	
    	return words;
    	
    }
    */
}
