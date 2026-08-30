package org.example.data.services;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.example.data.daos.BookDao;

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
public final class BookService_Factory implements Factory<BookService> {
  private final Provider<BookDao> bookDaoProvider;

  public BookService_Factory(Provider<BookDao> bookDaoProvider) {
    this.bookDaoProvider = bookDaoProvider;
  }

  @Override
  public BookService get() {
    return newInstance(bookDaoProvider.get());
  }

  public static BookService_Factory create(Provider<BookDao> bookDaoProvider) {
    return new BookService_Factory(bookDaoProvider);
  }

  public static BookService newInstance(BookDao bookDao) {
    return new BookService(bookDao);
  }
}
