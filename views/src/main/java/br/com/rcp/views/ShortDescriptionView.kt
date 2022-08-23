package br.com.rcp.views

import android.content.Context
import android.location.Geocoder
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import org.koin.core.KoinComponent
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*


class ShortDescriptionView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attributeSet, defStyleAttr), KoinComponent {
    private val city  : TextView
    private val title : TextView
    private val price : TextView

    init {
        inflate(context, R.layout.view_short_description, this)
        city  = findViewById(R.id.city)
        title = findViewById(R.id.title)
        price = findViewById(R.id.price)
    }

    fun bind(title: String, latitude: BigDecimal, longitude: BigDecimal, price: BigDecimal): ShortDescriptionView {
        setTitle(title)
        setPrice(price)
        setLocal(getLocation(context, latitude, longitude))
        return this
    }

    private fun setTitle(title: String) {
        this.title.text = title
    }

    private fun setPrice(price: BigDecimal) {
        this.price.text = getCurrencyFormatted(price)
    }

    private fun setLocal(local: String) {
        this.city.text = local
    }

    private fun getCurrencyFormatted(value: BigDecimal) : String {
        return NumberFormat.getCurrencyInstance(getLocale()).format(value)
    }

    private fun getLocale() : Locale {
        return Locale("pt", "BR")
    }

    private fun getLocation(context: Context, latitude: BigDecimal, longitude: BigDecimal) : String {
        return try {
            val geocoder   = Geocoder(context, getLocale())
            val address    = geocoder.getFromLocation(latitude.toDouble(), longitude.toDouble(), 1)
            "${address[0].subAdminArea}"
        } catch (ex: Exception) {
            "Sem Localização"
        }
    }
}