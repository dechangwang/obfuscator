package com.sun.tools.javac;

import com.sun.tools.javac.StreamDrainer.TestRunCmd;

public class TestRun {

	public static void main(String[] args) {
		 StreamDrainer  nn = new StreamDrainer();
		 nn.new TestRunCmd().test("HelloWorld");

	}

}
