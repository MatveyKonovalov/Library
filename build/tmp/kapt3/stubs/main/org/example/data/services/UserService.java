package org.example.data.services;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lorg/example/data/services/UserService;", "Lorg/example/domain/repositories/UserOperations;", "userDao", "Lorg/example/data/daos/UserDao;", "(Lorg/example/data/daos/UserDao;)V", "findUser", "Lorg/example/domain/models/User;", "userId", "", "getAllUsers", "", "registerUser", "name", "email", "userType", "Lorg/example/domain/models/UserType;", "saveInFile", "", "LibrarySystem"})
public final class UserService implements org.example.domain.repositories.UserOperations {
    @org.jetbrains.annotations.NotNull()
    private final org.example.data.daos.UserDao userDao = null;
    
    @javax.inject.Inject()
    public UserService(@org.jetbrains.annotations.NotNull()
    org.example.data.daos.UserDao userDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String registerUser(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    org.example.domain.models.UserType userType) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.example.domain.models.User findUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.example.domain.models.User> getAllUsers() {
        return null;
    }
    
    @java.lang.Override()
    public void saveInFile() {
    }
}