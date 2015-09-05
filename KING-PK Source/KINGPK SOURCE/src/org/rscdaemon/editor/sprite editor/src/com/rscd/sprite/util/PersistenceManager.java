package com.rscd.sprite.util;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class PersistenceManager {
	private static final XStream xstream = new XStream();

	static {
		addAlias("NPCDef", "com.rscd.sprite.entityhandling.defs.NPCDef");
		addAlias("ItemDef", "com.rscd.sprite.entityhandling.defs.ItemDef");
		addAlias("TextureDef", "com.rscd.sprite.entityhandling.defs.extras.TextureDef");
		addAlias("AnimationDef", "com.rscd.sprite.entityhandling.defs.extras.AnimationDef");
		addAlias("ItemDropDef", "com.rscd.sprite.entityhandling.defs.extras.ItemDropDef");
	}
	
	private static void addAlias(String name, String className) {
		try {
			xstream.alias(name, Class.forName(className));
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Object load(File file) {
		try {
			System.out.println("Loading data file: " + file.getName());
			InputStream is =  new GZIPInputStream(new FileInputStream(file));
			Object rv = xstream.fromXML(is);
			is.close();
			return rv;
		}
		catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return null;
	}

	public static void write(File file, Object o) {
		try {
			OutputStream os = new GZIPOutputStream(new FileOutputStream(file));
			xstream.toXML(o, os);
			os.close();
		}
		catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
}
