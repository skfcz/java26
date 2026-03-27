package de.groygroy.linuxmagazin.java26;

import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTP3 {

    static void main() throws  Exception {

        var client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        var request = HttpRequest.newBuilder(URI.create("http://www.linuxmagazin.de"))
                .version(HttpClient.Version.HTTP_3).HEAD().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status :" + response.statusCode());
        System.out.println("Http Version : "+response.version());



    }
}
