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
        Dataset data = FileHandler.loadDataset(new File("iris.data"), 4, ",");
        Clusterer kmean3 = new KMeans(3);
        Clusterer kmean4 = new KMeans(4);

        Dataset[] clusterBy3 = kmean3.cluster(data);
        Dataset[] clusterBy4 = kmean4.cluster(data);

        ClusterEvaluation aic = new AICScore();
        ClusterEvaluation bic = new AICScore();
        ClusterEvaluation squaredError = new SumOfSquaredErrors();

        double aic3 = aic.score(clusterBy3);
        double bic3 = bic.score(clusterBy3);
        double squaredError3 = squaredError.score(clusterBy3);

        double aic4 = aic.score(clusterBy4);
        double bic4 = bic.score(clusterBy4);
        double squaredError4 = squaredError.score(clusterBy4);
    }
}
