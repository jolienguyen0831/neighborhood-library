package com.pluralsight;

import java.util.Scanner;

public class BookApplication {
    private static Scanner input = new Scanner(System.in);
    private static Book[] books = new Book[20];

    public static void main(String[] args) {
        loadBookInfo();
        boolean appRunning = true;
        while (appRunning) {
            System.out.print("""
                    \n1. Show available books
                    2. Show checked out books
                    3. Exit
                    Please enter your choice:""");
            byte choice = input.nextByte();
            input.nextLine();
            switch (choice) {
                case 1 -> showAvailableBooks();
                case 2 -> showCheckedOutBooks();
                case 3 -> appRunning = false;
            }
        }
    }

    private static void showCheckedOutBooks() {
        boolean case2Running = true;
        while (case2Running) {
            listCheckOutBooks();
            System.out.println("""
                    \nC: Check in a book
                    X: Exit to main menu
                    Please enter your choice:""");
            String checkInChoice = input.nextLine();
            switch (checkInChoice.toLowerCase()) {
                case "c" -> {
                    checkInBook();
                    case2Running = false;
                }
                case "x" -> case2Running = false;

            }
        }
    }

    private static void listCheckOutBooks() {
        System.out.println("\nChecked out books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %s |ISBN: %s |Title: %s |Name: %s%n", book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
            }
        }
    }

    private static void checkInBook() {
        System.out.print("Please enter book ID to check in: ");
        int inputID = input.nextInt();
        for (Book book : books) {
            if (inputID == book.getId()) {
                book.checkIn();
            }
        }
    }

    private static void showAvailableBooks() {
        boolean case1Running = true;
        while (case1Running) {
            listNotCheckedOutBooks();
            System.out.print("""
                    \n1. Select a book to check out
                    2. Exit to main menu
                    Please enter your choice:
                    """);
            byte checkOutChoice = input.nextByte();
            input.nextLine();
            switch (checkOutChoice) {
                case 1 -> {
                    checkOutBook();
                    case1Running = false;
                }
                case 2 -> case1Running = false;
            }
        }
    }

    private static void checkOutBook() {
        System.out.print("Please a book to check out: ");
        String bookName = input.nextLine();
        for (Book book : books) {
            if (bookName.equalsIgnoreCase(book.getTitle())) {
                System.out.print("Please enter your name:");
                String userName = input.nextLine();
                book.checkOut(userName);
                return;
            }
        }
    }

    private static void listNotCheckedOutBooks() {
        System.out.println("\nAvailable books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %s |ISBN: %s |Title: %s%n", book.getId(), book.getIsbn(), book.getTitle());
            }
        }
    }


    private static void loadBookInfo() {
        books[0] = new Book(1, "9780140449136", "The Odyssey", false, "");
        books[1] = new Book(2, "9780140449266", "The Iliad", true, "Alice");
        books[2] = new Book(3, "9780679783275", "Pride and Prejudice", false, "");
        books[3] = new Book(4, "9780743273565", "The Great Gatsby", true, "John");
        books[4] = new Book(5, "9780061120084", "To Kill a Mockingbird", false, "");
        books[5] = new Book(6, "9780451524935", "1984", true, "Emma");
        books[6] = new Book(7, "9780141439600", "Jane Eyre", false, "");
        books[7] = new Book(8, "9780307277671", "The Road", false, "");
        books[8] = new Book(9, "9781501128035", "It", true, "Michael");
        books[9] = new Book(10, "9780439139601", "Harry Potter and the Goblet of Fire", false, "");
        books[10] = new Book(11, "9780261103573", "The Lord of the Rings", true, "Sarah");
        books[11] = new Book(12, "9780553386790", "A Game of Thrones", false, "");
        books[12] = new Book(13, "9780060850524", "Brave New World", true, "David");
        books[13] = new Book(14, "9780140283334", "Of Mice and Men", false, "");
        books[14] = new Book(15, "9780141182803", "The Catcher in the Rye", true, "Chris");
        books[15] = new Book(16, "9780143039433", "Moby-Dick", false, "");
        books[16] = new Book(17, "9780140449181", "The Aeneid", false, "");
        books[17] = new Book(18, "9780679732761", "Beloved", true, "Sophia");
        books[18] = new Book(19, "9780385754729", "The Book Thief", false, "");
        books[19] = new Book(20, "9780590353427", "Harry Potter and the Sorcerer's Stone", true, "Liam");
    }
}


