package com.example.modernandroidapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/example/modernandroidapp/data/ConsignmentRepository;", "", "getConsignmentById", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/modernandroidapp/data/Consignment;", "id", "", "getOngoingConsignments", "", "app_release"})
public abstract interface ConsignmentRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.modernandroidapp.data.Consignment>> getOngoingConsignments();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.modernandroidapp.data.Consignment> getConsignmentById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
}