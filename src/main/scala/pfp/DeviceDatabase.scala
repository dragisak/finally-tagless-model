package pfp

import java.util.UUID

trait DeviceDatabase[F[_]] {

  def getDeviceData(deviceId: UUID): F[Option[DeviceData]]

}
