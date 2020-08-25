package other

fun main(){
//    labels()
    println(waterFilter(5))

    val anotherlist = fishList.filter {
        it.name.contains("i",true)
    }
    println(anotherlist)
    val moreList = fishList.filter {
        it.name.contains("i",true)
    }.joinToString(","){
        it.name
    }
    println(moreList)

    val fishSample = Fish("splashy")
    with(fishSample.name){
        val temp = this.capitalize()
        println(fishSample.name)
        println(temp)
    }

}

fun labels() {
    outerLoop@ for (i in 1..10) {
        print("$i ")
        for (j in 1..10) {
            print("$j ")
            if (i > 4) break@outerLoop  // breaks to outer loop
        }
    }
}

val waterFilter = { dirty: Int -> dirty/2}

data class Fish(val name:String)

val fishList  = listOf(Fish("Gold fish"), Fish("Dory"), Fish("Sail fish"), Fish("Salmon"))
