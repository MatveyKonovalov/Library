package org.example.presentation;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J,\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0006\u0010\u001d\u001a\u00020\u0006J\u001c\u0010\u001e\u001a\u00020\u000f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010\'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lorg/example/presentation/UserConsoleUI;", "", "libraryOperations", "Lorg/example/domain/LibraryOperations;", "(Lorg/example/domain/LibraryOperations;)V", "addBook", "", "isAddedSomeBooks", "", "bookManagement", "bookManagementMenu", "borrowBook", "borrowingOperations", "borrowingOperationsMenu", "checkAmountInput", "", "message", "", "checkNoBlankInput", "checkUserCommandInput", "Lkotlin/Pair;", "userInput", "maxValue", "defaultValue", "findUser", "getUserEmail", "getUserType", "Lorg/example/domain/models/UserType;", "getUserYesNoInput", "libraryDialog", "processingCheckUserInput", "pairResult", "reduceAmountBooks", "registerUser", "removeBook", "returnBook", "searchBookByAuthor", "searchBookByISBN", "searchBookByTitle", "showAllBooks", "showAllBorrowingRecords", "showAllUsers", "showMenu", "showOverdueBooks", "userManagement", "userManagementMenu", "Companion", "LibrarySystem"})
public final class UserConsoleUI {
    @org.jetbrains.annotations.NotNull()
    private final org.example.domain.LibraryOperations libraryOperations = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ErrorFormatMessage = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ErrorCommandNumMessage = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ErrorAmountMessage = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ErrorAnswerForYesNoQuestionMessage = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.example.presentation.UserConsoleUI.Companion Companion = null;
    
    @javax.inject.Inject()
    public UserConsoleUI(@org.jetbrains.annotations.NotNull()
    org.example.domain.LibraryOperations libraryOperations) {
        super();
    }
    
    public final void libraryDialog() {
    }
    
    private final void bookManagement() {
    }
    
    private final void bookManagementMenu() {
    }
    
    private final void addBook(boolean isAddedSomeBooks) {
    }
    
    private final void reduceAmountBooks() {
    }
    
    private final void removeBook() {
    }
    
    private final void searchBookByISBN() {
    }
    
    private final void searchBookByTitle() {
    }
    
    private final void searchBookByAuthor() {
    }
    
    private final void showAllBooks() {
    }
    
    private final void userManagement() {
    }
    
    private final void userManagementMenu() {
    }
    
    private final void registerUser() {
    }
    
    private final void findUser() {
    }
    
    private final void showAllUsers() {
    }
    
    private final void borrowingOperations() {
    }
    
    private final void borrowingOperationsMenu() {
    }
    
    private final void borrowBook() {
    }
    
    private final void returnBook() {
    }
    
    private final void showOverdueBooks() {
    }
    
    private final void showAllBorrowingRecords() {
    }
    
    private final void showMenu() {
    }
    
    private final kotlin.Pair<java.lang.Boolean, java.lang.Integer> checkUserCommandInput(java.lang.String userInput, int maxValue, int defaultValue) {
        return null;
    }
    
    private final int processingCheckUserInput(kotlin.Pair<java.lang.Boolean, java.lang.Integer> pairResult) {
        return 0;
    }
    
    private final java.lang.String checkNoBlankInput(java.lang.String message) {
        return null;
    }
    
    private final int checkAmountInput(java.lang.String message) {
        return 0;
    }
    
    private final java.lang.String getUserYesNoInput() {
        return null;
    }
    
    private final org.example.domain.models.UserType getUserType() {
        return null;
    }
    
    private final java.lang.String getUserEmail() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lorg/example/presentation/UserConsoleUI$Companion;", "", "()V", "ErrorAmountMessage", "", "ErrorAnswerForYesNoQuestionMessage", "ErrorCommandNumMessage", "ErrorFormatMessage", "makeCyanColorText", "text", "makeGreenColorText", "makeRedColorText", "LibrarySystem"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final java.lang.String makeRedColorText(java.lang.String text) {
            return null;
        }
        
        private final java.lang.String makeGreenColorText(java.lang.String text) {
            return null;
        }
        
        private final java.lang.String makeCyanColorText(java.lang.String text) {
            return null;
        }
    }
}