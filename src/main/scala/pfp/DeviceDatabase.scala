package pfp

import java.time.Instant
import java.util.concurrent.{ConcurrentHashMap, ConcurrentMap}

import cats.Id

trait DeviceDatabase[F[_]] {

  def getDeviceHistory(deviceId: DeviceId): F[Option[DeviceHistory]]

}

object DeviceDatabaseMock extends DeviceDatabase[Id] {

  private val devices: ConcurrentMap[DeviceId, DeviceHistory] = new ConcurrentHashMap[DeviceId, DeviceHistory]()

  override def getDeviceHistory(deviceId: DeviceId): Id[Option[DeviceHistory]] = Option(devices.get(deviceId))

  def viewed(deviceId: DeviceId, creativeId: CreativeId, now: Instant): Unit =
    devices.compute(
      deviceId,
      (dId, x) =>
        Option(x)
          .map(
            old => old.copy(creativesSeen = old.creativesSeen + (creativeId -> now))
          )
          .getOrElse(DeviceHistory(dId))
    )
}
