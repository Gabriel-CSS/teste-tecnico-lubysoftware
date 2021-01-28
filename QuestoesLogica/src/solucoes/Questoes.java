package solucoes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gabriel C. S. Silva
 */

public class Questoes {
    
    /**
    * Questão 1.1 - Fatorial de um número
    *  OBS: Utilizei valores 'double' pois, o tipo integer não retorna
    *  resultado quando o valor é muito grande!
    */
    
    public double CalcularFatorial(double num){
        double fatorial = 1;
        
        if(num <= 0){
            System.out.println(fatorial);
            return 1;
        }else{
            while (num != 1){
                fatorial *= num;
                num--;
            }

            System.out.println(fatorial);

            return fatorial;
        }
    }
    
    /**
    * Questão 1.2 - CalcularPremio
    * OBS: Como em Java os tipos primitivos (int) não podem receber valores nulos,
    * criei dois métodos de mesmo nome, o primeiro recebe os três parâmetros,
    * o segundo recebe apenas os dois primeiros, não sendo necessário informar o terceiro parâmetro (null).
    */
    
    public int CalcularPremio(int premio, String tipo, int fator){
        if(premio >= 0 && fator >= 0){
            System.out.println(premio * fator);
            return premio * fator;
        }else{
            System.out.println(0);
            return 0;
        }
    }
    public int CalcularPremio(int premio, String tipo){
        
        switch(tipo){
            case "basic":
            default:
                premio *= 1;
                break;
            case "vip":
                premio *= 1.2;
                break;
            case "premium":
                premio *= 1.5;
                break;
            case "deluxe":
                premio *= 1.8;
                break;
            case "special":
                premio *= 2;
                break;
        }
        
        System.out.println(premio);
        return premio;
    }
    
    /*
    * Questão 1.3 - ContarNumerosPrimos
    */
    
    public int ContarNumerosPrimos(int num){
        int primos=0, cont=2;
        
        for(int i=2; i<num; i++){
            for(int j=2; j<i; j++){
                if(i % j == 0) cont++;
            }
            if(cont == 2) primos++;
            cont = 2;
        }
            
        
        System.out.println(primos);
        return primos;
    }
    
    /*
    * Questão 1.4 - CalcularVogais
    */
    public int CalcularVogais(String frase){
        char vogais[] = new char[]{'a', 'e', 'i', 'o', 'u'};
        int total = 0;
        
        frase = frase.toLowerCase(); //utilizei toLowerCase para deixar todas as letras minúsculas, apenas para facilitar
        
        for(int i=0; i<frase.length(); i++){
            for(int j = 0; j<vogais.length; j++){
                if(frase.charAt(i) == vogais[j]){
                    total++;
                }
            }
        }
        
        System.out.println(total);
        return total;
    }
    
    /*
    * Questão 1.5 - CalcularValorComDescontoFormatado
    */
    
    public String CalcularValorComDescontoFormatado(String valorS, String descontoS){
        double valor, desconto;
        
        valorS = valorS.substring(3);
        valorS = valorS.replace(".", "");
        valorS = valorS.replace(",", ".");
        
        valor = Double.parseDouble(valorS);
        desconto = Double.parseDouble(descontoS.replace("%", ""));
        
        valor = valor - (valor * desconto / 100);
        
        valorS = String.format("R$ %.2f", valor); 
        System.out.println(valorS);
        return valorS;
    }
    
    /*
    * Questão 1.6 - CalcularDiferencaData
    */
    
    public int CalcularDiferencaData(String dt1, String dt2) throws ParseException{
        int dias;
        DateFormat date = new SimpleDateFormat("ddMMyyyy");
        Date date1 = date.parse(dt1);
        Date date2 = date.parse(dt2);
        
        long dt = date2.getTime() - date1.getTime();
        
        dias = (int)(dt / 86400000L);
        if(dias < 0) dias *= -1;
        
        System.out.println(dias);
        return dias;
    }
    
    /*
    * Questão 1.7 ObterElementosPares
    */
    public int[] ObterElementosPares(int vetor[]){
        int i;
        ArrayList<Integer> arrPares = new ArrayList<>();
        
        for(i=0; i<vetor.length; i++){
            if(vetor[i] % 2 == 0){
                arrPares.add(vetor[i]);
            }
        }
        
        int pares[] = new int[arrPares.size()];
        
        for(i=0; i<arrPares.size(); i++){
            pares[i] = arrPares.get(i);
            System.out.println(pares[i]);
        }
        
        return pares;
    }
    
    /*
    * Questão 1.8
    */
    public String[] BuscarPessoa(String vetor[], String elemento){
        int i;
        
        ArrayList<String> arrResult = new ArrayList<>();
        
        for(i=0; i<vetor.length; i++){
            if(vetor[i].contains(elemento)){
                arrResult.add(vetor[i]);
            }
        }
        
        String resultado[] = new String[arrResult.size()];
        resultado = arrResult.toArray(resultado);
        
        for(i=0; i<resultado.length; i++){
            System.out.println(resultado[i]);
        }
        
        return resultado;
    }
    
    
    /*
    * Questão 1.9 - TransformarEmMatriz
    */
    
    public int[][] TransformarEmMatriz(String numeros){
        ArrayList<Integer> arrNums = new ArrayList<>();
        int i, j=0;
        
        
        for(i=0; i<numeros.length(); i++){
            if(numeros.charAt(i) != ',') arrNums.add(Character.getNumericValue(numeros.charAt(i)));
        }
        
        int intMatriz[][] = new int[arrNums.size()/2][2];
        i=0;
        
        while(i < (arrNums.size()/2)){
            while(j < arrNums.size()){
                intMatriz[i][0] = arrNums.get(j);
                j++;
                intMatriz[i][1] = arrNums.get(j);
                j++;
                break;
            }
            i++;
        }
        
        for(i=0; i<arrNums.size()/2; i++){
            for(j=0; j<2; j++){
                System.out.print(intMatriz[i][j] + " ");
            }
            System.out.println();
        }
        
        return intMatriz;        
    }
    
    /*
    * Questão 1.10 - ObterElementosFaltantes
    */
    
    public int[] ObterElementosFaltantes(int vetor1[], int vetor2[]){
        
        ArrayList <Integer> arrFaltando = new ArrayList<>();
        ArrayList <Integer> arr1 = new ArrayList<>();
        ArrayList <Integer> arr2 = new ArrayList<>();
        
        int i, j;
        
        for(i=0; i<vetor1.length; i++){
            arr1.add(vetor1[i]);
        }
        
        for(i=0; i<vetor2.length; i++){
            if(!arr1.contains(vetor2[i])) arrFaltando.add(vetor2[i]);
        }
        
        for(i=0; i<vetor2.length; i++){
            arr2.add(vetor2[i]);
        }
        
        for(i=0; i<vetor1.length; i++){
            if(!arr2.contains(vetor1[i])) arrFaltando.add(vetor1[i]);
        }
        
        int vetFaltando[] = new int[arrFaltando.size()];
        
        for(i=0; i<arrFaltando.size(); i++){
            vetFaltando[i] = arrFaltando.get(i);
            System.out.print(vetFaltando[i] + " ");
        }
        System.out.println();
        
        
        return vetFaltando;
    }
    
    
    
}
