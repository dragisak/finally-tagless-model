package pfp

import java.time.Instant

trait AdSelection[F[_]] {

  def selectAd(campaigns: List[Campaign], device: Option[DeviceHistory], now: Instant): F[Option[(Campaign, Creative)]]

}
