public class ConversorCMYKtoRGB implements ConversorCor {

    public Mapa getNovoMapa(int altura, int largura){

        return new MapaRGB(altura, largura);
    }

    public Cor converter(Cor cor){

        CorCMYK corCMYK = (CorCMYK) cor;

        float auxK = 1 - (corCMYK.getKey() / 100f);
        float auxR = 1 - (corCMYK.getCyan() / 100f) ;
        float auxG = 1 - (corCMYK.getMagenta() / 100f) ;
        float auxB = 1 - (corCMYK.getYellow() / 100f) ;

        int red =   (int) (255 * auxR * auxK);
        int green = (int) (255 * auxG * auxK);
        int blue = (int)  (255 * auxB * auxK);

        return new CorRGB(1,red,green,blue);  
    }   
}
