package pfp

import java.util.UUID

import cats.data.NonEmptyList

case class Campaign(
  id: UUID,
  countryCode: String,
  creatives: NonEmptyList[Creative]
)

object Campaign {
  import io.circe._
  import io.circe.generic.semiauto._

  implicit val campaignDecoder: Decoder[Campaign] = deriveDecoder[Campaign]
  implicit val campaignEncoder: Encoder[Campaign] = deriveEncoder[Campaign]
}
