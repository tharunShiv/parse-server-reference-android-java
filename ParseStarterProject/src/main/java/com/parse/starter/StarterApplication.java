/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

// help us connect to parse
public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Log.i("Parse Result", "reached11!");
    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);


    // get these when you deploy Parse
      // fill these at the gradle.properties
    String apiKey = BuildConfig.ApiKey;
    String clientKey = BuildConfig.ClientKey;
    String server = BuildConfig.Server;
    // Add your initialization code here
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId(apiKey)
            .clientKey(clientKey)
            .server(server)
            .build()
    );// add a '/' to the end

//    ParseObject object = new ParseObject("ExampleObject");
//    object.put("myNumber", "123");
//    object.put("myString", "rob");
//    Log.i("Parse Result", "reached!");
//    object.saveInBackground(new SaveCallback () {
//      @Override
//      public void done(ParseException ex) {
//        if (ex == null) {
//          Log.i("Parse Result", "Successful!");
//        } else {
//          Log.i("Parse Result", "Failed" + ex.toString());
//        }
//      }
//    });


    // Advanced Parse


    // make a new object and make it store


    // this enables anonymouus user usage without password/email
    // so uncomment it if you need no authentication
    // ParseUser.enableAutomaticUser();

    ParseACL defaultACL = new ParseACL();
    defaultACL.setPublicReadAccess(true);
    defaultACL.setPublicWriteAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

  }
}
