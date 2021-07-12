public class ConversorRGBtoCMYK implements ConversorCor{

    public Mapa getNovoMapa(int altura, int largura){

        return new MapaCMYK(altura, largura);
    }

    public Cor converter(Cor cor){

        CorRGB corRGB = (CorRGB) cor;

        double max = 0;
        float r = corRGB.getRed();
        float g = corRGB.getGreen();
        float b = corRGB.getBlue();

        float rAux = r / 255;
        float gAux = g / 255;
        float bAux = b / 255;


        if(rAux > gAux && rAux > bAux)
            max = rAux;
        else if(gAux > rAux && gAux > bAux)
            max = gAux;
        else 
            max = bAux;
              
        double keyAUX = (1 - max);
        double cyanAUX = (1 - rAux - keyAUX) / (1 - keyAUX);
        double magentaAUX = (1 - gAux - keyAUX) / (1 - keyAUX);
        double yellowAUX = (1 - bAux - keyAUX) / (1 - keyAUX);

        int key = (int) Math.round(keyAUX * 100);
        int cyan = (int) Math.round(cyanAUX * 100);
        int magenta = (int) Math.round(magentaAUX * 100);
        int yellow = (int) Math.round(yellowAUX * 100);

        return new CorCMYK(cyan,magenta,yellow,key);  
    }
}
