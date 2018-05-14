package weka.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;

public class DiskretizirajAtribut {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Instances dataset = new Instances(new BufferedReader(new FileReader("C:/autos.arff"))); //pristupanje podacima
		String[] options= new String[4];
		options[0] = "-B"; options[1] = "4";
		//doseg
		options[2] = "-R";
		options[3] = "2-3";
		
		Discretize discretize = new Discretize();
		discretize.setOptions(options);
		discretize.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, discretize);
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("..."));
		saver.writeBatch();
	}

}
