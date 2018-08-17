package pfp

import java.time.Instant
import java.util.UUID

case class DeviceData(
  id: UUID,
  creativesSeen: Map[UUID, Instant]
)

object DeviceData extends JsonEncoders {
  import io.circe._
  import io.circe.generic.semiauto._
  import io.circe.java8.time._

  implicit val deviceDataDecoder: Decoder[DeviceData] = deriveDecoder[DeviceData]
  implicit val deviceDataEncoder: Encoder[DeviceData] = deriveEncoder[DeviceData]
}
