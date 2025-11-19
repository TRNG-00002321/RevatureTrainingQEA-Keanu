import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {
    static void main() {
        Logger logger = LoggerFactory.getLogger(LogDemo.class);

        logger.info("This is info");

        logger.warn("This is a WARNING");

        logger.error("This is an ERROR");
    }
}
