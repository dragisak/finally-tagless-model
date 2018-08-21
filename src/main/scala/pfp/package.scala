import java.util.UUID

import cats.{~>, Id}
import cats.arrow.FunctionK

import scala.concurrent.Future

package object pfp {

  type ImpressionId = UUID
  type CreativeId = UUID
  type CampaignId = UUID
  type DeviceId = String

  object ImpressionId {
    def apply(): ImpressionId = UUID.randomUUID()
  }

  implicit val toF: Id ~> Future = λ[FunctionK[Id, Future]](Future.successful(_))

}
