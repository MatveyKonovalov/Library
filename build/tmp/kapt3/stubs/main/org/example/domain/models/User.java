package org.example.domain.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0017H&J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0003J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006 "}, d2 = {"Lorg/example/domain/models/User;", "", "name", "", "userId", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "_borrowedBooks", "", "borrowedBooks", "", "getBorrowedBooks", "()Ljava/util/List;", "value", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getName", "getUserId", "canBorrow", "", "getBorrowDays", "", "getFinePerDay", "", "getMaxBooks", "returnBook", "", "isbn", "takeBook", "toString", "LibrarySystem"})
public abstract class User {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String email;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> _borrowedBooks = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> borrowedBooks = null;
    
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    private final void setEmail(java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBorrowedBooks() {
        return null;
    }
    
    public abstract int getMaxBooks();
    
    public abstract int getBorrowDays();
    
    public abstract double getFinePerDay();
    
    public final boolean canBorrow() {
        return false;
    }
    
    public final boolean takeBook(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return false;
    }
    
    public final void returnBook(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}