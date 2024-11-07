/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto_progra.demo.newpackage.repository;

import Proyecto_progra.demo.Test.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DELL LATITUDE 5401
 */
public interface UserReposity extends JpaRepository<User, Long> {
    
}
