package pfp

trait DeviceDatabase[F[_]] {

  def getDeviceData(deviceId: DeviceId): F[Option[DeviceData]]

}
