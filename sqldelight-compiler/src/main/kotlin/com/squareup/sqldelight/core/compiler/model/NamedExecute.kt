package com.squareup.sqldelight.core.compiler.model

import com.intellij.psi.PsiElement
import com.squareup.sqldelight.core.lang.psi.StmtIdentifierMixin
import com.squareup.sqldelight.core.lang.util.sqFile

open class NamedExecute(
        identifier: StmtIdentifierMixin,
        statement: PsiElement
) : BindableQuery(identifier, statement) {
    val name = identifier.name!!

    override val id: Int
        //the sqlFile packagename -> com.example.
        //sqlFile.name -> test.sq
        // name -> query name
        get() = statement.sqFile().let { "${it.packageName}:${it.name}:${name}".hashCode() }
}