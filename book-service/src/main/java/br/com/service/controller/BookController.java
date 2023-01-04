package br.com.service.controller;

import br.com.service.model.Book;
import br.com.service.proxy.CambioProxy;
import br.com.service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping(value = "{id}/{currency}")
    public Book findByBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){

        var book =  bookRepository.getById(id);
        if(book == null) throw new RuntimeException("Book not Found");

        var cambio = proxy.getCambio(book.getPrice(), "USD",currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment("Book port: " + port +
                " Cambio Port " + cambio.getEnvironment());
        book.setPrice(cambio.getConvertedValue());
        return book;
    }
}
