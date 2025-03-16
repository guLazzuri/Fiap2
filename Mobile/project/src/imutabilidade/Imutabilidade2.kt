package imutabilidade

fun verificarIdade(idade: Int) {

    var fase: String

    if (idade < 9) {
        fase = "criança"
    }
    else if (idade >= 12 && idade < 18) {
        fase = "adolecente"
    }
    else if (idade >= 19 && idade < 59) {
        fase = "adulto"
    }
    else {
        fase = "idoso"
    }

    println(fase)
}

fun main() {
    verificarIdade(130)
}