package jagex;

import java.awt.Color;
import java.io.IOException;
import java.util.Vector;

import editor.models.Face;
import editor.models.Model;
import editor.models.Vertex;

import jagex.IO.Archive;
import jagex.IO.DataOperations;
import jagex.IO.ExtendedByteArrayOutputStream;

public class Models {

	static Archive archive;
	public static Models modelsCache[];

	public static void load(Archive jagexArchive) {
		archive = jagexArchive;
		if (modelsCache == null) {
			modelsCache = new Models[jagexArchive.getNames().size()];
		}
		Vector<String> names = jagexArchive.getNames();
		for (int j = 0; j < jagexArchive.getNames().size(); j++) {
			if (modelsCache[j] == null) {
				modelsCache[j] = new Models();
			}
			modelsCache[j].readValues(Integer.parseInt(names.get(j)));
		}
	}

	public Models getModel(int i) {
		return modelsCache[i];
	}

	public Models() {
		vert_x = null;
		vert_y = null;
		vert_z = null;
		face_vert_cnt = null;
		texture_front = null;
		texture_back = null;
		face_shade = null;
		face_verts = null;
	}

	public void readValues(int s) {
		byte[] is = archive.getFile(s);
		int i = 0;
		int j = DataOperations.getUnsigned2Bytes(is, i);
		i += 2;
		int k = DataOperations.getUnsigned2Bytes(is, i);
		i += 2;
		vert_x = new int[j];
		vert_y = new int[j];
		vert_z = new int[j];
		face_vert_cnt = new int[k];
		texture_front = new int[k];
		texture_back = new int[k];
		face_shade = new int[k];
		face_verts = new int[k][];
		for (int l = 0; l < j; l++) {
			vert_x[l] = DataOperations.getSigned2Bytes(is, i);
			i += 2;
		}
		for (int l = 0; l < j; l++) {
			vert_y[l] = DataOperations.getSigned2Bytes(is, i);
			i += 2;
		}
		for (int l = 0; l < j; l++) {
			vert_z[l] = DataOperations.getSigned2Bytes(is, i);
			i += 2;
		}
		vert_cnt = j;
		for (int l = 0; l < k; l++)
			face_vert_cnt[l] = is[i++] & 0xff;
		for (int l1 = 0; l1 < k; l1++) {
			texture_front[l1] = DataOperations.getSigned2Bytes(is, i);
			i += 2;
			if (texture_front[l1] == 32767)
				texture_front[l1] = use_gourad;
		}
		for (int l1 = 0; l1 < k; l1++) {
			texture_back[l1] = DataOperations.getSigned2Bytes(is, i);
			i += 2;
			if (texture_back[l1] == 32767)
				texture_back[l1] = use_gourad;
		}
		for (int l1 = 0; l1 < k; l1++) {
			int k2 = is[i++] & 0xff;
			if (k2 == 0)
				face_shade[l1] = 0;
			else
				face_shade[l1] = use_gourad;
		}
		for (int l2 = 0; l2 < k; l2++) {
			face_verts[l2] = new int[face_vert_cnt[l2]];
			for (int i3 = 0; i3 < face_vert_cnt[l2]; i3++)
				if (j < 256) {
					face_verts[l2][i3] = is[i++] & 0xff;
				} else {
					face_verts[l2][i3] = DataOperations
							.getUnsigned2Bytes(is, i);
					i += 2;
				}
		}

		face_cnt = k;

	}

	private Color getColor(int rscColor) {
		rscColor = -1 - rscColor;
		int k2 = (rscColor >> 10 & 0x1f) * 8;
		int j3 = (rscColor >> 5 & 0x1f) * 8;
		int l3 = (rscColor & 0x1f) * 8;
		int rgbValue = 0;
		for (int j4 = 0; j4 < 256; j4++) {
			int j6 = j4 * j4;
			int red = (k2 * j6) / 0x10000;
			int green = (j3 * j6) / 0x10000;
			int blue = (l3 * j6) / 0x10000;
			rgbValue = ((red << 16) + (green << 8) + blue);
		}
		return new Color(rgbValue);
	}

	private int vert_x[];
	private int vert_y[];
	private int vert_z[];
	private int face_vert_cnt[];
	private int texture_front[];
	private int texture_back[];
	private int face_shade[];
	public int face_verts[][];
	private int vert_cnt;
	private int use_gourad;
	private int face_cnt;

	public static byte[] repack() throws IOException {
		ExtendedByteArrayOutputStream bos = new ExtendedByteArrayOutputStream();
		Models model[] = modelsCache;
		for (int i = 0; i < model.length; i++) {
			Models m = model[i];
			bos.writeShort(m.vert_cnt);
			bos.writeShort(m.face_cnt);
			for (int l = 0; l < m.vert_cnt; l++) {
				bos.writeSmart(m.vert_x[l]);
			}
			for (int l = 0; l < m.vert_cnt; l++) {
				bos.writeSmart(m.vert_y[l]);
			}
			for (int l = 0; l < m.vert_cnt; l++) {
				bos.writeSmart(m.vert_z[l]);
			}
			for (int l = 0; l < m.face_cnt; l++)
				bos.writeShort(l);
			for (int l = 0; l < m.face_cnt; l++)
				bos.writeSmart(m.texture_front[l]);
			for (int l = 0; l < m.face_cnt; l++)
				bos.writeSmart(m.texture_back[l]);
			for (int l = 0; l < m.face_cnt; l++)
				bos.writeSmart(m.face_shade[l]);
			for (int l = 0; l < m.face_cnt; l++) {
				for (int i3 = 0; i3 < m.face_vert_cnt[l]; i3++) {
					if (m.vert_cnt < 256) {
						bos.writeShort(0);
					} else {
						bos.writeSmart(m.face_verts[l][i3]);
					}
				}
			}
		}
		bos.close();
		return bos.toByteArray();
	}

	public Model buildRSCModel() {
		Model model = new Model();
		Vector<Vertex> vert = new Vector<Vertex>();
		Vector<Face> faces = new Vector<Face>();
		for (int l = 0; l < vert_cnt; l++) {
			vert.add(new Vertex(vert_x[l], vert_y[l], vert_z[l]));
		}
		for (int f = 0; f < face_cnt; f++) {
			Color c = Color.RED;
			int textureID = 0;
			if (texture_front[f] < 0) {
				int texture = texture_front[f];
				c = getColor(texture);
			}
			if (texture_back[f] < 0) {
				int texture = texture_back[f];
				c = getColor(texture);
			}
			if (texture_front[f] > 0) {
				textureID = texture_front[f] + 1;
			}
			if (texture_back[f] > 0) {
				textureID = texture_back[f] + 1;
			}
			int[] tester = new int[face_vert_cnt[f]];
			for (int i3 = 0; i3 < face_vert_cnt[f]; i3++) {
				tester[i3] = face_verts[f][i3];
			}
			if (textureID == 0) {
				faces.add(new Face(c, tester));
			} else {
				faces.add(new Face(textureID, tester));
			}
		}
		model.setVertices(vert);
		model.setFaces(faces);
		return model;
	}
}
