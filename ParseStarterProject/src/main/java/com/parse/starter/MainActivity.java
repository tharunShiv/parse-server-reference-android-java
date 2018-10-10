/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    // make a new class ( like a table in Sql ) ( or like a Document )
      // classes should begin with capitals
//      ParseObject score = new ParseObject("Score");
////      score.put("username", "nick");
////      score.put("score", 45);
//
//        score.put("username", "shawn");
//        score.put("score", 54);
//
//      // now take this and save it to Parse
//      // select the save in background
//      score.saveInBackground(new SaveCallback() {
//          @Override
//          public void done(ParseException e) {
//              if (e == null) {
//                  // everything is okay
//                  Log.i("Success", "We Saved teh score");
//              } else {
//                  e.printStackTrace();
//              }
//          }
//      });

/*
    // get things from the Parse server
      ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
      // XA6Le5CE6J is the object ID, get it from teh dashboard
      query.getInBackground("XA6Le5CE6J", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {
              if (e == null && object != null) {
                  // good
                  // object.get("username");  // not the best
                  Log.i("username", object.getString("username"));
                  Log.i("score", Integer.toString(object.getInt("score")));

                  // updating the value of an object
                  object.put("score", 85);
                  // this time maybe without callback
                  object.saveInBackground();

                  Log.i("username", object.getString("username"));
                  Log.i("score", Integer.toString(object.getInt("score")));

              }
          }
      });
*/


    // TODO: Exercise, just for practice
    // creating a tweet class
    /*ParseObject tweet = new ParseObject("Tweet");
    tweet.put("username", "tharunShiv");
    tweet.put("tweet", "Subscribe to my YouTube channel");

    tweet.saveInBackground(new SaveCallback() {
        @Override
        public void done(ParseException e) {
            if(e == null) {
                // good
                Log.i("Hooli", "Data saved");
            } else {
                e.printStackTrace();
            }
        }
    });

    ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
    query.getInBackground("XNaNQmLaD4", new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject object, ParseException e) {
            if (e == null ) {
                // no error
                // good
                Log.i("Hooli", "Return 1: "+object.getString("username"));
                Log.i("Hooli", "Return 1: "+object.getString("tweet"));

                //updating
                object.put("username", "TharunShiv");
                object.put("tweet", "Subscribe to my Youtube channel and Follow me on IG");

                object.saveInBackground();

                Log.i("Hooli", "Return 2: "+object.getString("username"));
                Log.i("Hooli", "Return 2: "+object.getString("tweet"));

            }
        }
    });
   */

    /*
    // TOPIC: Advanced Queries
      ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
      // we were using IDS
      // but now we're gonna grab everything

      // where clause
      // there are many methods
      query.whereEqualTo("username", "shawn");

      //optional
      query.setLimit(1);

      query.findInBackground(new FindCallback<ParseObject>() {
          @Override
          public void done(List<ParseObject> objects, ParseException e) {
              if (e == null) {
                  // we're getting a list of ParseObjects
                  // good

                  if (objects.size() > 0) {
                      // one or more objects exist
                      for (ParseObject object : objects ) {
                          Log.i("Hooli", "username : " + object.getString("username"));
                          Log.i("Hooli", "score : " + Integer.toString(object.getInt("score")));
                      }
                  }
              }
          }
      });  */

    // TODO: conditional
      /*
      ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

      query.whereGreaterThan("score", 50);

      query.findInBackground(new FindCallback<ParseObject>() {
          @Override
          public void done(List<ParseObject> objects, ParseException e) {
              if (e == null && objects.size() > 0) {
                  for ( ParseObject object : objects ) {
                      object.put("score", object.getInt("score") + 20);
                      object.saveInBackground();
                  }
              }
          }
      }); */


      // TODO:  Parse User


      ParseUser user = new ParseUser();

      user.setUsername("nick");
      user.setPassword("myPass");

      // with callback
      user.signUpInBackground(new SignUpCallback() {
          @Override
          public void done(ParseException e) {
              if (e == null ) {
                  // Good
                  Log.i("Hooli", "SignUp DOne");
              } else {
                  e.printStackTrace();
              }
          }
      });

      // TODO: login code

      ParseUser.logInInBackground("nick", "myPass", new LogInCallback() {
          @Override
          public void done(ParseUser user, ParseException e) {
              if (user!=null) {
                  Log.i("Success", "We logged in");
              } else  {
                  e.printStackTrace();
              }
          }
      });


      // TODO: logout
      ParseUser.logOut();


      // TODO: check if someone is already logged in
      if (ParseUser.getCurrentUser() != null ){
          Log.i("Signed In", ParseUser.getCurrentUser().getUsername());
      } else {
          Log.i("not luck", "not signed in");
      }


    // allow us to do some checks to see how much the
    // user is using our app
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}