import java.lang.*;

public class WordFilter {

    public static void loadFilter(Buffer fragments, Buffer bad, Buffer host, Buffer tld) {
        loadBad(bad);
        loadHost(host);
        loadFragments(fragments);
        loadTld(tld);
    }

    public static void loadTld(Buffer buffer) {
        int wordcount = buffer.getUnsignedInt();
        tldList = new char[wordcount][];
        tldType = new int[wordcount];
        for (int idx = 0; idx < wordcount; idx++) {
            tldType[idx] = buffer.getUnsignedByte();
            char ac[] = new char[buffer.getUnsignedByte()];
            for (int k = 0; k < ac.length; k++)
                ac[k] = (char) buffer.getUnsignedByte();

            tldList[idx] = ac;
        }

    }

    public static void loadBad(Buffer buffer) {
        int wordcount = buffer.getUnsignedInt();
        badList = new char[wordcount][];
        badUnknown = new byte[wordcount][][];
        readBuffer(buffer, badList, badUnknown);
    }

    public static void loadHost(Buffer buffer) {
        int wordcount = buffer.getUnsignedInt();
        hostList = new char[wordcount][];
        hostUnknown = new byte[wordcount][][];
        //System.out.println("hostsenc len: " + buffer.buffer.length);
        //System.exit(1);
        readBuffer(buffer, hostList, hostUnknown);
    }

    public static void loadFragments(Buffer buffer) {
        hashFragments = new int[buffer.getUnsignedInt()];
        for (int i = 0; i < hashFragments.length; i++)
            hashFragments[i] = buffer.getUnsignedShort();

    }

    public static void readBuffer(Buffer buffer, char wordlist[][], byte abyte0[][][]) {
        for (int i = 0; i < wordlist.length; i++) {
            char currentword[] = new char[buffer.getUnsignedByte()];
            for (int j = 0; j < currentword.length; j++)
                currentword[j] = (char) buffer.getUnsignedByte();

            //if(buffer.buffer.length == 6188)
                //System.out.println(i + "=" + new String(currentword));
            wordlist[i] = currentword;
            byte abyte1[][] = new byte[buffer.getUnsignedInt()][2];
            for (int k = 0; k < abyte1.length; k++) {
                abyte1[k][0] = (byte) buffer.getUnsignedByte();
                abyte1[k][1] = (byte) buffer.getUnsignedByte();
            }

            if (abyte1.length > 0)
                abyte0[i] = abyte1;
        }

    }

    public static String filter(String input) {
        char outputChars[] = input.toLowerCase().toCharArray();
        applyDotSlashFilter(outputChars);
        applyBadwordFilter(outputChars);
        applyHostFilter(outputChars);
        method382(outputChars);
        for (int ignoreIdx = 0; ignoreIdx < ignoreList.length; ignoreIdx++) {
            for (int inputIgnoreIdx = -1; (inputIgnoreIdx = input.indexOf(ignoreList[ignoreIdx], inputIgnoreIdx + 1)) != -1; ) {
                char ignorewordChars[] = ignoreList[ignoreIdx].toCharArray();
                for (int ignorewordIdx = 0; ignorewordIdx < ignorewordChars.length; ignorewordIdx++)
                    outputChars[ignorewordIdx + inputIgnoreIdx] = ignorewordChars[ignorewordIdx];

            }

        }

        if (forceLowercase) {
            stripNonUppercase(input.toCharArray(), outputChars);
            toLowercase(outputChars);
        }
        return new String(outputChars);
    }

    public static void stripNonUppercase(char input[], char output[]) {
        for (int chrIdx = 0; chrIdx < input.length; chrIdx++)
            if (output[chrIdx] != '*' && isUppercase(input[chrIdx]))
                output[chrIdx] = input[chrIdx];

    }

    public static void toLowercase(char input[]) {// i think
        boolean isUppercase = true;
        for (int idx = 0; idx < input.length; idx++) {
            char current = input[idx];
            if (isLetter(current)) {
                if (isUppercase) {
                    if (isLowercase(current))
                        isUppercase = false;
                } else if (isUppercase(current))
                    input[idx] = (char) ((current + 97) - 65);
            } else {
                isUppercase = true;
            }
        }

    }

    public static void applyBadwordFilter(char input[]) {
        for (int i = 0; i < 2; i++) {
            for (int j = badList.length - 1; j >= 0; j--)
                applyWordFilter(input, badList[j], badUnknown[j]);

        }

    }

