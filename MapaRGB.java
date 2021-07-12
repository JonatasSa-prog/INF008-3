public class MapaRGB extends Mapa{

        private CorRGB[][] nos;
        
    
        public MapaRGB(int x, int y){
            this.nos = new CorRGB[x][y];
            this.criarMapaRGB();
        }
    
       private void criarMapaRGB(){
        
            for(int a = 0; a < this.nos.length; a++){
                for(int b = 0; b < this.nos[0].length; b++){
                    this.nos[a][b] = new CorRGB(255,255,255);
                } 
            }
        }

        public Cor[][] getCores(){
            return this.nos;
        }
        
        public Cor getCor(int x, int y){
            return this.nos[x][y];
        } 
        
        public void setCor(int x, int y, Cor pixel){
            this.nos[x][y] = (CorRGB) pixel;
        }

        public void setCor(int x, int y, int red, int green, int blue){
            this.nos[x][y] = (CorRGB) new CorRGB(red,green,blue);
        }
    
        public void modificarPixel(int x, int y, CorRGB cor){
            this.nos[x][y] = new CorRGB(cor);
        }
    
        public void modificarPixelCinza(int x, int y, CorRGB cor){
            CorRGB corCinza = new CorRGB(cor);
            corCinza.setCinza();
            this.nos[x][y] = corCinza;
        }
    
        public void modificarPixel(int x, int y, int red, int green, int blue){
            this.nos[x][y] = new CorRGB(red,green,blue);
        }
    
        public CorRGB get(int x, int y){
            return this.nos[x][y];   
        }
    
        public MapaRGB mapaRGBCinza(MapaRGB mapaRGB){
    
            MapaRGB nova = new MapaRGB(this.getAltura(),this.getLargura());
            for(int a = 0; a < mapaRGB.getAltura(); a++){
                for(int b = 0; b < mapaRGB.getLargura(); b++){
                    nova.modificarPixelCinza(a, b, mapaRGB.get(a, b));
                }
            }
        
            return nova;
        }
    
        public boolean equals(MapaRGB nos){
    
            if(this.getAltura() != nos.getAltura() || this.getLargura() != nos.getLargura())
                return false;
            
            for(int a = 0; a < this.nos.length; a++){
                for(int b = 0; b < this.nos[0].length; b++){
                    if(this.nos[a][b].equals(nos.get(a, b)) == false){
                        return false;
                    }
                }
            }
            return true;
        }
    
        public void rotacionarMatrizHorario() {
            int largura = getAltura();
            int altura = getLargura();
            CorRGB[][] ret = new CorRGB[altura][largura];
    
            for (int i=0; i<altura; i++) {
                for (int j=0; j<largura; j++) {
                    ret[i][j] = this.nos[largura - j - 1][i];
                }
             }
    
            if(altura == largura){
                for (int i=0; i<altura; i++) {
                    for (int j=0; j<largura; j++) {
                        this.nos[i][j] = ret[i][j];
                    }
                }
            }else{
                this.nos = new CorRGB[ret.length][ret[0].length];
                    for (int i=0; i<altura; i++) {
                        for (int j=0; j<largura; j++) {
                            this.nos[i][j] = ret[i][j];
                    }
                }
            }     
        }
    
        public boolean fragmento(MapaRGB i){
            for(int x = 0; x < 4; x++){
                if(this.fragmentoMapaRGB(i) == true)
                    return true;
                i.rotacionarMatrizHorario();
            }
            return false;
        }
    
        private boolean fragmentoMapaRGB(MapaRGB i){
            
            MapaRGB aux = new MapaRGB(i.getAltura(),i.getLargura());
            for(int x = 0; x < this.getAltura(); x++){
                for(int y = 0; y < this.getLargura(); y++){
                    aux.alocar(this, x, y);
                    if(aux.equals(i))
                        return true;
                }
            }
    
            return false;
        }
    
        private void alocar(MapaRGB i,int auxA, int auxB){
    
            for(int x = 0, a = auxA; x < i.getAltura() && a < this.getAltura(); x++, a++){
                for(int y = 0, b = auxB; y < i.getLargura() && b < this.getLargura(); y++, b++){
                    this.modificarPixel(x, y, i.get(a, b));
                    
                }
            }
        }
    
        public int getLargura(){
    
            return this.nos[0].length;
            
        }
    
        public int getAltura(){
            
            return this.nos.length;
        }

        public void statusRGB(){
 
            for(int a = 0; a < this.nos.length; a++){
                for(int b = 0; b < this.nos[0].length; b++){
                    this.nos[a][b].status();
                }  
            }
              
        }
    
        public void status(){
    
            for(int a = 0; a < this.nos.length; a++){
                for(int b = 0; b < this.nos[0].length; b++){
                    System.out.println("Posição: " + a + " " + b + " = " + this.nos[a][b].getHexa());
                }  
            }
        }

}
    

