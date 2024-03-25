package org.example.service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class RelatorioService {

    private static final Logger logger = Logger.getLogger(RelatorioService.class.getName());

    public static void gerarRelatorio(List<String> dadosRelatorio, String diretorioRelatorio) {
        String nomeArquivo = diretorioRelatorio + "/relatorio.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (String linha : dadosRelatorio) {
                writer.write(linha);
                writer.newLine();
            }
            logger.info("Relatório gerado com sucesso.");
        } catch (IOException e) {
            logger.severe("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}