    public static void applyHostFilter(char input[]) {
        for (int i = hostList.length - 1; i >= 0; i--)
            applyWordFilter(input, hostList[i], hostUnknown[i]);

    }

    public static void applyDotSlashFilter(char input[]) {
        char input1[] = input.clone();
        char dot[] = {
                'd', 'o', 't'
        };
        applyWordFilter(input1, dot, null);
        char input2[] = input.clone();
        char slash[] = {
                's', 'l', 'a', 's', 'h'
        };
        applyWordFilter(input2, slash, null);
        for (int i = 0; i < tldList.length; i++)
            applyTldFilter(input, input1, input2, tldList[i], tldType[i]);

    }

    public static void applyTldFilter(char input[], char input1[], char input2[], char tld[], int type) {
        if (tld.length > input.length)
            return;
        for (int chr = 0; chr <= input.length - tld.length; chr++) {
            int idx2 = chr;
            int l = 0;
            while (idx2 < input.length) {
                int i1 = 0;
                char current = input[idx2];
                char next = '\0';
                if (idx2 + 1 < input.length)
                    next = input[idx2 + 1];
                if (l < tld.length && (i1 = compareLettersNumbers(tld[l], current, next)) > 0) {
                    idx2 += i1;
                    l++;
                    continue;
                }
                if (l == 0)
                    break;
                if ((i1 = compareLettersNumbers(tld[l - 1], current, next)) > 0) {
                    idx2 += i1;
                    continue;
                }
                if (l >= tld.length || !isNotLetterOrDigit(current))
                    break;
                idx2++;
            }
            if (l >= tld.length) {
                boolean flag = false;
                int startmatch = method375(input, input1, chr);
                int endmatch = method376(input, input2, idx2 - 1);
                if (DEBUGTLD)
                    System.out.println("Potential tld: " + tld + " at char " + chr + " (type=" + type + ", startmatch=" + startmatch + ", endmatch=" + endmatch + ")");
                if (type == 1 && startmatch > 0 && endmatch > 0)
                    flag = true;
                if (type == 2 && (startmatch > 2 && endmatch > 0 || startmatch > 0 && endmatch > 2))
                    flag = true;
                if (type == 3 && startmatch > 0 && endmatch > 2)
                    flag = true;
                boolean Tmp = type == 3 && startmatch > 2 && endmatch > 0;
                if (flag) {
                    if (DEBUGTLD)
                        System.out.println("Filtered tld: " + tld + " at char " + chr);
                    int l1 = chr;
                    int i2 = idx2 - 1;
                    if (startmatch > 2) {
                        if (startmatch == 4) {
                            boolean flag1 = false;
                            for (int k2 = l1 - 1; k2 >= 0; k2--)
                                if (flag1) {
                                    if (input1[k2] != '*')
                                        break;
                                    l1 = k2;
                                } else if (input1[k2] == '*') {
                                    l1 = k2;
                                    flag1 = true;
                                }

                        }
                        boolean flag2 = false;
                        for (int l2 = l1 - 1; l2 >= 0; l2--)
                            if (flag2) {
                                if (isNotLetterOrDigit(input[l2]))
                                    break;
                                l1 = l2;
                            } else if (!isNotLetterOrDigit(input[l2])) {
                                flag2 = true;
                                l1 = l2;
                            }

                    }
                    if (endmatch > 2) {
                        if (endmatch == 4) {
                            boolean flag3 = false;
                            for (int i3 = i2 + 1; i3 < input.length; i3++)
                                if (flag3) {
                                    if (input2[i3] != '*')
                                        break;
                                    i2 = i3;
                                } else if (input2[i3] == '*') {
                                    i2 = i3;
                                    flag3 = true;
                                }

                        }
                        boolean flag4 = false;
                        for (int j3 = i2 + 1; j3 < input.length; j3++)
                            if (flag4) {
                                if (isNotLetterOrDigit(input[j3]))
                                    break;
                                i2 = j3;
                            } else if (!isNotLetterOrDigit(input[j3])) {
                                flag4 = true;
                                i2 = j3;
                            }

                    }
                    for (int j2 = l1; j2 <= i2; j2++)
                        input[j2] = '*';

                }
            }
        }

    }

