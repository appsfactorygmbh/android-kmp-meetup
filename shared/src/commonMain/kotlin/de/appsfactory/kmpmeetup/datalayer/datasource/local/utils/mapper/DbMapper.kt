package de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.mapper

import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.model.DbUserName
import de.appsfactory.kmpmeetup.domainlayer.model.UserName

fun UserName.toDbData() = DbUserName(text = text)

fun DbUserName.toEntity() = UserName(text = text)
