package org.example.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Provider;
import javax.annotation.processing.Generated;
import org.example.data.Library;
import org.example.data.daos.BookDao;
import org.example.data.daos.BookDao_Factory;
import org.example.data.daos.BorrowingRecordDao;
import org.example.data.daos.BorrowingRecordDao_Factory;
import org.example.data.daos.UserDao;
import org.example.data.daos.UserDao_Factory;
import org.example.data.mappers.BorrowingRecordMapper;
import org.example.data.mappers.BorrowingRecordMapper_Factory;
import org.example.data.mappers.UserMapper;
import org.example.data.mappers.UserMapper_Factory;
import org.example.data.services.BookService;
import org.example.data.services.BookService_Factory;
import org.example.data.services.BorrowingRecordService;
import org.example.data.services.BorrowingRecordService_Factory;
import org.example.data.services.UserService;
import org.example.data.services.UserService_Factory;

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
public final class DaggerLibraryComponent {
  private DaggerLibraryComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static LibraryComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public LibraryComponent build() {
      return new LibraryComponentImpl();
    }
  }

  private static final class LibraryComponentImpl implements LibraryComponent {
    private final LibraryComponentImpl libraryComponentImpl = this;

    private Provider<BookDao> bookDaoProvider;

    private Provider<BookService> bookServiceProvider;

    private Provider<UserMapper> userMapperProvider;

    private Provider<UserDao> userDaoProvider;

    private Provider<UserService> userServiceProvider;

    private Provider<BorrowingRecordMapper> borrowingRecordMapperProvider;

    private Provider<BorrowingRecordDao> borrowingRecordDaoProvider;

    private Provider<BorrowingRecordService> borrowingRecordServiceProvider;

    private LibraryComponentImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.bookDaoProvider = DoubleCheck.provider(BookDao_Factory.create());
      this.bookServiceProvider = DoubleCheck.provider(BookService_Factory.create(bookDaoProvider));
      this.userMapperProvider = DoubleCheck.provider(UserMapper_Factory.create());
      this.userDaoProvider = DoubleCheck.provider(UserDao_Factory.create(userMapperProvider));
      this.userServiceProvider = DoubleCheck.provider(UserService_Factory.create(userDaoProvider));
      this.borrowingRecordMapperProvider = DoubleCheck.provider(BorrowingRecordMapper_Factory.create());
      this.borrowingRecordDaoProvider = DoubleCheck.provider(BorrowingRecordDao_Factory.create(borrowingRecordMapperProvider));
      this.borrowingRecordServiceProvider = DoubleCheck.provider(BorrowingRecordService_Factory.create(borrowingRecordDaoProvider));
    }

    @Override
    public Library getLibrary() {
      return new Library(bookServiceProvider.get(), userServiceProvider.get(), borrowingRecordServiceProvider.get());
    }
  }
}
