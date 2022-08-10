package one.yufz.hmspush.fakedevice

import android.content.pm.PackageInfo
import android.util.Base64
import de.robv.android.xposed.callbacks.XC_LoadPackage
import one.yufz.hmspush.HMS_CORE_SIGNATURE
import one.yufz.hmspush.HMS_PACKAGE_NAME
import one.yufz.hmspush.findClass
import one.yufz.hmspush.hookMethod
import one.yufz.hmspush.isSystemHookReady
import one.yufz.hmspush.set

object FakeHmsSignature {
    fun hook(lpparam: XC_LoadPackage.LoadPackageParam) {
        val classApplicationPackageManager = lpparam.classLoader.findClass("android.app.ApplicationPackageManager")
        classApplicationPackageManager.hookMethod("getPackageInfo", String::class.java, Int::class.java) {
            doAfter {
                if (!isSystemHookReady) {
                    val packageName = args[0] as String
                    if (packageName == HMS_PACKAGE_NAME) {
                        val info = result as PackageInfo
                        info.signatures?.firstOrNull()?.let {
                            info.signatures[0]["mSignature"] = Base64.decode(HMS_CORE_SIGNATURE, Base64.NO_WRAP)
                        }
                    }
                }
            }
        }
    }
}