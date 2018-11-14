/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libktvr17;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.Saveble;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class SaverToBase implements Saveble {
    private EntityManager em;

    public SaverToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibProPtvr16PU");
        this.em = emf.createEntityManager();
        
    }
    
    @Override
    public void saveHistories(List<History> histories) {
        int n = histories.size();
        for (int i=0;i<n;i++){
            if(histories.get(i).getId() == null){
            em.persist(histories.get(i));
            }else{
            em.merge(histories.get(i));   
                }
    }
    }
    

    @Override
    public void saveReaders(List<Reader> readers) {
        int n = readers.size();
        for (int i=0;i<n;i++){
            if(readers.get(i).getId() == null){
            em.persist(readers.get(i));
            }else{
            em.merge(readers.get(i));   
                }
    }
    }
    

    @Override
    public void saveBooks(List<Book> books) {
        int n = books.size();
        for (int i=0;i<n;i++){
            if(books.get(i).getId() == null){
            em.persist(books.get(i));
            }else{
            em.merge(books.get(i));   
                }
    }
    }

    @Override
    public List<History> loadHistories() {
       List<History> listHistory = new ArrayList<>();
       listHistory = em.createQuery("SELECT h FROM History h")
               .getResultList();
       return listHistory;
    }

    @Override
    public List<Reader> loadReaders() {
        List<Reader> listReader = new ArrayList<>();
        listReader = em.createQuery("SELECT r FROM Reader r")
               .getResultList();
        
        return listReader;
    }

    @Override
    public List<Book> loadBooks() {
        List<Book> listBook = new ArrayList<>();
        listBook = em.createQuery("SELECT b FROM Book b")
               .getResultList();
        return listBook;
        
    }
    
}
