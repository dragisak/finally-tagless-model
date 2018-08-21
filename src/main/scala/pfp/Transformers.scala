package pfp

import cats.{~>, Id}
import cats.arrow.FunctionK
import monix.eval.Task

import scala.concurrent.Future

object Transformers {

  implicit val toF: Id ~> Future = λ[FunctionK[Id, Future]](Future.successful(_))
  implicit val toT: Id ~> Task = λ[FunctionK[Id, Task]](Task.now(_))
}
