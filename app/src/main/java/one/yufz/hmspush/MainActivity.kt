package one.yufz.hmspush

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView

class MainActivity : Activity() {
    companion object {
        private const val REQUEST_LAUNCH_SETTINGS = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeActivityFullscreen(this)

        val intent = Intent().apply {
            setClassName(HMS_PACKAGE_NAME, HMS_CORE_DUMMY_SETTINGS_ACTIVITY)
            putExtra(FLAG_HMS_PUSH_SETTINGS, true)
        }
        try {
            startActivityForResult(intent, REQUEST_LAUNCH_SETTINGS)
        } catch (e: ActivityNotFoundException) {
            inflateTips("HMS Core 未安装或没有权限访问")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_LAUNCH_SETTINGS) {
            if (resultCode == RESULT_OK) {
                window.setWindowAnimations(0)
                finish()
            } else {
                inflateTips("请检查是否已勾选 HMS Core 作用域，并重启 HMS Core")
            }
        }
    }

    private fun makeActivityFullscreen(activity: Activity) {
        activity.window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
            decorView.systemUiVisibility = decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun inflateTips(tips: CharSequence?) {
        setContentView(R.layout.tips)
        findViewById<TextView>(R.id.tips).text = tips
    }
}