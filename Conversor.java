public class Conversor {

    public Mapa converter(Mapa mapa, ConversorCor conversor){

        Mapa novo = conversor.getNovoMapa(mapa.getAltura(), mapa.getLargura());

        for(int x = 0; x < mapa.getAltura(); x++) 
            for(int y = 0; y < mapa.getLargura(); y++){ 
                Cor cor = mapa.getCor(x, y); 
                Cor novaCor = conversor.converter(cor); 
                novo.setCor(x, y, novaCor); 
            } 
        return novo; 
    } 
}
