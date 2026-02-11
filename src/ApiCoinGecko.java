import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiCoinGecko {

    public static void main(String[] args) throws IOException, InterruptedException {
        //CG-bAm8KbX6ip5eFzGeJNsPzVzK
        //https://api.coingecko.com/api/v3/simple/price?vs_currencies=usd&ids=bitcoin&x_cg_demo_api_key=CG-bAm8KbX6ip5eFzGeJNsPzVzK

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite em qual moeda deseja consultar a cotação: ");
        var moeda = leitura.nextLine();
        System.out.println("Digite qual criptomoeda deseja consultar: ");
        var cripto = leitura.nextLine();

        var url = "https://api.coingecko.com/api/v3/simple/price?vs_currencies=" + moeda + "&ids=" + cripto + "&x_cg_demo_api_key=CG-bAm8KbX6ip5eFzGeJNsPzVzK";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }

}
