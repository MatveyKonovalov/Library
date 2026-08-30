package org.example.data.services;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.example.data.daos.UserDao;

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
public final class UserService_Factory implements Factory<UserService> {
  private final Provider<UserDao> userDaoProvider;

  public UserService_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public UserService get() {
    return newInstance(userDaoProvider.get());
  }

  public static UserService_Factory create(Provider<UserDao> userDaoProvider) {
    return new UserService_Factory(userDaoProvider);
  }

  public static UserService newInstance(UserDao userDao) {
    return new UserService(userDao);
  }
}
