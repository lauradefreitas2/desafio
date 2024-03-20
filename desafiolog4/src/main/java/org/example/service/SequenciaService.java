package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.service.DesenvolvedorService.LogManager;

public class SequenciaService {
    private static final Logger logger = LogManager.getLogger(String.valueOf(SequenciaService.class));
    private final Scanner scanner;
    private final List<String> numerosSequencia;

    public SequenciaService() {
        this.scanner = new Scanner(System.in);
        this.numerosSequencia = new ArrayList<>();
    }

    public void registrarNumeroSequencia() {
        logger.info("Registrando número de sequência...");
        System.out.println("Registro de Número de Sequência:");

        System.out.print("Número de sequência: ");
        String numeroSequencia = scanner.nextLine();

        numerosSequencia.add(numeroSequencia);

        logger.info("Número de sequência registrado com sucesso!");
    }

    public void consultarNumeroSequencia(String numeroSequencia) {
        logger.info("Consultando número de sequência...");
        System.out.println("Consulta de Número de Sequência:");

        if (numerosSequencia.contains(numeroSequencia)) {
            System.out.println("Número de sequência encontrado: " + numeroSequencia);
        } else {
            System.out.println("Número de sequência não encontrado.");
        }

        logger.info("Consulta de número de sequência concluída.");
    }
}
