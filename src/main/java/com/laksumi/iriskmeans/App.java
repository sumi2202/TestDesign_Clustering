package com.laksumi.iriskmeans;
import net.sf.javaml.core.Dataset;

import java.util.logging.FileHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
//        Dataset data = new Dataset("iris.data");
        Dataset data = FileHandler.loadDataset(new File("iris.data"), 4, ",");
    }
}
