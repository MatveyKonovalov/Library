package org.example.domain.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lorg/example/domain/models/Student;", "Lorg/example/domain/models/User;", "name", "", "userId", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBorrowDays", "", "getFinePerDay", "", "getMaxBooks", "CommonInfo", "LibrarySystem"})
public final class Student extends org.example.domain.models.User {
    private static final int MAX_BOOKS = 0;
    private static final int BORROW_DAYS = 0;
    private static final double FINE_PER_DAY = 0.0;
    @org.jetbrains.annotations.NotNull()
    public static final org.example.domain.models.Student.CommonInfo CommonInfo = null;
    
    public Student(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        super(null, null, null);
    }
    
    @java.lang.Override()
    public int getMaxBooks() {
        return 0;
    }
    
    @java.lang.Override()
    public int getBorrowDays() {
        return 0;
    }
    
    @java.lang.Override()
    public double getFinePerDay() {
        return 0.0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lorg/example/domain/models/Student$CommonInfo;", "", "()V", "BORROW_DAYS", "", "FINE_PER_DAY", "", "MAX_BOOKS", "LibrarySystem"})
    public static final class CommonInfo {
        
        private CommonInfo() {
            super();
        }
    }
}