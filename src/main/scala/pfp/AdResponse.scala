package pfp

import java.util.UUID

case class AdResponse(
  impressionId: UUID,
  campaignId: UUID,
  creative: Creative
)

object AdResponse {
  import io.circe._
  import io.circe.generic.semiauto._

  implicit val adResponseDecoder: Decoder[AdResponse] = deriveDecoder[AdResponse]
  implicit val adResponseEncoder: Encoder[AdResponse] = deriveEncoder[AdResponse]
}
