package com.multunus.onemdm.gcm;


import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.multunus.onemdm.config.Config;
import com.multunus.onemdm.network.DeviceRegistration;
import com.multunus.onemdm.service.RegistrationService;
import com.multunus.onemdm.util.Logger;

public class GCMInstanceIDListenerService extends InstanceIDListenerService {
    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. This call is initiated by the
     * InstanceID provider.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Fetch updated Instance ID token and notify our app's server of any changes (if applicable).
        Intent intent = new Intent(this, RegistrationService.class);
        startService(intent);

    }
    // [END refresh_token]
}