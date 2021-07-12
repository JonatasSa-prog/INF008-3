public class CorRGB extends Cor{

    public static CorRGB PRETA = new CorRGB(0, 0, 0);
	public static CorRGB BRANCA = new CorRGB(255, 255, 255);
	public static CorRGB RED = new CorRGB(255, 0, 0);
	public static CorRGB GREEN = new CorRGB(0, 255, 0);
	public static CorRGB BLUE = new CorRGB(0, 0, 255);
    public static CorRGB ORANGE = new CorRGB(160, 166, 93);

    private int red;
    private int green;
    private int blue;
    
    public CorRGB(int red, int green, int blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public CorRGB(int tipoCor,int red, int green, int blue) {
        this.setTipoCor(tipoCor);
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public CorRGB(CorRGB cor){
        this(cor.getRed(),cor.getGreen(),cor.getBlue());
    }

    public CorRGB(){
        this(0,0,0);
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        if(red >= 0 && red <=255)
            this.red = red;  
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        if(green >= 0 && green <= 255)
            this.green = green;   
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        if(blue >= 0 && blue <=255)
            this.blue = blue;
    }

    public int getLuminosidade(){
        return (int) (this.getRed() * 0.3 + this.getGreen() * 0.59 + this.getBlue() * 0.11);  
    }

    public CorRGB getRGB(){
        return new CorRGB(this.getRed(), this.getGreen(), this.getBlue());
    }

    public String getHexa(){ 
        return String.format("#%02X%02X%02X", this.getRed(), this.getGreen(), this.getBlue());
    }

    public void setCinza(){
        
        int cinza = (int) Math.round(this.getLuminosidade());

        this.setRed(cinza);
        this.setGreen(cinza);
        this.setBlue(cinza);
    }

    public boolean equals(CorRGB cor){

        if(this.getRed() == cor.getRed() && 
                this.getGreen() == cor.getGreen() &&
                    this.getBlue() == cor.getBlue())
            return true;

        return false;
    }

    public void escurecer(double num){
        
        double aux = num / 100;
        
        int auxRed = (int) (this.getRed() * aux);
        int auxGreen = (int) (this.getGreen() * aux);
        int auxBlue = (int) (this.getBlue() * aux);
        
        if(num > 0 && num <= 100){
            if(this.getRed() != 0 || this.getRed() != 255)
                this.setRed(this.getRed() - Math.round(auxRed));
            if(this.getGreen() != 0 || this.getGreen() != 255)
                this.setGreen(this.getGreen() - Math.round(auxGreen));
            if(this.getBlue() != 0 || this.getBlue() != 255)
                this.setBlue(this.getBlue() - Math.round(auxBlue));
        }
    }

    public void clarear(double num){
        
        double aux = num / 100;

        int auxRed = (int) (this.getRed() * aux);
        int auxGreen = (int) (this.getGreen() * aux);
        int auxBlue = (int) (this.getBlue() * aux);

        if(num > 0 && num <= 100){
            if(this.getRed() != 0 || this.getRed() != 255)
                this.setRed(this.getRed() + Math.round(auxRed));
            if(this.getGreen() != 0 || this.getGreen() != 255)
                this.setGreen(this.getGreen() + Math.round(auxGreen));
            if(this.getBlue() != 0 || this.getBlue() != 255)
                this.setBlue(this.getBlue() + Math.round(auxBlue));
        }
    }

    public CorRGB novoIgual(){
        return new CorRGB(this);
    }

    public void status(){
        System.out.println("Red: " + this.getRed() + " Green: " + this.getGreen() + " Blue: " +this.getBlue() + " Luminosidade: " + this.getLuminosidade() + " Hexadecimal " + this.getHexa() + " Tipo da Cor: " + this.getTipoCor());
    }


}    

