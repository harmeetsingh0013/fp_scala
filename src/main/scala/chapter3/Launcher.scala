package chapter3

import chapter3._

object Launcher extends App {

    val list1 = List(1, 2, 3)
    val list2 = Cons(1, Cons(2, Cons(3, Nil)))

    println("\n\n\n ********************* Element Remove from Tail  ********************* \n\n\n")
    println(s" Tail List 1: ${List.tail(list1)}")
    println(s" Tail List 2: ${List.tail(list2)}")

    println("\n\n\n ********************* Set Head Element  ********************* \n\n\n")
    println(s" Set Head List 1: ${List.setHead(4, list1)}")
    println(s" Set Head List 2: ${List.setHead(Cons(4, Nil), list2)}")

    println("\n\n\n ********************* Drop elements from List  ********************* \n\n\n")
    println(s" Drop List 1: ${List.drop(list1, 2)}")
    println(s" Drop List 2: ${List.drop(list2, 2)}")

    // println("\n\n\n ********************* Dropwhile from list  ********************* \n\n\n")
    // println(s" Dropwhile List 1: ${List.dropWhile(list1, (x: Int) => x == 2)}")
    // println(s" Dropwhile List 2: ${List.dropWhile(list2, (x: Int) => (x % 2) == 0)}")

    println("\n\n\n ********************* Init  ********************* \n\n\n")
    println(s" Init List 1: ${List.init(list1)}")
    println(s" Init List 2: ${List.init(list2)}")

    println("\n\n\n")
}
