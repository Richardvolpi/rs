import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;

@SuppressWarnings("serial")
public class a extends Applet implements Runnable {

    private String[] WebName = {
        "jagex.jag", "filter2.jag", "maps63.jag", "entity24.mem", "config85.jag", "maps63.mem",
        "textures17.jag", "media58.jag", "sounds1.mem", "land63.jag", "land63.mem", "entity24.jag", "models36.jag"};
    private int[] size = {
        4990, 15377, 37629, 48212, 58819, 59481, 63685, 0x181a9, 0x1bec7, 0x22c2f, 0x25c3b, 0x3baf3,
        0x46c1e};

    protected void StartBot() {}
    
    protected synchronized void MudLoop() {}
    
    protected synchronized void ircLoop() {}
    
    protected void fed() {}
    
    protected synchronized void DrawRs() {}
    
    protected final void CreateApplet(int i, int k, String s, boolean flag, boolean onTop) {
        AppletWidth = i;
        AppletHeight = k;
        RsFrame = new c(this, i, k, s, flag, false, onTop);
        fim = 1;
        RsThread = new Thread(this);
        RsThread.start();
        RsThread.setPriority(1);
    }

    protected final void fle(int i) {
        fid = 1000 / i;
    }

    protected final void flf() {
        for (int i = 0; i < 10; i++) {
            fif[i] = 0L;
        }
    }

    public final synchronized boolean keyDown(Event arg0, int arg1) {
        KeyPressed(arg1);
        fki = arg1;
        fkj = arg1;
        if (arg1 == 1006) {
            fjl = true;
        }
        if (arg1 == 1007) {
            fjm = true;
        }
        if (arg1 == 1004) {
            fjn = true;
        }
        if (arg1 == 1005) {
            fka = true;
        }
        if ((char) arg1 == ' ') {
            fkb = true;
        }
        if ((char) arg1 == 'n' || (char) arg1 == 'm') {
            fkc = true;
        }
        if ((char) arg1 == 'N' || (char) arg1 == 'M') {
            fkc = true;
        }
        if ((char) arg1 == '{') {
            fjj = true;
        }
        if ((char) arg1 == '}') {
            fjk = true;
        }
        if ((char) arg1 == '\u03F0') {
            fkk = !fkk;
        }
        boolean flag = false;

        for (int i = 0; i < fji.length(); i++) {
            if (arg1 != fji.charAt(i)) {
                continue;
            }
            flag = true;
            break;
        }
        if (flag && fkl.length() < 20) {
            fkl += (char) arg1;
        }
        if (flag && fkn.length() < 80) {
            fkn += (char) arg1;
        }
        if (arg1 == 8 && fkl.length() > 0) {
            fkl = fkl.substring(0, fkl.length() - 1);
        }
        if (arg1 == 8 && fkn.length() > 0) {
            fkn = fkn.substring(0, fkn.length() - 1);
        }
        if (arg1 == 10 || arg1 == 13) {
            fkm = fkl;
            fla = fkn;
        }
        return true;
    }

    protected void KeyPressed(int i) {}

    public final synchronized boolean keyUp(Event event, int i) {
        fki = 0;
        if (i == 1006) {
            fjl = false;
        }
        if (i == 1007) {
            fjm = false;
        }
        if (i == 1004) {
            fjn = false;
        }
        if (i == 1005) {
            fka = false;
        }
        if ((char) i == ' ') {
            fkb = false;
        }
        if ((char) i == 'n' || (char) i == 'm') {
            fkc = false;
        }
        if ((char) i == 'N' || (char) i == 'M') {
            fkc = false;
        }
        if ((char) i == '{') {
            fjj = false;
        }
        if ((char) i == '}') {
            fjk = false;
        }
        return true;
    }

    public final synchronized boolean mouseMove(Event event, int i, int k) {
        MouseX = i;
        MouseY = k + fik;
        MouseDownVar = 0;
        return true;
    }

