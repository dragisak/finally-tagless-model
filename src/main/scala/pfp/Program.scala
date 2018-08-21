package pfp

import java.time.Instant

import cats.{FlatMap, Id}
import cats.syntax.flatMap._
import cats.syntax.functor._

class Program[F[_]: DeviceDatabase: CampaignDatabase: AdSelection: FlatMap] {

  private val campaignDatabase = implicitly[CampaignDatabase[F]]
  private val deviceDatabase = implicitly[DeviceDatabase[F]]
  private val adSelection = implicitly[AdSelection[F]]

  def serveAd(adRequest: AdRequest, now: Instant = Instant.now()): F[Option[AdResponse]] =
    for {
      campaigns <- campaignDatabase.findCampaigns(adRequest.countryCode)
      deviceOpt <- deviceDatabase.getDeviceHistory(adRequest.deviceId)
      selected <- adSelection.selectAd(campaigns, deviceOpt, now)
    } yield
      selected.map {
        case (selectedCampaign, selectedCreative) => AdResponse(selectedCampaign, selectedCreative)
      }

}

object Program {

  private implicit val dumbCampaignDatabasse = CampaignDatabaseMock
  private implicit val dumnbDeviceDatabase = DeviceDatabaseMock
  private implicit val syncSelection = AdSelectionDumb

  val dumbProgram = new Program[Id]

}
