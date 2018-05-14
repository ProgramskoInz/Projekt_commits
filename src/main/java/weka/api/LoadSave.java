package weka.api;
import weka.*;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.File;
import java.io.*;
public class LoadSave {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//DataSource source = new DataSource("C:/autos.arff");
		//Instances dataset = source.getDataSet();
		Instances	 dataset = new Instances(new BufferedReader(new FileReader("C:/autos.arff"))); //pristupanje podacima
		
		//load CSV
		/*
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("");
		Instances data = loader.getDataset();
		
		load ARFF
		ArffLoader loader = new ArffLoader();
		loader.setSource...
		instances data = loader.getDataSet();
		CSVSaver saver = new CSVSaver();
		saver.setInstances(data) // setaj dataset koji os spremit
	 ovdje dvije linije isto ko i za arff spremanje
		
		 */
		System.out.println(dataset.toSummaryString());
		/*
		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		saver.setFile(new File("C:/novi.arff"));
		saver.writeBatch();*/
	}

}
