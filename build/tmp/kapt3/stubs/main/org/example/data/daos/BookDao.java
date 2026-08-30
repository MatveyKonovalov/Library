package org.example.data.daos;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J:\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u000e\u001a\u00020\u0005J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u001aH\u0002J\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u001eR\'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006 "}, d2 = {"Lorg/example/data/daos/BookDao;", "", "()V", "books", "", "", "Lorg/example/domain/models/Book;", "getBooks", "()Ljava/util/Map;", "books$delegate", "Lkotlin/Lazy;", "addBook", "Lkotlin/Pair;", "", "title", "author", "isbn", "genre", "amount", "", "findBookByAuthor", "", "findBookByIsbn", "findBookByTitle", "getAllBooks", "loadBooksFromFile", "", "reduceBookAmount", "removeBook", "saveBooksInFile", "", "Companion", "LibrarySystem"})
public final class BookDao {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILENAME = "books.txt";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy books$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.example.data.daos.BookDao.Companion Companion = null;
    
    @javax.inject.Inject()
    public BookDao() {
        super();
    }
    
    private final java.util.Map<java.lang.String, org.example.domain.models.Book> getBooks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, org.example.domain.models.Book> addBook(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, int amount) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.example.domain.models.Book removeBook(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.example.domain.models.Book findBookByIsbn(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.Integer> reduceBookAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn, int amount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.example.domain.models.Book> getAllBooks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.example.domain.models.Book> findBookByAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String author) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.example.domain.models.Book> findBookByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    public final void saveBooksInFile() {
    }
    
    private final java.util.Map<java.lang.String, org.example.domain.models.Book> loadBooksFromFile() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/example/data/daos/BookDao$Companion;", "", "()V", "FILENAME", "", "LibrarySystem"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}