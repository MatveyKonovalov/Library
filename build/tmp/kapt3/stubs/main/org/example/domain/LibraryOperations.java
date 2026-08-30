package org.example.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\u0007H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0007H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011H&J\u001a\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u00030\u0011H&J$\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010%\u001a\u00020\u000eH&\u00a8\u0006&"}, d2 = {"Lorg/example/domain/LibraryOperations;", "", "addBooks", "Lkotlin/Pair;", "", "Lorg/example/domain/models/Book;", "title", "", "author", "isbn", "genre", "amount", "", "borrowBook", "", "userId", "borrowingRecordsWithThisBook", "", "Lorg/example/domain/models/BorrowingRecord;", "findBookByAuthor", "findBookByIsbn", "findBookByTitle", "findUser", "Lorg/example/domain/models/User;", "getAllBooks", "getAllRecords", "getAllUsers", "getOverdueBooksWithFine", "", "reduceAmountBook", "registerUser", "name", "email", "userType", "Lorg/example/domain/models/UserType;", "removeAllBook", "returnBook", "saveInFile", "LibrarySystem"})
public abstract interface LibraryOperations {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.Pair<java.lang.Boolean, org.example.domain.models.Book> addBooks(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, int amount);
    
    public abstract void removeAllBook(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.example.domain.models.Book findBookByIsbn(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.Pair<java.lang.Boolean, java.lang.Integer> reduceAmountBook(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn, int amount);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.Book> getAllBooks();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.Book> findBookByAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String author);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.Book> findBookByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String registerUser(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    org.example.domain.models.UserType userType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.example.domain.models.User findUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.User> getAllUsers();
    
    public abstract void borrowBook(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    public abstract void returnBook(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<kotlin.Pair<org.example.domain.models.BorrowingRecord, java.lang.Double>> getOverdueBooksWithFine();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.BorrowingRecord> borrowingRecordsWithThisBook(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.BorrowingRecord> getAllRecords();
    
    public abstract void saveInFile();
}