package com.example.mytasks.di

import androidx.lifecycle.ViewModel
import com.example.mytasks.presentation.viewModelPack.TaskViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModuleKey(TaskViewModel::class)
    abstract fun bindTaskViewModel(viewModel: TaskViewModel): ViewModel


    @MustBeDocumented
    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    annotation class ViewModuleKey(val viewModelKey: KClass<out ViewModel>)

}