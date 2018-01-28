package simplified.lib

case class StateV1(value: Int) {

  def flatMap(f: Int => StateV1): StateV1 = {
    val tempState = f(value)
    StateV1(tempState.value)
  }

  def map(f: Int => Int): StateV1 = StateV1(f(value))
}
