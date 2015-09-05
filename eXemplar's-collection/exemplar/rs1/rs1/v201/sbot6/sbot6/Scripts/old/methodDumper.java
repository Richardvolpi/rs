package Scripts;

import java.lang.reflect.Method;

public class methodDumper {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("client");
            Method[] m = c.getMethods();
            for(int i = 0; i < m.length; i ++)
                System.out.println(m[i].toString());
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
