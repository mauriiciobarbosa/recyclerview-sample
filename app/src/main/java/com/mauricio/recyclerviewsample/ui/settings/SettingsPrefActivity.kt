package com.mauricio.recyclerviewsample.ui.settings

import android.os.Bundle
import android.preference.*
import com.mauricio.recyclerviewsample.R


class SettingsPrefActivity : AppCompatPreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentManager
                .beginTransaction()
                .replace(android.R.id.content, MainPreferenceFragment()).commit()
    }

    class MainPreferenceFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.preferences)

            bindPreferenceSummaryToValue(findPreference(getString(R.string.key_slide_actions)))

            bindPreferenceSummaryToValue(findPreference(getString(R.string.key_item_animator)))
            bindPreferenceSummaryToValue(findPreference(getString(R.string.key_item_decoration)))
            bindPreferenceSummaryToValue(findPreference(getString(R.string.key_layout_manager)))

        }

        fun bindPreferenceSummaryToValue(preference: Preference) {
            preference.onPreferenceChangeListener = sBindPreferenceSummaryToValueListener

            if (preference is ListPreference) {
                sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                        PreferenceManager
                                .getDefaultSharedPreferences(preference.context)
                                .getString(preference.key, ""))
            } else if (preference is CheckBoxPreference) {
                sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                        PreferenceManager
                                .getDefaultSharedPreferences(preference.context)
                                .getBoolean(preference.key, false))
            }
        }

        /**
         * A preference value change listener that updates the preference's summary
         * to reflect its new value.
         */
        private val sBindPreferenceSummaryToValueListener = Preference.OnPreferenceChangeListener { preference, newValue ->
            val stringValue = newValue.toString()

            if (preference is ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                val index = preference.findIndexOfValue(stringValue)

                // Set the summary to reflect the new value.
                preference.setSummary(
                        if (index >= 0)
                            preference.entries[index]
                        else
                            null)

            }
            true
        }

    }

}