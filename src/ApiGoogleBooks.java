import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiGoogleBooks {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o titulo do livo que deseja consultar: ");
        var titulo = leitura.nextLine();

        String url = "https://www.googleapis.com/books/v1/volumes?q=" + titulo + "&key=AIzaSyDwubyygJHkXK33tYfGSQxxQwRjpRXQlCw";

        //chave api AIzaSyDwubyygJHkXK33tYfGSQxxQwRjpRXQlCw

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


    }
}
