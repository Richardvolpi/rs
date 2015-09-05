public class update201to203 {

    private static final int mudVer = 203;

    // 201 - 203 Outgoing
    private static final int[] outgoing201 = {118,159,89,143,62,94,102,27,249,59,3,10,166,18,44,201,76,237,189,131,190,78,92,67,177,202,162,24,235,123,199,40,255,71,100,121,253,127,38,172,232,52,186,142,74,226,211,241,32,0,104,238};// 201
    private static final int[] outgoing202a = {73,177,74,142,166,211,53,216,145,254,129,71,49,104,206,232,67,17,154,183,198,48,253,128,255,56,248,89,27,147,181,92,34,36,126,235,245,94,51,40,168,52,153,72,41,246,132,83,32,0,39,218};// 202
    private static final int[] outgoing202b = {32,0,39,153,176,25,108,168,52,254,145,90,104,34,245,67,36,126,235,17,94,51,40,49,27,92,181,89,147,71,142,177,74,73,55,16,57,222,166,68,232,206,216,211,53,70,128,255,253,48,154,56,248,183,198,41,83,156,129,72,157,123,225,252,35,218,87,246,132,};// 202
    private static final int[] outgoing203 = {32,0,31,67,64,132,241,195,167,218,216,38,249,53,247,180,161,14,127,99,115,136,79,4,91,170,169,90,246,50,135,153,202,190,229,113,171,103,142,165,158,137,230,55,104,46,236,221,166,212,116,60,254,22,23,29,163,3,102,45,111,33,8,176,197,235,77,16,187};// 203

    // 201 - 203 Incoming
    private static final int[] incoming203 = {131,4,183,71,149,109,51,120,191,99,48,53,234,91,79,104,245,252,25,156,153,83,211,59,92,128,97,162,101,137,15,240,206,5,42,203,33,176,225,20,6,30,249,90,123,159,253,210,172,204,36,182,89,222,114,117,244,84,194,52};// 203
    private static final int[] incoming202b = {48,222,136,249,25,5,158,170,145,109,27,114,53,95,77,190,223,127,131,180,177,165,115,207,4,187,250,92,253,220,18,152,209,224,93,171,211,229,160,251,63,198,139,228,191,208,65,197,147,11,23,248,148,64,126,219,168,103,15,172};// 202
    private static final int[] incoming202a = {152,2,158,11,248,23,48,222,136,249,25,170,145,109,27,114,53,95,77,190,223,127,131,180,177,165,115,207,4,187,250,92,253,220,18,209,224,93,171,211,229,160,251,63,198,139,228,191,208,65,197,147,148,64,126,219,168,103,15,172};// 202
    private static final int[] incoming201 = {161,154,137,238,126,253,168,125,67,54,248,230,141,172,158,37,183,29,41,47,117,208,249,16,33,109,76,7,108,113,155,185,24,42,170,222,26,188,130,69,240,198,128,229,211,81,210,44,23,73,131,10,112,49,60,15,174,206,20,28};// 201

    public static final int getVer() {
        return mudVer;
    }

    public static final int fixOutgoingID(int id201) {
        int id202 = outGoing201to202(id201);
        int id203 = outGoing202to203(id202);
//        if(id201 < 0 || id202 < 0 || id203 < 0)
//            System.out.println("Fucked outgoing packet! 201: " + id201 + ", 202: " + id202 + ", 203: " + id203);
        return id203;
    }

    private static final int outGoing201to202(int id) {
        for(int x = 0;x < outgoing201.length;x++) {
            if(id == outgoing201[x])
                return outgoing202a[x];
        }
        return -1;
    }
    
    private static final int outGoing202to203(int id) {
        for(int x = 0;x < outgoing202b.length;x++) {
            if(id == outgoing202b[x])
                return outgoing203[x];
        }
        return -1;
    }

    public static final int fixIncomingID(int id203) {
        int id202 = inComing203to202(id203);
        int id201 = inComing202to201(id202);
//        if(id201 < 0 || id202 < 0 || id203 < 0)
//            System.out.println("Fucked incoming packet! 201: " + id201 + ", 202: " + id202 + ", 203: " + id203);
        return id201;
    }
    
    private static final int inComing203to202(int id) {
        for(int x = 0;x < incoming203.length;x++) {
            if(id == incoming203[x])
                return incoming202b[x];
        }
        return -1;
    }
    
    private static final int inComing202to201(int id) {
        for(int x = 0;x < incoming202a.length;x++) {
            if(id == incoming202a[x])
                return incoming201[x];
        }
        return -1;
    }

}