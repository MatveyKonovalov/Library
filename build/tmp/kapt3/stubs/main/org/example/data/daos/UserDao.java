package org.example.data.daos;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\tJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001d"}, d2 = {"Lorg/example/data/daos/UserDao;", "", "userMapper", "Lorg/example/data/mappers/UserMapper;", "(Lorg/example/data/mappers/UserMapper;)V", "id", "", "users", "", "", "Lorg/example/domain/models/User;", "getUsers", "()Ljava/util/Map;", "users$delegate", "Lkotlin/Lazy;", "findUser", "userId", "getAllUsers", "", "loadUserFromFile", "", "registerUser", "name", "email", "userType", "Lorg/example/domain/models/UserType;", "saveUserInFile", "", "Companion", "LibrarySystem"})
public final class UserDao {
    @org.jetbrains.annotations.NotNull()
    private final org.example.data.mappers.UserMapper userMapper = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILENAME = "users.txt";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy users$delegate = null;
    private int id;
    @org.jetbrains.annotations.NotNull()
    public static final org.example.data.daos.UserDao.Companion Companion = null;
    
    @javax.inject.Inject()
    public UserDao(@org.jetbrains.annotations.NotNull()
    org.example.data.mappers.UserMapper userMapper) {
        super();
    }
    
    private final java.util.Map<java.lang.String, org.example.domain.models.User> getUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.example.domain.models.User findUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String registerUser(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    org.example.domain.models.UserType userType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.example.domain.models.User> getAllUsers() {
        return null;
    }
    
    public final void saveUserInFile() {
    }
    
    private final java.util.Map<java.lang.String, org.example.domain.models.User> loadUserFromFile() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/example/data/daos/UserDao$Companion;", "", "()V", "FILENAME", "", "LibrarySystem"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}