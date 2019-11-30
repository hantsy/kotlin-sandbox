package generics;

open class WaterSupply(var needProcessed: Boolean = false)
class TapWater : WaterSupply(true) {
    fun addChemicalCleaner()= apply {
        needProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() = apply {
        needProcessed = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (!waterSupply.needProcessed) {
            cleaner.clean(waterSupply)
        }
        println("add water from $waterSupply")
    }

    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaner()
    }

}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>){
    println("aquarium water is clean : ${aquarium.waterSupply.needProcessed}")
}

fun genericExamples() {
    val cleaner = TapWaterCleaner()
    val a1 = Aquarium<TapWater>(TapWater())
//    isWaterClean(a1)
//    a1.addWater(cleaner)
//    isWaterClean(a1)
    a1.hasWaterSupplyOfType<TapWater>()
   // a1.waterSupply.isTypeOf<TapWater>()
}

fun main(args: Array<String>) {
    genericExamples()
}