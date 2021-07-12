import java.util.ArrayList;

public class CompararMapaCor {

    ArrayList<MapaRGB> mapasAux = new ArrayList<MapaRGB> ();

    public ArrayList<MapaRGB> getImagemPorLuminosidade(MapasRGB mapas,int red, int green, int blue, double pctMinimo, double limiarSimilaridade){
        

        int max,min,aux;
        CorRGB cor = new CorRGB(red,green,blue);
        aux = (int) Math.round(cor.getLuminosidade() * (pctMinimo/100) );
        max = (int) (cor.getLuminosidade() + aux);
        min = (int) (cor.getLuminosidade() - aux);
        
        int vet[] = mapas.comparar(max,min);
        
        for(int i = 0; i < vet.length; i++){
            double tamanho = mapas.getMapaRGB(i).getAltura() * mapas.getMapaRGB(i).getLargura();
            int pctAux = (int) ((tamanho - vet[i]) / tamanho * 100);
            System.out.println(pctAux);
            if((100 - pctAux) >= pctMinimo)
                mapasAux.add((MapaRGB) mapas.getMapaRGB(i));        
            }

        return mapasAux;
    }

    public void getPorcentagem(CorRGB cor, MapaRGB mapa){
        int count = 0;
        for(int i = 0; i < mapa.getLargura(); i++){
            for(int j = 0; j < mapa.getAltura(); j++){
                if(mapa.get(i, j).equals(cor))
                    count = count + 1;
            }
        }
    }

    public int[] getQTD(ArrayList<CorRGB> cor,MapaRGB mapa){
        int vet[] = new int[cor.size()];
        for(int i = 0; i < cor.size(); i++){
            vet[i] = getQTDCores(i, cor, mapa);
        }

        return vet;
    }

    public int getQTDCores(int x,ArrayList<CorRGB> cor,MapaRGB mapa){
        int count = 0;
        for(int i = 0; i < mapa.getAltura(); i++){
            for(int j = 0; j < mapa.getLargura(); j++){
                if(mapa.get(i, j).equals(cor.get(x))) 
                    count = count + 1;
            }
        }

        return count;
    }

    public void addMapasAux(MapaRGB mapa){
        mapasAux.add(mapa);
    }

    public void getMapasAux(int num){
        mapasAux.get(num);
    }

    public void statusMapaAux(){
        for(int i = 0; i < mapasAux.size(); i++){
            System.out.println("Mapa " + i + ":");
            mapasAux.get(i);
        }
    }

}
