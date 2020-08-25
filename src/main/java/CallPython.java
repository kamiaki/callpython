import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 单参数的调用 有第三方包
 */
public class CallPython {
    public static void main(String[] args) {
        int a = 18;
        int b = 23;
        try {
            String[] args1 = new String[] { "python", "testPython.py", String.valueOf(a), String.valueOf(b),"aaaA啊啊" };
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
