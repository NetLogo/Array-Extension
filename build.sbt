import org.nlogo.build.{ ExtensionDocumentationPlugin, NetLogoExtension }

enablePlugins(NetLogoExtension)
enablePlugins(ExtensionDocumentationPlugin)

scalaVersion := "2.12.12"

name       := "array"
version    := "1.1.1"
isSnapshot := true

netLogoClassManager := "org.nlogo.extensions.array.ArrayExtension"
netLogoVersion      := "6.2.2"

javaSource in Compile := baseDirectory.value / "src" / "main"
scalaSource in Test   := baseDirectory.value / "src" / "test"
javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path", "-encoding", "us-ascii")
