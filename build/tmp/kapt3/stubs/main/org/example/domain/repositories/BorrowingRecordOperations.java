package org.example.domain.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\t\u001a\u00020\bH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH&J\u001a\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e0\u000bH&J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lorg/example/domain/repositories/BorrowingRecordOperations;", "", "addRecord", "", "record", "Lorg/example/domain/models/BorrowingRecord;", "deleteRecord", "userId", "", "isbn", "getAllRecordWithCurrentIsbn", "", "getAllRecords", "getOverdueBooksWithFine", "Lkotlin/Pair;", "", "getRecordByUserIdAndIsbn", "saveInFile", "LibrarySystem"})
public abstract interface BorrowingRecordOperations {
    
    @org.jetbrains.annotations.Nullable()
    public abstract org.example.domain.models.BorrowingRecord deleteRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    public abstract void addRecord(@org.jetbrains.annotations.NotNull()
    org.example.domain.models.BorrowingRecord record);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<kotlin.Pair<org.example.domain.models.BorrowingRecord, java.lang.Double>> getOverdueBooksWithFine();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.BorrowingRecord> getAllRecordWithCurrentIsbn(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    @org.jetbrains.annotations.Nullable()
    public abstract org.example.domain.models.BorrowingRecord getRecordByUserIdAndIsbn(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.BorrowingRecord> getAllRecords();
    
    public abstract void saveInFile();
}