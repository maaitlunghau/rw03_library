/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.fpt.mb;

import com.fpt.entity.LibraryCards;
import com.fpt.entity.Students;
import com.fpt.sb.LibraryCardsFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author hp
 */
@Named(value = "libraryManaged")
@SessionScoped
public class LibraryManaged implements Serializable {
   
    //properties
     //Call enterprise bean
    @EJB
    private LibraryCardsFacadeLocal libraryCardsFacade;
   
    //1.2 Data source and instance
    private LibraryCards card = new LibraryCards();
    private String studentNo;
    
    //getters/setters

    public LibraryCards getCard() {
        return card;
    }

    public void setCard(LibraryCards card) {
        this.card = card;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
    
    //3. Direct Database fetch
    public List<LibraryCards> getLibCards(){
      return libraryCardsFacade.getLibCard();
    }
   
    public List<Students> getStudents(){
      return libraryCardsFacade.getStudent();
    }
    //4.Methods
    //4.1 changeStatus()
    public void changeStatus(LibraryCards card){
      libraryCardsFacade.toggleStatus(card);
      showMessage("Status update!");
    }

    private void showMessage(String message) {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
    }
    
    //4.2 addLibCard()
    public String addLibCard(){
       //step1: Scan Student from DB
       Students matched = null;
       for(var student: getStudents()){
         if(student.getStdno().equals(studentNo)){
          matched = student;
          break;
         }
       }
       if(matched == null){
         showMessage("Student not found: " + studentNo);
         return null;
       }
       card.setStudentNo(matched);
       card.setStatus(true);
       libraryCardsFacade.addLibCard(card);

       //step2
       card = new LibraryCards();
       studentNo = "";

       return "index?faces-redirect=true";
    }
}
