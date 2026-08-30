package org.example.data.daos;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.example.data.mappers.BorrowingRecordMapper;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class BorrowingRecordDao_Factory implements Factory<BorrowingRecordDao> {
  private final Provider<BorrowingRecordMapper> borrowingRecordMapperProvider;

  public BorrowingRecordDao_Factory(Provider<BorrowingRecordMapper> borrowingRecordMapperProvider) {
    this.borrowingRecordMapperProvider = borrowingRecordMapperProvider;
  }

  @Override
  public BorrowingRecordDao get() {
    return newInstance(borrowingRecordMapperProvider.get());
  }

  public static BorrowingRecordDao_Factory create(
      Provider<BorrowingRecordMapper> borrowingRecordMapperProvider) {
    return new BorrowingRecordDao_Factory(borrowingRecordMapperProvider);
  }

  public static BorrowingRecordDao newInstance(BorrowingRecordMapper borrowingRecordMapper) {
    return new BorrowingRecordDao(borrowingRecordMapper);
  }
}
