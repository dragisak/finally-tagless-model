package pfp

import java.util.concurrent.{ConcurrentHashMap, ConcurrentMap}

import cats.Id

trait CampaignDatabase[F[_]] {

  def findCampaigns(countryCode: String): F[List[Campaign]]

}

object CampaignDatabaseMock extends CampaignDatabase[Id] {

  private val campaigns: ConcurrentMap[String, List[Campaign]] = new ConcurrentHashMap[String, List[Campaign]]()

  override def findCampaigns(countryCode: String): Id[List[Campaign]] =
    Option(campaigns.get(countryCode)).getOrElse(Nil)

  def addCampaign(campaign: Campaign, countries: Set[String]): Unit = countries.foreach(
    country => campaigns.compute(country, (_, l) => Option(l).map(campaign :: _).getOrElse(List(campaign)))
  )
}