    public final synchronized boolean mouseUp(Event event, int i, int k) {
        MouseX = i;
        MouseY = k + fik;
        MouseDownVar = 0;
        return true;
    }

    public final synchronized boolean mouseDown(Event arg0, int arg1, int arg2) {
        MouseX = arg1;
        MouseY = arg2 + fik;
        if (arg0.metaDown()) {
            MouseDownVar = 2;
        } else {
            MouseDownVar = 1;
        }
        fkh = MouseDownVar;
        fcf(MouseDownVar, arg1, arg2);
        return true;
    }

    protected void fcf(int i, int k, int l) {}

    public final synchronized boolean mouseDrag(Event arg0, int arg1, int arg2) {
        MouseX = arg1;
        MouseY = arg2 + fik;
        if (arg0.metaDown()) {
            MouseDownVar = 2;
        } else {
            MouseDownVar = 1;
        }
        return true;
    }

    public final void init() {
        run();
    }

    public final void start() {
        if (fii >= 0) {
            fii = 0;
        }
    }

    public final void stop() {
        if (fii >= 0) {
            fii = 4000 / fid;
        }
    }

    public void destroy() {
        fii = -1;
        try {
            Thread.sleep(5000L);
        } catch (Exception _ex) {}
        if (fii == -1) {
            System.out.println("5 seconds expired, forcing kill");
            CloseBot();
            if (RsThread != null) {
                RsThread.stop();// Deprecated
                RsThread = null;
            }
        }
    }

    public final void CloseBot() {
        fii = -2;
        System.out.println("Closing program");
        fed();
        try {
            Thread.sleep(1000L);
        } catch (Exception _ex) {}
        if (RsFrame != null) {
            RsFrame.dispose();
        }
        System.exit(0);
    }

    public final void run() {
        if (fim == 1) {
            fim = 2;
            LoadingGfx = getGraphics();
            DrawLoadingLogo();
            fli(0, "Loading...");
            StartBot();
            fim = 0;
        }
        int i = 0;
        int k = 256;
        int i1 = 1;
        int j1 = 0;
        for (int k1 = 0; k1 < 10; k1++) {
            fif[k1] = System.currentTimeMillis();
        }
        while (fii >= 0) {
            if (fii > 0) {
                fii--;
                if (fii == 0) {
                    CloseBot();
                    RsThread = null;
                    return;
                }
            }
            int i2 = k;
            int j2 = i1;
            k = 300;
            i1 = 1;
            long l1 = System.currentTimeMillis();
            if (fif[i] == 0L) {
                k = i2;
                i1 = j2;
            } else if (l1 > fif[i]) {
                k = (int) ((long) (2560 * fid) / (l1 - fif[i]));
            }
            if (k < 25) {
                k = 25;
            }
            if (k > 256) {
                k = 256;
                i1 = (int) ((long) fid - (l1 - fif[i]) / 10L);
                if (i1 < fkd) {
                    i1 = fkd;
                }
            }
            try {
                Thread.sleep(i1);
            } catch (Exception e) {
                System.out.println(e);
            }
            fif[i] = l1;
            i = (i + 1) % 10;
            if (i1 > 1) {
                for (int k2 = 0; k2 < 10; k2++) {
                    if (fif[k2] != 0L) {
                        fif[k2] += i1;
                    }
                }
            }
            int l2 = 0;
            ircLoop();
            while (j1 < 256) {
                MudLoop();
                j1 += k;
                if (++l2 > fie) {
                    j1 = 0;
                    fij += 6;
                    if (fij > 25) {
                        fij = 0;
                        fkk = true;
                    }
                    break;
                }
            }
            fij--;
            j1 &= 0xff;
            DrawRs();
        }
        if (fii == -1) {
            CloseBot();
        }
        RsThread = null;
    }

    public final void update(Graphics g1) {
        paint(g1);
    }

