def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit = {
  while(testCondition) {
    codeBlock
  }
}

var i = 0;
whilst(i < 5) {
  println(i)
  i += 1
}

class Goku
class Gohan extends Goku

def myPrint(implicit goku: Goku) = println(goku)

implicit val gohan = new Gohan
//myPrint

implicit val goku = new Goku
myPrint