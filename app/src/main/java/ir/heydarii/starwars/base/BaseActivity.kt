package ir.heydarii.starwars.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ir.heydarii.starwars.R

/**
 * This class will be used to configure all Activities if needed
 */
open class BaseActivity : AppCompatActivity() {

   protected fun showError(view: View, errorMessage: String, handleErrors: () -> Unit) {
        Snackbar.make(view, errorMessage, Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.retry)) { handleErrors() }.show()
    }
}
