public class MapasRGB {
    
    private MapaRGB[] mapasRGB;

    public MapasRGB(int x){
        this.mapasRGB = new MapaRGB[x];   
    }

    public void addMapaRGB(int x, MapaRGB outro){
        this.mapasRGB[x] = outro;
    }

    public Mapa getMapaRGB(int x){
        return this.mapasRGB[x];   
    }

    public int tamanho(){
        return mapasRGB.length;
    }

    public int[] comparar(int max, int min){
        int vet[] = new int[mapasRGB.length];
        for(int i = 0; i < mapasRGB.length; i++){
            vet[i] = compararLuminosidade(i,max,min);
        }
       
       return vet;
    }

    public int compararLuminosidade(int x, int luminosidadeMax, int luminosidadeMin){
        int count = 0;
        for(int i = 0; i < mapasRGB[x].getAltura(); i++){
            for(int j = 0; j < mapasRGB[x].getLargura(); j++){
                float aux = mapasRGB[x].get(i, j).getLuminosidade();
                if(aux <= luminosidadeMax && aux >= luminosidadeMin){
                    count = count + 1;
                }
            }
        }
        return count;
    }

    public void status(){
        for(int i = 0; i < mapasRGB.length; i++){
            System.out.println("Mapa " + i + ":");
            mapasRGB[i].status();
        }
    }
}
