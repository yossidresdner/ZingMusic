package app.zingmusic.browser;

import android.app.Activity;
import android.os.Bundle;
import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends Activity {

    private GeckoRuntime runtime;
    private GeckoSession session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GeckoView view = new GeckoView(this);
        setContentView(view);

        runtime = GeckoRuntime.create(this);
        session = new GeckoSession();
        session.open(runtime);

        view.setSession(session);
        session.loadUri("https://zingmusic.app/");
    }

    @Override
    protected void onDestroy() {
        if (session != null) {
            session.close();
        }
        super.onDestroy();
    }
}
