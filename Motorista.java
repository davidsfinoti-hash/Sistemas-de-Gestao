public class Motorista {

    private String nome;
    private String cpf;
    private String cnh;
    private int validadeCnh; // Ano de validade

    public Motorista(String nome, String cpf, String cnh, int validadeCnh) {
        setNome(nome);
        this.cpf = cpf;
        this.cnh = cnh;
        this.validadeCnh = validadeCnh;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getCnh() { return cnh; }
    public int getValidadeCnh() { return validadeCnh; }

    // Setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do motorista não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setCnh(String cnh) { this.cnh = cnh; }
    public void setValidadeCnh(int validadeCnh) { this.validadeCnh = validadeCnh; }

    public boolean cnhValida() {
        return validadeCnh >= 2024;
    }

    @Override
    public String toString() {
        return "Motorista{nome='" + nome + "', cpf='" + cpf + "', cnh='" + cnh + "', validadeCnh=" + validadeCnh + "}";
    }
}