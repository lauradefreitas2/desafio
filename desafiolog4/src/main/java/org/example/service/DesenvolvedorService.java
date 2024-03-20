package org.example.service;

import org.example.model.Desenvolvedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DesenvolvedorService {
    public static Logger LogManager;
    private static final Logger logger = Logger.getLogger(String.valueOf(DesenvolvedorService.class));
    private final Scanner scanner;
    private final List<Desenvolvedor> desenvolvedores;

    public DesenvolvedorService() {
        this.scanner = new Scanner(System.in);
        this.desenvolvedores = new ArrayList<>();
    }

    public void inserirDesenvolvedor() {
        logger.info("Inserindo desenvolvedor...");
        System.out.println("Inserção de Desenvolvedor:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Área de domínio (Mainframe, Open ou Ambos): ");
        String areaDominio = scanner.nextLine();

        Desenvolvedor desenvolvedor = new Desenvolvedor(nome, cpf, dataNascimento, matricula, areaDominio);
        desenvolvedores.add(desenvolvedor);

        logger.info("Desenvolvedor inserido com sucesso!");
    }

    public void consultarDesenvolvedor(String matricula) {
        logger.info("Consultando desenvolvedor...");
        System.out.println("Consulta de Desenvolvedor:");

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.getMatricula().equals(matricula)) {
                System.out.println(desenvolvedor);
                return;
            }
        }
        System.out.println("Desenvolvedor não encontrado.");

        logger.info("Consulta de desenvolvedor concluída.");
    }
}
