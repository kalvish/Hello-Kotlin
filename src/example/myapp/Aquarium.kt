package example.myapp

open class Aquarium (open var width : Int = 20, open var height : Int = 40, open var length : Int = 100){

    open var volume : Int
        get() = width * height * length / 1000
        set(value) {
            height = ( value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open val water: Double
        get() = volume * 0.9

    init {
        println("aquarium initializing")
//        println(volume)
    }

    init {
        // 1 liter = 1000 cm^3
//        println("Volume: ${width * length * height / 1000} l")
    }

    fun printSize() {
        println(shape)

        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")

        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }
}