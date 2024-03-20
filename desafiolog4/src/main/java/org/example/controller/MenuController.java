package org.example.controller;

import org.example.service.DesenvolvedorService;
import org.example.service.SequenciaService;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.service.DesenvolvedorService.LogManager;

public class MenuController {
    private static final Logger logger = LogManager.getLogger(String.valueOf(MenuController.class));
    private final DesenvolvedorService desenvolvedorService;
    private final SequenciaService sequenciaService;
    private final Scanner scanner;

    public MenuController() {
        this.desenvolvedorService = new DesenvolvedorService();
        this.sequenciaService = new SequenciaService();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Inserir desenvolvedor");
            System.out.println("2. Registrar número de sequência");
            System.out.println("3. Consultar desenvolvedor");
            System.out.println("4. Consultar número de sequência");
            System.out.println("5. Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    inserirDesenvolvedor();
                    break;
                case 2:
                    registrarNumeroSequencia();
                    break;
                case 3:
                    consultarDesenvolvedor();
                    break;
                case 4:
                    consultarNumeroSequencia();
                    break;
                case 5:
                    encerrar();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine();
        } while (opcao != 5);
    }

    private void inserirDesenvolvedor() {
        logger.info("Opção selecionada: Inserir desenvolvedor");
        desenvolvedorService.inserirDesenvolvedor();
    }

    private void registrarNumeroSequencia() {
        logger.info("Opção selecionada: Registrar número de sequência");
        sequenciaService.registrarNumeroSequencia();
    }

    private void consultarDesenvolvedor() {
        logger.info("Opção selecionada: Consultar desenvolvedor");
        System.out.print("Digite a matrícula do desenvolvedor: ");
        String matricula = scanner.nextLine();
        desenvolvedorService.consultarDesenvolvedor(matricula);
    }

    private void consultarNumeroSequencia() {
        logger.info("Opção selecionada: Consultar número de sequência");
        System.out.print("Digite o número de sequência para consultar: ");
        String numeroSequencia = scanner.nextLine();
        sequenciaService.consultarNumeroSequencia(numeroSequencia);
    }

    private void encerrar() {
        logger.info("Encerrando programa...");
        System.out.println("Encerrando programa...");
        // Aqui você pode adicionar qualquer operação de encerramento, se necessário
    }

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.exibirMenu();
    }
}
