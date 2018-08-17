package pfp

import java.util.UUID

case class Creative(
  id: UUID,
  payload: String
)

object Creative {
  import io.circe._
  import io.circe.generic.semiauto._

  implicit val creativeDecoder: Decoder[Creative] = deriveDecoder[Creative]
  implicit val creativeEncoder: Encoder[Creative] = deriveEncoder[Creative]
}
