public class Viagem {

    private String destino;
    private float distanciaTotal;
    private Motorista motorista;
    private Veiculo veiculo;

    public Viagem(String destino, float distanciaTotal, Motorista motorista, Veiculo veiculo) {
        this.destino = destino;
        this.distanciaTotal = distanciaTotal;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }

    // Getters
    public String getDestino() { return destino; }
    public float getDistanciaTotal() { return distanciaTotal; }
    public Motorista getMotorista() { return motorista; }
    public Veiculo getVeiculo() { return veiculo; }

    // Setters
    public void setDestino(String destino) { this.destino = destino; }
    public void setDistanciaTotal(float distanciaTotal) { this.distanciaTotal = distanciaTotal; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public boolean iniciarViagem() {
        // Verifica se motorista e veículo estão vinculados
        if (motorista == null) {
            System.out.println("Erro: nenhum motorista vinculado à viagem.");
            return false;
        }
        if (veiculo == null) {
            System.out.println("Erro: nenhum veículo vinculado à viagem.");
            return false;
        }

        // Verifica validade da CNH
        if (!motorista.cnhValida()) {
            System.out.println("Erro: CNH do motorista " + motorista.getNome() +
                    " está vencida (validade: " + motorista.getValidadeCnh() + "). Viagem não pode ser iniciada.");
            return false;
        }

        // Tenta realizar a viagem consumindo combustível
        System.out.println("\n--- Iniciando viagem para " + destino + " ---");
        boolean sucesso = veiculo.viajar(distanciaTotal);

        if (!sucesso) {
            System.out.println("Viagem para " + destino + " não pôde ser concluída por falta de combustível.");
        } else {
            System.out.println("Viagem para " + destino + " concluída com sucesso!");
        }

        return sucesso;
    }

    public void gerarRelatorio() {
        System.out.println("\n===== RELATÓRIO DE VIAGEM =====");
        System.out.println("Destino       : " + destino);
        System.out.println("Distância     : " + distanciaTotal + " km");
        System.out.println("Motorista     : " + (motorista != null ? motorista.getNome() : "Não definido"));
        System.out.println("CNH           : " + (motorista != null ? motorista.getCnh() + " (válida até " + motorista.getValidadeCnh() + ")" : "N/A"));
        System.out.println("Veículo       : " + (veiculo != null ? veiculo.getModelo() + " - " + veiculo.getPlaca() : "Não definido"));
        System.out.println("Combustível   : " + (veiculo != null ? veiculo.getCombustivelAtual() + " L restantes" : "N/A"));
        System.out.println("================================\n");
    }
}