public class MapaCMYK extends Mapa{
    
    private CorCMYK[][] nos;
     
    public MapaCMYK(int altura, int largura){
        this.nos = new CorCMYK[altura][largura];
    }
   
    public Cor[][] getCores(){
        return this.nos;
    }
    
    public Cor getCor(int x, int y){
        return this.nos[x][y];
    }

    public CorCMYK get(int x, int y){
        return this.nos[x][y];   
    }
    
    public void setCor(int x, int y, Cor pixel){
        this.nos[x][y] = (CorCMYK) pixel;
    }

    public void setCor(int x, int y, int cyan, int magenta, int yellow, int key){
        this.nos[x][y] = (CorCMYK) new CorCMYK(cyan,magenta,yellow,key);
    }

    public void status(){
    
        for(int a = 0; a < this.nos.length; a++){
            for(int b = 0; b < this.nos[0].length; b++){
                this.nos[a][b].status();
            }  
        }
    }
}
