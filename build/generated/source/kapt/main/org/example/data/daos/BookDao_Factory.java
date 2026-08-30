package org.example.data.daos;

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
public final class BookDao_Factory implements Factory<BookDao> {
  @Override
  public BookDao get() {
    return newInstance();
  }

  public static BookDao_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BookDao newInstance() {
    return new BookDao();
  }

  private static final class InstanceHolder {
    private static final BookDao_Factory INSTANCE = new BookDao_Factory();
  }
}
