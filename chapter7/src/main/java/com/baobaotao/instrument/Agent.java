package com.baobaotao.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class Agent {
	public static void premain(String agentArgs, Instrumentation instrumentation) {
		
		ClassFileTransformer transformer = new Transformer();
		instrumentation.addTransformer(transformer);
	}
}
