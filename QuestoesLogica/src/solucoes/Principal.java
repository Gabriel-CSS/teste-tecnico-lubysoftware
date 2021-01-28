package solucoes;

import java.text.ParseException;

/**
 * @author Gabriel C. S. Silva
 * 
 * Obs: Utilizar esta classe principal para teste e execução dos métodos 
 * criados para resulução das questões propostas.
 *
 */

public class Principal {
    public static void main(String[]args) throws ParseException{
        Questoes questoes = new Questoes();
        
        //Testando Questão 1.1
        //questoes.CalcularFatorial(5);// 120
        //questoes.CalcularFatorial(-5);// 1
        
        //Testando Questão 1.2
        //questoes.CalcularPremio(100, "vip");// 120
        //questoes.CalcularPremio(100, "basic", 3);// 300
        
        //Testando Questão 1.3
        //questoes.ContarNumerosPrimos(10); // 4
        
        //Testando Questão 1.4
        //questoes.CalcularVogais("Luby Software");// 4
        //questoes.CalcularVogais("LUBY SOFTWARE E DEMAIS");// 8
        
        //Testando Questão 1.5
        //questoes.CalcularValorComDescontoFormatado("R$ 6.800,00", "30%");// "R$ 4.760,00"
        
        //Testando Questão 1.6
        //questoes.CalcularDiferencaData("10122020", "25122020"); //15
        //questoes.CalcularDiferencaData("25122020", "10122020"); //15
        
        //Testando Questão 1.7
        //int[] vetor = new int[] { 1,2,3,4,5 };
        //questoes.ObterElementosPares(vetor);// { 2, 4 }
        
        //Testando Questão 1.8
        /*String[] vetorS = new String[] {
            "John Doe",
            "Jane Doe",
            "Alice Jones",
            "Bobby Louis",
            "Lisa Romero"
        };

        questoes.BuscarPessoa(vetorS, "Doe");// { "John Doe", "Jane Doe" };
        questoes.BuscarPessoa(vetorS, "Alice");// { "Alice Jones" };
        questoes.BuscarPessoa(vetorS, "Louis");//{ };
        */
        
        //Testando Questão 1.9
        //questoes.TransformarEmMatriz("1,2,3,4,5,6"); // {1, 2}, {3, 4}, {5, 6}
        
        //Testando Questão 1.10
        int[] vetor1 = new int[] { 1,2,3,4,5 };
        int[] vetor2 = new int[] { 1,2,5 };
        questoes.ObterElementosFaltantes(vetor1, vetor2);//{ 3, 4 };
        
        // faltam elementos no vetor3
        int[] vetor3 = new int[] { 1,4,5 };
        int[] vetor4 = new int[] { 1,2,3,4,5 };
        questoes.ObterElementosFaltantes(vetor3, vetor4);// { 2, 3 };

        // faltam elementos em ambos vetores
        int[] vetor5 = new int[] { 1,2,3,4 };
        int[] vetor6 = new int[] { 2,3,4,5 };
        questoes.ObterElementosFaltantes(vetor5, vetor6);// { 1, 5 };

        // não faltam items
        int[] vetor7 = new int[] { 1,3,4,5 };
        int[] vetor8 = new int[] { 1,3,4,5 };
        questoes.ObterElementosFaltantes(vetor7, vetor8);// { };
    }
}