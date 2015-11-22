package com.sun.tools.javac;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamDrainer  implements Runnable {
	private InputStream ins;

    public StreamDrainer(InputStream ins) {
        this.ins = ins;
    }

    public StreamDrainer() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(ins));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  class TestRunCmd {
    	public  void test(String args) {
    		//String[] cmd = new String[] { "cmd.exe", "/k","cd", "D:\\guochuang\\obfuscator-test\\src" };
            String[] cmd2 = new String[] { "cmd.exe", "/k", "java", "-classpath","D:\\guochuang\\obfuscator-test\\src","obfuscator.helloworld."+args };
            try {
                Process process = Runtime.getRuntime().exec(cmd2);
               // process = Runtime.getRuntime().exec(cmd2);

               
                
                new Thread(new StreamDrainer(process.getInputStream())).start();
                new Thread(new StreamDrainer(process.getErrorStream())).start();
                
                process.getOutputStream().close();

                int exitValue = process.waitFor();
                System.out.println("∑µªÿ÷µ£∫" + exitValue);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
