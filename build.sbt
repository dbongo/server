name          := "server"

organization  := "com.evant"

version       := "0.1"

scalaVersion  := "2.11.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

val akkaV = "2.3.4"
val sprayV = "1.3.1"

libraryDependencies ++= {
  Seq(
    "org.mongodb"         %% "casbah"        % "2.7.2",
    "io.spray"            %% "spray-can"     % sprayV,
    "io.spray"            %% "spray-json"    % "1.2.6",
    "io.spray"            %% "spray-routing" % sprayV,
    "io.spray"            %% "spray-httpx"   % sprayV,
    "com.typesafe.akka"   %% "akka-actor"    % akkaV,
    "nl.grons"            %% "metrics-scala" % "3.2.0_a2.3",
    "org.json4s"          %% "json4s-native" % "3.2.9",
    "org.scalatest"       %% "scalatest"     % "2.2.0"  % "test",
    "org.specs2"          %% "specs2"        % "2.3.13" % "test",
    "io.spray"            %% "spray-testkit" % sprayV   % "test",
    "com.typesafe.akka"   %% "akka-testkit"  % akkaV    % "test"
  )
}

libraryDependencies += "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "0.4"  

resolvers += "spray repo" at "http://repo.spray.io"