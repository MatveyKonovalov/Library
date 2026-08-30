package org.example.domain.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lorg/example/domain/models/UserType;", "", "maxBooks", "", "borrowDays", "finePerDay", "", "(Ljava/lang/String;IIID)V", "getBorrowDays", "()I", "getFinePerDay", "()D", "getMaxBooks", "GUEST", "STUDENT", "FACULTY", "LibrarySystem"})
public enum UserType {
    /*public static final*/ GUEST /* = new GUEST(0, 0, 0.0) */,
    /*public static final*/ STUDENT /* = new STUDENT(0, 0, 0.0) */,
    /*public static final*/ FACULTY /* = new FACULTY(0, 0, 0.0) */;
    private final int maxBooks = 0;
    private final int borrowDays = 0;
    private final double finePerDay = 0.0;
    
    UserType(int maxBooks, int borrowDays, double finePerDay) {
    }
    
    public final int getMaxBooks() {
        return 0;
    }
    
    public final int getBorrowDays() {
        return 0;
    }
    
    public final double getFinePerDay() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<org.example.domain.models.UserType> getEntries() {
        return null;
    }
}