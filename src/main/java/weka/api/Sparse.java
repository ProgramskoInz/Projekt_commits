package weka.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;

public class Sparse {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Instances	 dataset = new Instances(new BufferedReader(new FileReader("C:/autos.arff"))); //pristupanje podacima
		NonSparseToSparse sp = new NonSparseToSparse();
		sp.setInputFormat(dataset);
		
		Instances newData = Filter.useFilter(dataset, sp);
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File(".."));
		saver.writeBatch();
	}

}
