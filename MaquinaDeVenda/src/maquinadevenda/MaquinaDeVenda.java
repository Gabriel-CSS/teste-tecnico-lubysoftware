package maquinadevenda;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel C. S. Silva
 */
public class MaquinaDeVenda {
        double rendimentoTotal = 0; // Armazena o rendimento das vendas da máquina
        int vendasTotais = 0; // Armazena o total de vendas realizadas
        
        /* Criando um vetor de bebida do tamanho da variedade de bebidas disponíveis. */
        Bebida bebida[] = new Bebida[9];
        
        JFrame frame = new JFrame("");
       
    public boolean iniciaBebidas(){
        // Definindo os valores padrões
        String nomes[] = new String[]{"Coke", "Soda", "Guaraná", "Orange", "Zero", "Chá", "Skyl", "Brame", "Duff"};
        double precos[] = new double[]{4.50,   3.75,    3.40,      2.95,    4.35,   3.15,   3.30,   3.20,   5.00};
        int quantia[] = new int[]{15, 40, 20, 5, 35, 25, 25, 20, 25};
        
        for(int i=0; i<9; i++){
            bebida[i] = new Bebida(i, nomes[i], precos[i], quantia[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        TelaMaquinaVenda Tela = new TelaMaquinaVenda();
        Tela.show();
    }
    
    public void solicitaVenda(int id){
        
        if(bebida[id].getEstoque() >= 1){
            try{
                String aux = String.format("%.2f", bebida[id].getPreco());
                String aux2 = JOptionPane.showInputDialog(frame, "Bebida selecionada: " + bebida[id].getNome() + 
                            "\nValor: R$ " + aux + 
                            "\n\nInsira um valor correspondente para realizar a compra:", "Drink It - Vending Machine", JOptionPane.PLAIN_MESSAGE);
                
                double inserido = Double.parseDouble(aux2);

                if(inserido < bebida[id].getPreco()){        
                    faltandoValor(id, inserido, bebida[id].getPreco()-inserido);
                }else if(inserido > bebida[id].getPreco()){
                    trocoVenda(id, inserido - bebida[id].getPreco());
                }else{
                    realizarVenda(id);
                }
            }catch(Exception err){
                JOptionPane.showMessageDialog(frame, "Tente informar novamente inserindo apenas valores numéricos\n"
                        + "e separados por . (ponto) quando necessário!", "OPS, erro encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Infelizmente nossas bebidas " + bebida[id].getNome() + " acabaram.\nTente escolher outra bebida.");
        }
    }
    
    public void trocoVenda(int id, double valor){
        String aux; aux = String.format("Troco de R$ %.2f", valor);
        JOptionPane.showMessageDialog(null, aux);
        realizarVenda(id);
    }
    
    public void faltandoValor(int id, double inserido, double faltando){
        try{
            String aux = String.format("%.2f", faltando);
            String aux2 = JOptionPane.showInputDialog(frame, "Você inseriu um valor a menos, favor insira o restante.\n"
                + "R$ " + aux, "Drink It - Vending Machine", JOptionPane.INFORMATION_MESSAGE);
            inserido = Double.parseDouble(aux2);
            if(inserido < faltando){
                faltandoValor(id, inserido, faltando - inserido);
            }else if(inserido > faltando){
                trocoVenda(id, inserido - faltando);
            }else{
                realizarVenda(id);
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(frame, "Tente informar novamente inserindo apenas valores numéricos\n"
                    + "e separados por . (ponto) quando necessário!", "OPS, erro encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void realizarVenda(int id){
        JOptionPane.showMessageDialog(frame, "Pagamento concluído\nPegue abaixo sua bebida " + bebida[id].getNome(), "Drink It - Vending Machine", JOptionPane.PLAIN_MESSAGE);
        bebida[id].alteraEstoque();
        rendimentoTotal += bebida[id].getPreco();
        vendasTotais++;
    }
    
    public void mostraEstoque(){
        String aux, preco;
        
        aux = "Nome        Valor     Quantia\n";
        for(int i=0; i<9; i++){
            preco = String.format("%.2f", bebida[i].getPreco());
            aux += bebida[i].getNome() + "      R$ " + preco + "     " + bebida[i].getEstoque() + "\n";
        }
        JOptionPane.showMessageDialog(frame, aux, "Drink It - Vending Machine", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void mostraVendas(){
        String rendimento = String.format("%.2f", rendimentoTotal);
        JOptionPane.showMessageDialog(frame, "Rendimento das vendas: R$ " + rendimento + "\nTotal de vendas: " + vendasTotais, 
                "Drink It - Vending Machine", JOptionPane.PLAIN_MESSAGE);
    }
    
}
