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
    private Library library;

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

    private void createLibraryAndCallListBooks() {
        library = new Library(books, printStream, null);

        library.listBooks();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        books.add(titleOne);

        createLibraryAndCallListBooks();
        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(titleOne);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        // implement me
        createLibraryAndCallListBooks();

        verify(printStream, times(0)).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        // implement me
        books.add(titleOne);
        books.add(titleTwo);

        createLibraryAndCallListBooks();

        verify(printStream).println(titleOne);
        verify(printStream).println(titleTwo);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    private void createLibraryWithDateFormatterAndCallWelcome() {
        library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
    }
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        createLibraryWithDateFormatterAndCallWelcome();

        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        when(dateTimeFormatter.print(time)).thenReturn(formattedTimeString);

        createLibraryWithDateFormatterAndCallWelcome();

        verify(printStream).println(contains(formattedTimeString));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {
        createLibraryWithDateFormatterAndCallWelcome();
        verify(dateTimeFormatter).print(time);
    }
}