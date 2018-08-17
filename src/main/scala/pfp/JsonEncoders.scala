package pfp

import java.util.UUID

import io.circe.KeyEncoder
import cats.instances.uuid._
import cats.syntax.show._

trait JsonEncoders {

  implicit val uuidKeyEncoder: KeyEncoder[UUID] = new KeyEncoder[UUID] {
    override def apply(uuid: UUID): String = uuid.show
  }
}
