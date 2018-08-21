package pfp

import java.time.Instant

import cats.FlatMap
import cats.syntax.flatMap._
import cats.syntax.functor._

abstract class Program[F[_]: DeviceDatabase: CampaignDatabase: AdSelection: FlatMap] {

  private val campaignDatabase = implicitly[CampaignDatabase[F]]
  private val deviceDatabase = implicitly[DeviceDatabase[F]]
  private val adSelection = implicitly[AdSelection[F]]

  def serveAd(adRequest: AdRequest, now: Instant): F[Option[AdResponse]] =
    for {
      campaigns <- campaignDatabase.findCampaigns(adRequest.countryCode)
      deviceOpt <- deviceDatabase.getDeviceHistory(adRequest.deviceId)
      selected <- adSelection.selectAd(campaigns, deviceOpt, now)
    } yield
      selected.map {
        case (selectedCampaign, selectedCreative) => AdResponse(selectedCampaign, selectedCreative)
      }

}
