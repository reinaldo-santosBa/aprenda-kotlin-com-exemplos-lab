enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }
}

fun main() {
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Charlie")
    
    val conteudo1 = ConteudoEducacional("Kotlin Básico", 120)
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 180)
    val conteudo3 = ConteudoEducacional("Kotlin para Android", 240)
    
    val formacao1 = Formacao("Formação Kotlin Developer", Nivel.BASICO, listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Formação Android Developer", Nivel.INTERMEDIARIO, listOf(conteudo2, conteudo3))
    
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario2)
    formacao2.matricular(usuario3)
    
    println("Formação: ${formacao1.nome}, Nível: ${formacao1.nivel}")
    println("Conteúdos:")
    formacao1.conteudos.forEach { println("- ${it.nome} (${it.duracao} min)") }
    println("Inscritos:")
    formacao1.inscritos.forEach { println("- ${it.nome}") }
    
    println()
    
    println("Formação: ${formacao2.nome}, Nível: ${formacao2.nivel}")
    println("Conteúdos:")
    formacao2.conteudos.forEach { println("- ${it.nome} (${it.duracao} min)") }
    println("Inscritos:")
    formacao2.inscritos.forEach { println("- ${it.nome}") }
}
