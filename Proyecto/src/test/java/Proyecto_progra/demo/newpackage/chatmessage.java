/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_progra.demo.newpackage;

/**
 *
 * @author DELL LATITUDE 5401
 */
import Proyecto_progra.demo.Test.User;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "ChatMessage")
@Data
public class ChatMessage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Corresponde a 'id' en MySQL 

    @Column(name = "chat_id", nullable = false)
    private Long chatId; // Corresponde a 'chat_id' en MySQL 
    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message; // Corresponde a 'message' en MySQL 

    @Column(name = "sender", nullable = false)
    @Enumerated(EnumType.STRING)
    private SenderType sender; // Corresponde a 'sender' en MySQL 
 
    
   // @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
   // private LocalDateTime timestamp; // Corresponde a 'timestamp' en MySQL 
 
     // Relación ManyToOne con User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    public enum SenderType {
        USER, BOT
    }
}
    

