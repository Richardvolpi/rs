import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class GameApplet extends Applet
        implements Runnable {

    protected void startGame() {
    }

    protected synchronized void handleInputs() {
    }

    protected void onClosing() {
    }

    protected synchronized void draw() {
    }

    protected final void startApplication(int w, int h, String title, boolean resizeable) {
        startedAsApplet = false;
        System.out.println("Started application");
        appletWidth = w;
        appletHeight = h;
        gameFrameReference = new GameFrame(this, w, h, title, resizeable, false);
        loadingStep = 1;
        appletThread = new Thread(this);
        appletThread.start();
        appletThread.setPriority(1);
    }

    protected final boolean getStartedAsApplet() {
        return startedAsApplet;
    }

    protected final void method8(int i) {
        anInt4 = 1000 / i;
    }

    protected final void resetTimings() {
        for (int i = 0; i < 10; i++)
            timings[i] = 0L;

    }

    public final synchronized boolean keyDown(Event event, int i) {
        handleKeyPress(i);
        //unusedKeyCode1 = i;
        //unusedKeyCode2 = i;
        lastMouseAction = 0;
        if (i == 1006)
            keyLeft = true;
        if (i == 1007)
            keyRight = true;
        if (i == 1004)
            keyUp = true;
        if (i == 1005)
            keyDown = true;
        if ((char) i == ' ')
            keySpace = true;
        /*if ((char) i == 'n' || (char) i == 'm')
            keyNm = true;
        if ((char) i == 'N' || (char) i == 'M')
            keyNm = true;
        if ((char) i == '{')
            keyLsb = true;
        if ((char) i == '}')
            keyRsb = true;*/
        if ((char) i == '\u03F0')
            interlace = !interlace;
        boolean foundText = false;
        for (int j = 0; j < charMap.length(); j++) {
            if (i != charMap.charAt(j))
                continue;
            foundText = true;
            break;
        }

        if (foundText && inputTextCurrent.length() < 20)
            inputTextCurrent += (char) i;
        if (foundText && inputPmCurrent.length() < 80)
            inputPmCurrent += (char) i;
        if (i == 8 && inputTextCurrent.length() > 0)
            inputTextCurrent = inputTextCurrent.substring(0, inputTextCurrent.length() - 1);
        if (i == 8 && inputPmCurrent.length() > 0)
            inputPmCurrent = inputPmCurrent.substring(0, inputPmCurrent.length() - 1);
        if (i == 10 || i == 13) {
            inputTextFinal = inputTextCurrent;
            inputPmFinal = inputPmCurrent;
        }
        return true;
    }

    protected void handleKeyPress(int i) {
    }

    public final synchronized boolean keyUp(Event event, int i) {
        //unusedKeyCode1 = 0;
        if (i == 1006)
            keyLeft = false;
        if (i == 1007)
            keyRight = false;
        if (i == 1004)
            keyUp = false;
        if (i == 1005)
            keyDown = false;
        if ((char) i == ' ')
            keySpace = false;
        /*if ((char) i == 'n' || (char) i == 'm')
            keyNm = false;
        if ((char) i == 'N' || (char) i == 'M')
            keyNm = false;
        if ((char) i == '{')
            keyLsb = false;
        if ((char) i == '}')
            keyRsb = false;*/
        return true;
    }

    public final synchronized boolean mouseMove(Event event, int i, int j) {
        mouseX = i;
        mouseY = j + yOffset;
        mouseButtonDown = 0;
        lastMouseAction = 0;
        return true;
    }

    public final synchronized boolean mouseUp(Event event, int i, int j) {
        mouseX = i;
        mouseY = j + yOffset;
        mouseButtonDown = 0;
        return true;
    }

    public final synchronized boolean mouseDown(Event event, int i, int j) {
        mouseX = i;
        mouseY = j + yOffset;
        if (event.metaDown())
            mouseButtonDown = 2;
        else
            mouseButtonDown = 1;
        lastMouseButtonDown = mouseButtonDown;
        lastMouseAction = 0;
        handleMouseDown(mouseButtonDown, i, j);
        return true;
    }

    protected void handleMouseDown(int i, int j, int k) {
    }

    public final synchronized boolean mouseDrag(Event event, int i, int j) {
        mouseX = i;
        mouseY = j + yOffset;
        if (event.metaDown())
            mouseButtonDown = 2;
        else
            mouseButtonDown = 1;
        return true;
    }

    public final void init() {
        startedAsApplet = true;
        System.out.println("Started applet");
        appletWidth = 512;
        appletHeight = 344;
        loadingStep = 1;
        Utility.appletCodeBase = getCodeBase();
        startThread(this);
    }

    public final void start() {
        if (stopTimeout >= 0)
            stopTimeout = 0;
    }

    public final void stop() {
        if (stopTimeout >= 0)
            stopTimeout = 4000 / anInt4;
    }

    public final void destroy() {
        stopTimeout = -1;
        try {
            Thread.sleep(5000L);
        } catch (Exception Ex) {
        }
        if (stopTimeout == -1) {
            System.out.println("5 seconds expired, forcing kill");
            closeProgram();
            if (appletThread != null) {
                appletThread.stop();
                appletThread = null;
            }
        }
    }

    private final void closeProgram() {
        stopTimeout = -2;
        System.out.println("Closing program");
        onClosing();
        try {
            Thread.sleep(1000L);
        } catch (Exception Ex) {
        }
        if (gameFrameReference != null)
            gameFrameReference.dispose();
        if (!startedAsApplet)
            System.exit(0);
    }

    public final void run() {
        if (loadingStep == 1) {
            loadingStep = 2;
            graphics = getGraphics();
            loadJagex();
            drawLoadingScreen(0, "Loading...");
            startGame();
            loadingStep = 0;
        }
        int i = 0;
        int j = 256;
        int sleep = 1;
        int i1 = 0;
        for (int j1 = 0; j1 < 10; j1++)
            timings[j1] = System.currentTimeMillis();

        //long l = System.currentTimeMillis();
        while (stopTimeout >= 0) {
            if (stopTimeout > 0) {
                stopTimeout--;
                if (stopTimeout == 0) {
                    closeProgram();
                    appletThread = null;
                    return;
                }
            }
            int k1 = j;
            int lastSleep = sleep;
            j = 300;
            sleep = 1;
            long time = System.currentTimeMillis();
            if (timings[i] == 0L) {
                j = k1;
                sleep = lastSleep;
            } else if (time > timings[i])
                j = (int) ((long) (2560 * anInt4) / (time - timings[i]));
            if (j < 25)
                j = 25;
            if (j > 256) {
                j = 256;
                sleep = (int) ((long) anInt4 - (time - timings[i]) / 10L);
                if (sleep < threadSleep)
                    sleep = threadSleep;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException Ex) {
            }
            timings[i] = time;
            i = (i + 1) % 10;
            if (sleep > 1) {
                for (int j2 = 0; j2 < 10; j2++)
                    if (timings[j2] != 0L)
                        timings[j2] += sleep;

            }
            int k2 = 0;
            while (i1 < 256) {
                handleInputs();
                i1 += j;
                if (++k2 > maxDrawTime) {
                    i1 = 0;
                    interlaceTimer += 6;
                    if (interlaceTimer > 25) {
                        interlaceTimer = 0;
                        interlace = true;
                    }
                    break;
                }
            }
            interlaceTimer--;
            i1 &= 0xff;
            draw();
        }
        if (stopTimeout == -1)
            closeProgram();
        appletThread = null;
    }

    public final void update(Graphics g) {
        paint(g);
    }

    public final void paint(Graphics g) {
        if (loadingStep == 2 && imageLogo != null) {
            drawLoadingScreen(loadingProgressPercent, loadingProgessText);
            //return;
        }
        //if (loadingStep == 0)
        //    emptyMethod();
    }

    private final void loadJagex() {
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, appletWidth, appletHeight);
        byte buff[] = readDataFile("jagex.jag", "Jagex library", 0);
        if (buff != null) {
            byte logo[] = Utility.loadData("logo.tga", 0, buff);
            imageLogo = createImage(logo);
        }
        buff = readDataFile("fonts" + Version.FONTS + ".jag", "Game fonts", 5);
        if(buff != null) {
            Surface.createFont(Utility.loadData("h11p.jf", 0, buff), 0);
            Surface.createFont(Utility.loadData("h12b.jf", 0, buff), 1);
            Surface.createFont(Utility.loadData("h12p.jf", 0, buff), 2);
            Surface.createFont(Utility.loadData("h13b.jf", 0, buff), 3);
            Surface.createFont(Utility.loadData("h14b.jf", 0, buff), 4);
            Surface.createFont(Utility.loadData("h16b.jf", 0, buff), 5);
            Surface.createFont(Utility.loadData("h20b.jf", 0, buff), 6);
            Surface.createFont(Utility.loadData("h24b.jf", 0, buff), 7);
        }
    }

    private final void drawLoadingScreen(int percent, String text) {
        try {
            int midx = (appletWidth - 281) / 2;
            int midy = (appletHeight - 148) / 2;
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, appletWidth, appletHeight);
            if (!hasRefererLogoNotused)
                graphics.drawImage(imageLogo, midx, midy, this);
            midx += 2;
            midy += 90;
            loadingProgressPercent = percent;
            loadingProgessText = text;
            graphics.setColor(new Color(132, 132, 132));
            if (hasRefererLogoNotused)
                graphics.setColor(new Color(220, 0, 0));
            graphics.drawRect(midx - 2, midy - 2, 280, 23);
            graphics.fillRect(midx, midy, (277 * percent) / 100, 20);
            graphics.setColor(new Color(198, 198, 198));
            if (hasRefererLogoNotused)
                graphics.setColor(new Color(255, 255, 255));
            drawString(graphics, text, fontTimesroman_15, midx + 138, midy + 10);
            if (!hasRefererLogoNotused) {
                drawString(graphics, "Created by JAGeX - visit www.jagex.com", fontHelvetica_13, midx + 138, midy + 30);
                drawString(graphics, "\2512001-2002 Andrew Gower and Jagex Ltd", fontHelvetica_13, midx + 138, midy + 44);
            } else {
                graphics.setColor(new Color(132, 132, 152));
                drawString(graphics, "\2512001-2002 Andrew Gower and Jagex Ltd", fontHelvetica_12, midx + 138, appletHeight - 20);
            }
            if (logoHeaderText != null) {
                graphics.setColor(Color.white);
                drawString(graphics, logoHeaderText, fontHelvetica_13, midx + 138, midy - 120);
            }
        } catch (Exception Ex) {
        }
    }

    protected final void showLoadingProgress(int i, String s) {
        try {
            int j = (appletWidth - 281) / 2;
            int k = (appletHeight - 148) / 2;
            j += 2;
            k += 90;
            loadingProgressPercent = i;
            loadingProgessText = s;
            int l = (277 * i) / 100;
            graphics.setColor(new Color(132, 132, 132));
            if (hasRefererLogoNotused)
                graphics.setColor(new Color(220, 0, 0));
            graphics.fillRect(j, k, l, 20);
            graphics.setColor(Color.black);
            graphics.fillRect(j + l, k, 277 - l, 20);
            graphics.setColor(new Color(198, 198, 198));
            if (hasRefererLogoNotused)
                graphics.setColor(new Color(255, 255, 255));
            drawString(graphics, s, fontTimesroman_15, j + 138, k + 10);
            return;
        } catch (Exception Ex) {
            return;
        }
    }

    protected final void drawString(Graphics g, String s, Font font, int i, int j) {
        Object obj;
        if (gameFrameReference == null)
            obj = this;
        else
            obj = gameFrameReference;
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(font);
        fontmetrics.stringWidth(s);
        g.setFont(font);
        g.drawString(s, i - fontmetrics.stringWidth(s) / 2, j + fontmetrics.getHeight() / 4);
    }

    private final Image createImage(byte buff[]) {
        int i = buff[13] * 256 + buff[12];
        int j = buff[15] * 256 + buff[14];
        byte abyte1[] = new byte[256];
        byte abyte2[] = new byte[256];
        byte abyte3[] = new byte[256];
        for (int k = 0; k < 256; k++) {
            abyte1[k] = buff[20 + k * 3];
            abyte2[k] = buff[19 + k * 3];
            abyte3[k] = buff[18 + k * 3];
        }

        IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
        byte abyte4[] = new byte[i * j];
        int l = 0;
        for (int i1 = j - 1; i1 >= 0; i1--) {
            for (int j1 = 0; j1 < i; j1++)
                abyte4[l++] = buff[786 + j1 + i1 * i];

        }

        MemoryImageSource memoryimagesource = new MemoryImageSource(i, j, indexcolormodel, abyte4, 0, i);
        return createImage(memoryimagesource);
    }

    protected byte[] readDataFile(String file, String prettyname, int percent) {
        //System.out.println("Using default load");
        file = "./data/" + file;
        int expectedTotal = 0;
        int total = 0;
        byte buff[] = null;
        try {
            showLoadingProgress(percent, "Loading " + prettyname + " - 0%");
            java.io.InputStream inputstream = Utility.openFile(file);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte header[] = new byte[6];
            datainputstream.readFully(header, 0, 6);
            expectedTotal = ((header[0] & 0xff) << 16) + ((header[1] & 0xff) << 8) + (header[2] & 0xff);
            total = ((header[3] & 0xff) << 16) + ((header[4] & 0xff) << 8) + (header[5] & 0xff);
            showLoadingProgress(percent, "Loading " + prettyname + " - 5%");
            int read = 0;
            buff = new byte[total];
            while (read < total) {
                int size = total - read;
                if (size > 1000)
                    size = 1000;
                datainputstream.readFully(buff, read, size);
                read += size;
                showLoadingProgress(percent, "Loading " + prettyname + " - " + (5 + (read * 95) / total) + "%");
            }
            datainputstream.close();
        } catch (IOException Ex) {
        }
        showLoadingProgress(percent, "Unpacking " + prettyname);
        if (total != expectedTotal) {
            byte decompressed[] = new byte[expectedTotal];
            BZLib.decompress(decompressed, expectedTotal, buff, total, 0);
            return decompressed;
        } else {
            return buff;
        }
    }

    public Graphics getGraphics() {
        if (gameFrameReference != null)
            return gameFrameReference.getGraphics();
        else
            return super.getGraphics();
    }

    public Image createImage(int i, int j) {
        if (gameFrameReference != null)
            return gameFrameReference.createImage(i, j);
        else
            return super.createImage(i, j);
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

    protected Socket createSocket(String s, int i)
            throws IOException {
        Socket socket;
        if (getStartedAsApplet())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket = new Socket(InetAddress.getByName(s), i);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    protected void startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    public GameApplet() {
        appletWidth = 512;
        appletHeight = 384;
        anInt4 = 20;
        maxDrawTime = 1000;
        timings = new long[10];
        loadingStep = 1;
        hasRefererLogoNotused = false;
        loadingProgessText = "Loading";
        fontTimesroman_15 = new Font("TimesRoman", 0, 15);
        fontHelvetica_13 = new Font("Helvetica", 1, 13);
        fontHelvetica_12 = new Font("Helvetica", 0, 12);
        //keyLsb = false;
        //keyRsb = false;
        keyLeft = false;
        keyRight = false;
        keyUp = false;
        keyDown = false;
        keySpace = false;
        //keyNm = false;
        threadSleep = 1;
        interlace = false;
        inputTextCurrent = "";
        inputTextFinal = "";
        inputPmCurrent = "";
        inputPmFinal = "";
    }

    private int appletWidth;
    private int appletHeight;
    private Thread appletThread;
    private int anInt4;
    private int maxDrawTime;
    private long timings[];
    public static GameFrame gameFrameReference = null;
    private boolean startedAsApplet;
    private int stopTimeout;
    private int interlaceTimer;
    public int yOffset;
    public int lastMouseAction;
    public int loadingStep;
    public String logoHeaderText;
    private boolean hasRefererLogoNotused;
    private int loadingProgressPercent;
    private String loadingProgessText;
    private Font fontTimesroman_15;
    private Font fontHelvetica_13;
    private Font fontHelvetica_12;
    private Image imageLogo;
    private Graphics graphics;
    private static String charMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    //public boolean keyLsb;
    //public boolean keyRsb;
    public boolean keyLeft;
    public boolean keyRight;
    public boolean keyUp;
    public boolean keyDown;
    public boolean keySpace;
    //public boolean keyNm;
    public int threadSleep;
    public int mouseX;
    public int mouseY;
    public int mouseButtonDown;
    public int lastMouseButtonDown;
    //public int unusedKeyCode1;
    //public int unusedKeyCode2;
    public boolean interlace;
    public String inputTextCurrent;
    public String inputTextFinal;
    public String inputPmCurrent;
    public String inputPmFinal;

}
