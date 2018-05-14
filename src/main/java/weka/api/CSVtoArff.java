package weka.api;
import weka.*;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.*;
public class CSVtoArff {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
	
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(""));
		Instances data = loader.getDataSet();
		
	/*	load ARFF
		ArffLoader loader = new ArffLoader();
		loader.setSource...
		instances data = loader.getDataSet();
		CSVSaver saver = new CSVSaver();
		saver.setInstances(data) // setaj dataset koji os spremit
	 ovdje dvije linije isto ko i za arff spremanje
		
		 */
	
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("C:/novi.arff"));
		saver.writeBatch();
	}

}
