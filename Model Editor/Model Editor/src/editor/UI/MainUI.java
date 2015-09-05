package editor.UI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.*;

import jagex.Models;
import jagex.IO.Archive;

import editor.models.Camera;
import editor.utils.ModelViewer;
import editor.utils.Util;

/**
 * @author Sean
 *
 */
public class MainUI extends JFrame {
	private ModelViewer modelPanel;
	private Archive jagexArchive;
	
	public MainUI() {
		initComponents();
		File jag = new File("models.jag");
		try {
			jagexArchive = new Archive(Util.getFileBytes(jag.getAbsolutePath()));
			Models.load(jagexArchive);
			setup();
			getModelPanel().setModel(Models.modelsCache[1].buildRSCModel());
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	public void setup() {
		setModelPanel(new ModelViewer());
		getModelPanel().setDrawFrame(false);
		getModelPanel().setDrawVerts(false);
		getModelPanel().setSize(scrollPane1.getWidth(), scrollPane1.getHeight());
		scrollPane1.add(getModelPanel());
		Camera camera = getModelPanel().getOurCamera();
		camera.setZ(420);
		camera.setAngleX((float) Math.toRadians(25));
		scrollPane1.setViewportView(getModelPanel());
	}
	
	public ModelViewer getModelPanel() {
		return modelPanel;
	}

	private void initComponents() {
		scrollPane1 = new JScrollPane();

		setTitle("RSC Model Editor - Written by Sean (Snemo)");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(0, 0, 635, 410);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
	}

	public void setModelPanel(ModelViewer modelPanel) {
		this.modelPanel = modelPanel;
	}

	private JScrollPane scrollPane1;
}
