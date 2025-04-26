import org.nlogo.build.{ ExtensionDocumentationPlugin, NetLogoExtension }

enablePlugins(NetLogoExtension)
enablePlugins(ExtensionDocumentationPlugin)

name       := "array"
version    := "1.1.1"
isSnapshot := true

scalaVersion := "2.13.16"
Test / scalaSource  := baseDirectory.value / "src" / "test"

Compile / javaSource := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path", "-encoding", "us-ascii", "--release", "11")

netLogoClassManager := "org.nlogo.extensions.array.ArrayExtension"
netLogoVersion      := "7.0.0-internal1"
