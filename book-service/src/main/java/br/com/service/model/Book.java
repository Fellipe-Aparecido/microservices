package br.com.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String author;
    private String title;
    private Date lauchDate;
    private Double price;
    private String currency;
    private String environment;

}
