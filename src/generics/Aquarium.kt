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
class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>){
        check(!waterSupply.needsProcessing){
            "water supply needs processing first"
        }
        if(waterSupply.needsProcessing){
            cleaner.clean(waterSupply)
        }
        println("add water")
    }
}

fun addToItem(aquarium: Aquarium<WaterSupply>) =  println("item added")

interface Cleaner<in T :WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun genericsExample(){
    val aquarium = Aquarium<TapWater>(TapWater())
    addToItem(aquarium)
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

//    var aquarium2 = Aquarium("String")
//    println(aquarium2.waterSupply)

//    var aquarium3 = Aquarium(null)
//    println(aquarium3.waterSupply)

//    var aquarium4 = Aquarium(LakeWater())
//    aquarium4.waterSupply.filter()
//    println(aquarium4.addWater())
    val aquarium5 = Aquarium(TapWater())
    var cleaner = TapWaterCleaner()
    aquarium5.addWater(cleaner)
}

fun main(){
    genericsExample()
}