    public static int method375(char input[], char input1[], int i) {
        if (i == 0)
            return 2;
        for (int j = i - 1; j >= 0; j--) {
            if (!isNotLetterOrDigit(input[j]))
                break;
            if (input[j] == ',' || input[j] == '.')
                return 3;
        }

        int filtered = 0;
        for (int l = i - 1; l >= 0; l--) {
            if (!isNotLetterOrDigit(input1[l]))
                break;
            if (input1[l] == '*')
                filtered++;
        }

        if (filtered >= 3)
            return 4;
        return !isNotLetterOrDigit(input[i - 1]) ? 0 : 1;
    }

    public static int method376(char ac[], char ac1[], int i) {
        if (i + 1 == ac.length)
            return 2;
        for (int j = i + 1; j < ac.length; j++) {
            if (!isNotLetterOrDigit(ac[j]))
                break;
            if (ac[j] == '\\' || ac[j] == '/')
                return 3;
        }

        int k = 0;
        for (int l = i + 1; l < ac.length; l++) {
            if (!isNotLetterOrDigit(ac1[l]))
                break;
            if (ac1[l] == '*')
                k++;
        }

        if (k >= 5)
            return 4;
        return !isNotLetterOrDigit(ac[i + 1]) ? 0 : 1;
    }

    public static void applyWordFilter(char ac[], char word[], byte abyte0[][]) {
        if (word.length > ac.length)
            return;
        for (int chr = 0; chr <= ac.length - word.length; chr++) {
            int j = chr;
            int k = 0;
            boolean flag = false;
            while (j < ac.length) {
                int l = 0;
                char c = ac[j];
                char c2 = '\0';
                if (j + 1 < ac.length)
                    c2 = ac[j + 1];
                if (k < word.length && (l = compareLettersSymbols(word[k], c, c2)) > 0) {
                    j += l;
                    k++;
                    continue;
                }
                if (k == 0)
                    break;
                if ((l = compareLettersSymbols(word[k - 1], c, c2)) > 0) {
                    j += l;
                    continue;
                }
                if (k >= word.length || !isNotLowercaseLetter(c))
                    break;
                if (isNotLetterOrDigit(c) && c != '\'')
                    flag = true;
                j++;
            }
            if (k >= word.length) {
                boolean flag1 = true;
                if (DEBUGTLD)
                    System.out.println("Potential word: " + word + " at char " + chr);
                if (!flag) {
                    char c1 = ' ';
                    if (chr - 1 >= 0)
                        c1 = ac[chr - 1];
                    char c3 = ' ';
                    if (j < ac.length)
                        c3 = ac[j];
                    byte byte0 = encodeChar(c1);
                    byte byte1 = encodeChar(c3);
                    if (abyte0 != null && method378(abyte0, byte0, byte1))
                        flag1 = false;
                } else {
                    boolean flag2 = false;
                    boolean flag3 = false;
                    if (chr - 1 < 0 || isNotLetterOrDigit(ac[chr - 1]) && ac[chr - 1] != '\'')
                        flag2 = true;
                    if (j >= ac.length || isNotLetterOrDigit(ac[j]) && ac[j] != '\'')
                        flag3 = true;
                    if (!flag2 || !flag3) {
                        boolean flag4 = false;
                        int j1 = chr - 2;
                        if (flag2)
                            j1 = chr;
                        for (; !flag4 && j1 < j; j1++)
                            if (j1 >= 0 && (!isNotLetterOrDigit(ac[j1]) || ac[j1] == '\'')) {
                                char ac2[] = new char[3];
                                int k1;
                                for (k1 = 0; k1 < 3; k1++) {
                                    if (j1 + k1 >= ac.length || isNotLetterOrDigit(ac[j1 + k1]) && ac[j1 + k1] != '\'')
                                        break;
                                    ac2[k1] = ac[j1 + k1];
                                }

                                boolean flag5 = true;
                                if (k1 == 0)
                                    flag5 = false;
                                if (k1 < 3 && j1 - 1 >= 0 && (!isNotLetterOrDigit(ac[j1 - 1]) || ac[j1 - 1] == '\''))
                                    flag5 = false;
                                if (flag5 && !method391(ac2))
                                    flag4 = true;
                            }

                        if (!flag4)
                            flag1 = false;
                    }
                }
                if (flag1) {
                    if (DEBUGWORD)
                        System.out.println("Filtered word: " + word + " at char " + chr);
                    for (int i1 = chr; i1 < j; i1++)
                        ac[i1] = '*';

                }
            }
        }

    }

