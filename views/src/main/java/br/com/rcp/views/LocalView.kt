package br.com.rcp.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import org.koin.core.KoinComponent

class LocalView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attributeSet, defStyleAttr), KoinComponent {
    private val city: TextView

    init {
        inflate(context, R.layout.view_location, this)
        city = findViewById(R.id.city)
    }

    fun bind(city: String) {
        this.city.text = city
    }
}