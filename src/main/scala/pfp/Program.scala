package pfp

trait Program[F[_]] {

  def serveAd(adRequest: AdRequest): F[AdResponse]

}
