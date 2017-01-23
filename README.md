# Play Json Quick Transforms

A library to help quickly transform the default case class formats of play json.

To use add this to your build.sbt

```
resolvers += Resolver.bintrayRepo("pritesh-patel", "maven")

libraryDependencies ++= Seq(
  "priteshpatel" %% "play-json-quick-transforms" % "1.0.3"
)
```

This library adds functions to the existing Formats in play json.
It adds:

`withTransformers`
`withWriteTransformers`
`withReadTransformers`


Part of this library are some basic transformers which you can use with these methods.

To get the extra functions and transformers add these imports:

```
import pritesh.json.JsonTransformers
import pritesh.json.QuickTransforms._
```

A full example can be found in the tests with `TestClass`
