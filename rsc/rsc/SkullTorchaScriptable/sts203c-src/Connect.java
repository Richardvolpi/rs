import java.io.*;
import java.net.Socket;

public class Connect extends r implements Runnable {

    public Connect(Socket socket, a a1)throws IOException {
        bae = false;
        bai = true;
        bad = socket;
        bab = socket.getInputStream();
        bac = socket.getOutputStream();
        bai = false;
        a1.NewThread(this);
    }

    public void baj() {
        super.baj();
        bae = true;
        try {
            if (bab != null) {
                bab.close();
            }
            if (bac != null) {
                bac.close();
            }
            if (bad != null) {
                bad.close();
            }
        } catch (IOException _ex) {
            System.out.println("Error closing stream");
        }
        bai = true;
        synchronized (this) {
            notify();
        }
        baf = null;
    }

    public int bak()throws IOException {
        if (bae) {
            return 0;
        }
        return bab.read();
    }

    public int bal()throws IOException {
        if (bae) {
            return 0;
        }
        return bab.available();
    }

    public void bam(int arg0, int arg1, byte arg2[])throws IOException {
        if (bae) {
            return;
        }
        int j;
        for (int i = 0; i < arg0; i += j) {
            if ((j = bab.read(arg2, i + arg1, arg0 - i)) <= 0) {
                throw new IOException("EOF");
            }
        }
    }

    public void ban(byte arg0[], int arg1, int arg2)throws IOException {
        if (bae) {
            return;
        }
        if (baf == null) {
            baf = new byte[5000];
        }
        synchronized (this) {
            for (int i = 0; i < arg2; i++) {
                baf[bah] = arg0[i + arg1];
                bah = (bah + 1) % 5000;
                if (bah == (bag + 4900) % 5000) {
                    throw new IOException("buffer overflow");
                }
            }
            notify();
        }
    }

    public void run() {
        while (!bai) {
            int i;
            int j;
            synchronized (this) {
                if (bah == bag) {
                    try {
                        wait();
                    } catch (InterruptedException _ex) {}
                }
                if (bai) {
                    return;
                }
                j = bag;
                if (bah >= bag) {
                    i = bah - bag;
                } else {
                    i = 5000 - bag;
                }
            }
            if (i > 0) {
                try {
                    bac.write(baf, j, i);
                } catch (IOException ioexception) {
                    super.hcg = true;
                    super.hci = "Twriter:" + ioexception;
                }
                bag = (bag + i) % 5000;
                try {
                    if (bah == bag) {
                        bac.flush();
                    }
                } catch (IOException ioexception1) {
                    super.hcg = true;
                    super.hci = "Twriter:" + ioexception1;
                }
            }
        }
    }

    private InputStream bab;
    private OutputStream bac;
    private Socket bad;
    private boolean bae;
    private byte baf[];
    private int bag;
    private int bah;
    private boolean bai;
}
