package br.com.rcp.views

import android.content.Context
import android.util.AttributeSet
import android.util.Patterns
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.rcp.domain.models.CheckIn
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import org.koin.core.KoinComponent

class CheckInView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attributeSet, defStyleAttr), KoinComponent {
    private val name   : TextInputEditText
    private val email  : TextInputEditText
    private val button : MaterialButton

    init {
        inflate(context, R.layout.view_checkin, this)
        name   = findViewById(R.id.name)
        email  = findViewById(R.id.email)
        button = findViewById(R.id.check)
    }

    fun bind(identifier: Long, onCheckInSelected: (CheckIn) -> Unit) {
        button.setOnClickListener {
            onCheckInSelected(CheckIn(identifier.toString(), getEmailField(), getNameField()))
        }
    }

    private fun getEmailField(): String {
        return email.text.toString()
    }

    private fun getNameField(): String {
        return name.text.toString()
    }
}