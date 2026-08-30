package org.example.data.services;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J<\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lorg/example/data/services/BookService;", "Lorg/example/domain/repositories/BookOperations;", "bookDao", "Lorg/example/data/daos/BookDao;", "(Lorg/example/data/daos/BookDao;)V", "addBook", "Lkotlin/Pair;", "", "Lorg/example/domain/models/Book;", "title", "", "author", "isbn", "genre", "amount", "", "findBookByAuthor", "", "findBookByIsbn", "findBookByTitle", "getAllBooks", "reduceBookAmount", "removeBook", "saveInFile", "", "LibrarySystem"})
public final class BookService implements org.example.domain.repositories.BookOperations {
    @org.jetbrains.annotations.NotNull()
    private final org.example.data.daos.BookDao bookDao = null;
    
    @javax.inject.Inject()
    public BookService(@org.jetbrains.annotations.NotNull()
    org.example.data.daos.BookDao bookDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlin.Pair<java.lang.Boolean, org.example.domain.models.Book> addBook(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn, @org.jetbrains.annotations.NotNull()
    java.lang.String genre) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlin.Pair<java.lang.Boolean, org.example.domain.models.Book> addBook(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, int amount) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.example.domain.models.Book removeBook(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.example.domain.models.Book findBookByIsbn(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlin.Pair<java.lang.Boolean, java.lang.Integer> reduceBookAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn, int amount) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.example.domain.models.Book> getAllBooks() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.example.domain.models.Book> findBookByAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String author) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.example.domain.models.Book> findBookByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @java.lang.Override()
    public void saveInFile() {
    }
}