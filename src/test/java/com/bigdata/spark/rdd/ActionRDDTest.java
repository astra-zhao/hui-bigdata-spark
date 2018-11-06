package com.bigdata.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * <b><code>ActionRDDTest</code></b>
 * <p/>
 * Description:DEMO - Action RDD
 * <p/>
 * <b>Creation Time:</b> 2018/11/6 0:27.
 *
 * @author Hu Weihui
 */
public class ActionRDDTest {

    private static final String FILE_PATH = TransformationRDDTest.class.getClassLoader().getResource("demo.txt").toString();

    private SparkConf sparkConf;
    private JavaSparkContext sparkContext;

    @Before
    public void before() throws Exception {
        sparkConf = new SparkConf().setMaster("local[4]").setAppName("test");
        sparkContext = new JavaSparkContext(sparkConf);
    }

    @After
    public void after() throws Exception {
        sparkContext.close();
    }

    @Test
    public void testCollect() {
        JavaRDD<String> stringJavaRDD = sparkContext.textFile(FILE_PATH);
        List<String> collect = stringJavaRDD.collect();
        checkResult(collect);
    }

    @Test
    public void testCount() {
        JavaRDD<String> stringJavaRDD = sparkContext.textFile(FILE_PATH);
        long count = stringJavaRDD.count();
        System.out.println(count);
    }

    @Test
    public void testFirst() {
        JavaRDD<String> stringJavaRDD = sparkContext.textFile(FILE_PATH);
        String first = stringJavaRDD.first();
        System.out.println(first);
    }


    private void checkResult(List<?> collect){
        for (Object o : collect) {
            System.out.println(o.toString());
        }
    }

}
