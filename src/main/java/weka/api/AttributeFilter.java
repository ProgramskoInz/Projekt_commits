package weka.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class AttributeFilter {

	public static void main(String[] args) throws Exception {
		//ucitaj dataset
		Instances dataset = new Instances(new BufferedReader(new FileReader("C:/autos.arff")));
		//ucitaj opcije za brisanje atribute
		String[] opts = new String[] {"-R","1"};
		//filter klasa remove objekt
		Remove remove = new Remove();
		//filter opc
		remove.setOptions(opts);
		//salji dataset
		remove.setInputFormat(dataset);
		//ucitaj filter
		Instances newData = Filter.useFilter(dataset, remove);
		
		//save dataset kao novi 
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("......"));
		saver.writeBatch();
	}

}
