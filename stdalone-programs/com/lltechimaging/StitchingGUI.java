package com.lltechimaging;

import java.io.*;

import javax.swing.JFrame;

import org.apache.commons.io.IOUtils;

/*This program launches MainStitching in HeadLess mode, in order to have
 * progress messages in console output and no image display or log window during stitching.*/

public class StitchingGUI 
{
    static String[] classpaths = {"jars/ij.jar", "jars/edu_mines_jtk.jar", "plugins/Stitching_.jar"};
    
    public static void main(String [] args) throws Exception
    {
    	JFrame f = null;
    	if (args.length != 6)
    	{
    		System.out.println("Please specify the following arguments: ");
    		System.out.println(" - path to tileconfig file");
    		System.out.println(" - regression threshold");
    		System.out.println(" - Max/avg displacement threshold");
    		System.out.println(" - Absolute avg displacement threshold");
    		System.out.println(" - threshold for delta to the expected positions");
    		System.out.println(" - path to saved tiff file (without extension)");
    	}
    	try
    	{
		   f = new StitchingGUIFrame();
		   f.setVisible(true);
		   
		   File exe = new File(System.getProperty("java.home"), "bin/java");
		   
		   String classpath = new String();
		   for (String string : classpaths) {
			   classpath += string + File.pathSeparatorChar;			
		   }
		   ProcessBuilder pbuilder = new ProcessBuilder(exe.getAbsolutePath(), 
				   "-cp",  classpath,
				   "-Djava.awt.headless=true", "-Xmx10000m", "-Xincgc", "-XX:PermSize=128m", 
				   "MainStitching", args[0], args[1], args[2], args[3], args[4], args[5]);
		   pbuilder.redirectErrorStream(true);
		   Process proc = pbuilder.start();
		   IOUtils.copy(proc.getInputStream(), System.out);
		   f.dispose();
		   System.exit(proc.exitValue());
    	}
    	finally
    	{f.dispose();}
    }
}
