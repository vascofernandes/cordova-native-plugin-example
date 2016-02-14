
package org.apache.cordova.myplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;


public class MyPlugin extends CordovaPlugin {

	private static final String LOG_TAG = "MyPlugin";


    public static final String ACTION_ADD_MY_DEAL = "myDeal"; 
    public static final String ACTION_ADD_TOAST = "toast"; 

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        try {
            if (ACTION_ADD_MY_DEAL.equals(action)) {
                callbackContext.success(myDeal());
                return true;
            }
            
            if (ACTION_ADD_TOAST.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);

                showToast(arg_object.getString("toast"));
                
                callbackContext.success();
                return true;
            }
            
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
    
    public void showToast(String toast) {
		LOG.d(LOG_TAG, toast);
        // final String toastMsg = toast;

         // cordova.getActivity().runOnUiThread(new Runnable() {
            // @Override
            // public void run() {
                // Context context = cordova.getActivity().getApplicationContext();

                // Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show();
            // }
        // });
		
		Context context = cordova.getActivity().getApplicationContext();

		Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }

    public String myDeal() {
        return "My own deal";
    }

}
