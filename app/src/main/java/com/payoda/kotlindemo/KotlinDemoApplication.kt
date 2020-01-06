package com.payoda.kotlindemo

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware

class KotlinDemoApplication : Application(), KodeinAware {
    override val kodein: Kodein
        get() = TODO("not implemented")
    //To change initializer of created properties use File | Settings | File Templates.

}