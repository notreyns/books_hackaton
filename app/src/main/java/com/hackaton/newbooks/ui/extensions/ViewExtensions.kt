package com.hackaton.newbooks.ui.extensions

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop


fun View.setGoneIfFalse(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun View.setInvisibleIfTrue(isHide: Boolean) {
    visibility = if (!isHide) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

fun View.setGoneIfTrue(isHide: Boolean) {
    visibility = if (!isHide) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

/*
fun EditText.setValidStatus(isValid: Boolean) {
    if (isValid) {
        this.setBackgroundResource(R.drawable.edittext_background)
        this.setTextColor(ContextCompat.getColor(this.context, R.color.black))
    } else {
        this.setBackgroundResource(R.drawable.edittext_error_background)
        this.setTextColor(ContextCompat.getColor(this.context, R.color.red))
    }
}
*/

fun ImageView.setImageByUrl(url: String, @DrawableRes placeholder: Int? = null) {
    val requestBuilder = Glide.with(this)
        .asDrawable()
        .load(url)
        .transform(CenterCrop())
    placeholder?.let {
        requestBuilder.placeholder(placeholder)
    }
    requestBuilder.into(this)
}

/*
fun Toast.showCustomToast(message: String, activity: Activity, toastDuration: Int) {
    val layout = activity.layoutInflater.inflate (
        R.layout.custom_error_toast,
        activity.findViewById(R.id.error_toast_container)
    )
    val textView = layout.findViewById<TextView>(R.id.toast_message)
    textView.text = message
    this.apply {
        setGravity(Gravity.FILL_HORIZONTAL or Gravity.TOP, 0, 0)
        duration = toastDuration
        view = layout
        show()
    }
}*/
