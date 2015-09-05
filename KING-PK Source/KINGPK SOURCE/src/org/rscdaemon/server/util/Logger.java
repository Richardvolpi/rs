package org.rscdaemon.server.util;

import org.rscdaemon.server.model.World;

public class Logger {
	/**
	 * World instance
	 */
	private static final World world = World.getWorld();
	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
	
	public static void connection(Object o) {
//		System.out.println(o.toString());
	}
	
	public static void mod(Object o) {
		world.getServer().getLoginConnector().getActionSender().logAction(o.toString(), 3);
	}
	
	public static void event(Object o) {
		world.getServer().getLoginConnector().getActionSender().logAction(o.toString(), 1);
	}
	
	public static void error(Object o) {
		if(o instanceof Exception) {
			Exception e = (Exception)o;
			e.printStackTrace();
			if(world == null || !world.getServer().isInitialized()) {
				System.exit(1);
			}
			else {
				world.getServer().kill();
			}
			return;
		}
		world.getServer().getLoginConnector().getActionSender().logAction(o.toString(), 2);
	}
}
