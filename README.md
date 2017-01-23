# play-json-quick-transforms

A library to help quickly transform the default case class formats of play json

This library adds functions to the existing Formats in play json.
It adds:

`withTransformers`
`withWriteTransformers`
`withReadTransformers`


It also gives some default transformers which you can use with these methods.

To get the extra functions add this to your case class

`import QuickTransforms._`

A full example can be found in the tests with `TestClass`
