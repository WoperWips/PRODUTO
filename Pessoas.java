import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pessoas {
    // Definindo os atributos da classe
    private String nomeCompleto;
    private double altura;
    private LocalDate dataNascimento;
    private String email;

    // Construtor que recebe nome, altura e data de nascimento como parâmetros
    public Pessoas(String nomeCompleto, double altura, String dataNascimentoStr) throws IllegalArgumentException {
        // Atribui o nome completo e altura aos atributos da classe
        this.nomeCompleto = nomeCompleto;
        this.altura = altura;

        // Converte a string da data de nascimento para um objeto LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        // Valida se a data de nascimento não é posterior à data atual
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de nascimento não pode ser posterior à data atual.");
        }

        // Atribui a data de nascimento válida ao atributo
        this.dataNascimento = dataNascimento;

        // Gera o email automaticamente com base no nome completo
        this.email = gerarEmail(nomeCompleto);
    }

    // Método privado para gerar o email a partir do nome completo
    private String gerarEmail(String nomeCompleto) {
        // Divide o nome completo em partes usando espaços como separador
        String[] partesNome = nomeCompleto.toLowerCase().split(" ");
        String nome = partesNome[0]; // Primeiro nome
        String sobrenome = partesNome[partesNome.length - 1]; // Último sobrenome
        // Retorna o email no formato nome.sobrenome@dominio.com
        return nome + "." + sobrenome + "@dominio.com";
    }

    // Método getter para o nome completo
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    // Método getter para a altura
    public double getAltura() {
        return altura;
    }

    // Método getter para a data de nascimento
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Método getter para o email gerado
    public String getEmail() {
        return email;
    }

    // Método que calcula a idade da pessoa com base na data de nascimento
    public int calcularIdade() {
        // Calcula a diferença em anos entre a data de nascimento e a data atual
        return (int) ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }

    // Método para exibir as informações da pessoa
    public void exibirInformacoes() {
        // Exibe o nome completo
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("Altura: " + altura + " m");
        System.out.println("Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Idade: " + calcularIdade() + " anos");
        System.out.println("Email: " + email);
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        try {
            // Cria a primeira pessoa com nome, altura e data de nascimento válidos
            Pessoas pessoa1 = new Pessoas("Lucas da Silva", 1.75, "15/08/1990");
            // Exibe as informações da primeira pessoa
            pessoa1.exibirInformacoes();

            System.out.println(); // Linha em branco para separar as saídas

            // Cria a segunda pessoa com nome, altura e data de nascimento válidos
            Pessoas pessoa2 = new Pessoas("Alice Taliyah", 1.65, "25/12/2005");
            // Exibe as informações da segunda pessoa
            pessoa2.exibirInformacoes();
        } catch (IllegalArgumentException e) {
            // Caso ocorra uma exceção (como uma data de nascimento inválida), exibe a mensagem de erro
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
