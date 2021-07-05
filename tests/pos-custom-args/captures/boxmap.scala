type Top = Any retains *
class Cap extends Retains[*]

infix type ==> [A, B] = {*} (A => B)

type Box[+T <: Top] = {T} [K <: Top] => (T ==> K) => K

def box[T <: Top](x: T): Box[T] =
  [K <: Top] => (k: T ==> K) => k(x)

def map[A <: Top, B <: Top](b: Box[A])(f: A ==> B): Box[B] =
  b[Box[B]]((x: A) => box(f(x)))

def lazymap[A <: Top, B <: Top](b: Box[A])(f: A ==> B): {b, f} () => Box[B] =
  () => b[Box[B]]((x: A) => box(f(x)))

def test[A <: Top, B <: Top] =
  def lazymap[A <: Top, B <: Top](b: Box[A])(f: A ==> B) =
    () => b[Box[B]]((x: A) => box(f(x)))
  val x: (b: Box[A]) => {b} (f: A ==> B) => {b, f} () => Box[B] = lazymap[A, B]
  val x_red: (b: Box[A]) => ((f: A ==> B) => () => Box[B]) = lazymap[A, B]
  ()
