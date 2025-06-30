package com.example.modernandroidapp.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0002R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "userSessionManager", "Lcom/example/modernandroidapp/data/UserSessionManager;", "(Lcom/example/modernandroidapp/data/RoomConsignmentRepository;Lcom/example/modernandroidapp/data/UserSessionManager;)V", "<set-?>", "Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentUiState;", "_uiState", "get_uiState", "()Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentUiState;", "set_uiState", "(Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentUiState;)V", "_uiState$delegate", "Landroidx/compose/runtime/MutableState;", "currentUserRole", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/modernandroidapp/data/UserRole;", "getCurrentUserRole", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "addItem", "", "removeItem", "index", "", "resetSuccess", "submitConsignment", "updateCustomerName", "name", "", "updateItem", "item", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "validate", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddConsignmentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.RoomConsignmentRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.UserSessionManager userSessionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState _uiState$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.data.UserRole> currentUserRole = null;
    
    @javax.inject.Inject()
    public AddConsignmentViewModel(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.RoomConsignmentRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.UserSessionManager userSessionManager) {
        super();
    }
    
    private final com.example.modernandroidapp.ui.viewmodels.AddConsignmentUiState get_uiState() {
        return null;
    }
    
    private final void set_uiState(com.example.modernandroidapp.ui.viewmodels.AddConsignmentUiState p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.ui.viewmodels.AddConsignmentUiState getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.data.UserRole> getCurrentUserRole() {
        return null;
    }
    
    public final void updateCustomerName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void updateItem(int index, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.ConsignmentItem item) {
    }
    
    public final void addItem() {
    }
    
    public final void removeItem(int index) {
    }
    
    public final void submitConsignment() {
    }
    
    public final void resetSuccess() {
    }
    
    private final boolean validate() {
        return false;
    }
}