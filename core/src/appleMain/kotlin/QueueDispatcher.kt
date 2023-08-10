package com.juul.kable

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_queue_create
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal class QueueDispatcher(
    label: String,
) : CoroutineDispatcher() {

    val dispatchQueue: dispatch_queue_t = dispatch_queue_create(label, attr = null)

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}
