package shims

import scala.reflect.runtime.universe._

import shims.cats._

import _root_.cats.{Applicative => CApplicative, FlatMap => CFlatMap, Functor => CFunctor, Monad => CMonad, Traverse => CTraverse}
import _root_.cats.std.option._
import _root_.cats.std.string._

import org.specs2.mutable._

object CatsSpecs extends Specification {

  "functors" >> {
    "forward" >> {
      Functor[Option]

      ok
    }

    "backward" >> {
      import shims.util._

      implicit val ev: Functor[List] = null

      def foo[Tag: TypeTag](stuff: Functor.Aux[Option, Tag]) = println(typeTag[Tag])

      // foo(traverse1)

      CFunctor[List](rfunctor1)

      ok
    }

    "remain unambiguous" >> {
      CFunctor[Option]

      ok
    }
  }
}