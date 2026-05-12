public class Veiculo {

    private String placa;
    private String modelo;
    private float capacidadeTanque;
    private float combustivelAtual;

    public Veiculo(String placa, String modelo, float capacidadeTanque, float combustivelAtual) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeTanque = capacidadeTanque;
        setCombustivelAtual(combustivelAtual);
    }

    // Getters
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public float getCapacidadeTanque() { return capacidadeTanque; }
    public float getCombustivelAtual() { return combustivelAtual; }

    // Setters com validação
    public void setPlaca(String placa) { this.placa = placa; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCapacidadeTanque(float capacidadeTanque) { this.capacidadeTanque = capacidadeTanque; }

    public void setCombustivelAtual(float combustivelAtual) {
        if (combustivelAtual < 0) {
            throw new IllegalArgumentException("Combustível não pode ser negativo.");
        }
        this.combustivelAtual = combustivelAtual;
    }

    public void abastecer(float litros) {
        if (litros <= 0) {
            System.out.println("Aviso: quantidade de litros inválida.");
            return;
        }
        float total = combustivelAtual + litros;
        if (total > capacidadeTanque) {
            System.out.println("Aviso: abastecimento excederia a capacidade do tanque. Abastecendo até o limite.");
            combustivelAtual = capacidadeTanque;
        } else {
            combustivelAtual = total;
        }
        System.out.printf("Veículo abastecido. Combustível atual: %.2f L%n", combustivelAtual);
    }

    public boolean viajar(float distancia) {
        // Consumo médio: 10 km/l
        float consumo = distancia / 10.0f;
        if (consumo > combustivelAtual) {
            System.out.printf("Erro: combustível insuficiente! Necessário: %.2f L | Disponível: %.2f L%n",
                    consumo, combustivelAtual);
            return false;
        }
        combustivelAtual -= consumo;
        System.out.printf("Viagem realizada! Distância: %.1f km | Consumo: %.2f L | Combustível restante: %.2f L%n",
                distancia, consumo, combustivelAtual);
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo{placa='" + placa + "', modelo='" + modelo +
                "', tanque=" + capacidadeTanque + "L, combustivelAtual=" + combustivelAtual + "L}";
    }
}