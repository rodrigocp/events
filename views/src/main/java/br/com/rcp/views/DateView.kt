package br.com.rcp.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import org.koin.core.KoinComponent
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class DateView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attributeSet, defStyleAttr), KoinComponent {
    private var date        : Long      = 0L
    private val dayOfWeek   : TextView
    private val dayOfMonth  : TextView
    private val monthOfYear : TextView

    init {
        inflate(context, R.layout.view_calendar, this)
        dayOfWeek   = findViewById(R.id.dayOfWeek)
        dayOfMonth  = findViewById(R.id.dayOfMonth)
        monthOfYear = findViewById(R.id.monthOfYear)
    }

    fun bind(date: Long) {
        this.date = date
        setDayOfWeek()
        setDayOfMonth()
        setMonthOfYear()
    }

    private fun setDayOfWeek() {
        dayOfWeek.text   = convertDateFromPattern("EEE").dropLast(1)
    }

    private fun setDayOfMonth() {
        dayOfMonth.text  = convertDateFromPattern("dd")
    }

    private fun setMonthOfYear() {
        monthOfYear.text = convertDateFromPattern("MMM")
    }

    private fun convertDateFromPattern(pattern: String): String {
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