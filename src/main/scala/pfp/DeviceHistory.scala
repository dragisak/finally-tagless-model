package pfp

import java.time.Instant

case class DeviceHistory(
  id: DeviceId,
  creativesSeen: Map[CreativeId, Instant]
)

object DeviceHistory extends JsonEncoders {
  import io.circe._
  import io.circe.generic.semiauto._

  def apply(id: DeviceId): DeviceHistory = DeviceHistory(id, Map.empty)

  implicit val deviceDataDecoder: Decoder[DeviceHistory] = deriveDecoder[DeviceHistory]
  implicit val deviceDataEncoder: Encoder[DeviceHistory] = deriveEncoder[DeviceHistory]
}
