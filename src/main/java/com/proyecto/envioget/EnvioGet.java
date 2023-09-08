/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.proyecto.envioget;
import java.net.URI;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
/**
 *
 * @author david
 */
public class EnvioGet {

    public static void main(String[] args) throws Exception {
        
        while (true) {
            try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
                
                HttpUriRequest httpget = RequestBuilder.get()
                        .setUri(new URI("https://uala-no-country.onrender.com"))
                        .build();

                CloseableHttpResponse response = httpclient.execute(httpget);
                try {
                    System.out.println(EntityUtils.toString(response.getEntity()));
                } finally {
                    response.close();
                }
            }
            Thread.sleep(14*60000);
        }
    }
}