    public final void paint(Graphics g1) {
        if (fim == 2 && LoadingLogo != null) {
            fli(fjb, fjc);
            return;
        }
    }

    private final void DrawLoadingLogo() {
        LoadingGfx.setColor(Color.black);
        LoadingGfx.drawImage(LoadingLogo, 5, 0, this);
        j.cdi("h11p", 0, this);
        j.cdi("h12b", 1, this);
        j.cdi("h12p", 2, this);
        j.cdi("h13b", 3, this);
        j.cdi("h14b", 4, this);
        j.cdi("h16b", 5, this);
        j.cdi("h20b", 6, this);
        j.cdi("h24b", 7, this);
    }

    private final void fli(int arg0, String arg1) {
        try {
            int i = (AppletWidth - 281) / 2;
            int k = AppletHeight - 115;

            LoadingGfx.setColor(Color.black);
            LoadingGfx.fillRect(0, 0, AppletWidth, AppletHeight);
            LoadingGfx.drawImage(LoadingLogo, 5, 0, this);
            i += 2;
            k += 90;
            fjb = arg0;
            fjc = arg1;
            LoadingGfx.setColor(new Color(125, 0, 0));
            if (fja) {
                LoadingGfx.setColor(new Color(220, 0, 0));
            }
            LoadingGfx.drawRect(i - 2, k - 2, 280, 23);
            LoadingGfx.setColor(new Color(210, 60, 60));
            LoadingGfx.fillRect(i, k, (277 * arg0) / 100, 20);
            LoadingGfx.setColor(new Color(198, 198, 198));
            if (fja) {
                LoadingGfx.setColor(new Color(255, 255, 255));
            }
            WriteString(LoadingGfx, arg1, Arial, i + 138, k + 10);
        } catch (Exception _ex) {}
    }

    protected final void flj(int i, String s) {
        try {
            int k = (AppletWidth - 281) / 2;
            int l = AppletHeight - 115;
            k += 2;
            l += 90;
            fjb = i;
            fjc = s;
            int i1 = (277 * i) / 100;
            LoadingGfx.setColor(new Color(125, 0, 0));
            if (fja) {
                LoadingGfx.setColor(new Color(220, 0, 0));
            }
            LoadingGfx.fillRect(k, l, i1, 20);
            LoadingGfx.setColor(new Color(210, 60, 60));
            LoadingGfx.fillRect(k + i1, l, 277 - i1, 20);
            LoadingGfx.setColor(new Color(198, 198, 198));
            if (fja) {
                LoadingGfx.setColor(new Color(255, 255, 255));
            }
            WriteString(LoadingGfx, s, Arial, k + 138, l + 10);
            return;
        } catch (Exception _ex) {
            return;
        }
    }

    protected final void WriteString(Graphics arg0, String arg1, Font arg2, int arg3, int arg4) {
        Object obj;
        if (RsFrame == null) {
            obj = this;
        } else {
            obj = RsFrame;
        }
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(arg2);
        fontmetrics.stringWidth(arg1);
        arg0.setFont(arg2);
        arg0.drawString(arg1, arg3 - fontmetrics.stringWidth(arg1) / 2, arg4 + fontmetrics.getHeight() / 4);
    }

