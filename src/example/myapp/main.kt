import example.myapp.Aquarium
import example.myapp.TowerTank

fun main(){
    buildAquarium();
}

fun buildAquarium(){
    var aquarium = Aquarium()
    aquarium.printSize()
    aquarium.height = 60
    aquarium.printSize()
    var aquarium2 = Aquarium(width = 55, length = 123)
    aquarium2.printSize()
    aquarium2.height = 67
    aquarium2.printSize()
    aquarium2.volume = 4500
    aquarium2.printSize()

    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()

    var towerTank = TowerTank(diameter = 25, height = 40)
    towerTank.printSize()

}