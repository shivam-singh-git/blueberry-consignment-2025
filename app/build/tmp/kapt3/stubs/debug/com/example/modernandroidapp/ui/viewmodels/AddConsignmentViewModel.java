package com.example.modernandroidapp.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\bJ\u0016\u0010\'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020$J\u000e\u0010,\u001a\u00020$2\u0006\u0010(\u001a\u00020)J\u001e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00188F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\r\u00a8\u00060"}, d2 = {"Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "context", "Landroid/content/Context;", "(Lcom/example/modernandroidapp/data/RoomConsignmentRepository;Landroid/content/Context;)V", "<set-?>", "", "customerName", "getCustomerName", "()Ljava/lang/String;", "setCustomerName", "(Ljava/lang/String;)V", "customerName$delegate", "Landroidx/compose/runtime/MutableState;", "", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "", "submitSuccess", "getSubmitSuccess", "()Z", "setSubmitSuccess", "(Z)V", "submitSuccess$delegate", "validationError", "getValidationError", "setValidationError", "validationError$delegate", "addItem", "", "onCustomerNameChange", "newName", "onItemChange", "index", "", "item", "onSubmit", "removeItem", "scheduleReminders", "consignmentName", "validate", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddConsignmentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.RoomConsignmentRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState customerName$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState items$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState submitSuccess$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState validationError$delegate = null;
    
    @javax.inject.Inject()
    public AddConsignmentViewModel(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.RoomConsignmentRepository repository, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCustomerName() {
        return null;
    }
    
    private final void setCustomerName(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.modernandroidapp.data.ConsignmentItem> getItems() {
        return null;
    }
    
    private final void setItems(java.util.List<com.example.modernandroidapp.data.ConsignmentItem> p0) {
    }
    
    public final boolean getSubmitSuccess() {
        return false;
    }
    
    private final void setSubmitSuccess(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getValidationError() {
        return null;
    }
    
    private final void setValidationError(java.lang.String p0) {
    }
    
    public final void onCustomerNameChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newName) {
    }
    
    public final void onItemChange(int index, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.ConsignmentItem item) {
    }
    
    public final void addItem() {
    }
    
    public final void removeItem(int index) {
    }
    
    private final boolean validate() {
        return false;
    }
    
    public final void onSubmit() {
    }
    
    private final void scheduleReminders(java.lang.String consignmentName, java.util.List<com.example.modernandroidapp.data.ConsignmentItem> items) {
    }
}