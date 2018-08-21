package pfp

import java.time.Instant

import cats.Id

trait FrequencyCapping[F[_]] {

  def creativeAlreadySeen(deviceData: DeviceData, creativeId: CreativeId, since: Instant): F[Boolean]

}

object FrequencyCappingId extends FrequencyCapping[Id] {
  override def creativeAlreadySeen(deviceData: DeviceData, creativeId: CreativeId, since: Instant): Id[Boolean] =
    deviceData.creativesSeen.get(creativeId).exists(ts => ts.isAfter(since))
}
