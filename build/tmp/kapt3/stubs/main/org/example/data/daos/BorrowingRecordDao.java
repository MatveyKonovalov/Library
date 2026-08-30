package org.example.data.daos;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lorg/example/data/daos/BorrowingRecordDao;", "", "borrowingRecordMapper", "Lorg/example/data/mappers/BorrowingRecordMapper;", "(Lorg/example/data/mappers/BorrowingRecordMapper;)V", "borrowingRecords", "", "Lorg/example/domain/models/BorrowingRecord;", "getBorrowingRecords", "()Ljava/util/List;", "borrowingRecords$delegate", "Lkotlin/Lazy;", "addRecord", "", "record", "deleteRecord", "userId", "", "isbn", "getAllRecords", "", "loadBorrowingRecords", "saveBorrowingRecordsInFile", "Companion", "LibrarySystem"})
public final class BorrowingRecordDao {
    @org.jetbrains.annotations.NotNull()
    private final org.example.data.mappers.BorrowingRecordMapper borrowingRecordMapper = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILENAME = "borrowing_records.txt";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy borrowingRecords$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.example.data.daos.BorrowingRecordDao.Companion Companion = null;
    
    @javax.inject.Inject()
    public BorrowingRecordDao(@org.jetbrains.annotations.NotNull()
    org.example.data.mappers.BorrowingRecordMapper borrowingRecordMapper) {
        super();
    }
    
    private final java.util.List<org.example.domain.models.BorrowingRecord> getBorrowingRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.example.domain.models.BorrowingRecord deleteRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String isbn) {
        return null;
    }
    
    public final void addRecord(@org.jetbrains.annotations.NotNull()
    org.example.domain.models.BorrowingRecord record) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.example.domain.models.BorrowingRecord> getAllRecords() {
        return null;
    }
    
    public final void saveBorrowingRecordsInFile() {
    }
    
    private final java.util.List<org.example.domain.models.BorrowingRecord> loadBorrowingRecords() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/example/data/daos/BorrowingRecordDao$Companion;", "", "()V", "FILENAME", "", "LibrarySystem"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}