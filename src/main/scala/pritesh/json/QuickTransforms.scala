package pritesh.json

import play.api.libs.json._

object QuickTransforms {
  implicit class FormatWithTransforms[A](formats:OFormat[A]){

    private def createCustomReader(readTransforms: Seq[Reads[_ <: JsValue]]) = Reads[A]{ js =>
      js.transform(JsonTransformers.all(readTransforms: _* ))
        .flatMap(formats.reads)
    }

    private def createCustomWriter(writeTransforms: Seq[Reads[_ <: JsValue]]) = Writes[A] { obj =>
      formats.writes(obj).transform(JsonTransformers.all(writeTransforms: _*)) match {
        case JsSuccess(js, _) => js
        case JsError(errors) => throw new RuntimeException(s"Json writing error: $errors")
      }
    }

    def withTransforms(readTransforms: Seq[Reads[_ <: JsValue]], writeTransforms: Seq[Reads[_ <: JsValue]]): Format[A] = {
      Format(
        createCustomReader(readTransforms),
        createCustomWriter(writeTransforms)
      )
    }

    def withReadTransforms(readTransforms: Seq[Reads[_ <: JsValue]]): Format[A] = {
      Format(
        createCustomReader(readTransforms),
        formats
      )
    }

    def withWriteTransforms(writeTransforms: Seq[Reads[_ <: JsValue]]): Format[A] = {
      Format(
        formats,
        createCustomWriter(writeTransforms)
      )
    }

  }

}
