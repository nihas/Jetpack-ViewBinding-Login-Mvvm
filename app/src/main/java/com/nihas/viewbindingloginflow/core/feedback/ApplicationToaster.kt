/* Copyright 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.*/

package com.nihas.viewbindingloginflow.core.feedback

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

open class ApplicationToaster(val context: Context) : Toaster {

    private var toast: Toast? = null

    override fun show(title: String, duration: Int) {
        showInternal(title, duration)
    }

    override fun show(@StringRes titleRes: Int, duration: Int) {
        showInternal(context.getString(titleRes), duration)
    }

    private fun showInternal(title: String, duration: Int) {
        toast?.cancel()
        toast = null
        toast = Toast.makeText(context, title, if (duration != Toast.LENGTH_LONG || duration != Toast.LENGTH_SHORT) duration else Toast.LENGTH_SHORT)
                .apply { show() }
    }
}


interface Toaster {

    fun show(title: String, duration: Int = Toast.LENGTH_LONG)
    fun show(@StringRes titleRes: Int, duration: Int = Toast.LENGTH_LONG)

}