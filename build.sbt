name := course.value + "-" + assignment.value

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-deprecation")

// grading libraries
libraryDependencies += "junit" % "junit" % "4.10" % Test

// for funsets
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"

// include the common dir
commonSourcePackages += "common"
//依赖项，%%表示测试时需要，一般%； % "provided"表示此jar不打入最终的jar文件内
libraryDependencies += "com.alibaba" % "fastjson" % "1.2.4"
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.4.1" % "provided"

courseId := "bRPXgjY9EeW6RApRXdjJPw"

