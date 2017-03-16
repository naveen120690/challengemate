package com.challengemate.utils;

import org.apache.log4j.Logger;

public class LogManager {
	private static Logger debugLog = Logger.getLogger("debugLog");
	private static Logger errorLog = Logger.getLogger("errorLog");

	private LogManager() {
	}

	public static Logger getLogger(String loggerName) {
		switch (loggerName) {
		case "debugLog":
			return debugLog;
		case "errorLog":
			return errorLog;
		default:
			return null;
		}
	}
}