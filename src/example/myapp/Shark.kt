package example.myapp

class Shark : FishAction, FishColor by GreyColor {
    override fun eat() {
        println("Hunt and eat fish")
    }
}