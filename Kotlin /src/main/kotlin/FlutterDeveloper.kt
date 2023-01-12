class FlutterDeveloper : Empolyee(), Contract, NDA {
    override fun netSalary() {
        println("Your net salary is 15000 EGP")
    }

    override fun workingHours() {
        println("You have to work 30 hrs per week")
    }

    override fun daysOff() {
        println("You have 25 days off per year")
    }

    override fun benifits() {
        println("You can get 15% benfits every year on Your salary")
    }

    override fun bandNumberOne() {
        super<NDA>.bandNumberOne()
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