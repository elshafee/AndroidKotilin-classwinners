class AndroidDeveloper: Empolyee(), NDA,Contract {
    init {
        netSalary()
        workingHours()
        daysOff()
        benifits()
        bandNumberOne()
        bandNumberTwo()
        bandNumberThree()
        bandNumberFour()
    }
    override fun netSalary() {
        println("Your net salary is 20000 EGP")
    }

    override fun workingHours() {
        println("You have to work 40 hrs per week")
    }

    override fun daysOff() {
        println("You have 21 days off per year")
    }

    override fun benifits() {
        println("You can get 25% benfits every year on Your salary")
    }

    override fun bandNumberOne() {
        super<Contract>.bandNumberOne()
        println("Super class")
    }

    override fun donotShareContentWithOther() {
        println("Don't share the data with other")
    }

    override fun bandNumberTwo() {
        println("Band Two")
    }

    override fun bandNumberThree() {
        println("Band Three")
    }

    override fun bandNumberFour() {
        println("Band Four")
    }
}