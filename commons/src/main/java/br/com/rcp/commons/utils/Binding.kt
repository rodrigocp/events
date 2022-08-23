package br.com.rcp.commons.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.squareup.picasso.Picasso

object Binding {
    @JvmStatic
    @BindingAdapter("bind:loadImage")
    fun loadImage(image: ImageView, url: String?) {
        url?.let {
            Picasso.get().load(it).placeholder(placeholder(image.context)).error(placeholder(image.context)).into(image)
        }
    }

    private fun placeholder(context: Context) : CircularProgressDrawable {
        return CircularProgressDrawable(context).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }
    }
}