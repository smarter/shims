package shims.util

// I have to duplicate this here because I don't want dependencies

trait <:!<[A, B]

object <:!< {
  implicit def nsub[A, B]: A <:!< B = null
  implicit def nsubAmb1[A, B >: A]: A <:!< B = null
  implicit def nsubAmb2[A, B >: A]: A <:!< B = null
}

trait =/=[A, B]

object =/= {
  implicit def neq[A, B]: A =/= B = null
  implicit def neqAmb1[A]: A =/= A = null
  implicit def neqAmb2[A]: A =/= A = null
}