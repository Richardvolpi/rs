import java.math.BigInteger;

public class hash {

    hash() {
    }

    public hash(byte[] bytes) {
        hashStore = bytes;
        hashCount = 0;
    }

    public void addInt(int i) {
        hashStore[hashCount++] = (byte)i;
    }

    public void addInt2(int i) {
        hashStore[hashCount++] = (byte)(i >> 24);
        hashStore[hashCount++] = (byte)(i >> 16);
        hashStore[hashCount++] = (byte)(i >> 8);
        hashStore[hashCount++] = (byte)i;
    }

    public void addString(String s) {
        s.getBytes(0, s.length(), hashStore, hashCount);
        hashCount += s.length();
        hashStore[hashCount++] = 10;
    }

    public void copyHashBack(byte copyFrom[], int startAt, int finishAt) {
        for(int c = startAt; c < startAt + finishAt; c++)
            hashStore[hashCount++] = copyFrom[c];
    }

    public void copyHashTo(byte copyTo[], int startAt, int finishAt) {
        for(int c = startAt; c < startAt + finishAt; c++)
            copyTo[c] = hashStore[hashCount++];
    }

    public void addBigInts(BigInteger bigInt1, BigInteger bigInt2)  {
        int oldHashCount = hashCount;
        hashCount = 0;
        byte[] bytes = new byte[oldHashCount];
        copyHashTo(bytes, 0, oldHashCount);
        bytes = new BigInteger(bytes).modPow(bigInt1, bigInt2).toByteArray();
        hashCount = 0;
        addInt(bytes.length);
        copyHashBack(bytes, 0, bytes.length);
    }

    public byte hashStore[];
    public int hashCount;
}
