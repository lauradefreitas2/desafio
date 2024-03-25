package org.example.util;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogManager {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void configureLogger() {
        // Configura o nível do logger para INFO
        logger.setLevel(Level.INFO);

        // Configura um console handler para o logger
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);
    }

    public static Logger getLogger(String className) {
        return Logger.getLogger(className);
    }
}