    public static boolean method378(byte abyte0[][], byte byte0, byte byte1) {
        int i = 0;
        if (abyte0[i][0] == byte0 && abyte0[i][1] == byte1)
            return true;
        int j = abyte0.length - 1;
        if (abyte0[j][0] == byte0 && abyte0[j][1] == byte1)
            return true;
        do {
            int k = (i + j) / 2;
            if (abyte0[k][0] == byte0 && abyte0[k][1] == byte1)
                return true;
            if (byte0 < abyte0[k][0] || byte0 == abyte0[k][0] && byte1 < abyte0[k][1])
                j = k;
            else
                i = k;
        } while (i != j && i + 1 != j);
        return false;
    }

    public static int compareLettersNumbers(char c, char c1, char c2) {// l33tsp33k
        if (c == c1)
            return 1;
        if (c == 'e' && c1 == '3')
            return 1;
        if (c == 't' && (c1 == '7' || c1 == '+'))
            return 1;
        if (c == 'a' && (c1 == '4' || c1 == '@'))
            return 1;
        if (c == 'o' && c1 == '0')
            return 1;
        if (c == 'i' && c1 == '1')
            return 1;
        if (c == 's' && c1 == '5')
            return 1;
        if (c == 'f' && c1 == 'p' && c2 == 'h')
            return 2;
        return c != 'g' || c1 != '9' ? 0 : 1;
    }

    public static int compareLettersSymbols(char letter, char c1, char c2) {
        if (letter == '*')
            return 0;
        if (letter == c1)
            return 1;
        if (letter >= 'a' && letter <= 'z') {
            if (letter == 'e')
                return c1 != '3' ? 0 : 1;
            if (letter == 't')
                return c1 != '7' ? 0 : 1;
            if (letter == 'a')
                return c1 != '4' && c1 != '@' ? 0 : 1;
            if (letter == 'o') {
                if (c1 == '0' || c1 == '*')
                    return 1;
                return c1 != '(' || c2 != ')' ? 0 : 2;
            }
            if (letter == 'i')
                return c1 != 'y' && c1 != 'l' && c1 != 'j' && c1 != '1' && c1 != '!' && c1 != ':' && c1 != ';' ? 0 : 1;
            if (letter == 'n')
                return 0;
            if (letter == 's')
                return c1 != '5' && c1 != 'z' && c1 != '$' ? 0 : 1;
            if (letter == 'r')
                return 0;
            if (letter == 'h')
                return 0;
            if (letter == 'l')
                return c1 != '1' ? 0 : 1;
            if (letter == 'd')
                return 0;
            if (letter == 'c')
                return c1 != '(' ? 0 : 1;
            if (letter == 'u')
                return c1 != 'v' ? 0 : 1;
            if (letter == 'm')
                return 0;
            if (letter == 'f')
                return c1 != 'p' || c2 != 'h' ? 0 : 2;
            if (letter == 'p')
                return 0;
            if (letter == 'g')
                return c1 != '9' && c1 != '6' ? 0 : 1;
            if (letter == 'w')
                return c1 != 'v' || c2 != 'v' ? 0 : 2;
            if (letter == 'y')
                return 0;
            if (letter == 'b')
                return c1 != '1' || c2 != '3' ? 0 : 2;
            if (letter == 'v')
                return 0;
            if (letter == 'k')
                return 0;
            if (letter == 'x')
                return c1 != ')' || c2 != '(' ? 0 : 2;
            if (letter == 'j')
                return 0;
            if (letter == 'q')
                return 0;
            if (letter == 'z')
                return 0;
        }
        if (letter >= '0' && letter <= '9') {
            if (letter == '0') {
                if (c1 == 'o' || c1 == 'O')
                    return 1;
                return c1 != '(' || c2 != ')' ? 0 : 2;
            }
            if (letter == '1')
                return c1 != 'l' ? 0 : 1;
            if (letter == '2')
                return 0;
            if (letter == '3')
                return 0;
            if (letter == '4')
                return 0;
            if (letter == '5')
                return 0;
            if (letter == '6')
                return 0;
            if (letter == '7')
                return 0;
            if (letter == '8')
                return 0;
            if (letter == '9')
                return 0;
        }
        if (letter == '-')
            return 0;
        if (letter == ',')
            return c1 != '.' ? 0 : 1;
        if (letter == '.')
            return c1 != ',' ? 0 : 1;
        if (letter == '(')
            return 0;
        if (letter == ')')
            return 0;
        if (letter == '!')
            return c1 != 'i' ? 0 : 1;
        if (letter == '\'')
            return 0;
        if (DEBUGWORD)
            System.out.println("Letter=" + letter + " not matched");
        return 0;
    }

