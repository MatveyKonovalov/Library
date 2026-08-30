package org.example.presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.example.domain.LibraryOperations;

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
public final class UserConsoleUI_Factory implements Factory<UserConsoleUI> {
  private final Provider<LibraryOperations> libraryOperationsProvider;

  public UserConsoleUI_Factory(Provider<LibraryOperations> libraryOperationsProvider) {
    this.libraryOperationsProvider = libraryOperationsProvider;
  }

  @Override
  public UserConsoleUI get() {
    return newInstance(libraryOperationsProvider.get());
  }

  public static UserConsoleUI_Factory create(
      Provider<LibraryOperations> libraryOperationsProvider) {
    return new UserConsoleUI_Factory(libraryOperationsProvider);
  }

  public static UserConsoleUI newInstance(LibraryOperations libraryOperations) {
    return new UserConsoleUI(libraryOperations);
  }
}
