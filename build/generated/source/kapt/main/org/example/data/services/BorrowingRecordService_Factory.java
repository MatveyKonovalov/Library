package org.example.data.services;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.example.data.daos.BorrowingRecordDao;

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
public final class BorrowingRecordService_Factory implements Factory<BorrowingRecordService> {
  private final Provider<BorrowingRecordDao> borrowingRecordDaoProvider;

  public BorrowingRecordService_Factory(Provider<BorrowingRecordDao> borrowingRecordDaoProvider) {
    this.borrowingRecordDaoProvider = borrowingRecordDaoProvider;
  }

  @Override
  public BorrowingRecordService get() {
    return newInstance(borrowingRecordDaoProvider.get());
  }

  public static BorrowingRecordService_Factory create(
      Provider<BorrowingRecordDao> borrowingRecordDaoProvider) {
    return new BorrowingRecordService_Factory(borrowingRecordDaoProvider);
  }

  public static BorrowingRecordService newInstance(BorrowingRecordDao borrowingRecordDao) {
    return new BorrowingRecordService(borrowingRecordDao);
  }
}
