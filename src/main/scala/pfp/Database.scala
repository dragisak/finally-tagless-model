package pfp

trait Database[F[_]] {

  def findCampaigns(countryCode: String): F[List[Campaign]]

}
