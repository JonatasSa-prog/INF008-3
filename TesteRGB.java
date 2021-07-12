import java.util.ArrayList;

public class TesteRGB {

    public static void ConversorCMYKtoRGB(){

        MapaCMYK mapa = new MapaCMYK(2,2);
        mapa.setCor(0, 0, CorCMYK.red);
        mapa.setCor(0, 1, CorCMYK.green);        
        mapa.setCor(1, 0, CorCMYK.blue);        
        mapa.setCor(1, 1, CorCMYK.orange);
        
        Conversor conversor = new Conversor();

        MapaRGB mapa2 = (MapaRGB) conversor.converter(mapa, new ConversorCMYKtoRGB());

        mapa2.statusRGB();

    }

    public static void ConversorRGBtoCMYK(){

        MapaRGB mapa = new MapaRGB(2,2);
        mapa.setCor(0, 0, CorRGB.ORANGE);
        mapa.setCor(0, 1, 90,179,255);        
        mapa.setCor(1, 0, 35,96,147);        
        mapa.setCor(1, 1, 210,110,10); 
        
        Conversor conversor = new Conversor();

        MapaCMYK mapa2 = (MapaCMYK) conversor.converter(mapa, new ConversorRGBtoCMYK());

        mapa2.status();

    }

    public static void analise() throws Exception{
        AnalisarMapa a = new AnalisarMapa();
        a.analisar("C:/Users/jonat/Desktop/teste.txt", "AREA PROIBIDA");
        
    }

    public static void getBanco(){

        ArrayList<CorRGB> cores = new ArrayList<CorRGB> ();
        CorRGBDAO banco = new CorRGBDAO();
        cores = banco.read("AREA PROIBIDA");

        for(int i = 0; i < cores.size(); i++){
            System.out.println("Cor " + i + ":");
            cores.get(i).status();
        }
    }

    public static void mapasRGB(){
        ArrayList<MapaRGB> mapasAux = new ArrayList<MapaRGB> ();
        CompararMapaCor comparador = new CompararMapaCor();
        MapasRGB mapas = new MapasRGB(4);
        MapaRGB mapa1 = new MapaRGB(3, 2);
        MapaRGB mapa2 = new MapaRGB(2, 2);
        MapaRGB mapa3 = new MapaRGB(2, 2);
        MapaRGB mapa4 = new MapaRGB(2, 2);
        

        mapa1.setCor(0, 0, CorRGB.BLUE);
        mapa1.setCor(0, 1, CorRGB.BLUE);
        mapa1.setCor(1, 0, CorRGB.BLUE);
        mapa1.setCor(1, 1, CorRGB.BLUE);
        mapa1.setCor(2, 0, CorRGB.BLUE);
        mapa1.setCor(2, 1, CorRGB.BLUE);

        mapa2.setCor(0, 0, CorRGB.GREEN);
        mapa2.setCor(0, 1, CorRGB.ORANGE);

        mapa3.setCor(0, 0, CorRGB.BLUE);
        mapa3.setCor(0, 1, 0,0,10);
        mapa3.setCor(1, 0, CorRGB.BLUE);
        mapa3.setCor(1, 1, CorRGB.BLUE);

        mapa4.setCor(0, 0, 0,0,248);
        mapa4.setCor(0, 1, 0,0,10);
        mapa4.setCor(1, 0, 0,0,250);
        mapa4.setCor(1, 1, 0,0,238);

        mapas.addMapaRGB(0, mapa1);
        mapas.addMapaRGB(1, mapa2);
        mapas.addMapaRGB(2, mapa3);
        mapas.addMapaRGB(3, mapa4);
       

        mapasAux = comparador.getImagemPorLuminosidade(mapas, 0, 0, 255, 10, 40);
        System.out.println("---------------------------Mapas------------------------- ");
        mapas.status();
        System.out.println("---------------------------Mapas PCT------------------------- ");
        for(int i = 0; i < mapasAux.size(); i++){
            System.out.println("Mapa Arraylist " + i + ":");
            mapasAux.get(i).status();
        }
        
        
    }

    public static void luminosidade(){

        CorRGB cor = new CorRGB(0,0,255);
        System.out.println("Luminosidade: " + cor.getLuminosidade());

    }

    public static void lerArquivo() throws Exception{
        String data;
        LerArquivos ler = new LerArquivos();
        data = ler.readFileAsString("C:/Users/jonat/Desktop/teste.txt");
        System.out.println(data);
    }

    public static void getTxt() throws Exception{
        MapaRGB data;
        LerArquivos ler = new LerArquivos();
        data = ler.getFileToMapaRGB("C:/Users/jonat/Desktop/teste.txt");
        data.status();
    }

    public static void main(String[] args) throws Exception {
        /*System.out.println("CMYK to RGB");
        ConversorCMYKtoRGB();
        System.out.println("------------------------------------------------------------------");
        
        System.out.println("RGB to CMYK");
        ConversorRGBtoCMYK();*/
        //luminosidade();
        analise();
    }
    
}
