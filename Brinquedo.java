import java.util.Scanner;

class Produto {
    //Definição de classe
    private String nome;
    private String marca;
    private double custoProducao;
    private double precoVendas;
    
    public Produto(String marca, String nome, double custoProducao, double precoVendas) {
        this.marca = marca;
        this.nome = nome;
        this.custoProducao = custoProducao;
        this.precoVendas = precoVendas;
    }
    //retorna o valor de preço e venda
    public double calcularLucro() {
        return precoVendas - custoProducao;
    }
    //definições das classe exibição
    public void exibirInformacoes() {
        System.out.println("Marca:LEGO ");
        System.out.println("Nome:LEGO STAR WARS");
        System.out.println("Custo de Produção: R$" + String.format("%.2f", custoProducao));
        System.out.println("Preço de Vendas: R$" + String.format("%.2f", precoVendas));
        System.out.println("Lucro: R$" + String.format("%.2f", calcularLucro()));
    }
}
    //definção de venda - produção
public class Brinquedo {
    public static void main(String[] args) {
        Produto produto1 = new Produto("LEGO", "LEGO STAR WARS", 50.00, 80.00);
        produto1.exibirInformacoes();
    }
}
