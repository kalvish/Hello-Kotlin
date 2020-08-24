package other

fun main(){
//    labels()
    println(waterFilter(5))
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