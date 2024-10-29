/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_progra.demo.newpackage.repository;


import Proyecto_progra.demo.newpackage.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL LATITUDE 5401
 */
@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    
}
