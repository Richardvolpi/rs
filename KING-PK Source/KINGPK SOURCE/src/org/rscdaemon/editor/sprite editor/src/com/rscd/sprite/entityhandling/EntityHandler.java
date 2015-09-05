package com.rscd.sprite.entityhandling;

import com.rscd.sprite.util.PersistenceManager;
import com.rscd.sprite.entityhandling.defs.*;
import com.rscd.sprite.entityhandling.defs.extras.*;

import java.io.File;

/**
 * This class handles the loading of entities from the conf files,
 * and provides methods for relaying these entities to the user.
 */
public class EntityHandler {

	private static NPCDef[] npcs;
	private static ItemDef[] items;
	private static TextureDef[] textures;
	private static AnimationDef[] animations;
	
	private static int invPictureCount = 0;

	public static NPCDef getNpcDef(int id) {
		if(id < 0 || id >= npcs.length) {
			return null;
		}
		return npcs[id];
	}
	
	public static int npcCount() {
		return npcs.length;
	}
	
	public static ItemDef getItemDef(int id) {
		if(id < 0 || id >= items.length) {
			return null;
		}
		return items[id];
	}
	
	public static int invPictureCount() {
		return invPictureCount;
	}
	
	public static TextureDef getTextureDef(int id) {
		if(id < 0 || id >= textures.length) {
			return null;
		}
		return textures[id];
	}
	
	public static int textureCount() {
		return textures.length;
	}
	
	public static AnimationDef getAnimationDef(int id) {
		if(id < 0 || id >= animations.length) {
			return null;
		}
		return animations[id];
	}
	
	public static int animationCount() {
		return animations.length;
	}
	
	public static void load() {
		// Do nothing, static { } will do the work
	}

	static {
		npcs = (NPCDef[])PersistenceManager.load(new File("data", "NPCs.rscd"));
		items = (ItemDef[])PersistenceManager.load(new File("data", "Items.rscd"));
		for(int id = 0;id < items.length;id++) {
			if(items[id].getSprite() + 1 > invPictureCount) {
				invPictureCount = items[id].getSprite() + 1;
			}
		}
		textures = (TextureDef[])PersistenceManager.load(new File("data", "Textures.rscd"));
		animations = (AnimationDef[])PersistenceManager.load(new File("data", "Animations.rscd"));
	}
	
}
