package brainacad;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class TestResultLogger implements TestWatcher, BeforeTestExecutionCallback {
    
    private static PrintStream out;
    private static boolean utf8Initialized = false;
    
    static {
        initializeUTF8();
    }
    
    private static void initializeUTF8() {
        if (!utf8Initialized) {
            try {
                System.setOut(new PrintStream(System.out, true, "UTF-8"));
                System.setErr(new PrintStream(System.err, true, "UTF-8"));
                out = System.out;
                utf8Initialized = true;
            } catch (UnsupportedEncodingException e) {
                out = System.out;
            }
        } else {
            out = System.out;
        }
    }
    
    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String testName = getTestName(context);
        out.println("\n[ВЫПОЛНЕНИЕ ТЕСТА] " + testName);
    }
    
    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = getTestName(context);
        out.println("[УСПЕШНО] " + testName);
    }
    
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = getTestName(context);
        out.println("[НЕ ПРОШЕЛ] " + testName);
        out.println("  Причина: " + cause.getMessage());
    }
    
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = getTestName(context);
        out.println("[ПРЕРВАН] " + testName);
        if (cause != null) {
            out.println("  Причина: " + cause.getMessage());
        }
    }
    
    private String getTestName(ExtensionContext context) {
        String displayName = context.getDisplayName();
        String methodName = context.getTestMethod().map(m -> m.getName()).orElse("Unknown");
        return displayName != null && !displayName.equals(methodName) 
            ? displayName + " (" + methodName + ")" 
            : methodName;
    }
}

