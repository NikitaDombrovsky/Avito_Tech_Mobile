package com.example.avito_mobile_dombrovskiy.Core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


abstract class Reducer<S : UiState, E : UiEvent>(initialVal: S) {

    private val mutableState: MutableStateFlow<S> = MutableStateFlow(initialVal)
    val state = mutableState.asStateFlow()

    fun sendEvent(event: E) {
        reduce(mutableState.value, event)
    }

    fun setState(newState: S) {
        mutableState.tryEmit(newState)
    }

    abstract fun reduce(oldState: S, event: E)

}

interface UiEvent

interface UiState