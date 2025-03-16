package imutabilidade

class ValidarSenhaException(msg: String) : Exception(msg)

fun validarSenha(senha : String) : String {

    if(senha.length < 8){
        throw ValidarSenhaException("Senha deve conter no minimo 8 caracteres")
    }
    return "Senha Valida"
}

fun main(){
    try{
        val senha = "jjjj"
        val resultado = validarSenha(senha)
        println(resultado)

    } catch (e: ValidarSenhaException){
        println(e.message)
    }
    
}