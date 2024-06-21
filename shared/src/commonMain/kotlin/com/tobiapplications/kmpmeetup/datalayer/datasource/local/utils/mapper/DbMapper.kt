package com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.mapper

import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.model.DbName
import com.tobiapplications.kmpmeetup.domainlayer.model.Name

fun Name.toDbData() = DbName(text = text)

fun DbName.toEntity() = Name(text = text)
