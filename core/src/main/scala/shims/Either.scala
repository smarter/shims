package shims

trait EitherLike[\/[_, _]] {
  def left[A, B](a: A): A \/ B
  def right[A, B](b: B): A \/ B

  def map[A, B, C](e: A \/ B)(f: B => C): A \/ C = rightMap(e)(f)
  def flatMap[A, B, C](e: A \/ B)(f: B => (A \/ C)): A \/ C

  def isLeft[A, B](e: A \/ B): Boolean = fold(e)(left = { _ => true }, right = { _ => false })
  def isRight[A, B](e: A \/ B): Boolean = fold(e)(left = { _ => false }, right = { _ => true })

  def leftMap[A, B, C](e: A \/ B)(f: A => C): C \/ B
  def rightMap[A, B, C](e: A \/ B)(f: B => C): A \/ C
  def swap[A, B](e: A \/ B): B \/ A
  def fold[A, B, X](e: A \/ B)(left: A => X, right: B => X): X
}

object EitherLike {
  def apply[\/[_, _]](implicit E: EitherLike[\/]): EitherLike[\/] = E
}

// the following might be better in a shims.syntax package

// easy enough to alias these
object -\/ {

  def apply[\/[_, _], A, B](a: A)(implicit E: EitherLike[\/]): A \/ B = E.left(a)

  def unapply[\/[_, _], A, B](e: A \/ B)(implicit E: EitherLike[\/]): Option[A] =
    E.fold(e)(left = { a => Some(a) }, right = { _ => None })
}

// easy enough to alias these
object \/- {

  def apply[\/[_, _], A, B](b: B)(implicit E: EitherLike[\/]): A \/ B = E.right(b)

  def unapply[\/[_, _], A, B](e: A \/ B)(implicit E: EitherLike[\/]): Option[B] =
    E.fold(e)(left = { _ => None }, right = { b => Some(b) })
}