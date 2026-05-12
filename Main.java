public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   SISTEMA DE LOGÍSTICA - TESTES");
        System.out.println("========================================\n");

        // -------------------------------------------------------
        // 1. Instanciar 2 motoristas
        // -------------------------------------------------------
        System.out.println(">> Criando motoristas...");
        Motorista motorista1 = new Motorista("Carlos Silva", "111.222.333-44", "CNH-001", 2027);
        Motorista motorista2 = new Motorista("Ana Souza",   "555.666.777-88", "CNH-002", 2022); // CNH vencida

        System.out.println("Motorista 1: " + motorista1);
        System.out.println("Motorista 2: " + motorista2);

        // -------------------------------------------------------
        // 2. Instanciar 2 veículos
        // -------------------------------------------------------
        System.out.println("\n>> Criando veículos...");
        Veiculo veiculo1 = new Veiculo("ABC-1234", "Caminhão Volvo FH", 300f, 100f);
        Veiculo veiculo2 = new Veiculo("XYZ-9876", "Van Mercedes Sprinter", 80f, 20f);

        System.out.println("Veículo 1: " + veiculo1);
        System.out.println("Veículo 2: " + veiculo2);

        // -------------------------------------------------------
        // 3. Tentar criar viagem com CNH vencida (deve falhar)
        // -------------------------------------------------------
        System.out.println("\n>> Teste: viagem com CNH vencida (deve falhar)...");
        Viagem viagemInvalida = new Viagem("Belo Horizonte", 200f, motorista2, veiculo2);
        viagemInvalida.gerarRelatorio();
        viagemInvalida.iniciarViagem();

        // -------------------------------------------------------
        // 4. Criar viagem válida, abastecer e executar
        // -------------------------------------------------------
        System.out.println("\n>> Teste: viagem válida com motorista habilitado...");
        veiculo1.abastecer(150f); // Abastece mais combustível

        Viagem viagemValida = new Viagem("São Paulo", 800f, motorista1, veiculo1);
        viagemValida.gerarRelatorio();
        viagemValida.iniciarViagem();
        viagemValida.gerarRelatorio(); // Relatório final após a viagem

        // -------------------------------------------------------
        // 5. Teste extra: combustível negativo (deve lançar exceção)
        // -------------------------------------------------------
        System.out.println("\n>> Teste extra: tentativa de setar combustível negativo...");
        try {
            veiculo2.setCombustivelAtual(-10f);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada corretamente: " + e.getMessage());
        }

        // -------------------------------------------------------
        // 6. Teste extra: nome vazio no motorista
        // -------------------------------------------------------
        System.out.println("\n>> Teste extra: tentativa de criar motorista com nome vazio...");
        try {
            Motorista motoristaSemNome = new Motorista("", "000.000.000-00", "CNH-000", 2026);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada corretamente: " + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("   TESTES CONCLUÍDOS");
        System.out.println("========================================");
    }
}