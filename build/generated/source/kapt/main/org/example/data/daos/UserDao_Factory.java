package org.example.data.daos;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.example.data.mappers.UserMapper;

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
public final class UserDao_Factory implements Factory<UserDao> {
  private final Provider<UserMapper> userMapperProvider;

  public UserDao_Factory(Provider<UserMapper> userMapperProvider) {
    this.userMapperProvider = userMapperProvider;
  }

  @Override
  public UserDao get() {
    return newInstance(userMapperProvider.get());
  }

  public static UserDao_Factory create(Provider<UserMapper> userMapperProvider) {
    return new UserDao_Factory(userMapperProvider);
  }

  public static UserDao newInstance(UserMapper userMapper) {
    return new UserDao(userMapper);
  }
}
