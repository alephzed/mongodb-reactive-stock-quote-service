package com.davita.mongodbreactivestockquoteservice;

import com.davita.mongodbreactivestockquoteservice.client.StockQuoteClient;
import com.davita.mongodbreactivestockquoteservice.domain.Quote;
import com.davita.mongodbreactivestockquoteservice.repositories.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

//@Component
public class QuoteRunner implements CommandLineRunner {
    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository repository;

    public QuoteRunner(StockQuoteClient stockQuoteClient, QuoteRepository repository) {
        this.stockQuoteClient = stockQuoteClient;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream();
        Flux<Quote> quoteFlux = repository.findWithTailableCursorBy();
        quoteFlux.subscribe(quote ->
                System.out.println("*#*#*#*#*#*#*#*#*#*#**##* Id: " + quote.getId()));
    }
}
