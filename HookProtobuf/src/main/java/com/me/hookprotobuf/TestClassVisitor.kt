package com.me.hookprotobuf

import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.ARETURN

class TestClassVisitor : BaseClassVisitor() {

    override fun visitMethod(access: Int, name: String?, descriptor: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)

        if (name == "test") {
            methodVisitor.visitCode();
            methodVisitor.visitLdcInsn("uuuuu")
            methodVisitor.visitInsn(ARETURN);
            methodVisitor.visitMaxs(1, 1)
            methodVisitor.visitEnd()
            return null
        }
        return methodVisitor;
    }
}