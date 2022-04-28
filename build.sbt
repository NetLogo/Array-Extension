import org.nlogo.build.{ ExtensionDocumentationPlugin, NetLogoExtension }

enablePlugins(NetLogoExtension)
enablePlugins(ExtensionDocumentationPlugin)

name       := "array"
version    := "1.1.1"
isSnapshot := true

scalaVersion := "2.12.12"
scalaSource in Test  := baseDirectory.value / "src" / "test"

javaSource in Compile := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path", "-encoding", "us-ascii")

netLogoClassManager := "org.nlogo.extensions.array.ArrayExtension"
netLogoVersion      := "6.2.2-2f9fab6"
