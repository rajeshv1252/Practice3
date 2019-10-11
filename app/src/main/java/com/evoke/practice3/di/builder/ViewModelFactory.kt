package com.evoke.practice3.di.builder

import android.arch.lifecycle.ViewModel
    import android.arch.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.RuntimeException

@Singleton
class ViewModelFactory
@Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // get the ViewModel provider based on given class
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("Unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}