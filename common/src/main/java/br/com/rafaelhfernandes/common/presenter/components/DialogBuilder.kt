package br.com.rafaelhfernandes.common.presenter.components

import android.content.Context

object DialogBuilder {

    fun showDialog(
        context: Context,
        title: String? = "",
        message: String? = "",
        negativeButtonTitle: String? = "",
        positiveButtonTitle: String? = "",
        buttonClickListener: CustomAlertDialog.DialogBuilderButtonClickListener? = defaultClickLisnter
    ): CustomAlertDialog {


        val customAlertDialog = CustomAlertDialog(context)

        val builder = CustomAlertDialog.Builder(
            title = title,
            message = message,
            negativeButtonTitle = negativeButtonTitle,
            positiveButtonTitle = positiveButtonTitle,
            buttonClickListener = buttonClickListener,
            customAlertDialog = customAlertDialog
        )

        customAlertDialog.initialize(builder)

        return customAlertDialog
    }

    val defaultClickLisnter =
        object : CustomAlertDialog.DialogBuilderButtonClickListener() {}
}
