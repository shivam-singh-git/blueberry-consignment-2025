package com.example.modernandroidapp.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH\u00c6\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\rH\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentUiState;", "", "customerName", "", "items", "", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "isSubmitting", "", "isSuccess", "customerNameError", "itemErrors", "", "", "(Ljava/lang/String;Ljava/util/List;ZZLjava/lang/String;Ljava/util/Map;)V", "getCustomerName", "()Ljava/lang/String;", "getCustomerNameError", "()Z", "getItemErrors", "()Ljava/util/Map;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_release"})
public final class AddConsignmentUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String customerName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.modernandroidapp.data.ConsignmentItem> items = null;
    private final boolean isSubmitting = false;
    private final boolean isSuccess = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String customerNameError = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Integer, java.lang.String> itemErrors = null;
    
    public AddConsignmentUiState(@org.jetbrains.annotations.NotNull()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.modernandroidapp.data.ConsignmentItem> items, boolean isSubmitting, boolean isSuccess, @org.jetbrains.annotations.Nullable()
    java.lang.String customerNameError, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, java.lang.String> itemErrors) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCustomerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.modernandroidapp.data.ConsignmentItem> getItems() {
        return null;
    }
    
    public final boolean isSubmitting() {
        return false;
    }
    
    public final boolean isSuccess() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomerNameError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, java.lang.String> getItemErrors() {
        return null;
    }
    
    public AddConsignmentUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.modernandroidapp.data.ConsignmentItem> component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.ui.viewmodels.AddConsignmentUiState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.modernandroidapp.data.ConsignmentItem> items, boolean isSubmitting, boolean isSuccess, @org.jetbrains.annotations.Nullable()
    java.lang.String customerNameError, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, java.lang.String> itemErrors) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}