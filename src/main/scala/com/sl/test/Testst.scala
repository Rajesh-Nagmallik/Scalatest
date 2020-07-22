package com.sl.test
import scala.math.random

import org.apache.spark.sql.SparkSession

object Testst {
  def main(args: Array[String]) {
System.setProperty("hadoop.home.dir", "C:\\winutils")

    val spark = SparkSession
      .builder
      .appName("Wordcount").master("local")
      .getOrCreate()

    val data = spark.read.textFile("E:\\Hadoop\\test.txt").rdd

    val result = data.flatMap { line => {
      line.split(" ")


    } }
      .map { words => (words, 1)

      }
      .reduceByKey(_+_)


    println(result)

    spark.stop
  }
}
