package br.com.rcp.domain.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import br.com.rcp.domain.repository.UserRepository

private const val KNAME   = "name";
private const val KEMAIL  = "email";

class UserRepositoryImpl(private val preferences: SharedPreferences) : UserRepository {
    override fun setName(name: String) {
        persist(KNAME, name)
    }

    override fun setEmail(email: String) {
        persist(KEMAIL, email)
    }

    override fun getName(): String? {
        return retrieve(KNAME)
    }

    override fun getEmail(): String? {
        return retrieve(KEMAIL)
    }

    private fun persist(key: String, value: String) {
        preferences.edit { putString(key, value) }
    }

    private fun retrieve(key: String) : String? {
        return preferences.getString(key, null);
    }
}