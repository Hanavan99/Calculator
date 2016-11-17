package org.usd232.robotics.calculator.service;

import org.usd232.robotics.calculator.main.Config;

/**
 * This is where you will request the service implementation.
 * 
 * @author Hanavan Kuhn (Change this)
 *
 */
public class ServiceManager {

	private static Config cfg;
	
	private static IService service;
	
	public static void init(Config cfg) {
		ServiceManager.cfg = cfg;
		service = new ServiceImpl();
	}
	
	public static Config getConfig() {
		return cfg;
	}
	
	public static IService getService() {
		return service;
	}
	
}
