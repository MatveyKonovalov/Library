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
public final class UserMapper_Factory implements Factory<UserMapper> {
  @Override
  public UserMapper get() {
    return newInstance();
  }

  public static UserMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static UserMapper newInstance() {
    return new UserMapper();
  }

  private static final class InstanceHolder {
    private static final UserMapper_Factory INSTANCE = new UserMapper_Factory();
  }
}
