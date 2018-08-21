package pfp

trait DeviceDatabase[F[_]] {

  def getDeviceHistory(deviceId: DeviceId): F[Option[DeviceHistory]]

}
