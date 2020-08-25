import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.io.*;

/**
 * 无第三方包调用
 */
public class CallPythonNo {
    public static void main(String[] args) {
        runtime();
        isPython();
        runDiskPython();
        runPythonMethod();
    }

    public static void runPythonMethod() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("testPythonNO.py");
        PyFunction pyFunction = interpreter.get("add", PyFunction.class);
        Integer a = 1;
        Integer b = 4;
        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("the anwser is: " + pyobj);
    }

    public static void runDiskPython() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("testPythonNO.py");
    }

    public static void isPython() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a='hello world'; ");
        interpreter.exec("print a;");
    }

    public static void runtime() {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python testPythonNO.py");
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
