package br.com.rafaelhfernandes.core.presentation.accountmanager

enum class AccountManagerUserState {
    USER_ALREADY_EXISTS,
    USER_CREATED,
    USER_UPDATED,
    USER_DELETED,
    USER_NOT_FOUND,
    USER_FOUND,
    FAILURE_TO_ON_LOGIN_USER
}