package org.example.data.services;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0016J\u001a\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00110\u000eH\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lorg/example/data/services/BorrowingRecordService;", "Lorg/example/domain/repositories/BorrowingRecordOperations;", "borrowingRecordDao", "Lorg/example/data/daos/BorrowingRecordDao;", "(Lorg/example/data/daos/BorrowingRecordDao;)V", "addRecord", "", "record", "Lorg/example/domain/models/BorrowingRecord;", "deleteRecord", "userId", "", "isbn", "getAllRecordWithCurrentIsbn", "", "getAllRecords", "getOverdueBooksWithFine", "Lkotlin/Pair;", "", "getRecordByUserIdAndIsbn", "saveInFile", "LibrarySystem"})
public final class BorrowingRecordService implements org.example.domain.repositories.BorrowingRecordOperations {
    @org.jetbrains.annotations.NotNull()
    private final org.example.data.daos.BorrowingRecordDao borrowingRecordDao = null;
    
    @javax.inject.Inject()
    public BorrowingRecordService(@org.jetbrains.annotations.NotNull()
    org.example.data.daos.BorrowingRecordDao borrowingRecordDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.example.domain.models.BorrowingRecord deleteRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    @java.lang.Override()
    public void addRecord(@org.jetbrains.annotations.NotNull()
    org.example.domain.models.BorrowingRecord record) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.example.domain.models.BorrowingRecord> getAllRecords() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<kotlin.Pair<org.example.domain.models.BorrowingRecord, java.lang.Double>> getOverdueBooksWithFine() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.example.domain.models.BorrowingRecord> getAllRecordWithCurrentIsbn(@org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.example.domain.models.BorrowingRecord getRecordByUserIdAndIsbn(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    @java.lang.Override()
    public void saveInFile() {
    }
}