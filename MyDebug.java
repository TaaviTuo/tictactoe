package fi.tamk.miliho.tictactoe;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by miliho on 14.1.2018.
 */

public class MyDebug extends MyBaseActivity {

    private static int debug_level = 0;
    private static Context context;

    public static void print(String className, String methodName, String msg, int lvl) {

        boolean toastMessage = false;

        if(BuildConfig.DEBUG && lvl <= debug_level && debug_level > 0 && !toastMessage){

            Log.d(className, msg);
        } else if (BuildConfig.DEBUG && lvl <= debug_level && debug_level > 0 && toastMessage) {

            CharSequence text = className + " " + msg;
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {

        }
    }


    public static void loadDebug(Context host, Context contextToast) {

        context = contextToast;

        try {
            debug_level = host.getResources().getInteger(R.integer.DEBUG_LEVEL);
        } catch (Exception e) {

            Log.d("MyDebugError", "No int found in .xml file");
        }
    }
}
