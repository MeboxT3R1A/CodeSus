import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import kotlin.jvm.java

fun main(){
    val client: HttpClient = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://pokeapi.co/api/v2/pokemon-form/701"))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val dados = response.body()

    val gson = Gson()

    val buscarAPI = gson.fromJson(dados, Info::class.java)

    print(buscarAPI)
}