package pfp

case class AdRequest(
  deviceId: String,
  countryCode: String
)

object AdRequest {
  import io.circe._
  import io.circe.generic.semiauto._

  implicit val adRequestDecoder: Decoder[AdRequest] = deriveDecoder[AdRequest]
  implicit val adRequestEncoder: Encoder[AdRequest] = deriveEncoder[AdRequest]

}
