package pfp

case class Creative(
  id: CreativeId,
  payload: String
)

object Creative {
  import io.circe._
  import io.circe.generic.semiauto._

  implicit val creativeDecoder: Decoder[Creative] = deriveDecoder[Creative]
  implicit val creativeEncoder: Encoder[Creative] = deriveEncoder[Creative]
}
