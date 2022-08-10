package ktor_chatApp.plugins

import io.ktor.server.application.*
import ktor_chatApp.di.mainModule
import org.koin.ktor.plugin.Koin


fun Application.configureKoin(){
    install(Koin){
        modules(mainModule)
    }
}