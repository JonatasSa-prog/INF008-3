import java.util.ArrayList;

public class AnalisarMapa {

    

    public void analisar(String diretorio,String descricao) throws Exception{
        
        ArrayList<CorRGB> cores = new ArrayList<CorRGB> ();
        CompararMapaCor comparar = new CompararMapaCor();
        CorRGBDAO banco = new CorRGBDAO();
        LerArquivos ler = new LerArquivos();
        MapaRGB mapaAUX = ler.getFileToMapaRGB(diretorio);
        ConnectionMapasRGB.getConnection();
        cores = banco.read(descricao);

        int vet[] = new int[mapaAUX.getLargura() * mapaAUX.getAltura()];
        vet = comparar.getQTD(cores, mapaAUX);
        int pctTotal = 0;
        int tamanho = 0;
        int tamanhoVet = vet.length;
        int tamanhoMapa = mapaAUX.getAltura() * mapaAUX.getLargura();
        int vetPCT[] = new int[tamanhoVet];

        for(int i = 0; i < tamanhoVet; i++){
            tamanho = tamanho * vet[i];
        }

        for(int i = 0; i < tamanhoVet; i++){
            vetPCT[i] = (int) ((vet[i] * 100) / tamanhoMapa);
        }

        for(int i = 0; i < tamanhoVet; i++){
            pctTotal = pctTotal + vetPCT[i];
        }
        System.out.println("O total de porcentagem de " + descricao +" é: " + pctTotal + "%");
        for(int i = 0; i < tamanhoVet; i++){
    
            System.out.println("Cor: " + cores.get(i).getHexa() + " tem: " + vetPCT[i] + "%");
        }



    }
}
