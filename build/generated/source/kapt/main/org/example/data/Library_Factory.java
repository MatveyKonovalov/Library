package org.example.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.example.domain.repositories.BookOperations;
import org.example.domain.repositories.BorrowingRecordOperations;
import org.example.domain.repositories.UserOperations;

@ScopeMetadata
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
public final class Library_Factory implements Factory<Library> {
  private final Provider<BookOperations> bookServiceProvider;

  private final Provider<UserOperations> userServiceProvider;

  private final Provider<BorrowingRecordOperations> borrowingRecordServiceProvider;

  public Library_Factory(Provider<BookOperations> bookServiceProvider,
      Provider<UserOperations> userServiceProvider,
      Provider<BorrowingRecordOperations> borrowingRecordServiceProvider) {
    this.bookServiceProvider = bookServiceProvider;
    this.userServiceProvider = userServiceProvider;
    this.borrowingRecordServiceProvider = borrowingRecordServiceProvider;
  }

  @Override
  public Library get() {
    return newInstance(bookServiceProvider.get(), userServiceProvider.get(), borrowingRecordServiceProvider.get());
  }

  public static Library_Factory create(Provider<BookOperations> bookServiceProvider,
      Provider<UserOperations> userServiceProvider,
      Provider<BorrowingRecordOperations> borrowingRecordServiceProvider) {
    return new Library_Factory(bookServiceProvider, userServiceProvider, borrowingRecordServiceProvider);
  }

  public static Library newInstance(BookOperations bookService, UserOperations userService,
      BorrowingRecordOperations borrowingRecordService) {
    return new Library(bookService, userService, borrowingRecordService);
  }
}
