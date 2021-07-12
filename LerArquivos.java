import java.nio.file.Files;
import java.nio.file.Paths;

public class LerArquivos {

    public String readFileAsString(String fileName) throws Exception{
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public MapaRGB getFileToMapaRGB(String fileName) throws Exception{
        LerArquivos ler = new LerArquivos();
        String data = ler.readFileAsString(fileName);
        int tamanho = data.length() / 7;
        String auxStr[] = new String[tamanho];
        int tamAuxStr = auxStr.length;
        int countLinhas = 0;
        int countColuna = 0;

        for(int i = 0; i < data.length(); i++){
            char aux = data.charAt(i);
            if(aux == '#')
            countColuna = countColuna + 1;
        }

        for(int i = 0; i < data.length(); i++){
            char aux = data.charAt(i);
            if(aux == '\n')
                countLinhas = countLinhas + 1;
        }
        countLinhas = countLinhas + 1;
        countColuna = countColuna / countLinhas;

        MapaRGB mapaAux = new MapaRGB(countLinhas, countColuna);
        CorRGB cor[] = new CorRGB[tamAuxStr];
        
        auxStr = data.split(" ");
      
        for(int i = 0; i < auxStr.length; i++){
            cor[i] = ler.hex2Rgb(auxStr[i]);
        }

        int a = 0;
    
        for(int i = 0; i < countLinhas; i++){
            for(int j = 0; j < countColuna; j++){
                if(a < 6)
                    mapaAux.modificarPixel(i, j, cor[a]);
                a = a +1;
            }
        }

        return mapaAux;
    }

    public CorRGB hex2Rgb(String colorStr) {
        CorRGB c = new CorRGB(
        Integer.valueOf(colorStr.substring(1, 3), 16), 
        Integer.valueOf(colorStr.substring(3, 5), 16), 
        Integer.valueOf(colorStr.substring(5, 7), 16));
        return c;
    }
}
