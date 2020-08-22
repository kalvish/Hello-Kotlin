package generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessing = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater : WaterSupply(true){
    fun filter(){
        needsProcessing = false
    }
}

//class Aquarium<T: Any?>(val waterSupply: T) //default is T: Any?
//class Aquarium<T: Any>(val waterSupply: T) // To remove nulls T: Any
// To specify exact type, add specific type like WaterSupply
class Aquarium<T: WaterSupply>(val waterSupply: T) {
    fun addWater(){
        check(!waterSupply.needsProcessing){
            "water supply needs processing first"
        }
        println("add water")
    }
}

fun genericsExample(){
    val aquarium = Aquarium<TapWater>(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

//    var aquarium2 = Aquarium("String")
//    println(aquarium2.waterSupply)

//    var aquarium3 = Aquarium(null)
//    println(aquarium3.waterSupply)

    var aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    println(aquarium4.addWater())
}

fun main(){
    genericsExample()
}