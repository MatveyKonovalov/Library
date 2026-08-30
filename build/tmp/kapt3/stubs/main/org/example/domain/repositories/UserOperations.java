package org.example.domain.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lorg/example/domain/repositories/UserOperations;", "", "findUser", "Lorg/example/domain/models/User;", "userId", "", "getAllUsers", "", "registerUser", "name", "email", "userType", "Lorg/example/domain/models/UserType;", "saveInFile", "", "LibrarySystem"})
public abstract interface UserOperations {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String registerUser(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    org.example.domain.models.UserType userType);
    
    @org.jetbrains.annotations.Nullable()
    public abstract org.example.domain.models.User findUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.example.domain.models.User> getAllUsers();
    
    public abstract void saveInFile();
}