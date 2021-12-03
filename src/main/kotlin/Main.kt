import kotlin.math.pow
import kotlin.math.sqrt

class Punto(var idPunto: String) {
    var x = 0
    var y = 0

    constructor(idPunto: String, x: Int, y: Int) : this(idPunto) {
        this.x = x
        this.y = y
    }

    override fun toString(): String = "$idPunto -> [$x, $y]"

    fun obtenerCoordenadas() = Pair(x, y)

    companion object {
        //Resta dos puntos y retorna el punto resultado.
        fun componenteDeVector(vector1: Punto, vector2: Punto): Punto =
            Punto(vector1.idPunto + vector2.idPunto, vector2.x - vector1.x, vector2.y - vector1.y)

        //Obtiene la diferencia entre dos puntos que recibira de entrada dos parametros(Punto)
        fun distancia(vector1: Punto, vector2: Punto): Double =
            sqrt(((vector2.x - vector1.x).toDouble().pow(2)) + ((vector2.y - vector1.y).toDouble().pow(2)))

        //Recibe un array de puntos y devuelve dependiendo de la posicion Y, Si es Norte o Sur.
        fun localizacionGeograficaNS(vector: Array<Punto>): Map<String, List<Punto>> =
            mapOf("Norte" to vector.filter { it.y >= 0 }, "Sur" to vector.filter { it.y < 0 })

    }
}

fun main() {
    //Programa que usara el metodo componente de vector e imprimira el valor calculado ->
    val puntoA = Punto("pA", 3, 2)
    val puntoB = Punto("pB", 1, 3)
    println(puntoA)
    println(puntoB)
    println("Componente AB: punto ${Punto.componenteDeVector(puntoA, puntoB)}")
    println()

    //Valores de tipo punto ->
    val punto1 = Punto("id1", 4, 2)
    val punto2 = Punto("id2", 8, 5)
    val punto3 = Punto("id3", 5, 3)
    val punto4 = Punto("id4", 3, -2)
    val punto5 = Punto("id5", 8, 7)
    val punto6 = Punto("id6", 6, 2)
    val punto7 = Punto("id7", 4, 9)
    val punto8 = Punto("id8", 2, -7)
    val punto9 = Punto("id9", 2, -4)

    //Array de de puntos ->
    val listaPuntos = arrayOf(punto1, punto2, punto3, punto4, punto5, punto6, punto7, punto8, punto9)
    repeat(200){ print("*")}
    println()
    //Programa que usa el metodo Localizacion Geografica ->
    println("Localización Geográfica NS:${Punto.localizacionGeograficaNS(listaPuntos)}")

    //Lista de todos los puntos contenidos en el array ->
    println("Lista de puntos:${listaPuntos.contentToString()}")
    repeat(200){ print("*")}
    println()
    println("Fin del programa, Hecho por Naim")
}