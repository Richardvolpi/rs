import java.io.IOException;


public class r {

    public void hcm(int ai[]) {
        hcc = new p(ai);
        hcd = new p(ai);
    }

    public void baj() {}

    public long hcn()throws IOException {
        long l = hdh();
        long l1 = hdh();
        long l2 = hdh();
        long l3 = hdh();

        return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
    }

    public boolean hda() {
        return han > 0;
    }

    public void hdb(int i, byte abyte0[])throws IOException {
        bam(i, 0, abyte0);
    }

    public int hdc(int i) {
        return i - hcc.daf() & 0xff;
    }

    public int bak()throws IOException {
        return 0;
    }

    public void hdd(int i)throws IOException {
        if (hcg) {
            han = 0;
            hba = 3;
            hcg = false;
            throw new IOException(hci);
        }
        hck++;
        if (hck < i) {
            return;
        }
        if (han > 0) {
            hck = 0;
            ban(hbc, 0, han);
        }
        han = 0;
        hba = 3;
    }

    public void End() {
        if (hcd != null) {
            int i = hbc[han + 2] & 0xff;

            hbc[han + 2] = (byte) (i + hcd.daf());
        }
        if (hbb != 8) {
            hba++;
        }
        int j = hba - han - 2;

        if (j >= 160) {
            hbc[han] = (byte) (160 + j / 256);
            hbc[han + 1] = (byte) (j & 0xff);
        } else {
            hbc[han] = (byte) j;
            hba--;
            hbc[han + 1] = hbc[hba];
        }
        if (hcj <= 10000) {
            int k = hbc[han + 2] & 0xff;

            hcf[k]++;
            hch[k] += hba - han;
        }
        han = hba;
    }

    public void hdf(byte arg0[], int arg1, int arg2) {
        for (int i = 0; i < arg2; i++) {
            hbc[hba++] = arg0[arg1 + i];
        }
    }

    public void SendID(int i) {
        i = mudclient.fixID(i, true);
        if (han > (hcj * 4) / 5) {
            try {
                hdd(0);
            } catch (IOException ioexception) {
                hcg = true;
                hci = ioexception.getMessage();
            }
        }
        if (hbc == null) {
            hbc = new byte[hcj];
        }
        hbc[han + 2] = (byte) i;
        hbc[han + 3] = 0;
        hba = han + 3;
        hbb = 8;
    }

    public int hdh()throws IOException {
        int i = hea();
        int j = hea();

        return i * 256 + j;
    }

    public int hdi(byte arg0[]) {
        try {
            hal++;
            if (ham > 0 && hal > ham) {
                hcg = true;
                hci = "time-out";
                ham += ham;
                return 0;
            }
            if (hak == 0 && bal() >= 2) {
                hak = bak();
                if (hak >= 160) {
                    hak = (hak - 160) * 256 + bak();
                }
            }
            if (hak > 0 && bal() >= hak) {
                if (hak >= 160) {
                    hdb(hak, arg0);
                } else {
                    arg0[hak - 1] = (byte) bak();
                    if (hak > 1) {
                        hdb(hak - 1, arg0);
                    }
                }
                int i = hak;

                hak = 0;
                hal = 0;
                return i;
            }
        } catch (IOException ioexception) {
            hcg = true;
            hci = ioexception.getMessage();
        }
        return 0;
    }

    public void SendInt(int i) {
        hbc[hba++] = (byte) (i >> 8);
        hbc[hba++] = (byte) i;
    }

    public void SendString(String s) {
        s.getBytes(0, s.length(), hbc, hba);
        hba += s.length();
    }

    public int bal()throws IOException {
        return 0;
    }

    public void hdl(long l) {
        SendDouble((int) (l >> 32));
        SendDouble((int) (l & -1L));
    }

    public void hdm()throws IOException {
        End();
        hdd(0);
    }

    public void SendDouble(int i) {
        hbc[hba++] = (byte) (i >> 24);
        hbc[hba++] = (byte) (i >> 16);
        hbc[hba++] = (byte) (i >> 8);
        hbc[hba++] = (byte) i;
    }

    public int hea()throws IOException {
        return bak();
    }

    public void ban(byte abyte0[], int i, int j)throws IOException {}

    public void bam(int i, int j, byte abyte0[])throws IOException {}

    public void SendVar(int i) {
        hbc[hba++] = (byte) i;
    }

    public r() {
        hba = 3;
        hbb = 8;
        hcg = false;
        hci = "";
        hcj = 5000;
    }

    protected int hak;
    public int hal;
    public int ham;
    public int han;
    private int hba;
    private int hbb;
    public byte hbc[];
    final int hbe = 61;
    final int hbf = 59;
    final int hbg = 42;
    final int hbh = 43;
    final int hbi = 44;
    final int hbj = 45;
    final int hbk = 46;
    final int hbl = 47;
    final int hbm = 92;
    final int hbn = 32;
    final int hca = 124;
    final int hcb = 34;
    public p hcc;
    public p hcd;
    static char hce[];
    public static int hcf[] = new int[256];
    protected boolean hcg;
    public static int hch[] = new int[256];
    protected String hci;
    protected int hcj;
    protected int hck;
    public static int hcl;

    static {
        hce = new char[256];
        for (int i = 0; i < 256; i++) {
            hce[i] = (char) i;
        }
        hce[61] = '=';
        hce[59] = ';';
        hce[42] = '*';
        hce[43] = '+';
        hce[44] = ',';
        hce[45] = '-';
        hce[46] = '.';
        hce[47] = '/';
        hce[92] = '\\';
        hce[124] = '|';
        hce[33] = '!';
        hce[34] = '"';
    }
}