    protected byte[] LoadDataFile(int x, String arg1, int arg2) {
        boolean found = true;
        int i = 0;
        int k = 0;
        byte abyte0[] = null;
        flj(arg2, "Loading " + arg1 + " - 0%");
        String dir = System.getProperty("user.dir") + "/Data/";
        File file = new File(dir);
        if (!file.exists()) {
            if (!file.mkdir()) {
                return new byte[0];
            }
        }
        String arg0 = dir + WebName[x];
        try {
            file = new File(arg0);
            if (!file.exists()) {
                found = false;
                URL url = new URL("http://uk1.runescape.com/client2/" + WebName[x]);
                DataInputStream datainputstream = new DataInputStream(url.openStream());
                int l = size[x];
                byte abyte1[] = new byte[l];
                for (int i1 = 0; i1 < l; i1 += 1000) {
                    int j1 = l - i1;
                    if (j1 > 1000) {
                        j1 = 1000;
                    }
                    datainputstream.readFully(abyte1, i1, j1);
                    flj(arg2, "Loading " + arg1 + " - " + (5 + (i1 * 95) / l) / 2 + "%");
                }
                datainputstream.close();
                FileOutputStream fileoutputstream = new FileOutputStream(arg0);
                fileoutputstream.write(abyte1);
                fileoutputstream.close();
            }
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(arg0));
            byte abyte2[] = new byte[6];
            datainputstream.readFully(abyte2, 0, 6);
            i = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
            k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
            if (found) {
                flj(arg2, "Loading " + arg1 + " - 5%");
            }
            int l = 0;
            abyte0 = new byte[k];
            while (l < k) {
                int i1 = k - l;
                if (i1 > 1000) {
                    i1 = 1000;
                }
                datainputstream.readFully(abyte0, l, i1);
                l += i1;
                if (found) {
                    flj(arg2, "Loading " + arg1 + " - " + (5 + (l * 95) / k) + "%");
                } else {
                    flj(arg2, "Loading " + arg1 + " - " + (5 + (l * 95) / k) / 2 + "%");
                }
            }
            datainputstream.close();
        } catch (IOException _ex) {}
        flj(arg2, "Unpacking " + arg1);
        if (k != i) {
            byte abyte1[] = new byte[i];
            g.glj(abyte1, i, abyte0, k, 0);
            return abyte1;
        } else {
            return abyte0;
        }
    }

    public Graphics getGraphics() {
        if (RsFrame != null) {
            return RsFrame.getGraphics();
        } else {
            return super.getGraphics();
        }
    }

    public Image createImage(int i, int k) {
        if (RsFrame != null) {
            return RsFrame.createImage(i, k);
        } else {
            return super.createImage(i, k);
        }
    }

    public URL getCodeBase() {
        return super.getCodeBase();
    }

    public URL getDocumentBase() {
        return super.getDocumentBase();
    }

    public String getParameter(String s) {
        return super.getParameter(s);
    }

    protected Socket NewSocket(String arg0, int arg1)throws IOException {
        Socket socket = new Socket(InetAddress.getByName(arg0), arg1);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    protected void NewThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    public a() {
        AppletWidth = 512;
        AppletHeight = 384;
        fid = 20;
        fie = 1000;
        fif = new long[10];
        fim = 1;
        fja = false;
        fjc = "Loading";
        Arial = new Font("Arial", 1, 10);
        fjj = false;
        fjk = false;
        fjl = false;
        fjm = false;
        fjn = false;
        fka = false;
        fkb = false;
        fkc = false;
        fkd = 1;
        fkk = false;
        fkl = "";
        fkm = "";
        fkn = "";
        fla = "";
    }

    private int AppletWidth;
    private int AppletHeight;
    public Thread RsThread;
    private int fid;
    private int fie;
    private long fif[];
    public static c RsFrame = null;
    public int fii;
    private int fij;
    public int fik;
    public int fim;
    private boolean fja;
    private int fjb;
    private String fjc;
    private Font Arial;
    public Image LoadingLogo;
    private Graphics LoadingGfx;
    private static String fji = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public boolean fjj;
    public boolean fjk;
    public boolean fjl;
    public boolean fjm;
    public boolean fjn;
    public boolean fka;
    public boolean fkb;
    public boolean fkc;
    public int fkd;
    public int MouseX;
    public int MouseY;
    public int MouseDownVar;
    public int fkh;
    public int fki;
    public int fkj;
    public boolean fkk;
    public String fkl;
    public String fkm;
    public String fkn;
    public String fla;
}
