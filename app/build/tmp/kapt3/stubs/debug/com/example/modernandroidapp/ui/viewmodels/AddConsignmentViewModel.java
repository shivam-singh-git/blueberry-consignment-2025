package com.example.modernandroidapp.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0006J\u0016\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u000fJ\u0006\u0010)\u001a\u00020\"J\u000e\u0010*\u001a\u00020\"2\u0006\u0010&\u001a\u00020\'J\b\u0010+\u001a\u00020\u0016H\u0002R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00168F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR/\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000b\u00a8\u0006,"}, d2 = {"Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "(Lcom/example/modernandroidapp/data/RoomConsignmentRepository;)V", "<set-?>", "", "customerName", "getCustomerName", "()Ljava/lang/String;", "setCustomerName", "(Ljava/lang/String;)V", "customerName$delegate", "Landroidx/compose/runtime/MutableState;", "", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "", "submitSuccess", "getSubmitSuccess", "()Z", "setSubmitSuccess", "(Z)V", "submitSuccess$delegate", "validationError", "getValidationError", "setValidationError", "validationError$delegate", "addItem", "", "onCustomerNameChange", "newName", "onItemChange", "index", "", "item", "onSubmit", "removeItem", "validate", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddConsignmentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.RoomConsignmentRepository repository = null;
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
    com.example.modernandroidapp.data.RoomConsignmentRepository repository) {
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
}