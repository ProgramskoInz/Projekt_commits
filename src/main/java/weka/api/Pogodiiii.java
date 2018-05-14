package weka.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import weka.classifiers.trees.J48;
import weka.core.Instances;

public class Pogodiiii {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader breader = null;
		breader = new BufferedReader(new FileReader("C:/autos.arff"));
		Instances train = new Instances(breader);
		train.setClassIndex(train.numAttributes()-1);
		
		breader = new BufferedReader(new FileReader("C:/iristest.arff"));
		Instances test = new Instances(breader);
		test.setClassIndex(train.numAttributes()-1);
		
		breader.close();
		
		J48 stablo = new J48();
		stablo.buildClassifier(train);
		Instances oznacene = new Instances(test);
		
		for(int i = 0 ;i < test.numInstances(); i++) {

			double clsLabel = stablo.classifyInstance(test.instance(i));
			oznacene.instance(i).setClassValue(clsLabel);
			 	
		}
		
		BufferedWriter pisac = new BufferedWriter(new FileWriter("C:/Users/Boris/oznacene.arff"));
		pisac.write(oznacene.toString());
		pisac.close();
	}

}
