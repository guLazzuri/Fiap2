package imutabilidade

import javax.swing.text.StyledEditorKit.BoldAction

fun main() {
//    var nome = "Gustavo Lazzuri"
//    println(nome)
//    nome = "Gustavo"
//    println(nome)
//        // 1. Tipo Int
//        val idade: Int = 25
//        println("Idade: $idade")
//
//        // 2. Tipo Long
//        val populacaoMundo: Long = 7800000000L
//        println("População mundial: $populacaoMundo")
//
//        // 3. Tipo Double
//        val temperatura: Double = 36.6
//        println("Temperatura: $temperatura°C")
//
//        // 4. Tipo Float
//        val pi: Float = 3.14F
//        println("Valor de Pi: $pi")
//
//        // 5. Tipo Char
//        val letra: Char = 'K'
//        println("Letra: $letra")
//
//        // 6. Tipo String
//        val nome: String = "João"
//        println("Nome: $nome")
//
//        // 7. Tipo Boolean
//        val estaChovendo: Boolean = true
//        println("Está chovendo? $estaChovendo")
    ////////////////////////////////////////////////////////////

    fun soma(a: Int, b: Int) {
        var t = a + b
        println(t)
    }
    //soma(1,2)

    fun subtracao(a: Int, b: Int) {
        var t = a - b
        println(t)
    }
    subtracao(1, 2)

    fun divisao(a: Int, b: Int) {
        var t = a / b
        println(t)
    }
    divisao(4, 2)

    fun mutiplicacao(a: Int, b: Int) {
        var t = a * b
        println(t)
    }
    mutiplicacao(1, 2)

    fun restoDaDivisao(a: Int): Boolean {
        var t = a % 2
        println(t)
        if (t == 0) {
            return true
        }
        return false
    }
    restoDaDivisao(4)

    fun comparacaoDeDoisNumeros(x: Int, y: Int) {
        var VF: Boolean = false
        if (x >= y)
            VF = true
        println(VF)
    }
    comparacaoDeDoisNumeros(3, 2)

    fun ParouImpar(x: Int) {
        if (restoDaDivisao(x) == true)
            println("Par")
        else {
            println("Impar")
        }
    }
    ParouImpar(1)

    fun valor(x: Int) {
        println(x > 10 && x < 50);
    }
    valor(12)


    fun idade(x: Int) {
        var maior: Boolean = x >= 18
        println(maior)
    }
    idade(19)

    fun comDeString(x: String, y: String) {
        var stt: Boolean = x == y
        println(stt)
    }
    comDeString("gustavo", "lazzuri")


}




