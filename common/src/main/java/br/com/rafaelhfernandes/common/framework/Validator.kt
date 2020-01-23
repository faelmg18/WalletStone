package br.com.rafaelhfernandes.common.framework

object Validator {
    fun validate(
        function: () -> Boolean
    ): Boolean {
        return function()
    }
}