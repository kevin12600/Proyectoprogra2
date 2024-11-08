/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_progra.demo.newpackage;

import Proyecto_progra.demo.Test.User;
import Proyecto_progra.demo.newpackage.repository.UserReposity;
import Proyecto_progra.demo.newpackage.service.ChatMessageService;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PruebaConexion implements CommandLineRunner {
    
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ChatMessageService chatMessageService;
    @Autowired
    private UserReposity userReposity;

    @Override
    public void run(String... args) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Conexión a la base de datos establecida con éxito.");
        
            // Crear y guardar los usuarios
            User user1 = new User();
            user1.setName("Daniela");
            user1.setUsername("Dani");
            user1.setChatId(1025L);
            user1 = userReposity.save(user1); 
            System.out.println("Usuario 1 guardado con ID: " + user1.getId());

            User user2 = new User();
            user2.setName("Juanito");
            user2.setUsername("Juan");
            user2.setChatId(1026L);
            user2 = userReposity.save(user2); 
            System.out.println("Usuario 2 guardado con ID: " + user2.getId());

            User user3 = new User();
            user3.setName("Mariela");
            user3.setUsername("Mari");
            user3.setChatId(1027L);
            user3 = userReposity.save(user3); 
            System.out.println("Usuario 3 guardado con ID: " + user3.getId());

            //  Configurar los mensajes para cada usuario
            ChatMessage chatMessage1 = new ChatMessage();
            chatMessage1.setChatId(1025L); 
            chatMessage1.setMessage("Mensaje para Daniela");
            chatMessage1.setSender(ChatMessage.SenderType.USER); 
            chatMessage1.setUser(user1); 

            ChatMessage chatMessage2 = new ChatMessage();
            chatMessage2.setChatId(1026L); 
            chatMessage2.setMessage("Mensaje para Juanito"); 
            chatMessage2.setSender(ChatMessage.SenderType.USER); 
            chatMessage2.setUser(user2); 

            ChatMessage chatMessage3 = new ChatMessage();
            chatMessage3.setChatId(1027L); 
            chatMessage3.setMessage("Mensaje para Mariela"); 
            chatMessage3.setSender(ChatMessage.SenderType.USER); 
            chatMessage3.setUser(user3); 

            // Guardar los mensajes en la base de datos
            chatMessageService.saveMessage(chatMessage1);
            chatMessageService.saveMessage(chatMessage2);
            chatMessageService.saveMessage(chatMessage3);

            System.out.println("Mensajes guardados en la base de datos.");
            
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al guardar el mensaje: " + e.getMessage());
            e.printStackTrace();
        }
    }
}