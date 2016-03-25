package edu.sjsu.facetedJS.interpreter;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.sjsu.facetedJS.interpreter.parser.FacetedJavaScriptLexer;
import edu.sjsu.facetedJS.interpreter.parser.FacetedJavaScriptParser;

import edu.sjsu.facetedJS.interpreter.core.AstVisitor;
import edu.sjsu.facetedJS.interpreter.core.Statement;
import edu.sjsu.facetedJS.interpreter.core.env.Environment;
import edu.sjsu.facetedJS.interpreter.core.env.ProgramCounter;

public class Interp {
	public static final int NUM_SECURITY_LB = 8;
	public static final int NUM_TEST_RUN = 1;
	
	private InterpreterType type;
	
	public Interp(){
		this(InterpreterType.FE);
	}
	public Interp(InterpreterType type){
		this.type = type;
	}
	
	public void run(){
		switch(type){
		case SME: 
			break;
		case SME_C:
			break;
		case FE:
			break;
		}
	}
	
	public void flush(String[] args) throws Exception{
		runScript("", args);
	}
	
	public void test(String[] args, int p) throws Exception{
		long startTime = System.nanoTime();
		String msg = "Security label : " + p + " ";
		
		switch(type){
		case SME:
			msg += "Secure Multi-Execution";
			runSME(args, "",p);
			break;
		case SME_C:
			msg += "Concurrent Secure Multi-Execution";
			ArrayList<Thread> td = new ArrayList<Thread>();
			runSME_c(args, "", p, td);
			for (Thread t : td)  t.join();
			break;
		case FE:
			msg += "Faceted Execution";
			runFE(args, p);
			break;
		}
		
		// benchmark test
        long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		int duration_ms = (int) Math.round(duration/1000000000.0 * 1000);
		DecimalFormat formatter = new DecimalFormat("#,###,###");
		System.out.println(msg + " : " + formatter.format(duration_ms) + "" + " ms");
	}
	
	private static void runSME(String[] args, String acc, int i) throws Exception{
		if (i > 0){
			runSME(args, acc+"s"+i+"=true;", i - 1);
			runSME(args, acc+"s"+i+"=false;", i - 1);
			return;
		}
		runScript(acc, args);
	}
	
	private static void runSME_c(String[] args, String acc, int i, ArrayList<Thread> td) throws Exception{
		if (i > 0){
			runSME_c(args, acc+"s"+i+"=true;", i - 1, td);
			runSME_c(args, acc+"s"+i+"=false;", i - 1, td);
			return;
		}
		Thread t = new SMEThread(acc, args);
		td.add(t);
		t.start();
	}
	
	private static void runFE(String[] args, int p) throws Exception{		
		String acc = "";
		for (int i = 1; i <= p; i++){
			acc += "k"+i+"=new Label();s"+i+"=setSecurity(k"+i+",true, false);";
		}
		runScript(acc,args);
	}

	
	public static void main(String[] args) throws Exception {
//		// flush
//		Interp interpTest = new Interp();
//		interpTest.flush(args);
//
//		// Secure Multi-Execution Brenchmark
//		for (int p = 0; p <= NUM_SECURITY_LB; p++){
//			Interp interp = new Interp(InterpreterType.SME);
//			interp.test(args, p);
//		}
//		// Concurrent Secure Multi-Execution Brenchmark
//		for (int p = 0; p <= NUM_SECURITY_LB; p++){
//			Interp interp = new Interp(InterpreterType.SME_C);
//			interp.test(args, p);
//		}
//		// Faceted JS Brenchmark
//		for (int p = 0; p <= NUM_SECURITY_LB; p++){
//			Interp interp = new Interp(InterpreterType.FE);
//			interp.test(args, p);
//		}

		run(args, new Environment());
	}
	
	static void runScript(String s, String[] args) throws Exception{
		int i = NUM_TEST_RUN;
		while (i > 0){
			Environment env = new Environment();
			String script ="s1 = true;s2 = true;s3 = true;s4 = true;s5 = true;s6 = true;s7 = true;s8 = true;" + s;
			ProgramCounter pc = new ProgramCounter();
			FacetedJavaScriptLexer _lexer = new FacetedJavaScriptLexer(new ANTLRInputStream(script));
	        CommonTokenStream _tokens = new CommonTokenStream(_lexer);
			FacetedJavaScriptParser _parser = new FacetedJavaScriptParser(_tokens);
	        ParseTree _tree = _parser.prog();
	        AstVisitor _builder = new AstVisitor();
	        Statement systemScript = (Statement) _builder.visit(_tree);
	        systemScript.evaluate(env, pc, true);
			run(args, env);
			i--;        
		}
	}
	
	
	public static void run(String[] args, Environment env) throws Exception{
		// predefined script
		ProgramCounter pc = new ProgramCounter();
		InputStream _is = Interp.class.getResourceAsStream("/env.js");
		ANTLRInputStream _input = new ANTLRInputStream(_is);

		FacetedJavaScriptLexer _lexer = new FacetedJavaScriptLexer(_input);
        CommonTokenStream _tokens = new CommonTokenStream(_lexer);
        FacetedJavaScriptParser _parser = new FacetedJavaScriptParser(_tokens);
        ParseTree _tree = _parser.prog();

        AstVisitor _builder = new AstVisitor();
        Statement systemScript = (Statement) _builder.visit(_tree);
        
        systemScript.evaluate(env, pc, true);
		
		// beginning of interpreter
        String inputFile = null;
        if (args.length > 0) {
        	inputFile = args[0];
        }
        InputStream is = System.in;
        if (inputFile != null) {
			is = Interp.class.getResourceAsStream("/"+inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);

		FacetedJavaScriptLexer lexer = new FacetedJavaScriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
		FacetedJavaScriptParser parser = new FacetedJavaScriptParser(tokens);
        ParseTree tree = parser.prog();
        
        AstVisitor builder = new AstVisitor();
        Statement prog = (Statement) builder.visit(tree);
        
        prog.evaluate(env, pc, false);
	}
}

enum InterpreterType {
    SME,	// Secure Multi-Execution
    SME_C,	// Concurrent Secure Multi-Execution
    FE		// Faceted Execution
}

class SMEThread extends Thread {
   private String acc;
   private String[] args;
   
   SMEThread(String acc, String[] args){
       this.acc = acc;
       this.args = args;
   }
   
   public void run() {
	   try {
		   Interp.runScript(acc, args);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
   }

}
