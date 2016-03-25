enablePlugins(org.nlogo.build.NetLogoExtension)

javaSource in Compile <<= baseDirectory(_ / "src")

name := "array"

netLogoClassManager := "org.nlogo.extensions.array.ArrayExtension"

netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path",
  "-encoding", "us-ascii")

netLogoVersion := "6.0.0-M2"
