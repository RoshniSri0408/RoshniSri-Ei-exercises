class Logger {
    private static Logger instance;
    
    // Private constructor to prevent instantiation
    private Logger() {}

    // Method to get the single instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
public class SingletonLoggerDemo {
    public static void main(String[] args) {
        // Get the single instance of the Logger
        Logger logger = Logger.getInstance();
        
        // Log messages from different parts of the application
        logger.log("Application started.");
        performTask1();
        performTask2();
        logger.log("Application ended.");
    }

    private static void performTask1() {
        Logger logger = Logger.getInstance();
        logger.log("Performing task 1.");
    }

    private static void performTask2() {
        Logger logger = Logger.getInstance();
        logger.log("Performing task 2.");
    }
}
