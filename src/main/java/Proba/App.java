package Proba;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;


import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.classifiers.bayes.NaiveBayes;
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Cao");
		BufferedReader breader = null;
		breader = new BufferedReader(new FileReader("C:/autos.arff"));
		
		Instances train = new Instances (breader);
		train.setClassIndex(train.numAttributes() - 1);
		breader.close();
		
		NaiveBayes nB = new NaiveBayes();
		nB.buildClassifier(train);
		Evaluation eval = new Evaluation(train);
		eval.crossValidateModel(nB,train,10, new Random(1));
		System.out.println(eval.toSummaryString("\nResults\n=====\n",true));
		System.out.println(eval.fMeasure(1) + " " + eval.precision(1) + " " + eval.recall(1));
	}
}
