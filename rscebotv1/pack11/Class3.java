// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Class3.java

package pack11;

import java.util.ArrayList;
import java.util.HashMap;
import pack1.Class13;
import pack12.*;
import pack3.Class11;
import pack3.Class12;

public class Class3
{

    public Class3()
    {
    }

    public static int method231()
    {
        return anArrayList67.size();
    }

    public static String method232(int i)
    {
        if(i < 0 || i >= anArrayList67.size())
            return null;
        else
            return (String)anArrayList67.get(i);
    }

    public static int method233()
    {
        return anInt68;
    }

    public static int method234()// npcCount
    {
        return npcs.size();
    }

    public static Class9_Sub3 method235(int i)// getNPC
    {
        if(i < 0 || i >= npcs.size())
            return null;
        else
            return (Class9_Sub3)npcs.get(i);
    }

    public static Class9_Sub2 method236(int i)// getItem
    {
        if(i < 0 || i >= items.size())
            return null;
        else
            return (Class9_Sub2)items.get(i);
    }

    public static int method237()// tileSpriteCount
    {
        return tileSprites.size();
    }

    public static int method238()// spriteCount
    {
        return itemSprites.size();
    }

    public static Class11 method239(int i)// getSprite
    {
        if(i < 0 || i >= itemSprites.size())
            return null;
        else
            return (Class11)itemSprites.get(i);
    }

    public static int method240()// spellCount
    {
        return spells.size();
    }

    public static Class9_Sub6 method241(int i)// getSpell
    {
        if(i < 0 || i >= spells.size())
            return null;
        else
            return (Class9_Sub6)spells.get(i);
    }

    public static int method242()// prayerCount
    {
        return prayers.size();
    }

    public static Class9_Sub5 method243(int i)// getPrayer
    {
        if(i < 0 || i >= prayers.size())
            return null;
        else
            return (Class9_Sub5)prayers.get(i);
    }

    public static Class8 method244(int i)
    {
        if(i < 0 || i >= anArrayList63.size())
            return null;
        else
            return (Class8)anArrayList63.get(i);
    }

    public static Class9_Sub4 method245(int i)// getWallObject
    {
        if(i < 0 || i >= wallObjects.size())
            return null;
        else
            return (Class9_Sub4)wallObjects.get(i);
    }

    public static Class10 method246(int i)
    {
        if(i < 0 || i >= anArrayList65.size())
            return null;
        else
            return (Class10)anArrayList65.get(i);
    }

    public static Class9_Sub1 method247(int i)// getObject
    {
        if(i < 0 || i >= objects.size())
            return null;
        else
            return (Class9_Sub1)objects.get(i);
    }

    public static void method248()
    {
        prayers.add(new Class9_Sub5(1, 15, "Thick skin", "Increases your defense by 5%"));
        prayers.add(new Class9_Sub5(4, 15, "Burst of strength", "Increases your strength by 5%"));
        prayers.add(new Class9_Sub5(7, 15, "Clarity of thought", "Increases your attack by 5%"));
        prayers.add(new Class9_Sub5(10, 30, "Rock skin", "Increases your defense by 10%"));
        prayers.add(new Class9_Sub5(13, 30, "Superhuman strength", "Increases your strength by 10%"));
        prayers.add(new Class9_Sub5(16, 30, "Improved reflexes", "Increases your attack by 10%"));
        prayers.add(new Class9_Sub5(19, 5, "Rapid restore", "2x restore rate for all stats except hits"));
        prayers.add(new Class9_Sub5(22, 10, "Rapid heal", "2x restore rate for hitpoints stat"));
        prayers.add(new Class9_Sub5(25, 10, "Protect items", "Keep 1 extra item if you die"));
        prayers.add(new Class9_Sub5(28, 60, "Steel skin", "Increases your defense by 15%"));
        prayers.add(new Class9_Sub5(31, 60, "Ultimate strength", "Increases your strength by 15%"));
        prayers.add(new Class9_Sub5(34, 60, "Incredible reflexes", "Increases your attack by 15%"));
        prayers.add(new Class9_Sub5(37, 60, "Paralyze monster", "Stops monsters from fighting back"));
        prayers.add(new Class9_Sub5(40, 60, "Protect from missiles", "100% protection from ranged attacks"));
    }

    public static void method249()
    {
        anArrayList63.add(new Class8(-16913, 1, 0));
        anArrayList63.add(new Class8(1, 3, 1));
        anArrayList63.add(new Class8(3, 2, 0));
        anArrayList63.add(new Class8(3, 4, 0));
        anArrayList63.add(new Class8(-16913, 2, 0));
        anArrayList63.add(new Class8(-27685, 2, 0));
        anArrayList63.add(new Class8(25, 3, 1));
        anArrayList63.add(new Class8(0xbc614e, 5, 1));
        anArrayList63.add(new Class8(-26426, 1, 1));
        anArrayList63.add(new Class8(-1, 5, 1));
        anArrayList63.add(new Class8(31, 3, 1));
        anArrayList63.add(new Class8(3, 4, 0));
        anArrayList63.add(new Class8(-4534, 2, 0));
        anArrayList63.add(new Class8(32, 2, 0));
        anArrayList63.add(new Class8(-9225, 2, 0));
        anArrayList63.add(new Class8(-3172, 2, 0));
        anArrayList63.add(new Class8(15, 2, 0));
        anArrayList63.add(new Class8(-2, 2, 0));
        anArrayList63.add(new Class8(-1, 3, 1));
        anArrayList63.add(new Class8(-2, 4, 0));
        anArrayList63.add(new Class8(-2, 4, 1));
        anArrayList63.add(new Class8(-2, 0, 0));
        anArrayList63.add(new Class8(-17793, 2, 0));
        anArrayList63.add(new Class8(-14594, 1, 1));
        anArrayList63.add(new Class8(1, 3, 0));
    }

    public static void method250()
    {
        anArrayList65.add(new Class10(64, 6));
        anArrayList65.add(new Class10(64, 3));
        anArrayList65.add(new Class10(96, 2));
        anArrayList65.add(new Class10(80, 33));
        anArrayList65.add(new Class10(80, 15));
        anArrayList65.add(new Class10(90, 49));
    }

    public static void method251()
    {
        tileSprites.add(new Class12("wall", "door"));
        tileSprites.add(new Class12("water", ""));
        tileSprites.add(new Class12("wall", ""));
        tileSprites.add(new Class12("planks", ""));
        tileSprites.add(new Class12("wall", "doorway"));
        tileSprites.add(new Class12("wall", "window"));
        tileSprites.add(new Class12("roof", ""));
        tileSprites.add(new Class12("wall", "arrowslit"));
        tileSprites.add(new Class12("leafytree", ""));
        tileSprites.add(new Class12("treestump", ""));
        tileSprites.add(new Class12("fence", ""));
        tileSprites.add(new Class12("mossy", ""));
        tileSprites.add(new Class12("railings", ""));
        tileSprites.add(new Class12("painting1", ""));
        tileSprites.add(new Class12("painting2", ""));
        tileSprites.add(new Class12("marble", ""));
        tileSprites.add(new Class12("deadtree", ""));
        tileSprites.add(new Class12("fountain", ""));
        tileSprites.add(new Class12("wall", "stainedglass"));
        tileSprites.add(new Class12("target", ""));
        tileSprites.add(new Class12("books", ""));
        tileSprites.add(new Class12("timbered", ""));
        tileSprites.add(new Class12("timbered", "timberwindow"));
        tileSprites.add(new Class12("mossybricks", ""));
        tileSprites.add(new Class12("growingwheat", ""));
        tileSprites.add(new Class12("gungywater", ""));
        tileSprites.add(new Class12("web", ""));
        tileSprites.add(new Class12("wall", "desertwindow"));
        tileSprites.add(new Class12("wall", "crumbled"));
        tileSprites.add(new Class12("cavern", ""));
        tileSprites.add(new Class12("cavern2", ""));
        tileSprites.add(new Class12("lava", ""));
        tileSprites.add(new Class12("pentagram", ""));
        tileSprites.add(new Class12("mapletree", ""));
        tileSprites.add(new Class12("yewtree", ""));
        tileSprites.add(new Class12("helmet", ""));
        tileSprites.add(new Class12("canvas", "tentbottom"));
        tileSprites.add(new Class12("Chainmail2", ""));
        tileSprites.add(new Class12("mummy", ""));
        tileSprites.add(new Class12("jungleleaf", ""));
        tileSprites.add(new Class12("jungleleaf3", ""));
        tileSprites.add(new Class12("jungleleaf4", ""));
        tileSprites.add(new Class12("jungleleaf5", ""));
        tileSprites.add(new Class12("jungleleaf6", ""));
        tileSprites.add(new Class12("mossybricks", "arrowslit"));
        tileSprites.add(new Class12("planks", "window"));
        tileSprites.add(new Class12("planks", "junglewindow"));
        tileSprites.add(new Class12("cargonet", ""));
        tileSprites.add(new Class12("bark", ""));
        tileSprites.add(new Class12("canvas", ""));
        tileSprites.add(new Class12("canvas", "tentdoor"));
        tileSprites.add(new Class12("wall", "lowcrumbled"));
        tileSprites.add(new Class12("cavern", "crumbled"));
        tileSprites.add(new Class12("cavern2", "crumbled"));
        tileSprites.add(new Class12("lava", "flames"));
    }

    public static void method252()
    {
        int ai[] = {
            130, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        };
        npcs.add(new Class9_Sub3("Unicorn", "It's a unicorn", "", 21, 23, 19, 23, true, ai, 0, 0, 0, 0, 201, 230, 6, 6, 7));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bob", "An axe seller", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            129, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sheep", "A very wooly sheep", "", 0, 0, 3, 0, false, ai, 0, 0, 0, 0, 170, 124, 6, 6, 5));
        ai = (new int[] {
            132, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chicken", "Yep definitely a chicken", "", 3, 4, 3, 4, true, ai, 0, 0, 0, 0, 70, 62, 6, 6, 5));
        ai = (new int[] {
            142, 139, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Goblin", "An ugly green creature", "", 16, 14, 12, 13, true, ai, 0, 0, 0, 0, 219, 206, 9, 8, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hans", "A castle servant", "", 3, 3, 3, 3, true, ai, 1, 0xff0000, 65280, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            128, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cow", "It's a multi purpose cow", "", 9, 8, 8, 9, true, ai, 0, 0, 0, 0, 327, 240, 6, 6, 45));
        ai = (new int[] {
            0, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Cook", "The head cook of Lumbridge castle", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xff0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            131, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bear", "Eek! A bear!", "", 25, 23, 25, 26, true, ai, 0, 0, 0, 0, 262, 247, 6, 9, 30));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Priest", "A priest of Saradomin", "", 0, 0, 3, 0, false, ai, 1, 0x202020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Urhney", "He looks a little grumpy", "", 10, 10, 3, 10, false, ai, 1, 0x202020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Man", "One of runescapes many citizens", "pickpocket", 11, 8, 7, 11, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "I could get a beer off him", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            127, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Camel", "Oh its a camel", "", 0, 0, 3, 0, false, ai, 0, 0, 0, 0, 208, 208, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gypsy", "An old gypsy lady", "", 0, 0, 3, 0, false, ai, 0xf2f2f2, 255, 65280, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ghost", "Ooh spooky", "", 15, 15, 5, 15, false, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            13, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sir Prysin", "One of the king's knights", "", 30, 60, 50, 20, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Traiborn The Wizard", "An old wizard", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 28, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Captain Rovin", "The head of the palace guard", "", 40, 70, 65, 30, false, ai, 0xaa6640, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rat", "Overgrown vermin", "", 10, 10, 5, 10, true, ai, 0, 0, 0, 0, 346, 136, 7, 7, 45));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Reldo", "I think he's the librarian", "", 20, 15, 3, 10, false, ai, 1, 2, 65280, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mugger", "He jumps out and attacks people", "", 15, 10, 8, 8, true, ai, 1, 0xff0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lesser Demon", "Lesser but still pretty big", "", 78, 79, 79, 80, true, ai, 0, 0, 0, 0, 275, 262, 11, 11, 30));
        ai = (new int[] {
            125, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Giant Spider", "I think this spider has been genetically modified", "", 10, 10, 5, 10, true, ai, 0, 0, 0, 0, 120, 104, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Man", "A shifty looking man", "", 30, 30, 30, 30, false, ai, 1, 0xff0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jonny The Beard", "I can see why he's called the beard", "", 10, 20, 8, 5, true, ai, 1, 2, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Baraek", "A fur trader", "", 30, 30, 30, 30, false, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Katrine", "She doesn't look to friendly", "", 35, 25, 10, 30, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jake", "A scruffy looking chap", "", 9, 8, 5, 7, false, ai, 0xff0000, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rat", "A small muddy rat", "", 3, 4, 2, 2, true, ai, 0, 0, 0, 0, 115, 45, 7, 7, 10));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Romeo", "He looks mildly confused", "", 20, 60, 60, 40, false, ai, 0xffc260, 255, 0x805020, 0xecded0, 125, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 89, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Juliet", "She looks a little stressed", "", 2, 4, 3, 2, false, ai, 0xeebb70, 0xf4b3f3, 0xf4b3f3, 0xecded0, 125, 225, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Father Lawrence", "A kindly looking priest", "", 0, 0, 3, 0, false, ai, 0xaa6640, 0x202020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Apothecary", "I wonder if he has any good potions", "", 10, 5, 7, 5, false, ai, 0xaa6640, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            125, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Spider", "Incey wincey", "", 5, 2, 2, 1, true, ai, 0, 0, 0, 0, 40, 35, 6, 6, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Delrith", "A freshly summoned demon", "", 42, 35, 7, 37, true, ai, 0, 0, 0, 0, 275, 262, 11, 11, 30));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Veronica", "She doesn't look too happy", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 48, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Weaponsmaster", "The phoenix gang quartermaster", "", 35, 20, 20, 28, true, ai, 1, 0xff0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Professor Oddenstein", "A mad scientist if I ever saw one", "", 3, 3, 7, 3, false, ai, 0xffffff, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Curator", "He looks like he's daydreaming", "", 3, 2, 3, 2, false, ai, 0xffffff, 2, 0x805020, 0xecded0, 145, 200, 6, 6, 5));
        ai = (new int[] {
            133, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skeleton", "It rattles as it walks", "", 24, 20, 17, 23, true, ai, 0, 0, 0, 0, 216, 234, 11, 11, 5));
        ai = (new int[] {
            135, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zombie", "The living dead", "", 23, 28, 24, 23, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            80, 62
        });
        npcs.add(new Class9_Sub3("King", "King Roald the VIII", "", 15, 60, 30, 15, false, ai, 1, 0xff0000, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            138, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Giant Bat", "An angry flying rodent", "", 32, 32, 32, 32, true, ai, 0, 0, 0, 0, 225, 195, 5, 3, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "A friendly barman", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            134, 133, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skeleton", "It rattles as it walks", "", 32, 30, 29, 35, true, ai, 0, 0, 0, 0, 216, 234, 11, 11, 5));
        ai = (new int[] {
            133, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skeleton", "It rattles as it walks", "", 27, 24, 24, 28, true, ai, 0, 0, 0, 0, 216, 234, 11, 11, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rat", "overgrown vermin", "", 16, 12, 10, 15, true, ai, 0, 0, 0, 0, 346, 136, 7, 7, 45));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Horvik The Armourer", "He looks strong", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            131, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bear", "A bear", "", 0, 0, 3, 0, false, ai, 0, 0, 0, 0, 262, 247, 6, 9, 30));
        ai = (new int[] {
            133, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skeleton", "It rattles when it walks", "", 20, 18, 18, 21, true, ai, 0, 0, 0, 0, 216, 234, 11, 11, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            135, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zombie", "The living dead", "", 18, 20, 22, 19, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ghost", "Ooh spooky", "", 23, 30, 25, 23, true, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Aubury", "I think he might be a shop keeper", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "I can buy swords off him", "", 0, 0, 3, 0, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 82, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Darkwizard", "He works evil magic", "", 15, 15, 12, 12, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lowe", "The owner of the archery store", "", 0, 0, 3, 0, false, ai, 0xffc260, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thessalia", "A young shop assistant", "", 0, 0, 3, 0, false, ai, 1, 0xf4b3f3, 3, 0xecded0, 130, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 82, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Darkwizard", "He works evil magic", "", 27, 24, 24, 27, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Giant", "A very large foe", "", 37, 36, 35, 40, true, ai, 1, 2, 0x805020, 0xecded0, 218, 330, 6, 6, 5));
        ai = (new int[] {
            139, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Goblin", "An ugly green creature", "", 8, 9, 5, 9, true, ai, 0, 0, 0, 0, 219, 206, 9, 8, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Farmer", "He grows the crops in this area", "pickpocket", 15, 16, 12, 18, true, ai, 0xaa6640, 0x805020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thief", "He'll take anything that isn't nailed down", "", 24, 22, 17, 23, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He tries to keep order around here", "pickpocket", 31, 30, 22, 31, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            18, 32, 42, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Knight", "A sinister looking knight", "", 45, 50, 42, 48, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            139, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hobgoblin", "A large ugly green creature", "", 32, 34, 29, 34, true, ai, 0, 0, 0, 0, 285, 268, 9, 8, 7));
        ai = (new int[] {
            136, 135, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zombie", "The living dead", "", 32, 31, 30, 35, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zaff", "He trades in staffs", "", 0, 0, 3, 0, false, ai, 0x303030, 2, 3, 0x997326, 145, 220, 6, 6, 5));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Scorpion", "An extremely vicious scorpion", "", 21, 24, 17, 22, true, ai, 0, 0, 0, 0, 362, 208, 7, 7, 45));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Silk Trader", "He sells silk", "", 0, 0, 3, 0, false, ai, 0x303030, 0xff30cc, 0xff30cc, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Man", "One of Runescapes many citizens", "pickpocket", 11, 8, 7, 11, true, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guide", "He gives hints to new adventurers", "", 0, 0, 7, 0, false, ai, 1, 32768, 0x8000ff, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            125, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Giant Spider", "I think this spider has been genetically modified", "", 30, 31, 32, 34, true, ai, 0, 0, 0, 0, 180, 156, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 70, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Peksa", "A helmet salesman", "", 11, 8, 7, 11, false, ai, 0xeebb70, 2, 3, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Barbarian", "Not civilised looking", "", 18, 15, 14, 18, true, ai, 0xeebb70, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fred The Farmer", "An old farmer", "", 11, 8, 7, 11, false, ai, 0xf2f2f2, 0x805020, 0x805030, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gunthor The Brave", "He sure in hell doesn't look so brave..", "", 80, 55, 35, 38, true, ai, 0xeebb70, 0xff5020, 0x805020, 0xecded0, 165, 245, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Witch", "She's got warts", "", 35, 25, 10, 30, true, ai, 1, 2, 3, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ghost", "Ooh spooky", "", 23, 30, 25, 23, true, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wizard", "An old wizard", "", 18, 15, 14, 18, true, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0x604020, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0x604020, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 70, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Zeke", "He sells Scimitars", "", 0, 0, 3, 0, false, ai, 0x303030, 0xffcc30, 0xee3082, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 37, -1, -1, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Louie Legs", "He might want to sell something", "", 0, 0, 3, 0, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 98, 48, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Warrior", "A member of Al Kharid's military", "pickpocket", 20, 17, 19, 18, true, ai, 1, 0xcc40cc, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xccb366, 120, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "Maybe she'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0x604020, 0x805020, 0x805020, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 47, -1, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Highwayman", "He holds up passers by", "", 14, 15, 13, 13, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Kebab Seller", "A seller of strange food", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xccb366, 120, 220, 6, 6, 5));
        ai = (new int[] {
            132, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chicken", "Yep definitely a chicken", "", 3, 4, 3, 4, false, ai, 0, 0, 0, 0, 70, 62, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ernest", "A former chicken", "", 3, 3, 3, 3, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Monk", "A Peaceful monk", "", 12, 13, 15, 12, true, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dwarf", "A short angry guy", "", 20, 17, 16, 20, true, ai, 0x705040, 0x805020, 0x805020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Banker", "He can look after my money", "", 11, 8, 7, 11, false, ai, 0xf2f2f2, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Count Draynor", "A vicious vampire", "", 40, 65, 35, 35, true, ai, 1, 2, 3, 0xfceee0, 140, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Morgan", "A frigtened villager", "", 11, 8, 7, 11, false, ai, 1, 0xf83992, 0x9fab7c, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dr Harlow", "His nose is very red", "", 11, 8, 7, 11, false, ai, 0xf2f2f2, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            126, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Deadly Red Spider", "I think this spider has been genetically modified", "", 40, 36, 35, 35, true, ai, 0, 0, 0, 0, 120, 104, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He's here to guard this fortress", "pickpocket", 31, 30, 22, 31, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cassie", "She sells shields", "", 35, 25, 10, 30, false, ai, 0xffa350, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            19, 34, 43, -1, 49, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("White Knight", "A chivalrous knight", "", 55, 60, 52, 58, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 93, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ranael", "A shopkeeper of some sort", "", 35, 25, 10, 30, false, ai, 0xffa350, 0xdd88aa, 3, 0xccb366, 145, 235, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Moss Giant", "his beard seems to have a life of its own", "", 62, 61, 60, 65, true, ai, 0x779966, 0x805020, 0x805020, 0xdcffd0, 261, 396, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0x604020, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Witch", "She's got warts", "", 35, 25, 10, 30, false, ai, 1, 2, 3, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            18, 32, 42, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Knight", "A sinister looking knight", "", 45, 50, 42, 48, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            139, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Greldo", "A small green warty creature", "", 8, 9, 5, 9, true, ai, 0, 0, 0, 0, 219, 206, 9, 8, 5));
        ai = (new int[] {
            19, 34, 43, -1, 49, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sir Amik Varze", "The head of the White Knights", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 29, 38, 48, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guildmaster", "He's in charge of this place", "", 40, 40, 40, 40, false, ai, 1, 0xcc40cc, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Valaine", "She runs the champion's store", "", 35, 25, 10, 30, false, ai, 0xffa350, 0x30ffff, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Drogo", "He runs a mining store", "", 20, 17, 16, 20, false, ai, 0x705040, 0x907020, 0x907020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Imp", "A cheeky little imp", "", 4, 4, 8, 5, true, ai, 0, 0, 0, 0, 74, 70, 11, 11, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Flynn", "The mace salesman", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wyson The Gardener", "An old gardener", "", 10, 8, 7, 8, false, ai, 0xffffff, 0x888888, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wizard Mizgog", "An old wizard", "", 20, 15, 3, 10, false, ai, 0xddcc88, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Prince Ali", "A young prince", "", 20, 20, 20, 20, false, ai, 1, 0xee50ee, 0xeeee50, 0xccb366, 140, 215, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            79, 62
        });
        npcs.add(new Class9_Sub3("Hassan", "the Chancellor to the emir", "", 20, 20, 20, 20, false, ai, 1, 0xffffff, 0xffffff, 0xccb366, 150, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 82, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Osman", "He looks a little shifty", "", 20, 20, 20, 20, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 116, -1, 22, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Joe", "Lady Keli's head guard", "", 40, 40, 40, 40, false, ai, 1, 2, 3, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Leela", "She comes from Al Kharid", "", 20, 20, 20, 20, false, ai, 1, 0xbb7755, 3, 0xccb366, 140, 215, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 89, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lady Keli", "An Infamous bandit", "", 20, 20, 20, 20, false, ai, 0xffcc58, 0xee50ee, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ned", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Aggie", "A witch", "", 35, 25, 10, 30, false, ai, 1, 0xff0000, 3, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 89, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Prince Ali", "That is an effective disguise", "", 10, 10, 10, 10, false, ai, 0xffcc58, 0xee50ee, 3, 0xecded0, 140, 215, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jailguard", "I wonder what he's guarding", "", 34, 34, 32, 36, true, ai, 0xffcc58, 2, 3, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 48, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Redbeard Frank", "A pirate", "", 35, 25, 10, 30, false, ai, 0xee8030, 2, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Wydin", "A grocer", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "I can buy swords off him", "", 0, 0, 3, 0, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Brian", "An axe seller", "", 0, 0, 3, 0, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Squire", "A young squire", "", 0, 0, 3, 0, false, ai, 0xddcc78, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Head Chef", "He looks after the chef's guild", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xff0000, 0xecded0, 150, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thurgo", "A short angry guy", "", 20, 17, 16, 20, false, ai, 0xeeeeee, 0x805070, 0x805020, 0xccb366, 121, 176, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ice Giant", "He's got icicles in his beard", "", 67, 66, 70, 70, true, ai, 0x6699bb, 0x8090ee, 0x805020, 0x55cfff, 261, 396, 6, 6, 5));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("King Scorpion", "Wow scorpions shouldn't grow that big", "", 40, 38, 30, 39, true, ai, 0, 0, 0, 0, 543, 312, 7, 7, 45));
        ai = (new int[] {
            6, 1, 2, -1, 48, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Pirate", "A vicious pirate", "", 35, 25, 20, 30, true, ai, 1, 0xeeee77, 0xdd0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            19, 34, 43, -1, 49, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sir Vyvin", "One of the white knights of Falador", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 116, -1, 84, 90, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Monk of Zamorak", "An evil cleric", "", 28, 32, 30, 28, true, ai, 0xffc260, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 84, 90, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Monk of Zamorak", "An evil cleric", "", 18, 22, 20, 18, true, ai, 0xffc260, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Wayne", "An armourer", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 140, 210, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Barmaid", "a pretty barmaid", "", 35, 25, 10, 30, false, ai, 0xffa350, 0xffff30, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Dwarven Shopkeeper", "I wonder if he wants to buy any of my junk", "", 20, 17, 16, 20, false, ai, 0x705040, 0x907020, 0x907020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Doric", "A dwarven smith", "", 20, 17, 16, 20, false, ai, 0xffa350, 0x907020, 0x907020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0x604020, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guide", "She gives hints to new adventurers", "", 0, 0, 7, 0, false, ai, 1, 32768, 0x8000ff, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Hetty", "A witch", "", 35, 25, 10, 30, false, ai, 0x309030, 0xff0000, 3, 0xecfed0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Betty", "A witch", "", 35, 25, 10, 30, false, ai, 1, 0xff0000, 3, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "I could get a beer off him", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            142, 141, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("General Wartface", "An ugly green creature", "", 16, 14, 12, 13, false, ai, 0, 0, 0, 0, 264, 250, 9, 8, 5));
        ai = (new int[] {
            142, 140, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("General Bentnoze", "An ugly green creature", "", 16, 14, 12, 13, false, ai, 0, 0, 0, 0, 264, 250, 9, 8, 5));
        ai = (new int[] {
            142, 140, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Goblin", "An ugly green creature", "", 16, 14, 12, 13, true, ai, 0, 0, 0, 0, 219, 206, 9, 8, 5));
        ai = (new int[] {
            142, 141, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Goblin", "An ugly green creature", "", 16, 14, 12, 13, true, ai, 0, 0, 0, 0, 219, 206, 9, 8, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Herquin", "A gem merchant", "", 0, 0, 3, 0, false, ai, 0xffa350, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Rommik", "The owner of the crafting shop", "", 0, 0, 3, 0, false, ai, 0xffa350, 0xff5020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Grum", "Grum the goldsmith", "", 0, 0, 3, 0, false, ai, 0xffa350, 0x707070, 0x707070, 0xecded0, 130, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 44, 100, 118, -1, 35, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ice Warrior", "A strange inhuman warrior", "", 57, 56, 59, 59, true, ai, 0x6699bb, 0x8090ee, 0x8090ee, 0x55cfff, 150, 250, 6, 6, 5));
        ai = (new int[] {
            3, 56, 38, -1, 109, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Warrior", "A skilled fighter", "pickpocket", 35, 25, 20, 30, true, ai, 0xffa350, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Thrander", "A smith of some sort", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 48, -1, 70, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Border Guard", "a guard from Al Kharid", "", 20, 17, 19, 18, false, ai, 1, 0xcc4099, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 48, -1, 70, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Border Guard", "a guard from Al Kharid", "", 20, 17, 19, 18, false, ai, 1, 0xcc4099, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 4, 38, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Customs Officer", "She is here to stop smugglers", "", 23, 12, 15, 14, false, ai, 1, 2, 3, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Luthas", "The owner of the banana plantation", "", 23, 12, 15, 14, false, ai, 1, 2, 3, 0x906020, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zambo", "He will sell me exotic rum", "", 23, 12, 15, 14, false, ai, 0xcc7030, 0x30ccbb, 3, 0x906020, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Captain Tobias", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Gerrant", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0x906020, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Seaman Lorris", "A young sailor", "", 20, 20, 20, 20, false, ai, 0xffa040, 255, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Seaman Thresnor", "A young sailor", "", 20, 20, 20, 20, false, ai, 0xffa040, 255, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Tanner", "He makes leather", "", 20, 60, 60, 40, false, ai, 0xffc260, 0x805020, 0x805020, 0xccb366, 125, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Dommik", "The owner of the crafting shop", "", 0, 0, 3, 0, false, ai, 0xffa350, 0xff5020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Abbot Langley", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thordur", "He runs a a tourist attraction", "", 20, 17, 16, 20, false, ai, 0x705040, 0x907020, 0x907020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Brother Jered", "human", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rat", "Overgrown vermin", "", 16, 12, 10, 15, true, ai, 0, 0, 0, 0, 346, 136, 7, 7, 45));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ghost", "Ooh spooky", "", 23, 30, 25, 23, true, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            134, 133, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skeleton", "it rattles when it walks", "", 32, 30, 29, 35, true, ai, 0, 0, 0, 0, 216, 234, 11, 11, 5));
        ai = (new int[] {
            136, 135, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zombie", "the living dead", "", 32, 31, 30, 35, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lesser Demon", "Lesser but still very big", "", 78, 79, 79, 80, true, ai, 0, 0, 0, 0, 275, 262, 11, 11, 30));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 82, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Melzar The Mad", "He looks totally insane", "", 47, 44, 44, 47, true, ai, 1, 2, 3, 0xfffef0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Scavvo", "He has lopsided eyes", "", 10, 10, 10, 10, false, ai, 0xf2f2f2, 0x704040, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Greater Demon", "big red and incredibly evil", "", 86, 87, 87, 88, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shop Assistant", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0x604020, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Oziach", "A strange little man", "", 0, 0, 3, 0, false, ai, 0x604020, 0x80cc20, 0x80cc20, 0xecded0, 145, 205, 6, 6, 5));
        ai = (new int[] {
            131, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bear", "Eek! A bear!", "", 27, 25, 27, 28, true, ai, 0, 0, 0, 0, 262, 247, 6, 9, 30));
        ai = (new int[] {
            18, 32, 42, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Knight", "An armoured follower of Zamorak", "", 45, 50, 42, 48, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 110, 71, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chaos Dwarf", "a dwarf gone bad", "", 58, 59, 61, 60, true, ai, 0xdd3040, 0xdd3040, 0xdd3040, 0xdd3040, 135, 185, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dwarf", "A dwarf who looks after the mining guild", "", 20, 17, 16, 20, false, ai, 0x705040, 0x907020, 0x907020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            139, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wormbrain", "Dumb even by goblin standards", "", 8, 9, 5, 9, true, ai, 0, 0, 0, 0, 219, 206, 9, 8, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, 46, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Klarense", "A young sailor", "", 20, 20, 20, 20, false, ai, 0xffa040, 221, 4, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ned", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            134, 133, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skeleton", "A Taller than normal skeleton", "", 52, 50, 59, 55, true, ai, 0, 0, 0, 0, 259, 281, 11, 11, 12));
        ai = (new int[] {
            144, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dragon", "A powerful and ancient dragon", "", 110, 110, 110, 110, true, ai, 0, 0, 0, 0, 452, 326, 10, 7, 70));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Oracle", "A mystic of unknown race", "", 57, 56, 59, 59, false, ai, 0x6699bb, 0xddeeee, 0xddeeee, 0x55bfee, 110, 180, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            80, 64
        });
        npcs.add(new Class9_Sub3("Duke of Lumbridge", "Duke Horacio of Lumbridge", "", 15, 60, 30, 15, false, ai, 1, 0xff0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 32, 42, -1, 114, 75, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dark Warrior", "A warrior touched by chaos", "", 20, 25, 17, 23, true, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Druid", "A worshipper of Guthix", "", 28, 32, 30, 28, true, ai, 0xffffff, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            145, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Red Dragon", "A big powerful dragon", "", 150, 150, 140, 150, true, ai, 0, 0, 0, 0, 452, 326, 10, 7, 70));
        ai = (new int[] {
            146, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Blue Dragon", "A mother dragon", "", 110, 115, 105, 105, true, ai, 0, 0, 0, 0, 452, 326, 10, 7, 70));
        ai = (new int[] {
            146, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Baby Blue Dragon", "Young but still dangerous", "", 50, 50, 50, 50, true, ai, 0, 0, 0, 0, 226, 163, 10, 7, 30));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kaqemeex", "A wise druid", "", 28, 32, 30, 28, false, ai, 0xdddddd, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sanfew", "An old druid", "", 28, 32, 30, 28, false, ai, 0xffffff, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            -1, 28, 37, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Suit of Armour", "A dusty old suit of armour", "", 30, 30, 29, 28, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Adventurer", "A cleric", "", 12, 13, 15, 12, false, ai, 0xffa260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 122, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Adventurer", "A wizard", "", 20, 15, 3, 10, false, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 28, 37, -1, 110, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Adventurer", "A Warrior", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, 107, -1, -1, -1, 46, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Adventurer", "An archer", "", 35, 25, 10, 30, false, ai, 0xffa350, 0xeebb40, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Leprechaun", "A funny little man who lives in a tree", "", 20, 17, 16, 20, false, ai, 0x507040, 0x50aa20, 0x50aa20, 0xecded0, 103, 141, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Monk of Entrana", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Monk of Entrana", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            136, 135, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zombie", "The living dead", "", 32, 31, 30, 35, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Monk of Entrana", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tree Spirit", "Ooh spooky", "", 100, 90, 85, 105, true, ai, 0, 0, 0, 0, 241, 292, 9, 9, 5));
        ai = (new int[] {
            128, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cow", "It's a dairy cow", "", 9, 8, 8, 9, false, ai, 0, 0, 0, 0, 327, 240, 6, 6, 45));
        ai = (new int[] {
            78, 82, 88, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Irksol", "Is he invisible or just a set of floating clothes?", "", 115, 115, 115, 115, true, ai, 0x303030, 0xff0000, 0xff0000, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fairy Lunderwin", "A fairy merchant", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0x906020, 94, 143, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jakut", "An unusual looking merchant", "", 2, 2, 3, 2, false, ai, 0x3088cc, 65280, 65280, 0x906020, 145, 260, 6, 6, 5));
        ai = (new int[] {
            0, 1, 37, -1, 110, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Aiden", "He can teleport you to the Deathmatch Arena", "", 55, 60, 52, 58, false, ai, 0x30aaaa, 0x3060cc, 0x30eeee, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Fairy Shopkeeper", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 94, 143, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Fairy Shop Assistant", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0x604020, 0x805020, 0x805020, 0xecded0, 94, 143, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fairy Banker", "He can look after my money", "", 11, 8, 7, 11, false, ai, 0xf2f2f2, 2, 3, 0xecded0, 94, 143, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Giles", "He runs an ore exchange store", "", 30, 30, 30, 30, false, ai, 1, 255, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Miles", "He runs a bar exchange store", "", 30, 30, 30, 30, false, ai, 0xffee99, 255, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Niles", "He runs a fish exchange store", "", 30, 30, 30, 30, false, ai, 0xf2f2f2, 255, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Gaius", "he sells very big swords", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fairy Ladder Attendant", "A worker in the faerie market", "", 0, 0, 3, 0, false, ai, 0xffc260, 0x805020, 0x805020, 0xecded0, 94, 143, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 85, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jatix", "A hard working druid", "", 28, 32, 30, 28, false, ai, 0xaaaaaa, 65535, 0xffffff, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Master Crafter", "The man in charge of the crafter's guild", "", 0, 0, 3, 0, false, ai, 0xffa350, 0xff5020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 49, -1, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Bandit", "He's ready for a fight", "", 32, 33, 27, 26, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 117, -1, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Noterazzo", "A bandit shopkeeper", "", 32, 33, 27, 26, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 49, -1, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Bandit", "A wilderness outlaw", "", 32, 33, 27, 26, true, ai, 1, 221, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Fat Tony", "A Gourmet Pizza chef", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xff0000, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, 49, 98, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Donny The Lad", "A bandit leader", "", 42, 43, 37, 36, true, ai, 0xffa040, 0x7b0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, 109, 98, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Black Heather", "A bandit leader", "", 42, 43, 37, 36, true, ai, 1, 0x7b0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 49, -1, -1, 22, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Speedy Keith", "A bandit leader", "", 42, 43, 37, 36, true, ai, 0xffa040, 0x7b0000, 3, 0xecded0, 150, 230, 6, 6, 5));
        ai = (new int[] {
            147, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("White Wolf Sentry", "A vicious mountain wolf", "", 30, 32, 34, 31, true, ai, 0, 0, 0, 0, 260, 198, 6, 10, 30));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Boy", "He doesn't seem very happy", "", 42, 43, 37, 36, false, ai, 0xffa040, 0x7b0000, 3, 0xecded0, 100, 147, 6, 6, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rat", "He seems to live here", "", 3, 4, 2, 2, false, ai, 0, 0, 0, 0, 115, 45, 7, 7, 10));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Nora T Hag", "She's got warts", "", 35, 25, 10, 30, false, ai, 1, 2, 3, 0xeceed0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            148, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Grey Wolf", "A sinister looking wolf", "", 60, 62, 69, 65, true, ai, 0, 0, 0, 0, 260, 198, 6, 10, 30));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 84, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Evil Red Man", "I've not seen anyone like this before", "", 200, 200, 300, 170, true, ai, 0xdd3040, 0xdd3040, 0xdd3040, 0xdd3040, 150, 185, 6, 6, 5));
        ai = (new int[] {
            125, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cave Spider", "Eek, a cave spider, spooky.", "", 90, 81, 85, 85, true, ai, 0, 0, 0, 0, 120, 104, 6, 6, 5));
        ai = (new int[] {
            131, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cave Bear", "Eek! A bear!", "", 95, 90, 100, 87, true, ai, 0, 0, 0, 0, 262, 247, 6, 9, 30));
        ai = (new int[] {
            148, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cave Wolf", "A sinister looking wolf", "", 99, 97, 120, 175, true, ai, 0, 0, 0, 0, 260, 198, 6, 10, 30));
        ai = (new int[] {
            147, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("White Wolf", "A vicious mountain wolf", "", 40, 42, 44, 41, true, ai, 0, 0, 0, 0, 260, 198, 6, 10, 30));
        ai = (new int[] {
            147, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Pack Leader", "A vicious mountain wolf", "", 70, 72, 74, 71, true, ai, 0, 0, 0, 0, 312, 238, 6, 10, 30));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Harry", "I wonder what he's got for sale", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thug", "He likes hitting things", "", 19, 20, 18, 17, true, ai, 1, 2, 255, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            156, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Firebird", "Probably not a chicken", "", 6, 7, 5, 7, true, ai, 0, 0, 0, 0, 70, 62, 6, 6, 5));
        ai = (new int[] {
            3, 59, 41, 102, 113, 74, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Achetties", "One of Asgarnia's greatest heros", "", 45, 50, 42, 48, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 4, 44, 100, 118, -1, -1, -1, 155, -1, 
            -1, 64
        });
        npcs.add(new Class9_Sub3("Ice Queen", "The leader of the ice warriors", "", 105, 101, 104, 104, true, ai, 0x6699bb, 0x8090ee, 0x8090ee, 0x55cfff, 150, 250, 6, 6, 5));
    }

    public static void method253()
    {
        int ai[] = {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        };
        npcs.add(new Class9_Sub3("Grubor", "A rough looking thief", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xecded0, 150, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 51, -1, -1, -1, -1, -1, -1, 
            79, 67
        });
        npcs.add(new Class9_Sub3("Trobert", "A well dressed thief", "", 14, 15, 13, 13, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 110, -1, 75, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Garv", "A diligent guard", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 48, 163, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "A vicious pirate", "", 35, 25, 20, 30, false, ai, 1, 0xeeee77, 0xdd0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 42, 110, -1, 75, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Grip", "Scar face petes head guard", "", 31, 60, 62, 31, true, ai, 1, 2, 3, 0xecded0, 152, 231, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Alfonse The Waiter", "He should get a clean apron", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Charlie The Cook", "Head cook of the Shrimp and parrot", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xeeaa22, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            159, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard Dog", "He doesn't seem pleased to see me", "", 45, 47, 49, 46, true, ai, 0, 0, 0, 0, 247, 188, 6, 10, 30));
        ai = (new int[] {
            160, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ice Spider", "I think this spider has been genetically modified", "", 60, 66, 65, 65, true, ai, 0, 0, 0, 0, 132, 114, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 48, 163, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Pirate", "A vicious pirate", "", 38, 28, 23, 33, true, ai, 1, 0x777700, 0x660000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 32, 42, -1, 114, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jailer", "Guards prisoners for the black knights", "", 50, 55, 47, 53, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 32, 42, 103, 53, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Lord Darquarius", "A black knight commander", "", 75, 80, 72, 78, true, ai, 1, 2, 3, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Seth", "He runs a fish exchange store", "", 30, 30, 30, 30, false, ai, 0xf2f2f2, 255, 0xdd6040, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Banker", "He can look after my money", "", 11, 8, 7, 11, false, ai, 0xf2f2f2, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 33, 41, 102, 52, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Helemos", "A retired hero", "", 45, 50, 42, 48, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 84, 90, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chaos Druid", "A crazy evil druid", "", 18, 22, 20, 18, true, ai, 0xffffff, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Poison Scorpion", "It has a very vicious looking tail", "", 26, 29, 23, 27, true, ai, 0, 0, 0, 0, 362, 208, 7, 7, 45));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Velrak The Explorer", "he looks cold and hungry", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0x889966, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 34, 43, 101, 49, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Sir Lancelot", "A knight of the round table", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 34, 43, 100, 49, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sir Gawain", "A knight of the round table", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 34, 43, -1, 49, 150, -1, -1, -1, -1, 
            -1, 68
        });
        npcs.add(new Class9_Sub3("King Arthur", "A wise old king", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            18, 32, 42, 103, 53, -1, -1, -1, -1, -1, 
            -1, 64
        });
        npcs.add(new Class9_Sub3("Sir Mordred", "An evil knight", "", 57, 62, 54, 60, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            18, 32, 42, -1, 53, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Renegade Knight", "He isn't very friendly", "", 50, 55, 48, 53, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 48, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Davon", "An amulet trader", "", 35, 25, 20, 30, false, ai, 1, 0xeeee77, 0x9d0000, 0xac9e90, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, 163, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "I could get some grog off him", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Arhein", "A merchant", "", 0, 0, 3, 0, false, ai, 0x303030, 0xcc30cc, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, 122, -1, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Morgan Le Faye", "An evil sorceress", "", 35, 25, 10, 30, false, ai, 1, 2, 3, 0xeceed0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Candlemaker", "He makes and sells candles", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lady", "She has a hint of magic about her", "", 0, 0, 3, 0, false, ai, 0xf2f2f2, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lady", "She has a hint of magic about her", "", 0, 0, 3, 0, false, ai, 0xf2f2f2, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lady", "She has a hint of magic about her", "", 0, 0, 3, 0, false, ai, 0xf2f2f2, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Beggar", "A scruffy looking chap", "", 9, 8, 5, 7, false, ai, 0xffdd00, 2, 3, 0xecded0, 135, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Merlin", "An old wizard", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thrantax", "A freshly summoned demon", "", 90, 90, 90, 90, false, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hickton", "The owner of the archery store", "", 0, 0, 3, 0, false, ai, 0x805030, 0xdd0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            164, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Demon", "A big scary jet black demon", "", 155, 157, 157, 158, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            165, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Dragon", "A fierce dragon with black scales!", "", 210, 190, 190, 170, true, ai, 0, 0, 0, 0, 542, 391, 10, 7, 84));
        ai = (new int[] {
            166, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Poison Spider", "I think this spider has been genetically modified", "", 60, 62, 64, 68, true, ai, 0, 0, 0, 0, 180, 156, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 122, -1, 84, 90, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Monk of Zamorak", "An evil cleric", "", 48, 52, 40, 48, true, ai, 0xffc260, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            167, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hellhound", "Hello nice doggy", "", 115, 112, 116, 114, true, ai, 0, 0, 0, 0, 312, 237, 6, 10, 36));
        ai = (new int[] {
            -1, -1, -1, -1, 109, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Animated Axe", "a magic axe with a mind of it's own", "", 48, 45, 44, 48, true, ai, 0xeebb70, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            168, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Unicorn", "It's a sort of unicorn", "", 31, 33, 29, 33, true, ai, 0, 0, 0, 0, 201, 230, 6, 6, 7));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Frincos", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            78, 82, 88, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Otherworldly Being", "Is he invisible or just a set of floating clothes?", "", 66, 66, 66, 66, true, ai, 0x303030, 0xff0000, 0xff0000, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Owen", "He runs a fish exchange store", "", 30, 30, 30, 30, false, ai, 0xffee99, 255, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 82, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thormac The Sorceror", "A powerful sorcerrer", "", 27, 24, 24, 27, false, ai, 1, 2, 3, 0x997326, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 76, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Seer", "An old wizard", "", 18, 15, 14, 18, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kharid Scorpion", "a smaller less dangerous scorpion", "", 21, 24, 17, 22, false, ai, 0, 0, 0, 0, 121, 69, 7, 7, 45));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kharid Scorpion", "a smaller less dangerous scorpion", "", 21, 24, 17, 22, false, ai, 0, 0, 0, 0, 121, 69, 7, 7, 45));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kharid Scorpion", "a smaller less dangerous scorpion", "", 21, 24, 17, 22, false, ai, 0, 0, 0, 0, 121, 69, 7, 7, 45));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 28, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Barbarian Guard", "Not very civilised", "", 18, 15, 14, 18, false, ai, 0xeebb70, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "I could get a beer off him", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            79, 66
        });
        npcs.add(new Class9_Sub3("Man", "A well dressed nobleman", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gem Trader", "He sells gems", "", 0, 0, 3, 0, false, ai, 0x303030, 0x30ffcc, 0x30ffcc, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            79, 62
        });
        npcs.add(new Class9_Sub3("Dimintheis", "A well dressed nobleman", "", 11, 8, 7, 11, false, ai, 1, 0x773055, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Chef", "A busy looking chef", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xdddd00, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            142, 140, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hobgoblin", "An ugly green creature", "", 49, 47, 49, 48, true, ai, 0, 0, 0, 0, 314, 295, 9, 8, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre", "A large dim looking humanoid", "", 72, 33, 60, 70, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 20, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Boot The Dwarf", "A short angry guy", "", 20, 17, 16, 20, false, ai, 0x705040, 0xa04020, 0x805020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            3, 1, 2, -1, 122, -1, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wizard", "A young wizard", "", 18, 15, 14, 18, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            169, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chronozon", "Chronozon the blood demon", "", 183, 60, 60, 182, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Captain Barnaby", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 4, 38, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Customs Official", "She's here to stop smugglers", "", 23, 12, 15, 14, false, ai, 1, 2, 3, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Man", "One of Runescape's citizens", "pickpocket", 11, 8, 7, 11, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Farmer", "An humble peasant", "pickpocket", 15, 16, 12, 18, true, ai, 0xaa6640, 0x805020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 56, 38, -1, 109, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Warrior", "A skilled fighter", "pickpocket", 35, 25, 20, 30, true, ai, 0xffa350, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He tries to keep the law and order around here", "pickpocket", 31, 30, 22, 31, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            19, 34, 43, -1, 49, -1, -1, -1, -1, -1, 
            -1, 64
        });
        npcs.add(new Class9_Sub3("Knight", "A knight of Ardougne", "pickpocket", 55, 60, 52, 58, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 34, 43, 101, 119, -1, -1, -1, -1, -1, 
            -1, 66
        });
        npcs.add(new Class9_Sub3("Paladin", "A paladin of Ardougne", "pickpocket", 85, 55, 57, 88, true, ai, 0xffc030, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 33, 41, 102, 52, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hero", "A Hero of Ardougne", "pickpocket", 85, 80, 82, 88, true, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Baker", "He sells hot baked bread", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0x880000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Silk Merchant", "He buys silk", "", 0, 0, 3, 0, false, ai, 0x303030, 0xff30cc, 0xff30cc, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 67
        });
        npcs.add(new Class9_Sub3("Fur Trader", "A buyer and seller of animal furs", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 66
        });
        npcs.add(new Class9_Sub3("Silver Merchant", "He deals in silver", "", 0, 0, 3, 0, false, ai, 0x303030, 0xffcccc, 0xffcccc, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Spice Merchant", "He sells exotic spices", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0x880000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gem Merchant", "He sells gems", "", 0, 0, 3, 0, false, ai, 0x303030, 0x30ffcc, 0x30ffcc, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, 56, 93, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zenesha", "A shopkeeper of some sort", "", 35, 25, 10, 30, false, ai, 0xffa350, 0xdd88aa, 3, 0xecded0, 145, 235, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kangai Mau", "A tribesman", "", 0, 0, 3, 0, false, ai, 1, 0x906020, 0xff3030, 0x906020, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 122, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wizard Cromperty", "An old wizard", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("RPDT Employee", "A delivery man", "", 12, 12, 13, 12, false, ai, 0x303030, 170, 170, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Horacio", "An old gardener", "", 10, 8, 7, 8, false, ai, 0xffffff, 0x888888, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Aemad", "He helps run the adventurers store", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Kortan", "He helps run the adventurers store", "", 15, 22, 22, 6, false, ai, 0xffc260, 2, 0x805020, 0xecded0, 155, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zoo Keeper", "He looks after Ardougne city zoo", "", 20, 20, 20, 20, true, ai, 0xffa040, 187, 187, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, 84, -1, -1, -1, 
            -1, 68
        });
        npcs.add(new Class9_Sub3("Make Over Mage", "He can change how I look", "", 0, 0, 3, 0, false, ai, 0x303030, 0xffcc30, 0xee3082, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "I could get a beer off him", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chuck", "A wood merchant", "", 0, 0, 3, 0, false, ai, 0xffa350, 0xff5020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rogue", "He needs a shave", "pickpocket", 24, 22, 17, 23, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            170, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shadow Spider", "Is it a spider or is it a shadow", "", 54, 51, 55, 52, true, ai, 0, 0, 0, 0, 132, 114, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fire Giant", "A big guy with red glowing skin", "", 110, 112, 111, 105, true, ai, 0xbb0000, 0xff7733, 0xff7733, 0xff3333, 261, 396, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Grandpa Jack", "A wistful old man", "", 20, 20, 20, 20, false, ai, 0xeeeeee, 0xbb5544, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Sinister Stranger", "not your average fisherman", "", 40, 65, 35, 35, false, ai, 1, 2, 3, 0xfceee0, 140, 240, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bonzo", "He runs a bone exchange stall", "", 30, 30, 30, 30, false, ai, 1, 0xff0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 107, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Forester", "He looks after McGrubor's wood", "", 24, 22, 17, 23, false, ai, 1, 56576, 43520, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Morris", "Fishing competition organiser", "", 30, 30, 30, 30, false, ai, 1, 0xff0000, 3, 0xecded0, 150, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Brother Omad", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 48, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Thief", "A dastardly blanket thief", "", 24, 22, 17, 23, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 50, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Head Thief", "A dastardly blanket thief", "", 34, 32, 37, 33, true, ai, 1, 2, 3, 0xecded0, 150, 230, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Big Dave", "A well built fisherman", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xecded0, 165, 242, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Joshua", "A grumpy fisherman", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xecded0, 145, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mountain Dwarf", "A short angry guy", "", 20, 17, 16, 20, false, ai, 1, 0x705020, 0x705020, 0xecded0, 130, 180, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mountain Dwarf", "A short angry guy", "", 30, 27, 26, 30, true, ai, 1, 0x705020, 0x705020, 0xecded0, 130, 180, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Brother Cedric", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 84, 90, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Necromancer", "A crazy evil necromancer", "", 28, 42, 40, 28, true, ai, 0xffffff, 65535, 255, 0xffded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            135, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zombie", "The living dead", "", 23, 28, 24, 23, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            18, 1, 2, -1, -1, -1, 82, 88, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lucien", "He walks with a slight limp", "", 24, 22, 17, 23, false, ai, 1, 2, 3, 4, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 36, 97, 108, -1, 20, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("The Fire Warrior of Lesarkus", "A strange red humanoid", "", 72, 50, 59, 72, true, ai, 0xff9966, 0xee9080, 0xee9080, 0xff9f55, 150, 250, 6, 6, 5));
        ai = (new int[] {
            6, 1, 41, -1, -1, -1, 85, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guardian of Armadyl", "A worshipper of Armadyl", "", 58, 52, 50, 58, false, ai, 0xffeeaa, 65535, 255, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 41, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guardian of Armadyl", "A worshipper of Armadyl", "", 58, 52, 50, 58, false, ai, 0xffeeaa, 0xffffff, 255, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            18, 1, 2, -1, -1, -1, 82, 88, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lucien", "He walks with a limp", "", 24, 22, 17, 23, true, ai, 1, 2, 3, 4, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Winelda", "A witch", "", 35, 25, 10, 30, false, ai, 1, 0xff0000, 3, 0xecffd0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Brother Kojo", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            172, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dungeon Rat", "Overgrown vermin", "", 20, 10, 12, 22, true, ai, 0, 0, 0, 0, 346, 136, 7, 7, 45));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Master Fisher", "The man in charge of the fishing guild", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Orven", "He runs a fish exchange store", "", 30, 30, 30, 30, false, ai, 0xffee99, 0xff0000, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Padik", "He runs a fish exchange store", "", 30, 30, 30, 30, false, ai, 0xffee99, 0xff0000, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "He smells of fish", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lady Servil", "She look's wealthy", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "It's one of General Khazard's guard's", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 173, 174, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "It's one of General Khazard's guard's", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 173, 174, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "It's one of General Khazard's guard's", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 117, 173, 174, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "It's one of General Khazard's guard's", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jeremy Servil", "A young squire", "", 0, 0, 3, 0, false, ai, 0xddcc78, 2, 3, 0xecded0, 120, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Justin Servil", "Jeremy servil's father", "", 0, 0, 3, 0, false, ai, 0xbbcc78, 2, 3, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fightslave Joe", "He look's mistreated and weak", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fightslave Kelvin", "He look's mistreated and weak", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Local", "A scruffy looking chap", "", 9, 8, 5, 7, false, ai, 0xffdd00, 2, 3, 0xecded0, 135, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Khazard Bartender", "A tough looking barman", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            18, 32, 42, 103, 53, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("General Khazard", "He look's real nasty", "", 75, 80, 170, 78, true, ai, 1, 2, 3, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Khazard Ogre", "Khazard's strongest ogre warrior", "", 72, 33, 60, 70, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 117, 173, 174, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "It's one of General Khazard's guard's", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Khazard Scorpion", "A large angry scorpion", "", 50, 48, 40, 49, true, ai, 0, 0, 0, 0, 543, 312, 7, 7, 45));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hengrad", "He look's mistreated and weak", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            167, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bouncer", "Hello nice doggy", "", 130, 135, 116, 130, true, ai, 0, 0, 0, 0, 312, 237, 6, 10, 36));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Stankers", "A cheerful looking fellow", "", 0, 0, 3, 0, false, ai, 1, 0x80ff20, 0x805020, 0xdcc399, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Docky", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Shopkeeper", "Maybe he'd like to buy some of my junk", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 150, -1, 86, -1, -1, 
            -1, 66
        });
        npcs.add(new Class9_Sub3("Fairy Queen", "A very little queen", "", 2, 2, 3, 2, false, ai, 0xffd070, 0xffffff, 0xffffff, 0x906020, 94, 143, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Merlin", "An old wizard", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, 122, -1, 82, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Crone", "A strange old lady", "", 35, 25, 10, 30, false, ai, 0x503050, 2, 3, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            79, -1
        });
        npcs.add(new Class9_Sub3("High Priest of Entrana", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0x303030, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Elkoy", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0xddccaa, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Remsai", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0xddccaa, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bolkoy", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0x88cc88, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Local Gnome", "It's a young tree gnome", "", 3, 3, 3, 3, true, ai, 1, 0xff0000, 0x88ee88, 36864, 90, 110, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 150, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Miner Willabii", "Hey look, It's miner Willabii!", "", 3, 3, 3, 3, false, ai, 1, 0xffff00, 0x22cc88, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            18, 32, 42, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Knight Titan", "He is one huge son of a gun...", "", 150, 160, 142, 165, true, ai, 1, 2, 3, 0xecded0, 209, 314, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kalron", "he look's lost", "", 3, 3, 3, 3, true, ai, 1, 0xff0000, 0x88ee00, 36864, 90, 110, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Brother Galahad", "A Peaceful monk", "", 12, 13, 15, 12, false, ai, 0xffc260, 65535, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tracker 1", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0x88cc88, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tracker 2", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0x88cc88, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tracker 3", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0x88cc88, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 98, 117, 173, 174, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Khazard Troop", "It's one of General Khazard's warrior's", "", 31, 30, 22, 31, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 108, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Commander Montai", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 255, 0x88cc88, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 107, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Troop", "It's a tree gnome trooper", "", 3, 3, 3, 3, true, ai, 1, 0xff0000, 0x44cc88, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 32, 42, 103, 53, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Khazard Warlord", "He look's real nasty", "", 75, 80, 170, 78, true, ai, 1, 2, 3, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            19, 34, 43, 101, 49, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Sir Percival", "He's covered in pieces of straw", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, 154, -1, -1, -1, -1, 
            80, 62
        });
        npcs.add(new Class9_Sub3("Fisher King", "an old king", "", 15, 60, 30, 15, false, ai, 0xeeeeee, 0xff0000, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Maiden", "She has a far away look in her eyes", "", 2, 4, 3, 2, false, ai, 0xeebb70, 0xffffff, 0xffffff, 0xecded0, 125, 225, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fisherman", "an old fisherman", "", 15, 60, 30, 15, false, ai, 0xeeeeee, 0xee9933, 0xaaaaaa, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 34, 43, 101, 49, 154, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("King Percival", "The new fisher king", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Unhappy Peasant", "He looks tired and hungry", "", 25, 26, 22, 28, true, ai, 0xaa6640, 0x805020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Happy Peasant", "He looks well fed and full of energy", "", 25, 26, 22, 28, true, ai, 0xaa6640, 0x805020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ceril", "It's Sir ceril carnillean a local noblemen", "", 11, 8, 7, 11, false, ai, 0xffffff, 255, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Butler", "It's the carnillean family butler", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 117, 70, 21, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Carnillean Guard", "It's a carnillean family guard", "", 31, 30, 22, 31, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, 97, 48, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tribesman", "A primative warrior", "", 38, 39, 39, 40, true, ai, 1, 0x906020, 0x906020, 0x705010, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Henryeta", "It's a wealthy looking woman", "", 2, 4, 3, 2, false, ai, 0xeebb70, 0xffffff, 0xffffff, 0xecded0, 125, 225, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Philipe", "It's a young well dressed boy", "", 0, 0, 3, 0, false, ai, 0xddcc78, 2, 3, 0xecded0, 120, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Clivet", "A strange looking man in black ", "", 20, 20, 20, 20, false, ai, 1, 2, 3, 0xccb366, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cult Member", "An suspicous looking man in black ", "", 20, 20, 20, 20, true, ai, 1, 2, 3, 0xccb366, 160, 220, 6, 6, 5));
        ai = (new int[] {
            18, 32, 42, 103, 53, -1, -1, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Lord Hazeel", "He could do with some sun", "", 75, 80, 170, 78, true, ai, 1, 2, 3, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 110, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Alomone", "A musculer looking man in black ", "", 48, 46, 20, 56, false, ai, 3, 2, 3, 0xccb366, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 98, 110, 173, 174, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Khazard Commander", "It's one of General Khazard's commander's", "", 50, 50, 22, 45, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Claus", "the carnillean family cook", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xff0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            129, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("1st Plague Sheep", "The sheep has the plague", "", 0, 0, 3, 0, false, ai, 0, 0, 0, 0, 170, 124, 6, 6, 5));
        ai = (new int[] {
            129, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("2nd Plague Sheep", "The sheep has the plague", "", 0, 0, 3, 0, false, ai, 0, 0, 0, 0, 170, 124, 6, 6, 5));
        ai = (new int[] {
            129, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("3rd Plague Sheep", "The sheep has the plague", "", 0, 0, 3, 0, false, ai, 0, 0, 0, 0, 170, 124, 6, 6, 5));
        ai = (new int[] {
            129, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("4th Plague Sheep", "The sheep has the plague", "", 0, 0, 3, 0, false, ai, 0, 0, 0, 0, 170, 124, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Farmer Brumty", "He looks after livestock in this area", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Doctor Orbon", "A local doctor", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xff0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Councillor Halgrive", "A town counceller", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 255, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Edmond", "A local civilian", "", 20, 20, 20, 20, false, ai, 1, 0xbb00ff, 0xffffff, 0x906020, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Citizen", "He look's tired", "", 12, 11, 13, 10, true, ai, 0xffc030, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Citizen", "He look's frightened", "", 10, 10, 13, 8, true, ai, 0xffc030, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Citizen", "She look's frustrated", "", 11, 10, 13, 14, true, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Citizen", "He look's angry", "", 20, 20, 23, 18, true, ai, 0xff4000, 0xc05020, 0x505020, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Citizen", "He look's disillusioned", "", 18, 12, 10, 20, true, ai, 0x604020, 0xa05050, 0x307020, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jethick", "A cynical old man", "", 18, 12, 10, 20, false, ai, 0xffffff, 0x505080, 0x303020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Mourner", "A mourner or plague healer", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Mourner", "A mourner or plague healer", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ted Rehnison", "The head of the Rehnison family", "", 11, 8, 7, 11, false, ai, 0xf2f2f2, 0x805020, 0x805030, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Martha Rehnison", "A fairly poor looking woman", "", 11, 10, 13, 14, false, ai, 1, 0x805020, 0x805020, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Billy Rehnison", "The Rehnisons eldest son", "", 20, 60, 60, 40, false, ai, 0xffc260, 0x800050, 0x805020, 0xecded0, 125, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Milli Rehnison", "She doesn't seem very happy", "", 42, 43, 37, 36, false, ai, 0xffa040, 0x7b0000, 3, 0xecded0, 112, 198, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Alrena", "She look's concerned", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Mourner", "A mourner or plague healer", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Clerk", "A bueracratic administrator", "", 2, 4, 3, 2, false, ai, 0xffbb50, 0xf477b3, 0xbbbbbb, 0xdccea0, 138, 205, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Carla", "She look's upset", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            79, 64
        });
        npcs.add(new Class9_Sub3("Bravek", "The city warder of West Ardougne", "", 15, 60, 30, 15, false, ai, 1, 0xff0000, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Caroline", "A well dressed middle aged lady", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Holgart", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Holgart", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Holgart", "An old sailor", "", 20, 20, 20, 20, false, ai, 0xffffff, 255, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kent", "Caroline's husband", "", 20, 60, 60, 40, false, ai, 0xffc260, 0x800050, 0x805020, 0xecded0, 125, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Bailey", "The fishing platform cook", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xff0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kennith", "A young scared looking boy", "", 0, 0, 3, 0, false, ai, 0xddcc78, 0xaacc78, 3, 0xecded0, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Platform Fisherman", "an emotionless fisherman", "", 15, 60, 30, 15, true, ai, 0xeeeeee, 0xffcc00, 0xff0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Platform Fisherman", "an emotionless fisherman", "", 15, 60, 30, 15, true, ai, 0xeeeeee, 0xbb00dd, 0xddbbcc, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Platform Fisherman", "an emotionless fisherman", "", 15, 60, 30, 15, true, ai, 0xeeeeee, 0xccddcc, 0xeeaabb, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Elena", "She doesn't look too happy", "", 1, 1, 5, 1, false, ai, 0xcea350, 0xcc99ff, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jinno", "He doesn't seem to mind his lack of legs", "", 30, 30, 30, 30, false, ai, 1, 255, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Watto", "He doesn't seem to mind his lack of legs", "", 30, 30, 30, 30, false, ai, 0xffee99, 255, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 28, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Recruiter", "A member of the Ardougne royal army", "", 40, 70, 65, 30, false, ai, 0xeeb360, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, 63
        });
        npcs.add(new Class9_Sub3("Head Mourner", "In charge of people with silly outfits", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Almera", "A woman of the wilderness", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hudon", "A young boisterous looking lad", "", 0, 0, 3, 0, false, ai, 0xddcc78, 0xaacc78, 3, 0xecded0, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hadley", "A happy looking fellow", "", 15, 60, 30, 15, false, ai, 0xeeeeee, 0xccddcc, 0xeeaabb, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rat", "Overgrown vermin", "", 15, 2, 3, 8, true, ai, 0, 0, 0, 0, 346, 136, 7, 7, 45));
        ai = (new int[] {
            0, 28, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 64
        });
        npcs.add(new Class9_Sub3("Combat Instructor", "He will tell me how to fight", "", 40, 70, 65, 30, false, ai, 0xaa6640, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Golrie", "It's a tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xccbbcc, 0xddccaa, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, 122, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guide", "She gives hints to new adventurers", "", 0, 0, 7, 0, false, ai, 1, 32768, 0x8000ff, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            165, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("King Black Dragon", "The biggest meanest dragon around", "", 315, 300, 325, 170, true, ai, 0, 0, 0, 0, 542, 391, 10, 7, 84));
        ai = (new int[] {
            0, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Cooking Instructor", "Talk to him to learn about runescape food", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fishing Instructor", "He smells of fish", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Financial Advisor", "He knows about money", "", 0, 0, 3, 0, false, ai, 0xffa350, 0x707070, 0x707070, 0xecded0, 130, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gerald", "An old fisherman", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 69, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mining Instructor", "A short angry guy", "", 20, 17, 16, 20, false, ai, 0x705040, 0x805020, 0x805020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Elena", "She looks concerned", "", 1, 1, 5, 1, false, ai, 0xcea350, 0xcc99ff, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Omart", "A nervous looking fellow", "", 15, 60, 30, 15, false, ai, 0xeeeeee, 0xccddcc, 0xeeaabb, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bank Assistant", "She can look after my stuff", "", 11, 8, 7, 11, false, ai, 0xf2f2f2, 0x707070, 0x707070, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jerico", "He looks friendly enough", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kilron", "He looks shifty", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guidor's Wife", "She looks rather concerned", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            0, 28, 37, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Quest Advisor", "I wonder what advise he has to impart", "", 40, 70, 65, 30, false, ai, 0xaa6640, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Chemist", "human", "", 3, 3, 7, 3, false, ai, 0xffffff, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Mourner", "A mourner or plague healer", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Mourner", "A mourner or plague healer", "", 2, 2, 3, 2, false, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 49, -1, -1, -1, -1, -1, -1, 
            -1, 64
        });
        npcs.add(new Class9_Sub3("Wilderness Guide", "He's ready for a fight", "", 32, 33, 27, 26, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Magic Instructor", "An old wizard", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Mourner", "A mourner or plague healer", "", 20, 20, 19, 30, true, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Community Instructor", "This is the last advisor - honest", "", 2, 4, 3, 2, false, ai, 0xff8830, 0xf477b3, 0xbbbbbb, 0xdccea0, 138, 205, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Boatman", "An old sailor", "", 20, 20, 20, 20, false, ai, 0x666666, 255, 3, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            133, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skeleton Mage", "It rattles as it walks", "", 24, 20, 17, 23, true, ai, 0, 0, 0, 0, 216, 234, 11, 11, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Controls Guide", "He's ready for a fight", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Nurse Sarah", "She's quite a looker", "", 1, 1, 5, 1, false, ai, 0xeeb360, 0xffffff, 0xffffff, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Tailor", "He's ready for a party", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 177, 83, 176, 46, 11, 
            45, -1
        });
        npcs.add(new Class9_Sub3("Mourner", "A mourner or plague healer", "", 30, 20, 25, 25, true, ai, 0x303030, 0xff0000, 0xff0000, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He tries to keep order around here", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Chemist", "He looks clever enough", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chancy", "He's ready for a bet", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hops", "He's drunk", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("DeVinci", "He has a colourful personality", "", 32, 33, 27, 26, false, ai, 0xff8830, 0xaabbdd, 0xaabbdd, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Guidor", "He's not that ill", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chancy", "He's ready for a bet", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hops", "He's drunk", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("DeVinci", "He has a colourful personality", "", 32, 33, 27, 26, false, ai, 0xff8830, 0xaabbdd, 0xaabbdd, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            80, 62
        });
        npcs.add(new Class9_Sub3("King Lathas", "King Lanthas of east ardounge", "", 15, 60, 30, 15, false, ai, 1, 0xff0000, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Head Wizard", "He runs the wizards guild", "", 20, 15, 3, 10, false, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Magic Store Owner", "An old wizard", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wizard Frumscone", "A confused looking wizard", "", 20, 15, 3, 10, false, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            135, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Target Practice Zombie", "The living dead", "", 23, 28, 24, 23, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            6, 1, 2, 122, -1, -1, 83, 87, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Trufitus", "A wise old witch doctor", "", 10, 5, 7, 5, false, ai, 0xc0c0c0, 0x6f5737, 0x6f5737, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 28, 37, -1, 109, -1, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Colonel Radick", "A soldier of the town of Yanille", "", 40, 70, 65, 30, true, ai, 0xaa6640, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, 48, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Soldier", "A soldier of the town of Yanille", "", 31, 30, 22, 31, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "I could get a beer off him", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            179, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jungle Spider", "A venomous deadly spider", "", 45, 46, 50, 47, true, ai, 0, 0, 0, 0, 120, 104, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, 10
        });
        npcs.add(new Class9_Sub3("Jiminua", "She looks very interested in selling some of her wares.", "", 0, 0, 3, 0, false, ai, 10, 0x805030, 0x6f5737, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 180, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jogre", "An aggressive humanoid", "", 72, 33, 60, 70, true, ai, 0x3ac826, 0x32cd32, 37633, 0x3cb371, 212, 280, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He tries to keep order around here", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre", "Useful for ranged training", "", 72, 33, 60, 70, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He tries to keep order around here", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 69, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He tries to keep order around here", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shop Keeper", "he sells weapons", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bartender", "I could get a beer off him", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Frenita", "runs a cookery shop", "", 0, 0, 3, 0, false, ai, 0xffa040, 0x805020, 0x805020, 0xecded0, 160, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Chieftan", "A slightly bigger uglier ogre", "", 92, 53, 80, 90, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 192, 197, 187, -1, 204, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rometti", "It's a well dressed tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0xddccaa, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, 201, 202, -1, -1, 
            -1, 65
        });
        npcs.add(new Class9_Sub3("Rashiliyia", "A willowy ethereal being who floats above the ground", "", 80, 80, 80, 80, false, ai, 1, 2, 3, 0x3cb371, 155, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, 193, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Blurberry", "It's a red faced tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xaaaaff, 0xddccaa, 36864, 110, 140, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, 195, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Heckel Funch", "It's another jolly tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0xddccaa, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Aluft Gianne", "It's a tree gnome chef", "", 3, 3, 3, 3, false, ai, 1, 0xccffff, 0xddccdd, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, 195, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Hudo Glenfad", "It's another jolly tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff0000, 0xddccaa, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Irena", "human", "", 0, 0, 0, 0, false, ai, 1, 0xbb7755, 3, 0xccb366, 140, 215, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, 180, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mosol", "A jungle warrior", "", 0, 0, 3, 0, false, ai, 1, 0x906020, 0x906020, 0x906020, 160, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Banker", "It's tree gnome banker", "", 3, 3, 3, 3, false, ai, 0xffffff, 0x101010, 0x101010, 36864, 90, 130, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 150, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("King Narnode Shareen", "It's a gnome he look's important", "", 3, 3, 3, 3, false, ai, 1, 0xffff00, 0xfeff00, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            135, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("UndeadOne", "One of Rashaliyas Minions", "", 80, 59, 59, 50, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 82, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Drucas", "engraver", "", 20, 20, 20, 20, false, ai, 1, 2, 3, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tourist", "human", "", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 150, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("King Narnode Shareen", "It's a gnome he look's important", "", 3, 3, 3, 3, false, ai, 1, 0xffff00, 0xfeff00, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 192, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hazelmere", "An ancient looking gnome", "", 3, 3, 3, 3, false, ai, 1, 0xffff00, 0x22cc88, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 116, 69, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Glough", "An rough looking gnome", "", 3, 3, 3, 3, false, ai, 1, 0x303030, 0x303030, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Shar", "Concerned about the economy", "b38c40", 0, 0, 3, 0, false, ai, 0xffc260, 2, 0x805020, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Shantay", "human", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xb38c40, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Charlie", "Poor guy?", "", 0, 0, 3, 0, true, ai, 1, 0x805020, 0x805020, 0xb38c40, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 98, 180, 175, 22, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Guard", "A tree gnome guard", "", 31, 31, 31, 31, true, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Pilot", "He can fly the glider", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mehman", "local", "805030", 32, 33, 27, 26, false, ai, 0xff8830, 2, 3, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 1, 2, -1, -1, -1, 213, 214, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ana", "This lady doesn't look as if she belongs here.", "", 17, 15, 16, 18, false, ai, 0xffc030, 0x805020, 0x805020, 0x997326, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, 84, 42, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chaos Druid warrior", "A crazy evil druid", "", 48, 42, 40, 48, true, ai, 1, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Pilot", "He can fly the glider", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Shipyard Worker", "He look's busy", "", 48, 42, 40, 48, true, ai, 0x303030, 0x805020, 0x805020, 0xb38c40, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Shipyard Worker", "He look's busy", "", 48, 42, 40, 48, true, ai, 0x303030, 0x805020, 0x805020, 0xb38c40, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Shipyard Worker", "He look's busy", "", 48, 42, 40, 48, true, ai, 0x303030, 0x805020, 0x805020, 0x705010, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 22, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shipyard Foreman", "He look's busy", "", 60, 60, 59, 69, false, ai, 0x303030, 0x805020, 0x805020, 0x705010, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 22, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shipyard Foreman", "He look's busy", "", 60, 60, 59, 69, false, ai, 0x303030, 0x805020, 0x805020, 0x705010, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 98, 180, 175, 22, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Guard", "A tree gnome guard", "", 23, 23, 23, 23, true, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Femi", "It's a little tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Femi", "It's a little tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 193, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Anita", "It's a little tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 116, 69, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Glough", "An rough looking gnome", "", 3, 3, 3, 3, false, ai, 1, 0x303030, 0x303030, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 84, 90, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Salarin The Twisted", "A crazy evil druid", "", 68, 72, 70, 68, true, ai, 0xdd0000, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            164, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Black Demon", "A big scary jet black demon", "", 195, 195, 160, 100, true, ai, 0, 0, 0, 0, 398, 401, 11, 11, 30));
        ai = (new int[] {
            6, 1, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Pilot", "He can fly the glider", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Pilot", "He can fly the glider", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Pilot", "He can fly the glider", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Pilot", "He can fly the glider", "", 3, 3, 3, 3, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            5, 28, 37, -1, 110, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sigbert The Adventurer", "A Warrior", "", 55, 60, 52, 58, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Yanille Watchman", "He watches out for invading ogres", "pickpocket", 41, 30, 22, 41, true, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tower Guard", "He stops people going up the tower", "", 41, 30, 22, 41, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Trainer", "He can advise on training", "", 11, 11, 11, 11, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Trainer", "He can advise on training", "", 11, 11, 11, 11, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Trainer", "He can advise on training", "", 11, 11, 11, 11, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Trainer", "He can advise on training", "pickpocket", 11, 11, 11, 11, false, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Blurberry Barman", "He serves cocktails", "pickpocket", 3, 3, 3, 3, false, ai, 1, 0xffff00, 0xfeff00, 36864, 90, 120, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Waiter", "He can serve you gnome food", "pickpocket", 3, 3, 3, 3, false, ai, 1, 0xffffcc, 0x303030, 36864, 90, 120, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 98, 106, 175, 22, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Guard", "A tree gnome guard", "pickpocket", 31, 31, 31, 17, true, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 192, 198, 189, -1, 204, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Child", "that's a little gnome", "pickpocket", 3, 3, 3, 3, true, ai, 1, 0xffff00, 0xff0000, 36864, 80, 100, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, 97, 47, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Earth Warrior", "A strange inhuman warrior", "", 52, 51, 54, 54, true, ai, 0x6699bb, 0x704020, 0x704020, 0x906020, 150, 250, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 191, 200, 186, -1, 207, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Child", "He's a little fellow", "pickpocket", 3, 3, 3, 3, true, ai, 1, 0xff00ff, 65280, 36864, 80, 100, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 193, 196, 188, -1, 203, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Child", "hello little gnome", "pickpocket", 3, 3, 3, 3, true, ai, 1, 0xff00cc, 255, 36864, 80, 100, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 116, 116, 69, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gulluck", "He sells weapons", "", 10, 11, 11, 11, false, ai, 1, 0x303030, 0x303030, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gunnjorn", "Not civilised looking", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Zadimus", "Ghostly Visage of the dead Zadimus", "", 0, 0, 0, 0, false, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 192, -1, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Brimstail", "An ancient looking gnome", "", 3, 3, 3, 3, false, ai, 1, 0xffff00, 0x22cc88, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 195, 198, 190, -1, 205, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Child", "He's a little fellow", "pickpocket", 3, 3, 3, 3, false, ai, 1, 0xff00cc, 255, 36864, 80, 100, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Local", "A tree gnome villager", "pickpocket", 9, 9, 9, 9, true, ai, 1, 0x805020, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Local", "A tree gnome villager", "pickpocket", 3, 3, 3, 3, true, ai, 1, 0x805020, 0x805020, 36864, 90, 120, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Moss Giant", "his beard seems to have a life of its own", "", 62, 61, 60, 65, true, ai, 0x779966, 0x805020, 0x805020, 0xdcffd0, 261, 396, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0x770011, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 191, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Goalie", "A gnome ball goal catcher", "", 70, 70, 70, 70, false, ai, 1, 0xff4000, 0xff4000, 36864, 100, 120, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0x990066, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 191, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0x990066, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 192, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0x990066, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 193, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0x990011, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 116, 69, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Referee", "He controls the game", "", 3, 3, 3, 3, false, ai, 1, 0x303030, 0x303030, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0x990011, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0xffa040, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0xffa040, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0xffc030, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0xffc030, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0xffc030, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "A tree gnome ball player", "tackle", 70, 70, 70, 70, true, ai, 1, 0xffc030, 0x805020, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "He's on your team", "pass to", 70, 70, 70, 70, false, ai, 1, 0xff4000, 0xff4000, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 194, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gnome Baller", "He's on your team", "pass to", 70, 70, 70, 70, false, ai, 1, 0xff4000, 0xff4000, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cheerleader", "It's a little tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff4000, 0xff4000, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 175, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cheerleader", "It's a little tree gnome", "", 3, 3, 3, 3, false, ai, 1, 0xff4000, 0xff4000, 36864, 100, 140, 6, 6, 5));
        ai = (new int[] {
            135, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Nazastarool Zombie", "One of Rashaliyas Minions", "", 95, 70, 80, 90, true, ai, 0, 0, 0, 0, 261, 388, 12, 12, 5));
        ai = (new int[] {
            134, 133, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Nazastarool Skeleton", "One of Rashaliyas Minions", "", 95, 70, 80, 90, true, ai, 0, 0, 0, 0, 259, 281, 11, 11, 12));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Nazastarool Ghost", "One of Rashaliyas Minions", "", 95, 70, 80, 90, true, ai, 0, 0, 0, 0, 302, 365, 9, 9, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Fernahei", "An enthusiastic fishing shop owner", "", 10, 5, 7, 5, false, ai, 0xc0c0c0, 0x6f5737, 0x6f5737, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 201, -1, -1, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Jungle Banker", "He can look after my money", "", 11, 8, 7, 11, false, ai, 0xc0c0c0, 0x6f5737, 0x6f5737, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cart Driver", "He drives the cart", "", 15, 16, 12, 18, false, ai, 0xffc030, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Cart Driver", "He drives the cart", "", 15, 16, 12, 18, false, ai, 0x303030, 0xffffff, 0xffffff, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 83, 87, -1, -1, 
            -1, 10
        });
        npcs.add(new Class9_Sub3("Shadi", "He knows secret's that you don't know.", "", 0, 0, 3, 0, false, ai, 10, 0x303030, 0x6f5737, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, 10
        });
        npcs.add(new Class9_Sub3("Kaleb", "This is Kaleb Paramaya - a warm and friendly inn owner", "", 0, 0, 3, 0, false, ai, 10, 0xffa040, 0xffffff, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, 10
        });
        npcs.add(new Class9_Sub3("Yohnus", "This is Yohnus - he runs the local blacksmiths", "", 0, 0, 3, 0, false, ai, 10, 0xffa040, 0xffffff, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Serevel", "This is Serevel - he sells tickets for the 'Lady of the Waves'", "", 0, 0, 3, 0, false, ai, 10, 0xffa040, 0xffffff, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 83, -1, -1, -1, 
            -1, 10
        });
        npcs.add(new Class9_Sub3("Yanni", "He sells fishing equipment.", "", 0, 0, 3, 0, false, ai, 10, 0xffffff, 0xff0000, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Official", "He helps the referee", "", 3, 3, 3, 3, false, ai, 10, 1, 0, 0, 100, 130, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Koftik", "The kings top tracker", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Koftik", "The kings top tracker", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Koftik", "The kings top tracker", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Koftik", "The kings top tracker", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Blessed Vermen", "A undead servent of iban", "", 15, 7, 30, 7, true, ai, 0, 0, 0, 0, 115, 45, 7, 7, 10));
        ai = (new int[] {
            125, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Blessed Spider", "One of iban's eight legged friends", "", 45, 31, 32, 34, true, ai, 0, 0, 0, 0, 180, 156, 6, 6, 5));
        ai = (new int[] {
            6, 34, 43, 101, 119, -1, -1, -1, -1, -1, 
            -1, 66
        });
        npcs.add(new Class9_Sub3("Paladin", "A paladin of Ardougne", "", 85, 55, 57, 88, true, ai, 0xffc030, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 34, 43, 101, 119, -1, -1, -1, -1, -1, 
            -1, 66
        });
        npcs.add(new Class9_Sub3("Paladin", "A paladin of Ardougne", "", 85, 55, 57, 88, true, ai, 0xffc030, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Slave", "He seems possessed", "", 17, 15, 16, 18, true, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Slave", "He seems possessed", "", 17, 15, 16, 18, true, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Slave", "He seems to have been here a while", "", 17, 15, 16, 18, true, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Slave", "He seems possessed", "", 17, 15, 16, 18, true, ai, 0xffc030, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Slave", "He seems to have been here a while", "", 17, 15, 16, 18, true, ai, 0xffa040, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Slave", "He seems possessed", "", 17, 15, 16, 18, true, ai, 0xffc030, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Slave", "He seems to have been here a while", "", 17, 15, 16, 18, true, ai, 0xffffaa, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            125, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kalrag", "I think this is one of Ibans pets", "", 88, 69, 78, 78, true, ai, 0, 0, 0, 0, 420, 404, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Niloof", "A short angry guy", "", 20, 17, 16, 20, false, ai, 0x705040, 0x805020, 0x805020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 78, -1, 88, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Kardia The Witch", "She's got warts", "", 35, 25, 10, 30, false, ai, 1, 2, 3, 0xecded0, 155, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Souless", "He seems an empty shell", "", 17, 15, 16, 18, true, ai, 0xffffff, 0x805020, 0x805020, 0xffffff, 100, 200, 6, 6, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Othainian", "big red and incredibly evil", "", 78, 78, 78, 78, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            164, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Doomion", "A big scary jet black demon", "", 98, 98, 98, 98, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Holthion", "big red and incredibly evil", "", 78, 78, 78, 78, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Klank", "A short angry guy", "", 20, 17, 16, 20, false, ai, 0x705040, 0x805020, 0x805020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            18, 1, 2, -1, -1, -1, 82, 88, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Iban", "You feel terror just looking at him", "", 24, 22, 17, 23, false, ai, 1, 2, 3, 4, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Koftik", "The kings top tracker", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            142, 139, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Goblin Guard", "An imposing green creature", "", 48, 51, 43, 51, true, ai, 0, 0, 0, 0, 285, 268, 9, 8, 7));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Observatory Professor", "He works in the observatory", "", 3, 3, 7, 3, false, ai, 0xffffff, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            127, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ugthanki", "A dangerous type of spitting camel that can temporarily blind an opponent.", "", 45, 45, 45, 45, true, ai, 0, 0, 0, 0, 208, 208, 6, 6, 25));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Observatory Assistant", "The Professor's assistant", "", 3, 3, 7, 3, false, ai, 0xffffff, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            210, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Souless", "A servent to zamorak", "", 23, 28, 24, 23, true, ai, 0, 0, 0, 0, 174, 259, 12, 12, 5));
        ai = (new int[] {
            166, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dungeon Spider", "A nasty poisonous arachnid", "", 25, 20, 35, 10, true, ai, 0, 0, 0, 0, 90, 78, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kamen", "A short angry guy", "", 20, 17, 16, 20, false, ai, 0x705040, 0x805020, 0x805020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 84, 90, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Iban Disciple", "An evil follower of Iban", "", 18, 22, 20, 18, true, ai, 0xffc260, 65535, 255, 0xeaded2, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Koftik", "The kings top tracker", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            142, 139, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Goblin", "These goblins have grown strong", "", 24, 20, 16, 18, true, ai, 0, 0, 0, 0, 219, 206, 9, 8, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, 46, -1, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Chadwell", "A sturdy looking gent", "", 18, 15, 14, 18, false, ai, 0xffdd80, 0x805020, 0x805020, 0xecded0, 160, 230, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Professor", "The owner of the observatory", "", 3, 3, 7, 3, false, ai, 0xffffff, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            -1, -1, -1, 99, 49, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("San Tojalon", "The animated spirit of San Tojalon", "", 120, 120, 120, 120, true, ai, 0xffc030, 0x805020, 0x805020, 0x997326, 120, 220, 6, 6, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ghost", "A doomed victim of zamorak", "", 33, 33, 20, 30, true, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Spirit of Scorpius", "The undead spirit of the follower of Zamorak", "", 100, 100, 100, 100, false, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Scorpion", "There are nasty scorpions around this grave", "", 21, 24, 17, 22, false, ai, 0, 0, 0, 0, 121, 69, 7, 7, 45));
        ai = (new int[] {
            6, 1, 2, -1, 122, -1, 84, -1, -1, -1, 
            -1, 68
        });
        npcs.add(new Class9_Sub3("Dark Mage", "He works in the ways of dark magic", "", 0, 0, 3, 0, false, ai, 0x303030, 0xffcc30, 0xee3082, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mercenary", "He seems to be guarding an area", "", 48, 60, 60, 32, true, ai, 1, 0xada381, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 51, 71, 22, -1, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Mercenary Captain", "He's in control of the local guards.", "watch", 48, 80, 80, 48, true, ai, 1, 0xada381, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mercenary", "He seems to be guarding an area", "", 48, 30, 48, 32, true, ai, 1, 0xada381, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 213, 214, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mining Slave", "A chained slave forced to mines.", "", 17, 15, 16, 18, true, ai, 0xffffaa, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Watchtower Wizard", "A learned man", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 122, 75, 21, -1, -1, 11, 
            79, 83
        });
        npcs.add(new Class9_Sub3("Ogre Shaman", "An intelligent form of ogre", "", 100, 100, 100, 100, false, ai, 0x339900, 0x9900ff, 26367, 26367, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skavid", "Servant race to the ogres", "", 3, 3, 3, 3, false, ai, 0x99999, 0x99cc99, 0x999999, 0x999999, 96, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 114, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Guard", "These ogres protect the city", "", 92, 53, 80, 90, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 114, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Guard", "These ogres protect the city", "", 92, 53, 80, 90, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Guard", "These ogres protect the city", "", 92, 53, 80, 90, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skavid", "Servant race to the ogres", "", 3, 3, 3, 3, false, ai, 0x99999, 0x999999, 0x999999, 0x999999, 96, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skavid", "Servant race to the ogres", "", 3, 3, 3, 3, false, ai, 0x99999, 0x999999, 0x999999, 0x999999, 96, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Og", "The chieftan of this ogre tribe", "", 92, 53, 80, 90, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Grew", "The chieftan of this ogre tribe", "", 92, 53, 80, 90, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Toban", "The chieftan of this ogre tribe", "", 92, 53, 80, 90, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, 70, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gorad", "A high ranking ogre official", "", 92, 53, 80, 90, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 114, -1, 24, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Guard", "this creature looks very tough", "", 98, 99, 99, 90, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 233, 320, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Yanille Watchman", "A captured guard of Yanille", "", 41, 30, 22, 41, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Merchant", "He sells ogre-inspired items", "", 72, 33, 60, 70, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Trader", "He trades in metals", "", 72, 33, 60, 70, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Trader", "He trades in food", "", 72, 33, 60, 70, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Trader", "He trades in food", "", 72, 33, 60, 70, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mercenary", "He seems to be guarding an area", "", 48, 30, 48, 32, true, ai, 1, 0xada381, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, 70, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("City Guard", "high ranking ogre guards", "", 92, 53, 80, 90, false, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mercenary", "He seems to be guarding this area", "", 48, 30, 48, 32, true, ai, 1, 0xada381, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Lawgof", "He guards the mines", "", 20, 17, 16, 20, false, ai, 0x705040, 0x303030, 0x303030, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dwarf", "A short angry guy", "", 20, 17, 16, 20, true, ai, 0x705040, 0x303030, 0x303030, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lollk", "He looks scared", "", 20, 17, 16, 20, false, ai, 0x705040, 0x303030, 0x303030, 0xecded0, 90, 130, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skavid", "Servant race to the ogres", "", 3, 3, 3, 3, false, ai, 0x99999, 0x999999, 0x999999, 0x999999, 96, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 119, -1, 22, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Guard", "These ogres protect the city", "", 92, 53, 80, 90, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 222, 294, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Nulodion", "He's the head of black guard weapon development", "", 20, 17, 16, 20, false, ai, 0x705040, 0x303030, 0x303030, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 109, 70, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Dwarf", "A short angry guy", "", 20, 17, 16, 20, true, ai, 0x705040, 0x303030, 0x303030, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, 154, 85, 86, 155, 211, 
            80, 215
        });
        npcs.add(new Class9_Sub3("Al Shabim", "The leader of a nomadic Bedabin desert people - sometimes referred to as the 'Tenti's'", "", 0, 0, 3, 0, false, ai, 1, 0x202020, 3, 0x604020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bedabin Nomad", "A Bedabin nomad - they live in the harshest extremes in the desert", "", 0, 0, 3, 0, false, ai, 1, 0x202020, 3, 0x604020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 51, 150, 22, -1, -1, -1, 
            -1, 68
        });
        npcs.add(new Class9_Sub3("Captain Siad", "He's in control of the whole mining camp.", "", 48, 48, 48, 48, true, ai, 1, 0xffffff, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 48, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bedabin Nomad Guard", "A Bedabin nomad guard - he's protecting something important", "", 70, 70, 70, 70, true, ai, 1, 0x202020, 3, 0x604020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre Citizen", "A denizen of Gu'Tanoth", "", 72, 33, 60, 70, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rock of Ages", "A tiny little minion, ready to crush your pixelated skull", "", 150, 170, 850, 150, true, ai, 0, 0, 0, 0, 74, 70, 11, 11, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ogre", "A large dim looking humanoid", "", 72, 33, 60, 70, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skavid", "Servant race to the ogres", "", 3, 3, 3, 3, false, ai, 0x99999, 0x999999, 0x999999, 0x999999, 96, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skavid", "Servant race to the ogres", "", 3, 3, 3, 3, false, ai, 0x99999, 0x999999, 0x999999, 0x999999, 96, 176, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, 117, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Skavid", "Servant race to the ogres", "", 3, 3, 3, 3, false, ai, 0x99999, 0x999999, 0x999999, 0x999999, 96, 176, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Draft Mercenary Guard", "He's quickly drafted in to deal with trouble makers", "", 48, 60, 60, 32, true, ai, 1, 0xada381, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Mining Cart Driver", "He drives the mining cart", "", 15, 16, 12, 18, false, ai, 0xffc030, 0xffffff, 0xffffff, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, 70, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kolodion", "He runs the mage arena", "", 20, 15, 3, 10, false, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, 70, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kolodion", "He runs the mage arena", "", 20, 15, 3, 10, true, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 89, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gertrude", "A busy housewife", "", 20, 20, 20, 20, false, ai, 0xffcc58, 0xee50ee, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shilop", "A young boisterous looking lad", "", 0, 0, 3, 0, false, ai, 0xddcc78, 0xaacc78, 3, 0xecded0, 100, 140, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, 70, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rowdy Guard", "He looks as if he's spoiling for trouble", "", 48, 60, 60, 32, true, ai, 1, 0xada381, 0xe2ba18, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shantay Pass Guard", "He seems to be guarding the Shantay Pass", "", 32, 32, 32, 32, true, ai, 1, 0xada381, 0x808000, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 213, 214, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Rowdy Slave", "A slave who's looking for trouble.", "", 17, 15, 16, 18, true, ai, 0xffffaa, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 49, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shantay Pass Guard", "He seems to be guarding the Shantay Pass", "", 32, 32, 32, 32, false, ai, 1, 0xada381, 0x808000, 0xb38c40, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Assistant", "He is an assistant to Shantay and helps him to run the pass.", "", 0, 0, 3, 0, false, ai, 1, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            216, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Desert Wolf", "A vicious Desert wolf", "", 30, 32, 34, 31, true, ai, 0, 0, 0, 0, 260, 198, 6, 10, 30));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, 11, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Workman", "This person is working on the site", "pickpocket", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Examiner", "As you examine the examiner you examine that she is indeed an examiner!!", "", 1, 1, 5, 1, false, ai, 0xeeb360, 255, 3, 0xecded0, 140, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Student", "A student busily digging!", "", 0, 0, 3, 0, false, ai, 1, 0xf4b3f3, 3, 0xecded0, 130, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Student", "A student busily digging!", "", 20, 20, 20, 20, false, ai, 1, 52224, 0xeeee50, 0xccb366, 140, 215, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guide", "This person specialises in panning for gold", "", 20, 15, 3, 10, false, ai, 1, 0x996600, 0x663300, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Billy", "He fixes your Dragon Squares for a small fee!", "", 20, 17, 19, 18, false, ai, 1, 0xff6600, 3, 0x996633, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sil", "Don't let his looks dazzle you", "", 20, 20, 3, 20, false, ai, 1, 0xffffff, 0xff0000, 0x663300, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Civillian", "He looks aggitated!", "", 20, 17, 19, 18, true, ai, 1, 0xff6600, 3, 0x996633, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 88, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Civillian", "She looks aggitated!", "", 0, 0, 3, 0, false, ai, 1, 0xf4b3f3, 3, 0xecded0, 130, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Civillian", "She looks aggitated!", "", 0, 0, 3, 0, false, ai, 0xffffff, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Civillian", "He looks aggitated!", "pickpocket", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Murphy", "The man in charge of the fishing trawler", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Murphy", "The man in charge of the fishing trawler", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 41, -1, 52, 74, 25, -1, -1, -1, 
            80, 68
        });
        npcs.add(new Class9_Sub3("Sir Radimus Erkle", "A huge muscular man in charge of the Legends Guild", "", 10, 20, 8, 5, false, ai, 0xffffff, 0xccb366, 0xccb366, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 180, 72, 23, 94, -1, -1, 
            -1, 215
        });
        npcs.add(new Class9_Sub3("Legends Guild Guard", "This guard is protecting the entrance to the Legends Guild.", "", 50, 50, 50, 50, false, ai, 0x604020, 0xccb366, 0xccb366, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, 85, 86, -1, 211, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Escaping Mining Slave", "An emancipated slave with cool Desert Clothes.", "", 17, 15, 16, 18, false, ai, 0xffffaa, 0x805020, 0x805020, 0xecded0, 120, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, 11, 
            10, -1
        });
        npcs.add(new Class9_Sub3("Workman", "This person is working in the mine", "pickpocket", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Murphy", "The man in charge of the fishing trawler", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            137, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Echned Zekin", "An evil spirit of the underworld.", "", 50, 50, 50, 50, false, ai, 0, 0, 0, 0, 201, 243, 9, 9, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Donovan The Handyman", "It's the family odd jobs man", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Pierre The Dog Handler", "It's the guy who looks after the family guard dog", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Hobbes The Butler", "It's the family butler", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, 8, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Louisa The Cook", "It's the family cook", "", 0, 0, 3, 0, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            9, -1
        });
        npcs.add(new Class9_Sub3("Mary The Maid", "The family maid", "", 35, 25, 10, 30, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Stanford The Gardener", "It's the family Gardener", "", 10, 8, 7, 8, false, ai, 1, 2, 3, 0xccb366, 155, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, 71, 22, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He looks like he's in over his head here", "", 31, 30, 22, 31, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            159, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard Dog", "He doesn't seem pleased to see me", "", 45, 47, 49, 46, false, ai, 0, 0, 0, 0, 247, 188, 6, 10, 30));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Guard", "He tries to keep law and order around here", "", 10, 8, 7, 8, false, ai, 1, 2, 3, 0xccb366, 155, 230, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Man", "A thirsty looking man", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Anna Sinclair", "The first child of the late Lord Sinclair", "", 11, 8, 7, 11, false, ai, 1, 0xff0000, 65280, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Bob Sinclair", "The second child of the late Lord Sinclair", "", 11, 8, 7, 11, false, ai, 1, 0xff0000, 0xff0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Carol Sinclair", "The third child of the late Lord Sinclair", "", 11, 8, 7, 11, false, ai, 1, 255, 0xff0000, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("David Sinclair", "The fourth child of the late Lord Sinclair", "", 11, 8, 7, 11, false, ai, 1, 65280, 65280, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Elizabeth Sinclair", "The fifth child of the late Lord Sinclair", "", 11, 8, 7, 11, false, ai, 1, 65280, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Frank Sinclair", "The sixth child of the late Lord Sinclair", "", 11, 8, 7, 11, false, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, -1, -1, -1, 45, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kolodion", "He's a shape shifter", "", 72, 55, 65, 70, true, ai, 0xb04020, 0x602010, 0x602010, 0x997326, 212, 280, 6, 6, 5));
        ai = (new int[] {
            125, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kolodion", "He's a shape shifter", "", 47, 69, 78, 78, true, ai, 0, 0, 0, 0, 420, 404, 6, 6, 5));
        ai = (new int[] {
            210, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kolodion", "He's a shape shifter", "", 58, 28, 78, 23, true, ai, 0, 0, 0, 0, 270, 390, 12, 12, 5));
        ai = (new int[] {
            164, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kolodion", "He's a shape shifter", "", 105, 85, 107, 98, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            -1, -1, -1, 100, 50, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Irvig Senay", "The animated spirit of Irvig Senay", "", 125, 125, 125, 125, true, ai, 0xffc030, 0x805020, 0x805020, 0x997326, 120, 220, 6, 6, 5));
        ai = (new int[] {
            -1, -1, -1, 102, 52, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ranalph Devere", "The animated spirit of Ranalph Devere", "", 130, 130, 130, 130, true, ai, 0xffc030, 0x805020, 0x805020, 0x997326, 120, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Poison Salesman", "Peter Potter - Poison Purveyor", "", 9, 8, 5, 7, false, ai, 0xff0000, 2, 3, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            7, 1, 2, 97, 219, -1, 221, 220, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gujuo", "A tall charismatic looking guy who holds the chest key.", "", 60, 60, 60, 60, false, ai, 0, 0x906020, 0x906020, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, 108, -1, -1, -1, 46, -1, 
            -1, 65
        });
        npcs.add(new Class9_Sub3("Jungle Forester", "A woodsman who specialises in large and exotic timber", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 122, -1, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Ungadulu", "An ancient looking Shaman", "", 75, 75, 75, 75, true, ai, 0xc0c0c0, 0x6f5737, 0x6f5737, 0x6f5737, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, 180, -1, -1, 85, 86, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Justice", "A old wise man", "", 75, 75, 75, 75, false, ai, 0xff4000, 0x6f5737, 0x6f5737, 0x6f5737, 148, 224, 6, 6, 5));
        ai = (new int[] {
            138, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Death Wing", "A supernatural creature of the underworld", "", 80, 80, 80, 80, true, ai, 0, 0, 0, 0, 225, 195, 5, 3, 5));
        ai = (new int[] {
            164, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Nezikchened", "An ancient powerful Demon of the Underworld...", "", 175, 177, 160, 178, true, ai, 0, 0, 0, 0, 358, 341, 11, 11, 30));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Dwarf Cannon Engineer", "He's the head of black guard weapon development", "", 20, 17, 16, 20, false, ai, 0x705040, 0x303030, 0x303030, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, 63
        });
        npcs.add(new Class9_Sub3("Dwarf Commander", "He guards the mines", "", 20, 17, 16, 20, false, ai, 0x705040, 0x303030, 0x303030, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            -1, 1, 2, 122, -1, 77, 76, 81, 155, -1, 
            -1, 64
        });
        npcs.add(new Class9_Sub3("Viyeldi", "The spirit of a dead sorcerer", "", 80, 80, 80, 80, true, ai, 1, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Nurmof", "He sells pickaxes", "", 20, 17, 16, 20, false, ai, 0x705040, 0x907020, 0xcc6020, 0xecded0, 121, 176, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fatigue Expert", "He looks wide awake", "", 10, 10, 13, 8, false, ai, 0xffc030, 0x805020, 0x805020, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            222, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Karamja Wolf", "A hungry wolf", "", 61, 61, 61, 61, true, ai, 0, 0, 0, 0, 260, 198, 6, 10, 30));
        ai = (new int[] {
            5, 1, 2, -1, 180, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Jungle Savage", "A savage and fearless Jungle warrior", "", 100, 60, 90, 100, true, ai, 1, 0x906020, 0x906020, 0x705010, 145, 220, 6, 6, 5));
        ai = (new int[] {
            223, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Oomlie Bird", "A variety of flightless jungle fowl - it has a sharp beak and a bad temper.", "", 50, 20, 40, 20, true, ai, 0, 0, 0, 0, 70, 62, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Sidney Smith", "Sidney Smith - Certification clerk", "", 30, 30, 30, 30, false, ai, 0, 0xff00ff, 0xff80ff, 0x804000, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Siegfried Erkle", "An eccentric shop keeper - related to the Grand Vizier of the Legends Guild", "", 35, 25, 10, 30, false, ai, 0xffa350, 0xdd88aa, 3, 0xccb366, 145, 235, 6, 6, 5));
        ai = (new int[] {
            5, 1, 2, -1, -1, -1, -1, -1, -1, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Tea Seller", "He has delicious tea to buy", "", 11, 8, 7, 11, false, ai, 1, 2, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Wilough", "A young son of gertrudes", "", 0, 0, 3, 0, false, ai, 0xddcc78, 0xaacc78, 3, 0xecded0, 100, 120, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Philop", "Gertrudes youngest", "", 0, 0, 3, 0, false, ai, 0xddcc78, 0xaacc78, 3, 0xecded0, 80, 100, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Kanel", "Gertrudes youngest's twin brother", "", 0, 0, 3, 0, false, ai, 0xddcc78, 0xaacc78, 3, 0xecded0, 80, 100, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chamber Guardian", "He hasn't seen much sun latley", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 41, -1, 52, 74, 25, -1, -1, -1, 
            80, 68
        });
        npcs.add(new Class9_Sub3("Sir Radimus Erkle", "A huge muscular man in charge of the Legends Guild", "", 10, 20, 8, 5, false, ai, 0xffffff, 0xccb366, 0xccb366, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            143, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Pit Scorpion", "Very vicious little scorpions", "", 33, 30, 32, 48, true, ai, 0, 0, 0, 0, 121, 69, 7, 7, 45));
        ai = (new int[] {
            3, 1, 2, 53, -1, -1, 227, -1, -1, 226, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Shadow Warrior", "A sinsistar shadowy figure", "", 120, 65, 150, 150, true, ai, 1, 2, 3, 4, 145, 220, 6, 6, 5));
        ai = (new int[] {
            3, 4, 2, -1, -1, -1, -1, 186, -1, 207, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Fionella", "She runs the legend's general store", "", 35, 25, 10, 30, false, ai, 0xffa040, 0x30ffff, 3, 0xccb366, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 122, 192, -1, -1, -1, -1, 
            -1, 65
        });
        npcs.add(new Class9_Sub3("Battle Mage", "He kills in the name of guthix", "", 0, 90, 120, 0, true, ai, 1, 0x806020, 0x805020, 36864, 100, 150, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 209, -1, 82, 88, -1, -1, 
            -1, 62
        });
        npcs.add(new Class9_Sub3("Battle Mage", "He kills in the name of zamarok", "", 0, 90, 120, 0, true, ai, 1, 2, 3, 0xfffef0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, 218, -1, 85, 86, -1, -1, 
            -1, 64
        });
        npcs.add(new Class9_Sub3("Battle Mage", "He kills in the name of Saradomin", "", 0, 90, 120, 0, true, ai, 0x303030, 0xffcc30, 0xee3082, 0x906020, 145, 220, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Gundai", "He must get lonely out here", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            6, 1, 2, -1, -1, -1, -1, -1, 46, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lundail", "He sells rune stones", "", 15, 16, 12, 18, false, ai, 0xaa6640, 0x805020, 3, 0xccb366, 145, 230, 6, 6, 5));
        ai = (new int[] {
            230, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Baby Red Dragon", "Young but still dangerous", "", 60, 60, 60, 60, true, ai, 0, 0, 0, 0, 226, 163, 10, 7, 30));
        ai = (new int[] {
            165, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Baby Black Dragon", "Young but still dangerous", "", 90, 90, 90, 95, true, ai, 0, 0, 0, 0, 226, 163, 10, 7, 30));
        ai = (new int[] {
            6, 1, 2, -1, -1, 77, 76, 81, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Subscription Vendor", "He can subscribe your account in exchange for a Subscription Card", "", 20, 15, 3, 10, false, ai, 0xffffff, 255, 255, 0xecded0, 145, 220, 6, 6, 5));
        ai = (new int[] {
            123, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chaos Rat", "Eeep!", "", 400, 360, 5000, 50, true, ai, 0, 0, 0, 0, 115, 45, 7, 7, 10));
        ai = (new int[] {
            124, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Chaos Imp", "A tiny little minion, ready to crush your pixelated skull", "", 150, 170, 850, 150, true, ai, 0, 0, 0, 0, 74, 70, 11, 11, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, -1, -1, 46, 11, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Edward", "He runs an herblore exchange store", "", 20, 20, 20, 20, false, ai, 1, 52224, 0xeeee50, 0xccb366, 140, 215, 6, 6, 5));
        ai = (new int[] {
            0, 1, 2, -1, -1, -1, 45, -1, -1, -1, 
            -1, -1
        });
        npcs.add(new Class9_Sub3("Lucas", "He runs a fletching exchange store", "", 30, 30, 30, 30, false, ai, 0xffee99, 255, 0xdd6040, 0xecded0, 145, 220, 6, 6, 5));
    }

    public static void method254()
    {
        items.add(new Class9_Sub2("Iron Mace", "A spiky mace", "", 63, 0, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Iron Short Sword", "A razor sharp sword", "", 91, 1, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Iron Kite Shield", "A large metal shield", "", 238, 2, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Iron Square Shield", "A medium metal shield", "", 168, 3, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Wooden Shield", "A solid wooden shield", "", 20, 4, false, true, 0, false));
        items.add(new Class9_Sub2("Medium Iron Helmet", "A medium sized helmet", "", 84, 5, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Large Iron Helmet", "A full face helmet", "", 154, 6, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Iron Chain Mail Body", "A series of connected metal rings", "", 210, 7, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Iron Plate Mail Body", "Provides excellent protection", "", 560, 8, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Iron Plate Mail Legs", "These look pretty heavy", "", 280, 9, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Coins", "Lovely money!", "", 1, 10, true, false, 0, false));
        items.add(new Class9_Sub2("Bronze Arrows", "Arrows with bronze heads", "", 2, 11, true, false, 0xff6619, false));
        items.add(new Class9_Sub2("Iron Axe", "A woodcutters axe", "", 56, 12, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Knife", "A dangerous looking knife", "", 6, 13, false, false, 0, false));
        items.add(new Class9_Sub2("Logs", "A number of wooden logs", "", 4, 14, false, false, 0, false));
        items.add(new Class9_Sub2("Leather Armour", "Better than no armour!", "", 21, 15, false, true, 0, false));
        items.add(new Class9_Sub2("Leather Gloves", "These will keep my hands warm!", "", 6, 17, false, true, 0, false));
        items.add(new Class9_Sub2("Boots", "Comfortable leather boots", "", 6, 16, false, true, 0, false));
        items.add(new Class9_Sub2("Cabbage", "Yuck I don't like cabbage", "Eat", 1, 18, false, false, 0, false));
        items.add(new Class9_Sub2("Egg", "A nice fresh egg", "", 4, 19, false, false, 0, false));
        items.add(new Class9_Sub2("Bones", "Ew it's a pile of bones", "Bury", 1, 20, false, false, 0, false));
        items.add(new Class9_Sub2("Bucket", "It's a wooden bucket", "", 2, 22, false, false, 0x101010, false));
        items.add(new Class9_Sub2("Milk", "It's a bucket of milk", "", 6, 22, false, false, 0, false));
        items.add(new Class9_Sub2("Flour", "A little heap of flour", "", 2, 23, false, false, 0, false));
        items.add(new Class9_Sub2("Amulet of GhostSpeak", "It lets me talk to ghosts", "", 35, 24, false, true, 0, true));
        items.add(new Class9_Sub2("Silverlight Key 1", "A key given to me by Wizard Traiborn", "", 1, 25, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Silverlight Key 2", "A key given to me by Captain Rovin", "", 1, 25, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Skull", "A spooky looking skull", "", 1, 26, false, false, 0, true));
        items.add(new Class9_Sub2("Iron Dagger", "Short but pointy", "", 35, 80, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Grain", "Some wheat heads", "", 2, 27, false, false, 0, false));
        items.add(new Class9_Sub2("Book", "", "read", 1, 28, false, false, 0xffaaaa, true));
        items.add(new Class9_Sub2("Fire-Rune", "One of the 4 basic elemental runes", "", 4, 30, true, false, 0, false));
        items.add(new Class9_Sub2("Water-Rune", "One of the 4 basic elemental runes", "", 4, 31, true, false, 0, false));
        items.add(new Class9_Sub2("Air-Rune", "One of the 4 basic elemental runes", "", 4, 32, true, false, 0, false));
        items.add(new Class9_Sub2("Earth-Rune", "One of the 4 basic elemental runes", "", 4, 33, true, false, 0, false));
        items.add(new Class9_Sub2("Mind-Rune", "Used for low level missile spells", "", 3, 34, true, false, 0, false));
        items.add(new Class9_Sub2("Body-Rune", "Used for curse spells", "", 3, 35, true, false, 0, false));
        items.add(new Class9_Sub2("Life-Rune", "Used for summon spells", "", 1, 36, true, false, 0, false));
        items.add(new Class9_Sub2("Death-Rune", "Used for high level missile spells", "", 500, 37, true, false, 0, false));
        items.add(new Class9_Sub2("Needle", "Used with a thread to make clothes", "", 1, 38, true, false, 0, false));
        items.add(new Class9_Sub2("Nature-Rune", "Used for alchemy spells", "", 7, 39, true, false, 0, false));
        items.add(new Class9_Sub2("Chaos-Rune", "Used for mid level missile spells", "", 250, 40, true, false, 0, false));
        items.add(new Class9_Sub2("Law-Rune", "Used for teleport spells", "", 12, 41, true, false, 0, false));
        items.add(new Class9_Sub2("Thread", "Used with a needle to make clothes", "", 1, 42, true, false, 0, false));
        items.add(new Class9_Sub2("Holy Symbol of Saradomin", "This needs a string putting on it", "", 200, 43, false, false, 0, false));
        items.add(new Class9_Sub2("Unblessed Holy Symbol", "This needs blessing", "", 200, 44, false, true, 0, false));
        items.add(new Class9_Sub2("Cosmic-Rune", "Used for enchant spells", "", 15, 45, true, false, 0, false));
        items.add(new Class9_Sub2("Key", "The key to get into the phoenix gang", "", 1, 25, false, false, 0xee9900, true));
        items.add(new Class9_Sub2("Key", "The key to the phoenix gang's weapons store", "", 1, 25, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Scroll", "An intelligence Report", "", 5, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Water", "It's a bucket of water", "", 6, 22, false, false, 0x5757f1, false));
        items.add(new Class9_Sub2("Silverlight Key 3", "A key I found in a drain", "", 1, 25, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Silverlight", "A magic sword", "", 50, 81, false, true, 0, false));
        items.add(new Class9_Sub2("Broken Shield", "Half of the shield of Arrav", "", 1, 46, false, false, 0, false));
        items.add(new Class9_Sub2("Broken Shield", "Half of the shield of Arrav", "", 1, 47, false, false, 0, false));
        items.add(new Class9_Sub2("Cadavaberries", "Poisonous berries", "", 1, 21, false, false, 0xe757b1, false));
        items.add(new Class9_Sub2("Message", "A message from Juliet to Romeo", "", 1, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Cadava", "I'm meant to give this to Juliet", "", 1, 48, false, false, 0xb15072, true));
        items.add(new Class9_Sub2("Potion", "this is meant to be good for spots", "", 1, 48, false, false, 0x50b671, false));
        items.add(new Class9_Sub2("Phoenix Crossbow", "Former property of the phoenix gang", "", 4, 49, false, true, 0, false));
        items.add(new Class9_Sub2("Crossbow", "This fires crossbow bolts", "", 70, 49, false, true, 0, false));
        items.add(new Class9_Sub2("Certificate", "I can use this to claim a reward from the king", "", 1, 29, false, false, 0, false));
        items.add(new Class9_Sub2("bronze Dagger", "Short but pointy", "", 10, 80, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Dagger", "Short but pointy", "", 125, 80, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Dagger", "Short but pointy", "", 325, 80, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Dagger", "Short but pointy", "", 800, 80, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Bronze Short Sword", "A razor sharp sword", "", 26, 1, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Short Sword", "A razor sharp sword", "", 400, 1, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Short Sword", "A razor sharp sword", "", 845, 1, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Short Sword", "A razor sharp sword", "", 2080, 1, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Bronze Long Sword", "A razor sharp sword", "", 40, 81, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Iron Long Sword", "A razor sharp sword", "", 140, 81, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Long Sword", "A razor sharp sword", "", 600, 81, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Long Sword", "A razor sharp sword", "", 1600, 81, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Long Sword", "A razor sharp sword", "", 3400, 81, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Long Sword", "A razor sharp sword", "", 32000, 81, false, true, 65535, false));
        items.add(new Class9_Sub2("Bronze 2-Handed Sword", "A very large sword", "", 150, 82, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Iron 2-Handed Sword", "A very large sword", "", 380, 82, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel 2-Handed Sword", "A very large sword", "", 1000, 82, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril 2-Handed Sword", "A very large sword", "", 4200, 82, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite 2-Handed Sword", "A very large sword", "", 6400, 82, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune 2-Handed Sword", "A very large sword", "", 0x186a0, 82, false, true, 65535, false));
        items.add(new Class9_Sub2("Bronze Scimitar", "A vicious curved sword", "", 32, 83, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Iron Scimitar", "A vicious curved sword", "", 112, 83, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Scimitar", "A vicious curved sword", "", 600, 83, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Scimitar", "A vicious curved sword", "", 1600, 83, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Scimitar", "A vicious curved sword", "", 3000, 83, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("bronze Axe", "A woodcutters axe", "", 16, 12, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Axe", "A woodcutters axe", "", 600, 12, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Iron Battle Axe", "A vicious looking axe", "", 182, 84, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Battle Axe", "A vicious looking axe", "", 650, 84, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Battle Axe", "A vicious looking axe", "", 2400, 84, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Battle Axe", "A vicious looking axe", "", 5200, 84, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Battle Axe", "A vicious looking axe", "", 41600, 84, false, true, 65535, false));
        items.add(new Class9_Sub2("Bronze Mace", "A spiky mace", "", 18, 0, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Mace", "A spiky mace", "", 225, 0, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Mace", "A spiky mace", "", 585, 0, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Mace", "A spiky mace", "", 1440, 0, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Mace", "A spiky mace", "", 14400, 0, false, true, 65535, false));
        items.add(new Class9_Sub2("Brass Key", "I wonder what this is the key to", "", 1, 25, false, false, 0xff9900, false));
        items.add(new Class9_Sub2("Staff", "It's a slightly magical stick", "", 15, 85, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Staff of Air", "A Magical staff", "", 1500, 91, false, true, 65535, false));
        items.add(new Class9_Sub2("Staff of Water", "A Magical staff", "", 1500, 91, false, true, 255, false));
        items.add(new Class9_Sub2("Staff of Earth", "A Magical staff", "", 1500, 91, false, true, 0x703500, false));
        items.add(new Class9_Sub2("Medium Bronze Helmet", "A medium sized helmet", "", 24, 5, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Medium Steel Helmet", "A medium sized helmet", "", 300, 5, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Medium Mithril Helmet", "A medium sized helmet", "", 780, 5, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Medium Adamantite Helmet", "A medium sized helmet", "", 1920, 5, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Large Bronze Helmet", "A full face helmet", "", 44, 6, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Large Steel Helmet", "A full face helmet", "", 550, 6, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Large Mithril Helmet", "A full face helmet", "", 1430, 6, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Large Adamantite Helmet", "A full face helmet", "", 3520, 6, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Large Rune Helmet", "A full face helmet", "", 35200, 6, false, true, 65535, false));
        items.add(new Class9_Sub2("Bronze Chain Mail Body", "A series of connected metal rings", "", 60, 7, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Chain Mail Body", "A series of connected metal rings", "", 750, 7, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Chain Mail Body", "A series of connected metal rings", "", 1950, 7, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Chain Mail Body", "A series of connected metal rings", "", 4800, 7, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Bronze Plate Mail Body", "Provides excellent protection", "", 160, 8, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Plate Mail Body", "Provides excellent protection", "", 2000, 8, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Plate Mail Body", "Provides excellent protection", "", 5200, 8, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Plate Mail Body", "Provides excellent protection", "", 12800, 8, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Steel Plate Mail Legs", "These look pretty heavy", "", 1000, 9, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Plate Mail Legs", "These look pretty heavy", "", 2600, 9, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Plate Mail Legs", "These look pretty heavy", "", 6400, 9, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Bronze Square Shield", "A medium metal shield", "", 48, 3, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Square Shield", "A medium metal shield", "", 600, 3, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Square Shield", "A medium metal shield", "", 1560, 3, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Square Shield", "A medium metal shield", "", 3840, 3, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Bronze Kite Shield", "A large metal shield", "", 68, 2, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Kite Shield", "A large metal shield", "", 850, 2, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Kite Shield", "A large metal shield", "", 2210, 2, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Kite Shield", "A large metal shield", "", 5440, 2, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Cooked Meat", "Mmm this looks tasty", "Eat", 4, 60, false, false, 0xcc6633, false));
        items.add(new Class9_Sub2("Raw Chicken", "I need to cook this first", "", 1, 60, false, false, 0xff8c33, false));
        items.add(new Class9_Sub2("Burnt Meat", "Oh dear", "", 1, 60, false, false, 0x4c4c4c, false));
        items.add(new Class9_Sub2("Pot", "This pot is empty", "", 1, 61, false, false, 0xff9155, false));
        items.add(new Class9_Sub2("Flour", "There is flour in this pot", "", 10, 62, false, false, 0, false));
        items.add(new Class9_Sub2("Bread Dough", "Some uncooked dough", "", 1, 63, false, false, 0, false));
        items.add(new Class9_Sub2("Bread", "Nice crispy bread", "Eat", 12, 64, false, false, 0xff6c33, false));
        items.add(new Class9_Sub2("Burnt Bread", "This bread is ruined!", "", 1, 64, false, false, 0x4c4c4c, false));
        items.add(new Class9_Sub2("Jug", "This jug is empty", "", 1, 65, false, false, 0x10140, false));
        items.add(new Class9_Sub2("Water", "It's full of water", "", 1, 65, false, false, 0xc0c0ff, false));
        items.add(new Class9_Sub2("Wine", "It's full of wine", "Drink", 1, 65, false, false, 0xc41818, false));
        items.add(new Class9_Sub2("Grapes", "Good grapes for wine making", "", 1, 21, false, false, 0x8f3bd7, false));
        items.add(new Class9_Sub2("Shears", "For shearing sheep", "", 1, 66, false, false, 0, false));
        items.add(new Class9_Sub2("Wool", "I think this came from a sheep", "", 1, 67, false, false, 0, false));
        items.add(new Class9_Sub2("Fur", "This would make warm clothing", "", 10, 68, false, false, 0xbb8216, false));
        items.add(new Class9_Sub2("Cow Hide", "I should take this to the tannery", "", 1, 69, false, false, 0, false));
        items.add(new Class9_Sub2("Leather", "It's a piece of leather", "", 1, 69, false, false, 0xffb233, false));
        items.add(new Class9_Sub2("Clay", "Some hard dry clay", "", 1, 70, false, false, 0xe59919, false));
        items.add(new Class9_Sub2("Copper Ore", "this needs refining", "", 3, 70, false, false, 0xff6619, false));
        items.add(new Class9_Sub2("Iron Ore", "this needs refining", "", 17, 70, false, false, 0xb29999, false));
        items.add(new Class9_Sub2("Gold", "this needs refining", "", 150, 73, false, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Mithril Ore", "this needs refining", "", 162, 70, false, false, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Ore", "this needs refining", "", 400, 70, false, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Coal", "hmm a non-renewable energy source!", "", 45, 71, false, false, 0, false));
        items.add(new Class9_Sub2("Bronze Pickaxe", "Used for mining", "", 1, 72, false, false, 0xff6619, false));
        items.add(new Class9_Sub2("Uncut Diamond", "this would be worth more cut", "", 200, 73, false, false, 0, false));
        items.add(new Class9_Sub2("Uncut Ruby", "this would be worth more cut", "", 100, 73, false, false, 0xff3300, false));
        items.add(new Class9_Sub2("Uncut Emerald", "this would be worth more cut", "", 50, 73, false, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Uncut Sapphire", "this would be worth more cut", "", 25, 73, false, false, 19711, false));
        items.add(new Class9_Sub2("Diamond", "this looks valuable", "", 2000, 74, false, false, 0, false));
        items.add(new Class9_Sub2("Ruby", "this looks valuable", "", 1000, 74, false, false, 0xff3300, false));
        items.add(new Class9_Sub2("Emerald", "this looks valuable", "", 500, 74, false, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Sapphire", "this looks valuable", "", 250, 74, false, false, 19711, false));
        items.add(new Class9_Sub2("Muddy Guam", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Tinderbox", "useful for lighting a fire", "", 1, 76, false, false, 0, false));
        items.add(new Class9_Sub2("Chisel", "good for detailed crafting", "", 1, 77, false, false, 0, false));
        items.add(new Class9_Sub2("Hammer", "good for hitting things!", "", 1, 78, false, false, 0, false));
        items.add(new Class9_Sub2("Bronze Bar", "it's a bar of bronze", "", 8, 79, false, false, 0xff6619, false));
        items.add(new Class9_Sub2("Iron Bar", "it's a bar of iron", "", 28, 79, false, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Bar", "it's a bar of steel", "", 100, 79, false, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Gold Bar", "this looks valuable", "", 300, 79, false, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Mithril Bar", "it's a bar of mithril", "", 300, 79, false, false, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Bar", "it's a bar of adamantite", "", 640, 79, false, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Pressure Gauge", "It looks like part of a machine", "", 1, 50, false, false, 0, true));
        items.add(new Class9_Sub2("Fish Food", "Keeps  your pet fish strong and healthy", "", 1, 51, false, false, 0, false));
        items.add(new Class9_Sub2("Poison", "This stuff looks nasty", "", 1, 52, false, false, 0, false));
        items.add(new Class9_Sub2("Poisoned Fish Food", "Doesn't seem very nice to the poor fishes", "", 1, 51, false, false, 0, true));
        items.add(new Class9_Sub2("Spinach Roll", "A home made spinach thing", "", 1, 53, false, false, 0, false));
        items.add(new Class9_Sub2("Bad Wine", "Oh dear", "Drink", 1, 65, false, false, 0xc41818, false));
        items.add(new Class9_Sub2("Ashes", "A heap of ashes", "", 2, 23, false, false, 0xaaaaaa, false));
        items.add(new Class9_Sub2("Apron", "A mostly clean apron", "", 2, 58, false, true, 0, false));
        items.add(new Class9_Sub2("Cape", "A bright red cape", "", 2, 59, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Wizards Robe", "I can do magic better in this", "", 500, 87, false, true, 255, false));
        items.add(new Class9_Sub2("Wizardshat", "A silly pointed hat", "", 200, 86, false, true, 255, false));
        items.add(new Class9_Sub2("Brass Necklace", "I'd prefer a gold one", "", 30, 438, false, true, 0, false));
        items.add(new Class9_Sub2("Skirt", "A ladies skirt", "", 500, 88, false, true, 255, false));
        items.add(new Class9_Sub2("Longbow", "A Nice sturdy bow", "", 80, 54, false, true, 65280, false));
        items.add(new Class9_Sub2("Shortbow", "Short but effective", "", 50, 55, false, true, 65280, false));
        items.add(new Class9_Sub2("Crossbow Bolts", "Good if you have a crossbow!", "", 3, 56, true, false, 0, false));
        items.add(new Class9_Sub2("Apron", "this will help keep my clothes clean", "", 2, 58, false, true, 0x956030, false));
        items.add(new Class9_Sub2("Chef's Hat", "What a silly hat", "", 2, 89, false, true, 0, false));
        items.add(new Class9_Sub2("Beer", "A glass of frothy ale", "drink", 2, 90, false, false, 0, false));
        items.add(new Class9_Sub2("Skirt", "A ladies skirt", "", 500, 88, false, true, 0xf4b3f3, false));
        items.add(new Class9_Sub2("Skirt", "A ladies skirt", "", 500, 88, false, true, 0x404040, false));
        items.add(new Class9_Sub2("Black Plate Mail Body", "Provides excellent protection", "", 3840, 8, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Staff of Fire", "A Magical staff", "", 1500, 91, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Magic Staff", "A Magical staff", "", 200, 91, false, true, 0xffffff, false));
        items.add(new Class9_Sub2("Wizardshat", "A silly pointed hat", "", 200, 86, false, true, 0x404040, false));
        items.add(new Class9_Sub2("Silk", "It's a sheet of silk", "", 30, 92, false, false, 0xff30cc, false));
        items.add(new Class9_Sub2("Flier", "Get your axes from Bob's axes", "", 1, 29, false, false, 0, false));
        items.add(new Class9_Sub2("Tin Ore", "this needs refining", "", 3, 70, false, false, 0xd2b9b9, false));
        items.add(new Class9_Sub2("Mithril Axe", "A powerful axe", "", 520, 12, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Axe", "A powerful axe", "", 1280, 12, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Bronze Battle Axe", "A vicious looking axe", "", 52, 84, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Bronze Plate Mail Legs", "These look pretty heavy", "", 80, 9, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Ball of Wool", "Spun from sheeps wool", "", 2, 93, false, false, 0, false));
        items.add(new Class9_Sub2("Oil Can", "Its pretty full", "", 3, 94, false, false, 0, true));
        items.add(new Class9_Sub2("Cape", "A warm black cape", "", 7, 59, false, true, 0x252525, false));
        items.add(new Class9_Sub2("Kebab", "A meaty Kebab", "eat", 3, 95, false, false, 0, false));
        items.add(new Class9_Sub2("Spade", "A fairly small spade", "Dig", 3, 96, false, false, 0, false));
        items.add(new Class9_Sub2("Closet Key", "A slightly smelly key", "", 1, 25, false, false, 0xffee00, false));
        items.add(new Class9_Sub2("Rubber Tube", "Its slightly charred", "", 3, 97, false, false, 0, true));
        items.add(new Class9_Sub2("Bronze Plated Skirt", "Designer leg protection", "", 80, 88, false, true, 0x803019, false));
        items.add(new Class9_Sub2("Iron Plated Skirt", "Designer leg protection", "", 280, 88, false, true, 0x776666, false));
        items.add(new Class9_Sub2("Black Robe", "I can do magic better in this", "", 500, 87, false, true, 0x404040, false));
        items.add(new Class9_Sub2("Stake", "A very pointy stick", "", 8, 98, false, true, 0xff6619, true));
        items.add(new Class9_Sub2("Garlic", "A clove of garlic", "", 3, 99, false, false, 0, false));
        items.add(new Class9_Sub2("Red Spiders Eggs", "eewww", "", 7, 100, false, false, 0, false));
        items.add(new Class9_Sub2("Limpwurt Root", "the root of a limpwurt plant", "", 7, 101, false, false, 0, false));
        items.add(new Class9_Sub2("Strength Potion", "4 doses of strength potion", "Drink", 5000, 48, false, false, 0xeeee30, false));
        items.add(new Class9_Sub2("Strength Potion", "3 doses of strength potion", "Drink", 4000, 48, false, false, 0xeeee30, false));
        items.add(new Class9_Sub2("Strength Potion", "2 doses of strength potion", "Drink", 3000, 436, false, false, 0xeeee30, false));
        items.add(new Class9_Sub2("Strength Potion", "1 dose of strength potion", "Drink", 2000, 437, false, false, 0xeeee30, false));
        items.add(new Class9_Sub2("Steel Plated Skirt", "designer leg protection", "", 1000, 88, false, true, 0x777777, false));
        items.add(new Class9_Sub2("Mithril Plated Skirt", "Designer Leg protection", "", 2600, 88, false, true, 0x224255, false));
        items.add(new Class9_Sub2("Adamantite Plated Skirt", "Designer leg protection", "", 6400, 88, false, true, 0x425522, false));
        items.add(new Class9_Sub2("Cabbage", "Yuck I don't like cabbage", "Eat", 1, 18, false, false, 0, false));
        items.add(new Class9_Sub2("Cape", "A thick Blue Cape", "", 32, 59, false, true, 0x4040ee, false));
        items.add(new Class9_Sub2("Large Black Helmet", "A full face helmet", "", 1056, 6, false, true, 0x404040, false));
        items.add(new Class9_Sub2("Red Bead", "A small round red bead", "", 4, 102, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Yellow Bead", "A small round yellow bead", "", 4, 102, false, false, 0xffff00, false));
        items.add(new Class9_Sub2("Black Bead", "A small round black bead", "", 4, 102, false, false, 0x404040, false));
        items.add(new Class9_Sub2("White Bead", "A small round white bead", "", 4, 102, false, false, 0xffffff, false));
        items.add(new Class9_Sub2("Amulet of Accuracy", "It increases my aim", "", 100, 24, false, true, 0, false));
        items.add(new Class9_Sub2("Redberries", "Very bright red berries", "", 3, 21, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Rope", "A Coil of rope", "", 18, 103, false, false, 0, false));
        items.add(new Class9_Sub2("Reddye", "A little bottle of dye", "", 5, 104, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Yellowdye", "A little bottle of dye", "", 5, 104, false, false, 0xffff00, false));
        items.add(new Class9_Sub2("Paste", "A bottle off skin coloured paste", "", 5, 104, false, false, 0xecdcc0, true));
        items.add(new Class9_Sub2("Onion", "A strong smelling onion", "", 3, 99, false, false, 0xeeaa66, false));
        items.add(new Class9_Sub2("Bronze Key", "A heavy key", "", 1, 25, false, false, 0xff6619, true));
        items.add(new Class9_Sub2("Soft Clay", "Clay that's ready to be used", "", 2, 105, false, false, 0, false));
        items.add(new Class9_Sub2("Wig", "A blonde wig", "", 2, 106, false, false, 0xffcc58, true));
        items.add(new Class9_Sub2("Wig", "A wig made from wool", "", 2, 106, false, false, 0, true));
        items.add(new Class9_Sub2("Half Full Wine Jug", "It's half full of wine", "Drink", 1, 65, false, false, 0xc41818, false));
        items.add(new Class9_Sub2("Keyprint", "An imprint of a key in a lump of clay", "", 2, 107, false, false, 0, true));
        items.add(new Class9_Sub2("Black Plate Mail Legs", "These look pretty heavy", "", 1920, 9, false, true, 0x404040, false));
        items.add(new Class9_Sub2("Banana", "Mmm this looks tasty", "Eat", 2, 108, false, false, 0, false));
        items.add(new Class9_Sub2("Pastry Dough", "Some uncooked dough", "", 1, 63, false, false, 0, false));
        items.add(new Class9_Sub2("Pie Dish", "For making pies in", "", 3, 110, false, false, 0xee8f55, false));
        items.add(new Class9_Sub2("Cooking Apple", "I wonder what i can make with this", "", 1, 109, false, false, 0, false));
        items.add(new Class9_Sub2("Pie Shell", "I need to find a filling for this pie", "", 1, 111, false, false, 0, false));
        items.add(new Class9_Sub2("Uncooked Apple Pie", "I need to cook this first", "", 1, 112, false, false, 0xfdceae, false));
        items.add(new Class9_Sub2("Uncooked Meat Pie", "I need to cook this first", "", 1, 112, false, false, 0xfdceae, false));
        items.add(new Class9_Sub2("Uncooked Redberry Pie", "I need to cook this first", "", 1, 112, false, false, 0xfdceae, false));
        items.add(new Class9_Sub2("Apple Pie", "Mmm Apple pie", "eat", 30, 112, false, false, 0xaa6c33, false));
        items.add(new Class9_Sub2("Redberry Pie", "Looks tasty", "eat", 12, 112, false, false, 0xaa6c33, false));
        items.add(new Class9_Sub2("Meat Pie", "Mighty and meaty", "eat", 15, 112, false, false, 0xaa6c33, false));
        items.add(new Class9_Sub2("Burntpie", "Oops", "empty dish", 1, 112, false, false, 0x4c4c4c, false));
        items.add(new Class9_Sub2("Half a Meat Pie", "Mighty and meaty", "eat", 10, 113, false, false, 0xaa6c33, false));
        items.add(new Class9_Sub2("Half a Redberry Pie", "Looks tasty", "eat", 4, 113, false, false, 0xaa6c33, false));
        items.add(new Class9_Sub2("Half an Apple Pie", "Mmm Apple pie", "eat", 5, 113, false, false, 0xaa6c33, false));
        items.add(new Class9_Sub2("Portrait", "It's a picture of a knight", "", 3, 114, false, false, 0, true));
        items.add(new Class9_Sub2("Faladian Knight's Sword", "A razor sharp sword", "", 200, 115, false, true, 0xeedddd, true));
        items.add(new Class9_Sub2("Blurite Ore", "What Strange stuff", "", 3, 70, false, false, 0x5050ee, true));
        items.add(new Class9_Sub2("Asgarnian Ale", "A glass of frothy ale", "drink", 2, 90, false, false, 0, false));
        items.add(new Class9_Sub2("Wizard's Mind Bomb", "It's got strange bubbles in it", "drink", 2, 90, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarven Stout", "A Pint of thick dark beer", "drink", 2, 90, false, false, 0, false));
        items.add(new Class9_Sub2("Eye of Newt", "It seems to be looking at me", "", 3, 116, false, false, 0, false));
        items.add(new Class9_Sub2("Rat's Tail", "A bit of rat", "", 3, 117, false, false, 0, true));
        items.add(new Class9_Sub2("Bluedye", "A little bottle of dye", "", 5, 104, false, false, 255, false));
        items.add(new Class9_Sub2("Goblin Armour", "Armour Designed to fit Goblins", "", 40, 118, false, false, 65535, true));
        items.add(new Class9_Sub2("Goblin Armour", "Armour Designed to fit Goblins", "", 40, 118, false, false, 0xff9940, true));
        items.add(new Class9_Sub2("Goblin Armour", "Armour Designed to fit Goblins", "", 40, 118, false, false, 255, true));
        items.add(new Class9_Sub2("Unstrung Longbow", "I need to find a string for this", "", 60, 119, false, false, 65280, false));
        items.add(new Class9_Sub2("Unstrung Shortbow", "I need to find a string for this", "", 23, 120, false, false, 65280, false));
        items.add(new Class9_Sub2("Unfired Pie Dish", "I need to put this in a pottery oven", "", 3, 110, false, false, 0xee8877, false));
        items.add(new Class9_Sub2("Unfired Pot", "I need to put this in a pottery oven", "", 1, 61, false, false, 0xee8877, false));
        items.add(new Class9_Sub2("Arrow Shafts", "I need to attach feathers to these", "", 1, 121, true, false, 0, false));
        items.add(new Class9_Sub2("Woad Leaf", "slightly bluish leaves", "", 1, 122, true, false, 0, false));
        items.add(new Class9_Sub2("Orangedye", "A little bottle of dye", "", 5, 104, false, false, 0xffaa00, false));
        items.add(new Class9_Sub2("Gold Ring", "A valuable ring", "", 350, 123, false, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Sapphire Ring", "A valuable ring", "", 900, 123, false, false, 19711, false));
        items.add(new Class9_Sub2("Emerald Ring", "A valuable ring", "", 1275, 123, false, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Ruby Ring", "A valuable ring", "", 2025, 123, false, false, 0xff3300, false));
        items.add(new Class9_Sub2("Diamond Ring", "A valuable ring", "", 3525, 123, false, false, 0, false));
        items.add(new Class9_Sub2("Gold Necklace", "I wonder if this is valuable", "", 450, 57, false, true, 0xffcc4c, false));
        items.add(new Class9_Sub2("Sapphire Necklace", "I wonder if this is valuable", "", 1050, 57, false, true, 19711, false));
        items.add(new Class9_Sub2("Emerald Necklace", "I wonder if this is valuable", "", 1425, 57, false, true, 0x33cc33, false));
        items.add(new Class9_Sub2("Ruby Necklace", "I wonder if this is valuable", "", 2175, 57, false, true, 0xff3300, false));
        items.add(new Class9_Sub2("Diamond Necklace", "I wonder if this is valuable", "", 3675, 57, false, true, 0, false));
        items.add(new Class9_Sub2("Ring Mould", "Used to make gold rings", "", 5, 127, false, false, 0, false));
        items.add(new Class9_Sub2("Amulet Mould", "Used to make gold amulets", "", 5, 128, false, false, 0, false));
        items.add(new Class9_Sub2("Necklace mould", "Used to make gold necklaces", "", 5, 129, false, false, 0, false));
        items.add(new Class9_Sub2("Gold Amulet", "It needs a string so I can wear it", "", 350, 126, false, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Sapphire Amulet", "It needs a string so I can wear it", "", 900, 126, false, false, 19711, false));
        items.add(new Class9_Sub2("Emerald Amulet", "It needs a string so I can wear it", "", 1275, 126, false, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Ruby Amulet", "It needs a string so I can make wear it", "", 2025, 126, false, false, 0xff3300, false));
        items.add(new Class9_Sub2("Diamond Amulet", "It needs a string so I can wear it", "", 3525, 126, false, false, 0, false));
        items.add(new Class9_Sub2("Gold Amulet", "I wonder if I can get this enchanted", "", 350, 125, false, true, 0xffcc4c, false));
        items.add(new Class9_Sub2("Sapphire Amulet", "I wonder if I can get this enchanted", "", 900, 125, false, true, 19711, false));
        items.add(new Class9_Sub2("Emerald Amulet", "I wonder if I can get this enchanted", "", 1275, 125, false, true, 0x33cc33, false));
        items.add(new Class9_Sub2("Ruby Amulet", "I wonder if I can get this enchanted", "", 2025, 125, false, true, 0xff3300, false));
        items.add(new Class9_Sub2("Diamond Amulet", "I wonder if I can get this enchanted", "", 3525, 125, false, true, 0, false));
        items.add(new Class9_Sub2("Superchisel", "I wonder if I can get this enchanted", "twiddle", 3525, 126, false, false, 0, false));
        items.add(new Class9_Sub2("Mace of Zamorak", "This mace gives me the creeps", "", 4500, 0, false, true, 0xcc99b2, false));
        items.add(new Class9_Sub2("Bronze Plate Mail Top", "Armour designed for females", "", 160, 130, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Plate Mail Top", "Armour designed for females", "", 2000, 130, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Plate Mail Top", "Armour designed for females", "", 5200, 130, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Plate Mail Top", "Armour designed for females", "", 12800, 130, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Iron Plate Mail Top", "Armour designed for females", "", 560, 130, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Black Plate Mail Top", "Armour designed for females", "", 3840, 130, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Sapphire Amulet of Magic", "It improves my magic", "", 900, 125, false, true, 19711, false));
        items.add(new Class9_Sub2("Emerald Amulet of Protection", "It improves my defense", "", 1275, 125, false, true, 0x33cc33, false));
        items.add(new Class9_Sub2("Ruby Amulet of Strength", "It improves my damage", "", 5000, 125, false, true, 0xff3300, false));
        items.add(new Class9_Sub2("Diamond Amulet of Power", "A powerful amulet", "", 3525, 125, false, true, 0, false));
        items.add(new Class9_Sub2("Karamja Rum", "A very strong spirit brewed in Karamja", "", 30, 131, false, false, 0, true));
        items.add(new Class9_Sub2("Cheese", "It's got holes in it", "Eat", 4, 150, false, false, 0, false));
        items.add(new Class9_Sub2("Tomato", "This would make good ketchup", "Eat", 4, 151, false, false, 0, false));
        items.add(new Class9_Sub2("Pizza Base", "I need to add some tomato next", "", 4, 152, false, false, 0xffdcb8, false));
        items.add(new Class9_Sub2("Burnt Pizza", "Oh dear!", "", 1, 152, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Incomplete Pizza", "I need to add some cheese next", "", 10, 153, false, false, 0, false));
        items.add(new Class9_Sub2("Uncooked Pizza", "This needs cooking", "", 25, 154, false, false, 0, false));
        items.add(new Class9_Sub2("Plain Pizza", "A cheese and tomato pizza", "Eat", 40, 154, false, false, 0, false));
        items.add(new Class9_Sub2("Meat Pizza", "A pizza with bits of meat on it", "Eat", 50, 155, false, false, 0xffae5c, false));
        items.add(new Class9_Sub2("Anchovie Pizza", "A Pizza with Anchovies", "Eat", 60, 155, false, false, 0xaeaeae, false));
        items.add(new Class9_Sub2("Half Meat Pizza", "Half of this pizza has been eaten", "Eat", 25, 156, false, false, 0xffae5c, false));
        items.add(new Class9_Sub2("Half Anchovie Pizza", "Half of this pizza has been eaten", "Eat", 30, 156, false, false, 0xaeaeae, false));
        items.add(new Class9_Sub2("Cake", "A plain sponge cake", "Eat", 50, 157, false, false, 0xffc999, false));
        items.add(new Class9_Sub2("Burnt Cake", "Argh what a mess!", "", 1, 157, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Chocolate Cake", "This looks very tasty!", "Eat", 70, 157, false, false, 0xff804c, false));
        items.add(new Class9_Sub2("Partial Cake", "Someone has eaten a big chunk of this cake", "Eat", 30, 158, false, false, 0xffc999, false));
        items.add(new Class9_Sub2("Partial Chocolate Cake", "Someone has eaten a big chunk of this cake", "Eat", 50, 158, false, false, 0xff804c, false));
        items.add(new Class9_Sub2("Slice of Cake", "I'd rather have a whole cake!", "Eat", 10, 159, false, false, 0xffc999, false));
        items.add(new Class9_Sub2("Chocolate Slice", "A slice of chocolate cake", "Eat", 30, 159, false, false, 0xff804c, false));
        items.add(new Class9_Sub2("Chocolate Bar", "It's a bar of chocolate", "Eat", 10, 160, false, false, 0, false));
        items.add(new Class9_Sub2("Cake Tin", "Useful for baking cakes", "", 10, 177, false, false, 0, false));
        items.add(new Class9_Sub2("Uncooked Cake", "Now all I need to do is cook it", "", 20, 178, false, false, 0xffe0e0, false));
        items.add(new Class9_Sub2("Unfired Bowl", "I need to put this in a pottery oven", "", 2, 161, false, false, 0xee8877, false));
        items.add(new Class9_Sub2("Bowl", "Useful for mixing things", "", 4, 161, false, false, 0xffb366, false));
        items.add(new Class9_Sub2("Bowl of Water", "It's a bowl of water", "", 3, 162, false, false, 255, false));
        items.add(new Class9_Sub2("Incomplete Stew", "I need to add some meat too", "", 4, 162, false, false, 0x9999b3, false));
        items.add(new Class9_Sub2("Incomplete Stew", "I need to add some potato too", "", 4, 162, false, false, 0x9999b3, false));
        items.add(new Class9_Sub2("Uncooked Stew", "I need to cook this", "", 10, 162, false, false, 0xccb366, false));
        items.add(new Class9_Sub2("Stew", "It's a meat and potato stew", "Eat", 20, 162, false, false, 0x994c00, false));
        items.add(new Class9_Sub2("Burnt Stew", "Eew it's horribly burnt", "Empty", 1, 162, false, false, 0x303030, false));
        items.add(new Class9_Sub2("Potato", "Can be used to make stew", "", 1, 163, false, false, 0, false));
        items.add(new Class9_Sub2("Raw Shrimp", "I should try cooking this", "", 5, 164, false, false, 0xffa0a0, false));
        items.add(new Class9_Sub2("Shrimp", "Some nicely cooked fish", "Eat", 5, 164, false, false, 0xff7070, false));
        items.add(new Class9_Sub2("Raw Anchovies", "I should try cooking this", "", 15, 164, false, false, 0xa0a0ff, false));
        items.add(new Class9_Sub2("Anchovies", "Some nicely cooked fish", "Eat", 15, 164, false, false, 0x7070ff, false));
        items.add(new Class9_Sub2("Burnt Fish", "Oops!", "", 1, 164, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Raw Sardine", "I should try cooking this", "", 10, 165, false, false, 0xa0ffa0, false));
        items.add(new Class9_Sub2("Sardine", "Some nicely cooked fish", "Eat", 10, 165, false, false, 0x70ff70, false));
        items.add(new Class9_Sub2("Raw Salmon", "I should try cooking this", "", 50, 165, false, false, 0, false));
        items.add(new Class9_Sub2("Salmon", "Some nicely cooked fish", "Eat", 50, 165, false, false, 0xc09090, false));
        items.add(new Class9_Sub2("Raw Trout", "I should try cooking this", "", 20, 165, false, false, 0xffa0a0, false));
        items.add(new Class9_Sub2("Trout", "Some nicely cooked fish", "Eat", 20, 165, false, false, 0xff7070, false));
        items.add(new Class9_Sub2("Burnt Fish", "Oops!", "", 1, 165, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Raw Herring", "I should try cooking this", "", 15, 166, false, false, 0, false));
        items.add(new Class9_Sub2("Herring", "Some nicely cooked fish", "Eat", 15, 166, false, false, 0xc09090, false));
        items.add(new Class9_Sub2("Raw Pike", "I should try cooking this", "", 25, 166, false, false, 0xa0a0ff, false));
        items.add(new Class9_Sub2("Pike", "Some nicely cooked fish", "Eat", 25, 166, false, false, 0x7070ff, false));
        items.add(new Class9_Sub2("Burnt Fish", "Oops!", "", 1, 166, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Raw Tuna", "I should try cooking this", "", 100, 167, false, false, 0, false));
        items.add(new Class9_Sub2("Tuna", "Wow this is a big fish", "Eat", 100, 167, false, false, 0xc09090, false));
        items.add(new Class9_Sub2("Burnt Fish", "Oops!", "", 1, 167, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Raw Swordfish", "I should try cooking this", "", 200, 168, false, false, 0xffa0ff, false));
        items.add(new Class9_Sub2("Swordfish", "I'd better be careful eating this!", "Eat", 350, 168, false, false, 0xc070c0, false));
        items.add(new Class9_Sub2("Burnt Swordfish", "Oops!", "", 1, 168, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Raw Lobster", "I should try cooking this", "", 350, 169, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Lobster", "This looks tricky to eat", "Eat", 0, 169, false, false, 0xb06000, false));
        items.add(new Class9_Sub2("Burnt Lobster", "Oops!", "", 1, 169, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Lobster Pot", "Useful for catching lobsters", "", 20, 170, false, false, 0, false));
        items.add(new Class9_Sub2("Net", "Useful for catching small fish", "", 5, 171, false, false, 0, false));
        items.add(new Class9_Sub2("Fishing Rod", "Useful for catching sardine or herring", "", 5, 172, false, false, 0, false));
        items.add(new Class9_Sub2("Fly Fishing Rod", "Useful for catching salmon or trout", "", 5, 173, false, false, 0, false));
        items.add(new Class9_Sub2("Harpoon", "Useful for catching really big fish", "", 5, 174, false, false, 0, false));
        items.add(new Class9_Sub2("Fishing Bait", "For use with a fishing rod", "", 3, 175, true, false, 0, false));
        items.add(new Class9_Sub2("Feather", "Used for fly-fishing", "", 2, 176, true, false, 0, false));
        items.add(new Class9_Sub2("Chest Key", "A key to One eyed Hector's chest", "", 1, 25, false, false, 0xaaff55, true));
        items.add(new Class9_Sub2("Silver", "this needs refining", "", 75, 134, false, false, 0, false));
        items.add(new Class9_Sub2("Silver Bar", "this looks valuable", "", 150, 79, false, false, 0, false));
        items.add(new Class9_Sub2("Holy Symbol of Saradomin", "This improves my prayer", "", 300, 44, false, true, 0, false));
        items.add(new Class9_Sub2("Holy Symbol Mould", "Used to make Holy Symbols", "", 5, 132, false, false, 0, false));
        items.add(new Class9_Sub2("Disk of Returning", "Used to get out of Thordur's blackhole", "spin", 12, 133, false, false, 0, false));
        items.add(new Class9_Sub2("Monks Robe", "I feel closer to the God's when I am wearing this", "", 40, 87, false, true, 0xa06040, false));
        items.add(new Class9_Sub2("Monks Robe", "Keeps a monk's legs nice and warm", "", 30, 88, false, true, 0xa06040, false));
        items.add(new Class9_Sub2("Red Key", "A painted key", "", 1, 25, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("Orange Key", "A painted key", "", 1, 25, false, false, 0x55aaff, true));
        items.add(new Class9_Sub2("Yellow Key", "A painted key", "", 1, 25, false, false, 0xffff55, true));
        items.add(new Class9_Sub2("Blue Key", "A painted key", "", 1, 25, false, false, 255, true));
        items.add(new Class9_Sub2("Magenta Key", "A painted key", "", 1, 25, false, false, 0xff00ff, true));
        items.add(new Class9_Sub2("Black Key", "A painted key", "", 1, 25, false, false, 0x404040, true));
        items.add(new Class9_Sub2("Rune Dagger", "Short but pointy", "", 8000, 80, false, true, 65535, false));
        items.add(new Class9_Sub2("Rune Short Sword", "A razor sharp sword", "", 20800, 1, false, true, 65535, false));
        items.add(new Class9_Sub2("Rune Scimitar", "A vicious curved sword", "", 25600, 83, false, true, 65535, false));
        items.add(new Class9_Sub2("Medium Rune Helmet", "A medium sized helmet", "", 19200, 5, false, true, 65535, false));
        items.add(new Class9_Sub2("Rune Chain Mail Body", "A series of connected metal rings", "", 50000, 7, false, true, 65535, false));
        items.add(new Class9_Sub2("Rune Plate Mail Body", "Provides excellent protection", "", 65000, 8, false, true, 65535, false));
        items.add(new Class9_Sub2("Rune Plate Mail Legs", "These look pretty heavy", "", 64000, 9, false, true, 65535, false));
        items.add(new Class9_Sub2("Rune Square Shield", "A medium metal shield", "", 38400, 3, false, true, 56797, false));
        items.add(new Class9_Sub2("Rune Kite Shield", "A large metal shield", "", 54400, 2, false, true, 56797, false));
        items.add(new Class9_Sub2("Rune Axe", "A powerful axe", "", 12800, 12, false, true, 65535, false));
        items.add(new Class9_Sub2("Rune Skirt", "Designer leg protection", "", 64000, 88, false, true, 26214, false));
        items.add(new Class9_Sub2("Rune Plate Mail Top", "Armour designed for females", "", 65000, 130, false, true, 65535, false));
        items.add(new Class9_Sub2("Runite Bar", "it's a bar of runite", "", 5000, 79, false, false, 56797, false));
        items.add(new Class9_Sub2("Runite Ore", "this needs refining", "", 3200, 70, false, false, 56797, false));
        items.add(new Class9_Sub2("Plank", "This doesn't look very useful", "", 1, 135, false, false, 0, false));
        items.add(new Class9_Sub2("Tile", "This doesn't look very useful", "", 1, 136, false, false, 0, false));
        items.add(new Class9_Sub2("Skull", "A spooky looking skull", "", 1, 26, false, false, 0, true));
        items.add(new Class9_Sub2("Big Bones", "Ew it's a pile of bones", "Bury", 1, 137, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy key", "It looks like a key to a chest", "", 1, 25, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Map", "A map showing the way to the Isle of Crandor", "", 1, 138, false, false, 0, true));
        items.add(new Class9_Sub2("Map Piece", "I need some more of the map for this to be useful", "", 1, 139, false, false, 0, true));
        items.add(new Class9_Sub2("Map Piece", "I need some more of the map for this to be useful", "", 1, 140, false, false, 0, true));
        items.add(new Class9_Sub2("Map Piece", "I need some more of the map for this to be useful", "", 1, 141, false, false, 0, true));
        items.add(new Class9_Sub2("Nails", "Nails made from steel", "", 3, 142, true, false, 0, false));
        items.add(new Class9_Sub2("Anti Dragon Breath Shield", "Helps prevent damage from dragons", "", 20, 143, false, true, 0, false));
        items.add(new Class9_Sub2("Maze Key", "The key to the entrance of Melzar's maze", "", 1, 25, false, false, 0xdddddd, false));
        items.add(new Class9_Sub2("Pumpkin", "Happy halloween", "eat", 10, 149, false, false, 0, false));
        items.add(new Class9_Sub2("Black Dagger", "Short but pointy", "", 240, 80, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Short Sword", "A razor sharp sword", "", 624, 1, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Long Sword", "A razor sharp sword", "", 960, 81, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black 2-Handed Sword", "A very large sword", "", 1920, 82, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Scimitar", "A vicious curved sword", "", 768, 83, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Axe", "A sinister looking axe", "", 384, 12, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Battle Axe", "A vicious looking axe", "", 1248, 84, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Mace", "A spikey mace", "", 432, 0, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Chain Mail Body", "A series of connected metal rings", "", 1440, 7, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Square Shield", "A medium metal shield", "", 1152, 3, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Kite Shield", "A large metal shield", "", 1632, 2, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Black Plated skirt", "designer leg protection", "", 1920, 88, false, true, 0x111111, false));
        items.add(new Class9_Sub2("Muddy Marrentill", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Tarromin", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Harralander", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Ranarr Weed", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Irit Leaf", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Avantoe", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Kwuarm", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Cadantine", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Dwarf Weed", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Guam Leaf", "A herb used in attack potion making", "", 3, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Marrentill", "A herb used in poison cures", "", 5, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Tarromin", "A useful herb", "", 11, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Harralander", "A useful herb", "", 20, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Ranarr Weed", "A useful herb", "", 25, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Irit Leaf", "A useful herb", "", 40, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Avantoe", "A useful herb", "", 48, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Kwuarm", "A powerful herb", "", 54, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Cadantine", "A powerful herb", "", 65, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Weed", "A powerful herb", "", 70, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Unfinished Guam Potion", "I need another ingredient to finish this Guam potion", "", 3, 48, false, false, 0x99b6b6, false));
        items.add(new Class9_Sub2("Unfinished Marrentill Potion", "I need another ingredient to finish this Marrentill potion", "", 5, 48, false, false, 0xb699b6, false));
        items.add(new Class9_Sub2("Unfinished Tarromin Potion", "I need another ingredient to finish this Tarromin potion", "", 11, 48, false, false, 0xb6b699, false));
        items.add(new Class9_Sub2("Unfinished Harralander Potion", "I need another ingredient to finish this Harralander potion", "", 20, 48, false, false, 0xb69999, false));
        items.add(new Class9_Sub2("Unfinished Ranarr Potion", "I need another ingredient to finish this Ranarr potion", "", 25, 48, false, false, 0x99b699, false));
        items.add(new Class9_Sub2("Unfinished Irit Potion", "I need another ingredient to finish this Irit potion", "", 40, 48, false, false, 0x9999b6, false));
        items.add(new Class9_Sub2("Unfinished Avantoe Potion", "I need another ingredient to finish this Avantoe potion", "", 48, 48, false, false, 0x999999, false));
        items.add(new Class9_Sub2("Unfinished Kwuarm Potion", "I need another ingredient to finish this Kwuarm potion", "", 54, 48, false, false, 0xb6b6b6, false));
        items.add(new Class9_Sub2("Unfinished Cadantine Potion", "I need another ingredient to finish this Cadantine potion", "", 65, 48, false, false, 0xd1b699, false));
        items.add(new Class9_Sub2("Unfinished Dwarfweed Potion", "I need another ingredient to finish this Dwarfweed potion", "", 70, 48, false, false, 0x99b6d1, false));
        items.add(new Class9_Sub2("Vial", "It's full of water", "", 2, 48, false, false, 0xaaddff, false));
        items.add(new Class9_Sub2("Vial", "This vial is empty", "", 2, 144, false, false, 0, false));
        items.add(new Class9_Sub2("Unicorn Horn", "Poor unicorn", "", 20, 145, false, false, 0, false));
        items.add(new Class9_Sub2("Blue Dragon Scale", "A large shiny scale", "", 50, 146, false, false, 0, false));
        items.add(new Class9_Sub2("Pestle and Mortar", "I can grind things for potions in this", "", 4, 147, false, false, 0, false));
        items.add(new Class9_Sub2("Snape Grass", "Strange spikey grass", "", 10, 148, false, false, 0, false));
        items.add(new Class9_Sub2("Medium Black Helmet", "A medium sized helmet", "", 576, 5, false, true, 0x303030, false));
        items.add(new Class9_Sub2("White Berries", "Poisonous berries", "", 10, 21, false, false, 0, false));
        items.add(new Class9_Sub2("Ground Blue Dragon Scale", "This stuff isn't good for you", "", 40, 23, false, false, 35071, false));
        items.add(new Class9_Sub2("Ground Unicorn Horn", "A useful potion ingredient", "", 20, 23, false, false, 0xeebb50, false));
        items.add(new Class9_Sub2("Attack Potion", "3 doses of attack potion", "Drink", 12, 48, false, false, 0x30eeee, false));
        items.add(new Class9_Sub2("Attack Potion", "2 doses of attack potion", "Drink", 9, 436, false, false, 0x30eeee, false));
        items.add(new Class9_Sub2("Attack Potion", "1 dose of attack potion", "Drink", 6, 437, false, false, 0x30eeee, false));
        items.add(new Class9_Sub2("Stat Restoration Potion", "3 doses of stat restoration potion", "Drink", 88, 48, false, false, 0xee3030, false));
        items.add(new Class9_Sub2("Stat Restoration Potion", "2 doses of stat restoration potion", "Drink", 66, 436, false, false, 0xee3030, false));
        items.add(new Class9_Sub2("Stat Restoration Potion", "1 dose of stat restoration potion", "Drink", 44, 437, false, false, 0xee3030, false));
        items.add(new Class9_Sub2("Defense Potion", "3 doses of defense potion", "Drink", 120, 48, false, false, 0x30ee30, false));
        items.add(new Class9_Sub2("Defense Potion", "2 doses of defense potion", "Drink", 90, 436, false, false, 0x30ee30, false));
        items.add(new Class9_Sub2("Defense Potion", "1 dose of defense potion", "Drink", 60, 437, false, false, 0x30ee30, false));
        items.add(new Class9_Sub2("Restore Prayer Potion", "3 doses of restore prayer potion", "Drink", 152, 48, false, false, 0x30ee99, false));
        items.add(new Class9_Sub2("Restore Prayer Potion", "2 doses of restore prayer potion", "Drink", 114, 436, false, false, 0x30ee99, false));
        items.add(new Class9_Sub2("Restore Prayer Potion", "1 dose of restore prayer potion", "Drink", 76, 437, false, false, 0x30ee99, false));
        items.add(new Class9_Sub2("Super Attack Potion", "3 doses of attack potion", "Drink", 5000, 48, false, false, 0x3030ee, false));
        items.add(new Class9_Sub2("Super Attack Potion", "2 doses of attack potion", "Drink", 1000, 436, false, false, 0x3030ee, false));
        items.add(new Class9_Sub2("Super Attack Potion", "1 dose of attack potion", "Drink", 1000, 437, false, false, 0x3030ee, false));
        items.add(new Class9_Sub2("Fishing Potion", "3 doses of fishing potion", "Drink", 200, 48, false, false, 0x303030, false));
        items.add(new Class9_Sub2("Fishing Potion", "2 doses of fishing potion", "Drink", 150, 436, false, false, 0x303030, false));
        items.add(new Class9_Sub2("Fishing Potion", "1 dose of fishing potion", "Drink", 100, 437, false, false, 0x303030, false));
        items.add(new Class9_Sub2("Super Strength Potion", "3 doses of strength potion", "Drink", 5000, 48, false, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Super Strength Potion", "2 doses of strength potion", "Drink", 1000, 436, false, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Super Strength Potion", "1 dose of strength potion", "Drink", 1000, 437, false, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Super Defense Potion", "3 doses of defense potion", "Drink", 5000, 48, false, false, 0xeeb630, false));
        items.add(new Class9_Sub2("Super Defense Potion", "2 doses of defense potion", "Drink", 1000, 436, false, false, 0xeeb630, false));
        items.add(new Class9_Sub2("Super Defense Potion", "1 dose of defense potion", "Drink", 1000, 437, false, false, 0xeeb630, false));
        items.add(new Class9_Sub2("Ranging Potion", "3 doses of ranging potion", "Drink", 288, 48, false, false, 0x30b6ee, false));
        items.add(new Class9_Sub2("Ranging Potion", "2 doses of ranging potion", "Drink", 216, 436, false, false, 0x30b6ee, false));
        items.add(new Class9_Sub2("Ranging Potion", "1 dose of ranging potion", "Drink", 144, 437, false, false, 0x30b6ee, false));
        items.add(new Class9_Sub2("Wine of Zamorak", "It's full of wine", "Drink", 1, 65, false, false, 0xc41818, false));
        items.add(new Class9_Sub2("Raw Bear Meat", "I need to cook this first", "", 1, 60, false, false, 0xff8c33, false));
        items.add(new Class9_Sub2("Raw Rat Meat", "I need to cook this first", "", 1, 60, false, false, 0xff8c33, false));
        items.add(new Class9_Sub2("Raw Beef", "I need to cook this first", "", 1, 60, false, false, 0xff8c33, false));
        items.add(new Class9_Sub2("Enchanted Bear Meat", "I don't fancy eating this now", "", 1, 60, false, false, 0xcdec33, true));
        items.add(new Class9_Sub2("Enchanted Rat Meat", "I don't fancy eating this now", "", 1, 60, false, false, 0xcdec33, true));
        items.add(new Class9_Sub2("Enchanted Beef", "I don't fancy eating this now", "", 1, 60, false, false, 0xcdec33, true));
        items.add(new Class9_Sub2("Enchanted Chicken Meat", "I don't fancy eating this now", "", 1, 60, false, false, 0xcdec33, true));
        items.add(new Class9_Sub2("Dramen Staff", "A magical staff cut from the dramen tree", "", 15, 85, false, true, 0x99b2cc, true));
        items.add(new Class9_Sub2("Dramen Branch", "I need to make this into a staff", "", 15, 179, false, false, 0x99b2cc, true));
        items.add(new Class9_Sub2("Cape", "A thick Green cape", "", 32, 59, false, true, 0x40cc40, false));
        items.add(new Class9_Sub2("Cape", "A thick yellow cape", "", 32, 59, false, true, 0xeeee40, false));
        items.add(new Class9_Sub2("Cape", "A thick Orange cape", "", 32, 59, false, true, 0xee9900, false));
        items.add(new Class9_Sub2("Cape", "A thick purple cape", "", 32, 59, false, true, 0xaa00dd, false));
        items.add(new Class9_Sub2("Greendye", "A little bottle of dye", "", 5, 104, false, false, 65280, false));
        items.add(new Class9_Sub2("Purpledye", "A little bottle of dye", "", 5, 104, false, false, 0xaa00ff, false));
        items.add(new Class9_Sub2("Iron Ore Certificate", "Each certificate exchangable at draynor market for 5 iron ore", "", 10, 180, true, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Coal Certificate", "Each certificate exchangable at draynor market for 5 coal", "", 20, 180, true, false, 0x404040, false));
        items.add(new Class9_Sub2("Mithril Ore Certificate", "Each certificate exchangable at draynor market for 5 mithril ore", "", 30, 180, true, false, 0x99b2cc, false));
        items.add(new Class9_Sub2("Silver Certificate", "Each certificate exchangable at draynor market for 5 silver nuggets", "", 15, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Gold Certificate", "Each certificate exchangable at draynor market for 5 gold nuggets", "", 25, 180, true, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Dragonstone Amulet", "A very powerful amulet", "", 17625, 125, false, true, 0xbb00ff, false));
        items.add(new Class9_Sub2("Dragonstone", "This looks very valuable", "", 10000, 74, false, false, 0xbb00ff, false));
        items.add(new Class9_Sub2("Dragonstone Amulet", "It needs a string so I can wear it", "", 17625, 126, false, false, 0xbb00ff, false));
        items.add(new Class9_Sub2("Crystal Key", "A very shiny key", "", 1, 25, false, false, 0xeeffff, false));
        items.add(new Class9_Sub2("Half of a Key", "A very shiny key", "", 1, 181, false, false, 0xeeffff, false));
        items.add(new Class9_Sub2("Half of a Key", "A very shiny key", "", 1, 182, false, false, 0xeeffff, false));
        items.add(new Class9_Sub2("Iron Bar Certificate", "Each certificate exchangable at draynor market for 5 iron bars", "", 10, 180, true, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Bar Certificate", "Each certificate exchangable at draynor market for 5 steel bars", "", 20, 180, true, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Bar Certificate", "Each certificate exchangable at draynor market for 5 mithril bars", "", 30, 180, true, false, 0x99b2cc, false));
        items.add(new Class9_Sub2("Silver Bar Certificate", "Each certificate exchangable at draynor market for 5 silver bars", "", 15, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Gold Bar Certificate", "Each certificate exchangable at draynor market for 5 gold bars", "", 25, 180, true, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Lobster Certificate", "Each certificate exchangable at draynor market for 5 lobsters", "", 10, 180, true, false, 0xb06000, false));
        items.add(new Class9_Sub2("Raw Lobster Certificate", "Each certificate exchangable at draynor market for 5 raw lobsters", "", 10, 180, true, false, 0xff0000, false));
        items.add(new Class9_Sub2("Swordfish Certificate", "Each certificate exchangable at draynor market for 5 swordfish", "", 10, 180, true, false, 0xc070c0, false));
        items.add(new Class9_Sub2("Raw Swordfish Certificate", "Each certificate exchangable at draynor market for 5 raw swordfish", "", 10, 180, true, false, 0xffa0ff, false));
        items.add(new Class9_Sub2("Diary", "Property of Nora.T.Hag", "read", 1, 28, false, false, 0xaaffaa, true));
        items.add(new Class9_Sub2("Front Door Key", "A house key", "", 1, 25, false, false, 0xee9900, true));
        items.add(new Class9_Sub2("Ball", "A child's ball", "", 1, 183, false, false, 0, true));
        items.add(new Class9_Sub2("Magnet", "A very attractive magnet", "", 3, 184, false, false, 0, true));
        items.add(new Class9_Sub2("Grey Wolf Fur", "This would make warm clothing", "", 50, 68, false, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Uncut Dragonstone", "this would be worth more cut", "", 1000, 73, false, false, 0xbb00ff, false));
        items.add(new Class9_Sub2("Dragonstone Ring", "A valuable ring", "", 17625, 123, false, false, 0xbb00ff, false));
        items.add(new Class9_Sub2("Dragonstone Necklace", "I wonder if this is valuable", "", 18375, 57, false, true, 0xbb00ff, false));
        items.add(new Class9_Sub2("Raw Shark", "I should try cooking this", "", 495, 185, false, false, 0x505080, false));
        items.add(new Class9_Sub2("Shark", "I'd better be careful eating this!", "Eat", 0, 185, false, false, 0xb06000, false));
        items.add(new Class9_Sub2("Burnt Shark", "Oops!", "", 0, 185, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Big Net", "Useful for catching lots of fish", "", 20, 186, false, false, 0, false));
        items.add(new Class9_Sub2("Casket", "I hope there is treasure in it", "open", 50, 187, false, false, 0, false));
        items.add(new Class9_Sub2("Raw Cod", "I should try cooking this", "", 25, 165, false, false, 0xa0a0cc, false));
        items.add(new Class9_Sub2("Cod", "Some nicely cooked fish", "Eat", 25, 165, false, false, 0x7070cc, false));
        items.add(new Class9_Sub2("Raw Mackerel", "I should try cooking this", "", 17, 166, false, false, 0xcccca0, false));
        items.add(new Class9_Sub2("Mackerel", "Some nicely cooked fish", "Eat", 17, 166, false, false, 0xcccc70, false));
        items.add(new Class9_Sub2("Raw Bass", "I should try cooking this", "", 120, 167, false, false, 0xffa0a0, false));
        items.add(new Class9_Sub2("Bass", "Wow this is a big fish", "Eat", 120, 167, false, false, 0xff7070, false));
        items.add(new Class9_Sub2("Ice Gloves", "These will keep my hands cold!", "", 6, 17, false, true, 0xaaeeff, true));
        items.add(new Class9_Sub2("Firebird Feather", "A red hot feather", "", 2, 176, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("Firebird Feather", "This is cool enough to hold now", "", 2, 176, false, false, 0xffdd00, true));
        items.add(new Class9_Sub2("Poisoned Iron Dagger", "Short but pointy", "", 35, 80, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Poisoned bronze Dagger", "Short but pointy", "", 10, 80, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Poisoned Steel Dagger", "Short but pointy", "", 125, 80, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Poisoned Mithril Dagger", "Short but pointy", "", 325, 80, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Poisoned Rune Dagger", "Short but pointy", "", 8000, 80, false, true, 65535, false));
        items.add(new Class9_Sub2("Poisoned Adamantite Dagger", "Short but pointy", "", 800, 80, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Poisoned Black Dagger", "Short but pointy", "", 240, 80, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Cure Poison Potion", "3 doses of cure poison potion", "Drink", 288, 48, false, false, 0x66ff11, false));
        items.add(new Class9_Sub2("Cure Poison Potion", "2 doses of cure poison potion", "Drink", 216, 436, false, false, 0x66ff11, false));
        items.add(new Class9_Sub2("Cure Poison Potion", "1 dose of cure poison potion", "Drink", 144, 437, false, false, 0x66ff11, false));
        items.add(new Class9_Sub2("Poison Antidote", "3 doses of anti poison potion", "Drink", 288, 48, false, false, 0xff1166, false));
        items.add(new Class9_Sub2("Poison Antidote", "2 doses of anti poison potion", "Drink", 216, 436, false, false, 0xff1166, false));
        items.add(new Class9_Sub2("Poison Antidote", "1 dose of anti poison potion", "Drink", 144, 437, false, false, 0xff1166, false));
        items.add(new Class9_Sub2("Weapon Poison", "For use on daggers and arrows", "", 144, 48, false, false, 0x1166ff, false));
        items.add(new Class9_Sub2("ID Paper", "ID of Hartigen the black knight", "", 1, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Poison Bronze Arrows", "Venomous looking arrows", "", 2, 206, true, false, 0xff6619, false));
        items.add(new Class9_Sub2("Christmas Cracker", "Use on another player to pull it", "", 1, 188, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Party Hat", "Party!!!", "", 2, 189, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Party Hat", "Party!!!", "", 2, 189, false, true, 0xffff00, false));
        items.add(new Class9_Sub2("Party Hat", "Party!!!", "", 2, 189, false, true, 255, false));
        items.add(new Class9_Sub2("Party Hat", "Party!!!", "", 2, 189, false, true, 65280, false));
        items.add(new Class9_Sub2("Party Hat", "Party!!!", "", 2, 189, false, true, 0xff00ff, false));
        items.add(new Class9_Sub2("Party Hat", "Party!!!", "", 2, 189, false, true, 0, false));
        items.add(new Class9_Sub2("Miscellaneous Key", "I wonder what this unlocks", "", 1, 25, false, false, 0xdd6666, false));
        items.add(new Class9_Sub2("Bunch of Keys", "Some keys on a keyring", "", 2, 190, false, false, 0, true));
        items.add(new Class9_Sub2("Whisky", "A bottle of Draynor Malt", "drink", 5, 191, false, false, 0xffaa00, false));
        items.add(new Class9_Sub2("Candlestick", "A valuable candlestick", "", 5, 192, false, false, 0, true));
        items.add(new Class9_Sub2("Master Thief Armband", "This denotes a great act of thievery", "", 2, 193, false, false, 0, true));
        items.add(new Class9_Sub2("Blamish Snail Slime", "Yuck", "", 5, 104, false, false, 0xeeffee, true));
        items.add(new Class9_Sub2("Blamish Oil", "made from the finest snail slime", "", 10, 48, false, false, 0xeeffee, true));
        items.add(new Class9_Sub2("Oily Fishing Rod", "A rod covered in Blamish oil", "", 15, 172, false, false, 0, true));
        items.add(new Class9_Sub2("Lava Eel", "Strange it looks cooler now it's been cooked", "eat", 150, 194, false, false, 0xb06000, true));
        items.add(new Class9_Sub2("Raw Lava Eel", "A very strange eel", "", 150, 194, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("Poison Crossbow Bolts", "Good if you have a crossbow!", "", 3, 56, true, false, 0, false));
        items.add(new Class9_Sub2("Dragon Sword", "A Razor sharp sword", "", 0x1e8480, 273, false, true, 0xff0044, false));
        items.add(new Class9_Sub2("Dragon Axe", "A vicious looking axe", "", 0x2625a0, 272, false, true, 0xff0044, false));
        items.add(new Class9_Sub2("Jail Keys", "Keys to the black knight jail", "", 2, 190, false, false, 0, true));
        items.add(new Class9_Sub2("Dusty Key", "A key given to me by Velrak", "", 1, 25, false, false, 0xbbbbbb, false));
        items.add(new Class9_Sub2("Charged Dragonstone Amulet", "A very powerful amulet", "rub", 25000, 125, false, true, 0xbb00ff, false));
        items.add(new Class9_Sub2("Grog", "A murky glass of some sort of drink", "drink", 3, 90, false, false, 0, false));
        items.add(new Class9_Sub2("Candle", "An unlit candle", "", 3, 195, false, false, 0, false));
        items.add(new Class9_Sub2("Black Candle", "A spooky but unlit candle", "", 3, 195, false, false, 0x202020, true));
        items.add(new Class9_Sub2("Candle", "A small slowly burning candle", "", 3, 196, false, false, 0, false));
        items.add(new Class9_Sub2("Black Candle", "A spooky candle", "", 3, 196, false, false, 0x202020, true));
        items.add(new Class9_Sub2("Insect Repellant", "Drives away all known 6 legged creatures", "", 3, 197, false, false, 0, false));
        items.add(new Class9_Sub2("Bat Bones", "Ew it's a pile of bones", "Bury", 1, 20, false, false, 0, false));
        items.add(new Class9_Sub2("Wax Bucket", "It's a wooden bucket", "", 2, 22, false, false, 0xffffdd, false));
        items.add(new Class9_Sub2("Excalibur", "This used to belong to king Arthur", "", 200, 115, false, true, 0x99b2cc, true));
        items.add(new Class9_Sub2("Druids Robe", "I feel closer to the Gods when I am wearing this", "", 40, 87, false, true, 0xffffff, false));
        items.add(new Class9_Sub2("Druids Robe", "Keeps a druids's knees nice and warm", "", 30, 88, false, true, 0xffffff, false));
        items.add(new Class9_Sub2("Eye Patch", "It makes me look very piratical", "", 2, 198, false, true, 0, false));
        items.add(new Class9_Sub2("Unenchanted Dragonstone Amulet", "I wonder if I can get this enchanted", "", 17625, 125, false, true, 0xbb00ff, false));
        items.add(new Class9_Sub2("Unpowered Orb", "I'd prefer it if it was powered", "", 100, 199, false, false, 0, false));
        items.add(new Class9_Sub2("Fire Orb", "A magic glowing orb", "", 300, 199, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Water Orb", "A magic glowing orb", "", 300, 199, false, false, 255, false));
        items.add(new Class9_Sub2("Battlestaff", "It's a slightly magical stick", "", 7000, 85, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Battlestaff of Fire", "A Magical staff", "", 15500, 91, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Battlestaff of Water", "A Magical staff", "", 15500, 91, false, true, 255, false));
        items.add(new Class9_Sub2("Battlestaff of Air", "A Magical staff", "", 15500, 91, false, true, 65535, false));
        items.add(new Class9_Sub2("Battlestaff of Earth", "A Magical staff", "", 15500, 91, false, true, 0x703500, false));
        items.add(new Class9_Sub2("Blood-Rune", "Used for high level missile spells", "", 1500, 200, true, false, 0, false));
        items.add(new Class9_Sub2("Beer Glass", "I need to fill this with beer", "", 2, 201, false, false, 0, false));
        items.add(new Class9_Sub2("Glassblowing Pipe", "Use on molten glass to make things", "", 2, 202, false, false, 0, false));
        items.add(new Class9_Sub2("Seaweed", "slightly damp seaweed", "", 2, 203, false, false, 0, false));
        items.add(new Class9_Sub2("Molten Glass", "hot glass ready to be blown", "", 2, 204, false, false, 0, false));
        items.add(new Class9_Sub2("Soda Ash", "one of the ingredients for making glass", "", 2, 23, false, false, 0, false));
        items.add(new Class9_Sub2("Sand", "one of the ingredients for making glass", "", 2, 22, false, false, 0xffcc00, false));
        items.add(new Class9_Sub2("Air Orb", "A magic glowing orb", "", 300, 199, false, false, 65535, false));
        items.add(new Class9_Sub2("Earth Orb", "A magic glowing orb", "", 300, 199, false, false, 0x703500, false));
        items.add(new Class9_Sub2("Bass Certificate", "Each certificate exchangable at Catherby for 5 bass", "", 10, 180, true, false, 0xff7070, false));
        items.add(new Class9_Sub2("Raw Bass Certificate", "Each certificate exchangable at Catherby for 5 raw bass", "", 10, 180, true, false, 0xffa0a0, false));
        items.add(new Class9_Sub2("Shark Certificate", "Each certificate exchangable at Catherby for 5 shark", "", 10, 180, true, false, 0xb06000, false));
        items.add(new Class9_Sub2("Raw Shark Certificate", "Each certificate exchangable at Catherby for 5 raw shark", "", 10, 180, true, false, 0x505080, false));
        items.add(new Class9_Sub2("Oak Logs", "Logs cut from an oak tree", "", 20, 14, false, false, 0, false));
        items.add(new Class9_Sub2("Willow Logs", "Logs cut from a willow tree", "", 40, 14, false, false, 0, false));
        items.add(new Class9_Sub2("Maple Logs", "Logs cut from a maple tree", "", 80, 14, false, false, 0, false));
        items.add(new Class9_Sub2("Yew Logs", "Logs cut from a yew tree", "", 160, 14, false, false, 0, false));
        items.add(new Class9_Sub2("Magic Logs", "Logs made from magical wood", "", 320, 14, false, false, 0, false));
        items.add(new Class9_Sub2("Headless Arrows", "I need to attach arrow heads to these", "", 1, 205, true, false, 0, false));
        items.add(new Class9_Sub2("Iron Arrows", "Arrows with iron heads", "", 6, 11, true, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Poison Iron Arrows", "Venomous looking arrows", "", 6, 206, true, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Arrows", "Arrows with steel heads", "", 24, 11, true, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Poison Steel Arrows", "Venomous looking arrows", "", 24, 206, true, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Arrows", "Arrows with mithril heads", "", 64, 11, true, false, 0x92b2cc, false));
        items.add(new Class9_Sub2("Poison Mithril Arrows", "Venomous looking arrows", "", 64, 206, true, false, 0x92b2cc, false));
        items.add(new Class9_Sub2("Adamantite Arrows", "Arrows with adamantite heads", "", 160, 11, true, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Poison Adamantite Arrows", "Venomous looking arrows", "", 160, 206, true, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Arrows", "Arrows with rune heads", "", 800, 11, true, false, 65535, false));
        items.add(new Class9_Sub2("Poison Rune Arrows", "Venomous looking arrows", "", 800, 206, true, false, 65535, false));
        items.add(new Class9_Sub2("Oak Longbow", "A Nice sturdy bow", "", 160, 54, false, true, 255, false));
        items.add(new Class9_Sub2("Oak Shortbow", "Short but effective", "", 100, 55, false, true, 255, false));
        items.add(new Class9_Sub2("Willow Longbow", "A Nice sturdy bow", "", 320, 54, false, true, 0xffff00, false));
        items.add(new Class9_Sub2("Willow Shortbow", "Short but effective", "", 200, 55, false, true, 0xffff00, false));
        items.add(new Class9_Sub2("Maple Longbow", "A Nice sturdy bow", "", 640, 54, false, true, 0xff8800, false));
        items.add(new Class9_Sub2("Maple Shortbow", "Short but effective", "", 400, 55, false, true, 0xff8800, false));
        items.add(new Class9_Sub2("Yew Longbow", "A Nice sturdy bow", "", 1280, 54, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Yew Shortbow", "Short but effective", "", 800, 55, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Magic Longbow", "A Nice sturdy bow", "", 9875, 54, false, true, 0x404040, false));
        items.add(new Class9_Sub2("Magic Shortbow", "Short but effective", "", 1600, 55, false, true, 0x404040, false));
        items.add(new Class9_Sub2("Unstrung Oak Longbow", "I need to find a string for this", "", 80, 119, false, false, 255, false));
        items.add(new Class9_Sub2("Unstrung Oak Shortbow", "I need to find a string for this", "", 50, 120, false, false, 255, false));
        items.add(new Class9_Sub2("Unstrung Willow Longbow", "I need to find a string for this", "", 160, 119, false, false, 0xffff00, false));
        items.add(new Class9_Sub2("Unstrung Willow Shortbow", "I need to find a string for this", "", 100, 120, false, false, 0xffff00, false));
        items.add(new Class9_Sub2("Unstrung Maple Longbow", "I need to find a string for this", "", 320, 119, false, false, 0xff8000, false));
        items.add(new Class9_Sub2("Unstrung Maple Shortbow", "I need to find a string for this", "", 200, 120, false, false, 0xff8000, false));
        items.add(new Class9_Sub2("Unstrung Yew Longbow", "I need to find a string for this", "", 640, 119, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Unstrung Yew Shortbow", "I need to find a string for this", "", 400, 120, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Unstrung Magic Longbow", "I need to find a string for this", "", 1280, 119, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Unstrung Magic Shortbow", "I need to find a string for this", "", 800, 120, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Barcrawl Card", "The official Alfred Grimhand barcrawl", "read", 10, 180, false, false, 0, true));
        items.add(new Class9_Sub2("Bronze Arrow Heads", "Not much use without the rest of the arrow!", "", 1, 207, true, false, 0xff6619, false));
        items.add(new Class9_Sub2("Iron Arrow Heads", "Not much use without the rest of the arrow!", "", 3, 207, true, false, 0xeeeedd, false));
        items.add(new Class9_Sub2("Steel Arrow Heads", "Not much use without the rest of the arrow!", "", 12, 207, true, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Arrow Heads", "Not much use without the rest of the arrow!", "", 32, 207, true, false, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Arrow Heads", "Not much use without the rest of the arrow!", "", 80, 207, true, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Arrow Heads", "Not much use without the rest of the arrow!", "", 400, 207, true, false, 65535, false));
        items.add(new Class9_Sub2("Flax", "I should use this with a spinning wheel", "", 5, 209, false, false, 0, false));
        items.add(new Class9_Sub2("Bow String", "I need a bow handle to attach this too", "", 10, 208, false, false, 0, false));
        items.add(new Class9_Sub2("Easter Egg", "Happy Easter", "eat", 10, 210, false, false, 0, false));
        items.add(new Class9_Sub2("Scorpion Cage", "I need to catch some scorpions in this", "", 10, 211, false, false, 0, true));
        items.add(new Class9_Sub2("Scorpion Cage", "It has 1 scorpion in it", "", 10, 212, false, false, 0, true));
        items.add(new Class9_Sub2("Scorpion Cage", "It has 2 scorpions in it", "", 10, 212, false, false, 0, true));
        items.add(new Class9_Sub2("Scorpion Cage", "It has 3 scorpions in it", "", 10, 212, false, false, 0, true));
        items.add(new Class9_Sub2("Enchanted Battlestaff of Fire", "A Magical staff", "", 42500, 91, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Enchanted Battlestaff of Water", "A Magical staff", "", 42500, 91, false, true, 255, false));
        items.add(new Class9_Sub2("Enchanted Battlestaff of Air", "A Magical staff", "", 42500, 91, false, true, 65535, false));
        items.add(new Class9_Sub2("Enchanted Battlestaff of Earth", "A Magical staff", "", 42500, 91, false, true, 0x703500, false));
        items.add(new Class9_Sub2("Scorpion Cage", "It has 1 scorpion in it", "", 10, 212, false, false, 0, true));
        items.add(new Class9_Sub2("Scorpion Cage", "It has 1 scorpion in it", "", 10, 212, false, false, 0, true));
        items.add(new Class9_Sub2("Scorpion Cage", "It has 2 scorpions in it", "", 10, 212, false, false, 0, true));
        items.add(new Class9_Sub2("Scorpion Cage", "It has 2 scorpions in it", "", 10, 212, false, false, 0, true));
        items.add(new Class9_Sub2("Gold", "this needs refining", "", 150, 73, false, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Gold Bar", "this looks valuable", "", 300, 79, false, false, 0xffcc4c, false));
        items.add(new Class9_Sub2("Ruby Ring", "A valuable ring", "", 2025, 123, false, false, 0xff3300, false));
        items.add(new Class9_Sub2("Ruby Necklace", "I wonder if this is valuable", "", 2175, 57, false, true, 0xff3300, false));
        items.add(new Class9_Sub2("Family Crest", "The crest of a varrocian noble family", "", 10, 213, false, false, 0, true));
        items.add(new Class9_Sub2("Crest Fragment", "Part of the Fitzharmon family crest", "", 10, 214, false, false, 0, true));
        items.add(new Class9_Sub2("Crest Fragment", "Part of the Fitzharmon family crest", "", 10, 215, false, false, 0, true));
        items.add(new Class9_Sub2("Crest Fragment", "Part of the Fitzharmon family crest", "", 10, 216, false, false, 0, true));
        items.add(new Class9_Sub2("Steel Gauntlets", "Very handy armour", "", 6, 217, false, true, 0xbbbbbb, false));
        items.add(new Class9_Sub2("Gauntlets of Goldsmithing", "metal gloves for gold making", "", 6, 217, false, true, 0xffffaa, true));
        items.add(new Class9_Sub2("Gauntlets of Cooking", "Used for cooking fish", "", 6, 217, false, true, 0xdddddd, true));
        items.add(new Class9_Sub2("Gauntlets of Chaos", "improves bolt spells", "", 6, 217, false, true, 0xffaaaa, true));
        items.add(new Class9_Sub2("Robe of Zamorak", "A robe worn by worshippers of Zamorak", "", 1000, 87, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Robe of Zamorak", "A robe worn by worshippers of Zamorak", "", 1000, 88, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Address Label", "To lord Handelmort- Handelmort mansion", "", 10, 218, false, false, 0, true));
        items.add(new Class9_Sub2("Tribal Totem", "It represents some sort of tribal god", "", 10, 219, false, false, 0, true));
        items.add(new Class9_Sub2("Tourist Guide", "Your definitive guide to Ardougne", "read", 1, 28, false, false, 0xaaaaff, false));
        items.add(new Class9_Sub2("Spice", "Put it in uncooked stew to make curry", "", 230, 62, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Uncooked Curry", "I need to cook this", "", 10, 162, false, false, 0xeeb366, false));
        items.add(new Class9_Sub2("Curry", "It's a spicey hot curry", "Eat", 20, 162, false, false, 0xbb4c00, false));
        items.add(new Class9_Sub2("Burnt Curry", "Eew it's horribly burnt", "Empty", 1, 162, false, false, 0x503030, false));
        items.add(new Class9_Sub2("Yew Logs Certificate", "Each certificate exchangable at Ardougne for 5 yew logs", "", 10, 180, true, false, 0xb06000, false));
        items.add(new Class9_Sub2("Maple Logs Certificate", "Each certificate exchangable at Ardougne for 5 maple logs", "", 20, 180, true, false, 0xb06000, false));
        items.add(new Class9_Sub2("Willow Logs Certificate", "Each certificate exchangable at Ardougne for 5 willow logs", "", 30, 180, true, false, 0xb06000, false));
        items.add(new Class9_Sub2("Lockpick", "It makes picking some locks easier", "", 20, 220, false, false, 0, false));
        items.add(new Class9_Sub2("Red Vine Worms", "Strange little red worms", "", 3, 175, true, false, 0xff0000, true));
        items.add(new Class9_Sub2("Blanket", "A child's blanket", "", 5, 92, false, false, 56831, false));
        items.add(new Class9_Sub2("Raw Giant Carp", "I should try cooking this", "", 50, 165, false, false, 80, true));
        items.add(new Class9_Sub2("Giant Carp", "Some nicely cooked fish", "Eat", 50, 165, false, false, 0xc090d0, true));
        items.add(new Class9_Sub2("Fishing Competition Pass", "Admits one to the Hemenster fishing competition", "", 10, 218, false, false, 0, true));
        items.add(new Class9_Sub2("Hemenster Fishing Trophy", "Hurrah you won a fishing competition", "", 20, 221, false, false, 0xffcc4c, true));
        items.add(new Class9_Sub2("Pendant of Lucien", "Gets me through the chamber of fear", "", 12, 222, false, true, 0x303030, true));
        items.add(new Class9_Sub2("Ice Arrows", "Wearing these makes me feel like I am floating", "", 6, 223, false, true, 0xff7700, true));
        items.add(new Class9_Sub2("Ice Arrows", "Can only be fired with yew or magic bows", "", 2, 11, true, false, 0xaaffff, true));
        items.add(new Class9_Sub2("Lever", "This was once attached to something", "", 20, 224, false, false, 0, true));
        items.add(new Class9_Sub2("Staff of Armadyl", "A Magical staff", "", 15, 91, false, true, 0xffff00, true));
        items.add(new Class9_Sub2("Pendant of Armadyl", "Allows me to fight Lucien", "", 12, 222, false, true, 0, true));
        items.add(new Class9_Sub2("Large Cog", " A large old cog", "", 10, 241, false, false, 255, true));
        items.add(new Class9_Sub2("Large Cog", " A large old cog", "", 10, 240, false, false, 0, true));
        items.add(new Class9_Sub2("Large Cog", " A large old cog", "", 10, 241, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("Large Cog", " A large old cog", "", 10, 241, false, false, 0xcc00cc, true));
        items.add(new Class9_Sub2("Rat Poison", "This stuff looks nasty", "", 1, 52, false, false, 0, false));
        items.add(new Class9_Sub2("Shiny Key", "Quite a small key", "", 1, 25, false, false, 0xbbbbbb, true));
        items.add(new Class9_Sub2("Khazard Helmet", "A medium sized helmet", "", 10, 5, false, true, 0xababab, false));
        items.add(new Class9_Sub2("Khazard Chainmail", "A series of connected metal rings", "", 10, 7, false, true, 0xababab, false));
        items.add(new Class9_Sub2("Khali Brew", "A bottle of khazard's worst brew", "drink", 5, 191, false, false, 0xffaa00, false));
        items.add(new Class9_Sub2("Khazard Cell Keys", "Keys for General Khazard's cells", "", 1, 25, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Poison Chalice", "A strange looking drink", "drink", 20, 225, false, false, 0xaaff00, true));
        items.add(new Class9_Sub2("Magic Whistle", "A small tin whistle", "blow", 10, 226, false, false, 0, true));
        items.add(new Class9_Sub2("Cup of Tea", "A nice cup of tea", "drink", 10, 227, false, false, 0, false));
        items.add(new Class9_Sub2("Orb of Protection", "a strange glowing green orb", "", 1, 242, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Orbs of Protection", "two strange glowing green orbs", "", 1, 243, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Holy Table Napkin", "a cloth given to me by sir Galahad", "", 10, 92, false, false, 0, true));
        items.add(new Class9_Sub2("Bell", "I wonder what happens when i ring it", "ring", 1, 228, false, false, 0, true));
        items.add(new Class9_Sub2("Gnome Emerald Amulet of protection", "It improves my defense", "", 5000, 125, false, true, 0x33cc33, true));
        items.add(new Class9_Sub2("Magic Golden Feather", "It will point the way for me", "blow on", 2, 176, false, false, 0xffff00, true));
        items.add(new Class9_Sub2("Holy Grail", "A holy and powerful artifact", "", 1, 229, false, false, 0, true));
        items.add(new Class9_Sub2("Script of Hazeel", "An old scroll with strange ancient text", "", 1, 244, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Pineapple", "It can be cut up with a knife", "", 1, 124, false, false, 0, false));
        items.add(new Class9_Sub2("Pineapple Ring", "Exotic fruit", "eat", 1, 230, false, false, 0, false));
        items.add(new Class9_Sub2("Pineapple Pizza", "A tropicana pizza", "Eat", 100, 155, false, false, 0xffff77, false));
        items.add(new Class9_Sub2("Half Pineapple Pizza", "Half of this pizza has been eaten", "Eat", 50, 156, false, false, 0xffff77, false));
        items.add(new Class9_Sub2("Magic Scroll", "Maybe I should read it", "read", 1, 244, false, false, 0, true));
        items.add(new Class9_Sub2("Mark of Hazeel", "A large metal amulet", "", 0, 245, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Bloody Axe of Zamorak", "A vicious looking axe", "", 5000, 246, false, true, 0xeeeeee, true));
        items.add(new Class9_Sub2("Carnillean Armour", "the carnillean family armour", "", 65, 247, false, false, 0xeeeeee, true));
        items.add(new Class9_Sub2("Carnillean Key", "An old rusty key", "", 1, 25, false, false, 0xffee00, true));
        items.add(new Class9_Sub2("Cattle Prod", "An old cattle prod", "", 15, 248, false, false, 0xffee00, true));
        items.add(new Class9_Sub2("Plagued Sheep Remains", "These sheep remains are infected", "", 0, 20, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Poisoned Animal Feed", "This looks nasty", "", 0, 250, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Protective Jacket", "A thick heavy leather top", "", 50, 251, false, true, 0xdddddd, true));
        items.add(new Class9_Sub2("Protective Trousers", "A thick pair of leather trousers", "", 50, 252, false, true, 0xeedddd, true));
        items.add(new Class9_Sub2("Plagued Sheep Remains", "These sheep remains are infected", "", 0, 20, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Plagued Sheep Remains", "These sheep remains are infected", "", 0, 20, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Plagued Sheep Remains", "These sheep remains are infected", "", 0, 20, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Dwellberries", "some rather pretty blue berries", "eat", 4, 253, false, false, 0, false));
        items.add(new Class9_Sub2("Gasmask", "Stops me breathing nasty stuff", "", 2, 232, false, true, 0, true));
        items.add(new Class9_Sub2("Picture", "A picture of a lady called Elena", "", 2, 233, false, false, 0, true));
        items.add(new Class9_Sub2("Book", "Turnip growing for beginners", "read", 1, 28, false, false, 0xffaaff, false));
        items.add(new Class9_Sub2("Seaslug", "a rather nasty looking crustacean", "", 4, 254, false, false, 0, false));
        items.add(new Class9_Sub2("Chocolaty Milk", "Milk with chocolate in it", "drink", 2, 22, false, false, 0x955040, false));
        items.add(new Class9_Sub2("Hangover Cure", "It doesn't look very tasty", "", 2, 22, false, false, 0x85a040, true));
        items.add(new Class9_Sub2("Chocolate Dust", "I prefer it in a bar shape", "", 2, 23, false, false, 0x906020, false));
        items.add(new Class9_Sub2("Torch", "A unlit home made torch", "", 4, 255, false, false, 0, false));
        items.add(new Class9_Sub2("Torch", "A lit home made torch", "", 4, 256, false, false, 0, false));
        items.add(new Class9_Sub2("Warrant", "A search warrant for a house in Ardougne", "", 5, 29, false, false, 0, false));
        items.add(new Class9_Sub2("Damp Sticks", "Some damp wooden sticks", "", 0, 257, false, false, 0, false));
        items.add(new Class9_Sub2("Dry Sticks", "Some dry wooden sticks", "rub together", 0, 258, false, false, 0, false));
        items.add(new Class9_Sub2("Broken Glass", "Glass from a broken window pane", "", 0, 259, false, false, 0, false));
        items.add(new Class9_Sub2("Oyster Pearls", "I could work wonders with these and a chisel", "", 1400, 260, false, false, 0, false));
        items.add(new Class9_Sub2("Little Key", "Quite a small key", "", 1, 25, false, false, 0xbbbbbb, true));
        items.add(new Class9_Sub2("Scruffy Note", "It seems to say hongorer lure", "read", 2, 234, false, false, 0, true));
        items.add(new Class9_Sub2("Glarial's Amulet", "A bright green gem set in a necklace", "", 1, 261, false, true, 0xbbbbbb, true));
        items.add(new Class9_Sub2("Swamp Tar", "A foul smelling thick tar like substance", "", 1, 262, true, false, 0xbbbbbb, false));
        items.add(new Class9_Sub2("Uncooked Swamp Paste", "A thick tar like substance mixed with flour", "", 1, 263, true, false, 0xbbbbbb, false));
        items.add(new Class9_Sub2("Swamp Paste", "A tar like substance mixed with flour and warmed", "", 30, 263, true, false, 0xbbbbbb, false));
        items.add(new Class9_Sub2("Oyster Pearl Bolts", "Great if you have a crossbow!", "", 110, 266, true, false, 0, false));
        items.add(new Class9_Sub2("Glarial's Pebble", "A small pebble with elven inscription", "", 1, 264, false, false, 0xbbbbbb, true));
        items.add(new Class9_Sub2("Book on Baxtorian", "A book on elven history in north runescape", "read", 2, 28, false, false, 0, true));
        items.add(new Class9_Sub2("Large Key", "I wonder what this is the key to", "", 1, 25, false, false, 0xff9900, true));
        items.add(new Class9_Sub2("Oyster Pearl Bolt Tips", "Can be used to improve crossbow bolts", "", 56, 265, true, false, 0xbbbbbb, false));
        items.add(new Class9_Sub2("Oyster", "It's empty", "", 5, 267, false, false, 0, false));
        items.add(new Class9_Sub2("Oyster Pearls", "I could work wonders with these and a chisel", "", 112, 268, false, false, 0, false));
        items.add(new Class9_Sub2("Oyster", "It's a rare oyster", "open", 200, 269, false, false, 0, false));
        items.add(new Class9_Sub2("Soil", "It's a bucket of fine soil", "", 2, 22, false, false, 0xbb7777, false));
        items.add(new Class9_Sub2("Dragon Medium Helmet", "A medium sized helmet", "", 0x2dc6c0, 271, false, true, 0xff0044, false));
        items.add(new Class9_Sub2("Mithril Seed", "Magical seeds in a mithril case", "open", 200, 270, true, false, 0, false));
        items.add(new Class9_Sub2("An Old Key", "A door key", "", 1, 25, false, false, 0xee9900, true));
        items.add(new Class9_Sub2("Pigeon Cage", "It's for holding pigeons", "", 1, 274, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Messenger Pigeons", "some very plump birds", "release", 1, 275, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Bird Feed", "A selection of mixed seeds", "", 1, 276, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Rotten Apples", "Yuck!", "eat", 1, 277, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Doctors Gown", "I do feel clever wearing this", "", 40, 87, false, true, 0xffffff, true));
        items.add(new Class9_Sub2("Bronze Key", "A heavy key", "", 1, 25, false, false, 0xff6619, true));
        items.add(new Class9_Sub2("Distillator", "It's for seperating compounds", "", 1, 278, false, false, 0xff6619, true));
        items.add(new Class9_Sub2("Glarial's Urn", "An urn containing glarials ashes", "", 1, 279, false, false, 0, true));
        items.add(new Class9_Sub2("Glarial's Urn", "An empty metal urn", "", 1, 280, false, false, 0, true));
        items.add(new Class9_Sub2("Priest Robe", "I feel closer to saradomin in this", "", 500, 87, false, true, 0x101010, false));
        items.add(new Class9_Sub2("Priest Gown", "I feel closer to saradomin in this", "", 500, 88, false, true, 0x101010, false));
        items.add(new Class9_Sub2("Liquid Honey", "This isn't worth much", "", 0, 48, false, false, 0xffff00, true));
        items.add(new Class9_Sub2("Ethenea", "An expensive colourless liquid", "", 10, 48, false, false, 0xaaaabb, true));
        items.add(new Class9_Sub2("Sulphuric Broline", "it's highly poisonous", "", 1, 48, false, false, 0xb699b6, true));
        items.add(new Class9_Sub2("Plague Sample", "An air tight tin container", "", 1, 281, false, false, 0, true));
        items.add(new Class9_Sub2("Touch Paper", "For scientific testing", "", 1, 282, false, false, 0, true));
        items.add(new Class9_Sub2("Dragon Bones", "Ew it's a pile of bones", "Bury", 1, 137, false, false, 0, false));
        items.add(new Class9_Sub2("Muddy Snake Weed", "I need to clean this", "Clean", 1, 435, false, false, 0, true));
        items.add(new Class9_Sub2("Snake Weed", "A very rare jungle herb", "", 5, 75, false, false, 0, true));
        items.add(new Class9_Sub2("Muddy Ardrigal", "I need to clean this", "Clean", 1, 435, false, false, 0, true));
        items.add(new Class9_Sub2("Ardrigal", "An interesting", "", 5, 435, false, false, 0, true));
        items.add(new Class9_Sub2("Muddy Sito Foil", "I need to clean this", "Clean", 1, 435, false, false, 0, true));
        items.add(new Class9_Sub2("Sito Foil", "An rare species of jungle herb", "", 5, 75, false, false, 0, true));
        items.add(new Class9_Sub2("Muddy Volencia Moss", "I need to clean this", "Clean", 1, 435, false, false, 0, true));
        items.add(new Class9_Sub2("Volencia Moss", "A very rare species of jungle herb", "", 5, 75, false, false, 0, true));
        items.add(new Class9_Sub2("Muddy Rogues Purse", "I need to clean this", "Clean", 1, 435, false, false, 0, true));
        items.add(new Class9_Sub2("Rogues Purse", " A rare species of jungle herb", "", 5, 75, false, false, 0, true));
        items.add(new Class9_Sub2("Soul-Rune", "Used for high level curse spells", "", 2500, 235, true, false, 0, false));
        items.add(new Class9_Sub2("King Lathas Amulet", "The amulet is red", "", 10, 125, false, true, 0xcc3333, true));
        items.add(new Class9_Sub2("Bronze Spear", "A bronze tipped spear", "", 4, 283, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Halloween Mask", "aaaarrrghhh ... i'm a monster", "", 15, 284, false, true, 65280, false));
        items.add(new Class9_Sub2("Dragon Bitter", "A glass of frothy ale", "drink", 2, 90, false, false, 0, false));
        items.add(new Class9_Sub2("Greenmans Ale", "A glass of frothy ale", "drink", 2, 90, false, false, 0, false));
        items.add(new Class9_Sub2("Halloween Mask", "aaaarrrghhh ... i'm a monster", "", 15, 284, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Halloween Mask", "aaaarrrghhh ... i'm a monster", "", 15, 284, false, true, 255, false));
        items.add(new Class9_Sub2("Cocktail Glass", "For sipping cocktails", "", 0, 285, false, false, 0, false));
        items.add(new Class9_Sub2("Cocktail Shaker", "For mixing cocktails", "pour", 2, 286, false, false, 0, false));
        items.add(new Class9_Sub2("Bone Key", "A key delicately carved key made from a single piece of bone", "Look", 1, 25, false, false, 0xffffff, true));
        items.add(new Class9_Sub2("Gnome Robe", "A high fashion robe", "", 1000, 88, false, true, 0xffaaaa, false));
        items.add(new Class9_Sub2("Gnome Robe", "A high fashion robe", "", 1000, 88, false, true, 0xaaffaa, false));
        items.add(new Class9_Sub2("Gnome Robe", "A high fashion robe", "", 1000, 88, false, true, 0xaaaaff, false));
        items.add(new Class9_Sub2("Gnome Robe", "A high fashion robe", "", 1000, 88, false, true, 0xffffcc, false));
        items.add(new Class9_Sub2("Gnome Robe", "A high fashion robe", "", 1000, 88, false, true, 0xccffff, false));
        items.add(new Class9_Sub2("Gnomes Hat", "A silly pointed hat", "", 500, 86, false, true, 0xffaaaa, false));
        items.add(new Class9_Sub2("Gnomes Hat", "A silly pointed hat", "", 500, 86, false, true, 0xaaffaa, false));
        items.add(new Class9_Sub2("Gnomes Hat", "A silly pointed hat", "", 500, 86, false, true, 0xaaaaff, false));
        items.add(new Class9_Sub2("Gnomes Hat", "A silly pointed hat", "", 500, 86, false, true, 0xffffcc, false));
        items.add(new Class9_Sub2("Gnomes Hat", "A silly pointed hat", "", 500, 86, false, true, 0xccffff, false));
        items.add(new Class9_Sub2("Gnome Top", "rometti - the ultimate in gnome design", "", 1500, 87, false, true, 0xffaaaa, false));
        items.add(new Class9_Sub2("Gnome Top", "rometti - the only name in gnome fashion!", "", 1500, 87, false, true, 0xaaffaa, false));
        items.add(new Class9_Sub2("Gnome Top", "rometti - the only name in gnome fashion!", "", 1500, 87, false, true, 0xaaaaff, false));
        items.add(new Class9_Sub2("Gnome Top", "rometti - the only name in gnome fashion!", "", 1500, 87, false, true, 0xffffcc, false));
        items.add(new Class9_Sub2("Gnome Top", "rometti - the only name in gnome fashion!", "", 1500, 87, false, true, 0xccffff, false));
        items.add(new Class9_Sub2("Gnome Cocktail Guide", "A book on tree gnome cocktails", "read", 2, 299, false, false, 0, false));
        items.add(new Class9_Sub2("Beads of the Dead", "A curious looking neck ornament", "", 35, 24, false, true, 0xff6619, true));
        items.add(new Class9_Sub2("Cocktail Glass", "For sipping cocktails", "drink", 2, 288, false, false, 0, false));
        items.add(new Class9_Sub2("Cocktail Glass", "For sipping cocktails", "drink", 2, 289, false, false, 0, false));
        items.add(new Class9_Sub2("Lemon", "It's very fresh", "eat", 2, 290, false, false, 0, false));
        items.add(new Class9_Sub2("Lemon Slices", "It's very fresh", "eat", 2, 291, false, false, 0xffcc30, false));
        items.add(new Class9_Sub2("Orange", "It's very fresh", "eat", 2, 292, false, false, 0, false));
        items.add(new Class9_Sub2("Orange Slices", "It's very fresh", "eat", 2, 291, false, false, 0xffc030, false));
        items.add(new Class9_Sub2("Diced Orange", "Fresh chunks of orange", "eat", 2, 293, false, false, 0xffc030, false));
        items.add(new Class9_Sub2("Diced Lemon", "Fresh chunks of lemon", "eat", 2, 293, false, false, 0xffcc30, false));
        items.add(new Class9_Sub2("Fresh Pineapple", "It can be cut up with a knife", "eat", 1, 124, false, false, 0, false));
        items.add(new Class9_Sub2("Pineapple Chunks", "Fresh chunks of pineapple", "eat", 1, 293, false, false, 0xffc030, false));
        items.add(new Class9_Sub2("Lime", "It's very fresh", "eat", 2, 294, false, false, 0, false));
        items.add(new Class9_Sub2("Lime Chunks", "Fresh chunks of lime", "eat", 1, 293, false, false, 65280, false));
        items.add(new Class9_Sub2("Lime Slices", "It's very fresh", "eat", 2, 291, false, false, 65280, false));
        items.add(new Class9_Sub2("Fruit Blast", "A cool refreshing fruit mix", "drink", 2, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Odd Looking Cocktail", "A cool refreshing mix", "drink", 2, 289, false, false, 0, false));
        items.add(new Class9_Sub2("Whisky", "A locally brewed Malt", "drink", 5, 191, false, false, 0xffaa00, false));
        items.add(new Class9_Sub2("Vodka", "A strong spirit", "drink", 5, 191, false, false, 0xffaa00, false));
        items.add(new Class9_Sub2("Gin", "A strong spirit", "drink", 5, 191, false, false, 0xffaa00, false));
        items.add(new Class9_Sub2("Cream", "Fresh cream", "eat", 2, 296, false, false, 0, false));
        items.add(new Class9_Sub2("Drunk Dragon", "A warm creamy alcoholic beverage", "drink", 2, 297, false, false, 0, false));
        items.add(new Class9_Sub2("Equa Leaves", "Small sweet smelling leaves", "eat", 2, 298, false, false, 0, false));
        items.add(new Class9_Sub2("SGG", "A short green guy..looks good", "drink", 2, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Chocolate Saturday", "A warm creamy alcoholic beverage", "drink", 2, 297, false, false, 0, false));
        items.add(new Class9_Sub2("Brandy", "A strong spirit", "drink", 5, 191, false, false, 0xffaa00, false));
        items.add(new Class9_Sub2("Blurberry Special", "Looks good..smells strong", "drink", 2, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Wizard Blizzard", "Looks like a strange mix", "drink", 2, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Pineapple Punch", "A fresh healthy fruit mix", "drink", 2, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomebatta Dough", "Dough formed into a base", "", 2, 300, false, false, 0, false));
        items.add(new Class9_Sub2("Gianne Dough", "It's made from a secret recipe", "mould", 2, 301, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomebowl Dough", "Dough formed into a bowl shape", "", 2, 302, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomecrunchie Dough", "Dough formed into cookie shapes", "", 2, 303, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomebatta", "A baked dough base", "", 2, 300, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomebowl", "A baked dough bowl", "eat", 2, 302, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomebatta", "It's burnt to a sinder", "", 2, 304, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomecrunchie", "They're burnt to a sinder", "", 2, 306, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomebowl", "It's burnt to a sinder", "", 2, 305, false, false, 0, false));
        items.add(new Class9_Sub2("Uncut Red Topaz", "A semi precious stone", "", 40, 73, false, false, 0xfc274d, false));
        items.add(new Class9_Sub2("Uncut Jade", "A semi precious stone", "", 30, 73, false, false, 0x98fb98, false));
        items.add(new Class9_Sub2("Uncut Opal", "A semi precious stone", "", 20, 73, false, false, 0xffffa4, false));
        items.add(new Class9_Sub2("Red Topaz", "A semi precious stone", "", 200, 74, false, false, 0xfc274d, false));
        items.add(new Class9_Sub2("Jade", "A semi precious stone", "", 150, 74, false, false, 0x98fb98, false));
        items.add(new Class9_Sub2("Opal", "A semi precious stone", "", 100, 74, false, false, 0xffffa4, false));
        items.add(new Class9_Sub2("Swamp Toad", "Slippery little blighters", "remove legs", 2, 307, false, false, 0, false));
        items.add(new Class9_Sub2("Toad Legs", "Gnome delicacy apparently", "eat", 2, 308, false, false, 0, false));
        items.add(new Class9_Sub2("King Worm", "Gnome delicacy apparently", "eat", 2, 309, false, false, 0, false));
        items.add(new Class9_Sub2("Gnome Spice", "Aluft Giannes secret reciepe", "", 2, 310, false, false, 0, false));
        items.add(new Class9_Sub2("Gianne Cook Book", "Aluft Giannes favorite dishes", "read", 2, 299, false, false, 0, false));
        items.add(new Class9_Sub2("Gnomecrunchie", "yum ... smells good", "eat", 2, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Cheese and Tomato Batta", "Smells really good", "eat", 2, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Toad Batta", "actually smells quite good", "eat", 2, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Gnome Batta", "smells like pants", "eat", 2, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Worm Batta", "actually smells quite good", "eat", 2, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Fruit Batta", "actually smells quite good", "eat", 2, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Veg Batta", "well..it looks healthy", "eat", 2, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Chocolate Bomb", "Looks great", "eat", 2, 313, false, false, 0, false));
        items.add(new Class9_Sub2("Vegball", "Looks pretty healthy", "eat", 2, 314, false, false, 0, false));
        items.add(new Class9_Sub2("Worm Hole", "actually smells quite good", "eat", 2, 315, false, false, 0, false));
        items.add(new Class9_Sub2("Tangled Toads Legs", "actually smells quite good", "eat", 2, 316, false, false, 0, false));
        items.add(new Class9_Sub2("Choc Crunchies", "yum ... smells good", "eat", 2, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Worm Crunchies", "actually smells quite good", "eat", 2, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Toad Crunchies", "actually smells quite good", "eat", 2, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Spice Crunchies", "yum ... smells good", "eat", 2, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Crushed Gemstone", "A gemstone that has been smashed", "", 2, 23, false, false, 0xffffff, false));
        items.add(new Class9_Sub2("Blurberry Badge", "an official cocktail maker", "", 2, 317, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Gianne Badge", "an official gianne chef", "", 2, 317, false, false, 65280, false));
        items.add(new Class9_Sub2("Tree Gnome Translation", "Translate the old gnome tounge", "read", 2, 299, false, false, 0, true));
        items.add(new Class9_Sub2("Bark Sample", "A sample from the grand tree", "", 2, 318, false, false, 0, true));
        items.add(new Class9_Sub2("War Ship", "A model of a karamja warship", "play with", 2, 319, false, false, 0, true));
        items.add(new Class9_Sub2("Gloughs Journal", "Glough's private notes", "read", 2, 299, false, false, 0, true));
        items.add(new Class9_Sub2("Invoice", "A note with foreman's timber order", "read", 2, 234, false, false, 0, true));
        items.add(new Class9_Sub2("Ugthanki Kebab", "A strange smelling Kebab made from Ugthanki meat - it doesn't look too good", "eat", 20, 95, false, false, 0, false));
        items.add(new Class9_Sub2("Special Curry", "It's a spicy hot curry", "Eat", 20, 162, false, false, 0xbb4c00, false));
        items.add(new Class9_Sub2("Glough's Key", "Glough left this at anita's", "", 1, 25, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Glough's Notes", "Scribbled notes and diagrams", "read", 2, 234, false, false, 0, true));
        items.add(new Class9_Sub2("Pebble", "The pebble has an inscription", "", 2, 321, false, false, 0, true));
        items.add(new Class9_Sub2("Pebble", "The pebble has an inscription", "", 2, 322, false, false, 0, true));
        items.add(new Class9_Sub2("Pebble", "The pebble has an inscription", "", 2, 323, false, false, 0, true));
        items.add(new Class9_Sub2("Pebble", "The pebble has an inscription", "", 2, 324, false, false, 0, true));
        items.add(new Class9_Sub2("Daconia Rock", "A magicaly crafted stone", "", 40, 73, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Sinister Key", "You get a sense of dread from this key", "", 1, 25, false, false, 0x111111, false));
        items.add(new Class9_Sub2("Muddy Torstol", "I need to clean this", "Clean", 1, 435, false, false, 0, false));
        items.add(new Class9_Sub2("Torstol", "A useful herb", "", 25, 75, false, false, 0, false));
        items.add(new Class9_Sub2("Unfinished Torstol Potion", "I need Jangerberries to finish this Torstol potion", "", 25, 48, false, false, 0xbb7700, false));
        items.add(new Class9_Sub2("Jangerberries", "They don't look very ripe", "eat", 1, 21, false, false, 0x44a000, false));
        items.add(new Class9_Sub2("Fruit Blast", "A cool refreshing fruit mix", "drink", 30, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Blurberry Special", "Looks good..smells strong", "drink", 30, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Wizard Blizzard", "Looks like a strange mix", "drink", 30, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Pineapple Punch", "A fresh healthy fruit mix", "drink", 30, 295, false, false, 0, false));
        items.add(new Class9_Sub2("SGG", "A short green guy..looks good", "drink", 30, 295, false, false, 0, false));
        items.add(new Class9_Sub2("Chocolate Saturday", "A warm creamy alcoholic beverage", "drink", 30, 297, false, false, 0, false));
        items.add(new Class9_Sub2("Drunk Dragon", "A warm creamy alcoholic beverage", "drink", 30, 297, false, false, 0, false));
        items.add(new Class9_Sub2("Cheese and Tomato Batta", "Smells really good", "eat", 120, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Toad Batta", "actually smells quite good", "eat", 120, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Gnome Batta", "smells like pants", "eat", 120, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Worm Batta", "actually smells quite good", "eat", 120, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Fruit Batta", "actually smells quite good", "eat", 120, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Veg Batta", "well..it looks healthy", "eat", 120, 312, false, false, 0, false));
        items.add(new Class9_Sub2("Chocolate Bomb", "Looks great", "eat", 160, 313, false, false, 0, false));
        items.add(new Class9_Sub2("Vegball", "Looks pretty healthy", "eat", 150, 314, false, false, 0, false));
        items.add(new Class9_Sub2("Worm Hole", "actually smells quite good", "eat", 150, 315, false, false, 0, false));
        items.add(new Class9_Sub2("Tangled Toads Legs", "actually smells quite good", "eat", 160, 316, false, false, 0, false));
        items.add(new Class9_Sub2("Choc Crunchies", "yum ... smells good", "eat", 85, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Worm Crunchies", "actually smells quite good", "eat", 85, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Toad Crunchies", "actually smells quite good", "eat", 85, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Spice Crunchies", "yum ... smells good", "eat", 85, 311, false, false, 0, false));
        items.add(new Class9_Sub2("Stone-Plaque", "A stone plaque with carved letters in it", "Read", 5, 236, false, false, 0, true));
        items.add(new Class9_Sub2("Tattered Scroll", "An ancient tattered scroll", "Read", 5, 29, false, false, 255, true));
        items.add(new Class9_Sub2("Crumpled Scroll", "An ancient crumpled scroll", "Read", 5, 29, false, false, 0xc10000, true));
        items.add(new Class9_Sub2("Bervirius Tomb Notes", "Notes taken from the tomb of Bervirius", "Read", 5, 29, false, false, 0xffff00, true));
        items.add(new Class9_Sub2("Zadimus Corpse Corpse", "The remains of Zadimus", "Bury", 1, 237, false, false, 0xeafeae, true));
        items.add(new Class9_Sub2("Potion of Zamorak", "It looks scary", "drink", 25, 48, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Potion of Zamorak", "It looks scary", "drink", 25, 436, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Potion of Zamorak", "It looks scary", "drink", 25, 437, false, false, 0xee9900, false));
        items.add(new Class9_Sub2("Boots", "They're soft and silky", "", 2000, 223, false, true, 0xffaaaa, false));
        items.add(new Class9_Sub2("Boots", "They're soft and silky", "", 2000, 223, false, true, 0xaaffaa, false));
        items.add(new Class9_Sub2("Boots", "They're soft and silky", "", 2000, 223, false, true, 0xaaaaff, false));
        items.add(new Class9_Sub2("Boots", "They're soft and silky", "", 2000, 223, false, true, 0xffffcc, false));
        items.add(new Class9_Sub2("Boots", "They're soft and silky", "", 2000, 223, false, true, 0xccffff, false));
        items.add(new Class9_Sub2("Santa's Hat", "It's a Santa Claus' hat", "", 10, 325, false, true, 0, false));
        items.add(new Class9_Sub2("Locating Crystal", "A magical crystal sphere", "Activate", 100, 199, false, false, 0xc0ffff, true));
        items.add(new Class9_Sub2("Sword Pommel", "An ivory sword pommel", "", 100, 334, false, false, 0xffff80, true));
        items.add(new Class9_Sub2("Bone Shard", "A slender piece of bone", "Look", 1, 238, false, false, 0, true));
        items.add(new Class9_Sub2("Steel Wire", "Useful for crafting items", "", 200, 326, false, false, 0, true));
        items.add(new Class9_Sub2("Rashiliya Corpse", "The remains of the Zombie Queen", "", 1, 239, false, false, 0xffffc0, false));
        items.add(new Class9_Sub2("Rock of Ages Corpse", "The remains of the Rock of Ages", "Bury", 1, 237, false, false, 0xff8080, false));
        items.add(new Class9_Sub2("Reset Crystal", "Helps reset things in game", "Activate", 100, 199, false, false, 0x2c8ca, true));
        items.add(new Class9_Sub2("Bronze Wire", "Useful for crafting items", "", 20, 326, false, false, 0xff6619, true));
        items.add(new Class9_Sub2("Present", "Click to use this on a friend", "", 160, 330, false, false, 0, false));
        items.add(new Class9_Sub2("Gnome Ball", "Lets play", "shoot", 10, 327, false, false, 0, false));
        items.add(new Class9_Sub2("Papyrus", "Used for making notes", "", 9, 282, false, false, 0, true));
        items.add(new Class9_Sub2("A lump of Charcoal", "a lump of cooked coal good for making marks.", "", 45, 73, false, false, 0x202020, true));
        items.add(new Class9_Sub2("Arrow", "linen wrapped around an arrow head", "", 10, 328, false, false, 0, true));
        items.add(new Class9_Sub2("Lit Arrow", "A flamming arrow", "", 10, 329, true, false, 0, true));
        items.add(new Class9_Sub2("Rocks", "A few Large rocks", "", 10, 331, false, false, 0, true));
        items.add(new Class9_Sub2("Paramaya Rest Ticket", "Allows you to rest in the luxurius Paramaya Inn", "", 5, 218, false, false, 0, true));
        items.add(new Class9_Sub2("Ship Ticket", "Allows you passage on the 'Lady of the Waves' ship.", "", 5, 218, false, false, 0x80ffff, true));
        items.add(new Class9_Sub2("Damp Cloth", "It smells as if it's been doused in alcohol", "", 10, 92, false, false, 0, true));
        items.add(new Class9_Sub2("Desert Boots", "Boots made specially for the desert", "", 20, 223, false, true, 0xffffff, false));
        items.add(new Class9_Sub2("Orb of Light", "The orb gives you a safe peaceful feeling", "", 10, 333, false, false, 0, true));
        items.add(new Class9_Sub2("Orb of Light", "The orb gives you a safe peaceful feeling", "", 10, 345, false, false, 0, true));
        items.add(new Class9_Sub2("Orb of Light", "The orb gives you a safe peaceful feeling", "", 10, 346, false, false, 0, true));
        items.add(new Class9_Sub2("Orb of Light", "The orb gives you a safe peaceful feeling", "", 10, 347, false, false, 0, true));
        items.add(new Class9_Sub2("Railing", "A broken metal rod", "", 10, 335, false, false, 0, true));
        items.add(new Class9_Sub2("Randas's Journal", "An old journal with several pages missing", "read", 1, 28, false, false, 0xeeaaaa, true));
        items.add(new Class9_Sub2("Unicorn Horn", "Poor unicorn went splat!", "", 20, 145, false, false, 0, false));
        items.add(new Class9_Sub2("Coat of Arms", "A symbol of truth and all that is good", "", 10, 348, false, false, 0, true));
        items.add(new Class9_Sub2("Coat of Arms", "A symbol of truth and all that is good", "", 10, 336, false, false, 0, true));
        items.add(new Class9_Sub2("Staff of Iban", "It's a slightly magical stick", "", 0x124f8, 337, false, true, 0, false));
        items.add(new Class9_Sub2("Dwarf Brew", "It's a bucket of home made brew", "", 2, 22, false, false, 0xbb7777, true));
        items.add(new Class9_Sub2("Iban's Ashes", "A heap of ashes", "", 2, 23, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("Cat", "She's sleeping..i think!", "", 2, 338, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("A Doll of Iban", "A strange doll made from sticks and cloth", "search", 2, 339, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("Old Journal", "I wonder who wrote this!", "read", 1, 28, false, false, 0xffaaaa, true));
        items.add(new Class9_Sub2("Klank's Gauntlets", "Heavy hand protection", "", 5000, 217, false, true, 0xbbbbbb, false));
        items.add(new Class9_Sub2("Iban's Shadow", "A dark mystical liquid", "", 2, 340, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("Iban's Conscience", "The remains of a dove that died long ago", "", 2, 341, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("Amulet of Othainian", "A strange looking amulet", "", 0, 125, false, true, 0xbb00ff, true));
        items.add(new Class9_Sub2("Amulet of Doomion", "A strange looking amulet", "", 0, 125, false, true, 0xbb00ff, true));
        items.add(new Class9_Sub2("Amulet of Holthion", "A strange looking amulet", "", 0, 125, false, true, 0xbb00ff, true));
        items.add(new Class9_Sub2("Keep Key", "A small prison key", "", 1, 25, false, false, 0xbbbbbb, true));
        items.add(new Class9_Sub2("Bronze Throwing Dart", "A deadly throwing dart with a bronze tip.", "", 2, 231, true, true, 0xff6619, false));
        items.add(new Class9_Sub2("Prototype Throwing Dart", "A proto type of a deadly throwing dart.", "", 70, 231, true, false, 0xff6619, true));
        items.add(new Class9_Sub2("Iron Throwing Dart", "A deadly throwing dart with an iron tip.", "", 5, 231, true, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Full Water Skin", "A skinful of water", "", 30, 343, false, false, 0x804000, false));
        items.add(new Class9_Sub2("Lens Mould", "A peculiar mould in the shape of a disc", "", 10, 342, false, false, 0, true));
        items.add(new Class9_Sub2("Lens", "A perfectly formed glass disc", "", 10, 344, false, false, 0, true));
        items.add(new Class9_Sub2("Desert Robe", "Cool light robe to wear in the desert", "", 500, 88, false, true, 0xffffff, false));
        items.add(new Class9_Sub2("Desert Shirt", "A light cool shirt to wear in the desert", "", 500, 87, false, true, 0xffffff, false));
        items.add(new Class9_Sub2("Metal Key", "A large metalic key.", "", 1, 25, false, false, 0xc0c0c0, true));
        items.add(new Class9_Sub2("Slaves Robe Bottom", "A dirty desert skirt", "", 500, 88, false, true, 0x808000, false));
        items.add(new Class9_Sub2("Slaves Robe Top", "A dirty desert shirt", "", 500, 87, false, true, 0x808000, false));
        items.add(new Class9_Sub2("Steel Throwing Dart", "A deadly throwing dart with a steel tip.", "", 20, 231, true, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Astrology Book", "A book on Astrology in runescape", "Read", 2, 28, false, false, 0, false));
        items.add(new Class9_Sub2("Unholy Symbol Mould", "use this with silver in a furnace", "", 200, 349, false, false, 0, false));
        items.add(new Class9_Sub2("Unholy Symbol of Zamorak", "this needs stringing", "", 200, 350, false, false, 0, false));
        items.add(new Class9_Sub2("Unblessed Unholy Symbol of Zamorak", "this needs blessing", "", 200, 351, false, true, 0, false));
        items.add(new Class9_Sub2("Unholy Symbol of Zamorak", "a symbol indicating allegiance to Zamorak", "", 200, 351, false, true, 0, false));
        items.add(new Class9_Sub2("Shantay Desert Pass", "Allows you into the desert through the Shantay pass worth 5 gold.", "", 5, 218, true, false, 0xc7a221, false));
        items.add(new Class9_Sub2("Staff of Iban", "The staff is damaged", "wield", 15, 337, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Cannon Base", "bang", "set down", 0x30d40, 352, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Cannon Stand", "bang", "", 0x30d40, 353, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Cannon Barrels", "bang", "", 0x30d40, 354, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Cannon Furnace", "bang", "", 0x30d40, 355, false, false, 0, false));
        items.add(new Class9_Sub2("Fingernails", "Ugh gross!", "", 0, 356, false, false, 0, true));
        items.add(new Class9_Sub2("Powering crystal1", "An intricately cut gemstone", "", 0, 357, false, false, 0xffff33, true));
        items.add(new Class9_Sub2("Mining Barrel", "A roughly constructed barrel for carrying rock.", "", 100, 358, false, false, 65280, true));
        items.add(new Class9_Sub2("Ana in a Barrel", "A roughly constructed barrel with an Ana in it!", "Look", 100, 359, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("Stolen Gold", "I wish I could spend it", "", 300, 79, false, false, 0xffcc4c, true));
        items.add(new Class9_Sub2("Multi Cannon Ball", "A heavy metal spiked ball", "", 10, 332, true, false, 0, false));
        items.add(new Class9_Sub2("Railing", "A metal railing replacement", "", 10, 335, false, false, 0, true));
        items.add(new Class9_Sub2("Ogre Tooth", "big sharp and nasty", "", 0, 360, false, false, 0, true));
        items.add(new Class9_Sub2("Ogre Relic", "A grotesque symbol of the ogres", "", 0, 361, false, false, 0, true));
        items.add(new Class9_Sub2("Skavid Map", "A map of cave locations", "", 0, 362, false, false, 0, true));
        items.add(new Class9_Sub2("Dwarf Remains", "The remains of a dwarf savaged by goblins", "", 1, 237, false, false, 0xff8080, true));
        items.add(new Class9_Sub2("Key", "A key for a chest", "", 1, 25, false, false, 0xff9900, true));
        items.add(new Class9_Sub2("Ogre Relic Part", "A piece of a statue", "", 0, 363, false, false, 0, true));
        items.add(new Class9_Sub2("Ogre Relic Part", "A piece of a statue", "", 0, 364, false, false, 0, true));
        items.add(new Class9_Sub2("Ogre Relic Part", "A piece of a statue", "", 0, 365, false, false, 0, true));
        items.add(new Class9_Sub2("Ground Bat Bones", "The ground bones of a bat", "", 20, 23, false, false, 0xeebb50, false));
        items.add(new Class9_Sub2("Unfinished Shaman Potion", "I need another ingredient to finish the shaman potion", "", 3, 48, false, false, 56576, false));
        items.add(new Class9_Sub2("Ogre Potion", "A strange liquid", "", 120, 48, false, false, 0xccff66, true));
        items.add(new Class9_Sub2("Magic Ogre Potion", "A strange liquid that bubbles with power", "", 120, 48, false, false, 0x66ffcc, true));
        items.add(new Class9_Sub2("Tool Kit", "These could be handy!", "", 120, 366, false, false, 0xeedddd, true));
        items.add(new Class9_Sub2("Nulodion's Notes", "Construction notes for dwarf cannon ammo", "read", 1, 234, false, false, 0, true));
        items.add(new Class9_Sub2("Cannon Ammo Mould", "Used to make cannon ammo", "", 5, 367, false, false, 0, false));
        items.add(new Class9_Sub2("Tenti Pineapple", "The most delicious in the whole of Kharid", "", 1, 124, false, false, 0, true));
        items.add(new Class9_Sub2("Bedobin Copy Key", "A copy of a key for the captains of the mining camps chest", "", 20, 25, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Technical Plans", "Very technical looking plans for making a thrown weapon of some sort", "Read", 500, 218, false, false, 0xc0c0c0, true));
        items.add(new Class9_Sub2("Rock Cake", "Yum... I think!", "eat", 0, 368, false, false, 0, true));
        items.add(new Class9_Sub2("Bronze Dart Tips", "Dangerous looking dart tips - need feathers for flight", "", 1, 369, true, false, 0xff6619, false));
        items.add(new Class9_Sub2("Iron Dart Tips", "Dangerous looking dart tips - need feathers for flight", "", 3, 369, true, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Dart Tips", "Dangerous looking dart tips - need feathers for flight", "", 9, 369, true, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Dart Tips", "Dangerous looking dart tips - need feathers for flight", "", 25, 369, true, false, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Dart Tips", "Dangerous looking dart tips - need feathers for flight", "", 65, 369, true, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Dart Tips", "Dangerous looking dart tips - need feathers for flight", "", 350, 369, true, false, 65535, false));
        items.add(new Class9_Sub2("Mithril Throwing Dart", "A deadly throwing dart with a mithril tip.", "", 50, 231, true, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Throwing Dart", "A deadly throwing dart with an adamantite tip.", "", 130, 231, true, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Throwing Dart", "A deadly throwing dart with a runite tip.", "", 700, 231, true, true, 65535, false));
        items.add(new Class9_Sub2("Prototype Dart Tip", "Dangerous looking dart tip - needs feathers for flight", "", 1, 207, true, false, 0xff6619, false));
        items.add(new Class9_Sub2("Info Document", "read to access variable choices", "read", 2, 234, false, false, 0, true));
        items.add(new Class9_Sub2("Instruction Manual", "An old note book", "read", 1, 28, false, false, 0xffaaaa, true));
        items.add(new Class9_Sub2("Unfinished Potion", "I need another ingredient to finish this potion", "", 3, 48, false, false, 0x66ff66, false));
        items.add(new Class9_Sub2("Iron Throwing Knife", "A finely balanced knife", "", 6, 80, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Bronze Throwing Knife", "A finely balanced knife", "", 2, 80, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Steel Throwing Knife", "A finely balanced knife", "", 21, 80, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Throwing Knife", "A finely balanced knife", "", 54, 80, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Throwing Knife", "A finely balanced knife", "", 133, 80, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Throwing Knife", "A finely balanced knife", "", 333, 80, false, true, 65535, false));
        items.add(new Class9_Sub2("Black Throwing Knife", "A finely balanced knife", "", 37, 80, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Water Skin Mostly Full", "A half full skin of water", "", 27, 343, false, false, 0x804000, false));
        items.add(new Class9_Sub2("Water Skin Mostly Empty", "A half empty skin of water", "", 24, 343, false, false, 0x804000, false));
        items.add(new Class9_Sub2("Water Skin Mouthful Left", "A waterskin with a mouthful of water left", "", 18, 343, false, false, 0x804000, false));
        items.add(new Class9_Sub2("Empty Water Skin", "A completely empty waterskin", "", 15, 343, false, false, 0x804000, false));
        items.add(new Class9_Sub2("Nightshade", "Deadly!", "eat", 30, 370, false, false, 0, true));
        items.add(new Class9_Sub2("Shaman Robe", "This has been left by one of the dead ogre shaman", "search", 40, 87, false, false, 0xa06040, true));
        items.add(new Class9_Sub2("Iron Spear", "An iron tipped spear", "", 13, 283, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Spear", "A steel tipped spear", "", 46, 283, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Spear", "A mithril tipped spear", "", 119, 283, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Spear", "An adamantite tipped spear", "", 293, 283, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Spear", "A rune tipped spear", "", 1000, 283, false, true, 56797, false));
        items.add(new Class9_Sub2("Cat", "it's fluffs", "Stroke", 2, 338, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("Seasoned Sardine", "They don't smell any better", "", 10, 165, false, false, 0xa0ffa0, false));
        items.add(new Class9_Sub2("Kittens", "purrr", "", 2, 372, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("Kitten", "purrr", "stroke", 2, 371, false, false, 0xaaaaaa, true));
        items.add(new Class9_Sub2("Wrought Iron Key", "This key clears unlocks a very sturdy gate of some sort.", "", 1, 25, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Cell Door Key", "A roughly hewn key", "", 1, 25, false, false, 16384, true));
        items.add(new Class9_Sub2("A Free Shantay Disclaimer", "Very important information.", "Read", 1, 218, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Doogle leaves", "Small sweet smelling leaves", "", 2, 298, false, false, 0, false));
        items.add(new Class9_Sub2("Raw Ugthanki Meat", "I need to cook this first", "", 2, 60, false, false, 0xff80c0, false));
        items.add(new Class9_Sub2("Tasty Ugthanki Kebab", "A fresh Kebab made from Ugthanki meat", "eat", 20, 320, false, false, 0, false));
        items.add(new Class9_Sub2("Cooked Ugthanki Meat", "Freshly cooked Ugthanki meat", "Eat", 5, 60, false, false, 0xcc6633, false));
        items.add(new Class9_Sub2("Uncooked Pitta Bread", "I need to cook this.", "", 4, 152, false, false, 0, false));
        items.add(new Class9_Sub2("Pitta Bread", "Mmmm I need to add some other ingredients yet.", "", 10, 152, false, false, 0xffdcb8, false));
        items.add(new Class9_Sub2("Tomato Mixture", "A mixture of tomatoes in a bowl", "", 3, 162, false, false, 0xff0000, false));
        items.add(new Class9_Sub2("Onion Mixture", "A mixture of onions in a bowl", "", 3, 162, false, false, 0xffff00, false));
        items.add(new Class9_Sub2("Onion and Tomato Mixture", "A mixture of onions and tomatoes in a bowl", "", 3, 162, false, false, 0xff8040, false));
        items.add(new Class9_Sub2("Onion and Tomato and Ugthanki Mix", "A mixture of onions and tomatoes and Ugthanki meat in a bowl", "", 3, 162, false, false, 0x5b3722, false));
        items.add(new Class9_Sub2("Burnt Pitta Bread", "Urgh - it's all burnt", "", 1, 152, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Panning Tray", "used for panning gold", "search", 1, 373, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Panning Tray", "this tray contains gold nuggets", "take gold", 1, 374, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Panning Tray", "this tray contains mud", "search", 1, 375, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Rock Pick", "a sharp pick for cracking rocks", "", 1, 376, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Specimen Brush", "stiff brush for cleaning specimens", "", 1, 377, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Specimen Jar", "a jar for holding soil samples", "", 1, 378, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Rock Sample", "A rock sample", "", 1, 379, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Gold Nuggets", "Real gold pieces!", "", 1, 380, true, false, 0x400000, false));
        items.add(new Class9_Sub2("Cat", "looks like a healthy one", "", 1, 381, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Scrumpled Piece of Paper", "A piece of paper with barely legible writing - looks like a recipe!", "Read", 10, 218, false, false, 0xf8fa98, false));
        items.add(new Class9_Sub2("Digsite Info", "IAN ONLY", "read", 63, 382, false, false, 0, false));
        items.add(new Class9_Sub2("Poisoned Bronze Throwing Dart", "A venomous throwing dart with a bronze tip.", "", 2, 384, true, true, 0xff6619, false));
        items.add(new Class9_Sub2("Poisoned Iron Throwing Dart", "A venomous throwing dart with an iron tip.", "", 5, 384, true, true, 0xff6619, false));
        items.add(new Class9_Sub2("Poisoned Steel Throwing Dart", "A venomous throwing dart with a steel tip.", "", 20, 384, true, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Poisoned Mithril Throwing Dart", "A venomous throwing dart with a mithril tip.", "", 50, 384, true, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Poisoned Adamantite Throwing Dart", "A venomous throwing dart with an adamantite tip.", "", 130, 384, true, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Poisoned Rune Throwing Dart", "A deadly venomous dart with a runite tip.", "", 700, 384, true, true, 65535, false));
        items.add(new Class9_Sub2("Poisoned Bronze Throwing Knife", "A finely balanced knife with a coating of venom", "", 2, 385, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Poisoned Iron Throwing Knife", "A finely balanced knife with a coating of venom", "", 6, 385, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Poisoned Steel Throwing Knife", "A finely balanced knife with a coating of venom", "", 21, 385, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Poisoned Mithril Throwing Knife", "A finely balanced knife with a coating of venom", "", 54, 385, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Poisoned Black Throwing Knife", "A finely balanced knife with a coating of venom", "", 37, 385, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Poisoned Adamantite Throwing Knife", "A finely balanced knife with a coating of venom", "", 133, 385, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Poisoned Rune Throwing Knife", "A finely balanced knife with a coating of venom", "", 333, 385, false, true, 65535, false));
        items.add(new Class9_Sub2("Poisoned Bronze Spear", "A bronze tipped spear with added venom ", "", 4, 383, false, true, 0xff6619, false));
        items.add(new Class9_Sub2("Poisoned Iron Spear", "An iron tipped spear with added venom", "", 13, 383, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Poisoned Steel Spear", "A steel tipped spear with added venom", "", 46, 383, false, true, 0xeeeeee, false));
        items.add(new Class9_Sub2("Poisoned Mithril Spear", "A mithril tipped spear with added venom", "", 119, 383, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Poisoned Adamantite Spear", "An adamantite tipped spear with added venom", "", 293, 383, false, true, 0xb2cc99, false));
        items.add(new Class9_Sub2("Poisoned Rune Spear", "A rune tipped spear with added venom", "", 1000, 383, false, true, 56797, false));
        items.add(new Class9_Sub2("Book of Experimental Chemistry", "A book on experiments with volatile chemicals", "read", 1, 28, false, false, 0xffaaaa, true));
        items.add(new Class9_Sub2("Level 1 Certificate", "A Certificate of education", "read", 1, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Level 2 Certificate", "A Certificate of education", "read", 1, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Level 3 Certificate", "A Certificate of education", "read", 1, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Trowel", "A small device for digging", "", 1, 386, false, false, 0, false));
        items.add(new Class9_Sub2("Stamped Letter of Recommendation", "A stamped scroll with a recommendation on it", "", 1, 402, false, false, 0, true));
        items.add(new Class9_Sub2("Unstamped Letter of Recommendation", "I hereby recommend this student to undertake the Varrock City earth sciences exams", "", 5, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Rock Sample", "A rock sample", "", 1, 388, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Rock Sample", "A rock sample", "", 1, 389, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Cracked Rock Sample", "It's been cracked open", "", 1, 387, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Belt Buckle", "been here some time", "", 1, 390, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Powering Crystal2", "An intricately cut gemstone", "", 0, 357, false, false, 0xff66ff, true));
        items.add(new Class9_Sub2("Powering Crystal3", "An intricately cut gemstone", "", 0, 357, false, false, 0x66ffff, true));
        items.add(new Class9_Sub2("Powering Crystal4", "An intricately cut gemstone", "", 0, 357, false, false, 0x33ff33, true));
        items.add(new Class9_Sub2("Old Boot", "that's been here some time", "", 1, 391, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Bunny Ears", "Get another from the clothes shop if you die", "", 1, 392, false, true, 0x400000, false));
        items.add(new Class9_Sub2("Damaged Armour", "that's been here some time", "", 1, 393, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Damaged Armour", "that's been here some time", "", 1, 394, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Rusty Sword", "that's been here some time", "", 1, 395, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Ammonium Nitrate", "An acrid chemical", "", 20, 23, false, false, 0xffffcc, true));
        items.add(new Class9_Sub2("Nitroglycerin", "A strong acidic formula", "", 2, 48, false, false, 0xff9900, true));
        items.add(new Class9_Sub2("Old Tooth", "a large single tooth", "", 0, 360, false, false, 0, false));
        items.add(new Class9_Sub2("Radimus Scrolls", "Scrolls that Radimus gave you", "Read Scrolls", 5, 29, false, false, 0x808080, true));
        items.add(new Class9_Sub2("Chest Key", "A small key for a chest", "", 1, 25, false, false, 0xffcc00, false));
        items.add(new Class9_Sub2("Broken Arrow", "that's been here some time", "", 1, 396, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Buttons", "they've been here some time", "", 1, 397, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Broken Staff", "that's been here some time", "", 1, 398, false, false, 0x400000, false));
        items.add(new Class9_Sub2("vase", "An old vase", "", 1, 279, false, false, 0, false));
        items.add(new Class9_Sub2("Ceramic Remains", "some ancient pottery", "", 1, 399, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Broken Glass", "smashed glass", "", 0, 259, false, false, 0, true));
        items.add(new Class9_Sub2("Unidentified Powder", "Who knows what this is for?", "", 20, 23, false, false, 0xffffcc, true));
        items.add(new Class9_Sub2("Machette", "A purpose built tool for cutting through thick jungle.", "", 40, 432, false, true, 0x808080, true));
        items.add(new Class9_Sub2("Scroll", "A letter written by the expert", "read", 5, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Stone Tablet", "some ancient script is engraved on here", "read", 1, 400, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Talisman of Zaros", "an ancient item", "", 1, 401, false, false, 0x400000, true));
        items.add(new Class9_Sub2("Explosive Compound", "A dark mystical powder", "", 2, 48, false, false, 51, true));
        items.add(new Class9_Sub2("Bull Roarer", "A sound producing instrument - it may attract attention", "Swing", 1, 418, false, false, 0x733d06, true));
        items.add(new Class9_Sub2("Mixed Chemicals", "A pungent mix of 2 chemicals", "", 2, 48, false, false, 0xffff99, true));
        items.add(new Class9_Sub2("Ground Charcoal", "Powdered charcoal!", "", 20, 23, false, false, 0x222222, true));
        items.add(new Class9_Sub2("Mixed Chemicals", "A pungent mix of 3 chemicals", "", 2, 48, false, false, 0xcc9900, true));
        items.add(new Class9_Sub2("Spell Scroll", "A magical scroll", "read", 5, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Yommi Tree Seed", "A magical seed that grows into a Yommi tree - these need to be germinated", "Inspect", 200, 270, true, false, 65280, true));
        items.add(new Class9_Sub2("Totem Pole", "A well crafted totem pole", "", 500, 403, false, false, 65280, true));
        items.add(new Class9_Sub2("Dwarf Cannon Base", "bang", "set down", 0x30d40, 352, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Cannon Stand", "bang", "", 0x30d40, 353, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Cannon Barrels", "bang", "", 0x30d40, 354, false, false, 0, false));
        items.add(new Class9_Sub2("Dwarf Cannon Furnace", "bang", "", 0x249f0, 355, false, false, 0, false));
        items.add(new Class9_Sub2("Golden Bowl", "A specially made bowl constructed out of pure gold", "", 1000, 404, false, false, 0, true));
        items.add(new Class9_Sub2("Golden Bowl with Pure Water", "A golden bowl filled with pure water", "", 1000, 405, false, false, 0x80ffff, true));
        items.add(new Class9_Sub2("Raw Manta Ray", "A rare catch!", "", 500, 406, false, false, 255, false));
        items.add(new Class9_Sub2("Manta Ray", "A rare catch!", "eat", 500, 407, false, false, 255, false));
        items.add(new Class9_Sub2("Raw Sea Turtle", "A rare catch!", "", 500, 408, false, false, 255, false));
        items.add(new Class9_Sub2("Sea Turtle", "Tasty!", "eat", 500, 409, false, false, 255, false));
        items.add(new Class9_Sub2("Annas Silver Necklace", "A necklace coated with silver", "", 1, 24, false, true, 0, true));
        items.add(new Class9_Sub2("Bobs Silver Teacup", "A tea cup coated with silver", "", 1, 227, false, false, 0, true));
        items.add(new Class9_Sub2("Carols Silver Bottle", "A little bottle coated with silver", "", 1, 104, false, false, 0, true));
        items.add(new Class9_Sub2("Davids Silver Book", "An ornamental book coated with silver", "", 1, 28, false, false, 0, true));
        items.add(new Class9_Sub2("Elizabeths Silver Needle", "An ornamental needle coated with silver", "", 1, 38, false, false, 0, true));
        items.add(new Class9_Sub2("Franks Silver Pot", "A small pot coated with silver", "", 1, 61, false, false, 0, true));
        items.add(new Class9_Sub2("Thread", "A piece of red thread discovered at the scene of the crime", "", 1, 208, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("Thread", "A piece of green thread discovered at the scene of the crime", "", 1, 208, false, false, 65280, true));
        items.add(new Class9_Sub2("Thread", "A piece of blue thread discovered at the scene of the crime", "", 1, 208, false, false, 255, true));
        items.add(new Class9_Sub2("Flypaper", "Sticky paper for catching flies", "", 1, 415, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Murder Scene Pot", "The pot has a sickly smell of poison mixed with wine", "", 1, 61, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("A Silver Dagger", "Dagger Found at crime scene", "", 1, 80, false, true, 0, true));
        items.add(new Class9_Sub2("Murderers Fingerprint", "An impression of the murderers fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Annas Fingerprint", "An impression of Annas fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Bobs Fingerprint", "An impression of Bobs fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Carols Fingerprint", "An impression of Carols fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Davids Fingerprint", "An impression of Davids fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Elizabeths Fingerprint", "An impression of Elizabeths fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Franks Fingerprint", "An impression of Franks fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Zamorak Cape", "A cape from the almighty zamorak", "", 0x249f0, 59, false, true, 0xff0000, false));
        items.add(new Class9_Sub2("Saradomin Cape", "A cape from the almighty saradomin", "", 0x249f0, 59, false, true, 0x4040ee, false));
        items.add(new Class9_Sub2("Guthix Cape", "A cape from the almighty guthix", "", 0x249f0, 59, false, true, 0x40cc40, false));
        items.add(new Class9_Sub2("Staff of Zamorak", "It's a stick of the gods", "", 0x249f0, 337, false, true, 0, false));
        items.add(new Class9_Sub2("Staff of Guthix", "It's a stick of the gods", "", 0x249f0, 85, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("Staff of Saradomin", "It's a stick of the gods", "", 0x249f0, 414, false, true, 0x99b2cc, false));
        items.add(new Class9_Sub2("A Chunk of Crystal", "A reddish crystal fragment - it looks like it formed a shape at one time.", "", 2000, 410, false, false, 0, true));
        items.add(new Class9_Sub2("A Lump of Crystal", "A reddish crystal fragment - it looks like it formed a shape at one time.", "", 2000, 411, false, false, 0, true));
        items.add(new Class9_Sub2("A Hunk of Crystal", "A reddish crystal fragment - it looks like it formed a shape at one time.", "", 2000, 412, false, false, 0, true));
        items.add(new Class9_Sub2("A Red Crystal", "A heart shaped red crystal ", "Inspect", 2000, 413, false, false, 0, true));
        items.add(new Class9_Sub2("Unidentified Fingerprint", "An impression of the murderers fingerprint", "", 1, 416, false, false, 0xdddddd, true));
        items.add(new Class9_Sub2("Annas Silver Necklace", "A silver necklace coated with flour", "", 1, 24, false, true, 0, true));
        items.add(new Class9_Sub2("Bobs Silver Teacup", "A silver tea cup coated with flour", "", 1, 227, false, false, 0, true));
        items.add(new Class9_Sub2("Carols Silver Bottle", "A little silver bottle coated with flour", "", 1, 104, false, false, 0, true));
        items.add(new Class9_Sub2("Davids Silver Book", "An ornamental silver book coated with flour", "", 1, 28, false, false, 0, true));
        items.add(new Class9_Sub2("Elizabeths Silver Needle", "An ornamental silver needle coated with flour", "", 1, 38, false, false, 0, true));
        items.add(new Class9_Sub2("Franks Silver Pot", "A small silver pot coated with flour", "", 1, 61, false, false, 0, true));
        items.add(new Class9_Sub2("A Silver Dagger", "Dagger Found at crime scene coated with flour", "", 1, 80, false, true, 0, true));
        items.add(new Class9_Sub2("A Glowing Red Crystal", "A glowing heart shaped red crystal - great magic must be present in this item", "", 2000, 419, false, false, 0, true));
        items.add(new Class9_Sub2("Unidentified Liquid", "A strong acidic formula", "", 2, 48, false, false, 0xff9900, true));
        items.add(new Class9_Sub2("Radimus Scrolls", "Mission briefing and the completed map of Karamja - Sir Radimus will be pleased...", "Read Scrolls", 5, 29, false, false, 0x808080, true));
        items.add(new Class9_Sub2("Robe", "A worn robe", "", 15, 87, false, true, 255, false));
        items.add(new Class9_Sub2("Armour", "An unusually red armour", "", 40, 118, false, false, 0xcc0000, true));
        items.add(new Class9_Sub2("Dagger", "Short but pointy", "", 35, 80, false, true, 0xeedddd, false));
        items.add(new Class9_Sub2("Eye Patch", "It makes me look very piratical", "", 2, 198, false, true, 0, false));
        items.add(new Class9_Sub2("Booking of Binding", "An ancient tome on Demonology", "read", 1, 28, false, false, 0xeeaaaa, true));
        items.add(new Class9_Sub2("Holy Water Vial", "A deadly potion against evil kin", "Throw", 3, 48, false, true, 0x99b6b6, true));
        items.add(new Class9_Sub2("Enchanted Vial", "This enchanted vial is empty - but is ready for magical liquids.", "", 200, 144, false, false, 0xfdffdd, true));
        items.add(new Class9_Sub2("Scribbled Notes", "It looks like a page ripped from a book", "Read", 20, 427, false, false, 0x808000, true));
        items.add(new Class9_Sub2("Scrawled Notes", "It looks like a page ripped from a book", "Read", 20, 427, false, false, 0xd6a35c, true));
        items.add(new Class9_Sub2("Scatched Notes", "It looks like a page ripped from a book", "Read", 20, 427, false, false, 0xb5ba45, true));
        items.add(new Class9_Sub2("Shamans Tome", "An ancient tome on various subjects...", "read", 1, 299, false, false, 0xeeaaaa, true));
        items.add(new Class9_Sub2("Edible Seaweed", "slightly damp seaweed", "eat", 2, 203, false, false, 0, false));
        items.add(new Class9_Sub2("Rough Sketch of a Bowl", "A roughly sketched picture of a bowl made from metal", "Read", 5, 29, false, false, 0, true));
        items.add(new Class9_Sub2("Burnt Manta Ray", "oops!", "", 500, 430, false, false, 255, false));
        items.add(new Class9_Sub2("Burnt Sea Turtle", "oops!", "", 500, 431, false, false, 255, false));
        items.add(new Class9_Sub2("Cut Reed Plant", "A narrow long tube - it might be useful for something", "", 2, 202, false, false, 65280, true));
        items.add(new Class9_Sub2("Magical Fire Pass", "A pass which allows you to cross the flaming walls into the Flaming Octagon", "", 1, 29, false, false, 0xff0000, true));
        items.add(new Class9_Sub2("Snakes Weed Solution", "Snakes weed in water - part of a potion", "", 1, 48, false, false, 0x80ff80, true));
        items.add(new Class9_Sub2("Ardrigal Solution", "Ardrigal herb in water - part of a potion", "", 1, 48, false, false, 0x800000, true));
        items.add(new Class9_Sub2("Gujuo Potion", "A potion to help against fear of the supernatural", "Drink", 1, 48, false, false, 0x804040, true));
        items.add(new Class9_Sub2("Germinated Yommi Tree Seed", "A magical seed that grows into a Yommi tree - these have been germinated.", "Inspect", 200, 270, true, false, 65280, true));
        items.add(new Class9_Sub2("Dark Dagger", "An unusual looking dagger made of dark shiny obsidian", "", 91, 420, false, true, 0, true));
        items.add(new Class9_Sub2("Glowing Dark Dagger", "An unusual looking dagger made of dark shiny obsidian - it has an unnatural glow .", "", 91, 421, false, true, 0, true));
        items.add(new Class9_Sub2("Holy Force Spell", "A powerful incantation - it affects spirits of the underworld", "Cast", 1, 423, false, false, 0, true));
        items.add(new Class9_Sub2("Iron Pickaxe", "Used for mining", "", 140, 72, false, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Steel Pickaxe", "Requires level 6 mining to use", "", 500, 72, false, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Mithril Pickaxe", "Requires level 21 mining to use", "", 1300, 72, false, false, 0x99b2cc, false));
        items.add(new Class9_Sub2("Adamantite Pickaxe", "Requires level 31 mining to use", "", 3200, 72, false, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Rune Pickaxe", "Requires level 41 mining to use", "", 32000, 72, false, false, 65535, false));
        items.add(new Class9_Sub2("Sleeping Bag", "Not as comfy as a bed but better than nothing", "sleep", 30, 422, false, false, 0, false));
        items.add(new Class9_Sub2("Blue Wizards Hat", "An ancient wizards hat.", "", 2, 86, false, true, 255, false));
        items.add(new Class9_Sub2("Gilded Totem Pole", "A well crafted totem pole - given to you as a gift from Gujuo", "Inspect", 20, 403, false, false, 65280, true));
        items.add(new Class9_Sub2("Blessed Golden Bowl", "A specially made bowl constructed out of pure gold - it looks magical somehow", "", 1000, 404, false, false, 0, true));
        items.add(new Class9_Sub2("Blessed Golden Bowl with Pure Water", "A golden bowl filled with pure water - it looks magical somehow", "", 1000, 405, false, false, 0x80ffff, true));
        items.add(new Class9_Sub2("Raw Oomlie Meat", "Raw meat from the Oomlie bird", "", 10, 60, false, false, 0xff8c33, false));
        items.add(new Class9_Sub2("Cooked Oomlie Meat Parcel", "Deliciously cooked Oomlie meat in a palm leaf pouch.", "eat", 35, 433, false, false, 0xcc6633, false));
        items.add(new Class9_Sub2("Dragon Bone Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Limpwurt Root Certificate", "Exchangable at Catherby for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Prayer Potion Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0x30ee99, false));
        items.add(new Class9_Sub2("Super Attack Potion Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0x3030ee, false));
        items.add(new Class9_Sub2("Super Defense Potion Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0xeeb630, false));
        items.add(new Class9_Sub2("Super Strength Potion Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0xeeeeee, false));
        items.add(new Class9_Sub2("Half Dragon Square Shield", "The Right Half of an ancient and powerful looking Dragon Square shield.", "", 0x7a120, 425, false, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Half Dragon Square Shield", "Left Half of an ancient and powerful looking Dragon Square shield.", "", 0x1adb0, 424, false, false, 0xeedddd, false));
        items.add(new Class9_Sub2("Dragon Square Shield", "An ancient and powerful looking Dragon Square shield.", "", 0x4c4b40, 426, false, true, 0xce0000, false));
        items.add(new Class9_Sub2("Palm Tree Leaf", "A thick green plam leaf - natives use this to cook meat in", "", 5, 428, false, false, 0, false));
        items.add(new Class9_Sub2("Raw Oomlie Meat Parcel", "Oomlie meat in a palm leaf pouch - just needs to be cooked.", "", 16, 429, false, false, 0xff8c33, false));
        items.add(new Class9_Sub2("Burnt Oomlie Meat Parcel", "Oomlie meat in a palm leaf pouch - it's burnt.", "", 1, 429, false, false, 0x400000, false));
        items.add(new Class9_Sub2("Bailing Bucket", "It's a water tight bucket", "", 10, 22, false, false, 0x101010, false));
        items.add(new Class9_Sub2("Plank", "Damaged remains of the ship", "", 1, 135, false, false, 0, false));
        items.add(new Class9_Sub2("Arcenia Root", "the root of an arcenia plant", "", 7, 101, false, false, 0, true));
        items.add(new Class9_Sub2("Display Tea", "A nice cup of tea - for display only", "", 10, 227, false, false, 0, false));
        items.add(new Class9_Sub2("Blessed Golden Bowl with Plain Water", "A golden bowl filled with plain water", "Empty", 1000, 405, false, false, 0x80ffff, true));
        items.add(new Class9_Sub2("Golden Bowl with Plain Water", "A golden bowl filled with plain water", "Empty", 1000, 405, false, false, 0x80ffff, true));
        items.add(new Class9_Sub2("Cape of Legends", "A beautiful cape", "", 5000, 59, false, true, 0xffffff, false));
        items.add(new Class9_Sub2("Scythe", "Looks deadly.", "", 15, 434, false, true, 0, false));
        items.add(new Class9_Sub2("Candy Cane", "A powerful Christmas Candy Cane weapon", "", 10, 442, false, true, 0, false));
        items.add(new Class9_Sub2("Gingerbread Man", "Delicious sugar cookie!", "Eat", 10, 439, false, false, 0, false));
        items.add(new Class9_Sub2("Christmas Tree Cookie", "Delicious sugar cookie!", "Eat", 10, 440, false, false, 0, false));
        items.add(new Class9_Sub2("Santa Cookie", "Delicious sugar cookie!", "Eat", 10, 441, false, false, 0, false));
        items.add(new Class9_Sub2("Party Hat", "Party!!!", "", 2, 189, false, true, 0x303030, false));
        items.add(new Class9_Sub2("RSCEmulation Subscription Card", "This allows you to subscribe your account for 30 days!", "", 5, 180, false, false, 0x404040, false));
        items.add(new Class9_Sub2("Christmas Cracker", "Use on another player to pull it", "", 1, 188, false, false, 0xff333333, false));
        items.add(new Class9_Sub2("Air-Rune", "Used especially for War Zone", "", 4, 32, true, false, 0, false));
        items.add(new Class9_Sub2("Fire-Rune", "Used especially for War Zone", "", 4, 30, true, false, 0, false));
        items.add(new Class9_Sub2("Death-Rune", "Used especially for War Zone", "", 500, 37, true, false, 0, false));
        items.add(new Class9_Sub2("Blood-Rune", "Used especially for War Zone", "", 1500, 200, true, false, 0, false));
        items.add(new Class9_Sub2("Shark", "Used especially for War Zone", "Eat", 0, 185, false, false, 0xb06000, false));
        items.add(new Class9_Sub2("Swordfish", "Used especially for War Zone", "Eat", 350, 168, false, false, 0xc070c0, false));
        items.add(new Class9_Sub2("Strength Potion Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0xeeee30, false));
        items.add(new Class9_Sub2("Ranging Potion Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0x30b6ee, false));
        items.add(new Class9_Sub2("Snape Grass Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("White Berries Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Eye of Newt Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Ranarr Weed Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Irit Leaf Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Kwuarm Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Cadantine Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Tarromin Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Adamantite Ore Certificate", "Exchangable at Draynor Market for 5", "", 10, 180, true, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Runite Ore Certificate", "Exchangable at Draynor Market for 5", "", 10, 180, true, false, 56797, false));
        items.add(new Class9_Sub2("Adamantite Bar Certificate", "Exchangable at Draynor Market for 5", "", 10, 180, true, false, 0xb2cc99, false));
        items.add(new Class9_Sub2("Runite Bar Certificate", "Exchangable at Draynor Market for 5", "", 10, 180, true, false, 56797, false));
        items.add(new Class9_Sub2("Vial Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0xaaddff, false));
        items.add(new Class9_Sub2("Magic Logs Certificate", "Exchangable at Ardougne for 5", "", 45, 180, true, false, 0xb06000, false));
        items.add(new Class9_Sub2("Pussy Magnet", "Kryptix's weapon of choice", "", 3, 184, false, false, 0, false));
        items.add(new Class9_Sub2("Flax Certificate", "Exchangable at Seers Village for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Bow String Certificate", "Exchangable at Seers Village for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Big Bone Certificate", "Exchangable at Yanille for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Oak Logs Certificate", "Exchangable at Ardougne for 5", "", 10, 180, true, false, 0xb06000, false));
        items.add(new Class9_Sub2("Emerald Certificate", "Exchangable at Ardougne for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Sapphire Certificate", "Exchangable at Ardougne for 5", "", 10, 180, true, false, 19711, false));
        items.add(new Class9_Sub2("Ruby Certificate", "Exchangable at Ardougne for 5", "", 10, 180, true, false, 0xff3300, false));
        items.add(new Class9_Sub2("Diamond Certificate", "Exchangable at Ardougne for 5", "", 10, 180, true, false, 0, false));
        items.add(new Class9_Sub2("Dragonstone Certificate", "Exchangable at Ardougne for 5", "", 10, 180, true, false, 0xbb00ff, false));
        items.add(new Class9_Sub2("Wine of Zamorak Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0xc41818, false));
        items.add(new Class9_Sub2("Dwarf Weed Certificate", "Exchangable at Falador for 5", "", 10, 180, true, false, 0x33cc33, false));
        items.add(new Class9_Sub2("Halloween Mask", "aaaarrrghhh ... i'm a monster", "", 15, 284, false, true, 0x303030, false));
        items.add(new Class9_Sub2("Halloween Mask", "aaaarrrghhh ... i'm a monster", "", 15, 284, false, true, 0xffff00, false));
        items.add(new Class9_Sub2("Halloween Mask", "aaaarrrghhh ... i'm a monster", "", 15, 284, false, true, 0xff00ff, false));
        items.add(new Class9_Sub2("Halloween Mask", "aaaarrrghhh ... i'm a monster", "", 15, 284, false, true, 0, false));
    }

    public static void method255()
    {
        itemSprites.add(new Class11("head1", 1, 13, true, false, 0));
        itemSprites.add(new Class11("body1", 2, 6, true, false, 0));
        itemSprites.add(new Class11("legs1", 3, 15, true, false, 0));
        itemSprites.add(new Class11("fhead1", 1, 13, true, false, 0));
        itemSprites.add(new Class11("fbody1", 2, 10, true, false, 0));
        itemSprites.add(new Class11("head2", 1, 13, true, false, 0));
        itemSprites.add(new Class11("head3", 1, 5, true, false, 0));
        itemSprites.add(new Class11("head4", 1, 13, true, false, 0));
        itemSprites.add(new Class11("chefshat", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("apron", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("apron", 0x956030, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0x555555, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("fullhelm", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("platemailtop", 0x99ddff, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0x404040, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("platemaillegs", 0x99ddff, 0, true, false, 0));
        itemSprites.add(new Class11("leatherarmour", 0, 0, true, false, 0));
        itemSprites.add(new Class11("leathergloves", 0, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("apron", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0x252525, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0x4040ee, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0x40cc40, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0xeeee40, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0xee9900, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0xaa00dd, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 255, 0, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 255, 0, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 0x404040, 0, true, false, 0));
        itemSprites.add(new Class11("necklace", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("necklace", 0xffcc4c, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 255, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0x404040, 0, true, false, 0));
        itemSprites.add(new Class11("Wizardsrobe", 0xa06040, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0xee3030, 0, true, false, 0));
        itemSprites.add(new Class11("Wizardsrobe", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xa06040, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x404040, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xf4b3f3, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xee3030, 0, true, false, 0));
        itemSprites.add(new Class11("Skirt", 0x803019, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x776666, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x777777, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x224255, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x425522, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 26214, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 56797, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0xff9930, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0xad6331, 0, true, false, 0));
        itemSprites.add(new Class11("crossbow", 0, 0, false, false, 0));
        itemSprites.add(new Class11("longbow", 0, 0, false, false, 0));
        itemSprites.add(new Class11("battleaxe", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("battleaxe", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("battleaxe", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("battleaxe", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("battleaxe", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("battleaxe", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("battleaxe", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("mace", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("mace", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("mace", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("mace", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("mace", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("mace", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("mace", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("staff", 0, 0, true, false, 0));
        itemSprites.add(new Class11("rat", 0x49528b, 0, true, false, 0));
        itemSprites.add(new Class11("demon", 0xfa0000, 0, true, false, 0));
        itemSprites.add(new Class11("spider", 0xcc9940, 0, true, false, 0));
        itemSprites.add(new Class11("spider", 0xff4050, 0, true, false, 0));
        itemSprites.add(new Class11("camel", 0, 0, true, false, 0));
        itemSprites.add(new Class11("cow", 0, 0, true, false, 0));
        itemSprites.add(new Class11("sheep", 0, 0, false, false, 0));
        itemSprites.add(new Class11("unicorn", 0, 0, true, false, 0));
        itemSprites.add(new Class11("bear", 0, 0, true, false, 0));
        itemSprites.add(new Class11("chicken", 0, 0, true, false, 0));
        itemSprites.add(new Class11("skeleton", 0, 0, true, false, 0));
        itemSprites.add(new Class11("skelweap", 0, 0, true, true, 0));
        itemSprites.add(new Class11("zombie", 0, 0, true, false, 0));
        itemSprites.add(new Class11("zombweap", 0, 0, true, true, 0));
        itemSprites.add(new Class11("ghost", 0, 0, true, false, 0));
        itemSprites.add(new Class11("bat", 0, 0, true, false, 0));
        itemSprites.add(new Class11("goblin", 0x88ddff, 0, true, false, 0));
        itemSprites.add(new Class11("goblin", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("goblin", 47872, 0, true, false, 0));
        itemSprites.add(new Class11("gobweap", 65535, 0, true, true, 0));
        itemSprites.add(new Class11("scorpion", 0, 0, true, false, 0));
        itemSprites.add(new Class11("dragon", 65280, 0, true, false, 0));
        itemSprites.add(new Class11("dragon", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("dragon", 21981, 0, true, false, 0));
        itemSprites.add(new Class11("Wolf", 0, 0, true, false, 0));
        itemSprites.add(new Class11("Wolf", 0x999999, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 0xffff00, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 255, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 65280, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 0xff00ff, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("leathergloves", 0xaaeeff, 0, true, false, 0));
        itemSprites.add(new Class11("chicken", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("fplatemailtop", 0x99ddff, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x111111, 0, true, false, 0));
        itemSprites.add(new Class11("Wolf", 0x956030, 0, true, false, 0));
        itemSprites.add(new Class11("spider", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("battleaxe", 0xff0044, 0, true, false, 0));
        itemSprites.add(new Class11("sword", 0xff0044, 0, true, false, 0));
        itemSprites.add(new Class11("eyepatch", 0, 0, true, true, 0));
        itemSprites.add(new Class11("demon", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("dragon", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("spider", 0xddcc00, 0, true, false, 0));
        itemSprites.add(new Class11("Wolf", 0x222222, 0, true, false, 0));
        itemSprites.add(new Class11("unicorn", 0x222222, 0, true, false, 0));
        itemSprites.add(new Class11("demon", 0x600000, 0, true, false, 0));
        itemSprites.add(new Class11("spider", 0x222222, 0, true, false, 0));
        itemSprites.add(new Class11("necklace", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("rat", 0xaaaaaa, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0xababab, 0, true, false, 0));
        itemSprites.add(new Class11("chainmail", 0xababab, 0, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("legs1", 0x955040, 0, true, false, 0));
        itemSprites.add(new Class11("gasmask", 0, 0, true, false, 0));
        itemSprites.add(new Class11("mediumhelm", 0xff0044, 0, true, false, 0));
        itemSprites.add(new Class11("spider", 0x3ac826, 0, true, false, 0));
        itemSprites.add(new Class11("spear", 0, 0, true, false, 0));
        itemSprites.add(new Class11("halloweenmask", 52224, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0x101010, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x101010, 0, true, false, 0));
        itemSprites.add(new Class11("halloweenmask", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("halloweenmask", 255, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xffaaaa, 15, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xaaffaa, 15, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xaaaaff, 15, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xffffcc, 15, true, false, 0));
        itemSprites.add(new Class11("skirt", 0xccffff, 15, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 0xffaaaa, 0, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 0xaaffaa, 0, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 0xaaaaff, 0, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 0xffffcc, 0, true, false, 0));
        itemSprites.add(new Class11("wizardshat", 0xccffff, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0xffaaaa, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0xaaffaa, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0xaaaaff, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0xffffcc, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0xccffff, 0, true, false, 0));
        itemSprites.add(new Class11("Wizardsrobe", 0x3cb371, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x3cb371, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0xffaaaa, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0xaaffaa, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0xaaaaff, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0xffffcc, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0xccffff, 0, true, false, 0));
        itemSprites.add(new Class11("santahat", 0, 0, true, false, 0));
        itemSprites.add(new Class11("ibanstaff", 0, 0, true, false, 0));
        itemSprites.add(new Class11("souless", 0, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("legs1", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("Wizardsrobe", 0x808000, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x808000, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("Wolf", 0xccc824, 0, true, false, 0));
        itemSprites.add(new Class11("bunnyears", 0, 0, true, false, 0));
        itemSprites.add(new Class11("saradominstaff", 0, 0, true, false, 0));
        itemSprites.add(new Class11("spear", 56797, 0, true, false, 0));
        itemSprites.add(new Class11("skirt", 0x153f00, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0x153f00, 0, true, false, 0));
        itemSprites.add(new Class11("wolf", 0x553a00, 0, true, false, 0));
        itemSprites.add(new Class11("chicken", 0x692f03, 0, true, false, 0));
        itemSprites.add(new Class11("squareshield", 0xce0000, 0, true, false, 0));
        itemSprites.add(new Class11("cape", 0xffffff, 0, true, false, 0));
        itemSprites.add(new Class11("boots", 0x111111, 0, true, false, 0));
        itemSprites.add(new Class11("wizardsrobe", 0x111111, 0, true, false, 0));
        itemSprites.add(new Class11("Scythe", 0, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("dragon", 0xff0000, 0, true, false, 0));
        itemSprites.add(new Class11("hatchet", 0xff6619, 0, true, false, 0));
        itemSprites.add(new Class11("hatchet", 0xeedddd, 0, true, false, 0));
        itemSprites.add(new Class11("hatchet", 0xeeeeee, 0, true, false, 0));
        itemSprites.add(new Class11("hatchet", 0x99b2cc, 0, true, false, 0));
        itemSprites.add(new Class11("hatchet", 0xb2cc99, 0, true, false, 0));
        itemSprites.add(new Class11("hatchet", 65535, 0, true, false, 0));
        itemSprites.add(new Class11("hatchet", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("candycane", 1, 0, true, false, 0));
        itemSprites.add(new Class11("partyhat", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("halloweenmask", 0x303030, 0, true, false, 0));
        itemSprites.add(new Class11("halloweenmask", 0xffff00, 0, true, false, 0));
        itemSprites.add(new Class11("halloweenmask", 0xff00ff, 0, true, false, 0));
        itemSprites.add(new Class11("halloweenmask", 0, 0, true, false, 0));
    }

    public static void method256()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(Integer.valueOf(35), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Wind strike", "A strength 1 missile attack", 1, 2, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(36), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Confuse", "Reduces your opponents attack by 5%", 3, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(35), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Water Strike", "A strength 2 missile attack", 5, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(32), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Enchant lvl-1 amulet", "For use on sapphire amulets", 7, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(35), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Earth Strike", "A strength 3 missile attack", 9, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(36), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Weaken", "Reduces your opponents strength by 5%", 11, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(35), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(3));
        spells.add(new Class9_Sub6("Fire Strike", "A strength 4 missile attack", 13, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(40), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Bones to bananas", "Changes all held bones into bananas!", 15, 6, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(41), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Wind Bolt", "A strength 5 missile attack", 17, 2, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(36), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Curse", "Reduces your opponents defense by 5%", 19, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(40), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(3));
        spells.add(new Class9_Sub6("Low level alchemy", "Converts an item into gold", 21, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(32), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(41), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Water bolt", "A strength 6 missle attack", 23, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Varrock teleport", "Teleports you to Varrock", 25, 0, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Enchant lvl-2 amulet", "For use on emerald amulets", 27, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(41), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Earth bolt", "A strength 7 missile attack", 29, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Lumbridge teleport", "Teleports you to Lumbridge", 31, 0, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Telekinetic grab", "Take an item that you can see but can't reach", 33, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(41), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(4));
        spells.add(new Class9_Sub6("Fire bolt", "A strength 8 missile attack", 35, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(32), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Falador teleport", "Teleports you to Falador", 37, 0, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(41), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Crumble undead", "Hits skeletons, ghosts, & zombies hard!", 39, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(38), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Wind blast", "A strength 9 missile attack", 41, 2, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(40), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(4));
        spells.add(new Class9_Sub6("Superheat item", "Smelt 1 ore without a furnace", 43, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(5));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Camelot teleport", "Teleports you to Camelot", 45, 0, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(32), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(38), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Water blast", "A strength 10 missile attack", 47, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(46), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(5));
        spells.add(new Class9_Sub6("Enchant lvl-3 amulet", "For use on ruby amulets", 49, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(38), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(5));
        spells.add(new Class9_Sub6("Iban blast", "A strength 25 missile attack!", 50, 2, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(32), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(2));
        spells.add(new Class9_Sub6("Ardougne teleport", "Teleports you to Ardougne", 51, 0, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(4));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(38), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Earth blast", "A strength 11 missile attack", 53, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(40), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(5));
        spells.add(new Class9_Sub6("High level alchemy", "Convert an item into more gold", 55, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(611), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(30));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(3));
        spells.add(new Class9_Sub6("Charge Water Orb", "Needs to be cast on a water obelisk", 56, 5, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(10));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Enchant lvl-4 amulet", "For use on diamond amulets", 57, 3, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(2));
        spells.add(new Class9_Sub6("Watchtower teleport", "Teleports you to the watchtower", 58, 0, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(4));
        hashmap.put(Integer.valueOf(38), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(5));
        spells.add(new Class9_Sub6("Fire blast", "A strength 12 missile attack", 59, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(4));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Claws of Guthix", "Summons the power of Guthix", 60, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(4));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(2));
        spells.add(new Class9_Sub6("Saradomin strike", "Summons the power of Saradomin", 60, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(4));
        spells.add(new Class9_Sub6("Flames of Zamorak", "Summons the power of Zamorak", 60, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(30));
        hashmap.put(Integer.valueOf(611), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(3));
        spells.add(new Class9_Sub6("Charge earth Orb", "Needs to be cast on an earth obelisk", 60, 5, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(31), Integer.valueOf(2));
        hashmap.put(Integer.valueOf(42), Integer.valueOf(2));
        spells.add(new Class9_Sub6("Lost City Teleport", "Teleports you to the Lost City", 61, 0, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(5));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Wind wave", "A strength 13 missile attack", 62, 2, 2, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(611), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(30));
        spells.add(new Class9_Sub6("Charge Fire Orb", "Needs to be cast on a fire obelisk", 63, 5, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(32), Integer.valueOf(7));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(5));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Water wave", "A strength 14 missile attack", 65, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(611), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(30));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(3));
        spells.add(new Class9_Sub6("Charge air Orb", "Needs to be cast on an air obelisk", 66, 5, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(5));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(5));
        hashmap.put(Integer.valueOf(825), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Vulnerability", "Reduces your opponents defense by 10%", 66, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(15));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(15));
        hashmap.put(Integer.valueOf(46), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Enchant lvl-5 amulet", "For use on dragonstone amulets", 68, 3, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(7));
        hashmap.put(Integer.valueOf(33), Integer.valueOf(5));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Earth wave", "A strength 15 missile attack", 70, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(8));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(8));
        hashmap.put(Integer.valueOf(825), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Enfeeble", "Reduces your opponents strength by 10%", 73, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(5));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(1));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(7));
        spells.add(new Class9_Sub6("Fire wave", "A strength 16 missile atack", 75, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(34), Integer.valueOf(12));
        hashmap.put(Integer.valueOf(32), Integer.valueOf(12));
        hashmap.put(Integer.valueOf(825), Integer.valueOf(1));
        spells.add(new Class9_Sub6("Stun", "Reduces your opponents attack by 10%", 80, 2, 3, (HashMap)hashmap.clone()));
        hashmap.clear();
        hashmap.put(Integer.valueOf(33), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(619), Integer.valueOf(3));
        hashmap.put(Integer.valueOf(31), Integer.valueOf(3));
        spells.add(new Class9_Sub6("Charge", "Increases your mage arena spells damage", 80, 0, 3, (HashMap)hashmap.clone()));
        hashmap = null;
    }

    public static void method257()
    {
        wallObjects.add(new Class9_Sub4("Wall", "", "WalkTo", "Examine", 1, 0, 192, 2, 2));
        wallObjects.add(new Class9_Sub4("Doorframe", "", "WalkTo", "Close", 0, 1, 192, 4, 4));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Window", "", "WalkTo", "Examine", 1, 0, 192, 5, 5));
        wallObjects.add(new Class9_Sub4("Fence", "", "WalkTo", "Examine", 1, 0, 192, 10, 10));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "Examine", 1, 0, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("Stained glass window", "", "WalkTo", "Examine", 1, 0, 192, 18, 18));
        wallObjects.add(new Class9_Sub4("Highwall", "", "WalkTo", "Examine", 1, 0, 275, 2, 2));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 275, 0, 0));
        wallObjects.add(new Class9_Sub4("Doorframe", "", "WalkTo", "Close", 0, 1, 275, 4, 4));
        wallObjects.add(new Class9_Sub4("battlement", "", "WalkTo", "Examine", 1, 0, 70, 2, 2));
        wallObjects.add(new Class9_Sub4("Doorframe", "", "WalkTo", "Examine", 1, 0, 192, 4, 4));
        wallObjects.add(new Class9_Sub4("snowwall", "", "WalkTo", "Examine", 1, 0, 192, -31711, -31711));
        wallObjects.add(new Class9_Sub4("arrowslit", "", "WalkTo", "Examine", 1, 0, 192, 7, 7));
        wallObjects.add(new Class9_Sub4("timberwall", "", "WalkTo", "Examine", 1, 0, 192, 21, 21));
        wallObjects.add(new Class9_Sub4("timberwindow", "", "WalkTo", "Examine", 1, 0, 192, 22, 22));
        wallObjects.add(new Class9_Sub4("blank", "", "WalkTo", "Examine", 0, 0, 192, 0xbc614e, 0xbc614e));
        wallObjects.add(new Class9_Sub4("highblank", "", "WalkTo", "Examine", 0, 0, 275, 0xbc614e, 0xbc614e));
        wallObjects.add(new Class9_Sub4("mossybricks", "", "WalkTo", "Examine", 1, 0, 192, 23, 23));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Odd looking wall", "This wall doesn't look quite right", "Push", "Examine", 1, 1, 192, 2, 2));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("web", "A spider's web", "WalkTo", "Examine", 1, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Window", "", "WalkTo", "Examine", 1, 0, 192, 27, 27));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Crumbled", "", "WalkTo", "Examine", 1, 0, 192, 28, 28));
        wallObjects.add(new Class9_Sub4("Cavern", "", "WalkTo", "Examine", 1, 0, 192, 29, 29));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("cavern2", "", "WalkTo", "Examine", 1, 0, 192, 30, 30));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Wall", "", "WalkTo", "Examine", 1, 0, 192, 3, 3));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Strange looking wall", "This wall doesn't look quite right", "Push", "Examine", 1, 1, 192, 29, 29));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("memberrailings", "", "WalkTo", "Examine", 1, 0, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Magic Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Strange Panel", "This wall doesn't look quite right", "Push", "Examine", 1, 1, 192, 21, 21));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("blockblank", "", "WalkTo", "Examine", 1, 0, 192, 0xbc614e, 0xbc614e));
        wallObjects.add(new Class9_Sub4("unusual looking wall", "This wall doesn't look quite right", "Push", "Examine", 1, 1, 192, 2, 2));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick Lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Fence with loose pannels", "I wonder if I could get through this", "push", "Examine", 1, 1, 192, 10, 10));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("rat cage", "The rat's have damaged the bars", "search", "Examine", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("arrowslit", "", "WalkTo", "Examine", 1, 0, 192, 44, 44));
        wallObjects.add(new Class9_Sub4("solidblank", "", "WalkTo", "Examine", 1, 0, 192, 0xbc614e, 0xbc614e));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("loose panel", "The panel has worn with age", "break", "Examine", 1, 1, 192, 3, 3));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("plankswindow", "", "WalkTo", "Examine", 1, 0, 192, 45, 45));
        wallObjects.add(new Class9_Sub4("Low Fence", "", "WalkTo", "Examine", 1, 0, 96, 10, 10));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Cooking pot", "Smells good!", "WalkTo", "Examine", 1, 1, 96, 10, 10));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("plankstimber", "", "WalkTo", "Examine", 1, 0, 192, 46, 46));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("magic portal", "", "enter", "Examine", 1, 1, 192, 17, 17));
        wallObjects.add(new Class9_Sub4("magic portal", "", "enter", "Examine", 1, 1, 192, 17, 17));
        wallObjects.add(new Class9_Sub4("magic portal", "", "enter", "Examine", 1, 1, 192, 17, 17));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Cavern wall", "It looks as if it is covered in some fungus.", "WalkTo", "search", 1, 1, 192, 29, 29));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "the door is shut", "walk through", "Examine", 1, 1, 192, 3, 3));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "walk through", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "walk through", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "walk through", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "walk through", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "walk through", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "walk through", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "walk through", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Pick Lock", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Low wall", "a low wall", "", "Examine", 1, 1, 70, 2, 2));
        wallObjects.add(new Class9_Sub4("Low wall", "a low wall", "", "Examine", 1, 1, 70, 2, 2));
        wallObjects.add(new Class9_Sub4("Blacksmiths Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("railings", "", "pick lock", "Examine", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "pick lock", "Examine", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "pick lock", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "pick lock", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "pick lock", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "look through", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "knock on", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Doorframe", "", "WalkTo", "Close", 1, 1, 192, 4, 4));
        wallObjects.add(new Class9_Sub4("Tent", "", "WalkTo", "Examine", 1, 0, 192, 36, 36));
        wallObjects.add(new Class9_Sub4("Jail Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Jail Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Window", "A barred window", "WalkTo", "Search", 1, 1, 192, 27, 27));
        wallObjects.add(new Class9_Sub4("magic portal", "A magical barrier shimmers with power", "WalkTo", "Examine", 1, 1, 192, 17, 17));
        wallObjects.add(new Class9_Sub4("Jail Door", "A solid iron gate", "Open", "Examine", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("Cave exit", "The way out", "Leave", "Examine", 0, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("Cave exit", "The way out", "Leave", "Examine", 0, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("Cave exit", "The way out", "Leave", "Examine", 0, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("Cave exit", "The way out", "Leave", "Examine", 0, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("Cave exit", "The way out", "Leave", "Examine", 0, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("Cave exit", "The way out", "Leave", "Examine", 0, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("railings", "", "WalkTo", "search", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("battlement", "This is blocking your path", "Climb-over", "Examine", 1, 1, 70, 2, 2));
        wallObjects.add(new Class9_Sub4("Tent Door", "An entrance into the tent", "Go through", "Examine", 1, 1, 192, 50, 50));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Tent Door", "An entrance into the tent", "Go through", "Examine", 1, 1, 192, 50, 50));
        wallObjects.add(new Class9_Sub4("Low Fence", "A damaged wooden fence", "search", "Examine", 1, 1, 96, 10, 10));
        wallObjects.add(new Class9_Sub4("Sturdy Iron Gate", "A solid iron gate", "Open", "Examine", 1, 1, 192, 12, 12));
        wallObjects.add(new Class9_Sub4("battlement", "this low wall blocks your path", "climb over", "Examine", 1, 1, 70, 2, 2));
        wallObjects.add(new Class9_Sub4("Water", "My waterfall boundary!", "WalkTo", "Examine", 1, 0, 192, 25, 25));
        wallObjects.add(new Class9_Sub4("Wheat", "Test Boundary!", "WalkTo", "Examine", 1, 0, 192, 24, 24));
        wallObjects.add(new Class9_Sub4("Jungle", "Thick inpenetrable jungle", "Chop", "Examine", 1, 1, 192, 8, 8));
        wallObjects.add(new Class9_Sub4("Window", "you can see a vicious looking guard dog right outside", "Investigate", "Examine", 1, 1, 192, 5, 5));
        wallObjects.add(new Class9_Sub4("Rut", "Looks like a small rut carved into the ground.", "WalkTo", "Search", 1, 0, 96, 51, 51));
        wallObjects.add(new Class9_Sub4("Crumbled Cavern 1", "", "WalkTo", "Examine", 0, 0, 192, 52, 52));
        wallObjects.add(new Class9_Sub4("Crumbled Cavern 2", "", "WalkTo", "Examine", 0, 0, 192, 53, 53));
        wallObjects.add(new Class9_Sub4("cavernhole", "", "WalkTo", "Examine", 1, 0, 192, 54, 54));
        wallObjects.add(new Class9_Sub4("flamewall", "A supernatural fire of incredible intensity", "Touch", "Investigate", 1, 1, 192, 54, 54));
        wallObjects.add(new Class9_Sub4("Ruined wall", "Some ancient wall structure - it doesn't look too high.", "WalkTo", "Jump", 1, 1, 192, 28, 28));
        wallObjects.add(new Class9_Sub4("Ancient Wall", "An ancient - slightly higher wall with some strange markings on it", "Use", "Search", 1, 1, 275, 2, 2));
        wallObjects.add(new Class9_Sub4("Door", "The door is shut", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "This door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "This door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "This door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "This door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("web", "A spider's web", "WalkTo", "Examine", 1, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("web", "A spider's web", "WalkTo", "Examine", 1, 1, 192, 26, 26));
        wallObjects.add(new Class9_Sub4("Anti-Nigger Forcefield", "A magical barrier that screams white power", "WalkTo", "Examine", 1, 1, 192, 17, 17));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
        wallObjects.add(new Class9_Sub4("Door", "The door is locked", "Open", "Examine", 1, 1, 192, 0, 0));
    }

    public static void method258()
    {
        objects.add(new Class9_Sub1("Tree", "A pointy tree", "Chop", "Examine", 1, 1, 1, 0, "tree2"));
        objects.add(new Class9_Sub1("Tree", "A leafy tree", "Chop", "Examine", 1, 1, 1, 0, "tree"));
        objects.add(new Class9_Sub1("Well", "The bucket is missing", "WalkTo", "Examine", 1, 2, 2, 0, "well"));
        objects.add(new Class9_Sub1("Table", "A mighty fine table", "WalkTo", "Examine", 1, 1, 1, 96, "table"));
        objects.add(new Class9_Sub1("Treestump", "Someone has chopped this tree down!", "WalkTo", "Examine", 1, 1, 1, 0, "treestump"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Chair", "A sturdy looking chair", "WalkTo", "Examine", 1, 1, 1, 0, "chair"));
        objects.add(new Class9_Sub1("logs", "A pile of logs", "WalkTo", "Examine", 1, 1, 1, 0, "logpile"));
        objects.add(new Class9_Sub1("Longtable", "It has nice candles", "WalkTo", "Examine", 1, 4, 1, 0, "longtable"));
        objects.add(new Class9_Sub1("Throne", "It looks fancy and expensive", "WalkTo", "Examine", 1, 1, 1, 0, "throne"));
        objects.add(new Class9_Sub1("Range", "A hot well stoked range", "WalkTo", "Examine", 1, 1, 2, 0, "range"));
        objects.add(new Class9_Sub1("Gravestone", "R I P", "WalkTo", "Examine", 1, 1, 1, 0, "gravestone1"));
        objects.add(new Class9_Sub1("Gravestone", "Its covered in moss", "WalkTo", "Examine", 1, 1, 1, 0, "gravestone2"));
        objects.add(new Class9_Sub1("Bed", "Ooh nice blankets", "rest", "Examine", 1, 2, 3, 0, "Bigbed"));
        objects.add(new Class9_Sub1("Bed", "Its a bed - wow", "rest", "Examine", 1, 2, 2, 0, "bed"));
        objects.add(new Class9_Sub1("bar", "Mmm beer", "WalkTo", "Examine", 1, 1, 1, 0, "barpumps"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Altar", "Its an Altar", "Recharge at", "Examine", 1, 2, 1, 0, "altar"));
        objects.add(new Class9_Sub1("Post", "What am I examining posts for", "WalkTo", "Examine", 1, 1, 1, 0, "wallpost"));
        objects.add(new Class9_Sub1("Support", "A wooden pole", "WalkTo", "Examine", 0, 1, 1, 0, "supportnw"));
        objects.add(new Class9_Sub1("barrel", "Its empty", "WalkTo", "Examine", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("Bench", "It doesn't look very comfy", "WalkTo", "Examine", 1, 2, 1, 0, "bench"));
        objects.add(new Class9_Sub1("Portrait", "A painting of our beloved king", "WalkTo", "Examine", 0, 1, 1, 0, "portrait"));
        objects.add(new Class9_Sub1("candles", "Candles on a fancy candlestick", "WalkTo", "Examine", 1, 1, 1, 0, "candles"));
        objects.add(new Class9_Sub1("fountain", "The water looks fairly clean", "WalkTo", "Examine", 1, 2, 2, 0, "fountain"));
        objects.add(new Class9_Sub1("landscape", "An oil painting", "WalkTo", "Examine", 0, 1, 1, 0, "landscape"));
        objects.add(new Class9_Sub1("Millstones", "You can use these to make flour", "WalkTo", "Examine", 1, 3, 3, 0, "mill"));
        objects.add(new Class9_Sub1("Counter", "It's the shop counter", "WalkTo", "Examine", 1, 2, 1, 120, "counter"));
        objects.add(new Class9_Sub1("Stall", "A market stall", "WalkTo", "Examine", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("Target", "Coming soon archery practice", "Practice", "Examine", 1, 1, 1, 0, "target"));
        objects.add(new Class9_Sub1("PalmTree", "A nice palm tree", "WalkTo", "Examine", 1, 1, 1, 0, "palm2"));
        objects.add(new Class9_Sub1("PalmTree", "A shady palm tree", "WalkTo", "Examine", 1, 1, 1, 0, "palm"));
        objects.add(new Class9_Sub1("Fern", "A leafy plant", "WalkTo", "Examine", 0, 1, 1, 0, "fern"));
        objects.add(new Class9_Sub1("Cactus", "It looks very spikey", "WalkTo", "Examine", 1, 1, 1, 0, "cactus"));
        objects.add(new Class9_Sub1("Bullrushes", "I wonder why it's called a bullrush", "WalkTo", "Examine", 0, 1, 1, 0, "bullrushes"));
        objects.add(new Class9_Sub1("Flower", "Ooh thats pretty", "WalkTo", "Examine", 0, 1, 1, 0, "flower"));
        objects.add(new Class9_Sub1("Mushroom", "I think it's a poisonous one", "WalkTo", "Examine", 0, 1, 1, 0, "mushroom"));
        objects.add(new Class9_Sub1("Coffin", "This coffin is closed", "Open", "Examine", 1, 2, 2, 0, "coffin"));
        objects.add(new Class9_Sub1("Coffin", "This coffin is open", "Search", "Close", 1, 2, 2, 0, "coffin2"));
        objects.add(new Class9_Sub1("stairs", "These lead upstairs", "Go up", "Examine", 1, 2, 3, 0, "woodenstairs"));
        objects.add(new Class9_Sub1("stairs", "These lead downstairs", "Go down", "Examine", 1, 2, 3, 0, "woodenstairsdown"));
        objects.add(new Class9_Sub1("stairs", "These lead upstairs", "Go up", "Examine", 1, 2, 3, 0, "stonestairs"));
        objects.add(new Class9_Sub1("stairs", "These lead downstairs", "Go down", "Examine", 1, 2, 3, 0, "stonestairsdown"));
        objects.add(new Class9_Sub1("railing", "nice safety measure", "WalkTo", "Examine", 1, 1, 1, 0, "woodenrailing"));
        objects.add(new Class9_Sub1("pillar", "An ornate pillar", "WalkTo", "Examine", 1, 1, 1, 0, "marblepillar"));
        objects.add(new Class9_Sub1("Bookcase", "A large collection of books", "WalkTo", "Examine", 1, 1, 2, 0, "bookcase"));
        objects.add(new Class9_Sub1("Sink", "Its fairly dirty", "WalkTo", "Examine", 1, 1, 2, 0, "sink"));
        objects.add(new Class9_Sub1("Dummy", "I can practice my fighting here", "hit", "Examine", 1, 1, 1, 0, "sworddummy"));
        objects.add(new Class9_Sub1("anvil", "heavy metal", "WalkTo", "Examine", 1, 1, 1, 0, "anvil"));
        objects.add(new Class9_Sub1("Torch", "It would be very dark without this", "WalkTo", "Examine", 0, 1, 1, 0, "torcha1"));
        objects.add(new Class9_Sub1("hopper", "You put grain in here", "operate", "Examine", 1, 2, 2, 0, "milltop"));
        objects.add(new Class9_Sub1("chute", "Flour comes out here", "WalkTo", "Examine", 1, 2, 2, 40, "millbase"));
        objects.add(new Class9_Sub1("cart", "A farm cart", "WalkTo", "Examine", 1, 2, 3, 0, "cart"));
        objects.add(new Class9_Sub1("sacks", "Yep they're sacks", "WalkTo", "Examine", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("Gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "WalkTo", "close", 3, 1, 2, 0, "metalgateopen"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "WalkTo", "close", 3, 1, 2, 0, "woodengateopen"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("signpost", "To Varrock", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("signpost", "To the tower of wizards", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("doors", "The doors are open", "WalkTo", "Close", 3, 1, 2, 0, "doubledoorsopen"));
        objects.add(new Class9_Sub1("doors", "The doors are shut", "Open", "Examine", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("signpost", "To player owned houses", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("signpost", "To Lumbridge Castle", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("bookcase", "It's a bookcase", "WalkTo", "Search", 1, 1, 2, 0, "bookcase"));
        objects.add(new Class9_Sub1("henge", "these look impressive", "WalkTo", "Examine", 1, 2, 2, 0, "henge"));
        objects.add(new Class9_Sub1("Dolmen", "An ancient altar", "WalkTo", "Examine", 1, 2, 2, 0, "dolmen"));
        objects.add(new Class9_Sub1("Tree", "This tree doesn't look too healthy", "WalkTo", "Chop", 1, 1, 1, 0, "deadtree1"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("Wheat", "nice ripe looking wheat", "WalkTo", "pick", 0, 1, 1, 0, "wheat"));
        objects.add(new Class9_Sub1("sign", "The blue moon inn", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sails", "The windmill's sails", "WalkTo", "Examine", 0, 1, 3, 0, "windmillsail"));
        objects.add(new Class9_Sub1("sign", "estate agent", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "The Jolly boar inn", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("Drain", "This drainpipe runs from the kitchen to the sewers", "WalkTo", "Search", 0, 1, 1, 0, "pipe&drain"));
        objects.add(new Class9_Sub1("manhole", "A manhole cover", "open", "Examine", 0, 1, 1, 0, "manholeclosed"));
        objects.add(new Class9_Sub1("manhole", "How dangerous - this manhole has been left open", "climb down", "close", 0, 1, 1, 0, "manholeopen"));
        objects.add(new Class9_Sub1("pipe", "a dirty sewer pipe", "WalkTo", "Examine", 1, 1, 1, 0, "wallpipe"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("barrel", "It seems to be full of newt's eyes", "WalkTo", "Examine", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("fountain", "I think I see something in the fountain", "WalkTo", "Search", 1, 2, 2, 0, "fountain"));
        objects.add(new Class9_Sub1("signpost", "To Draynor Manor", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("Tree", "This tree doesn't look too healthy", "Approach", "Search", 1, 1, 1, 0, "deadtree1"));
        objects.add(new Class9_Sub1("sign", "General Store", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "Lowe's Archery store", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "The Clothes Shop", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "Varrock Swords", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("sign", "Bob's axes", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "The staff shop", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("fire", "A strongly burning fire", "WalkTo", "Examine", 0, 1, 1, 0, "firea1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks2"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "copperrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "copperrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "ironrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "ironrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "tinrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "tinrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "mithrilrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "mithrilrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "adamiterock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "adamiterock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "coalrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "coalrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "goldrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "goldrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "clayrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "clayrock1"));
        objects.add(new Class9_Sub1("web", "A spider's web", "WalkTo", "Examine", 0, 1, 1, 0, "ceilingweb"));
        objects.add(new Class9_Sub1("web", "A spider's web", "WalkTo", "Examine", 0, 1, 1, 0, "floorweb"));
        objects.add(new Class9_Sub1("furnace", "A red hot furnace", "WalkTo", "Examine", 1, 2, 2, 0, "furnace"));
        objects.add(new Class9_Sub1("Cook's Range", "A hot well stoked range", "WalkTo", "Examine", 1, 1, 2, 0, "range"));
        objects.add(new Class9_Sub1("Machine", "I wonder what it's supposed to do", "WalkTo", "Examine", 1, 2, 2, 0, "madmachine"));
        objects.add(new Class9_Sub1("Spinning wheel", "I can spin wool on this", "WalkTo", "Examine", 1, 1, 1, 0, "spinningwheel"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "WalkTo", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Lever", "The lever is down", "WalkTo", "Examine", 0, 1, 1, 0, "leverdown"));
        objects.add(new Class9_Sub1("LeverA", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("LeverB", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("LeverC", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("LeverD", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("LeverE", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("LeverF", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("signpost", "To the forge", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("signpost", "To the Barbarian's  Village", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("signpost", "To Al Kharid", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("Compost Heap", "A smelly pile of compost", "WalkTo", "Search", 1, 2, 2, 0, "compost"));
        objects.add(new Class9_Sub1("Coffin", "This coffin is closed", "Open", "Examine", 1, 2, 2, 0, "coffin"));
        objects.add(new Class9_Sub1("Coffin", "This coffin is open", "Search", "Close", 1, 2, 2, 0, "coffin2"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("sign", "The Bank of runescape", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("doors", "The doors are shut", "Open", "Examine", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("torch", "A scary torch", "WalkTo", "Examine", 0, 1, 1, 0, "skulltorcha1"));
        objects.add(new Class9_Sub1("Altar", "An altar to the evil God Zamorak", "Recharge at", "Examine", 1, 2, 1, 0, "chaosaltar"));
        objects.add(new Class9_Sub1("Shield", "A display shield", "WalkTo", "Examine", 0, 1, 1, 0, "wallshield"));
        objects.add(new Class9_Sub1("Grill", "some sort of ventilation", "WalkTo", "Examine", 0, 1, 1, 0, "wallgrill"));
        objects.add(new Class9_Sub1("Cauldron", "A very large pot", "WalkTo", "drink from", 1, 1, 1, 0, "cauldron"));
        objects.add(new Class9_Sub1("Grill", "some sort of ventilation", "Listen", "Examine", 0, 1, 1, 0, "wallgrill"));
        objects.add(new Class9_Sub1("Mine Cart", "It's empty", "WalkTo", "Examine", 1, 1, 1, 0, "minecart"));
        objects.add(new Class9_Sub1("Buffers", "Stop the carts falling off the end", "WalkTo", "Examine", 1, 1, 1, 0, "trackbuffer"));
        objects.add(new Class9_Sub1("Track", "Train track", "WalkTo", "Examine", 0, 2, 2, 0, "trackcurve"));
        objects.add(new Class9_Sub1("Track", "Train track", "WalkTo", "Examine", 0, 2, 2, 0, "trackpoints"));
        objects.add(new Class9_Sub1("Track", "Train track", "WalkTo", "Examine", 0, 1, 1, 0, "trackstraight"));
        objects.add(new Class9_Sub1("Hole", "I can see a witches cauldron directly below it", "WalkTo", "Examine", 1, 1, 1, 0, "hole"));
        objects.add(new Class9_Sub1("ship", "A ship to Karamja", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A ship to Karamja", "board", "Examine", 0, 2, 3, 0, "Shipmiddle"));
        objects.add(new Class9_Sub1("ship", "A ship to Karamja", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("Emergency escape ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("sign", "Wydin's grocery", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "The Rusty Anchor", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Sarim", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Sarim", "board", "Examine", 0, 2, 3, 0, "Shipmiddle"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Sarim", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("hopper", "You put grain in here", "operate", "Examine", 1, 2, 2, 0, "milltop"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "bluriterock1"));
        objects.add(new Class9_Sub1("Doric's anvil", "Property of Doric the dwarf", "WalkTo", "Examine", 1, 1, 1, 0, "anvil"));
        objects.add(new Class9_Sub1("pottery oven", "I can fire clay pots in this", "WalkTo", "Examine", 1, 2, 2, 0, "potteryoven"));
        objects.add(new Class9_Sub1("potter's wheel", "I can make clay pots using this", "WalkTo", "Examine", 1, 1, 1, 0, "potterywheel"));
        objects.add(new Class9_Sub1("gate", "A gate from Lumbridge to Al Kharid", "Open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "This gate is open", "WalkTo", "Examine", 2, 1, 2, 0, "metalgateopen"));
        objects.add(new Class9_Sub1("crate", "A crate used for storing bananas", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("Banana tree", "A tree with nice ripe bananas growing on it", "WalkTo", "Pick Banana", 1, 1, 1, 0, "palm2"));
        objects.add(new Class9_Sub1("Banana tree", "There are no bananas left on the tree", "WalkTo", "Pick Banana", 1, 1, 1, 0, "palm2"));
        objects.add(new Class9_Sub1("crate", "A crate used for storing bananas", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("Chest", "A battered old chest", "WalkTo", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Flower", "Ooh thats pretty", "WalkTo", "Examine", 0, 1, 1, 0, "flower"));
        objects.add(new Class9_Sub1("sign", "Fishing Supplies", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "Jewellers", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("Potato", "A potato plant", "WalkTo", "pick", 0, 1, 1, 0, "potato"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Lure", "Bait", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Net", "Bait", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Harpoon", "Cage", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "silverrock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "silverrock1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Monks Altar", "Its an Altar", "Recharge at", "Examine", 1, 2, 1, 0, "altar"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Coffin", "This coffin is closed", "Open", "Examine", 1, 2, 2, 0, "coffin"));
        objects.add(new Class9_Sub1("Coffin", "This coffin is open", "Search", "Close", 1, 2, 2, 0, "coffin2"));
        objects.add(new Class9_Sub1("Smashed table", "This table has seen better days", "WalkTo", "Examine", 1, 1, 1, 0, "smashedtable"));
        objects.add(new Class9_Sub1("Fungus", "A creepy looking fungus", "WalkTo", "Examine", 0, 1, 1, 0, "nastyfungus"));
        objects.add(new Class9_Sub1("Smashed chair", "This chair is broken", "WalkTo", "Examine", 1, 1, 1, 0, "smashedchair"));
        objects.add(new Class9_Sub1("Broken pillar", "The remains of a pillar", "WalkTo", "Examine", 1, 1, 1, 0, "brokenpillar"));
        objects.add(new Class9_Sub1("Fallen tree", "A fallen tree", "WalkTo", "Examine", 1, 3, 2, 0, "fallentree"));
        objects.add(new Class9_Sub1("Danger Sign", "Danger!", "WalkTo", "Examine", 1, 1, 1, 0, "dangersign"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "runiterock1"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "runiteruck1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Gravestone", "A big impressive gravestone", "WalkTo", "Examine", 1, 2, 2, 0, "largegrave"));
        objects.add(new Class9_Sub1("bone", "Eep!", "WalkTo", "Examine", 1, 1, 1, 0, "curvedbone"));
        objects.add(new Class9_Sub1("bone", "This would feed a dog for a month", "WalkTo", "Examine", 1, 1, 1, 0, "largebone"));
        objects.add(new Class9_Sub1("carcass", "I think it's dead", "WalkTo", "Examine", 1, 2, 2, 0, "carcass"));
        objects.add(new Class9_Sub1("animalskull", "I wouldn't like to meet a live one", "WalkTo", "Examine", 1, 1, 1, 0, "animalskull"));
        objects.add(new Class9_Sub1("Vine", "A creepy creeper", "WalkTo", "Examine", 0, 1, 1, 0, "vine"));
        objects.add(new Class9_Sub1("Vine", "A creepy creeper", "WalkTo", "Examine", 0, 1, 1, 0, "vinecorner"));
        objects.add(new Class9_Sub1("Vine", "A creepy creeper", "WalkTo", "Examine", 0, 1, 1, 0, "vinejunction"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "WalkTo", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("ship", "The Lumbridge Lady", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "The Lumbridge Lady", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("hole", "This ship isn't much use with that there", "WalkTo", "Examine", 2, 1, 1, 0, "brokenwall"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("hole", "This ship isn't much use with that there", "WalkTo", "Examine", 2, 1, 1, 0, "brokenwall"));
        objects.add(new Class9_Sub1("ship", "The Lumbridge Lady", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "The Lumbridge Lady", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("Altar of Guthix", "A sort of ancient altar thingy", "Recharge at", "Examine", 1, 2, 2, 0, "dolmen"));
        objects.add(new Class9_Sub1("The Cauldron of Thunder", "A very large pot", "WalkTo", "Examine", 1, 1, 1, 0, "cauldron"));
        objects.add(new Class9_Sub1("Tree", "A leafy tree", "Search", "Examine", 1, 1, 1, 0, "tree"));
        objects.add(new Class9_Sub1("ship", "A ship to Entrana", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A ship to Entrana", "board", "Examine", 0, 2, 3, 0, "Shipmiddle"));
        objects.add(new Class9_Sub1("ship", "A ship to Entrana", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Sarim", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Sarim", "board", "Examine", 0, 2, 3, 0, "Shipmiddle"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Sarim", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Dramen Tree", "This tree doesn't look too healthy", "Chop", "Examine", 1, 1, 1, 0, "dramentree"));
        objects.add(new Class9_Sub1("hopper", "You put grain in here", "operate", "Examine", 1, 2, 2, 0, "milltop"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "WalkTo", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("sign", "2-handed swords sold here", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "ye olde herbalist", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Door mat", "If I ever get my boots muddy I know where to come", "search", "Examine", 0, 1, 1, 0, "Doormat"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Cauldron", "A very large pot", "WalkTo", "Examine", 1, 1, 1, 0, "cauldron"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("gate", "The bank vault gate", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "net", "Harpoon", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("sign", "Harry's fishing shack", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("sign", "The shrimp and parrot", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("signpost", "Palm Street", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("Rockslide", "A pile of rocks blocks your path", "Mine", "Prospect", 1, 1, 1, 0, "rock3"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the lava!", "Bait", "Examine", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("barrel", "Its got ale in it", "WalkTo", "Examine", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("table", "It's a sturdy table", "WalkTo", "Examine", 1, 2, 1, 96, "bigtable"));
        objects.add(new Class9_Sub1("Fireplace", "It would be very cold without this", "WalkTo", "Examine", 1, 2, 1, 0, "fireplacea1"));
        objects.add(new Class9_Sub1("Egg", "Thats one big egg!", "WalkTo", "Examine", 1, 1, 1, 0, "bigegg"));
        objects.add(new Class9_Sub1("Eggs", "They'd make an impressive omlette", "WalkTo", "Examine", 1, 1, 1, 0, "eggs"));
        objects.add(new Class9_Sub1("Stalagmites", "Hmm pointy", "WalkTo", "Examine", 1, 1, 1, 0, "stalagmites"));
        objects.add(new Class9_Sub1("Stool", "A simple three legged stool", "WalkTo", "Examine", 1, 1, 1, 0, "stool"));
        objects.add(new Class9_Sub1("Bench", "It doesn't look to comfortable", "WalkTo", "Examine", 1, 1, 1, 0, "wallbench"));
        objects.add(new Class9_Sub1("table", "A round table ideal for knights", "WalkTo", "Examine", 1, 2, 2, 0, "bigroundtable"));
        objects.add(new Class9_Sub1("table", "A handy little table", "WalkTo", "Examine", 1, 1, 1, 96, "roundtable"));
        objects.add(new Class9_Sub1("fountain of heros", "Use a dragonstone gem here to increase it's abilties", "WalkTo", "Examine", 1, 2, 2, 0, "fountain"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "WalkTo", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("hedge", "A carefully trimmed hedge", "WalkTo", "Examine", 1, 1, 1, 0, "bush2"));
        objects.add(new Class9_Sub1("flower", "A nice colourful flower", "WalkTo", "Examine", 1, 1, 1, 0, "blueflower"));
        objects.add(new Class9_Sub1("plant", "Hmm leafy", "WalkTo", "Examine", 1, 1, 1, 0, "smallfern"));
        objects.add(new Class9_Sub1("Giant crystal", "How unusual a crystal with a n00b trapped in it", "WalkTo", "Examine", 1, 3, 3, 0, "giantcrystal"));
        objects.add(new Class9_Sub1("sign", "The dead man's chest", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("sign", "The rising sun", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("crate", "A large wooden storage box", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("crate", "A large wooden storage box", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("ship", "A merchant ship", "stow away", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A merchant ship", "stow away", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("beehive", "It's guarded by angry looking bees", "WalkTo", "Examine", 1, 1, 1, 0, "beehive"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Altar", "An altar to the evil God Zamorak", "Recharge at", "Search", 1, 2, 1, 0, "chaosaltar"));
        objects.add(new Class9_Sub1("sign", "Hickton's Archery store", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("signpost", "To Camelot", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("Archway", "A decorative marble arch", "WalkTo", "Examine", 1, 2, 1, 0, "marblearch"));
        objects.add(new Class9_Sub1("Obelisk of water", "It doesn't look very wet", "WalkTo", "Examine", 1, 1, 1, 0, "obelisk"));
        objects.add(new Class9_Sub1("Obelisk of fire", "It doesn't look very hot", "WalkTo", "Examine", 1, 1, 1, 0, "obelisk"));
        objects.add(new Class9_Sub1("sand pit", "I can use a bucket to get sand from here", "WalkTo", "Search", 1, 2, 2, 0, "sandpit"));
        objects.add(new Class9_Sub1("Obelisk of air", "A tall stone pointy thing", "WalkTo", "Examine", 1, 1, 1, 0, "obelisk"));
        objects.add(new Class9_Sub1("Obelisk of earth", "A tall stone pointy thing", "WalkTo", "Examine", 1, 1, 1, 0, "obelisk"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Oak Tree", "A grand old oak tree", "Chop", "Examine", 1, 2, 2, 0, "oaktree"));
        objects.add(new Class9_Sub1("Willow Tree", "A weeping willow", "Chop", "Examine", 1, 2, 2, 0, "willowtree"));
        objects.add(new Class9_Sub1("Maple Tree", "It's got nice shaped leaves", "Chop", "Examine", 1, 2, 2, 0, "mapletree"));
        objects.add(new Class9_Sub1("Yew Tree", "A tough looking yew tree", "Chop", "Examine", 1, 2, 2, 0, "yewtree"));
        objects.add(new Class9_Sub1("Magic Tree", "A magical tree", "Chop", "Examine", 1, 1, 1, 0, "magictree"));
        objects.add(new Class9_Sub1("gate", "A gate guarded by a fierce barbarian", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("sign", "The forester's arms", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("flax", "A flax plant", "pick", "WalkTo", 0, 1, 1, 0, "flax"));
        objects.add(new Class9_Sub1("Large treestump", "Someone has chopped this tree down!", "WalkTo", "Examine", 1, 2, 2, 0, "treestump"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "goldrock1"));
        objects.add(new Class9_Sub1("Lever", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Lever", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Lever", "It's a lever", "Pull", "Inspect", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("ship", "A ship bound for Ardougne", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A ship bound for Ardougne", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("Bakers Stall", "A market stall", "WalkTo", "steal from", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("Silk Stall", "A market stall", "WalkTo", "steal from", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("Fur Stall", "A market stall", "WalkTo", "steal from", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("Silver Stall", "A market stall", "WalkTo", "steal from", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("Spices Stall", "A market stall", "WalkTo", "steal from", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("gems Stall", "A market stall", "WalkTo", "steal from", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("crate", "A large heavy sealed crate", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("crate", "A large heavy sealed crate", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("sign", "RPDT depot", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("stairs", "These lead upstairs", "Go up", "Search for traps", 1, 2, 3, 0, "stonestairs"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Search for traps", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Search for traps", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Search for traps", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Search for traps", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Search for traps", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "someone is stealing something from it", "WalkTo", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Search for traps", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("empty stall", "A market stall", "WalkTo", "Examine", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("stairs", "These lead upstairs", "Go up", "Examine", 1, 2, 3, 0, "stonestairs"));
        objects.add(new Class9_Sub1("hopper", "You put grain in here", "operate", "Examine", 1, 2, 2, 0, "milltop"));
        objects.add(new Class9_Sub1("signpost", "Ardougne city zoo", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("sign", "The flying horse", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "pull", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "pull", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("pipe", "a dirty sewer pipe", "WalkTo", "Examine", 1, 1, 1, 0, "wallpipe"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Bait", "Examine", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Bait", "Examine", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Bait", "Examine", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Bait", "Examine", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("Vine", "A creepy creeper", "WalkTo", "Examine", 0, 1, 1, 0, "vine"));
        objects.add(new Class9_Sub1("gate", "The main entrance to McGrubor's wood", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "WalkTo", "Examine", 2, 1, 2, 0, "woodengateopen"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("stairs", "These lead downstairs", "Go down", "Examine", 1, 2, 3, 0, "stonestairsdown"));
        objects.add(new Class9_Sub1("broken cart", "A farm cart", "WalkTo", "Examine", 1, 2, 3, 0, "brokencart"));
        objects.add(new Class9_Sub1("Lever", "It's a lever", "Pull", "Searchfortraps", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("clock pole blue", "A pole - a pole to put cog's on", "inspect", "Examine", 0, 1, 1, 0, "clockpoleblue"));
        objects.add(new Class9_Sub1("clock pole red", "A pole - a pole to put cog's on", "inspect", "Examine", 0, 1, 1, 0, "clockpolered"));
        objects.add(new Class9_Sub1("clock pole purple", "A pole - a pole to put cog's on", "inspect", "Examine", 0, 1, 1, 0, "clockpolepurple"));
        objects.add(new Class9_Sub1("clock pole black", "A pole - a pole to put cog's on", "inspect", "Examine", 0, 1, 1, 0, "clockpoleblack"));
        objects.add(new Class9_Sub1("wallclockface", "It's a large clock face", "WalkTo", "Examine", 1, 2, 2, 0, "wallclockface"));
        objects.add(new Class9_Sub1("Lever Bracket", "Theres something missing here", "WalkTo", "Examine", 0, 1, 1, 0, "leverbracket"));
        objects.add(new Class9_Sub1("Lever", "It's a lever", "Pull", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("stairs", "These lead upstairs", "Go up", "Examine", 1, 2, 3, 0, "woodenstairs"));
        objects.add(new Class9_Sub1("stairs", "These lead downstairs", "Go down", "Examine", 1, 2, 3, 0, "woodenstairsdown"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed2"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "close", "Examine", 3, 1, 2, 0, "metalgateopen2"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "pull", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "push", "Examine", 0, 1, 1, 0, "leverdown"));
        objects.add(new Class9_Sub1("Foodtrough", "It's for feeding the rat's", "WalkTo", "Examine", 1, 2, 1, 0, "Foodtrough"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "cage", "harpoon", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("spearwall", "It's a defensive battlement", "WalkTo", "Examine", 1, 2, 1, 0, "spearwall"));
        objects.add(new Class9_Sub1("hornedskull", "A horned dragon skull", "WalkTo", "Examine", 1, 2, 2, 0, "hornedskull"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "picklock", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "picklock", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("guardscupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("guardscupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("Coal truck", "I can use this to transport coal", "get coal from", "Examine", 1, 1, 1, 0, "minecart"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Birmhaven", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Birmhaven", "board", "Examine", 0, 2, 3, 0, "Shipmiddle"));
        objects.add(new Class9_Sub1("ship", "A ship to Port Birmhaven", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("Tree", "It's a tree house", "WalkTo", "Examine", 1, 1, 1, 0, "toplesstree"));
        objects.add(new Class9_Sub1("Ballista", "It's a war machine", "fire", "Examine", 1, 4, 1, 0, "catabow"));
        objects.add(new Class9_Sub1("largespear", "", "WalkTo", "Examine", 1, 2, 1, 0, "catabowarrow"));
        objects.add(new Class9_Sub1("spirit tree", "A grand old spirit tree", "talk to", "Examine", 1, 2, 2, 0, "ent"));
        objects.add(new Class9_Sub1("young spirit Tree", "Ancestor of the spirit tree", "talk to", "Examine", 1, 1, 1, 0, "tree2"));
    }

    public static void method259()
    {
        objects.add(new Class9_Sub1("gate", "The gate is closed", "talk through", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("wall", "A damaged wall", "climb", "Examine", 1, 3, 1, 0, "khazardwall"));
        objects.add(new Class9_Sub1("tree", "An exotic looking tree", "WalkTo", "Examine", 1, 1, 1, 0, "jungle tree 2"));
        objects.add(new Class9_Sub1("tree", "An exotic looking tree", "WalkTo", "Examine", 1, 1, 1, 0, "jungle tree 1"));
        objects.add(new Class9_Sub1("Fern", "An exotic leafy plant", "WalkTo", "Examine", 0, 1, 1, 0, "jungle fern textured"));
        objects.add(new Class9_Sub1("Fern", "An exotic leafy plant", "WalkTo", "Examine", 0, 1, 1, 0, "jungle fern textured 2"));
        objects.add(new Class9_Sub1("Fern", "An exotic leafy plant", "WalkTo", "Examine", 0, 1, 1, 0, "jungle fern textured 3"));
        objects.add(new Class9_Sub1("Fern", "An exotic leafy plant", "WalkTo", "Examine", 0, 1, 1, 0, "jungle fern textured 4"));
        objects.add(new Class9_Sub1("fly trap", "A small carnivourous plant", "approach", "Search", 0, 1, 1, 0, "jungle fly trap"));
        objects.add(new Class9_Sub1("Fern", "An exotic leafy plant", "WalkTo", "Examine", 0, 1, 1, 0, "jungle fern"));
        objects.add(new Class9_Sub1("Fern", "An exotic spikey plant", "WalkTo", "Examine", 0, 1, 1, 0, "jungle spikey fern"));
        objects.add(new Class9_Sub1("plant", "What an unusual plant", "WalkTo", "Examine", 0, 1, 1, 0, "jungle strange plant"));
        objects.add(new Class9_Sub1("plant", "An odd looking plant", "WalkTo", "Examine", 1, 1, 1, 0, "jungle strange plant 2"));
        objects.add(new Class9_Sub1("plant", "some nice jungle foliage", "WalkTo", "Examine", 1, 1, 1, 0, "jungle medium size plant"));
        objects.add(new Class9_Sub1("stone head", "It looks like it's been here some time", "WalkTo", "Examine", 1, 2, 2, 0, "jungle statue"));
        objects.add(new Class9_Sub1("dead Tree", "A rotting tree", "WalkTo", "Examine", 1, 1, 1, 0, "deadtree2"));
        objects.add(new Class9_Sub1("sacks", "Yep they're sacks", "WalkTo", "prod", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("khazard open Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("khazard shut Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("doorframe", "It's a stone doorframe", "WalkTo", "Examine", 3, 1, 2, 0, "doubledoorframe"));
        objects.add(new Class9_Sub1("Sewer valve", "It changes the water flow of the sewer's", "turn left", "turn right", 1, 1, 1, 0, "sewervalve"));
        objects.add(new Class9_Sub1("Sewer valve 2", "It changes the water flow of the sewer's", "turn left", "turn right", 1, 1, 1, 0, "sewervalve"));
        objects.add(new Class9_Sub1("Sewer valve 3", "It changes the water flow of the sewer's", "turn left", "turn right", 1, 1, 1, 0, "sewervalve"));
        objects.add(new Class9_Sub1("Sewer valve 4", "It changes the water flow of the sewer's", "turn left", "turn right", 1, 1, 1, 0, "sewervalve"));
        objects.add(new Class9_Sub1("Sewer valve 5", "It changes the water flow of the sewer's", "turn left", "turn right", 1, 1, 1, 0, "sewervalve"));
        objects.add(new Class9_Sub1("Cave entrance", "I wonder what is inside...", "enter", "Examine", 1, 2, 2, 0, "caveentrance"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "logbridgelow"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "logbridgehigh"));
        objects.add(new Class9_Sub1("tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "treeplatformhigh"));
        objects.add(new Class9_Sub1("tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "treeplatformlow"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "close", "Examine", 2, 1, 2, 0, "metalgateopen2"));
        objects.add(new Class9_Sub1("tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "largetreeplatformlow"));
        objects.add(new Class9_Sub1("tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "largetreeplatformhigh"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "logbridgecurvedhigh"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "logbridgecurvedlow"));
        objects.add(new Class9_Sub1("tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "treeplatformlow2"));
        objects.add(new Class9_Sub1("tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "treeplatformhigh2"));
        objects.add(new Class9_Sub1("Tribal brew", "A very large pot", "WalkTo", "drink", 1, 1, 1, 0, "cauldron"));
        objects.add(new Class9_Sub1("Pineapple tree", "A tree with nice ripe pineapples growing on it", "WalkTo", "Pick pineapple", 1, 1, 1, 0, "palm2"));
        objects.add(new Class9_Sub1("Pineapple tree", "There are no pineapples left on the tree", "WalkTo", "Pick pineapple", 1, 1, 1, 0, "palm2"));
        objects.add(new Class9_Sub1("log raft", "A mighty fine raft", "board", "Examine", 0, 1, 1, 96, "lograft"));
        objects.add(new Class9_Sub1("log raft", "A mighty fine raft", "board", "Examine", 0, 1, 1, 96, "lograft"));
        objects.add(new Class9_Sub1("Tomb of hazeel", "A clay shrine to lord hazeel", "WalkTo", "Examine", 1, 1, 2, 96, "hazeeltomb"));
        objects.add(new Class9_Sub1("range", "A pot of soup slowly cooking", "WalkTo", "Examine", 1, 1, 2, 0, "range"));
        objects.add(new Class9_Sub1("Bookcase", "A large collection of books", "Search", "Examine", 1, 1, 2, 0, "bookcase"));
        objects.add(new Class9_Sub1("Carnillean Chest", "Perhaps I should search it", "WalkTo", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Carnillean Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("crate", "A crate used for storing food", "Search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("Butlers cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("Butlers cupboard", "The cupboard is open", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "WalkTo", "Examine", 2, 1, 2, 0, "woodengateopen"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("Cattle furnace", "A red hot furnace", "WalkTo", "Examine", 1, 2, 2, 0, "furnace"));
        objects.add(new Class9_Sub1("Ardounge wall", "A huge wall seperating east and west ardounge", "WalkTo", "Examine", 1, 1, 3, 0, "ardoungewall"));
        objects.add(new Class9_Sub1("Ardounge wall corner", "A huge wall seperating east and west ardounge", "WalkTo", "Examine", 1, 1, 1, 0, "ardoungewallcorner"));
        objects.add(new Class9_Sub1("Dug up soil", "A freshly dug pile of mud", "WalkTo", "Examine", 0, 1, 1, 0, "mudpatch"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud caved in from above", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("large Sewer pipe", "a dirty sewer pipe", "enter", "Examine", 1, 1, 1, 0, "largesewerpipe"));
        objects.add(new Class9_Sub1("Ardounge wall gateway", "A huge set of heavy wooden doors", "open", "Examine", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is open", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("Fishing crane", "For hauling in large catches of fish", "operate", "Examine", 1, 1, 2, 0, "fishingcrane"));
        objects.add(new Class9_Sub1("Rowboat", "A reasonably sea worthy two man boat", "WalkTo", "Examine", 1, 2, 2, 0, "rowboat"));
        objects.add(new Class9_Sub1("Damaged Rowboat", "A not so sea worthy two man boat", "WalkTo", "Examine", 1, 2, 2, 0, "rowboatsinking"));
        objects.add(new Class9_Sub1("barrel", "I wonder what's inside", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Fishing crane", "For hauling in large catches of fish", "operate", "Examine", 1, 1, 1, 0, "fishingcranerot1"));
        objects.add(new Class9_Sub1("Fishing crane", "For hauling in large catches of fish", "operate", "Examine", 1, 1, 1, 0, "fishingcranerot2"));
        objects.add(new Class9_Sub1("Waterfall", "it's a waterfall", "WalkTo", "Examine", 2, 1, 2, 0, "waterfall"));
        objects.add(new Class9_Sub1("leaflessTree", "A pointy tree", "jump off", "jump to next", 1, 1, 1, 0, "deadtree2base"));
        objects.add(new Class9_Sub1("leaflessTree", "A pointy tree", "jump off", "jump to next", 1, 1, 1, 0, "deadtree2base"));
        objects.add(new Class9_Sub1("log raft", "A mighty fine raft", "board", "Examine", 0, 1, 1, 96, "lograft"));
        objects.add(new Class9_Sub1("doors", "The doors are shut", "Open", "Examine", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("Well", "An oddly placed well", "operate", "Examine", 1, 2, 2, 0, "well"));
        objects.add(new Class9_Sub1("Tomb of glarial", "A stone tomb surrounded by flowers", "Search", "Examine", 1, 2, 4, 96, "elventomb"));
        objects.add(new Class9_Sub1("Waterfall", "it's a fast flowing waterfall", "jump off", "Examine", 2, 1, 2, 0, "waterfalllev1"));
        objects.add(new Class9_Sub1("Waterfall", "it's a fast flowing waterfall", "jump off", "Examine", 0, 1, 2, 0, "waterfalllev2"));
        objects.add(new Class9_Sub1("Bookcase", "A large collection of books", "Search", "Examine", 1, 1, 2, 0, "bookcase"));
        objects.add(new Class9_Sub1("doors", "The doors are shut", "Open", "Examine", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("doors", "The doors are shut", "Open", "Examine", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("Stone stand", "On top is an indent the size of a rune stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonestand"));
        objects.add(new Class9_Sub1("Stone stand", "On top is an indent the size of a rune stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonestand"));
        objects.add(new Class9_Sub1("Stone stand", "On top is an indent the size of a rune stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonestand"));
        objects.add(new Class9_Sub1("Stone stand", "On top is an indent the size of a rune stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonestand"));
        objects.add(new Class9_Sub1("Stone stand", "On top is an indent the size of a rune stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonestand"));
        objects.add(new Class9_Sub1("Stone stand", "On top is an indent the size of a rune stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonestand"));
        objects.add(new Class9_Sub1("Glarial's Gravestone", "There is an indent the size of a pebble in the stone's center", "read", "Examine", 1, 1, 1, 0, "gravestone1"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("crate", "It's a crate", "Search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("leaflessTree", "A pointy tree", "jump off", "Examine", 1, 1, 1, 0, "deadtree2base"));
        objects.add(new Class9_Sub1("Statue of glarial", "A statue of queen glarial - something's missing", "WalkTo", "Examine", 1, 1, 1, 0, "glarialsstatue"));
        objects.add(new Class9_Sub1("Chalice of eternity", "A magically elevated chalice full of treasure", "WalkTo", "Examine", 1, 1, 1, 0, "baxtorianchalice"));
        objects.add(new Class9_Sub1("Chalice of eternity", "A magically elevated chalice full of treasure", "empty", "Examine", 1, 1, 1, 0, "baxtorianchalicelow"));
        objects.add(new Class9_Sub1("doors", "The doors are shut", "Open", "Examine", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "pull", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "pull", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("log raft remains", "oops!", "WalkTo", "Examine", 0, 1, 1, 96, "brokenlograft"));
        objects.add(new Class9_Sub1("Tree", "A pointy tree", "WalkTo", "Examine", 0, 1, 1, 0, "tree2"));
        objects.add(new Class9_Sub1(" Range", "A hot well stoked range", "WalkTo", "Examine", 1, 1, 2, 0, "range"));
        objects.add(new Class9_Sub1("crate", "It's an old crate", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "Net", "Examine", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("Watch tower", "They're always watching", "approach", "Examine", 1, 2, 2, 0, "watchtower"));
        objects.add(new Class9_Sub1("signpost", "Tourist infomation", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("doors", "The doors are open", "WalkTo", "Examine", 2, 1, 2, 0, "doubledoorsopen"));
        objects.add(new Class9_Sub1("Rope ladder", "A hand made ladder", "WalkTo", "Examine", 1, 1, 1, 0, "ropeladder"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("Rope ladder", "A hand made ladder", "WalkTo", "Examine", 1, 1, 1, 0, "ropeladder"));
        objects.add(new Class9_Sub1("Cooking pot", "the mourners are busy enjoying this stew", "WalkTo", "Examine", 1, 1, 1, 0, "cauldron"));
        objects.add(new Class9_Sub1("Gallow", "Best not hang about!", "WalkTo", "Examine", 1, 2, 2, 0, "gallows"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("crate", "A crate used for storing confiscated goods", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("sign", "Tailors fancy dress", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("grand tree", "the grand tree", "WalkTo", "Examine", 0, 1, 1, 0, "grand tree-lev 0"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "WalkTo", "close", 2, 1, 2, 0, "woodengateopen"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 1, 1, 0, "logbridge lev0"));
        objects.add(new Class9_Sub1("Watch tower", "A tree gnome construction", "WalkTo", "Examine", 1, 1, 1, 0, "gnomewatchtower lev0"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 0, 0, 0, "logbridgejunction lev0"));
        objects.add(new Class9_Sub1("climbing rocks", "I wonder if I can climb up these", "climb", "Examine", 0, 1, 1, 0, "climbing_rocks"));
        objects.add(new Class9_Sub1("Ledge", "It looks rather thin", "balance on", "Examine", 0, 1, 0, 0, "corner_ledge"));
        objects.add(new Class9_Sub1("Ledge", "It looks rather thin", "balance on", "Examine", 0, 1, 1, 0, "straight_ledge"));
        objects.add(new Class9_Sub1("log", "It looks slippery", "WalkTo", "Examine", 0, 1, 1, 0, "log_balance1"));
        objects.add(new Class9_Sub1("log", "It looks slippery", "WalkTo", "Examine", 0, 1, 1, 0, "log_balance2"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("PalmTree", "A shady palm tree", "WalkTo", "Search", 1, 1, 1, 0, "palm"));
        objects.add(new Class9_Sub1("Scorched Earth", "An area of burnt soil", "WalkTo", "Search", 0, 1, 1, 0, "mudpatch"));
        objects.add(new Class9_Sub1("Rocks", "A moss covered rock", "Mine", "Search", 1, 1, 1, 0, "mossyrock"));
        objects.add(new Class9_Sub1("sign", "The dancing donkey inn", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "harpoon", "cage", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("Rocky Walkway", "A precarious rocky walkway", "Balance", "Examine", 1, 1, 1, 0, "rocktile"));
        objects.add(new Class9_Sub1("Rocky Walkway", "A precarious rocky walkway", "Balance", "Examine", 1, 1, 1, 0, "rocktile"));
        objects.add(new Class9_Sub1("Rocky Walkway", "A precarious rocky walkway", "Balance", "Examine", 1, 1, 1, 0, "rocktile"));
        objects.add(new Class9_Sub1("Rocky Walkway", "A precarious rocky walkway", "Balance", "Examine", 1, 1, 1, 0, "rocktile"));
        objects.add(new Class9_Sub1("fight Dummy", "I can practice my fighting here", "hit", "Examine", 1, 1, 1, 0, "sworddummy"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Jungle Vine", "A deep jungle Vine", "WalkTo", "Search", 0, 1, 1, 0, "vine"));
        objects.add(new Class9_Sub1("statue", "hand carved", "WalkTo", "Examine", 1, 1, 1, 0, "tribalstature"));
        objects.add(new Class9_Sub1("sign", "Ye Olde Dragon Inn", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("grand tree", "the grand tree", "WalkTo", "Examine", 0, 1, 1, 0, "grand treeinside-lev 0"));
        objects.add(new Class9_Sub1("grand tree", "the grand tree", "WalkTo", "Examine", 0, 1, 1, 0, "grand treeinside-lev 1"));
        objects.add(new Class9_Sub1("grand tree", "the grand tree", "WalkTo", "Examine", 0, 1, 1, 0, "grand treeinside-lev 2"));
        objects.add(new Class9_Sub1("grand tree", "the grand tree", "WalkTo", "Examine", 0, 1, 1, 0, "grand tree-lev 1"));
        objects.add(new Class9_Sub1("grand tree", "the grand tree", "WalkTo", "Examine", 0, 1, 1, 0, "grand tree-lev 2"));
        objects.add(new Class9_Sub1("Hillside Entrance", "Large doors that seem to lead into the hillside", "Open", "Search", 2, 1, 2, 0, "hillsidedoor"));
        objects.add(new Class9_Sub1("tree", "A large exotic looking tree", "WalkTo", "Search", 1, 1, 1, 0, "jungle medium size plant"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 0, 0, 0, "logbridgejunction lev1"));
        objects.add(new Class9_Sub1("Tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 0, 0, 0, "fourwayplatform-lev 0"));
        objects.add(new Class9_Sub1("Tree platform", "A tree gnome construction", "WalkTo", "Examine", 0, 0, 0, 0, "fourwayplatform-lev 1"));
        objects.add(new Class9_Sub1("Metalic Dungeon Gate", "It seems to be closed", "Open", "Search", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 0, 0, 0, "logbridge lev1"));
        objects.add(new Class9_Sub1("Log bridge", "A tree gnome construction", "WalkTo", "Examine", 0, 0, 0, 0, "logbridge lev2"));
        objects.add(new Class9_Sub1("Watch tower", "A tree gnome construction", "WalkTo", "Examine", 1, 0, 0, 0, "gnomewatchtower lev1"));
        objects.add(new Class9_Sub1("Watch tower", "A tree gnome construction", "WalkTo", "Examine", 1, 0, 0, 0, "gnomewatchtower lev2"));
        objects.add(new Class9_Sub1("Shallow water", "A small opening in the ground with some spots of water", "WalkTo", "Investigate", 1, 2, 2, 0, "rockpoolwater"));
        objects.add(new Class9_Sub1("Doors", "Perhaps you should give them a push", "Open", "Search", 2, 1, 2, 0, "hillsidedoor"));
        objects.add(new Class9_Sub1("grand tree", "the grand tree", "WalkTo", "Examine", 0, 1, 1, 0, "grand tree-lev 3"));
        objects.add(new Class9_Sub1("Tree Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 0, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Tree Ladder", "it's a ladder leading downwards", "Climb-down", "Examine", 0, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("blurberrys cocktail bar", "the gnome social hot spot", "WalkTo", "Examine", 0, 1, 1, 0, "blurberrybar"));
        objects.add(new Class9_Sub1("Gem Rocks", "A rocky outcrop with a vein of semi precious stones", "Mine", "Prospect", 1, 1, 1, 0, "gemrock"));
        objects.add(new Class9_Sub1("Giannes place", "Eat green eat gnome cruisine", "WalkTo", "Examine", 0, 1, 1, 0, "blurberrybar"));
        objects.add(new Class9_Sub1("ropeswing", "A good place to train agility", "WalkTo", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("net", "A good place to train agility", "WalkTo", "Examine", 1, 2, 1, 0, "obstical_net"));
        objects.add(new Class9_Sub1("Frame", "A good place to train agility", "WalkTo", "Examine", 1, 1, 1, 0, "obstical_frame"));
        objects.add(new Class9_Sub1("Tree", "It has a branch ideal for tying ropes to", "WalkTo", "Examine", 1, 2, 2, 0, "tree_for_rope"));
        objects.add(new Class9_Sub1("Tree", "I wonder who put that rope there", "WalkTo", "Examine", 1, 2, 2, 0, "tree_with_rope"));
        objects.add(new Class9_Sub1("Tree", "they look fun to swing on", "WalkTo", "Examine", 1, 2, 2, 0, "tree_with_vines"));
        objects.add(new Class9_Sub1("cart", "A farm cart", "WalkTo", "Search", 1, 2, 3, 0, "cart"));
        objects.add(new Class9_Sub1("fence", "it doesn't look too strong", "WalkTo", "Examine", 1, 1, 1, 0, "gnomefence"));
        objects.add(new Class9_Sub1("beam", "A plank of wood", "WalkTo", "Examine", 0, 1, 1, 0, "beam"));
        objects.add(new Class9_Sub1("Sign", "read me", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Blurberry's cocktail bar", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Giannes tree gnome cuisine", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Heckel funch's grocery store", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Hudo glenfad's grocery store", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Rometti's fashion outlet", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Tree gnome bank and rometti's fashion outlet", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Tree gnome local swamp", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "Agility training course", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Sign", "To the grand tree", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Root", "To the grand tree", "search", "Examine", 1, 1, 1, 0, "treeroot1"));
        objects.add(new Class9_Sub1("Root", "To the grand tree", "search", "Examine", 1, 1, 1, 0, "treeroot2"));
        objects.add(new Class9_Sub1("Metal Gate", "The gate is closed", "Open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Metal Gate", "The gate is open", "WalkTo", "close", 2, 1, 2, 0, "metalgateopen"));
        objects.add(new Class9_Sub1("A farm cart", "It is blocking the entrance to the village", "Examine", "Search", 1, 2, 3, 0, "cart"));
        objects.add(new Class9_Sub1("Ledge", "It looks rather thin", "balance on", "Examine", 0, 1, 1, 0, "straight_ledge"));
        objects.add(new Class9_Sub1("Ledge", "It looks rather thin", "balance on", "Examine", 0, 1, 1, 0, "straight_ledge"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("cage", "i don't like the look of that", "open", "Examine", 0, 1, 1, 0, "gnomecage"));
        objects.add(new Class9_Sub1("glider", "i wonder if it flys", "fly", "Examine", 1, 1, 1, 0, "gnomeglider"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("cupboard", "Perhaps I should search it", "Search", "close", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("stairs", "These lead upstairs", "Go up", "Examine", 1, 2, 3, 0, "woodenstairs"));
        objects.add(new Class9_Sub1("glider", "i wonder if it flys", "WalkTo", "Examine", 1, 1, 1, 0, "gnomeglidercrashed"));
        objects.add(new Class9_Sub1("gate", "The gate is open", "WalkTo", "close", 1, 1, 2, 0, "woodengateopen"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 1, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("chaos altar", "An altar to the evil God Zamorak", "Recharge at", "Examine", 1, 2, 1, 0, "chaosaltar"));
        objects.add(new Class9_Sub1("Gnome stronghold gate", "The gate is closed", "Open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("ropeswing", "A good place to train agility", "Swing", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("ropeswing", "A good place to train agility", "Swing", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("stairs", "These lead upstairs", "Go up", "Examine", 1, 2, 3, 0, "woodenstairs"));
        objects.add(new Class9_Sub1("stairs", "These lead downstairs", "Go down", "Examine", 1, 2, 3, 0, "woodenstairsdown"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Pile of rubble", "What a mess", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Stone stand", "On top our four indents from left to right", "WalkTo", "push down", 1, 1, 1, 0, "stonestand"));
        objects.add(new Class9_Sub1("Watch tower", "A tree gnome construction", "climb up", "Examine", 1, 1, 1, 0, "gnomewatchtower lev1"));
        objects.add(new Class9_Sub1("Pile of rubble", "What a mess", "climb", "Examine", 1, 2, 1, 0, "mudpiledown"));
        objects.add(new Class9_Sub1("Root", "To the grand tree", "search", "Examine", 1, 1, 1, 0, "treeroot2"));
        objects.add(new Class9_Sub1("Root", "To the grand tree", "push", "Examine", 1, 1, 1, 0, "treeroot2"));
        objects.add(new Class9_Sub1("Root", "To the grand tree", "push", "Examine", 1, 1, 1, 0, "treeroot2"));
        objects.add(new Class9_Sub1("Sign", "Home to the Head tree guardian", "WalkTo", "Examine", 1, 1, 1, 0, "gnomesign"));
        objects.add(new Class9_Sub1("Hammock", "They've got to sleep somewhere", "lie in", "Examine", 1, 1, 2, 0, "gnomehamek"));
        objects.add(new Class9_Sub1("Goal", "You're supposed to throw the ball here", "WalkTo", "Examine", 0, 1, 1, 0, "gnomegoal"));
        objects.add(new Class9_Sub1("stone tile", "It looks as if it might move", "twist", "Examine", 1, 1, 1, 0, "stonedisc"));
        objects.add(new Class9_Sub1("Chest", "You get a sense of dread from the chest", "WalkTo", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "You get a sense of dread from the chest", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Watch tower", "A tree gnome construction", "WalkTo", "climb down", 0, 1, 1, 0, "gnomewatchtower lev2"));
        objects.add(new Class9_Sub1("net", "A good place to train agility", "climb", "Examine", 1, 2, 1, 0, "obstical_net"));
        objects.add(new Class9_Sub1("Watch tower", "A tree gnome construction", "climb up", "Examine", 1, 1, 1, 0, "gnomewatchtower lev1"));
        objects.add(new Class9_Sub1("Watch tower", "A tree gnome construction", "climb down", "Examine", 1, 1, 1, 0, "gnomewatchtower lev2"));
        objects.add(new Class9_Sub1("ropeswing", "A good place to train agility", "grab hold of", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("Bumpy Dirt", "Some disturbed earth", "Look", "Search", 0, 1, 1, 0, "mudpatch"));
        objects.add(new Class9_Sub1("pipe", "a dirty sewer pipe", "WalkTo", "Examine", 1, 1, 1, 0, "obstical_pipe"));
        objects.add(new Class9_Sub1("net", "A good place to train agility", "climb", "Examine", 1, 2, 1, 0, "obstical_net"));
        objects.add(new Class9_Sub1("pipe", "a dirty sewer pipe", "enter", "Examine", 1, 1, 1, 0, "obstical_pipe"));
        objects.add(new Class9_Sub1("log", "It looks slippery", "balance on", "Examine", 0, 1, 1, 0, "log_balance1"));
        objects.add(new Class9_Sub1("pipe", "a dirty sewer pipe", "enter", "Examine", 1, 1, 1, 0, "obstical_pipe"));
        objects.add(new Class9_Sub1("pipe", "a dirty sewer pipe", "enter", "Examine", 0, 1, 1, 0, "obstical_pipe"));
        objects.add(new Class9_Sub1("Handholds", "I wonder if I can climb up these", "climb", "Examine", 0, 1, 1, 0, "climbing_rocks"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("stronghold spirit Tree", "Ancestor of the spirit tree", "talk to", "Examine", 1, 1, 1, 0, "tree2"));
        objects.add(new Class9_Sub1("Tree", "It has a branch ideal for tying ropes to", "WalkTo", "Examine", 1, 2, 2, 0, "tree_for_rope"));
        objects.add(new Class9_Sub1("Tree", "I wonder who put that rope there", "swing on", "Examine", 1, 2, 2, 0, "tree_with_rope"));
        objects.add(new Class9_Sub1("Tree", "I wonder who put that rope there", "swing on", "Examine", 1, 2, 2, 0, "tree_with_rope"));
        objects.add(new Class9_Sub1("Spiked pit", "I don't want to go down there", "WalkTo", "Examine", 1, 2, 2, 0, "spikedpit-low"));
        objects.add(new Class9_Sub1("Spiked pit", "I don't want to go down there", "WalkTo", "Examine", 1, 2, 2, 0, "spikedpit"));
        objects.add(new Class9_Sub1("Cave", "I wonder what is inside...", "enter", "Examine", 1, 2, 2, 0, "caveentrance"));
        objects.add(new Class9_Sub1("stone pebble", "Looks like a stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonedisc"));
        objects.add(new Class9_Sub1("Pile of rubble", "Rocks that have caved in", "WalkTo", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Pile of rubble", "Rocks that have caved in", "WalkTo", "Search", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("pipe", "I might be able to fit through this", "enter", "Examine", 1, 1, 1, 0, "obstical_pipe"));
        objects.add(new Class9_Sub1("pipe", "2", "enter", "Examine", 1, 1, 1, 0, "obstical_pipe"));
        objects.add(new Class9_Sub1("Stone", "Looks like a stone", "WalkTo", "Examine", 1, 1, 1, 0, "stonedisc"));
        objects.add(new Class9_Sub1("Stone", "Looks like a stone", "Look Closer", "Investigate", 1, 1, 1, 0, "stonedisc"));
        objects.add(new Class9_Sub1("ropeswing", "A good place to train agility", "Swing", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("log", "It looks slippery", "balance on", "Examine", 0, 1, 1, 0, "log_balance1"));
        objects.add(new Class9_Sub1("net", "A good place to train agility", "Climb Up", "Examine", 1, 2, 1, 0, "obstical_net"));
        objects.add(new Class9_Sub1("Ledge", "It looks rather thin", "balance on", "Examine", 0, 1, 1, 0, "straight_ledge"));
        objects.add(new Class9_Sub1("Handholds", "I wonder if I can climb up these", "climb", "Examine", 0, 1, 1, 0, "climbing_rocks"));
        objects.add(new Class9_Sub1("log", "It looks slippery", "balance on", "Examine", 0, 1, 1, 0, "log_balance1"));
        objects.add(new Class9_Sub1("log", "It looks slippery", "balance on", "Examine", 0, 1, 1, 0, "log_balance1"));
        objects.add(new Class9_Sub1("Rotten Gallows", "A human corpse hangs from the noose", "Look", "Search", 1, 2, 2, 0, "gallows"));
        objects.add(new Class9_Sub1("Pile of rubble", "Rocks that have caved in", "WalkTo", "Search", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("ropeswing", "I wonder what's over here", "Swing", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("ropeswing", "I wonder what's over here", "Swing", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("ocks", "A moss covered rock", "balance", "Examine", 1, 1, 1, 0, "mossyrock"));
        objects.add(new Class9_Sub1("Tree", "This tree doesn't look too healthy", "WalkTo", "balance", 1, 1, 1, 0, "deadtree1"));
        objects.add(new Class9_Sub1("Well stacked rocks", "Rocks that have been stacked at regular intervals", "Investigate", "Search", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Tomb Dolmen", "An ancient construct for displaying the bones of the deceased", "Look", "Search", 1, 2, 2, 0, "dolmen"));
        objects.add(new Class9_Sub1("Handholds", "I wonder if I can climb up these", "Climb", "Examine", 0, 1, 1, 0, "climbing_rocks"));
        objects.add(new Class9_Sub1("Bridge Blockade", "A crudely constructed fence to stop you going further", "Investigate", "Jump", 1, 1, 1, 0, "gnomefence"));
        objects.add(new Class9_Sub1("Log Bridge", "A slippery log that is a make-do bridge", "Balance On", "Examine", 0, 1, 1, 0, "log_balance2"));
        objects.add(new Class9_Sub1("Handholds", "I wonder if I can climb up these", "climb", "Examine", 0, 1, 1, 0, "climbing_rocks"));
        objects.add(new Class9_Sub1("Tree", "they look fun to swing on", "Swing on", "Examine", 1, 2, 2, 0, "tree_with_vines"));
        objects.add(new Class9_Sub1("Tree", "they look fun to swing on", "Swing on", "Examine", 1, 2, 2, 0, "tree_with_vines"));
        objects.add(new Class9_Sub1("Wet rocks", "A rocky outcrop", "Look", "Search", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Smashed table", "This table has seen better days", "Examine", "Craft", 1, 1, 1, 0, "smashedtable"));
        objects.add(new Class9_Sub1("Crude Raft", "A crudely constructed raft", "Disembark", "Examine", 0, 1, 1, 96, "lograft"));
        objects.add(new Class9_Sub1("Daconia rock", "Piles of daconia rock", "Mine", "Prospect", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("statue", "A statue to mark Taie Bwo Wannai sacred grounds", "WalkTo", "Examine", 1, 1, 1, 0, "tribalstature"));
        objects.add(new Class9_Sub1("Stepping stones", "A rocky outcrop", "Balance", "Jump onto", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("gate", "Enter to balance into an agility area", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("gate", "Enter to balance into an agility area", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("pipe", "It looks a tight squeeze", "enter", "Examine", 1, 1, 1, 0, "obstical_pipe"));
        objects.add(new Class9_Sub1("ropeswing", "A good place to train agility", "Swing", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("Stone", "Looks like a stone", "balance on", "Examine", 1, 1, 1, 0, "stonedisc"));
        objects.add(new Class9_Sub1("Ledge", "It doesn't look stable", "balance on", "Examine", 0, 1, 1, 0, "straight_ledge"));
        objects.add(new Class9_Sub1("Vine", "A creepy creeper", "climb up", "Examine", 0, 1, 1, 0, "vinecorner"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "WalkTo", "Climb", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Wooden Gate", "The gate is open", "Close", "Close", 2, 1, 2, 0, "woodengateopen"));
        objects.add(new Class9_Sub1("Wooden Gate", "The gate is closed", "Open", "Examine", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("Stone bridge", "An ancient stone construction", "WalkTo", "Examine", 0, 1, 1, 0, "bridge section 1"));
        objects.add(new Class9_Sub1("Stone bridge", "An ancient stone construction", "WalkTo", "Examine", 0, 1, 1, 0, "bridge section 2"));
        objects.add(new Class9_Sub1("Stone bridge", "An ancient stone construction", "WalkTo", "Examine", 0, 1, 1, 0, "bridge section 3"));
        objects.add(new Class9_Sub1("Stone bridge", "An ancient stone construction", "WalkTo", "Examine", 0, 1, 1, 0, "cave bridge support"));
        objects.add(new Class9_Sub1("Stone platform", "An ancient stone construction", "WalkTo", "Examine", 0, 1, 1, 0, "cave platform small"));
        objects.add(new Class9_Sub1("fence", "it doesn't look too strong", "WalkTo", "Examine", 1, 1, 1, 0, "gnomefence2"));
        objects.add(new Class9_Sub1("Rocks", "A rocky outcrop", "Climb", "Climb", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 3, 1, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 3, 1, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Gate of Iban", "It doesn't look very inviting", "open", "Examine", 1, 3, 1, 0, "rams skull door"));
        objects.add(new Class9_Sub1("Wooden Door", "It doesn't look very inviting", "cross", "Examine", 1, 3, 1, 0, "rams skull dooropen"));
        objects.add(new Class9_Sub1("Tomb Dolmen", "An ancient construct for displaying the bones of the deceased", "Look", "Search", 1, 2, 2, 0, "dolmen"));
        objects.add(new Class9_Sub1("Cave entrance", "It doesn't look very inviting", "enter", "Examine", 1, 3, 1, 0, "caveentrance2"));
        objects.add(new Class9_Sub1("Old bridge", "That's been there a while", "WalkTo", "Examine", 1, 3, 1, 0, "cave old bridge"));
        objects.add(new Class9_Sub1("Old bridge", "That's been there a while", "cross", "Examine", 1, 3, 1, 0, "cave old bridgedown"));
        objects.add(new Class9_Sub1("Crumbled rock", "climb up to above ground", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("stalagmite", "Formed over thousands of years", "WalkTo", "Examine", 1, 1, 1, 0, "cave large stagamite"));
        objects.add(new Class9_Sub1("stalagmite", "Formed over thousands of years", "WalkTo", "Examine", 1, 1, 1, 0, "cave small stagamite"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Lever", "Seems to be some sort of winch", "pull", "Examine", 1, 1, 1, 0, "cave lever"));
        objects.add(new Class9_Sub1("stalactite", "Formed over thousands of years", "WalkTo", "Examine", 0, 1, 1, 0, "cave large stagatite"));
        objects.add(new Class9_Sub1("stalactite", "Formed over thousands of years", "WalkTo", "Examine", 0, 1, 1, 0, "cave small stagatite"));
        objects.add(new Class9_Sub1("stalactite", "Formed over thousands of years", "climb", "Examine", 0, 1, 1, 0, "cave extra large stagatite"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Swamp", "That smells horrid", "step over", "Examine", 1, 1, 1, 0, "cave swampbubbles"));
        objects.add(new Class9_Sub1("Swamp", "That smells horrid", "WalkTo", "Examine", 1, 1, 1, 0, "cave swampbubbles"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud caved in from above", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Travel Cart", "A sturdy cart for travelling in", "Board", "Look", 1, 2, 3, 0, "cart"));
        objects.add(new Class9_Sub1("Travel Cart", "A sturdy cart for travelling in", "Board", "Look", 1, 2, 3, 0, "cart"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "mine", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("stalactite", "Formed over thousands of years", "WalkTo", "Examine", 0, 1, 1, 0, "cave large stagatite"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "Examine", 1, 2, 2, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "WalkTo", "Examine", 1, 2, 2, 0, "cave rocktrap1a"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "WalkTo", "Examine", 1, 1, 3, 0, "cave swamprocks"));
        objects.add(new Class9_Sub1("sign", "The Paramaya Hostel", "WalkTo", "Examine", 0, 1, 1, 0, "shopsign"));
        objects.add(new Class9_Sub1("Ladder", "A ladder that leads to the dormitory - a ticket is needed", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Spiked pit", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrapa"));
        objects.add(new Class9_Sub1("signpost", "To the Furnace", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("Ship", "A sea faring ship called 'Lady Of The Waves'", "board", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("Ship", "A sea faring ship called 'Lady Of The Waves'", "board", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("sacks", "Yep they're sacks", "WalkTo", "Search", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("Zamorakian Temple", "Scary!", "WalkTo", "Examine", 0, 1, 1, 0, "cave temple"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Grill", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrap"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "walk here", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "walk here", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Tomb Doors", "Ornately carved wooden doors depicting skeletal warriors", "Open", "Search", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("Swamp", "That smells horrid", "step over", "Examine", 1, 1, 1, 0, "cave swampbubbles"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "Examine", 1, 2, 1, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "Examine", 1, 2, 1, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("stalactite", "Formed over thousands of years", "WalkTo", "Examine", 0, 1, 1, 0, "cave extra large stagatite"));
        objects.add(new Class9_Sub1("stalactite", "Formed over thousands of years", "WalkTo", "Examine", 0, 1, 1, 0, "cave extra large stagatite"));
        objects.add(new Class9_Sub1("Spiked pit", "They looks suspicious", "walk over", "Examine", 1, 1, 1, 0, "cave grilltrapa up"));
        objects.add(new Class9_Sub1("Lever", "Seems to be some sort of winch", "pull", "Examine", 1, 1, 1, 0, "cave lever"));
        objects.add(new Class9_Sub1("Cage", "Seems to be mechanical ", "WalkTo", "Examine", 1, 1, 1, 0, "cave grillcage"));
        objects.add(new Class9_Sub1("Cage", "Seems to be mechanical ", "WalkTo", "Examine", 1, 1, 1, 0, "cave grillcageup"));
        objects.add(new Class9_Sub1("Rocks", "More rocks!", "step over", "search for traps", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Spear trap", "Ouch!", "WalkTo", "Examine", 1, 1, 1, 0, "cave speartrapa"));
        objects.add(new Class9_Sub1("Rocks", "More rocks!", "step over", "search", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Rocks", "More rocks!", "step over", "search", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Rocks", "More rocks!", "step over", "search", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Rocks", "More rocks!", "step over", "search", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Rocks", "More rocks!", "step over", "search", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Rocks", "More rocks!", "step over", "search", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "drop down", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Furnace", "Charred bones are slowly burning inside", "WalkTo", "Examine", 1, 1, 1, 0, "cave furnace"));
        objects.add(new Class9_Sub1("Well", "The remains of a warrior slump over the strange construction", "drop down", "Examine", 1, 1, 1, 0, "cave well"));
        objects.add(new Class9_Sub1("Passage", "A strange metal grill covers the passage", "walk down", "Examine", 1, 2, 1, 0, "cave tubetrap"));
        objects.add(new Class9_Sub1("Passage", "The passage way has swung down to a vertical position", "climb up", "Examine", 1, 2, 1, 0, "cave tubetrapa"));
        objects.add(new Class9_Sub1("Passage", "The passage way has swung down to a vertical position", "climb up rope", "Examine", 1, 2, 1, 0, "cave tubetrapa rope"));
        objects.add(new Class9_Sub1("stalagmite", "Formed over thousands of years", "search", "Examine", 1, 1, 1, 0, "cave large stagamite"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "search", 1, 2, 2, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "search", 1, 2, 2, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "search", 1, 2, 2, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "search", 1, 2, 2, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "search", 1, 2, 2, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Rocks", "You should be able to move these", "clear", "search", 1, 2, 2, 0, "cave rocktrap1"));
        objects.add(new Class9_Sub1("Passage", "Looks suspicous!", "Walk here", "search", 1, 1, 1, 0, "cave snaptrap"));
        objects.add(new Class9_Sub1("snap trap", "aaaarghh", "WalkTo", "Examine", 1, 1, 1, 0, "cave snaptrapa"));
        objects.add(new Class9_Sub1("Wooden planks", "You can walk across these", "WalkTo", "Examine", 1, 1, 1, 0, "cave planks"));
        objects.add(new Class9_Sub1("Passage", "Looks suspicous!", "Walk here", "search", 1, 1, 1, 0, "cave snaptrap"));
        objects.add(new Class9_Sub1("Passage", "Looks suspicous!", "Walk here", "search", 1, 1, 1, 0, "cave snaptrap"));
        objects.add(new Class9_Sub1("Flames of zamorak", "Careful", "search", "Examine", 1, 2, 2, 0, "cave bloodwell"));
        objects.add(new Class9_Sub1("Platform", "An ancient construction", "WalkTo", "Examine", 1, 1, 1, 0, "cave platform verysmall"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("wall grill", "It seems to filter the rotten air through the caverns", "climb up", "Examine", 1, 1, 1, 0, "cave wallgrill"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to make to the other side", "jump off", "climb up", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("wall grill", "It seems to filter the rotten air through the caverns", "climb up", "Examine", 1, 1, 1, 0, "cave wallgrill"));
        objects.add(new Class9_Sub1("Dug up soil", "A freshly dug pile of mud", "search", "Examine", 0, 1, 1, 0, "mudpatch"));
        objects.add(new Class9_Sub1("Dug up soil", "A freshly dug pile of mud", "search", "Examine", 0, 1, 1, 0, "mudpatch"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud caved in from above", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("stalagmite", "Formed over thousands of years", "WalkTo", "Examine", 0, 1, 1, 0, "cave small stagamite"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud and rocks piled up", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud and rocks piled up", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud and rocks piled up", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud and rocks piled up", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud and rocks piled up", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Spiked pit", "I don't want to go down there", "WalkTo", "Examine", 0, 1, 1, 0, "spikedpit"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Boulder", "Could be dangerous!", "WalkTo", "Examine", 1, 2, 2, 0, "cave bolder"));
        objects.add(new Class9_Sub1("crate", "Someone or something has been here before us", "WalkTo", "Search", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("Door", "Spooky!", "open", "Examine", 1, 1, 1, 0, "cave templedoor"));
        objects.add(new Class9_Sub1("Platform", "An ancient construction", "WalkTo", "Examine", 1, 1, 1, 0, "cave platform small2"));
        objects.add(new Class9_Sub1("Cage remains", "Poor unicorn!", "WalkTo", "Search", 1, 1, 1, 0, "cave smashedcage"));
        objects.add(new Class9_Sub1("Ledge", "I might be able to climb that", "climb up", "Examine", 1, 1, 1, 0, "cave ledge"));
        objects.add(new Class9_Sub1("Passage", "Looks suspicous!", "Walk here", "Examine", 1, 1, 1, 0, "cave snaptrap"));
        objects.add(new Class9_Sub1("Passage", "Looks suspicous!", "Walk here", "Examine", 1, 1, 1, 0, "cave snaptrap"));
        objects.add(new Class9_Sub1("Gate of Zamorak", "It doesn't look very inviting", "open", "Examine", 1, 3, 1, 0, "rams skull door"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Bridge support", "An ancient construction", "WalkTo", "Examine", 1, 1, 1, 0, "cave bridge supportbase"));
        objects.add(new Class9_Sub1("Tomb of Iban", "A clay shrine to lord iban", "Open", "Examine", 1, 1, 2, 96, "hazeeltomb"));
        objects.add(new Class9_Sub1("Claws of Iban", "claws of iban", "WalkTo", "Examine", 1, 1, 1, 96, "clawsofiban"));
        objects.add(new Class9_Sub1("barrel", "Its stinks of alcohol", "empty", "Examine", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("Rocks", "More rocks", "step over", "search for traps", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Rocks", "More rocks", "step over", "search for traps", 1, 1, 1, 0, "cave speartrap"));
        objects.add(new Class9_Sub1("Swamp", "That smells horrid", "WalkTo", "Examine", 1, 1, 1, 0, "cave swampbubbles"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Stone bridge", "An ancient stone construction", "WalkTo", "Examine", 0, 1, 1, 0, "bridge section corner"));
        objects.add(new Class9_Sub1("cage", "That's no way to live", "search", "Examine", 0, 1, 1, 0, "gnomecage"));
        objects.add(new Class9_Sub1("cage", "That's no way to live", "search", "Examine", 0, 1, 1, 0, "gnomecage"));
        objects.add(new Class9_Sub1("Stone steps", "They lead into the darkness", "walk down", "Examine", 0, 1, 1, 0, "cave bridge stairs"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud and rocks piled up", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "cross", "Examine", 1, 1, 3, 0, "bridge section collapsed"));
        objects.add(new Class9_Sub1("Stone bridge", "The bridge has partly collapsed", "jump over", "Examine", 1, 1, 3, 0, "bridge section collapsed2"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Pit of the Damned", "The son of zamoracks alter...", "WalkTo", "Examine", 1, 1, 1, 0, "cave temple alter"));
        objects.add(new Class9_Sub1("Open Door", "Spooky!", "open", "Examine", 1, 1, 1, 0, "cave templedooropen"));
        objects.add(new Class9_Sub1("signpost", "Observatory reception", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("Stone Gate", "A mystical looking object", "Go through", "Look", 1, 2, 2, 0, "henge"));
        objects.add(new Class9_Sub1("Chest", "Perhaps there is something inside", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Zodiac", "A map of the twelve signs of the zodiac", "WalkTo", "Examine", 0, 3, 3, 0, "zodiac"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Stone steps", "They lead into the darkness", "walk down", "Examine", 0, 1, 1, 0, "cave bridge stairs"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("Rock", "Scripture has been carved into the rock", "read", "Examine", 1, 1, 1, 0, "cave carvings"));
        objects.add(new Class9_Sub1("Telescope", "A device for viewing the heavens", "Use", "Examine", 1, 1, 1, 0, "telescope"));
        objects.add(new Class9_Sub1("Gate", "The entrance to the dungeon jail", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("sacks", "These sacks feels lumpy!", "Search", "Examine", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("Ladder", "the ladder goes down into a dark area", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Chest", "All these chests look the same!", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "All these chests look the same!", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Bookcase", "A very roughly constructed bookcase.", "WalkTo", "Search", 1, 1, 2, 0, "bookcase"));
        objects.add(new Class9_Sub1("Iron Gate", "A well wrought iron gate - it's locked.", "Open", "Search", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Ladder", "the ladder down to the cavern", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Chest", "Perhaps there is something inside", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "All these chests look the same!", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "Perhaps there is something inside", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "All these chests look the same!", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Rockslide", "A pile of rocks blocks your path", "WalkTo", "Examine", 1, 1, 1, 0, "rock3"));
        objects.add(new Class9_Sub1("Altar", "An altar to the evil God Zamorak", "Recharge at", "Examine", 1, 2, 1, 0, "chaosaltar"));
        objects.add(new Class9_Sub1("column", "Formed over thousands of years", "WalkTo", "Examine", 1, 1, 1, 0, "cave pillar"));
        objects.add(new Class9_Sub1("Grave of Scorpius", "Here lies Scorpius: dread follower of zamorak", "Read", "Examine", 1, 1, 3, 0, "gravestone1"));
        objects.add(new Class9_Sub1("Bank Chest", "Allows you to access your bank.", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("dwarf multicannon", "fires metal balls", "fire", "pick up", 0, 1, 1, 0, "dwarf multicannon"));
        objects.add(new Class9_Sub1("Disturbed sand", "Footprints in the sand show signs of a struggle", "Look", "Search", 0, 1, 1, 0, "sandyfootsteps"));
        objects.add(new Class9_Sub1("Disturbed sand", "Footprints in the sand show signs of a struggle", "Look", "Search", 0, 1, 1, 0, "sandyfootsteps"));
        objects.add(new Class9_Sub1("dwarf multicannon base", "bang", "pick up", "Examine", 0, 1, 1, 0, "dwarf multicannon part1"));
        objects.add(new Class9_Sub1("dwarf multicannon stand", "bang", "pick up", "Examine", 0, 1, 1, 0, "dwarf multicannon part2"));
        objects.add(new Class9_Sub1("dwarf multicannon barrels", "bang", "pick up", "Examine", 0, 1, 1, 0, "dwarf multicannon part3"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("fence", "These bridges seem hastily put up", "WalkTo", "Examine", 0, 1, 1, 0, "gnomefence"));
        objects.add(new Class9_Sub1("signpost", "a signpost", "read", "Examine", 1, 1, 1, 0, "signpost2"));
        objects.add(new Class9_Sub1("Rocks", "I wonder if I can climb up these", "climb", "Examine", 0, 1, 1, 0, "brownclimbingrocks"));
        objects.add(new Class9_Sub1("Rocks", "I wonder if I can climb up these", "climb", "Examine", 0, 1, 1, 0, "brownclimbingrocks"));
        objects.add(new Class9_Sub1("Cave entrance", "A noxious smell emanates from the cave...", "enter", "Examine", 1, 3, 1, 0, "caveentrance2"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wouldn't like to think where the owner is now", "Search", "Close", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Wooden Doors", "Large oak doors constantly watched by guards", "Open", "Watch", 2, 1, 2, 0, "hillsidedoor"));
        objects.add(new Class9_Sub1("Pedestal", "something fits on here", "WalkTo", "Examine", 1, 1, 1, 96, "stonestand"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "Search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "Search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("Standard", "A standard with a human skull on it", "WalkTo", "Examine", 1, 1, 1, 0, "ogre standard"));
        objects.add(new Class9_Sub1("Mining Cave", "A gaping hole that leads to another section of the mine", "enter", "Examine", 1, 3, 1, 0, "caveentrance2"));
        objects.add(new Class9_Sub1("Mining Cave", "A gaping hole that leads to another section of the mine", "enter", "Examine", 1, 3, 1, 0, "caveentrance2"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "WalkTo", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Lift", "To brings mined rocks to the surface", "Operate", "Examine", 1, 1, 2, 0, "liftwinch"));
        objects.add(new Class9_Sub1("Mining Barrel", "For loading up mined stone from below ground", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("Hole", "I wonder where this leads...", "enter", "Examine", 1, 1, 1, 0, "hole"));
        objects.add(new Class9_Sub1("Hole", "I wonder where this leads...", "enter", "Examine", 1, 1, 1, 0, "hole"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Counter", "An ogre is selling items here", "Steal from", "Examine", 1, 1, 1, 0, "rockcounter"));
        objects.add(new Class9_Sub1("Track", "Train track", "Look", "Examine", 1, 2, 2, 0, "trackcurve"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Mine Cart", "A heavily constructed and often used mining cart.", "Look", "Search", 1, 1, 1, 0, "minecart"));
        objects.add(new Class9_Sub1("Lift Platform", "A wooden lift that is operated from the surface.", "Use", "Search", 1, 1, 1, 0, "liftbed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Close", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Watch tower", "Constructed by the dwarven black guard", "WalkTo", "Examine", 0, 2, 2, 0, "watchtower"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Cave entrance", "I wonder what is inside...", "enter", "Examine", 1, 2, 2, 0, "caveentrance"));
        objects.add(new Class9_Sub1("Pile of mud", "Mud caved in from above", "climb", "Examine", 1, 2, 1, 0, "mudpile"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("crate", "A crate", "search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("crate", "A crate", "search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("Gate", "This gate barrs your way into gu'tanoth", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Gate", "This gate barrs your way into gu'tanoth", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "Search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "Search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "Search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "Search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("multicannon", "fires metal balls", "inspect", "Examine", 1, 1, 1, 0, "dwarf multicannon"));
        objects.add(new Class9_Sub1("Rocks", "Some rocks are close to the egde", "jump over", "look at", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "Some rocks are close to the edge", "jump over", "look at", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-down", "Examine", 0, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Cave entrance", "I wonder what is inside...", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Counter", "An ogre is selling cakes here", "Steal from", "Examine", 1, 1, 1, 0, "rock cake counter"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Bookcase", "A large collection of books", "Look", "Search", 1, 1, 2, 0, "bookcase"));
        objects.add(new Class9_Sub1("Captains Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Experimental Anvil", "An experimental anvil - for developing new techniques in forging", "Use", "Examine", 1, 1, 1, 0, "anvil"));
        objects.add(new Class9_Sub1("Rocks", "A small pile of stones", "Search", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "Search", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("Column", "Created by ancient mages", "WalkTo", "Examine", 1, 1, 1, 0, "magearena colomn"));
        objects.add(new Class9_Sub1("Wall", "Created by ancient mages", "WalkTo", "Examine", 1, 1, 1, 0, "magearena wall"));
        objects.add(new Class9_Sub1("Wall", "Created by ancient mages", "WalkTo", "Examine", 1, 1, 1, 0, "magearena corner"));
        objects.add(new Class9_Sub1("Wall", "Created by ancient mages", "WalkTo", "Examine", 1, 1, 1, 0, "magearena tallwall"));
        objects.add(new Class9_Sub1("Wall", "Created by ancient mages", "WalkTo", "Examine", 1, 1, 1, 0, "magearena cornerfill"));
        objects.add(new Class9_Sub1("Lever", "The lever is up", "pull", "Examine", 0, 1, 1, 0, "leverup"));
        objects.add(new Class9_Sub1("Lever", "The lever is down", "pull", "Examine", 0, 1, 1, 0, "leverdown"));
        objects.add(new Class9_Sub1("Wall", "Created by ancient mages", "WalkTo", "Examine", 1, 1, 1, 0, "magearena tallcorner"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Wall", "Created by ancient mages", "WalkTo", "Examine", 1, 1, 1, 0, "magearena plain wall"));
        objects.add(new Class9_Sub1("Gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Gate", "The gate is closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("shock", "cosmic energy", "WalkTo", "Examine", 1, 1, 1, 0, "spellshock"));
        objects.add(new Class9_Sub1("Desk", "A very strong looking table with some locked drawers.", "WalkTo", "Search", 1, 2, 1, 120, "counter"));
        objects.add(new Class9_Sub1("Cave", "I wonder what's inside!", "enter", "Examine", 1, 1, 1, 0, "small caveentrance2"));
        objects.add(new Class9_Sub1("Mining Cart", "A sturdy well built mining cart with barrels full of rock on the back.", "WalkTo", "Search", 1, 2, 3, 0, "cart"));
        objects.add(new Class9_Sub1("Rock of Dalgroth", "A mysterious boulder of the ogres", "mine", "prospect", 1, 2, 2, 0, "cave bolder"));
        objects.add(new Class9_Sub1("entrance", "Created by ancient mages", "walk through", "Examine", 1, 1, 1, 0, "magearena door"));
        objects.add(new Class9_Sub1("Dried Cactus", "It looks very spikey", "WalkTo", "Examine", 1, 1, 1, 0, "cactuswatered"));
        objects.add(new Class9_Sub1("climbing rocks", "I wonder if I can climb up these", "climb", "Examine", 0, 1, 1, 0, "climbing_rocks"));
        objects.add(new Class9_Sub1("Rocks", "Strange rocks - who knows why they're wanted?", "Mine", "Prospect", 1, 1, 1, 0, "tinrock1"));
        objects.add(new Class9_Sub1("lightning", "blimey!", "WalkTo", "Examine", 1, 1, 1, 0, "lightning1"));
        objects.add(new Class9_Sub1("Crude Desk", "A very roughly constructed desk", "WalkTo", "Search", 1, 2, 1, 120, "counter"));
        objects.add(new Class9_Sub1("Heavy Metal Gate", "This is an immense and very heavy looking gate made out of thick wrought metal", "Look", "Push", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Counter", "An ogre is selling cakes here", "Steal from", "Examine", 1, 1, 1, 0, "rock cake counter"));
        objects.add(new Class9_Sub1("Crude bed", "A flea infested sleeping experience", "rest", "Examine", 1, 1, 2, 0, "poorbed"));
        objects.add(new Class9_Sub1("flames", "looks hot!", "WalkTo", "Examine", 1, 1, 1, 0, "firespell1"));
        objects.add(new Class9_Sub1("Carved Rock", "An ornately carved rock with a pointed recepticle", "WalkTo", "Search", 1, 1, 1, 120, "cave small stagamite"));
        objects.add(new Class9_Sub1("USE", "FREE SLOT PLEASE USE", "WalkTo", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("crate", "A crate used for storing materials", "search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("crate", "A crate used for storing materials", "search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("barrel", "Its shut", "search", "Examine", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 1, 1, 0, "1-1light"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 1, 1, 0, "1-1dark"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 3, 1, 0, "1-3light"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 3, 1, 0, "1-3dark"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 2, 2, 0, "2-2light"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 1, 1, 0, "2-2dark"));
        objects.add(new Class9_Sub1("Barrier", "this section is roped off", "WalkTo", "Examine", 1, 1, 1, 0, "barrier1"));
        objects.add(new Class9_Sub1("buried skeleton", "I hope I don't meet any of these", "search", "Examine", 1, 1, 1, 0, "halfburiedskeleton"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 1, 1, 0, "2-1light"));
        objects.add(new Class9_Sub1("Brick", "A stone brick", "WalkTo", "Examine", 1, 1, 1, 0, "2-1light"));
        objects.add(new Class9_Sub1("Specimen tray", "A pile of sifted earth", "WalkTo", "Search", 1, 2, 2, 0, "compost"));
        objects.add(new Class9_Sub1("winch", "This winches earth from the dig hole", "Operate", "Examine", 1, 1, 2, 0, "liftwinch"));
        objects.add(new Class9_Sub1("crate", "A crate", "search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("crate", "A crate", "search", "Examine", 1, 1, 1, 0, "crate"));
        objects.add(new Class9_Sub1("Urn", "A large ornamental urn", "WalkTo", "Examine", 1, 1, 1, 0, "largeurn"));
        objects.add(new Class9_Sub1("buried skeleton", "I'm glad this isn't around now", "search", "Examine", 1, 1, 1, 0, "halfburiedskeleton2"));
        objects.add(new Class9_Sub1("panning point", "a shallow where I can pan for gold", "look", "Examine", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "WalkTo", "Examine", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("signpost", "a signpost", "read", "Examine", 1, 1, 1, 0, "signpost2"));
        objects.add(new Class9_Sub1("signpost", "a signpost", "read", "Examine", 1, 1, 1, 0, "signpost2"));
        objects.add(new Class9_Sub1("signpost", "a signpost", "read", "Examine", 1, 1, 1, 0, "signpost2"));
        objects.add(new Class9_Sub1("signpost", "a signpost", "read", "Examine", 1, 1, 1, 0, "signpost2"));
        objects.add(new Class9_Sub1("signpost", "Digsite educational centre", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("soil", "soil", "search", "Examine", 0, 1, 1, 0, "dugupsoil1"));
        objects.add(new Class9_Sub1("soil", "soil", "search", "Examine", 0, 1, 1, 0, "dugupsoil2"));
        objects.add(new Class9_Sub1("soil", "soil", "search", "Examine", 0, 1, 1, 0, "dugupsoil3"));
        objects.add(new Class9_Sub1("Gate", "The gate has closed", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("ship", "The ship is sinking", "WalkTo", "Examine", 2, 1, 2, 0, "sinkingshipfront"));
        objects.add(new Class9_Sub1("barrel", "The ship is sinking", "climb on", "Examine", 2, 1, 2, 0, "sinkingbarrel"));
        objects.add(new Class9_Sub1("Leak", "The ship is sinking", "fill", "Examine", 0, 1, 1, 0, "shipleak"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("bush", "A leafy bush", "search", "Examine", 1, 1, 1, 0, "bush1"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("sacks", "Yep they're sacks", "search", "Examine", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("sacks", "Yep they're sacks", "search", "Examine", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("Leak", "The ship is sinking", "fill", "Examine", 0, 1, 1, 0, "shipleak2"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "search", "Examine", 1, 1, 2, 0, "cupboardopen"));
        objects.add(new Class9_Sub1("Wrought Mithril Gates", "Magnificent wrought mithril gates giving access to the Legends Guild", "open", "Search", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Legends Hall Doors", "Solid Oak doors leading to the Hall of Legends", "Open", "Search", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("Camp bed", "Not comfortable but useful nonetheless", "WalkTo", "Examine", 1, 1, 2, 0, "poorbed"));
        objects.add(new Class9_Sub1("barrel", "It has a lid on it - I need something to lever it off", "WalkTo", "Examine", 1, 1, 1, 0, "barrelredcross"));
        objects.add(new Class9_Sub1("barrel", "I wonder what is inside...", "search", "Examine", 1, 1, 1, 0, "barrelredcross"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Dense Jungle Tree", "Thick vegetation", "Chop", "Examine", 1, 1, 1, 0, "jungle medium size plant"));
        objects.add(new Class9_Sub1("Jungle tree stump", "A chopped down jungle tree", "Walk", "Examine", 1, 1, 1, 0, "treestump"));
        objects.add(new Class9_Sub1("signpost", "To the digsite", "WalkTo", "Examine", 1, 1, 1, 0, "signpost"));
        objects.add(new Class9_Sub1("gate", "You can pass through this on the members server", "open", "Examine", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Bookcase", "A large collection of books", "search", "Examine", 1, 1, 2, 0, "bookcase"));
        objects.add(new Class9_Sub1("Dense Jungle Tree", "An exotic looking tree", "Chop", "Examine", 1, 1, 1, 0, "jungle tree 2"));
        objects.add(new Class9_Sub1("Dense Jungle Tree", "An exotic looking tree", "Chop", "Examine", 1, 1, 1, 0, "jungle tree 1"));
        objects.add(new Class9_Sub1("Spray", "There's a strong wind", "WalkTo", "Examine", 1, 1, 1, 0, "shipspray1"));
        objects.add(new Class9_Sub1("Spray", "There's a strong wind", "WalkTo", "Examine", 1, 1, 1, 0, "shipspray2"));
        objects.add(new Class9_Sub1("winch", "This winches earth from the dig hole", "Operate", "Examine", 1, 1, 2, 0, "liftwinch"));
        objects.add(new Class9_Sub1("Brick", "It seems these were put here deliberately", "search", "Examine", 1, 1, 1, 0, "1-1light"));
        objects.add(new Class9_Sub1("Rope", "it's a rope leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ropeforclimbingbot"));
        objects.add(new Class9_Sub1("Rope", "it's a rope leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ropeforclimbingbot"));
        objects.add(new Class9_Sub1("Dense Jungle Palm", "A hardy palm tree with dense wood", "Chop", "Examine", 1, 1, 1, 0, "palm2"));
        objects.add(new Class9_Sub1("Dense Jungle Palm", "A hardy palm tree with dense wood", "Chop", "Examine", 1, 1, 1, 0, "palm"));
        objects.add(new Class9_Sub1("Trawler net", "A huge net to catch little fish", "inspect", "Examine", 1, 1, 1, 0, "trawlernet-l"));
        objects.add(new Class9_Sub1("Trawler net", "A huge net to catch little fish", "inspect", "Examine", 1, 1, 1, 0, "trawlernet-r"));
        objects.add(new Class9_Sub1("Brick", "The bricks are covered in the strange compound", "WalkTo", "Examine", 1, 1, 1, 0, "1-1light"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside ?", "open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Chest", "Perhaps I should search it", "Search", "Close", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Trawler catch", "Smells like fish!", "Search", "Examine", 1, 1, 1, 0, "trawlernet"));
        objects.add(new Class9_Sub1("Yommi Tree", "An adolescent rare and mystical looking tree in", "WalkTo", "Examine", 1, 2, 2, 0, "totemtree1"));
        objects.add(new Class9_Sub1("Grown Yommi Tree", "A fully grown rare and mystical looking tree", "WalkTo", "Examine", 1, 2, 2, 0, "totemtree2"));
        objects.add(new Class9_Sub1("Chopped Yommi Tree", "A mystical looking tree that has recently been felled", "WalkTo", "Examine", 1, 2, 2, 0, "totemtree3"));
        objects.add(new Class9_Sub1("Trimmed Yommi Tree", "The trunk of the yommi tree.", "WalkTo", "Examine", 1, 2, 2, 0, "totemtree4"));
        objects.add(new Class9_Sub1("Totem Pole", "A nicely crafted wooden totem pole.", "Lift", "Examine", 1, 2, 2, 0, "totemtree5"));
        objects.add(new Class9_Sub1("Baby Yommi Tree", "A baby Yommi tree - with a mystical aura", "WalkTo", "Examine", 1, 2, 2, 0, "smallfern"));
        objects.add(new Class9_Sub1("Fertile earth", "A very fertile patch of earth", "WalkTo", "Examine", 0, 2, 2, 0, "dugupsoil1"));
        objects.add(new Class9_Sub1("Rock Hewn Stairs", "steps cut out of the living rock", "Climb", "Examine", 1, 2, 3, 0, "rocksteps"));
        objects.add(new Class9_Sub1("Hanging rope", "A rope hangs from the ceiling", "WalkTo", "Examine", 1, 1, 1, 0, "ropeladder"));
        objects.add(new Class9_Sub1("Rocks", "A large boulder blocking the stream", "Move", "Examine", 1, 2, 2, 0, "cave bolder"));
        objects.add(new Class9_Sub1("Boulder", "A large boulder blocking the way", "WalkTo", "Smash to pieces", 1, 2, 2, 0, "cave bolder"));
        objects.add(new Class9_Sub1("dwarf multicannon", "fires metal balls", "fire", "pick up", 1, 1, 1, 0, "dwarf multicannon"));
        objects.add(new Class9_Sub1("dwarf multicannon base", "bang", "pick up", "Examine", 1, 1, 1, 0, "dwarf multicannon part1"));
        objects.add(new Class9_Sub1("dwarf multicannon stand", "bang", "pick up", "Examine", 1, 1, 1, 0, "dwarf multicannon part2"));
        objects.add(new Class9_Sub1("dwarf multicannon barrels", "bang", "pick up", "Examine", 1, 1, 1, 0, "dwarf multicannon part3"));
        objects.add(new Class9_Sub1("rock", "A rocky outcrop", "climb over", "Examine", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Rock Hewn Stairs", "steps cut out of the living rock", "Climb", "Examine", 1, 2, 3, 0, "rocksteps"));
        objects.add(new Class9_Sub1("Rock Hewn Stairs", "steps cut out of the living rock", "Climb", "Examine", 1, 2, 3, 0, "rocksteps"));
        objects.add(new Class9_Sub1("Rock Hewn Stairs", "steps cut out of the living rock", "Climb", "Examine", 1, 2, 3, 0, "rocksteps"));
        objects.add(new Class9_Sub1("Compost Heap", "The family gardeners' compost heap", "WalkTo", "Investigate", 1, 2, 2, 0, "compost"));
        objects.add(new Class9_Sub1("beehive", "An old looking beehive", "WalkTo", "Investigate", 1, 1, 1, 0, "beehive"));
        objects.add(new Class9_Sub1("Drain", "This drainpipe runs from the kitchen to the sewers", "WalkTo", "Investigate", 0, 1, 1, 0, "pipe&drain"));
        objects.add(new Class9_Sub1("web", "An old thick spider's web", "WalkTo", "Investigate", 0, 1, 1, 0, "floorweb"));
        objects.add(new Class9_Sub1("fountain", "There seems to be a lot of insects here", "WalkTo", "Investigate", 1, 2, 2, 0, "fountain"));
        objects.add(new Class9_Sub1("Sinclair Crest", "The Sinclair family crest", "WalkTo", "Investigate", 0, 1, 1, 0, "wallshield"));
        objects.add(new Class9_Sub1("barrel", "Annas stuff - There seems to be something shiny at the bottom", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("barrel", "Bobs things - There seems to be something shiny at the bottom", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("barrel", "Carols belongings - there seems to be something shiny at the bottom", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("barrel", "Davids equipment - there seems to be something shiny at the bottom", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("barrel", "Elizabeths clothes - theres something shiny at the bottom", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("barrel", "Franks barrel seems to have something shiny at the bottom", "WalkTo", "Search", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("Flour Barrel", "Its full of flour", "WalkTo", "Take From", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("sacks", "Full of various gardening tools", "WalkTo", "investigate", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("gate", "A sturdy and secure wooden gate", "WalkTo", "Investigate", 2, 1, 2, 0, "woodengateclosed"));
        objects.add(new Class9_Sub1("Dead Yommi Tree", "A dead Yommi Tree - it looks like a tough axe will be needed to fell this", "WalkTo", "Inspect", 1, 2, 2, 0, "deadtree2"));
        objects.add(new Class9_Sub1("clawspell", "forces of guthix", "WalkTo", "Examine", 1, 1, 1, 0, "clawspell1"));
        objects.add(new Class9_Sub1("Rocks", "The remains of a large rock", "WalkTo", "Examine", 1, 2, 2, 0, "cave rock1"));
        objects.add(new Class9_Sub1("crate", "A crate of some kind", "WalkTo", "Search", 1, 1, 1, 70, "crate"));
        objects.add(new Class9_Sub1("Cavernous Opening", "A dark and mysterious cavern", "enter", "search", 1, 3, 1, 0, "caveentrance2"));
        objects.add(new Class9_Sub1("Ancient Lava Furnace", "A badly damaged furnace fueled by red hot Lava - it looks ancient", "Look", "Search", 1, 2, 2, 0, "furnace"));
        objects.add(new Class9_Sub1("Spellcharge", "forces of guthix", "WalkTo", "Examine", 1, 1, 1, 0, "Spellcharge1"));
        objects.add(new Class9_Sub1("Rocks", "A small rocky outcrop", "WalkTo", "Search", 1, 1, 1, 0, "cave rock1"));
        objects.add(new Class9_Sub1("cupboard", "The cupboard is shut", "open", "Examine", 1, 1, 2, 0, "cupboard"));
        objects.add(new Class9_Sub1("sacks", "Yep they're sacks", "search", "Examine", 1, 1, 1, 0, "sacks"));
        objects.add(new Class9_Sub1("Rock", "A rocky outcrop", "WalkTo", "Search", 1, 1, 1, 0, "rocks1"));
        objects.add(new Class9_Sub1("Saradomin stone", "A faith stone", "chant to", "Examine", 1, 1, 1, 0, "saradominstone"));
        objects.add(new Class9_Sub1("Guthix stone", "A faith stone", "chant to", "Examine", 1, 1, 1, 0, "guthixstone"));
        objects.add(new Class9_Sub1("Zamorak stone", "A faith stone", "chant to", "Examine", 1, 1, 1, 0, "zamorakstone"));
        objects.add(new Class9_Sub1("Magical pool", "A cosmic portal", "step into", "Examine", 1, 2, 2, 0, "rockpool"));
        objects.add(new Class9_Sub1("Wooden Beam", "Some sort of support - perhaps used with ropes to lower people over the hole", "WalkTo", "Search", 0, 1, 1, 0, "Scaffoldsupport"));
        objects.add(new Class9_Sub1("Rope down into darkness", "A scarey downwards trip into possible doom.", "WalkTo", "Use", 0, 1, 1, 0, "ScaffoldsupportRope"));
        objects.add(new Class9_Sub1("Cave entrance", "A dark cave entrance leading to the surface.", "Enter", "Examine", 1, 3, 1, 0, "caveentrance2"));
        objects.add(new Class9_Sub1("Cave entrance", "A small tunnel that leads to a large room beyond.", "enter", "Examine", 1, 2, 2, 0, "Shamancave"));
        objects.add(new Class9_Sub1("Ancient Wooden Doors", "The doors are locked shut", "Open", "Pick Lock", 2, 1, 2, 0, "doubledoorsclosed"));
        objects.add(new Class9_Sub1("Table", "An old rickety table", "WalkTo", "search", 1, 1, 1, 96, "table"));
        objects.add(new Class9_Sub1("Crude bed", "Barely a bed at all", "Rest", "Search", 1, 1, 2, 0, "poorbed"));
        objects.add(new Class9_Sub1("Tall Reeds", "A tall plant with a tube for a stem.", "WalkTo", "Search", 0, 1, 1, 0, "bullrushes"));
        objects.add(new Class9_Sub1("Goblin foot prints", "They seem to be heading south east", "WalkTo", "Examine", 0, 1, 1, 0, "sandyfootsteps"));
        objects.add(new Class9_Sub1("Dark Metal Gate", "A dark metalic gate which seems to be fused with the rock", "Open", "Search", 2, 1, 2, 0, "metalgateclosed"));
        objects.add(new Class9_Sub1("Magical pool", "A cosmic portal", "step into", "Examine", 1, 2, 2, 0, "rockpool"));
        objects.add(new Class9_Sub1("Rope Up", "A welcome rope back up and out of this dark place.", "Climb", "Examine", 0, 1, 1, 0, "obstical_ropeswing"));
        objects.add(new Class9_Sub1("Half buried remains", "Some poor unfortunate soul", "WalkTo", "Search", 1, 1, 1, 0, "skeletonwithbag"));
        objects.add(new Class9_Sub1("Totem Pole", "A carved and decorated totem pole", "Look", "Examine", 1, 1, 1, 0, "totemtreeevil"));
        objects.add(new Class9_Sub1("Totem Pole", "A carved and decorated totem pole", "Look", "Examine", 1, 1, 1, 0, "totemtreegood"));
        objects.add(new Class9_Sub1("Comfy bed", "Its a bed - wow", "rest", "Examine", 1, 2, 2, 0, "bed"));
        objects.add(new Class9_Sub1("Rotten Yommi Tree", "A decomposing fully grown Yommi Tree", "WalkTo", "Inspect", 1, 2, 2, 0, "totemtreerotten2"));
        objects.add(new Class9_Sub1("Rotten Yommi Tree", "A decomposing felled Yommi Tree", "WalkTo", "Inspect", 1, 2, 2, 0, "totemtreerotten3"));
        objects.add(new Class9_Sub1("Rotten Yommi Tree", "A decomposing Yommi Tree Trunk", "WalkTo", "Inspect", 1, 2, 2, 0, "totemtreerotten4"));
        objects.add(new Class9_Sub1("Rotten Totem Pole", "A decomposing Totem Pole", "WalkTo", "Inspect", 1, 2, 2, 0, "totemtreerotten5"));
        objects.add(new Class9_Sub1("Leafy Palm Tree", "A shady palm tree", "WalkTo", "Shake", 1, 1, 1, 0, "palm"));
        objects.add(new Class9_Sub1("Grand Viziers Desk", "A very elegant desk - you could knock it to get the Grand Viziers attention.", "WalkTo", "Knock on table", 1, 2, 1, 120, "counter"));
        objects.add(new Class9_Sub1("Strange Barrel", "It might have something inside of it.", "Smash", "Examine", 1, 1, 1, 0, "barrel"));
        objects.add(new Class9_Sub1("ship", "A sturdy sailing ship", "WalkTo", "Examine", 0, 5, 3, 0, "Shipfront"));
        objects.add(new Class9_Sub1("ship", "A sturdy sailing ship", "WalkTo", "Examine", 0, 2, 3, 0, "Shipmiddle"));
        objects.add(new Class9_Sub1("ship", "A sturdy sailing ship", "WalkTo", "Examine", 0, 5, 3, 0, "Shipback"));
        objects.add(new Class9_Sub1("digsite bed", "Not comfortable but useful nonetheless", "sleep", "Examine", 1, 1, 2, 0, "poorbed"));
        objects.add(new Class9_Sub1("Tea stall", "A stall selling oriental infusions", "WalkTo", "Steal from", 1, 2, 2, 112, "market"));
        objects.add(new Class9_Sub1("Boulder", "A large boulder blocking the way", "WalkTo", "Smash to pieces", 1, 2, 2, 0, "cave bolder"));
        objects.add(new Class9_Sub1("Boulder", "A large boulder blocking the way", "WalkTo", "Smash to pieces", 1, 2, 2, 0, "cave bolder"));
        objects.add(new Class9_Sub1("Damaged Earth", "Disturbed earth - it will heal itself in time", "WalkTo", "Examine", 0, 1, 1, 0, "dugupsoil1"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading upwards", "Climb-Up", "Examine", 1, 1, 1, 0, "ladder"));
        objects.add(new Class9_Sub1("Ladder", "it's a ladder leading downwards", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("Game chest", "Costs 5 marbles to open", "Open", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Ladder", "i wonder what's down there", "Climb-Down", "Examine", 1, 1, 1, 0, "ladderdown"));
        objects.add(new Class9_Sub1("portal", "Created by ancient mages", "open", "Examine", 1, 1, 1, 0, "magearena door"));
        objects.add(new Class9_Sub1("Chest", "This chest opens the bank.", "Access Bank", "Examine", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("fish", "I can see fish swimming in the water", "net", "Harpoon", 0, 1, 1, 0, "fishing"));
        objects.add(new Class9_Sub1("Gem Rocks", "A rocky outcrop with a vein of semi precious stones", "Mine", "Prospect", 1, 1, 1, 0, "gemrock"));
        objects.add(new Class9_Sub1("Gem Rocks", "A rocky outcrop with a vein of semi precious stones", "Mine", "Prospect", 1, 1, 1, 0, "gemrock"));
        objects.add(new Class9_Sub1("Gem Rocks", "A rocky outcrop with a vein of semi precious stones", "Mine", "Prospect", 1, 1, 1, 0, "gemrock"));
        objects.add(new Class9_Sub1("Chest", "I wonder what is inside...", "Open", "Search for traps", 1, 1, 1, 0, "ChestClosed"));
        objects.add(new Class9_Sub1("Food Supplies", "I can loot food supplies from this chest", "Loot", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Ranged Supplies", "I can loot ranged supplies from this chest", "Loot", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Magic Supplies", "I can loot magic supplies from this chest", "Loot", "Examine", 1, 1, 1, 0, "ChestOpen"));
        objects.add(new Class9_Sub1("Portal", "A cosmic portal", "Warp", "Examine", 1, 2, 2, 0, "rockpool"));
    }

    public static void method260()
    {
        method252();
        method253();
        method254();
        method251();
        method255();
        method256();
        method248();
        method249();
        method257();
        method250();
        method258();
        method259();
        for(int i = 0; i < items.size(); i++)
            if(((Class9_Sub2)items.get(i)).method302() + 1 > anInt68)
                anInt68 = ((Class9_Sub2)items.get(i)).method302() + 1;

        for(int j = 0; j < objects.size(); j++)
            ((Class9_Sub1)objects.get(j)).anInt800 = method261(((Class9_Sub1)objects.get(j)).method294());

    }

    public static int method261(String s)
    {
        if(s.equalsIgnoreCase("na"))
            return 0;
        int i = anArrayList67.indexOf(s);
        if(i < 0)
        {
            anArrayList67.add(s);
            return anArrayList67.size() - 1;
        } else
        {
            return i;
        }
    }

    public static ArrayList npcs = new ArrayList();
    public static ArrayList items = new ArrayList();
    public static ArrayList tileSprites = new ArrayList();
    public static ArrayList itemSprites = new ArrayList();
    public static ArrayList spells = new ArrayList();
    public static ArrayList prayers = new ArrayList();
    public static ArrayList anArrayList63 = new ArrayList();
    public static ArrayList wallObjects = new ArrayList();
    public static ArrayList anArrayList65 = new ArrayList();
    public static ArrayList objects = new ArrayList();
    public static ArrayList anArrayList67 = new ArrayList();
    public static int anInt68 = 0;

}
