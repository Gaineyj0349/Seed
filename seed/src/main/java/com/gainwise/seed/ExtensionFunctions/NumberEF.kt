package com.gainwise.seed.ExtensionFunctions

import java.text.DateFormat

fun Long.getLocaleDateString() = DateFormat.getDateTimeInstance().format(this);