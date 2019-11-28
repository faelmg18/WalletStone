package br.com.rafaelhfernandes.core.framework

import br.com.rafaelhfernandes.core.R
import br.com.rafaelhfernandes.core.framework.exception.ValidatorExeption
import br.com.rafaelhfernandes.core.presentation.app.WalletStoneApplication

object Validator {
    fun validate(
        conditional: Boolean,
        message: String = WalletStoneApplication
            .appContext.getString(R.string.failure_validation),
        function: (valid: ValidatorExeption) -> Unit
    ): Boolean {
        if (!conditional) {
            function(
                ValidatorExeption(
                    message
                )
            )
            return false
        }
        return true
    }
}