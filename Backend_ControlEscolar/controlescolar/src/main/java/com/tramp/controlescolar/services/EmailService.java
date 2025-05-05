package com.tramp.controlescolar.services;
import com.sendgrid.*;
import java.io.IOException;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    //Cargamos la api key desde application.properties 
    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;
    
    //Recibe los datos del correo
    public String enviarCorreo(String destinatario, String asunto, String contenido) throws IOException{
        // Se crea el objeto Email con la dirección de correo del remitente
        Email from = new Email("agaviocarlos@gmail.com");
        // Se crea el objeto Email con la dirección de correo del destinatario
        Email to = new Email(destinatario);

        //Contenido del correo
        Content content = new Content("text/plain", contenido);

        //Crear el correo
        Mail mail = new Mail(from, asunto, to, content);

        //Configurar SendGrid con la api key
        SendGrid sg = new SendGrid(sendGridApiKey);

        //Crear la solicitud HTTP

        Request request = new Request();
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            // Retrorna el código de respuesta HTTP
            return "Código de respuesta: " + response.getStatusCode();
        } catch (IOException ex) {
            throw new IOException("Error al enviar el correo: " + ex.getMessage());
        }
    }
}
