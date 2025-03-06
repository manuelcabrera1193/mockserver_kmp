package org.example.project.di

import org.example.project.network.NetworkClient
import org.example.project.repository.AuthRepository
import org.koin.dsl.module

val sharedModule = module {
    single { NetworkClient().client }
    single { AuthRepository(get()) }
}
