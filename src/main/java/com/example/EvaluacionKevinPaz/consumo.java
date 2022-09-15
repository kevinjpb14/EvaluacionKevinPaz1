package com.example.EvaluacionKevinPaz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class consumo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String Category;
    public consumo (String Category){
        this.Category = Category;
    }

  
}


