package example.myapp.decor

data class Decoration(val rocks: String)

fun makeDecorations() {
    var decoration1 = Decoration("Granite")
    println(decoration1)

    var decor2 = Decoration("Slate")
    println(decor2)

    var decor3 = Decoration("Slate")
    println(decor3)

    println(decoration1.equals(decor2))
    println(decor3.equals(decor2))
}

fun main(){
    makeDecorations()
}