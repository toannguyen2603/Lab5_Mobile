package com.lab5.healthMeasure;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020#H\u0016J\u001a\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\u001c\u0010:\u001a\u00020#2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<H\u0002J\u0010\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0010H\u0002J\b\u0010A\u001a\u00020#H\u0002J\u0010\u0010B\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0010H\u0002J\u0010\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020EH\u0002J\"\u0010F\u001a\u00020#2\u0018\u0010;\u001a\u0014\u0012\u0004\u0012\u00020=\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0G0<H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006K"}, d2 = {"Lcom/lab5/healthMeasure/ExerciseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/lab5/healthMeasure/databinding/FragmentExerciseBinding;", "activeDurationUpdate", "Lcom/lab5/healthMeasure/ActiveDurationUpdate;", "ambientController", "Landroidx/wear/ambient/AmbientModeSupport$AmbientController;", "Landroidx/wear/ambient/AmbientModeSupport;", "ambientModeHandler", "Lcom/lab5/healthMeasure/ExerciseFragment$AmbientModeHandler;", "binding", "getBinding", "()Lcom/lab5/healthMeasure/databinding/FragmentExerciseBinding;", "cachedExerciseState", "Landroidx/health/services/client/data/ExerciseState;", "chronoTickJob", "Lkotlinx/coroutines/Job;", "healthServicesManager", "Lcom/lab5/healthMeasure/HealthServicesManager;", "getHealthServicesManager", "()Lcom/lab5/healthMeasure/HealthServicesManager;", "setHealthServicesManager", "(Lcom/lab5/healthMeasure/HealthServicesManager;)V", "serviceConnection", "Lcom/lab5/healthMeasure/ExerciseServiceConnection;", "uiBindingJob", "viewModel", "Lcom/lab5/healthMeasure/MainViewModel;", "getViewModel", "()Lcom/lab5/healthMeasure/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindViewsToService", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "pauseResumeExercise", "performOneTimeUiUpdate", "resetDisplayedFields", "setAmbientUiState", "isAmbient", "", "startChronometer", "startEndExercise", "stopChronometer", "tryStartExercise", "unbindViewsFromService", "updateAggregateMetrics", "data", "", "Landroidx/health/services/client/data/DataType;", "Landroidx/health/services/client/data/AggregateDataPoint;", "updateButtons", "state", "updateChronometer", "updateExerciseStatus", "updateLaps", "laps", "", "updateMetrics", "", "Landroidx/health/services/client/data/DataPoint;", "AmbientModeHandler", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ExerciseFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public com.lab5.healthMeasure.HealthServicesManager healthServicesManager;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.lab5.healthMeasure.databinding.FragmentExerciseBinding _binding;
    private com.lab5.healthMeasure.ExerciseServiceConnection serviceConnection;
    private androidx.health.services.client.data.ExerciseState cachedExerciseState = androidx.health.services.client.data.ExerciseState.USER_ENDED;
    private com.lab5.healthMeasure.ActiveDurationUpdate activeDurationUpdate;
    private kotlinx.coroutines.Job chronoTickJob;
    private kotlinx.coroutines.Job uiBindingJob;
    private androidx.wear.ambient.AmbientModeSupport.AmbientController ambientController;
    private com.lab5.healthMeasure.ExerciseFragment.AmbientModeHandler ambientModeHandler;
    @org.jetbrains.annotations.NotNull()
    private static final com.lab5.healthMeasure.ExerciseFragment.Companion Companion = null;
    @java.lang.Deprecated()
    public static final long CHRONO_TICK_MS = 200L;
    
    public ExerciseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lab5.healthMeasure.HealthServicesManager getHealthServicesManager() {
        return null;
    }
    
    public final void setHealthServicesManager(@org.jetbrains.annotations.NotNull()
    com.lab5.healthMeasure.HealthServicesManager p0) {
    }
    
    private final com.lab5.healthMeasure.MainViewModel getViewModel() {
        return null;
    }
    
    private final com.lab5.healthMeasure.databinding.FragmentExerciseBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void startEndExercise() {
    }
    
    private final void tryStartExercise() {
    }
    
    private final void pauseResumeExercise() {
    }
    
    private final void bindViewsToService() {
    }
    
    private final void unbindViewsFromService() {
    }
    
    private final void updateExerciseStatus(androidx.health.services.client.data.ExerciseState state) {
    }
    
    private final void updateButtons(androidx.health.services.client.data.ExerciseState state) {
    }
    
    private final void updateMetrics(java.util.Map<androidx.health.services.client.data.DataType, ? extends java.util.List<androidx.health.services.client.data.DataPoint>> data) {
    }
    
    private final void updateAggregateMetrics(java.util.Map<androidx.health.services.client.data.DataType, ? extends androidx.health.services.client.data.AggregateDataPoint> data) {
    }
    
    private final void updateLaps(int laps) {
    }
    
    private final void startChronometer() {
    }
    
    private final void stopChronometer() {
    }
    
    private final void updateChronometer() {
    }
    
    private final void resetDisplayedFields() {
    }
    
    private final void setAmbientUiState(boolean isAmbient) {
    }
    
    private final void performOneTimeUiUpdate() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/lab5/healthMeasure/ExerciseFragment$AmbientModeHandler;", "", "(Lcom/lab5/healthMeasure/ExerciseFragment;)V", "onAmbientEvent", "", "event", "Lcom/lab5/healthMeasure/AmbientEvent;", "onAmbientEvent$app_debug", "onEnterAmbient", "onExitAmbient", "onUpdateAmbient", "app_debug"})
    public final class AmbientModeHandler {
        
        public AmbientModeHandler() {
            super();
        }
        
        public final void onAmbientEvent$app_debug(@org.jetbrains.annotations.NotNull()
        com.lab5.healthMeasure.AmbientEvent event) {
        }
        
        private final void onEnterAmbient() {
        }
        
        private final void onExitAmbient() {
        }
        
        private final void onUpdateAmbient() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/lab5/healthMeasure/ExerciseFragment$Companion;", "", "()V", "CHRONO_TICK_MS", "", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}