import org.nlogo.build.{ ExtensionDocumentationPlugin, NetLogoExtension }

enablePlugins(NetLogoExtension)
enablePlugins(ExtensionDocumentationPlugin)

name       := "array"
version    := "1.2.0"
isSnapshot := true

scalaVersion := "3.7.0"
Test / scalaSource  := baseDirectory.value / "src" / "test"

Compile / javaSource := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-deprecation", "-encoding", "us-ascii", "--release", "11")

netLogoClassManager := "org.nlogo.extensions.array.ArrayExtension"
netLogoVersion      := "7.0.0-beta2-7e8f7a4"
