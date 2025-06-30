package com.example.modernandroidapp.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001f\u001a\u00020\u000fJ\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020#J\u0006\u0010\'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020%J\u0016\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J&\u0010/\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020-J\u0016\u00103\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020%J\u0016\u00104\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u00105\u001a\u00020%J\u0016\u00106\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u00102\u001a\u00020-R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/example/modernandroidapp/ui/viewmodels/ConsignmentDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/modernandroidapp/data/ConsignmentRepository;", "roomRepository", "Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "userSessionManager", "Lcom/example/modernandroidapp/data/UserSessionManager;", "(Lcom/example/modernandroidapp/data/ConsignmentRepository;Lcom/example/modernandroidapp/data/RoomConsignmentRepository;Lcom/example/modernandroidapp/data/UserSessionManager;)V", "_consignment", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/modernandroidapp/data/Consignment;", "_currentUserRole", "Lcom/example/modernandroidapp/data/UserRole;", "_hasUnsavedChanges", "", "_isLoading", "_isSaving", "_saveSuccess", "consignment", "Lkotlinx/coroutines/flow/StateFlow;", "getConsignment", "()Lkotlinx/coroutines/flow/StateFlow;", "currentUserRole", "getCurrentUserRole", "hasUnsavedChanges", "getHasUnsavedChanges", "isLoading", "isSaving", "saveSuccess", "getSaveSuccess", "canEdit", "hasChanges", "isAllItemsDelivered", "loadConsignment", "", "consignmentId", "", "resetSaveSuccess", "saveChanges", "saveConsignment", "updateCustomerName", "newCustomerName", "updateDeliveredQuantity", "itemIndex", "", "deliveredQuantity", "updateItem", "newName", "newDescription", "newQuantity", "updateItemDescription", "updateItemName", "newItemName", "updateItemQuantity", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ConsignmentDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.ConsignmentRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.RoomConsignmentRepository roomRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.UserSessionManager userSessionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.modernandroidapp.data.Consignment> _consignment = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.data.Consignment> consignment = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _hasUnsavedChanges = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> hasUnsavedChanges = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSaving = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _saveSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> saveSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.modernandroidapp.data.UserRole> _currentUserRole = null;
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
    public final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.data.Consignment> getConsignment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getHasUnsavedChanges() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getSaveSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.modernandroidapp.data.UserRole> getCurrentUserRole() {
        return null;
    }
    
    public final void loadConsignment(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId) {
    }
    
    public final void updateDeliveredQuantity(int itemIndex, int deliveredQuantity) {
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
    
    public final void updateItem(int itemIndex, @org.jetbrains.annotations.NotNull()
    java.lang.String newName, @org.jetbrains.annotations.NotNull()
    java.lang.String newDescription, int newQuantity) {
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