package br.com.service.controller;

import br.com.service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "{id}/{currency}")
    public Book findByBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        var port = environment.getProperty("local.server.port");

        return new Book(1L, "Nigel Poulton", "Dicker Deep Dive", new Date(),
                Double.valueOf(13.7), currency, port);
    }
}
