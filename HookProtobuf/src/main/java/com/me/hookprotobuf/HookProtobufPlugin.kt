package com.me.hookprotobuf

import com.android.build.gradle.AppExtension
import com.ss.android.ugc.bytex.common.CommonPlugin
import com.ss.android.ugc.bytex.common.visitor.ClassVisitorChain
import com.ss.android.ugc.bytex.pluginconfig.anno.PluginConfig
import org.gradle.api.Project

@PluginConfig("bytex.HookProtobuf")
open class HookProtobufPlugin : CommonPlugin<ProtobufExtention, ProtobufContext>() {
    override fun getContext(project: Project, android: AppExtension, extension: ProtobufExtention): ProtobufContext {
        extension.enableInDebug(true)
        return ProtobufContext(project, android, extension)
    }

    override fun transform(relativePath: String, chain: ClassVisitorChain): Boolean {
        if (relativePath.contains("CodedInputStream")) {
            context.logger.i("find it TestAsm.class")
            chain.connect(ClassVisitor())
        } else if (relativePath.contains("TestAsm")) {
            context.logger.i("find it TestAsm.class")
            chain.connect(TestClassVisitor())
        }
        return super.transform(relativePath, chain)
    }

}