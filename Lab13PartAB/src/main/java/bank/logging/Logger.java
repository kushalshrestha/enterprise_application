package bank.logging;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Logger implements ILogger{
	org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);
	}

	@Override
	public void log(String logstring, String logType) {
		switch (logType){
			case "TRACE" :
				logger.trace(logstring);
				break;
			case "DEBUG" :
				logger.debug(logstring);
				break;
			case "INFO" :
				logger.info(logstring);
				break;
			case "WARN" :
				logger.warn(logstring);
				break;
			case "ERROR" :
				logger.error(logstring);
				break;
		}
	}

}
