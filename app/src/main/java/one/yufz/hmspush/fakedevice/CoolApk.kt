package one.yufz.hmspush.fakedevice

import android.app.Application
import de.robv.android.xposed.callbacks.XC_LoadPackage
import one.yufz.hmspush.hookMethod
import one.yufz.hmspush.isSystemHookReady


class CoolApk : XGPush() {
    override fun fake(lpparam: XC_LoadPackage.LoadPackageParam): Boolean {
        Application::class.java.hookMethod("onCreate") {
            doAfter {
                super.fake(lpparam)
                if (!isSystemHookReady) {
                    FakeHmsSignature.hook(lpparam)
                }
            }
        }
        return true
    }
}