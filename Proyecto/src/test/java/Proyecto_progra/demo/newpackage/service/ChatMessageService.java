/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_progra.demo.newpackage.service;

import Proyecto_progra.demo.newpackage.ChatMessage;
import Proyecto_progra.demo.newpackage.repository.ChatMessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL LATITUDE 5401
 */
@Service
public class ChatMessageService {
     @Autowired
    private ChatMessageRepository chatMessageRepository;
@Transactional
    public ChatMessage saveMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }
    
}
