package com.me.hookprotobuf

import com.android.build.gradle.AppExtension
import com.ss.android.ugc.bytex.common.BaseContext
import org.gradle.api.Project

open class ProtobufContext(project: Project, android: AppExtension, extension: ProtobufExtention) :
        BaseContext<ProtobufExtention>(project, android, extension) {
}