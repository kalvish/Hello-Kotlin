package generics

open class WaterSupply(var needsProcessing: Boolean)

//extension function of WaterSupply to check type of water supply. e.g. TapWater
inline fun <reified T: WaterSupply>WaterSupply.isTypeOf() = this is T

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
    fun addWater(cleaner: Cleaner<T>){

        if(waterSupply.needsProcessing){
            cleaner.clean(waterSupply)
        }
        check(!waterSupply.needsProcessing){
            "water supply needs processing first"
        }
        println("add water")
    }
}

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T: WaterSupply> addToItem(aquarium: Aquarium<T>) =  println("item added")

interface Cleaner<in T :WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>){
    println("acquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
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
    isWaterClean(aquarium5)
    println("has water supply of Tap water?: ${aquarium5.hasWaterSupplyOfType<TapWater>()}")
    println("Is water type is Tap water?:${aquarium5.waterSupply.isTypeOf<TapWater>()}")
}

fun main(){
    genericsExample()
}