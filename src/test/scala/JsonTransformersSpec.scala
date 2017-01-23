import org.scalatest.{FlatSpec, Matchers, WordSpec}
import play.api.libs.json._

/**
  * Created by Pritesh on 22/01/2017.
  */
class JsonTransformersSpec extends FlatSpec with Matchers {

  "Json transformer" should "read copy transform correctly" in {

    val fields = Seq(
      "image" -> JsObject(Seq("value" -> JsString("hi"))),
      "data2" -> JsString("hello"),
      "data3" -> JsString("holla")
    )

    println("Reading: " + JsObject(fields).toString())

    val readObj = Json.fromJson[TestClass](JsObject(fields)) match {
      case JsSuccess(obj,path) =>
        obj.image shouldBe "hi"
        obj.data2 shouldBe "hello"
        obj.data3 shouldBe "holla"

      case JsError(errors) => fail(s"Json read failed $errors")
    }


  }

  it should "write copy transform correctly" in {
    val json = Json.toJson(TestClass("hi", "hello", "holla"))
    println("Writing: " + json.toString())
    Json.fromJson[TestClass](json) match {
      case JsSuccess(obj,path) =>
        obj.image shouldBe "hi"
        obj.data2 shouldBe "hello"
        obj.data3 shouldBe "holla"

      case JsError(errors) => fail(s"Json read failed $errors")
    }

  }

}
