package com.me.hookprotobuf

import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*


class ClassVisitor : BaseClassVisitor() {

    override fun visitMethod(access: Int, name: String?, descriptor: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        if (name == "readRawVarint64") {
            newMethod(methodVisitor)
            return null
        }
        return methodVisitor
    }

    override fun visitField(access: Int, name: String?, descriptor: String?, signature: String?, value: Any?): FieldVisitor {
        return super.visitField(access, name, descriptor, signature, value)
    }

    fun newMethod(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        methodVisitor.visitInsn(LCONST_0)
        methodVisitor.visitVarInsn(LSTORE, 1)
        methodVisitor.visitInsn(ICONST_0)
        methodVisitor.visitVarInsn(ISTORE, 3)
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitVarInsn(ILOAD, 3)
        methodVisitor.visitIntInsn(BIPUSH, 64)
        val label1 = Label()
        methodVisitor.visitJumpInsn(IF_ICMPGE, label1)
        methodVisitor.visitVarInsn(ALOAD, 0)
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/google/protobuf/CodedInputStream", "readRawByte", "()B", false)
        methodVisitor.visitVarInsn(ISTORE, 4)
        methodVisitor.visitVarInsn(LLOAD, 1)
        methodVisitor.visitVarInsn(ILOAD, 4)
        methodVisitor.visitIntInsn(BIPUSH, 127)
        methodVisitor.visitInsn(IAND)
        methodVisitor.visitInsn(I2L)
        methodVisitor.visitVarInsn(ILOAD, 3)
        methodVisitor.visitInsn(LSHL)
        methodVisitor.visitInsn(LOR)
        methodVisitor.visitVarInsn(LSTORE, 1)
        methodVisitor.visitVarInsn(ILOAD, 4)
        methodVisitor.visitIntInsn(SIPUSH, 128)
        methodVisitor.visitInsn(IAND)
        val label2 = Label()
        methodVisitor.visitJumpInsn(IFNE, label2)
        methodVisitor.visitVarInsn(LLOAD, 1)
        methodVisitor.visitInsn(LRETURN)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitIincInsn(3, 7)
        methodVisitor.visitJumpInsn(GOTO, label0)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitMethodInsn(INVOKESTATIC, "com/google/protobuf/InvalidProtocolBufferException", "malformedVarint", "()Lcom/google/protobuf/InvalidProtocolBufferException;", false)
        methodVisitor.visitInsn(ATHROW)
        methodVisitor.visitMaxs(5, 5)
        methodVisitor.visitEnd()
    }
}