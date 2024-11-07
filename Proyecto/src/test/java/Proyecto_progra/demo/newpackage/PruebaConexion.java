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

/**
 *
 * @author DELL LATITUDE 5401
 */
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
            System.out.println("Conexion a la base de datos establecida con exito.");
        
               // Crear y guardar una instancia del Usuario
            User user = new User();
            user.setName("Carlos");
            user.setUsername("Charls");
            user.setChatId(1023L);
            user = userReposity.save(user); // Guarda el usuario en la base de datos

            System.out.println("Usuario guardado con ID: " + user.getId());

            // Crear y configurar una instancia de ChatMessage asociada al User
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setChatId(1010L); // Establece el ID del chat
            chatMessage.setMessage("Mensaje guardado."); // Contenido del mensaje
            chatMessage.setSender(ChatMessage.SenderType.USER); // Establece el remitente
            chatMessage.setUser(user); // Asigna el usuario al mensaje

            // Guardar el mensaje en la base de datos
            chatMessageService.saveMessage(chatMessage);
            System.out.println("Mensaje guardado en la base de datos.");
            
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al guardar el mensaje: " + e.getMessage());
            e.printStackTrace();
        }
    }
}




