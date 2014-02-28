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

libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"

play.Project.playJavaSettings
