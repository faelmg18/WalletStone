package br.com.rafaelhfernandes.common.presenter.components

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import br.com.rafaelhfernandes.common.R
import br.com.rafaelhfernandes.common.databinding.CustomDialogBinding

class CustomAlertDialog : AlertDialog {

    private var builder: Builder? = null

    constructor(context: Context) : super(context)

    private constructor(context: Context, themeResId: Int) : super(context, themeResId)

    private constructor(
        context: Context,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener?
    ) : super(context, cancelable, cancelListener)

    fun initialize(builder: Builder) {
        this.builder = builder

        val binding = DataBindingUtil.inflate<CustomDialogBinding>(
            LayoutInflater.from(context),
            R.layout.custom_dialog, null, false
        )

        binding.builder = builder
        setView(binding.root)
    }

    data class Builder(
        val title: String? = "",
        val message: String? = "",
        val positiveButtonTitle: String? = "",
        val negativeButtonTitle: String? = "",
        val buttonClickListener: DialogBuilderButtonClickListener? = null,
        val customAlertDialog: CustomAlertDialog
    )
    open class DialogBuilderButtonClickListener {

        open fun onPositiveButtonClick(customAlertDialog: CustomAlertDialog) {
            customAlertDialog.dismiss()
        }

        open fun onNegativeButtonClick(customAlertDialog: CustomAlertDialog) {
            customAlertDialog.dismiss()
        }
    }
}