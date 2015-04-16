package com.thoughtworks.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    private List<String> books;
    private PrintStream printStream;
    private String titleOne;
    private String titleTwo;
    private String formattedTimeString;
    private DateTime time;
    private DateTimeFormatter dateTimeFormatter;

    @Before
    public void setupLibraryAndBookInstance() {
        books = new ArrayList<>();
        time = new DateTime();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        titleOne = "Book Title One";
        titleTwo = "Book Title Two";
        formattedTimeString = "FormattedTimeString";
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        books.add(titleOne);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(titleOne);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        // implement me
        Library library = new Library(books, printStream, null);

        library.listBooks();

        verify(printStream, times(0)).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        // implement me
        books.add(titleOne);
        books.add(titleTwo);

        Library library = new Library(books, printStream, null);

        library.listBooks();

        verify(printStream).println(titleOne);
        verify(printStream).println(titleTwo);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class

        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        when(dateTimeFormatter.print(time)).thenReturn(formattedTimeString);

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println(contains(formattedTimeString));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(dateTimeFormatter).print(time);
    }
}