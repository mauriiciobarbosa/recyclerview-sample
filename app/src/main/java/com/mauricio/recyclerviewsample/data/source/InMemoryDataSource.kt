package com.mauricio.recyclerviewsample.data.source

import com.mauricio.recyclerviewsample.data.Quote
import java.util.*

class InMemoryDataSource {

    private val NEW_QUOTES: MutableList<Quote> = mutableListOf(
            Quote(12, "Leonardo da Vinci", "Quem pensa pouco, erra muito"),
            Quote(13, "Fiodór Dostoiévski", "Busco um instante feliz que justifique minha existência."),
            Quote(14, "Voltaire", "Uma discussão prolongada significa que ambas as partes estão erradas")
    )

    private val QUOTES: MutableList<Quote> = mutableListOf(
            Quote(1, "Creativity", "A creative work is, above all, someone who, when faced with a problem, raises alternatives instead of limiting herself to known solutions."),
            Quote(2, "Charles Chaplin", "A persistência é o caminho do êxito"),
            Quote(3, "Georg Lichtenberg", "As pessoas que nunca têm tempo para nada são as que menos conseguem fazer as coisas"),
            Quote(4, "Carlos Drummond de Andrade", "Perder tempo para aprender coisas que não nos interessam priva-nos de descobrir coisas interessantes."),
            Quote(5, "George Harrison", "If you don’t know where you’re going, any road will take you there."),
            Quote(6, "Uncle Ben", "with great power comes great responsibility"),
            Quote(7, "Martin Fowler", "Anyone can write code that a computer can understand. Good programmers write code that humans can understand."),
            Quote(8, "Steve Jobs", "Lembrar que estarei morto em breve é a ferramenta mais importante que já encontrei para me ajudar a tomar grandes decisões. Porque quase tudo — expectativas externas, orgulho, medo de passar vergonha ou falhar — caem diante da morte, deixando apenas o que é apenas importante. Não há razão para não seguir o seu coração.\n" +
                    "\n" +
                    "Lembrar que você vai morrer é a melhor maneira que eu conheço para evitar a armadilha de pensar que você tem algo a perder. Você já está nu. Não há razão para não seguir seu coração."),
            Quote(9, "Willian George Ward", "O pessimista queixa-se do vento, o otimista espera que ele mude e o realista ajusta as velas."),
            Quote(10, "Robert Anthony", "A melhor maneira de fugir do seu problema é resolvê-lo"),
            Quote(11, "Benjamin Franklin", "As três coisas mais difíceis do mundo: guardar segredo, perdoar uma injúria e aproveitar o tempo.")
    )

    fun bulkQuotes() = QUOTES

    /**
     * Return a new quote from the pool or throws an exception if there's no more items in the pool.
     */
    fun getQuoteFromPool(): Quote {
        if (NEW_QUOTES.isEmpty()) throw IllegalStateException("There are no more quotes to add")
        return NEW_QUOTES.removeAt(0)
    }

    /**
     * Remove a quote from
     */
    fun addQuoteToPool(item: Quote) {
        NEW_QUOTES.add(item)
    }

    fun copyQuote(quote: Quote): Quote {
        val index = Random().nextInt(QUOTES.size)
        val id = QUOTES.size + NEW_QUOTES.size + 1
        return Quote(id, quote.author, QUOTES[index].description)
    }

}