import kotlin.system.exitProcess

class Atm {
    var name: String = ""
    private var pinCode: Int = 0
    var balance: Float = 0f
    var selectoperation: Int = 0
    var money: Int = 0


    fun enterYourCard() {
        print("Welcome to our Bank ATM\n")
        print("Please enter your name: ")
        name = readLine().toString()
        println("Welcome $name")
        print("Please enter Your PinCode: ")
        pinCode = Integer.valueOf(readLine())
        print("Please enter Your Balance: ")
        balance = readLine()!!.toFloat()
        selectOperation()
    }

    fun selectOperation() {
        print("Please select Your Operation to proceed\n")
        print(" 1 for Deposit \n 2 for Withdraw \n 3 for check the Balance\n 4 for Quit\n")
        selectoperation = Integer.valueOf(readLine())
        when (selectoperation) {
            1 -> deposit()
            2 -> withDraw()
            3 -> checkBalance()
            4 -> quit()
        }
    }

    fun checkBalance() {
        println("Your Balance is: $balance")
        doYouNeedAnyThing()
    }

    fun withDraw() {
        println("please enter the amount of money you need to withdraw: ")
        money = Integer.valueOf(readLine())
        if (balance >= money) {
            balance -= money
            print("Withdraw done Successfully")
            checkBalance()
        } else {
            print("Sorry, you don't have enough money")
        }
        doYouNeedAnyThing()
    }

    fun deposit() {
        print("please enter the amount of money you need to deposit: ")
        money = Integer.valueOf(readLine())
        balance += money
        println("Deposit done Successfully")
        checkBalance()
        doYouNeedAnyThing()

    }

    fun doYouNeedAnyThing() {
        println("Do you need any thing?")
        print(" 1 for Yes \n 2 for No\n")
        var selected: Int = Integer.valueOf(readLine())
        when (selected) {
            1 -> selectOperation()
            2 -> quit()
        }
    }

    fun quit() {
        print("thanks for using our ATM, see you again")
        exitProcess(0)
    }
}