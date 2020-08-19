package example.myapp

abstract class AquariumFish : Habitat {
    abstract val color : String

    open fun print(){
        print("Color $color\n")
    }

    override fun transition() = println("not transiting")
}