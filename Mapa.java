public abstract class Mapa {
    
    public abstract Cor[][] getCores();
    public abstract Cor getCor(int x, int y);
    public abstract void setCor(int x, int y, Cor cor);
    
    public int getAltura(){
        return this.getCores().length;
    }    

    public int getLargura(){
        return this.getCores()[0].length;
    } 
}