    public static byte encodeChar(char c) {// returns the "id" of a character
        if (c >= 'a' && c <= 'z')
            return (byte) ((c - 97) + 1);
        if (c == '\'')
            return 28;
        if (c >= '0' && c <= '9')
            return (byte) ((c - 48) + 29);
        else
            return 27;
    }

    public static void method382(char input[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        while ((i = indexOfDigit(input, j)) != -1) {
            boolean flag = false;
            for (int i1 = j; i1 >= 0 && i1 < i && !flag; i1++)
                if (!isNotLetterOrDigit(input[i1]) && !isNotLowercaseLetter(input[i1]))
                    flag = true;

            if (flag)
                k = 0;
            if (k == 0)
                l = i;
            j = indexOfNonDigit(input, i);
            int j1 = 0;
            for (int k1 = i; k1 < j; k1++)
                j1 = (j1 * 10 + input[k1]) - 48;

            if (j1 > 255 || j - i > 8)
                k = 0;
            else
                k++;
            if (k == 4) {
                for (int l1 = l; l1 < j; l1++)
                    input[l1] = '*';

                k = 0;
            }
        }
    }

    public static int indexOfDigit(char input[], int start) {
        for (int idx = start; idx < input.length && idx >= 0; idx++)
            if (input[idx] >= '0' && input[idx] <= '9')
                return idx;

        return -1;
    }

    public static int indexOfNonDigit(char input[], int start) {
        for (int idx = start; idx < input.length && idx >= 0; idx++)
            if (input[idx] < '0' || input[idx] > '9')
                return idx;

        return input.length;
    }

    public static boolean isNotLetterOrDigit(char c) {
        return !isLetter(c) && !isDigit(c);
    }

    public static boolean isNotLowercaseLetter(char c) {
        if (c < 'a' || c > 'z')
            return true;
        return c == 'v' || c == 'x' || c == 'j' || c == 'q' || c == 'z';
    }

    public static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isLowercase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isUppercase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean method391(char input[]) {
        boolean notNum = true;
        for (int i = 0; i < input.length; i++)
            if (!isDigit(input[i]) && input[i] != 0)
                notNum = false;

        if (notNum)
            return true;
        int wordhash = word2hash(input);
        int k = 0;
        int fragmentLen = hashFragments.length - 1;
        if (wordhash == hashFragments[k] || wordhash == hashFragments[fragmentLen])
            return true;
        do {
            int i1 = (k + fragmentLen) / 2;
            if (wordhash == hashFragments[i1])
                return true;
            if (wordhash < hashFragments[i1])
                fragmentLen = i1;
            else
                k = i1;
        } while (k != fragmentLen && k + 1 != fragmentLen);
        return false;
    }

    public static int word2hash(char word[]) {
        if (word.length > 6)
            return 0;
        int i = 0;
        for (int j = 0; j < word.length; j++) {
            char c = word[word.length - j - 1];
            if (c >= 'a' && c <= 'z')
                i = i * 38 + ((c - 97) + 1);
            else if (c == '\'')
                i = i * 38 + 27;
            else if (c >= '0' && c <= '9')
                i = i * 38 + ((c - 48) + 28);
            else if (c != 0) {
                if (DEBUGWORD)
                    System.out.println("word2hash failed on " + new String(word));
                return 0;
            }
        }

        return i;
    }

    static boolean DEBUGTLD;
    static boolean DEBUGWORD;
    static boolean forceLowercase = true;
    //static int unused = 3;
    static int hashFragments[];
    static char badList[][];
    static byte badUnknown[][][];
    static char hostList[][];
    static byte hostUnknown[][][];
    static char tldList[][];
    static int tldType[];
    static String ignoreList[] = {
            "cook", "cook's", "cooks", "seeks", "sheet"
    };

}
