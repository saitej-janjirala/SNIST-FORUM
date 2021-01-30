package com.saitejajanjirala.snistforum.utils

import android.content.Context
import android.graphics.PorterDuff
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.saitejajanjirala.snistforum.R

object Toaster {
    fun show(context: Context, text: CharSequence) {
        val toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT)
        toast.view?.background?.setColorFilter(
            ContextCompat.getColor(context, R.color.teal_200), PorterDuff.Mode.SRC_IN
        )
        val textView = toast.view?.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, R.color.white))
        toast.show()
    }
}