/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.sb;

import com.fpt.entity.LibraryCards;
import com.fpt.entity.Students;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author hp
 */
@Local
public interface LibraryCardsFacadeLocal {

    void create(LibraryCards libraryCards);

    void edit(LibraryCards libraryCards);

    void remove(LibraryCards libraryCards);

    LibraryCards find(Object id);

    List<LibraryCards> findAll();

    List<LibraryCards> findRange(int[] range);

    int count();
    //Bổ sung 4 method
    List<LibraryCards> getLibCard();
    List<Students> getStudent();
    void toggleStatus(LibraryCards card);
    void addLibCard(LibraryCards card);    
}
