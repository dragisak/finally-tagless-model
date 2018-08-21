package pfp

import java.time.Instant

trait AdSelection[F[_]] {

  def selectAd(campaigns: List[Campaign], device: Option[DeviceData], now: Instant): F[Option[(Campaign, Creative)]]

}
