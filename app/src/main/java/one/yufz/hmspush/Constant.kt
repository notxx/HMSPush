package one.yufz.hmspush

import android.app.AndroidAppHelper
import android.app.NotificationManager

private const val TAG = "Constant"

const val ANDROID_PACKAGE_NAME = "android"

const val HMS_PACKAGE_NAME = "com.huawei.hwid"
const val HMS_CORE_PROCESS = "com.huawei.hwid.core"
const val HMS_CORE_SERVICE = "com.huawei.hms.core.service.HMSCoreService"
const val HMS_CORE_SERVICE_ACTION = "com.huawei.hms.core.aidlservice"

const val HMS_CORE_DUMMY_SETTINGS_ACTIVITY = "com.huawei.hms.core.activity.JumpActivity"
const val FLAG_HMS_PUSH_SETTINGS = "hms_push_settings"

const val HMS_PUSH_BASE = "com.huawei.hms.push.apk"
const val HMS_PUSH_NC = "pushnc.apk"

const val IS_SYSTEM_HOOK_READY = "is_system_hook_ready"
const val READY = "ready"

const val HMS_CORE_SIGNATURE = "MIIEtTCCA52gAwIBAgIJAPIEVquWT6DwMA0GCSqGSIb3DQEBBQUAMIGYMQswCQYDVQQGEwJDTjESMBAGA1UECBMJR3Vhbmdkb25nMRIwEAYDVQQHEwlTaGVuZ3poZW4xDzANBgNVBAoTBkh1YXdlaTEYMBYGA1UECxMPVGVybWluYWxDb21wYW55MRQwEgYDVQQDEwtBbmRyb2lkVGVhbTEgMB4GCSqGSIb3DQEJARYRbW9iaWxlQGh1YXdlaS5jb20wHhcNMTEwNTI1MDYxMDQ5WhcNMzYwNTE4MDYxMDQ5WjCBmDELMAkGA1UEBhMCQ04xEjAQBgNVBAgTCUd1YW5nZG9uZzESMBAGA1UEBxMJU2hlbmd6aGVuMQ8wDQYDVQQKEwZIdWF3ZWkxGDAWBgNVBAsTD1Rlcm1pbmFsQ29tcGFueTEUMBIGA1UEAxMLQW5kcm9pZFRlYW0xIDAeBgkqhkiG9w0BCQEWEW1vYmlsZUBodWF3ZWkuY29tMIIBIDANBgkqhkiG9w0BAQEFAAOCAQ0AMIIBCAKCAQEA4CxauXorOopZliI83ga4Ky1P9bFcr2W4YNXHo9aJlasIYgu3WiL+dnOooaugPhe2UdH8TVy9uunnPu6vWh1NL7c+cAAjHg2yFm0Pxd2X5wX9ZlRsnaOO1O+izM3SOK0y45ghJCsBld8B2blyQtvyCe2o5EbgQyRLhOa/ynnXuzwZJM3SSO29YA7/j3MAGomkxmPbiXDjKIuUMVJMNh6FO4+ingTmHr5vvb2Hzb0+60ewJ7WFG96qE6I/Q5Z6Aw50fqQyZSy7NP3eYQSb9QYMgT+w6T9rrZ029NRVEZXqO7SekgGqbfl1rhaeIUkF3iV518w8PqxFlLFKwZ1+OcXCZwIBA6OCAQAwgf0wHQYDVR0OBBYEFD7GkN6BG8OeUaMDAa0jzzAG1n3gMIHNBgNVHSMEgcUwgcKAFD7GkN6BG8OeUaMDAa0jzzAG1n3goYGepIGbMIGYMQswCQYDVQQGEwJDTjESMBAGA1UECBMJR3Vhbmdkb25nMRIwEAYDVQQHEwlTaGVuZ3poZW4xDzANBgNVBAoTBkh1YXdlaTEYMBYGA1UECxMPVGVybWluYWxDb21wYW55MRQwEgYDVQQDEwtBbmRyb2lkVGVhbTEgMB4GCSqGSIb3DQEJARYRbW9iaWxlQGh1YXdlaS5jb22CCQDyBFarlk+g8DAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBQUAA4IBAQBtrS/FkM8AeaxM4IZaiEMR3BatgydaKwMCQFd23R0fcEopmTyKE0qN/dVMWRUaBhVWEtvTAGRurPyfZPrC41JwmwNZ91avlsH1ZJUwTnIoe+R5igQzNWy8zdjVfN4ff/HABMuWKtWVsdoi7yBN4USQiGG7qWjgx0OB4RnHcrLPIsPQyDJanzHJeHsVbJR3GvZvT/sa2ZbD++dk87xQt6JkPCM3JhLyUJlGoDut+/6mH449KJIzhbvACHWs7Jm22SrEaPDcUMCZf/QJ46JdyNlmwg1YipcT/yF+LeSUV6Ms8j3xr1j0vN2UqPJrwckMWlGD22TUY1PdRhBHjHfyyJmI"

val isSystemHookReady: Boolean by lazy {
    try {
        val nm = AndroidAppHelper.currentApplication().getSystemService(NotificationManager::class.java)
        nm.callMethod("isSystemConditionProviderEnabled", IS_SYSTEM_HOOK_READY) as Boolean
    } catch (t: Throwable) {
        XLog.e(TAG, "isSystemHookReady error", t)
        false
    }
}
