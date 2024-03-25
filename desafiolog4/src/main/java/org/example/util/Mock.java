package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class Mock {

    public static List<Desenvolvedor> criarDesenvolvedores() {
        List<Desenvolvedor> desenvolvedores = new ArrayList<>();

        //exemplos de desenvolvedores
        Desenvolvedor funcionario = new Funcionario("Funcionario", "111.111.111-11", "01/01/1990", "F0001", 1);
        Desenvolvedor estagiario = new Estagiario("Estagiario", "222.222.222-22", "01/01/1995", "E0001", 2, (Funcionario) funcionario);
        Desenvolvedor colaborador = new Colaborador("Colaborador", "333.333.333-33", "01/01/1985", "C0001", 3, "Empresa A");

        // Adicionando os desenvolvedores na lista
        desenvolvedores.add(funcionario);
        desenvolvedores.add(estagiario);
        desenvolvedores.add(colaborador);

        return desenvolvedores;
    }

    public static List<Projeto> criarProjetos() {
        List<Projeto> projetos = new ArrayList<>();

        //  exemplos de projetos
        Projeto projeto1 = new Projeto("Projeto A", "Descrição do Projeto A", criarDesenvolvedores().subList(0, 2));
        Projeto projeto2 = new Projeto("Projeto B", "Descrição do Projeto B", criarDesenvolvedores().subList(1, 3));

        // Adicionando os projetos na lista
        projetos.add(projeto1);
        projetos.add(projeto2);

        return projetos;
    }

    public static List<Sequencia> criarSequencias() {
        List<Sequencia> sequencias = new ArrayList<>();

        // Criando exemplos de sequências
        Sequencia sequencia1 = new Sequencia("2022-0850368-5-001", "01/01/2022", "31/12/2022", criarDesenvolvedores().subList(0, 2), StatusDesenvolvimento.AGUARDANDO_ANALISE, DominioAmbiente.MAINFRAME);
        Sequencia sequencia2 = new Sequencia("2023-0850368-5-002", "01/01/2023", "31/12/2023", criarDesenvolvedores().subList(1, 3), StatusDesenvolvimento.CONCLUIDO, DominioAmbiente.OPEN);

        // Adicionando as sequências na lista
        sequencias.add(sequencia1);
        sequencias.add(sequencia2);

        return sequencias;
    }
}