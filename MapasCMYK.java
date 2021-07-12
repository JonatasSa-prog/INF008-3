public class MapasCMYK {
    private MapaCMYK[] mapasCMYK;

    public MapasCMYK(int x){
        this.mapasCMYK = new MapaCMYK[x];   
    }

    public void addMapaRGB(int x, MapaCMYK outro){
        this.mapasCMYK[x] = outro;
    }

    public Mapa getMapaRGB(int x){
        return this.mapasCMYK[x];   
    }

    public int tamanho(){
        return mapasCMYK.length;
    }

    public int[] comparar(int max, int min){
        int vet[] = new int[mapasCMYK.length];
        for(int i = 0; i < mapasCMYK.length; i++){
            vet[i] = compararLuminosidade(i,max,min);
        }
       
       return vet;
    }

    public int compararLuminosidade(int x, int luminosidadeMax, int luminosidadeMin){
        int count = 0;
        for(int i = 0; i < mapasCMYK[x].getAltura(); i++){
            for(int j = 0; j < mapasCMYK[x].getLargura(); j++){
                float aux = mapasCMYK[x].get(i, j).getLuminosidade();
                if(aux <= luminosidadeMax && aux >= luminosidadeMin){
                    count = count + 1;
                }
            }
        }
        return count;
    }

    public void status(){
        for(int i = 0; i < mapasCMYK.length; i++){
            System.out.println("Mapa " + i + ":");
            mapasCMYK[i].status();
        }
    }
}
