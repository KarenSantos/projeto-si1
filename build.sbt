name := "projeto-si1"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
)     

val appDependencies = Seq(
  javaEbean
)

play.Project.playJavaSettings
