package com.sun.tools.javac;

import java.io.PrintWriter;

import com.sun.tools.javac.StreamDrainer.TestRunCmd;

public class TestMain {

	 /** Main entry point for the launcher.
     *  Note: This method calls System.exit.
     *  @param args command line arguments
     */
    public static void main(String[] args) throws Exception {
    	
    	String path[]={"D:\\guochuang\\obfuscator-test\\src\\obfuscator\\helloworld\\HelloWorld.java"};
    	System.exit(compile(path));
       
       
    }

    /** Programmatic interface to the Java Programming Language
     * compiler, javac.
     *
     * @param args The command line arguments that would normally be
     * passed to the javac program as described in the man page.
     * @return an integer equivalent to the exit value from invoking
     * javac, see the man page for details.
     */
    public static int compile(String[] args) {
        com.sun.tools.javac.main.Main compiler =
            new com.sun.tools.javac.main.Main("javac");
        return compiler.compile(args).exitCode;
    }



    /** Programmatic interface to the Java Programming Language
     * compiler, javac.
     *
     * @param args The command line arguments that would normally be
     * passed to the javac program as described in the man page.
     * @param out PrintWriter to which the compiler's diagnostic
     * output is directed.
     * @return an integer equivalent to the exit value from invoking
     * javac, see the man page for details.
     */
    public static int compile(String[] args, PrintWriter out) {
        com.sun.tools.javac.main.Main compiler =
            new com.sun.tools.javac.main.Main("javac", out);
        return compiler.compile(args).exitCode;
    }
}
