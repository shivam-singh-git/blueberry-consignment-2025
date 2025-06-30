package com.example.modernandroidapp.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001aJ\u0016\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001aJ\u0016\u0010\'\u001a\u00020\u00182\u0006\u0010%\u001a\u00020#2\u0006\u0010(\u001a\u00020\u001aJ\u0016\u0010)\u001a\u00020\u00182\u0006\u0010%\u001a\u00020#2\u0006\u0010*\u001a\u00020#R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/example/modernandroidapp/ui/viewmodels/ConsignmentDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/modernandroidapp/data/ConsignmentRepository;", "roomRepository", "Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "userSessionManager", "Lcom/example/modernandroidapp/data/UserSessionManager;", "(Lcom/example/modernandroidapp/data/ConsignmentRepository;Lcom/example/modernandroidapp/data/RoomConsignmentRepository;Lcom/example/modernandroidapp/data/UserSessionManager;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/modernandroidapp/ui/viewmodels/ConsignmentDetailUiState;", "currentUserRole", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/modernandroidapp/data/UserRole;", "getCurrentUserRole", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "canEdit", "", "hasChanges", "isAllItemsDelivered", "loadConsignment", "", "consignmentId", "", "resetSaveSuccess", "saveChanges", "saveConsignment", "updateCustomerName", "newCustomerName", "updateItemDeliveredQuantity", "itemId", "deliveredQuantity", "", "updateItemDescription", "itemIndex", "newDescription", "updateItemName", "newItemName", "updateItemQuantity", "newQuantity", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ConsignmentDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.ConsignmentRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.RoomConsignmentRepository roomRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.UserSessionManager userSessionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.data.UserRole> currentUserRole = null;
    
    @javax.inject.Inject()
    public ConsignmentDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.ConsignmentRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.RoomConsignmentRepository roomRepository, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.UserSessionManager userSessionManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.data.UserRole> getCurrentUserRole() {
        return null;
    }
    
    public final void loadConsignment(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId) {
    }
    
    public final void updateItemDeliveredQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, int deliveredQuantity) {
    }
    
    public final void updateCustomerName(@org.jetbrains.annotations.NotNull()
    java.lang.String newCustomerName) {
    }
    
    public final void updateItemName(int itemIndex, @org.jetbrains.annotations.NotNull()
    java.lang.String newItemName) {
    }
    
    public final void updateItemDescription(int itemIndex, @org.jetbrains.annotations.NotNull()
    java.lang.String newDescription) {
    }
    
    public final void updateItemQuantity(int itemIndex, int newQuantity) {
    }
    
    public final void saveConsignment() {
    }
    
    public final void saveChanges() {
    }
    
    public final void resetSaveSuccess() {
    }
    
    public final boolean hasChanges() {
        return false;
    }
    
    public final boolean isAllItemsDelivered() {
        return false;
    }
    
    public final boolean canEdit() {
        return false;
    }
}