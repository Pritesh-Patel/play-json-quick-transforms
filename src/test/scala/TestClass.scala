import play.api.libs.json._
import pritesh.json.JsonTransformers
import pritesh.json.QuickTransforms._

case class TestClass(image: String, data2: String, data3: String)

object TestClass {

  val readTransforms = Seq(
    JsonTransformers.copy( JsPath \ "image" \ "value", JsPath \ "image")
  )

  val writeTransforms = Seq(
    JsonTransformers.copy( JsPath \ "image", JsPath \ "image" \ "value")
  )

  implicit val format = Json.format[TestClass].withTransforms(readTransforms,writeTransforms)



}
