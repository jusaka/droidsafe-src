package droidsafe.eclipse.plugin.core.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import droidsafe.eclipse.plugin.core.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
   * initializeDefaultPreferences()
   */
  public void initializeDefaultPreferences() {
    IPreferenceStore store = Activator.getDefault().getPreferenceStore();

    store.setDefault(PreferenceConstants.P_TARGET_PASS, "specdump");
    store.setDefault(PreferenceConstants.P_NOSOURCE_INFO, false);
    store.setDefault(PreferenceConstants.P_INFOFLOW, false);
    store.setDefault(PreferenceConstants.P_JIMPLE, false);
    store.setDefault(PreferenceConstants.P_ANALYZEAPI, false);
    store.setDefault(PreferenceConstants.P_DEBUGLOG, false);
    store.setDefault(PreferenceConstants.P_DUMP_PTA, false);
    store.setDefault(PreferenceConstants.P_DUMP_CALL_GRAPH, false);
    store.setDefault(PreferenceConstants.P_RUN_STRING_ANALYSIS, true);
    store.setDefault(PreferenceConstants.P_UNFILTERED_STRING_ANALYSIS, false);
    // store.setDefault(PreferenceConstants.P_ADD_ALL_METHODS_TO_STRING_ANALYSIS, false);

    // prefs = ConfigurationScope.INSTANCE.getNode(Activator.PLUGIN_ID);
    // prefs.put(PreferenceConstants.P_TARGET_PASS, "specdump");
    // prefs.putBoolean(PreferenceConstants.P_NOSOURCE_INFO, true);
    // prefs.putBoolean(PreferenceConstants.P_INFOFLOW, true);
    // prefs.putBoolean(PreferenceConstants.P_JIMPLE, true);
    // prefs.putBoolean(PreferenceConstants.P_ANALYZEAPI, true);
    // prefs.putBoolean(PreferenceConstants.P_DEBUGLOG, true);
    // prefs.putBoolean(PreferenceConstants.P_DUMP_PTA, true);
    // prefs.putBoolean(PreferenceConstants.P_DUMP_CALL_GRAPH, true);
    //
    // try {
    // prefs.flush();
    // } catch (BackingStoreException e) {
    // e.printStackTrace();
    // }

  }

}