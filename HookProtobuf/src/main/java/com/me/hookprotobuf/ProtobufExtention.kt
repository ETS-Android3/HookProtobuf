package com.me.hookprotobuf

import com.ss.android.ugc.bytex.common.BaseExtension

open class ProtobufExtention : BaseExtension() {


    override fun getName(): String {
        return "HookProtobuf"
    }

    override fun enableInDebug(enable: Boolean) {
        super.enableInDebug(enable)
    }
}
