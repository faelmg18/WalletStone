package br.com.rafaelhfernandes.common.extensions

import android.widget.EditText
import br.com.rafaelhfernandes.common.R
import br.com.rafaelhfernandes.common.framework.Validator.validate
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

fun TextInputLayout.isEmailValid(): Boolean {
    editText?.let {
        return it.isEmailValid()
    }
    return false
}

fun EditText.isEmailValid(): Boolean {
    return validate {
        android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()
    }
}