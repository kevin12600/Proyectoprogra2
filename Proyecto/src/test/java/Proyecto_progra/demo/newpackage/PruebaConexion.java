/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_progra.demo.newpackage;



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

    @Override
    public void run(String... args) {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Conexion a la base de datos establecida con exito.");
        
        // Crear un nuevo mensaje de chat
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setChatId(1010L); // Establece el ID del chat
            chatMessage.setMessage("Prueba de conexion exitosa."); // Contenido del mensaje
            chatMessage.setSender(ChatMessage.SenderType.USER); // Establecer el remitente

        // Guardar el mensaje usando el servicio
       // chatMessageService.saveMessage(chatMessage);
      // System.out.println("Mensaje guardado en la base de datos."); 
      
      
      try {
    chatMessageService.saveMessage(chatMessage);
    System.out.println("Mensaje guardado en la base de datos.");
} catch (Exception e) {
    System.err.println("Error al guardar el mensaje: " + e.getMessage());
    e.printStackTrace();
}

        
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        
    }
}



