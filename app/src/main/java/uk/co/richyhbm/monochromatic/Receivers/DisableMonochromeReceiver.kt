package uk.co.richyhbm.monochromatic.Receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import uk.co.richyhbm.monochromatic.Utilities.SecureSettings
import uk.co.richyhbm.monochromatic.Utilities.Settings

class DisableMonochromeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        if(context != null) {
            val settings = Settings(context)
            if(settings.isEnabled() && SecureSettings.isMonochromeEnabled(context.contentResolver)) {
                SecureSettings.resetAllFilters(context.contentResolver, settings)
            }
        }
    }
}