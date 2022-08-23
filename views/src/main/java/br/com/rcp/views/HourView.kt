package br.com.rcp.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import org.koin.core.KoinComponent
import java.text.SimpleDateFormat
import java.util.*

class HourView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attributeSet, defStyleAttr), KoinComponent {
    private val hour: TextView

    init {
        inflate(context, R.layout.view_hour, this)
        hour = findViewById(R.id.hourv)
    }

    fun bind(date: Long) {
        setHour(date)
    }

    private fun setHour(date: Long) {
        hour.text = convertDateFromPattern("hh:mm", date)
    }

    private fun convertDateFromPattern(pattern: String, date: Long): String {
        return try {
            (SimpleDateFormat(pattern, getLocale()).format(Date(date)) ?: "").toUpperCase(getLocale())
        } catch (e: Exception) {
            ""
        }
    }

    private fun getLocale() : Locale {
        return Locale("pt", "BR")
    }
}