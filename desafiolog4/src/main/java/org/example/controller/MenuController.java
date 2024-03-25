package org.example.controller;

import org.example.model.Desenvolvedor;
import org.example.service.DesenvolvedorService;
import org.example.service.RelatorioService;
import org.example.service.SequenciaService;
import org.example.util.Mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.service.DesenvolvedorService.LogManager;

import java.util.Scanner;
import java.util.logging.Logger;
public class MenuController {
    private static final Logger logger = Logger.getLogger(MenuController.class.getName());
    private final DesenvolvedorService desenvolvedorService;
    private final SequenciaService sequenciaService;
    private final BufferedReader reader;

    public MenuController() {
        this.desenvolvedorService = new DesenvolvedorService();
        this.sequenciaService = new SequenciaService();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
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
            opcao = lerOpcaoMenu();

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
            lerOpcaoMenu();
        } while (opcao != 5);
    }

    private int lerOpcaoMenu() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            logger.severe("Erro ao ler a opção do menu: " + e.getMessage());
            return 0;
        }
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
        try {
            String matricula = reader.readLine();
            desenvolvedorService.consultarDesenvolvedor(matricula);
        } catch (IOException e) {
            logger.severe("Erro ao ler a matrícula do desenvolvedor: " + e.getMessage());
        }
    }

    private void consultarNumeroSequencia() {
        logger.info("Opção selecionada: Consultar número de sequência");
        System.out.print("Digite o número de sequência para consultar: ");
        try {
            String numeroSequencia = reader.readLine();
            sequenciaService.consultarNumeroSequencia(numeroSequencia);
        } catch (IOException e) {
            logger.severe("Erro ao ler o número de sequência: " + e.getMessage());
        }
    }

    private void encerrar() {
        logger.info("Encerrando programa...");
        System.out.println("Encerrando programa...");

        RelatorioService.gerarRelatorio(gerarDadosRelatorio(), "C:\\suportedbdc_resource\\batch\\capacitacao\\capacitacao_POSO");
    }

    private List<String> gerarDadosRelatorio() {
        List<String> dadosRelatorio = new ArrayList<>();

        // Adicionando um cabeçalho ao relatório
        dadosRelatorio.add("RELATÓRIO - CONTROLE DE ATIVIDADES");
        List<Sequencia> sequencias = Mock.criarSequencias();
        for (Sequencia sequencia : sequencias) {
            dadosRelatorio.add("Número de sequência: " + sequencia.getNumeroSequencial());

            // Acessar o projeto associado à sequência
            Projeto projeto = sequencia.getProjeto();
            dadosRelatorio.add("Data de início: " + projeto.getDataInicio());
            dadosRelatorio.add("Data final: " + projeto.getDataFinal());

            // Adicionando informações dos desenvolvedores associados ao projeto
            List<Desenvolvedor> desenvolvedores = projeto.getDesenvolvedores();
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                dadosRelatorio.add("Desenvolvedor: " + desenvolvedor.getNome() + " - Matrícula: " + desenvolvedor.getMatricula());
            }
        }
        return dadosRelatorio;
    }
}


