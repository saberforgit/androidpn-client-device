/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zs.devicemanager.notify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.androidpn.connection.LogUtil;
import com.zs.devicemanager.model.Constants;

/** 
 * Broadcast receiver that handles push notification messages from the server.
 * This should be registered as receiver in AndroidManifest.xml. 
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public final class NotificationReceiver extends BroadcastReceiver {

    private static final String LOGTAG = LogUtil
            .makeLogTag(NotificationReceiver.class);

    //    private NotificationService notificationService;

    public NotificationReceiver() {
    }

    //    public NotificationReceiver(NotificationService notificationService) {
    //        this.notificationService = notificationService;
    //    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(LOGTAG, "NotificationReceiver.onReceive()...");
        String action = intent.getAction();
        Log.d(LOGTAG, "action=" + action);

        if (Constants.ACTION_SHOW_NOTIFICATION.equals(action)) {
            String notificationId = intent
                    .getStringExtra(Constants.NOTIFICATION_ID);
            String notificationApiKey = intent
                    .getStringExtra(Constants.NOTIFICATION_API_KEY);
            String notificationTitle = intent
                    .getStringExtra(Constants.NOTIFICATION_TITLE);
            String notificationMessage = intent
                    .getStringExtra(Constants.NOTIFICATION_MESSAGE);
            String notificationUri = intent
                    .getStringExtra(Constants.NOTIFICATION_URI);
            String notificationCreateTime = intent
                    .getStringExtra(Constants.NOTIFICATION_CREATE_TIME);


            Log.i(LOGTAG, "notificationId=" + notificationId);
            Log.i(LOGTAG, "notificationApiKey=" + notificationApiKey);
            Log.i(LOGTAG, "notificationTitle=" + notificationTitle);
            Log.i(LOGTAG, "notificationMessage=" + notificationMessage);
             Log.i(LOGTAG, "notificationUri=" + notificationUri);
            Log.i(LOGTAG, "notificationCreateTime=" + notificationCreateTime);



            Notifier notifier = new Notifier(context);
            notifier.notify(notificationId, notificationApiKey,
                        notificationTitle, notificationMessage, notificationUri,notificationCreateTime);

            //TODO
            if(notificationId.equals(Constants.sampleMesage)){

            }else if(notificationId.equals(Constants.passwordMessage)){
                Intent intent_notify_top = new Intent(context,NotifyDeskTopActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("notificationTitle",notificationTitle);
                bundle.putString("notificationMessage",notificationMessage);
                bundle.putString("notificationUri",notificationUri);
                bundle.putString("notificationCreateTime",notificationCreateTime);
                intent_notify_top.putExtras(bundle);
                intent_notify_top.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent_notify_top);
            }



        }

        //        } else if (Constants.ACTION_NOTIFICATION_CLICKED.equals(action)) {
        //            String notificationId = intent
        //                    .getStringExtra(Constants.NOTIFICATION_ID);
        //            String notificationApiKey = intent
        //                    .getStringExtra(Constants.NOTIFICATION_API_KEY);
        //            String notificationTitle = intent
        //                    .getStringExtra(Constants.NOTIFICATION_TITLE);
        //            String notificationMessage = intent
        //                    .getStringExtra(Constants.NOTIFICATION_MESSAGE);
        //            String notificationUri = intent
        //                    .getStringExtra(Constants.NOTIFICATION_URI);
        //
        //            Log.e(LOGTAG, "notificationId=" + notificationId);
        //            Log.e(LOGTAG, "notificationApiKey=" + notificationApiKey);
        //            Log.e(LOGTAG, "notificationTitle=" + notificationTitle);
        //            Log.e(LOGTAG, "notificationMessage=" + notificationMessage);
        //            Log.e(LOGTAG, "notificationUri=" + notificationUri);
        //
        //            Intent detailsIntent = new Intent();
        //            detailsIntent.setClass(context, NotificationDetailsActivity.class);
        //            detailsIntent.putExtras(intent.getExtras());
        //            //            detailsIntent.putExtra(Constants.NOTIFICATION_ID, notificationId);
        //            //            detailsIntent.putExtra(Constants.NOTIFICATION_API_KEY, notificationApiKey);
        //            //            detailsIntent.putExtra(Constants.NOTIFICATION_TITLE, notificationTitle);
        //            //            detailsIntent.putExtra(Constants.NOTIFICATION_MESSAGE, notificationMessage);
        //            //            detailsIntent.putExtra(Constants.NOTIFICATION_URI, notificationUri);
        //            detailsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //            detailsIntent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        //
        //            try {
        //                context.startActivity(detailsIntent);
        //            } catch (ActivityNotFoundException e) {
        //                Toast toast = Toast.makeText(context,
        //                        "No app found to handle this request",
        //                        Toast.LENGTH_LONG);
        //                toast.show();
        //            }
        //
        //        } else if (Constants.ACTION_NOTIFICATION_CLEARED.equals(action)) {
        //            //
        //        }

    }

}
