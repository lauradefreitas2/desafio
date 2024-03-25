package org.example.service;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfiguracaoService {

    private static final Logger logger = Logger.getLogger(ConfiguracaoService.class.getName());

    public static String lerConfiguracao(String chave) {
        Properties propriedades = new Properties();
        String valor = null;

        try (FileInputStream arquivoConfig = new FileInputStream("C:\\suportedbdc_config\\batch\\capacitacao_POSO\\config.properties")) {
            propriedades.load(arquivoConfig);
            valor = propriedades.getProperty(chave);
        } catch (IOException e) {
            logger.severe("Erro ao ler configuração: " + e.getMessage());
        }

        return valor;
    }
}
