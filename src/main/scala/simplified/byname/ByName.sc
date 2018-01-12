def method1(arg: Int): String = {
  s"The method1 passed value is $arg"
}

def method2(arg1: Int, arg2: Int): String = {
  s"The method2 passed value sum is ${arg1 + arg2}"
}

def method3(arg1: Int, arg2: Int, arg3: Int): String = {
  s"The method3 passed value sum is ${arg1 + arg2 + arg3}"
}

def method4(string: String): String = {
  s"String length is ${ string.length }"
}

def hofArg1(f: Int => String) = {
  println(f(1))
}

def hofArg2(f: (Int, Int) => String) = {
  println(f(1, 1))
}

def hofArg3(f: (Int, Int, Int) => String) = {
  println(f(1, 1, 1))
}

// higher order functions
hofArg1(method1)
hofArg2(method2)
hofArg3(method3)
// hofArg1(method4) not compiles because function type nu match

// pass by name
def byNameArg(methodValue: => String) = {
  println(methodValue)
}

byNameArg(method1(1))
byNameArg(method2(1, 1))
byNameArg(method3(1, 1, 1))
byNameArg(method4("Hello Name"))