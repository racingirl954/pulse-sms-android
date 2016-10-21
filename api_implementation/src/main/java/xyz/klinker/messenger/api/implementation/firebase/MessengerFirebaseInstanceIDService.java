/*
 * Copyright (C) 2016 Jacob Klinker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.klinker.messenger.api.implementation.firebase;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

import xyz.klinker.messenger.api.implementation.Account;
import xyz.klinker.messenger.api.implementation.ApiUtils;

public class MessengerFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        Account account = Account.get(this);
        String deviceId = Account.get(this).deviceId;

        try {
            Integer.parseInt(deviceId);
        } catch (Exception e) {
            account.setDeviceId(null);
            deviceId = null;
        }

        if (deviceId != null) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            String accountId = account.accountId;

            new ApiUtils().updateDevice(accountId, Integer.parseInt(deviceId),
                    null, refreshedToken);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("feature_flag");
    }

}