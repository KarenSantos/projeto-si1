name := "lab3-si1"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

val appDependencies = Seq(
  javaEbean
)

play.Project.playJavaSettings
