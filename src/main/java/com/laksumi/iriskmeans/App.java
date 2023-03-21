package com.laksumi.iriskmeans;

import java.io.File;
import java.io.IOException;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.clustering.Clusterer;

import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.evaluation.AICScore;
import net.sf.javaml.clustering.evaluation.BICScore;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;


import net.sf.javaml.tools.data.FileHandler;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException {
//        Dataset data = new Dataset("iris.data");
        Dataset data = FileHandler.loadDataset(new File("src/main/java/com/laksumi/iriskmeans/iris.data"), 4, ",");

        Clusterer kmean1 = new KMeans(1);
        Clusterer kmean2 = new KMeans(2);
        Clusterer kmean3 = new KMeans(3);
        Clusterer kmean4 = new KMeans(4);

        Dataset[] clusterBy1 = kmean1.cluster(data);
        Dataset[] clusterBy2 = kmean2.cluster(data);
        Dataset[] clusterBy3 = kmean3.cluster(data);
        Dataset[] clusterBy4 = kmean4.cluster(data);

        ClusterEvaluation aic = new AICScore();
        ClusterEvaluation bic = new BICScore();
        ClusterEvaluation squaredError = new SumOfSquaredErrors();

        double aic1 = aic.score(clusterBy1);
        double bic1 = bic.score(clusterBy1);
        double squaredError1 = squaredError.score(clusterBy1);

        double aic2 = aic.score(clusterBy2);
        double bic2 = bic.score(clusterBy2);
        double squaredError2 = squaredError.score(clusterBy2);

        double aic3 = aic.score(clusterBy3);
        double bic3 = bic.score(clusterBy3);
        double squaredError3 = squaredError.score(clusterBy3);

        double aic4 = aic.score(clusterBy4);
        double bic4 = bic.score(clusterBy4);
        double squaredError4 = squaredError.score(clusterBy4);

        System.out.println("KMeans Cluster where k = 1:");
        for(int i = 0; i < clusterBy1.length; i++){
            System.out.println(clusterBy1[i] + "\t");
        }
        System.out.println("The AIC score for k = 1 is: " + aic1);
        System.out.println("The BIC score for k = 1 is: " + bic1);
        System.out.println("Sum of squared errors for k = 1: " + squaredError1);

        System.out.println("KMeans Cluster where k = 2:");
        for(int i = 0; i < clusterBy2.length; i++){
            System.out.println(clusterBy2[i] + "\t");
        }
        System.out.println("The AIC score for k = 2 is: " + aic2);
        System.out.println("The BIC score for k = 2 is: " + bic2);
        System.out.println("Sum of squared errors for k = 2: " + squaredError2);

        System.out.println("KMeans Cluster where k = 3:");
        for(int i = 0; i < clusterBy3.length; i++){
            System.out.println(clusterBy3[i] + "\t");
        }
        System.out.println("The AIC score for k = 3 is: " + aic3);
        System.out.println("The BIC score for k = 3 is: " + bic3);
        System.out.println("Sum of squared errors for k = 3: " + squaredError3);

        System.out.println("KMeans Cluster where k = 4:");
        for(int i = 0; i < clusterBy4.length; i++){
            System.out.println(clusterBy4[i] + "\t");
        }
        System.out.println("The AIC score for k = 4 is: " + aic4);
        System.out.println("The BIC score for k = 4 is: " + bic4);
        System.out.println("Sum of squared errors for k = 4: " + squaredError4);

        System.out.println("The AIC score is: " + aic1 + "\t" + aic2 + "\t" + aic3 + "\t" + aic4);
        System.out.println("The BIC score is: " + bic1 + "\t" + bic2 + "\t" + bic3 + "\t" + bic4);
        System.out.println("Sum of squared errors: " + squaredError1 + "\t" + squaredError2 + "\t" + squaredError3 + "\t" + squaredError4);

    }
}
