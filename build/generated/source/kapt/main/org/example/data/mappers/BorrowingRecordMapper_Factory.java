package org.example.data.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class BorrowingRecordMapper_Factory implements Factory<BorrowingRecordMapper> {
  @Override
  public BorrowingRecordMapper get() {
    return newInstance();
  }

  public static BorrowingRecordMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BorrowingRecordMapper newInstance() {
    return new BorrowingRecordMapper();
  }

  private static final class InstanceHolder {
    private static final BorrowingRecordMapper_Factory INSTANCE = new BorrowingRecordMapper_Factory();
  }
}
