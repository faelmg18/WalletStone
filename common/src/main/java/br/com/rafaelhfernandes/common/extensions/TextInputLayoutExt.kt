package br.com.rafaelhfernandes.common.extensions

import br.com.rafaelhfernandes.common.R
import br.com.rafaelhfernandes.common.presenter.exceptions.FieldNotFiledExeption
import com.google.android.material.textfield.TextInputLayout

@Throws(FieldNotFiledExeption::class)
fun validateFieldFilled(vararg textInputLayout: TextInputLayout) {

    textInputLayout.forEach {
        if (it.editText?.text.toString().isEmpty()) {
            val message = it.context.getString(R.string.mandatory_filed)
            it.error = message
            throw FieldNotFiledExeption(message)
        } else {
            it.error = null
        }
    }
}