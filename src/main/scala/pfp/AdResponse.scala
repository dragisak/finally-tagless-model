package pfp

case class AdResponse(
  impressionId: ImpressionId,
  campaignId: CampaignId,
  creative: Creative
)

object AdResponse {
  import io.circe._
  import io.circe.generic.semiauto._

  def apply(campaign: Campaign, creative: Creative): AdResponse = AdResponse(ImpressionId(), campaign.id, creative)

  implicit val adResponseDecoder: Decoder[AdResponse] = deriveDecoder[AdResponse]
  implicit val adResponseEncoder: Encoder[AdResponse] = deriveEncoder[AdResponse]
}
