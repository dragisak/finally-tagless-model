package pfp

import java.time.Instant

import cats.Id

trait AdSelection[F[_]] {

  def selectAd(campaigns: List[Campaign], device: Option[DeviceHistory], now: Instant): F[Option[(Campaign, Creative)]]

}

object AdSelectionDumb extends AdSelection[Id] {

  override def selectAd(
    campaigns: List[Campaign],
    device: Option[DeviceHistory],
    now: Instant
  ): Id[Option[(Campaign, Creative)]] = campaigns.headOption.map(c => (c, c.creatives.head))

}
