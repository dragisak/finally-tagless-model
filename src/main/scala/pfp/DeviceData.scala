package pfp

import java.time.Instant

case class DeviceData(
  id: DeviceId,
  creativesSeen: Map[CreativeId, Instant]
)

object DeviceData extends JsonEncoders {
  import io.circe._
  import io.circe.generic.semiauto._

  def apply(id: DeviceId): DeviceData = DeviceData(id, Map.empty)
  implicit val deviceDataDecoder: Decoder[DeviceData] = deriveDecoder[DeviceData]
  implicit val deviceDataEncoder: Encoder[DeviceData] = deriveEncoder[DeviceData]
}
