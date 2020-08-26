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

    fishSample.apply {
        name = "newName"
    }
    println(fishSample.name)

    myWith("test"){
        println(capitalize())
    }

    val testLet = fishSample.name.capitalize().let { it+"haha" }.let { it.length }.let{it + 31}
    println(testLet)

    lateinit var oops:String
    myWith("oops", object :Function1<String, Unit>{
        override fun invoke(name: String) {
            oops = name.capitalize()
        }
    })
    println(oops)

    val runnable = object : Runnable {
        override fun run() {
            println("I'm a Runnable")
        }
    }

    JavaRun.runNow(runnable)
    JavaRun.runNow {
        println("Passing lambda as a Runnable")
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

data class Fish(var name:String)

val fishList  = listOf(Fish("Gold fish"), Fish("Dory"), Fish("Sail fish"), Fish("Salmon"))

inline fun myWith(name:String, block: String.() -> Unit){
    return name.block()
}