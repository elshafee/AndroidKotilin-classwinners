open class Bird {
    open fun fly() {
        println("Bird is flying..")
        println("grade is ")
    }
}


class Duck : Bird() {
  override  fun fly(){
        print("Duck can't flying")
      println("graduation grade is")
    }
    fun swim() {
        println("Swimming")
    }
}