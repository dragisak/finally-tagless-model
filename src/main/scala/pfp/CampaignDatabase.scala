package pfp

trait CampaignDatabase[F[_]] {

  def findCampaigns(countryCode: String): F[List[Campaign]]

}
