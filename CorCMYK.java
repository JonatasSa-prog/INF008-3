public class CorCMYK extends Cor {

    public static final CorCMYK red = new CorCMYK(0, 100, 100, 0);
    public static final CorCMYK green = new CorCMYK(100, 0, 100, 0);    
    public static final CorCMYK blue = new CorCMYK(100, 100, 0, 0);        
    public static final CorCMYK orange = new CorCMYK(0, 35, 100, 0);
 

    private int cyan;
    private int magenta;
    private int yellow;    
    private int key;
    
    public CorCMYK(int cyan, int magenta, int yellow, int key){
        this.cyan = cyan;
        this.magenta = magenta;        
        this.yellow = yellow;
        this.key = key;        
    }

    public CorCMYK(int tipoCor,int cyan, int magenta, int yellow, int key){
      this.setTipoCor(tipoCor);
      this.cyan = cyan;
      this.magenta = magenta;        
      this.yellow = yellow;
      this.key = key;        
    }


    public CorCMYK(){
      this(0,0,0,0);
    }

    public void setCyan(int cyan){
        if(cyan >= 0 && cyan <= 100)
            this.cyan = cyan;
    }

    public void setMagenta(int magenta){
        if(magenta >= 0 && magenta <= 100)
            this.magenta = magenta;
    }

    public void setYellow(int yellow){
        if(yellow >= 0 && yellow <= 100)
            this.yellow = yellow;
    }

    public void setKey(int key){
        if(key >= 0 && key <= 100)
            this.key = key;
    }
        
    public int getCyan(){
      return this.cyan;
    }
    
    public int getMagenta(){
      return this.magenta;
    }
    
    public int getYellow(){
      return this.yellow;
    }
    
    public int getKey(){
      return this.key;
    }
    
    public int getLuminosidade(){
      return this.key;
    }

    public void status(){
        System.out.println("Cyan = " + this.cyan + " Magenta = " + this.magenta + " Yellow = " + this.yellow + " Black(Key) = " + this.key);
    }
}
    

