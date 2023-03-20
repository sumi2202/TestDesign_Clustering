package com.laksumi.iriskmeans;

import java.io.File;
import java.io.IOException;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.tools.data.FileHandler;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
//        Dataset data = new Dataset("iris.data");
        Dataset data = FileHandler.loadDataset(new File("iris.data"), 4, ",");
        Clusterer km = new KMeans();
    }
}
