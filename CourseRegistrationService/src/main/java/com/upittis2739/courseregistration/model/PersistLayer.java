/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import generated.Student;

/**
 *
 * @author riand_000
 */
public class PersistLayer {

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory setUp() throws Exception {
        final Properties persistenceProperties = new Properties();
        InputStream is = null;
        try {
            is = getClass().getClassLoader().getResourceAsStream(
                    "persistence.properties");
            persistenceProperties.load(is);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignored) {
                }
            }
        }

        entityManagerFactory = Persistence.createEntityManagerFactory(
                "generated", persistenceProperties);
        
        return entityManagerFactory;
    }
    
    public static void main(String[] args) throws Exception{
        PersistLayer persist = new PersistLayer();
        final EntityManager loadManager = persist.setUp().createEntityManager();
        final Student student = loadManager.find(Student.class, (long)1);
        loadManager.close();
    }
}
