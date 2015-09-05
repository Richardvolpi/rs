package com.rscd.sprite;

import com.rscd.sprite.util.ImageLoader;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.TreeMap;

public class SpriteEditor extends JFrame implements ActionListener {
	private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 10);
	private static final int WIDTH = 800;
	private static final int HEIGHT = 400;
	
	private final Component paper = new JApplet();
	private final SpriteDrawer drawer = new SpriteDrawer(paper, WIDTH, HEIGHT - 80);
	
	private TreeMap<String, JButton> buttons = new TreeMap<String, JButton>();
	private TreeMap<String, JTextField> fields = new TreeMap<String, JTextField>();
	
	private Color overlay = Color.WHITE;
	private Sprite sprite;
	
	public static void main(String[] args) {
		new SpriteEditor();
	}
	
	private JButton addButton(Container parent, String name) {
		JButton button = new JButton(name);
		button.setFont(DEFAULT_FONT);
		button.addActionListener(this);
		parent.add(button);
		buttons.put(name, button);
		return button;
	}
	
	private JTextField addField(Container parent, String name, int size) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(name);
		JTextField field = new JTextField(size);
		label.setFont(DEFAULT_FONT);
		field.setFont(DEFAULT_FONT);
		field.addActionListener(this);
		panel.add(label);
		panel.add(field);
		parent.add(panel);
		fields.put(name, field);
		return field;
	}
	
	public SpriteEditor() {
		Container content = super.getContentPane();
		content.setLayout(new BorderLayout());
		
		/* Top Menu */
		JMenuBar menu = new JMenuBar();
		menu.setLayout(new FlowLayout());
		addButton(menu, "Load Sprite");
		addButton(menu, "Load Image");
		addButton(menu, "Save Sprite");
		addButton(menu, "Save Image");
		addButton(menu, "Clear");
		addButton(menu, "Unpack");
		addButton(menu, "Overlay");
		addButton(menu, "Refresh");
		addButton(menu, "Quit");
		
		/* Bottom Menu */
		JMenuBar footer = new JMenuBar();
		footer.setLayout(new FlowLayout());
		addField(footer, "Package", 8);
		addField(footer, "ID", 4);
		addField(footer, "Size", 6);
		addField(footer, "X-Shift", 4);
		addField(footer, "Y-Shift", 4);
		addField(footer, "Var-1", 4);
		addField(footer, "Var-2", 4);
		addField(footer, "Overlay", 8);
		
		content.add(menu, BorderLayout.NORTH);
		content.add(paper, BorderLayout.CENTER);
		content.add(footer, BorderLayout.SOUTH);
		
		super.setTitle("RSCD - Sprite Editor");
		super.setSize(WIDTH, HEIGHT);
		super.setResizable(false);
		super.setVisible(true);
		
		super.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		
		loadSprite(null);
		while(true) {
			drawer.drawImage(paper.getGraphics(), 0, 0);
			try { Thread.sleep(100); } catch(Exception ex) { }
		}
	}
	
	private void setField(String name, String contents, boolean enabled) {
		JTextField field = fields.get(name);
		if(field != null) {
			field.setText(contents);
			field.setEnabled(enabled);
		}
	}
	
	private void loadSprite(Sprite sprite) {
		this.sprite = sprite;
      		drawer.reset();
      		if(sprite == null) {
      			setField("Package", "", false);
      			setField("ID", "", false);
      			setField("Size", "", false);
      			setField("X-Shift", "", false);
      			setField("Y-Shift", "", false);
      			setField("Var-1", "", false);
      			setField("Var-2", "", false);
      			setField("Overlay", "", false);
      		}
      		else {
		      	setField("Package", sprite.getPackageName(), true);
		      	setField("ID", String.valueOf(sprite.getID()), true);
		      	setField("Size", sprite.getWidth() + "x" + sprite.getHeight(), false);
		      	setField("X-Shift", String.valueOf(sprite.getXShift()), true);
		      	setField("Y-Shift", String.valueOf(sprite.getYShift()), true);
		      	setField("Var-1", String.valueOf(sprite.getSomething1()), true);
		      	setField("Var-2", String.valueOf(sprite.getSomething2()), true);
		      	setField("Overlay", String.valueOf(getOverlay()), false);
		      	
	      		drawer.drawSprite(0, 0, sprite, getOverlay());
      		}
	}
	
	private int getOverlay() {
		if(overlay == null) {
			return 0;
		}
		return overlay == Color.BLACK || overlay == Color.WHITE ? 0 : overlay.getRGB();
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == buttons.get("Clear")) {
			loadSprite(null);
		}
		else if(event.getSource() == buttons.get("Unpack")) {
			try {
				super.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				SpriteLoader loader = new SpriteLoader(drawer);
				for(Sprite sprite : loader.getSprites()) {
					File folder;
					try {
						folder = new File("./sprites/dat/" + sprite.getPackageName() + "/");
						if(!folder.exists()) {
							folder.mkdir();
						}
						sprite.serializeTo(new File(folder.getAbsolutePath() + "/" + sprite.getID() + ".spr"));
						folder = new File("./sprites/img/" + sprite.getPackageName() + "/");
						if(!folder.exists()) {
							folder.mkdir();
						}
						ImageLoader.saveImage(sprite.toImage(), "png", new File(folder.getAbsolutePath() + "/" + sprite.getID() + ".png"));
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			finally {
				super.setCursor(Cursor.getDefaultCursor());
			}
		}
		else if(event.getSource() == buttons.get("Load Sprite")) {
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			chooser.setFileFilter(new FileNameExtensionFilter("RSCD Sprite Files", "spr"));
			if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					File file = chooser.getSelectedFile();
					loadSprite(Sprite.deserializeFrom(file));
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
		else if(event.getSource() == buttons.get("Load Image")) {
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			chooser.setFileFilter(new FileNameExtensionFilter("Image Files", "png"));
			if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					File file = chooser.getSelectedFile();
					loadSprite(Sprite.fromImage(ImageLoader.loadImage(file)));

				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
		else if(event.getSource() == buttons.get("Save Sprite")) {
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			chooser.setFileFilter(new FileNameExtensionFilter("RSCD Sprite Files", "spr"));
			if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					sprite.serializeTo(chooser.getSelectedFile());
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
		else if(event.getSource() == buttons.get("Save Image")) {
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			chooser.setFileFilter(new FileNameExtensionFilter("Image Files", "png"));
			if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					ImageLoader.saveImage(sprite.toImage(), "png", chooser.getSelectedFile());
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
		else if(event.getSource() == buttons.get("Refresh")) {
			if(sprite != null) {
				sprite.setName(getInt(fields.get("ID").getText()), fields.get("Package").getText());
				sprite.setShift(getInt(fields.get("X-Shift").getText()), getInt(fields.get("Y-Shift").getText()));
				sprite.setSomething(getInt(fields.get("Var-1").getText()), getInt(fields.get("Var-2").getText()));
			}
			loadSprite(sprite);
		}
		else if(event.getSource() == buttons.get("Overlay")) {
			overlay = JColorChooser.showDialog(this, "Choose an overlay", overlay);
			fields.get("Overlay").setText(String.valueOf(getOverlay()));
			loadSprite(sprite);
		}
		else if(event.getSource() == buttons.get("Quit")) {
			System.exit(0);
		}
	}
	
	public static int getInt(String s) {
		try {
			return Integer.parseInt(s);
		}
		catch(Exception e) {
			return 0;
		}
	}
	
}